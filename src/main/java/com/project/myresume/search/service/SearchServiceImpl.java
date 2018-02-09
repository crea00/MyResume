package com.project.myresume.search.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;


import com.project.myresume.search.dao.SearchDao;
import com.project.myresume.search.dto.SearchDto;
import com.project.myresume.users.dao.UsersDao;
import com.project.myresume.users.dto.UsersDto;
@Service
public class SearchServiceImpl implements SearchService{

	@Autowired
	private SearchDao dao;
	
	@Autowired UsersDao usersDao;
	
	//한 페이지에 나타낼 로우의 갯수
	private static final int PAGE_ROW_COUNT=3;
	//하단 디스플레이 페이지 갯수
	private static final int PAGE_DISPLAY_COUNT=5;
	
	@Override
	public ModelAndView search(SearchDto dto, HttpServletRequest request) {

				//ModelAndView 객체 생성 (request 에 담을 내용을 여기에 담는다.)
				ModelAndView mView=new ModelAndView();
				//보여줄 페이지의 번호
				int pageNum=1;
				//보여줄 페이지의 번호가 파라미터로 전달되는지 읽어온다.
				String strPageNum=request.getParameter("pageNum");
				if(strPageNum != null){//페이지 번호가 파라미터로 넘어온다면
					//페이지 번호를 설정한다.
					pageNum=Integer.parseInt(strPageNum);
				}
				//보여줄 페이지 데이터의 시작 ResultSet row 번호
				int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
				//보여줄 페이지 데이터의 끝 ResultSet row 번호
				int endRowNum=pageNum*PAGE_ROW_COUNT;
				//전체 row 의 갯수를 DB 에서 얻어온다.
				int totalRow = dao.getCount(dto);
				
				//전체 페이지의 갯수 구하기
				int totalPageCount=
						(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
				//시작 페이지 번호
				int startPageNum=
					1+((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
				//끝 페이지 번호
				int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
				//끝 페이지 번호가 잘못된 값이라면 
				if(totalPageCount < endPageNum){
					endPageNum=totalPageCount; //보정해준다. 
				}
				
				dto.setStartRowNum(startRowNum);
				dto.setEndRowNum(endRowNum);
				System.out.println("써치"+dao.search(dto));
				List<String> list = dao.search(dto);
				List<UsersDto> searchList = new ArrayList<>();
				UsersDto usersDto = new UsersDto();
				for(String id : list) {
					usersDto =usersDao.getData(id);
					searchList.add(usersDto);
				}
				
				// 현재 페이지 번호 
				mView.addObject("searchList", searchList);
				mView.addObject("pageNum", pageNum);
				mView.addObject("startPageNum", startPageNum);
				mView.addObject("endPageNum", endPageNum);
				// 전체 페이지의 갯수
				mView.addObject("totalPageCount", totalPageCount);
				System.out.println("토탈로우"+totalRow);
				System.out.println("스타트로우"+startRowNum);
				System.out.println("엔드로우"+endRowNum);
				System.out.println("페이지넘"+pageNum);
				System.out.println("스타트페이지넘"+startPageNum);
				System.out.println("엔드페이지넘"+endPageNum);
				System.out.println("토탈페이지 카운트"+totalPageCount);				
				
		return mView;
	}

	@Override
	public List<String> idList(SearchDto dto) {

		List<String> list=dao.search(dto);
		System.out.println(list);
		System.out.println("길이는"+list.size());
		return list;
	}

}
