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
		
		usersDao.insert(dto);
		// Dao를 이용해서 Db에 저장
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", dto.getId());
		
		return mv;
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
		boolean isValid = false;
		
		if(resultDto != null){
			boolean isMatch = true;
			if(isMatch){
				isValid = true;
			}
		}

		
		// 원래 이동해야할 url
		String url = request.getParameter("url");
		System.out.println("url" + url);
		
		ModelAndView mv = new ModelAndView();
		if(isValid){
			// 만약 아이디와 비밀번호가 일치한다면 로그인 처리
			request.getSession().setAttribute("id", dto.getId());
		
			mv.addObject("msg", dto.getId() + "님 로그인되었습니다.");
			mv.addObject("home.do", url);
			mv.addObject("isValid", isValid);
			System.out.println("id" + dto.getId());
			System.out.println("isValid가 true인데 " + isValid);
		} else {
			// 아이디 혹은 비밀번호가 틀린경우
			mv.addObject("msg", "아이디 혹은 비밀번호가 틀려요.");
			String location = request.getContextPath() + "/users/loginform.do?url=" + url;
			mv.addObject("url", location);
			System.out.println("isValid가 false인데 " + isValid);
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
	public ModelAndView getData(String id) {
		UsersDto dto =usersDao.getData(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("myDto", dto);
		return mv;
	}

	@Override
	public ModelAndView detail(String id) {
		UsersDto usersDto = usersDao.getData(id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("usersDto", usersDto);
		
		return mv;
	}

}
