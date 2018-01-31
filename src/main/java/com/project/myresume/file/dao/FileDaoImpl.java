package com.project.myresume.file.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.myresume.file.dto.FileDto;

@Repository
public class FileDaoImpl implements FileDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public void delete(String id) {
		session.delete("file.delete",id);
		
	}

	@Override
	public FileDto getData(String id) {
		
		return session.selectOne("file.getData",id);
	}

	@Override
	public void insert(FileDto dto) {
		session.insert("file.insert",dto);
		
	}

}
