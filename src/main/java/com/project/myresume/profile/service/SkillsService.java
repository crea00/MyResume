package com.project.myresume.profile.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.profile.dto.SkillsDto;

public interface SkillsService {
	public void insert(SkillsDto dto);// 저장(insert)	
	public void update(SkillsDto dto);// 수정(update)
	public void delete(SkillsDto dto);// 삭제(delete)
	public List<SkillsDto> getList(HttpServletRequest request);// 목록 리턴(select)
	public ModelAndView getData(int num);//하나의 정보 리턴
	
	
}
