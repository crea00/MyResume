package com.project.myresume.file.dao;


import com.project.myresume.file.dto.FileDto;


public interface FileDao {
	//파일의 정보를 삭제하는 메소드
	public void delete(String id);
	//파일의 정보를 리턴해주는 메소드
	public FileDto getData(String id);
	//파일 정보를 저장하는 메소드
	public void insert(FileDto dto);
	
}
