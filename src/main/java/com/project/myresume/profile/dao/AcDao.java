package com.project.myresume.profile.dao;

import java.util.List;

import com.project.myresume.profile.dto.AcDto;

public interface AcDao {
	public void insert(AcDto dto); // 저장
	public void update(AcDto dto); // 업데이트
	public void delete(AcDto dto); // 삭제
	public List<AcDto> getList(String id); // 목록
	public AcDto getData(int num); // 하나의 정보 리턴
}
