package com.project.myresume.profile.dao;

import java.util.List;


import com.project.myresume.profile.dto.ExpsDto;


public interface ExpsDao {
	
	public void insert(ExpsDto dto);// 저장(insert)	
	public void update(ExpsDto dto);// 수정(update)
	public void delete(ExpsDto dto);// 삭제(delete)
	public List<ExpsDto> getList(String id);// 경험목록 리턴(select)
	public ExpsDto getData(int num);//하나의 정보 리턴

	
	public void deleteAll(String id);

	public List<ExpsDto> oldSearch();
	public List<ExpsDto> newSearch();
}