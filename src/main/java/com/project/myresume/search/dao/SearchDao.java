package com.project.myresume.search.dao;

import java.util.List;

import com.project.myresume.search.dto.SearchDto;

public interface SearchDao {
	public List<String> search(SearchDto dto);
	public int getCount(SearchDto dto);
}
