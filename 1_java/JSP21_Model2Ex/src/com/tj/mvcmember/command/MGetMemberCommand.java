package com.tj.mvcmember.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.mvcmember.dao.MemberDao;
import com.tj.mvcmember.dto.MemberDto;

public class MGetMemberCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String mId = request.getParameter("mId");
		
		MemberDao mDao = new MemberDao();
		MemberDto memberDto = mDao.getMember(mId);
		
		request.setAttribute("memberDto", memberDto);
	}

}
