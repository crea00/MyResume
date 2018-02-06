package com.project.myresume.profile.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.profile.dao.SkillsDao;
import com.project.myresume.profile.dto.SkillsDto;
import com.project.myresume.users.dao.UsersDao;

@Service
public class SkillsServiceImpl implements SkillsService{
	
	@Autowired
	private SkillsDao skillDao;
	
	@Autowired
	private UsersDao usersDao;
	
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

	@Override
	public List<SkillsDto> resumeList(String id) {
		List<SkillsDto> skillsList = skillDao.getList(id);
		usersDao.increaseViewCount(id);
		return skillsList;
	}

	@Override
	public void deleteAll(String id) {
		skillDao.deleteAll(id);	
	}
	
	@Override
	public List<String> search(String keyword) {
		// TODO Auto-generated method stub
		return skillDao.search(keyword);

	}


}
