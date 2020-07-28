package com.leo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.ComantDao;

public class GComantService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String gId = request.getParameter("gId");
		String mId = request.getParameter("mId");
		
		String comant = request.getParameter("comant");		

		ComantDao cDto = ComantDao.getInstance();
		int comantResult = cDto.insertComant(gId, mId, comant);
		
		if (comantResult == ComantDao.SUCCESS) {
			System.out.println("코멘트 쓰기 성공 : service");
			request.setAttribute("comantWriteResult", "코멘트 입력되었습니다. : " + gId + " 글");
		} else {
			System.out.println("코멘트 쓰기 실패 : service");			
		}

	}

}
