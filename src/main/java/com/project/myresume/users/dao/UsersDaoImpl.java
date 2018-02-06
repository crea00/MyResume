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
		session.insert("users.insert", dto);
	}

	@Override
	public boolean canUseId(String id) {
		// id가 존재하는지 select
		String result = session.selectOne("users.isExistId", id);
		
		if(result == null){
			System.out.println("result는 true?" + result);
			// id가 존재하지 않으면 사용가능
			return true;

		} else {
			// id가 존재하면 사용불가
			System.out.println("result는 false?" + result);
			return false;
			
		}
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
	public List<UsersDto> getList() {
		//회원 전체의 정보 가져오기
		return session.selectList("users.getList");

	}

	@Override
	public void delete(String id) {
		session.delete("users.delete", id);
	}

	@Override
	public void update(UsersDto dto) {
		session.update("users.update",dto);
		
	}
	
	@Override
	public List<String> search(String keyword) {
		
		return session.selectList("users.search", keyword);
	}

	@Override
	public void increaseViewCount(String id) {
		session.update("users.addCount",id);
		
	}
	
	

}
