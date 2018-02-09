package com.project.myresume.cafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.cafe.dto.CafeDto;
import com.project.myresume.cafe.service.CafeService;
import com.project.myresume.users.dto.UsersDto;

@Controller
public class CafeController {

	@Autowired
	private CafeService cafeService;
	
	// 글 입력폼으로 이동
	@RequestMapping("/cafe/insertform")
	public ModelAndView authInsertForm(HttpServletRequest request){
		return new ModelAndView("cafe/insertform");
	}
	
	// 글 입력
	@RequestMapping("/cafe/insert")
	public ModelAndView authInsert(HttpServletRequest request, @ModelAttribute CafeDto dto){
		String writer = (String)request.getSession().getAttribute("id");
		dto.setWriter(writer);
		cafeService.insert(dto);
		System.out.println("dto에 저장된 writer" + dto.getWriter());
		System.out.println("dto에 저장된 title" + dto.getTitle());
		
		return new ModelAndView("redirect:/cafe/list.do");
	}
	
	// 글 삭제
	@RequestMapping("/cafe/delete")
	public ModelAndView authDelete(HttpServletRequest request, @RequestParam int num){
		cafeService.delete(num);
		return new ModelAndView("redirect:/cafe/list.do");
	}
	
	// 글목록 출력
	@RequestMapping("/cafe/list")
	public ModelAndView list(HttpServletRequest request){
		ModelAndView mv = cafeService.list(request);
		mv.setViewName("cafe/list");
		return mv;
	}
	
	// 글 자세히보기
	@RequestMapping("/cafe/detail")
	public ModelAndView detail(HttpServletRequest request){
		ModelAndView mv = cafeService.detail(request);
		mv.setViewName("cafe/detail");
		return mv;		
	}
	
	// 글 수정폼으로 이동
	@RequestMapping("/cafe/updateform")
	public ModelAndView authUpdateForm(HttpServletRequest request, @RequestParam int num){
		ModelAndView mv = cafeService.detail(num);
		mv.setViewName("cafe/updateform");
		return mv;
	}
	
	// 글 수정
	@RequestMapping("/cafe/update")
	public ModelAndView authUpdate(HttpServletRequest request, @ModelAttribute CafeDto dto){
		cafeService.update(dto);
		// 수정 결과 페이지로 이동하면서 글번호를 가지고간다.
		ModelAndView mv = new ModelAndView();
		mv.addObject("num", dto.getNum());
		mv.setViewName("cafe/update_result");
		return mv;
	}
}
