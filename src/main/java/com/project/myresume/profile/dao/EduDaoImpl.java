	package com.project.myresume.profile.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.myresume.profile.dto.EduDto;

@Repository
public class EduDaoImpl implements EduDao{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(EduDto dto) {
		session.insert("edu.insert",dto);
	}

	@Override
	public void update(EduDto dto) {
		session.update("edu.update",dto);
	}

	@Override
	public void delete(EduDto dto) {
		session.delete("edu.delete",dto);
	}

	@Override
	public List<EduDto> getList(String id) {
		return session.selectList("edu.getList",id);
	}

	@Override
	public EduDto getData(int num) {
		
		return session.selectOne("edu.getData",num);
	}

	@Override
	public void deleteAll(String id) {
		session.selectOne("edu.deleteAll",id);
	}

}
