package com.project.myresume.profile.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.myresume.profile.dto.SkillsDto;
@Repository
public class SkillsDaoImpl implements SkillsDao{
	@Autowired
	private SqlSession session;

	@Override
	public void insert(SkillsDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SkillsDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SkillsDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SkillsDto> getList(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SkillsDto getData(SkillsDto dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
