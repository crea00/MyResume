package com.project.myresume.profile.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.file.dto.FileDto;
import com.project.myresume.file.service.FileService;

import com.project.myresume.profile.dto.AcDto;
import com.project.myresume.profile.dto.EduDto;
import com.project.myresume.profile.service.AcService;
import com.project.myresume.profile.service.EduService;

import com.project.myresume.users.service.UsersService;

@Controller
public class ProfileController {

	// 의존 객체
	@Autowired
	private FileService fileService;

	@Autowired
	private EduService eduService;

	@Autowired
	private AcService acService;

	@Autowired
	private UsersService usersService;

	@RequestMapping("/profile/fileInsertForm")
	public ModelAndView authInsertForm(HttpServletRequest request) {

		// 생성자의 인자로 view 페이지의 정보를 전달해서 객체 생성
		ModelAndView mView = new ModelAndView("profile/fileInsertForm");

		return mView;
	}

	// 파일 업로드 요청 처리
	@RequestMapping("/profile/fileInsert")
	public ModelAndView authInsert(HttpServletRequest request, @ModelAttribute FileDto dto) {

		fileService.insert(request, dto);

		return new ModelAndView("redirect:/profile/detail.do");
	}

	@RequestMapping("/profile/fileDelete")
	public ModelAndView authDelete(HttpServletRequest request, @RequestParam String id) {
		fileService.delete(request, id);

		return new ModelAndView("redirect:/profile/detail.do");
	}

	// profile 목록 보여주기
	@RequestMapping("/profile/detail")
	public ModelAndView getList(HttpServletRequest request) {

		ModelAndView mView = new ModelAndView();
		List<AcDto> acList = acService.getList(request);
		List<EduDto> eduList = eduService.getList(request);
		mView.addObject("acList", acList);
		mView.addObject("eduList", eduList);
		mView.setViewName("profile/detail");
		return mView;
	}

	// 회원 이력서 출력 페이지
	@RequestMapping("/profile/resume")
	public ModelAndView resume(HttpServletRequest request, @RequestParam String id) {
		ModelAndView mv = usersService.getData(id);
		mv.setViewName("profile/resume");

		return mv;
	}

	// edu 한개의정보 갖고오기
	@RequestMapping("/profile/eduUpdateForm")
	public ModelAndView updateform(@RequestParam int num) {
		ModelAndView mView = eduService.getData(num);
		mView.setViewName("profile/eduUpdateForm");
		return mView;
	}

	// edu 수정하기
	@RequestMapping("/profile/eduUpdate")
	public ModelAndView eduUpdate(@ModelAttribute EduDto dto) {
		eduService.update(dto);
		ModelAndView mView = new ModelAndView();
		mView.setViewName("redirect:/profile/detail.do");
		return mView;
	}

	// edu 삭제하기
	@RequestMapping("/profile/eduDelete")
	public ModelAndView delete(@ModelAttribute EduDto dto) {
		eduService.delete(dto);
		ModelAndView mView = new ModelAndView();
		mView.setViewName("redirect:/profile/detail.do");
		return mView;

	}

	// edu insertForm
	@RequestMapping("/profile/eduInsertForm")
	public ModelAndView eduInsertForm() {

		return new ModelAndView("profile/eduInsertForm");
	}

	// edu insert
	@RequestMapping("/profile/eduInsert")
	public ModelAndView eduInsert(HttpServletRequest request, @ModelAttribute EduDto dto) {
		String id = (String) request.getSession().getAttribute("id");
		dto.setId(id);
		eduService.insert(dto);
		return new ModelAndView("redirect:/profile/detail.do");
	}

	// ac updateForm
	@RequestMapping("/profile/acUpdateForm")
	public ModelAndView acUpdateForm(@RequestParam int num) {
		ModelAndView mView = acService.getData(num);
		mView.setViewName("profile/acUpdateForm");
		return mView;
	}

	// ac Update
	@RequestMapping("/profile/acUpdate")
	public ModelAndView acUpdate(@ModelAttribute AcDto dto) {
		acService.update(dto);
		ModelAndView mView = new ModelAndView();
		mView.setViewName("redirect:/profile/detail.do");
		return mView;
	}

	// ac Delete
	@RequestMapping("/profile/acDelete")
	public ModelAndView acDelete(@ModelAttribute AcDto dto) {
		acService.delete(dto);
		ModelAndView mView = new ModelAndView();
		mView.setViewName("redirect:/profile/detail.do");
		return mView;
	}

	// ac InsertForm
	@RequestMapping("/profile/acInsertForm")
	public ModelAndView acInsertForm() {
		return new ModelAndView("redirect:/profile/acInsertForm.do");
	}

}
