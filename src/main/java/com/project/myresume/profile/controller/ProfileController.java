package com.project.myresume.profile.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {
	
	@RequestMapping("/profile/detail")
	public String profile(HttpServletRequest request) {
		
		
		return "profile/detail";
	}
	
	@RequestMapping("/profile/fileInsertForm")
	public String fileInsertform() {
		
		return "profile/fileInsertForm";
	}
}
