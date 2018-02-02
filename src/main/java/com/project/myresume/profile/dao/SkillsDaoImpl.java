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
		session.insert("skill.insert",dto);
	}

	@Override
	public void update(SkillsDto dto) {
		session.update("skill.update",dto);
	}

	@Override
	public void delete(SkillsDto dto) {
		session.delete("skill.delete",dto);
	}

	@Override
	public List<SkillsDto> getList(String id) {
		
		return session.selectList("skill.getList",id);
	}

	@Override
	public SkillsDto getData(int num) {
		
		return session.selectOne("skill.getData",num);
	}
	
}
