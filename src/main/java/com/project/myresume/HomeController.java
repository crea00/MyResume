package com.project.myresume;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request) {
		
		//가상의 공지 사항 
		List<String> news=new ArrayList<>();
		news.add("하나");
		news.add("두울");
		news.add("세엣");
		news.add("어쩌구.. 저쩌구...");
		
		request.setAttribute("news", news);
		
		return "home";
	}
	
}
