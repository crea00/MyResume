package com.project.myresume.profile.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.file.dto.FileDto;
import com.project.myresume.file.service.FileService;


@Controller
public class ProfileController {
	
	//의존 객체
		@Autowired 
		private FileService fileService;
		

		@RequestMapping("/profile/fileInsertForm")
		public ModelAndView authInsertForm(HttpServletRequest request){
			
			//생성자의 인자로 view 페이지의 정보를 전달해서 객체 생성 
			ModelAndView mView=new ModelAndView("profile/fileInsertForm");
			
			return mView;
		}
		
		//파일 업로드 요청 처리
		@RequestMapping("/profile/fileInsert")
		public ModelAndView authInsert(HttpServletRequest request, 
				@ModelAttribute FileDto dto){
			
			fileService.insert(request, dto);
			
			return new ModelAndView("redirect:/profile/detail.do");
		}
		
		@RequestMapping("/profile/fileDelete")
		public ModelAndView authDelete(HttpServletRequest request, 
				@RequestParam String id){
			
			fileService.delete(request, id);
			
			return new ModelAndView("redirect:/profile/detail.do");
		}
	
	
	
	/////////////////////////////////////////////////////
	
	@RequestMapping("/profile/detail")
	public String profile(HttpServletRequest request) {
		
		
		return "profile/detail";
	}
	
	
}
