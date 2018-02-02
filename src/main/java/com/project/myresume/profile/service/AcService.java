package com.project.myresume.profile.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.profile.dto.AcDto;

public interface AcService {
	public void insert(AcDto dto);
	public void delete(AcDto dto);
	public void update(AcDto dto);
	public List<AcDto> getList(HttpServletRequest request);
	public List<AcDto> resumeList(String id);
	public ModelAndView getData(int num);
}
