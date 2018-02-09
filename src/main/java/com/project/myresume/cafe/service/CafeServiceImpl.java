package com.project.myresume.cafe.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.cafe.dao.CafeDao;
import com.project.myresume.cafe.dto.CafeDto;

@Service
public class CafeServiceImpl implements CafeService {

	@Autowired
	private CafeDao cafeDao;
	
	// 글 입력
	@Override
	public void insert(CafeDto dto) {
		cafeDao.insert(dto);		
	}
	
	// 글 삭제
	@Override
	public void delete(int num) {
		cafeDao.delete(num);
	}

	// 글목록 출력
	@Override
	public ModelAndView list(HttpServletRequest request) {
		CafeDto dto = new CafeDto();
		List<CafeDto> list = cafeDao.getList(dto);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		System.out.println(list);
		return mv;
	}
	
	// 글 자세히보기
	@Override
	public ModelAndView detail(int num) {
		CafeDto dto = cafeDao.getData(num);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		return mv;
	}

	
	@Override
	public ModelAndView detail(CafeDto dto) {
		return null;
	}

	@Override
	public void update(CafeDto dto) {
		cafeDao.update(dto);
	}



}
