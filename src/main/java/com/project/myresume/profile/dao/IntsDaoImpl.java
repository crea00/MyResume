package com.project.myresume.profile.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.myresume.profile.dto.IntsDto;

@Repository
public class IntsDaoImpl implements IntsDao {
	@Autowired
	private SqlSession session;

	@Override
	public void insert(IntsDto dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(IntsDto dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(IntsDto dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<IntsDto> getList(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IntsDto getData(IntsDto dto) {
		// TODO Auto-generated method stub
		return null;
	}
}
