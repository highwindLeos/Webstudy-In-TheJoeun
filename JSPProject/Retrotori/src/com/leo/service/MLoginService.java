package com.leo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.leo.dao.MemberDao;
import com.leo.dto.MemberDto;

public class MLoginService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		
		MemberDao mdao = new MemberDao();
		int checkResult = mdao.loginCheck(mId, mPw);
		
		if (checkResult == MemberDao.LOGIN_SUCCESS) {
			System.out.println("로그인 성공: servlet");
			HttpSession session = request.getSession();
			
			MemberDto mdto = mdao.getMember(mId);
			
			request.setAttribute("checkResult", mdto.getmName()+"님 어서오세요.");
			request.setAttribute("requestMdto", mdto);
			
			session.setAttribute("loginOk", "ok");
			session.setAttribute("sessionMdto", mdto);
			
		} else if (checkResult == MemberDao.LOGIN_FAIL_ID) {
			System.out.println("로그인 실패 아이디  : servlet");
			request.setAttribute("checkResult", "아이디 가 존재하지 않습니다.");

		} else if (checkResult == MemberDao.LOGIN_FAIL_PW) {
			System.out.println("로그인 실패 패스워드: servlet");
			request.setAttribute("checkResult", "패스워드가 틀렸습니다.");
		}
	}

}
