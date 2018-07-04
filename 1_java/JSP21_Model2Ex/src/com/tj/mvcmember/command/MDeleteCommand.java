package com.tj.mvcmember.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.mvcmember.dao.MemberDao;

public class MDeleteCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();		
		
		String mId = (String)session.getAttribute("mId");
		String mPw = (String)session.getAttribute("mPw");
		
		MemberDao mDao = new MemberDao();
		int deleteResult = mDao.deleteMember(mId, mPw);
		
		if (deleteResult == MemberDao.SUCCESS) {
			System.out.println("삭제성공");
			session.invalidate(); 
			request.setAttribute("deleteResult", "회원 탈퇴성공했습니다");
		} else  {
			System.out.println("회원탈퇴 실패");
		}
		
		
	}

}
