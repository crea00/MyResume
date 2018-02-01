package com.project.myresume.profile.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.myresume.profile.dto.AcDto;

@Repository
public class AcDaoImpl implements AcDao{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(AcDto dto) {
		session.insert("ac.insert",dto);
	}

	@Override
	public void update(AcDto dto) {
		session.update("ac.update",dto);
	}

	@Override
	public void delete(AcDto dto) {
		session.delete("ac.delete",dto);
	}

	@Override
	public List<AcDto> getList(String id) {
		
		return session.selectList("ac.getList",id);
	}

	@Override
	public AcDto getData(int num) {

		return session.selectOne("ac.getData",num);
	}

}
