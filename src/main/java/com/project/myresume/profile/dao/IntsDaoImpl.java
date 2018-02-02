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
		session.insert("ints.insert",dto);
	}

	@Override
	public void update(IntsDto dto) {
		session.update("ints.update",dto);
	}

	@Override
	public void delete(IntsDto dto) {
		session.delete("ints.delete",dto);
	}

	@Override
	public List<IntsDto> getList(String id) {
		
		return session.selectList("ints.getList",id);
	}

	@Override
	public IntsDto getData(int num) {
	
		return session.selectOne("ints.getData",num);
	}
}
