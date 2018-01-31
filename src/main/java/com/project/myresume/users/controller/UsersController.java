package com.project.myresume.users.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {

	@RequestMapping("/users/loginform")
	public String loginform() {
		
		return "users/loginform";
	}
	
	@RequestMapping("/users/signup_form")
	public String signup_form() {
		
		return "users/signup_form";
	}
	
	@RequestMapping("/users/list")
	public String list() {
		
		return "users/list";
	}
}
