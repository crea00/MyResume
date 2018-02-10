package com.project.myresume.cafe.dao;

import java.util.List;

import com.project.myresume.cafe.dto.CafeDto;

public interface CafeDao {
	public void insert(CafeDto dto);			// 글 입력
	public void delete(int num);				// 글 삭제
	public void update(CafeDto dto);			// 글 수정
	public List<CafeDto> getList (CafeDto dto);	// 글목록 출력
	public CafeDto getData(CafeDto dto);		// 글정보 출력
	public CafeDto getData(int num);	
	public int getCount(CafeDto dto);			// 검색어에 일치하는 글의 갯수출력
	public void increaseViewCount(int num);		// 조회수 출력
	
}
