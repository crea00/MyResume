package com.project.myresume.search.service;

import java.util.List;

import com.project.myresume.search.dto.SearchDto;

public interface SearchService {
	public List<String> search(SearchDto dto);
}
