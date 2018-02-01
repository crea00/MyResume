package com.project.myresume.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.users.dto.UsersDto;
import com.project.myresume.users.service.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	// 로그인 폼 요청처리
	@RequestMapping("/users/loginform")
	public ModelAndView loginform(ModelAndView mv, HttpServletRequest request) {
		// url이라는 파라미터로 전달된 문자열 읽어오기
		String url = request.getParameter("url");
		System.out.println(url);
		if(url == null){
			// url이 null이면 root 요청
			url = request.getContextPath() + "/";
		}
		// 로그인 후 이동할 url정보를 ModelAndView객체에 담는다.
		mv.addObject("url", url);
		// view페이지 정보를 담고
		mv.setViewName("users/loginform");
		return mv;
	}
	
	// 로그인 요청처리
	@RequestMapping("/users/login")
	public ModelAndView login(@ModelAttribute UsersDto dto, HttpServletRequest request){
		ModelAndView mv = usersService.login(dto, request);
		mv.setViewName("users/login_result");
		return mv;		
	}
	
	// 로그아웃 요청 처리
	@RequestMapping("users/logout")
	public ModelAndView logout(HttpSession session, ModelAndView mv){
		String id = (String)session.getAttribute("id");
		// 세션초기화
		session.invalidate();
		mv.addObject("msg", id+" 님 로그 아웃 되었습니다.");
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
	public ModelAndView signup(@ModelAttribute UsersDto dto){
		// 전달되는 인자에 회원가입 정보가 들어있다.
		ModelAndView mv = usersService.signup(dto);
		mv.setViewName("users/signup_result");
		return mv;
	}
	
	// 회원정보 출력
	@RequestMapping("users/list")
	public ModelAndView getData(HttpServletRequest request){
		String id = (String)request.getSession().getAttribute("id");
		ModelAndView mv = usersService.getData(id);
		mv.setViewName	("users/list");
		return mv;
	}

	// 회원탈퇴
	@RequestMapping("/users/delete")
	public ModelAndView authDelete(HttpServletRequest request){
		HttpSession session = request.getSession();
		// service를 이용해서 탈퇴처리
		ModelAndView mv = usersService.delete(session);
		mv.setViewName("redirect:/");
		return mv;
	}
}
