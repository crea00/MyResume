package com.project.myresume.file.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.file.dto.FileDto;

public interface FileService {
	public void insert(HttpServletRequest request, FileDto dto);
	public void delete(HttpServletRequest request, String id);
	public ModelAndView getData(String id);	
}
