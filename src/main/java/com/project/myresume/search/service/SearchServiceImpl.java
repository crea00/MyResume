package com.project.myresume.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.myresume.search.dao.SearchDao;
import com.project.myresume.search.dto.SearchDto;
@Service
public class SearchServiceImpl implements SearchService{

	@Autowired
	private SearchDao dao;
	
	@Override
	public List<String> search(SearchDto dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}

}
