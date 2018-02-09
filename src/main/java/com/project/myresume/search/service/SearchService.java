package com.project.myresume.search.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.search.dto.SearchDto;

public interface SearchService {
	public ModelAndView search(SearchDto dto, HttpServletRequest request);
	public List<String> idList(SearchDto dto);
}
