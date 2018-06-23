<%@page import="com.tj.ex.dto.FileboardDto"%>
<%@page import="com.tj.ex.dao.FileboardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%FileboardDao fbDao = FileboardDao.getInstance();
	FileboardDto fbDto = new FileboardDto();
	for(int i=0 ; i<110 ; i++){
		// writeForm.jsp에서 받아왔던 것
		if(i%3==0)
			fbDto.setCid("bbb");
		else if(i%3==1)
			fbDto.setCid("aaa");
		else
			fbDto.setCid("ccc");
		fbDto.setFsubject("홍길동"+i);
		if(i%2==0)
			fbDto.setFfilename("test.docx");
		else
			fbDto.setFfilename("test.xlsx");
		fbDto.setFcontent("테스트용글\n입니다");
		fbDto.setFpw("11");
		// writePro.jsp에서 추가한 내용
		fbDto.setFreadcount(i%12);
		fbDto.setFip(request.getRemoteAddr());
		fbDto.setFnum(0);
		fbDto.setFref(0);
		fbDto.setFre_level(0);
		fbDto.setFre_step(0);
		int result = fbDao.insertFileboard(fbDto);
		System.out.println(result==FileboardDao.SUCCESS? i+"번째성공":
												i+"번째 실패");
	}
	response.sendRedirect("fboardList.jsp");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>