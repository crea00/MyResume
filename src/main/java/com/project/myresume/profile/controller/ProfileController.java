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
import com.project.myresume.profile.dto.ExpsDto;
import com.project.myresume.profile.dto.IntsDto;
import com.project.myresume.profile.dto.SkillsDto;
import com.project.myresume.profile.service.AcService;
import com.project.myresume.profile.service.EduService;
import com.project.myresume.profile.service.ExpsService;
import com.project.myresume.profile.service.IntsService;
import com.project.myresume.profile.service.SkillsService;
import com.project.myresume.users.dto.UsersDto;
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
	private ExpsService exService;
	
	@Autowired
	private IntsService intsService;
	
	@Autowired
	private SkillsService skillService;

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
		String id=(String)request.getSession().getAttribute("id");
		usersService.increaseViewCount(id);
		ModelAndView mView = new ModelAndView();
		List<AcDto> acList = acService.getList(request);
		List<EduDto> eduList = eduService.getList(request);
		List<ExpsDto> exList = exService.getList(request);
		List<IntsDto> intsList = intsService.getList(request);
		List<SkillsDto> skillsList = skillService.getList(request);
		UsersDto mydto =usersService.getData(id);
		mView.addObject("myDto",mydto);
		mView.addObject("acList", acList);
		mView.addObject("eduList", eduList);
		mView.addObject("expsList", exList);
		mView.addObject("intsList",intsList);
		mView.addObject("skillsList",skillsList);
		mView.setViewName("profile/detail");
		return mView;
	}

	// 회원 이력서 출력 페이지 
	@RequestMapping("/profile/resume")
	public ModelAndView resume(HttpServletRequest request, @RequestParam String id) {
		ModelAndView mv = new ModelAndView();
		// usersService.increaseViewCount(id); 보류
		UsersDto resumeDto = usersService.getData(id);
		List<AcDto> acList = acService.resumeList(id);
		List<EduDto> eduList = eduService.resumeList(id);
		List<ExpsDto> exList = exService.resumeList(id);
		List<IntsDto> intsList = intsService.resumeList(id);
		List<SkillsDto> skillsList = skillService.resumeList(id);
		mv.addObject("resumeDto", resumeDto);
		mv.addObject("acList", acList);
		mv.addObject("eduList", eduList);		
		mv.addObject("exList", exList);		
		mv.addObject("intsList", intsList);		
		mv.addObject("skillsList", skillsList);		
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
		return new ModelAndView("profile/acInsertForm");
	}
	
	// ac Insert
	@RequestMapping("/profile/acInsert")
	public ModelAndView acInsert(HttpServletRequest request,
			@ModelAttribute AcDto dto){
		String id=(String)request.getSession().getAttribute("id");
		acService.insert(dto);
		ModelAndView mView=new ModelAndView();
		mView.setViewName("redirect:/profile/detail.do");
		return mView;
	}
	
	// expsUpdateForm
	@RequestMapping("/profile/expsUpdateForm")
	public ModelAndView expsUpdateForm(@RequestParam int num){
	
       ModelAndView mView=exService.getData(num);
       mView.setViewName("profile/expsUpdateForm");
       return mView;
	}
	
	// expsUpdate
	@RequestMapping("/profile/expsUpdate")
	public ModelAndView expsUpdate(@ModelAttribute ExpsDto dto){
		exService.update(dto);
		ModelAndView mView= new ModelAndView();
		mView.setViewName("redirect:/profile/detail.do");
		return mView;
	}
	
	// expsDelete
	@RequestMapping("/profile/expsDelete")
	public ModelAndView expsDelete(@ModelAttribute ExpsDto dto){
		exService.delete(dto);
		ModelAndView mView=new ModelAndView();
		mView.setViewName("redirect:/profile/detail.do");
		return mView;
	}
	
	// expsInsertForm
	@RequestMapping("/profile/expsInsertForm")
	public ModelAndView expsInsertForm(){
		return new ModelAndView("profile/expsInsertForm");
	}
	
	// expsInsert
	@RequestMapping("/profile/expsInsert")
	public ModelAndView expsInsert(HttpServletRequest request,
			@ModelAttribute ExpsDto dto){
		String id=(String)request.getSession().getAttribute("id");
		exService.insert(dto);
		
		return new ModelAndView("redirect:/profile/detail.do");
	}
	
	// SkillsDelete
	@RequestMapping("/profile/skillsDelete")
	public ModelAndView skillsDelete(@ModelAttribute SkillsDto dto){
		skillService.delete(dto);
		
		return new ModelAndView("redirect:/profile/detail.do");
	}
	
	// SkillsUpdateForm
	@RequestMapping("/profile/skillsUpdateForm")
	public ModelAndView skillsUpdateForm(@RequestParam int num){
		ModelAndView mView= skillService.getData(num);
		mView.setViewName("profile/skillsUpdateForm");
		return mView;  
	}
	
	// SkillsUpdate
	@RequestMapping("/profile/skillsUpdate")
	public ModelAndView skillsUpdate(@ModelAttribute SkillsDto dto){
		skillService.update(dto);
		return new ModelAndView("redirect:/profile/detail.do");
	}
	
	// SkillsInsertForm
	@RequestMapping("/profile/skillsInsertForm")
	public ModelAndView skillsInsertForm(){
		return new ModelAndView("profile/skillsInsertForm");
	}
	
	// skillsInsert
	@RequestMapping("/profile/skillsInsert")
	public ModelAndView skillsInsert(@ModelAttribute SkillsDto dto){
		skillService.insert(dto);
		return new ModelAndView("redirect:/profile/detail.do");
	}
	
	// intsUpdateForm
	@RequestMapping("/profile/intsUpdateForm")
	public ModelAndView intsUpdateForm(@RequestParam int num){
		ModelAndView mView=intsService.getData(num);
		mView.setViewName("profile/intsUpdateForm");
		return mView;
	}
	
	// intsUpdate
	@RequestMapping("/profile/intsUpdate")
	public ModelAndView intsUpdate(@ModelAttribute IntsDto dto){
		intsService.update(dto);
		return new ModelAndView("redirect:/profile/detail.do");
	}
	
	// intsDelete
	@RequestMapping("/profile/intsDelete")
	public ModelAndView intsDelete(@ModelAttribute IntsDto dto){
		intsService.delete(dto);
		return new ModelAndView("redirect:/profile/detail.do");
	}
	
	// intsInsertForm
	@RequestMapping("/profile/intsInsertForm")
	public ModelAndView intsInsertForm(){
		return new ModelAndView("profile/intsInsertForm");
	}
	
	// intsInsert
	@RequestMapping("/profile/intsInsert")
	public ModelAndView intsInsert(@ModelAttribute IntsDto dto){
		intsService.insert(dto);
		ModelAndView mView= new ModelAndView();
		mView.setViewName("redirect:/profile/detail.do");
		return mView;
	}
}
