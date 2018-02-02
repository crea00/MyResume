package com.project.myresume.users.service;

import java.util.List;

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
		// Dao가 리턴해주는 값을
		boolean canUseId = usersDao.canUseId(id);
		// 리턴해준다.
		return canUseId;
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
			request.getSession().setAttribute("myDto", usersDao.getData(dto.getId()));
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
		// 세션을 이용해서 id값을 얻어온다.
		String id = (String)session.getAttribute("id");
		// DB에서 아이디를 삭제하고 탈퇴와 동시에 로그아웃되도록 세션초기화
		usersDao.delete(id);					
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		return mv;
	}

	//회원 한명의 정보 리턴
	@Override
	public ModelAndView getData(String id) {
		UsersDto dto =usersDao.getData(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("myDto", dto);
		mv.addObject("resumeDto", dto);
		return mv;
	}

	//회원 전체의 정보 리턴
	@Override
	public ModelAndView getList() {
		List<UsersDto> list = usersDao.getList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("userList", list);

		return mv;
	}


}
