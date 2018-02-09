package com.project.myresume.cafe.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.cafe.dto.CafeDto;

public interface CafeService {
	public void insert(CafeDto dto);
	public void delete(int num);
	public void update(CafeDto dto);
	public ModelAndView list(HttpServletRequest request);
	public ModelAndView detail(CafeDto dto);
	public ModelAndView detail(int num);
}
