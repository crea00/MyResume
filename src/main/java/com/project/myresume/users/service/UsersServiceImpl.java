package com.project.myresume.users.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.users.dao.UsersDao;
import com.project.myresume.users.dto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao usersDao;
	
	@Override
	public ModelAndView signup(UsersDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canUseId(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ModelAndView login(UsersDto dto, HttpServletRequest request) {
		// 입력한 아이디를 이용해서 가입된 회원정보가 있는지 select
		UsersDto resultDto = usersDao.getData(dto.getId());
		
		//아이디, 비밀번호가 유효한지 여부
		boolean isValid = true;
		
		if(resultDto != null){
			/* 일단 그냥 로그인 */
			// DB에 입력한 아이디가 존재한다면 비밀번호를 확인한다.
			boolean isMatch = true;
			if(isMatch){
				isValid = true;
			}
		} 
		
		// 원래 이동해야할 url
		String url = request.getParameter("url");

		ModelAndView mv = new ModelAndView();
		if(isValid){
			// 만약 아이디와 비밀번호가 일치한다면 로그인 처리
			request.getSession().setAttribute("id", dto.getId());
			mv.addObject("msg", dto.getId() + "님 로그인되었습니다.");
			mv.addObject("url", url);
		} else {
			// 아이디 혹은 비밀번호가 틀린경우
			mv.addObject("msg", "아이디 혹은 비밀번호가 틀려요.");
			String location = request.getContextPath() + "/users/loginform.do?url=" + url;
			mv.addObject("url", location);
		}
		return mv;
	}

	@Override
	public void update(UsersDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ModelAndView delete(HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView detail(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
