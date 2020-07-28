package com.leo.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.NoticeDao;
import com.leo.dto.NoticeDto;

public class NWriteService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		int nNum = 0;
		String nTitle = request.getParameter("nTitle");
		String nContent = request.getParameter("nContent");
		String nAuthor = request.getParameter("nAuthor");
		Date nRdate = null;
				
		nContent.replace("\r\n","<br>");
		
		NoticeDto ndto = new NoticeDto(nNum, nTitle, nContent, nAuthor, nRdate);
		
		NoticeDao nDao = new NoticeDao();
		int result = nDao.insertNotice(ndto);
		
		if (result == NoticeDao.SUCCESS) {
			System.out.println("공지사항 입력 성공 : service");
			request.setAttribute("nInsertResult", "공지사항이 입력되었습니다.");
		} else {
			System.out.println("공지사항 입력 실패 : service");
			request.setAttribute("nInsertResult", "공지사항 쓰기가 실패");
		}
		
	}

}
