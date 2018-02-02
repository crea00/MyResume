package com.project.myresume.users.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.users.dao.UsersDao;
import com.project.myresume.users.dto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao usersDao;
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public ModelAndView signup(UsersDto dto) {
		// 입력한 비밀번호를 암호화된 문자열로 얻어낸다.
		String hashPwd = encoder.encode(dto.getpassword());
		// Dto에 다시 넣어준다.
		dto.setpassword(hashPwd);
		// Dao를 이용해서 Db에 저장
		usersDao.insert(dto);
		
		// id를 ModelAndView객체에 담아서 리턴한다.
		ModelAndView mv = new ModelAndView();
		mv.addObject("resultDto", dto);
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
	public String login(UsersDto dto, HttpServletRequest request) {
		// 입력한 아이디를 이용해서 가입된 회원정보가 있는지 select
		UsersDto resultDto = usersDao.getData(dto.getId());
		String url="";
		//아이디, 비밀번호가 유효한지 여부
		boolean isValid = false;
		
		if(resultDto != null){
			boolean isMatch = true;
			if(isMatch){
				isValid = true;
			}
		}

		
		if(isValid){
			// 만약 아이디와 비밀번호가 일치한다면 로그인 처리
			request.getSession().setAttribute("id", dto.getId());
			request.getSession().setAttribute("myDto", usersDao.getData(dto.getId()));
			url= "redirect:/home.do";


		} else {
			// 아이디 혹은 비밀번호가 틀린경우
			request.setAttribute("msg", "아이디 혹은 비밀번호가 틀려요.");
			url= "users/loginform";

		}
		return url;
	}

	@Override
	public void update(UsersDto dto) {
		usersDao.update(dto);
		
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
	public UsersDto getData(String id) {
		UsersDto dto =usersDao.getData(id);
		return dto;
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
