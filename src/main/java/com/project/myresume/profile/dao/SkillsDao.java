package com.project.myresume.profile.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.project.myresume.profile.dto.SkillsDto;

public interface SkillsDao {
	public void insert(SkillsDto dto);// 저장(insert)	
	public void update(SkillsDto dto);// 수정(update)
	public void delete(SkillsDto dto);// 삭제(delete)
	public List<SkillsDto> getList(String id);// 목록 리턴(select)
	public SkillsDto getData(int num);//하나의 정보 리턴
	
	public void deleteAll(String id); 
}
