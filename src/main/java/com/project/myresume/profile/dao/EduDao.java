package com.project.myresume.profile.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.project.myresume.profile.dto.EduDto;

public interface EduDao {
	public void insert(EduDto dto); // 저장
	public void update(EduDto dto); // 업데이트
	public void delete(EduDto dto); // 삭제
	public List<EduDto> getList(String id); // 목록
	public EduDto getData(int num); // 하나의 정보 리턴

	
	public void deleteAll(String id);

	public List<String> search(String keyword);

}
