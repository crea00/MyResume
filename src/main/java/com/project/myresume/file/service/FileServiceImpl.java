package com.project.myresume.file.service;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.myresume.file.dao.FileDao;
import com.project.myresume.file.dto.FileDto;

@Service
public class FileServiceImpl implements FileService{

	@Autowired
	private FileDao fileDao;
	
	@Override
	public void insert(HttpServletRequest request, FileDto dto) {
		
		//삭제할 파일의 아이디를 읽어와서 삭제하고 새로운 사진 삽입하기
		HttpSession session = request.getSession();
		String id =(String)session.getAttribute("id");
		
		//1. 삭제할 파일의 저장된 파일명을 읽어온다.
		FileDto deleteDto=fileDao.getData(id);
		if(deleteDto!=null) {
			String saveFileName=deleteDto.getSaveFileName();
			//2. DB 에서 파일 정보 삭제
			fileDao.delete(id);
			//3. 파일 시스템에서 삭제 
			ServletContext application=request.getServletContext();
			//삭제할 파일의 절대 경로 구성하기 
			
			String path=application.getRealPath("/upload")+
	 		File.separator+saveFileName;
			//File 객체생성해서 삭제하기 
			new File(path).delete();
		}
		
		//파일을 저장할 폴더의 절대 경로를 얻어온다.
				String realPath=request.getSession()
						.getServletContext().getRealPath("/upload");
				//콘솔에 경로 출력해보기
				System.out.println(realPath);
				
				//MultipartFile 객체의 참조값 얻어오기
				//FileDto 에 담긴 MultipartFile 객체의 참조값을 얻어온다.
				MultipartFile mFile=dto.getFile();
				//원본 파일명
				String orgFileName=mFile.getOriginalFilename();
				//파일 사이즈
				long fileSize=mFile.getSize();
				//저장할 파일의 상세 경로
				String filePath=realPath+File.separator;
				//디렉토리를 만들 파일 객체 생성
				File file=new File(filePath);
				if(!file.exists()){//디렉토리가 존재하지 않는다면
					file.mkdir();//디렉토리를 만든다.
				}
				//파일 시스템에 저장할 파일명을 만든다. (겹치치 않게)
				String saveFileName=System.currentTimeMillis()+orgFileName;
				try{
					//upload 폴더에 파일을 저장한다.
					mFile.transferTo(new File(filePath+saveFileName));
				}catch(Exception e){
					e.printStackTrace();
				}
				//FileDto 객체에 추가 정보를 담는다.
				dto.setOrgFileName(orgFileName);
				dto.setSaveFileName(saveFileName);
				dto.setFileSize(fileSize);
				
				//FileDto 객체에 작성자 정보를 담는다.
				dto.setId(id);
				
				//FileDao 객체를 이용해서 DB 에 저장하기
				fileDao.insert(dto);	
		
	}

	@Override
	public void delete(HttpServletRequest request, String id) {
		//삭제할 파일의 정보를 얻어온다.
		FileDto dto=fileDao.getData(id);
		//1. 파일 시스템에서 물리적인 삭제
		String path=
			request.getServletContext().getRealPath("/upload")+
			File.separator+dto.getSaveFileName();
		try{
			new File(path).delete();
		}catch(Exception e){}
		//2. DB 에서 파일 정보 삭제
		fileDao.delete(id);
		
	}

	@Override
	public ModelAndView getData(String id) {
		//Dao 를 이용해서 파일 정보를 얻어와서 
		FileDto dto=fileDao.getData(id);
		//ModelAndView 객체에 담아서 
		ModelAndView mView=new ModelAndView();
		mView.addObject("myDto", dto);
		//리턴한다. 
		return mView;
	}

}
