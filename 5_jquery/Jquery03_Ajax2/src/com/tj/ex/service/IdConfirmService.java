package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.MembersDao;

public class IdConfirmService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		
		MembersDao mdao = new MembersDao();
		int result = mdao.confirmId(id);
		
		if (result == MembersDao.EXISTENCE){
			request.setAttribute("idConfirmMsg", "중복된 아이디 입니다.");
		} else {
			request.setAttribute("idConfirmMsg", "사용 가능한 아이디 입니다.");
		}
	}
}
