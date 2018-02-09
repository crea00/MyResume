package com.project.myresume.search.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.myresume.search.dto.SearchDto;
@Repository
public class SearchDaoImpl implements SearchDao{

	@Autowired
	private SqlSession session;
	
	@Override//검색기능
	public List<String> search(SearchDto dto) {
		// TODO Auto-generated method stub
		return session.selectList("search.s",dto);
	}

	@Override
	public int getCount(SearchDto dto) {
		// TODO Auto-generated method stub
		return session.selectOne("search.getCount",dto);
	}

}
