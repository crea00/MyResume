package com.project.myresume.users.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.profile.dao.SkillsDao;
import com.project.myresume.users.dao.UsersDao;
import com.project.myresume.users.dto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao usersDao;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private SkillsDao skDao;

	@Override
	public ModelAndView signup(UsersDto dto) {
		// 입력한 비밀번호를 암호화된 문자열로 얻어낸다.
		String hashPwd = encoder.encode(dto.getPassword());
		// Dto에 다시 넣어준다.
		dto.setPassword(hashPwd);
		// Dao를 이용해서 Db에 저장
		usersDao.insert(dto);

		// id를 ModelAndView객체에 담아서 리턴한다.
		ModelAndView mv = new ModelAndView();
		mv.addObject("resultDto", dto);
		mv.addObject("msg", "회원가입 되었습니다, 로그인해주세요.");
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
		// 아이디, 비밀번호가 유효한지 여부
		boolean isValid = false;

		if (resultDto != null) {
			// DB에 입력한 아이디가 존재한다면 비밀번호를 확인한다.
			boolean isMatch = encoder.matches(dto.getPassword(), resultDto.getPassword());
			if (isMatch) {
				// 아이디가 존재하고 비밀번호가 맞다면 true를 리턴한다.
				isValid = true;
			}
		}

		// 원래 이동해야할 url
		String url = request.getParameter("url");
		System.out.println("원래 이동할 url" + url);

		ModelAndView mv = new ModelAndView();
		if (isValid) {
			// 만약 아이디와 비밀번호가 일치한다면 로그인 처리
			request.getSession().setAttribute("id", dto.getId());
			request.getSession().setAttribute("myDto", usersDao.getData(dto.getId()));

			mv.addObject("msg", dto.getId() + "님 로그인되었습니다.");
			mv.addObject("resultDto", resultDto);
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
		// 입력한 비밀번호를 암호화된 문자열로 얻어낸다.
		String hashPwd = encoder.encode(dto.getPassword());
		// Dto에 다시 넣어준다.
		dto.setPassword(hashPwd);
		usersDao.update(dto);

	}

	@Override
	public ModelAndView delete(HttpSession session) {
		// 세션을 이용해서 id값을 얻어온다.
		String id = (String) session.getAttribute("id");
		// DB에서 아이디를 삭제하고 탈퇴와 동시에 로그아웃되도록 세션초기화
		usersDao.delete(id);
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "회원탈퇴되었습니다.");
		return mv;
	}

	// 회원 한명의 정보 리턴
	@Override
	public UsersDto getData(String id) {
		UsersDto dto = usersDao.getData(id);
		return dto;
	}

	// 회원 전체의 정보 리턴
	@Override
	public ModelAndView getList(HttpServletRequest request) {
		List<UsersDto> list = usersDao.getList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("userList", list);

		return mv;
	}

	@Override
	public void increaseViewCount(String id) {
	
	}

	@Override
	public List<String> search(String keyword) {
		System.out.println(keyword);
		System.out.println(usersDao.search(keyword));
		return usersDao.search(keyword);
	}

	@Override
	public boolean canUseEmail(String email) {
		boolean canUseEmail=usersDao.canUseEmail(email);
		return canUseEmail;
	}

}
