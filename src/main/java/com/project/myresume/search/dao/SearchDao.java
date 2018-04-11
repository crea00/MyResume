package com.project.myresume.search.dao;

import java.util.List;

import com.project.myresume.search.dto.SearchDto;

public interface SearchDao {
	// SearchDto를 parameter로 받아 검색하고 List를 리턴한다
	public List<String> search(SearchDto dto);
	// SearchDto를 parameter로 받아 카운트를 세고 int를 리턴한다
	public int getCount(SearchDto dto);
}
