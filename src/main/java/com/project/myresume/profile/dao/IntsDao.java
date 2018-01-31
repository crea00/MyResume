package com.project.myresume.profile.dao;

import java.util.List;

import com.project.myresume.profile.dto.IntsDto;

public interface IntsDao {
	public void insert(IntsDto dto);// 저장(insert)	
	public void update(IntsDto dto);// 수정(update)
	public void delete(IntsDto dto);// 삭제(delete)
	public List<IntsDto> getList(String id);// 목록 리턴(select)
	public IntsDto getData(IntsDto dto);//하나의 정보 리턴
}
