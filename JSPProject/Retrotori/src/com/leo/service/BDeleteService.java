package com.leo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.BoardDao;
import com.leo.dao.NoticeDao;

public class BDeleteService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		 // String pageNum = request.getParameter("pageNum");
		 int bNum = Integer.parseInt(request.getParameter("bNum"));
			
			BoardDao bDao = BoardDao.getInstance();
			int result = bDao.deleteBoard(bNum);
			
			if (result == BoardDao.SUCCESS) {
				System.out.println("게시글 삭제 성공 : service");
				request.setAttribute("bDeleteResult", "게시글이 삭제되었습니다.");
			} else {
				System.out.println("게시글 삭제 실패 : service");
				request.setAttribute("bDeleteResult", "게시글이  삭제가 실패");
			}

	}

}
