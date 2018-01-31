package com.project.myresume.users.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.file.service.FileService;
import com.project.myresume.users.dto.UsersDto;
import com.project.myresume.users.service.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;
	@Autowired
	private FileService fileService;
	
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
	
	
	@RequestMapping("/users/signup_form")
	public String signup_form() {
		
		return "users/signup_form";
	}
	
	@RequestMapping("/users/list")
	public ModelAndView list(HttpServletRequest request) {
		String id = (String)request.getSession().getAttribute("id");
		ModelAndView mv = usersService.detail(id);
		mv.setViewName("users/list");
		return mv;
	}
	
}
