package com.project.myresume.users.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.myresume.users.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(UsersDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canUseId(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UsersDto getData(String id) {
		return session.selectOne("users.getData", id);
	}

	@Override
	public boolean isValid(UsersDto dto) {
	
		return session.selectOne("users.isValid", dto);
	}

	@Override
	public List<UsersDto> getList(UsersDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UsersDto dto) {
		// TODO Auto-generated method stub
		
	}

}
