package com.project.myresume.profile.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.profile.dao.SkillsDao;
import com.project.myresume.profile.dto.SkillsDto;

@Service
public class SkillsServiceImpl implements SkillsService{
	
	@Autowired
	private SkillsDao skillDao;
	
	@Override
	public void insert(SkillsDto dto) {
		skillDao.insert(dto);
	}

	@Override
	public void update(SkillsDto dto) {
		skillDao.update(dto);
	}

	@Override
	public void delete(SkillsDto dto) {
		skillDao.delete(dto);
	}

	@Override
	public List<SkillsDto> getList(HttpServletRequest request) {
		String id=(String)request.getSession().getAttribute("id");
		List<SkillsDto> skillsList = skillDao.getList(id);
		return skillsList;
	}

	@Override
	public ModelAndView getData(int num) {
		SkillsDto dto=skillDao.getData(num);
		ModelAndView mView=new ModelAndView();
		mView.addObject("dto",dto);
		return mView;
	}

}
