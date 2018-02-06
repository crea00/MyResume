package com.project.myresume.profile.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.profile.dto.EduDto;

public interface EduService {
	public void insert(EduDto dto);
	public void delete(EduDto dto);
	public void update(EduDto dto);
	public List<EduDto> getList(HttpServletRequest request);
	public List<EduDto> resumeList(String id);
	public ModelAndView getData(int num);
	public List<String> search(String keyword);
}	
