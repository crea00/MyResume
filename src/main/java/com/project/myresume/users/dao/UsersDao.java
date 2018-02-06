package com.project.myresume.users.dao;

import java.util.List;

import com.project.myresume.users.dto.UsersDto;

public interface UsersDao {
	public void insert(UsersDto dto);
	public boolean canUseId(String id);
	public UsersDto getData(String id);
	public boolean isValid(UsersDto dto);
	public List<UsersDto> getList();
	public void delete(String id);
	public void update(UsersDto dto);
	public void increaseViewCount(String id);
	
}
