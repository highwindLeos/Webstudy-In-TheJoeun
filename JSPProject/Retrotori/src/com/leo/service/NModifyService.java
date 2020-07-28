package com.leo.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.NoticeDao;
import com.leo.dto.NoticeDto;

public class NModifyService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		int nNum = Integer.parseInt(request.getParameter("nNum"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		String nTitle = request.getParameter("nTitle");
		String nContent = request.getParameter("nContent");
		String nAuthor = request.getParameter("nAuthor");
		Date nRdate = null;
		
		nContent.replace("\r\n","<br>");
		
		NoticeDto ndto = new NoticeDto(nNum, nTitle, nContent, nAuthor, nRdate);
		
		NoticeDao nDao = new NoticeDao();
		int result = nDao.modifyNotice(ndto);
		
		if (result == NoticeDao.SUCCESS) {
			System.out.println("공지사항 수정 성공 : service");
			
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("nModifyResult", "공지사항이 수정되었습니다.");
		} else {
			System.out.println("공지사항 입력 실패 : service");
			request.setAttribute("nModifyResult", "공지사항  수정이 실패");
		}

	}

}
