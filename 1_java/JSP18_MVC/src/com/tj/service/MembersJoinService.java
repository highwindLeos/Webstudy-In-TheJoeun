package com.tj.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.dao.MembersDao;
import com.tj.dto.MembersDto;

public class MembersJoinService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		 String id = request.getParameter("id");
		 String pw  = request.getParameter("pw");
		 String name  = request.getParameter("name");
		 String email = request.getParameter("email");
		 Date birth = null;
		 if (request.getParameter("birth") != null) {
			 birth  = Date.valueOf(request.getParameter("birth")); 
		 }
		 
		 Date rDate = new Date(System.currentTimeMillis()) ;
		 String address = request.getParameter("address");
		 
		 MembersDao mDao = new MembersDao();
		 MembersDto newMember = new MembersDto(id, pw, name, email, birth, rDate, address);
		 
		 int result = mDao.joinMembers(newMember);
		 String joinResult = null;
		 
		 if (result == MembersDao.SUCCESS) {
			 joinResult = "회원가입 성공";
		 } else {
			 joinResult = "회원가입 실패";			 
		 }
		 
		 request.setAttribute("newMember", newMember);
		 request.setAttribute("joinResult", joinResult);
		 
	}

}
