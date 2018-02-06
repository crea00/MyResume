package com.project.myresume.profile.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.profile.dto.ExpsDto;

public interface ExpsService {
	public void insert(ExpsDto dto);// 저장(insert)	
	public void update(ExpsDto dto);// 수정(update)
	public void delete(ExpsDto dto);// 삭제(delete)
	public List<ExpsDto> getList(HttpServletRequest request);// 목록 리턴(select)
	public List<ExpsDto> resumeList(String id);// 목록 리턴(select)
	public ModelAndView getData(int num);//하나의 정보 리턴
	public List<String> oldSearch();
	public List<String> newSearch();
	
}
