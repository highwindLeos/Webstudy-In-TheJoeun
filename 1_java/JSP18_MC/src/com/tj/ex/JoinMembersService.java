package com.tj.ex;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JoinMembersService implements Service {

	@Override
	public ArrayList<MembersDto> excute(HttpServletRequest request, HttpServletResponse response) {
		 String id = request.getParameter("id");
		 String pw = request.getParameter("pw");
		 String name = request.getParameter("name");
		 String email = request.getParameter("email");
		 Date birth = null;
		 if (request.getParameter("birth") != null) {
			 birth = Date.valueOf(request.getParameter("birth")); // 문자열을 시간형으로 변환
		 }
		 Date rdate = new Date(System.currentTimeMillis()); 
		 String address = request.getParameter("address");
		 
		 MembersDto newMember = new MembersDto(id, pw, name, email, birth, rdate, address);
		 
		 MembersDao mDao = new MembersDao();
		 int result = mDao.joinMembers(newMember);
		 request.setAttribute("joinResult", result); // ${joinResult }
		 
		return null;
	}

}
