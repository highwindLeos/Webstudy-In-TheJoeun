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
			System.out.println("È¸¿ø Å»Åð ¼º°ø : c");
			session.invalidate(); // ¼¼¼Ç »èÁ¦
			request.setAttribute("deleteResult", "È¸¿ø Å»Åð µÇ¾ú½À´Ï´Ù.");
		} else  {
			System.out.println("È¸¿ø Å»Åð ½ÇÆÐ : c");
		}
		
		
	}

}
