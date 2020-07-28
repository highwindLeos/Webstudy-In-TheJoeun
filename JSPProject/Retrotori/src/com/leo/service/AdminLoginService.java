package com.leo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.leo.dao.AdminDao;
import com.leo.dao.MemberDao;
import com.leo.dto.AdminDto;
import com.leo.dto.MemberDto;

public class AdminLoginService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String aId = request.getParameter("aId");
		String aPw = request.getParameter("aPw");
		
		AdminDao aDao = new AdminDao();
		int checkResult = aDao.adminLoginCheck(aId, aPw);
		
		if (checkResult == MemberDao.LOGIN_SUCCESS) {
			System.out.println("로그인 성공: servlet");
			HttpSession session = request.getSession();
			
			AdminDto adto = aDao.getAdmin(aId);
			
			request.setAttribute("checkResult", "관리자 로그인 : "+ adto.getaName()+"님 어서오세요.");
			request.setAttribute("requestAdto", adto);
			
			session.setAttribute("adminOk", "ok");
			session.setAttribute("sessionAdto", adto);
			
		} else if (checkResult == MemberDao.LOGIN_FAIL_ID) {
			System.out.println("관리자 로그인 실패 아이디  : servlet");
			request.setAttribute("checkResult", "관리자 아이디 가 존재하지 않습니다.");

		} else if (checkResult == MemberDao.LOGIN_FAIL_PW) {
			System.out.println("관리자 로그인 실패 패스워드: servlet");
			request.setAttribute("checkResult", "관리자 패스워드가 틀렸습니다.");
		}

	}

}
