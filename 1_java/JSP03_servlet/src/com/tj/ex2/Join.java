package com.tj.ex2;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String encodingUTF8 = "utf-8";

       
    public Join() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출됨");
		
		 Enumeration<String> params = request.getParameterNames();
		 while (params.hasMoreElements()) {
			 System.out.println(params.nextElement());
		 }
		
		String hiddenParam = request.getParameter("hiddenParam"); // 히든 인풋 태그
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String birth = request.getParameter("birth");
//		Date birthDay = Date.valueOf(birth);
		String[] hobby = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String[] mailring = request.getParameterValues("mailring");
		
//		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birth);
		
		String hobbyTemp = "";
		for (int i = 0; i < hobby.length; i++) {
			hobbyTemp += hobby[i]+ ", ";
		}
		
		String mailringTemp = "";
		for (int i = 0; i < mailring.length; i++) {
			mailringTemp +=  mailring[i] + ", ";
		}
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("table { background-color : #fff; border : 1px solid #D4A190; margin: 0 auto;}");
		out.println("table tr td { width : 450px; background-color : #fff; text-align : center; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr><td><h1>회원가입 정보</h1></td></tr>");
		out.println("<tr><td><hr></tr></td>");
		out.println("<tr><td><h2>hiddenParam : "+ hiddenParam +"</h2></td></tr>");
		out.println("<tr><td><h2>이 름 : "+ name +"</h2></td></tr>");
		out.println("<tr><td><h2>아이디 : "+ id +"</h2></td></tr>");
//		out.println("<tr><td><h2>비밀번호 : "+ password +"</h2></td></tr>");
		out.println("<tr><td><h2>비밀번호 : ");
			for(int i =0; i < password.length() ; i++) {
				out.println("*");
			}
		out.println("</h2></td></tr>");
		out.println("<tr><td><h2>생년월일 : "+ birth +"</h2></td></tr>");
//		out.println("<tr><td><h2>취 미 : "+ hobbyTemp +"</h2></td></tr>");
		out.println("<tr><td><h2>취 미 : ");
			if(hobby != null) {
				for(int i = 0; i < hobby.length; i++) {
					if (i == hobby.length - 1) {
						out.println(hobby[i]);
					} else {
						out.println(hobby[i] + ", ");
					}
				}
				out.println("</h2>");
			} else {
				out.println("선택한 취미 없음 </h2> ");
			}
		out.println("</td></tr>");
		out.println("<tr><td><h2>성 별 : "+ gender +"</h2></td></tr>");
		out.println("<tr><td><h2>이메일 : "+ email +"</h2></td></tr>");
//		out.println("<tr><td><h2>메일수신동의 : "+ mailringTemp +"</h2></td></tr>");
		out.println("<tr><td><h2>메일수신동의 : ");
			if(mailring == null) {
				out.println("모두 수신거부 </h2>");
			} else { // 메일수신 동의
				for (int i = 0; i < mailring.length;  i++) {
					if(i == mailring.length - 1) {
					out.println(mailring[i] + "</h2>");	
					} else {
						out.println(mailring[i] + ", ");
					}
				}
			}
		out.println("</h2></td></tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(encodingUTF8); //포스트 방식의 한글이 깨짐을 utf-8 인코딩한다.
		doGet(request, response);
	} // POST 로 요청이 와도 결국 doGET 에서 처리하게 된다.border : none;

}
