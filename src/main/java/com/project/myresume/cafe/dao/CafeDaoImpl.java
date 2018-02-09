package com.project.myresume.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.myresume.cafe.dto.CafeDto;

@Repository
public class CafeDaoImpl implements CafeDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(CafeDto dto) {
		session.insert("cafe.insert", dto);
	}

	@Override
	public void delete(int num) {
		session.delete("cafe.delete", num);
	}

	@Override
	public void update(CafeDto dto) {
		session.update("cafe.update", dto);
	}

	// 검색어에 일치하는 글의 목록 리턴하기
	@Override
	public List<CafeDto> getList(CafeDto dto) {
		// parameterType으로 검색키워드가 담긴 CafeDto를 전달
		return session.selectList("cafe.getList", dto);
	}

	// 글 자세히보기
	@Override
	public CafeDto getData(CafeDto dto) {
		return session.selectOne("cafe.getData", dto);
	}
	
	@Override
	public CafeDto getData(int num) {
		return session.selectOne("cafe.getData2", num);
	}

	@Override
	public int getCount(CafeDto dto) {
		return session.selectOne("cafe.getCount", dto);
	}
	
	// 글 조회수
	@Override
	public void increaseViewCount(int num) {
		session.update("cafe.addCount", num);
	}

	


}
