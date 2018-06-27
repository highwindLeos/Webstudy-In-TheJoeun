package com.tj.ex;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
	
	public ArrayList<MembersDto> excute(HttpServletRequest request, HttpServletResponse response);

}
