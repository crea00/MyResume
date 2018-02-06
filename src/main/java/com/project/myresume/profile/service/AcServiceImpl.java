package com.project.myresume.profile.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.profile.dao.AcDao;
import com.project.myresume.profile.dto.AcDto;
import com.project.myresume.users.dao.UsersDao;
import com.project.myresume.users.service.UsersService;

@Service
public class AcServiceImpl implements AcService{
	
	@Autowired
	private AcDao acDao;
	private UsersDao usDao;
	
	@Override
	public void insert(AcDto dto) {
		acDao.insert(dto);
	}

	@Override
	public void delete(AcDto dto) {
		acDao.delete(dto);
	}

	@Override
	public void update(AcDto dto) {
		acDao.update(dto);
	}

	@Override
	public List<AcDto> getList(HttpServletRequest request) {
		String id=(String)request.getSession().getAttribute("id");
		List<AcDto> acList=acDao.getList(id);
		return acList;
	}

	@Override
	public ModelAndView getData(int num) {
		AcDto dto=acDao.getData(num);
		ModelAndView mView=new ModelAndView();
		mView.addObject("dto", dto);
		return mView;
	}

	@Override
	public List<AcDto> resumeList(String id) {
		List<AcDto> acList=acDao.getList(id);
		return acList;
	}

	@Override
	public void deleteAll(String id) {
		acDao.deleteAll(id);
	}

}
