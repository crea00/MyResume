package com.project.myresume.profile.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.profile.dao.AcDao;
import com.project.myresume.profile.dao.EduDao;
import com.project.myresume.profile.dto.AcDto;
import com.project.myresume.profile.dto.EduDto;

@Service
public class EduServiceImpl implements EduService {
	
	@Autowired
	private EduDao eduDao;
	@Autowired
	private AcDao acDao;
	
	@Override
	public void insert(EduDto dto) {
		eduDao.insert(dto);
	}

	@Override
	public void delete(EduDto dto) {
		eduDao.delete(dto);
	}

	@Override
	public void update(EduDto dto) {
		eduDao.update(dto);
	}

	@Override
	public List<EduDto> getList(HttpServletRequest request){
		String id=(String)request.getSession().getAttribute("id");
		List<EduDto> eduList= eduDao.getList(id); 
		
		return eduList;
	}

	@Override
	public ModelAndView getData(int num) {
		
		EduDto dto = eduDao.getData(num);
		
		ModelAndView mvView=new ModelAndView();
		mvView.addObject("dto",dto);
		
		return mvView;
	}

}