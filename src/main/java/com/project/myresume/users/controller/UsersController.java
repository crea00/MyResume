package com.project.myresume.users.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


import java.util.Iterator;

import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.api.plus.Person;
import org.springframework.social.google.api.plus.PlusOperations;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.project.myresume.profile.service.AcService;
import com.project.myresume.profile.service.EduService;
import com.project.myresume.profile.service.ExpsService;
import com.project.myresume.profile.service.IntsService;

import com.project.myresume.profile.service.SkillsService;
import com.project.myresume.search.dto.SearchDto;
import com.project.myresume.search.service.SearchService;
import com.project.myresume.users.dto.UsersDto;
import com.project.myresume.users.service.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@Autowired
	private ExpsService expsService;

	@Autowired
	private SkillsService skillsService;
	
	@Autowired
	private EduService eduService;
	
	@Autowired
	private AcService acService;
	
	@Autowired
	private IntsService intsService;
	
	@Autowired
	private SearchService searchService;
	

	/* GoogleLogin */
	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;
	@Autowired
	private OAuth2Parameters googleOAuth2Parameters;

	
	// 로그인 폼 요청처리
	@RequestMapping(value = "/users/loginform", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView loginform(ModelAndView mv, HttpServletRequest request) {
		
		
		/* 구글code 발행 */
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		String google_url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
		
		mv.addObject("google_url", google_url);
		
		// url이라는 파라미터로 전달된 문자열 읽어오기
		String url = request.getParameter("url");
		System.out.println(url);
		if (url == null) {
			// url이 null이면 root 요청
			url = request.getContextPath() + "/";
		}
		// 로그인 후 이동할 url정보를 ModelAndView객체에 담는다.
		mv.addObject("url", url);
		// view페이지 정보를 담고
		mv.setViewName("users/loginform");	
		
		System.out.println(google_url);
		return mv;
	}
	
	// 구글 Callback호출 메소드
	@RequestMapping(value = "/users/oauth2callback", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView googleCallback(ModelAndView mv, @RequestParam Map<String, String> param, HttpServletRequest request) throws IOException {
		System.out.println("여기는 googleCallback");
		String code=param.get("code");
		String error=param.get("error");
		if(error.equals("access_denied")) {
			mv.setViewName("redirect:/users/loginform.do");
			return mv;
		}
		System.out.println(param.get("error"));
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		AccessGrant accessGrant = oauthOperations.exchangeForAccess(code, googleOAuth2Parameters.getRedirectUri(), null);
		String accessToken = accessGrant.getAccessToken();
		
		Connection<Google>connection = googleConnectionFactory.createConnection(accessGrant);
		Google google = connection == null ? new GoogleTemplate(accessToken) : connection.getApi();
		
		PlusOperations plusOperations = google.plusOperations();
		Person person = plusOperations.getGoogleProfile();
		
		String id=person.getId();
		String name=person.getDisplayName();
		String email = person.getAccountEmail();

		System.out.println(id);
		System.out.println("이름은"+name);
		System.out.println(email);

		if(usersService.canUseId(id)) {//계정에 아이디 없으면 회원가입
			UsersDto dto = new UsersDto();
			dto.setName(name);
			dto.setId(id);
			dto.setEmail(email);
			usersService.socialSignup(dto);
			
		}
		
		
		request.getSession().setAttribute("id", id);
		
		mv.setViewName("redirect:/home.do");
		return mv;
	}
	
	
	

	// 로그인 요청처리
	@RequestMapping("/users/login")
	public ModelAndView login(@ModelAttribute UsersDto dto, HttpServletRequest request, HttpSession session){
		ModelAndView mv = usersService.login(dto, request);
		mv.setViewName("users/login_result");	
		return mv;		

	}
	
	// 로그아웃 요청 처리
	@RequestMapping("/users/logout")
	public ModelAndView logout(HttpSession session, ModelAndView mv){
		String id = (String)session.getAttribute("id");
		// 세션초기화
		session.invalidate();
		
		mv.addObject("msg", id + "님 로그아웃되었습니다.");
		mv.setViewName("users/logout_result");
		return mv;
	}
	
	
	// 회원가입 폼 요청 처리
	@RequestMapping("/users/signup_form")
	public String signup_form() {

		return "users/signup_form";
	}

	// 회원가입 요청 처리
	@RequestMapping("/users/signup")
	public ModelAndView signup(@ModelAttribute UsersDto dto) {
		// 전달되는 인자에 회원가입 정보가 들어있다.
		ModelAndView mv = usersService.signup(dto);
		// 홈으로 이동
		mv.setViewName("users/signup_result");
		return mv;
	}

	
	// 회원정보 갖고오기
	@RequestMapping("/users/info")
	public ModelAndView getData(HttpServletRequest request) {
		String id=(String)request.getSession().getAttribute("id");
		ModelAndView mView= new ModelAndView();
		UsersDto dto =usersService.getData(id);
		mView.addObject("myDto", dto);
		mView.setViewName("users/info");
		return mView;
		
	}

	// 회원탈퇴
	@RequestMapping("/users/delete")
	public ModelAndView authDelete(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		skillsService.deleteAll(id);
		eduService.deleteAll(id);
		expsService.deleteAll(id);
		acService.deleteAll(id);
		intsService.deleteAll(id);
		// service를 이용해서 탈퇴처리
		ModelAndView mv = usersService.delete(session);
		mv.setViewName("users/delete_result");
		return mv;
	}

	// 아이디 중복 확인 요청 처리
	@RequestMapping("/users/checkid")
	@ResponseBody
	public Map<String, Object> checkid(@RequestParam String inputId) {
		// service를 이용해서 사용가능여부를 boolean type으로 리턴받기
		boolean canUse = usersService.canUseId(inputId);
		System.out.println("canUse는" + canUse);
		// Map에 담고 리턴
		Map<String, Object> map = new HashMap<>();
		map.put("canUse", canUse);
		return map;
	}
	
	// email 중복 확인 요청 처리
	@RequestMapping("/users/checkemail")
	@ResponseBody
	public Map<String, Object> checkemail(@RequestParam String inputEmail) {
		// service를 이용해서 사용가능여부를 boolean type으로 리턴받기
		boolean canUse = usersService.canUseEmail(inputEmail);
		System.out.println("canUse는" + canUse);
		// Map에 담고 리턴
		Map<String, Object> map = new HashMap<>();
		map.put("canUse", canUse);
		return map;
	}

	// 회원정보 수정페이지 이동
	@RequestMapping("/users/updateform")
	public ModelAndView authUpdateForm(HttpServletRequest request){
		HttpSession session = request.getSession();
		
		//  service객체를 이용해서 사용자 정보가 담긴 ModelAndView객체 얻어오기
		ModelAndView mv = new ModelAndView();
		mv.setViewName("users/updateform");
		return mv;
	}
	
	// 회원정보 수정
	@RequestMapping("users/update")
	public String authUpdate(@ModelAttribute UsersDto dto, HttpServletRequest request){

		// service객체를 이용해서 수정
		usersService.update(dto);
		return "redirect:/profile/detail.do";
		
	}
	
	@RequestMapping("/search2")
	public ModelAndView search2(@RequestParam Map<String, String> params) {
		ModelAndView mView = new ModelAndView();
		List<UsersDto> searchDto = new ArrayList<>();
		//셋중에 하나만 가능--all/skill/edu
		String sp = params.get("search_param");
		//무조건 존재--expAll/new/old
		String exp = params.get("exp");
		//keyword
		String keyword = params.get("keyword");
		List<String> oldList =expsService.oldSearch();//경력자 아이디 리스트
		List<String> newList =expsService.newSearch();//신입 아이디 리스트
		List<String> idList = new ArrayList<>();
		
		if(sp.equals("all")) {
			idList =usersService.search(keyword);
			if(exp.equals("all")) {
				//전체검색
			}else if(exp.equals("new")) {
				//신입검색
				for(Iterator<String> it = idList.iterator() ; it.hasNext() ; ){
					String value = it.next();
					for(String str : oldList) {						
						if(value.equals(str)){
							it.remove();
						}
						
					}
				}
			}else if(exp.equals("old")) {
				//경력검색
				for(Iterator<String> it = idList.iterator(); it.hasNext() ; ){
					String value = it.next();
					for(String str : newList) {						
						if(value.equals(str)){
							it.remove();
						}
						
					}
				}
				
			}
		}else if(sp.equals("skill")) {//skill에서 검색
			idList =skillsService.search(keyword);
			if(exp.equals("all")) {
				//전체검색
			}else if(exp.equals("new")) {
				//신입검색
				for(Iterator<String> it = idList.iterator(); it.hasNext(); ){
					String value = it.next();
					for(String str : oldList) {						
						if(value.equals(str)){
							it.remove();
						}
						
					}
				}
			}else if(exp.equals("old")) {
				//경력검색
				for(Iterator<String> it = idList.iterator(); it.hasNext(); ){
					String value = it.next();
					for(String str : newList) {						
						if(value.equals(str)){
							it.remove();
						}
						
					}
				}
				
			}
			

		}else if(sp.equals("edu")) {//검색어가 edu단이면
			idList =eduService.search(keyword);
			if(exp.equals("all")) {
				//전체검색
			}else if(exp.equals("new")) {
				//신입검색
				for(Iterator<String> it = idList.iterator(); it.hasNext(); ){
					String value = it.next();
					for(String str : oldList) {						
						if(value.equals(str)){
							it.remove();
						}
						
					}
				}
			}else if(exp.equals("old")) {
				//경력검색
				for(Iterator<String> it = idList.iterator(); it.hasNext(); ){
					String value = it.next();
					for(String str : newList) {						
						if(value.equals(str)){
							it.remove();
						}
						
					}
				}
				
			}
			
		}
		
		for(String str: idList) {//경력자 또는 신입 또는 전체 중에서
			UsersDto dto=usersService.getData(str);
			searchDto.add(dto);
		}
		mView.addObject("searchList", searchDto);
		mView.setViewName("profile/searchList");
		
		//
		System.out.println(keyword);
		System.out.println(sp);
		System.out.println(exp);
		return mView;
	}
	

	@RequestMapping("/search")
	public ModelAndView search(@RequestParam Map<String, String> params, HttpServletRequest request) {
		
		SearchDto dto = new SearchDto();
		//셋중에 하나만 가능--all/skill/edu
		String sp = params.get("search_param");
		//무조건 존재--expAll/new/old
		String exp = params.get("exp");
		//keyword
		String keyword = params.get("keyword");
		System.out.println(sp);
		System.out.println(exp);
		System.out.println(keyword.toLowerCase());
		dto.setExp(exp);
		dto.setKeyword(keyword.toLowerCase());
		dto.setSearch_param(sp);
		
		ModelAndView mView = searchService.search(dto, request);
		mView.addObject("keyword", keyword);
		mView.addObject("search_param", sp);
		mView.addObject("exp", exp);
		
		mView.setViewName("profile/searchList");
		return mView;
	}

}
