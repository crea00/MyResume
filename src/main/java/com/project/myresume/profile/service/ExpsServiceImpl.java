package com.project.myresume.profile.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.profile.dao.ExpsDao;
import com.project.myresume.profile.dto.ExpsDto;

@Service
public class ExpsServiceImpl implements ExpsService{
	
	@Autowired
	private ExpsDao exDao;
	
	@Override
	public void insert(ExpsDto dto) {
		exDao.insert(dto);
	}

	@Override
	public void update(ExpsDto dto) {
		exDao.update(dto);
	}

	@Override
	public void delete(ExpsDto dto) {
		exDao.delete(dto);
	}

	@Override
	public List<ExpsDto> getList(HttpServletRequest request) {
		String id =(String)request.getSession().getAttribute("id");
		List<ExpsDto> exList=exDao.getList(id);
		
		return exList;
	}

	@Override
	public ModelAndView getData(int num) {
		ExpsDto dto = exDao.getData(num);
		ModelAndView mView= new ModelAndView();
		mView.addObject("dto",dto);
		return mView;
	}

	@Override
	public List<ExpsDto> resumeList(String id) {
		List<ExpsDto> exList=exDao.getList(id);
		
		return exList;
	}

}
