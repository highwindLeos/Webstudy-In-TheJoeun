package com.tj.mvcmember.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.mvcmember.dao.MemberDao;
import com.tj.mvcmember.dto.MemberDto;

public class MLoginCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		
		MemberDao mdao = new MemberDao();
		int checkResult = mdao.loginCheck(mId, mPw);
		
		if (checkResult == MemberDao.LOGIN_SUCCESS) {
			System.out.println("로그인 성공 : servlet");
			HttpSession session = request.getSession();
			
			MemberDto mdto = mdao.getMember(mId);
			
			request.setAttribute("checkResult", checkResult);
			request.setAttribute("requestMdto", mdto);
			
			session.setAttribute("loginOk", "ok");
			session.setAttribute("mId", mdto.getmId());
			session.setAttribute("mPw", mdto.getmPw());
			session.setAttribute("mName", mdto.getmName());
			session.setAttribute("sessionMdto", mdto);
			
		} else if (checkResult == MemberDao.LOGIN_FAIL_ID) {
			System.out.println("로그인 실패 : servlet");
			request.setAttribute("checkResult", "아이디 틀림");

		} else if (checkResult == MemberDao.LOGIN_FAIL_PW) {
			System.out.println("로그인 실패 : servlet");
			request.setAttribute("checkResult", "패스워드 틀림");
		}
		
	}

}
