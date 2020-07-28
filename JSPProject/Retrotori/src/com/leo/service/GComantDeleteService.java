package com.leo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.ComantDao;

public class GComantDeleteService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {

		String gId = request.getParameter("gId");
		int cNum = Integer.parseInt(request.getParameter("cNum"));

		ComantDao cDto = ComantDao.getInstance();
		int deleteResult = cDto.deleteComant(cNum);
		
		if (deleteResult == ComantDao.SUCCESS) {
			System.out.println("코멘트 삭제 성공 : service");
			request.setAttribute("comantDeleteResult", "코멘트 삭제되었습니다.");
		} else {
			System.out.println("코멘트 쓰기 실패 : service");			
		}
		

	}

}
