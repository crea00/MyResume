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
		session.insert("exps.insert",dto);
	}

	@Override
	public void update(ExpsDto dto) {
		session.update("exps.update",dto);
	}

	@Override
	public void delete(ExpsDto dto) {
		session.delete("exps.delete",dto);
	}

	@Override
	public List<ExpsDto> getList(String id) {
	
		return session.selectList("exps.getList",id);
	}

	@Override
	public ExpsDto getData(int num) {

		return session.selectOne("exps.getData",num);
	}

	@Override
	public List<ExpsDto> oldSearch() {
		// TODO Auto-generated method stub
		
		return session.selectList("exps.oldList");
	}


	@Override
	public List<ExpsDto> newSearch() {
		// TODO Auto-generated method stub
		return session.selectList("exps.newList");
	}

}
