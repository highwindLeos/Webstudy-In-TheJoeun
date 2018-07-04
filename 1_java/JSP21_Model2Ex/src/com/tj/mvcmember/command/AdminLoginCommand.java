package com.tj.mvcmember.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.mvcmember.dao.AdminDao;
import com.tj.mvcmember.dao.MemberDao;
import com.tj.mvcmember.dto.AdminDto;
import com.tj.mvcmember.dto.MemberDto;

public class AdminLoginCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {

		String aId = request.getParameter("aId");
		String aPw = request.getParameter("aPw");
		
		AdminDao adao = new AdminDao();
		
		int adminLoginResult = adao.confirmId(aId);
		
		if (adminLoginResult == AdminDao.LOGIN_SUCCESS) {
			System.out.println("관리자 로그인 성공 :  콘트롤러");
			HttpSession session = request.getSession();
			
			AdminDto adto = adao.getAdmin(aId);
			
			request.setAttribute("adminLoginResult", "관리자 로그인 성공했습니다.");
			request.setAttribute("requestAdto", adto);
			
			session.setAttribute("admin", adto);
			
		} else if (adminLoginResult == AdminDao.LOGIN_FAIL_ID) {
			request.setAttribute("adminLoginResult", "로그인 실패 : 아이디가 틀렸습니다.");

		} else if (adminLoginResult == AdminDao.LOGIN_FAIL_PW) {
			request.setAttribute("adminLoginResult", "로그인 실패 : 패스워드가 틀렸습니다.");
		}
		
		
	}

}
