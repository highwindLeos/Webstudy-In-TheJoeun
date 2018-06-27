package com.tj.ex;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MembersAllService implements Service {

	@Override
	public ArrayList<MembersDto> excute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<MembersDto> members;
		
		MembersDao mdao = new MembersDao();
		members = mdao.getMembersAll();
		
		return members;
	}

}
