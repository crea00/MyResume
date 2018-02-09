package com.project.myresume.cafe.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.cafe.dao.CafeDao;
import com.project.myresume.cafe.dto.CafeDto;
import com.project.myresume.users.dao.UsersDao;

@Service
public class CafeServiceImpl implements CafeService {

	@Autowired
	private CafeDao cafeDao;

	// 한 페이지에 나타낼 로우의 갯수
	private static final int PAGE_ROW_COUNT = 5;
	private static final int PAGE_DISPLAY_COUNT = 5;
	
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
		// 검색과 관련된 파라미터 읽어오기
		String keyword = request.getParameter("keyword");
		String condition = request.getParameter("condition");
		
		ModelAndView mv = new ModelAndView();
		CafeDto dto = new CafeDto();
		
		// 키워드가 전달된 경우 검색
		if(keyword != null){
			if(condition.equals("titlecontent")){	// 제목 + 내용 검색
				dto.setTitle(keyword);
				dto.setContent(keyword);
			} else if(condition.equals("title")){	// 제목 검색
				dto.setTitle(keyword);
			} else if(condition.equals("content")){	// 내용 검색
				dto.setContent(keyword);
			}
		}
		mv.addObject("condition", condition);
		mv.addObject("keyword", keyword);
		
		// 보여줄 페이지의 번호
		int pageNum = 1;
		// 보여줄 페이지의 번호가 파라미터로 전달되는지 읽어온다
		String strPageNum = request.getParameter("pageNum");
		// 페이지 번호가 넘어오면 페이지 번호 설정
		if(strPageNum != null){
			pageNum = Integer.parseInt(strPageNum);
		}
		// 보여줄 페이지 데이터의 시작 ResultSet row 번호
		int startRowNum = 1+(pageNum-1)*PAGE_ROW_COUNT;
		// 보여줄 페이지 데이터의 끝 ResultSet row 번호
		int endRowNum = pageNum * PAGE_ROW_COUNT;
		// 전체 row의 갯수를 DB에서 얻어온다
		int totalRow = cafeDao.getCount(dto);
		// 전체 페이지의 갯수 구하기
		int totalPageCount = (int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		// 시작 페이지 번호
		int startPageNum = 1+((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		// 끝 페이지 번호
		int endPageNum = startPageNum+PAGE_DISPLAY_COUNT-1;
		// 끝 페이지 번호가 잘못된 값이라면 보정해준다.
		if(totalPageCount < endPageNum){
			endPageNum = totalPageCount;
		}
		
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
			
		List<CafeDto> list = cafeDao.getList(dto);
	
		mv.addObject("list", list);
		mv.addObject("pageNum", pageNum);
		mv.addObject("startPageNum", startPageNum);
		mv.addObject("endPageNum", endPageNum);
		mv.addObject("totalPageCount", totalPageCount);
		return mv;
	}
	
	// 글 자세히보기
	@Override
	public ModelAndView detail(HttpServletRequest request) {
		// 검색과 관련된 파라미터를 읽어온다.
		String keyword = request.getParameter("keyword");
		String condition = request.getParameter("condition");
		System.out.println("keyword, condition" + keyword + condition);
		
		String msg = null;
		ModelAndView mv = new ModelAndView();
		CafeDto dto = new CafeDto();
		
		// 검색어가 전달된 경우
		if(keyword != null){
			// 제목 검색
			if(condition.equals("title")){
				dto.setTitle(keyword);
				msg = "키워드 : " + keyword + "에 대한 제목 검색결과";
				// 내용 검색
			} else if(condition.equals("content")){
				dto.setContent(keyword);
				msg = "키워드 : " + keyword + "에 대한 내용 검색결과";
			}
		}
		mv.addObject("condition", condition);
		mv.addObject("keyword", keyword);
		mv.addObject("msg", msg);
		
		// 파라미터로 전달되는 글번호를 읽어와서
		int num = Integer.parseInt(request.getParameter("num"));
		// dto에 담고
		dto.setNum(num);
		// 글의 조회수를 1 올린다	
		cafeDao.increaseViewCount(num);
		

		// 글번호에 해당하는 글정보 읽어온다.
		CafeDto resultDto = cafeDao.getData(dto);
		
		mv.addObject("dto", resultDto);
		return mv;
	}

	
	// 단순히 글 정보 출력
	@Override
	public ModelAndView detail(int num) {
		CafeDto dto = cafeDao.getData(num);
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		return mv;
	}
	

	@Override
	public void update(CafeDto dto) {
		cafeDao.update(dto);
	}



}
