package com.tj.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex5")
public class Ex5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String encodingUTF8 = "utf-8";
       
    public Ex5() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출됨");
		String[] colorSet = {"red", "orange", "yellow", "green", "blue", "navy", "violet"};
		int i; // 배경색은 넘어온 파라미터, 글자색은 colorSet[i] 가 될 예정
		String color = request.getParameter("color");
		
		System.out.println(color);
		
		for (i = 0; i < colorSet.length; i++) {
			if(colorSet[i].equals(color)) {
				break;
			}
		} // 입력된 값과 같은 색상이 있는 배열의 인덱스를 가지고 i가 설정되고 반복문 탈출.
		
		if(i == 0) {
			i = 6;
		} else {
			i--;
		} // i가 red 의 인덱스인 0 일때는 보라색인 6, 나머지는 선택한 색의 이전 색상의 인덱스로 설정한다.
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>배경색 글자색 변경</title>");
		out.println("<style>");
		out.println("body { background-color : " + color + "; }");
		out.println("h3 { color : " + colorSet[i] + "; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>글자색은 "+ colorSet[i] + " 배경색은 " + color + " 입니다.</h3>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(encodingUTF8); //포스트 방식의 한글이 깨짐을 utf-8 인코딩한다.
		System.out.println("doPOST() 호출됨");
		String[] colorSet = {"red", "orange", "yellow", "green", "blue", "navy", "violet"};
		int i; // 배경색은 넘어온 파라미터, 글자색은 colorSet[i] 가 될 예정
		int backgroundIdx = Integer.parseInt(request.getParameter("color"));
		
		System.out.println(backgroundIdx);
		
		if(backgroundIdx == 0) {
			backgroundIdx = 6;
		} else {
			backgroundIdx--;
		} // i가 red 의 인덱스인 0 일때는 보라색인 6, 나머지는 선택한 색의 이전 색상의 인덱스로 설정한다.
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>배경색 글자색 변경</title>");
		out.println("<style>");
		out.println("body { background-color : " + backgroundIdx + "; }");
		out.println("h3 { color : " + colorSet[backgroundIdx] + "; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>글자색은 "+ colorSet[backgroundIdx] + " 배경색은 " + backgroundIdx + " 입니다.</h3>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
