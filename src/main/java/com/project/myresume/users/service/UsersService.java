package com.project.myresume.users.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.users.dto.UsersDto;

public interface UsersService {
	public ModelAndView signup(UsersDto dto);
	public boolean canUseId(String id);
	public ModelAndView login(UsersDto dto, HttpServletRequest request);
	public void update(UsersDto dto);
	public ModelAndView delete(HttpSession session);
	public ModelAndView getList();
	public ModelAndView getData(String id);
}
