package com.project.myresume.profile.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.myresume.profile.dto.ExpsDto;
@Repository
public class ExpsDaoImpl implements ExpsDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(ExpsDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ExpsDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ExpsDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ExpsDto> getList(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExpsDto getData(ExpsDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
