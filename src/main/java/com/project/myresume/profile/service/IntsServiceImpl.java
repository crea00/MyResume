package com.project.myresume.profile.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.profile.dao.IntsDao;
import com.project.myresume.profile.dto.IntsDto;

@Service
public class IntsServiceImpl implements IntsService{
	
	@Autowired
	private IntsDao intsDao;
	
	@Override
	public void insert(IntsDto dto) {
		intsDao.insert(dto);
	}

	@Override
	public void update(IntsDto dto) {
		intsDao.update(dto);
	}

	@Override
	public void delete(IntsDto dto) {
		intsDao.delete(dto);
	}

	@Override
	public List<IntsDto> getList(HttpServletRequest request) {
		String id=(String)request.getSession().getAttribute("id");
		List<IntsDto> intsList=intsDao.getList(id);
		return intsList;
	}

	@Override
	public ModelAndView getData(int num) {
		IntsDto dto=intsDao.getData(num);
		ModelAndView mView=new ModelAndView();
		mView.addObject("dto",dto);
		return mView;
	}

	@Override
	public List<IntsDto> resumeList(String id) {
		List<IntsDto> intsList=intsDao.getList(id);
		return intsList;
	}

	@Override
	public void deleteAll(String id) {
		intsDao.deleteAll(id);
	}

}
