package com.project.myresume;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.users.dto.UsersDto;
import com.project.myresume.users.service.UsersService;

@Controller
public class HomeController {
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/home")
	public ModelAndView home(HttpServletRequest request) {
		
		ModelAndView mv = usersService.getList(request);
		mv.setViewName("home");

		return mv;
	}
	
}
