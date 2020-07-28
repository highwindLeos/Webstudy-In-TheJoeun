package com.leo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.leo.dao.MemberDao;

public class MDeleteService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {

		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		
		MemberDao mDao = new MemberDao();
		int deleteResult = mDao.deleteMember(mId, mPw);
		
		if (deleteResult == MemberDao.SUCCESS) {
			System.out.println("회원 탈퇴 성공 : service");
			HttpSession session = request.getSession();
			session.invalidate();
			
			request.setAttribute("memberDeleteResult", "회원탈퇴 처리되었습니다.");		
		} else {
			System.out.println("회원 탈퇴 실패 : service");			
		}

	}

}
