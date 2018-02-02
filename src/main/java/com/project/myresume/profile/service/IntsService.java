package com.project.myresume.profile.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.profile.dto.IntsDto;

public interface IntsService {
	public void insert(IntsDto dto);// 저장(insert)	
	public void update(IntsDto dto);// 수정(update)
	public void delete(IntsDto dto);// 삭제(delete)
	public List<IntsDto> getList(HttpServletRequest request);// 목록 리턴(select)
	public ModelAndView getData(int num);//하나의 정보 리턴
	
	
}
