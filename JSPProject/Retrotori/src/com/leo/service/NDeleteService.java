package com.leo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.NoticeDao;

public class NDeleteService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		int nNum = Integer.parseInt(request.getParameter("nNum"));
		
		NoticeDao nDao = new NoticeDao();
		int result = nDao.deleteNotice(nNum);
		
		if (result == NoticeDao.SUCCESS) {
			System.out.println("공지사항 삭제 성공 : service");
			request.setAttribute("nDeleteResult", "공지사항이 삭제되었습니다.");
		} else {
			System.out.println("공지사항 삭제 실패 : service");
			request.setAttribute("nDeleteResult", "공지사항  삭제가 실패");
		}

	}

}
