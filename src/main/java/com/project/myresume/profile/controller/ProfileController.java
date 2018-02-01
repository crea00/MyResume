package com.project.myresume.profile.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.file.dto.FileDto;
import com.project.myresume.file.service.FileService;
import com.project.myresume.profile.service.AcService;
import com.project.myresume.profile.service.EduService;


@Controller
public class ProfileController {
	
	//의존 객체
		@Autowired 
		private FileService fileService;
		
		@Autowired
		private EduService eduService;
		
		@Autowired
		private AcService acService;

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
	
	
	// edu 목록 보여주기
	@RequestMapping("/profile/detail")
	public ModelAndView getList(HttpServletRequest request){
		Map<String, Object> map = new HashMap<>();
		map.put("edu", eduService.getList(request));
		map.put("ac", acService.getList(request));
		ModelAndView mView=new ModelAndView();
		mView.addObject("map",map);
		mView.setViewName("profile/detail");
		return mView;
	}
	
	
}
