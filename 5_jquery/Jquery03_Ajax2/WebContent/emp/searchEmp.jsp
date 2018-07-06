
<%@page import="com.tj.ex.dto.EmpDto"%>
<%@page import="com.tj.ex.dao.EmpDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="" rel="stylesheet">
	<title>Title</title>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<style></style>
	<script></script>
	</head>
<body>
<c:if test="${emps != null}">
<table>
		<tr>
			<td colspan="9"></td>
		</tr>
		<tr>
			<td>사번</td>
			<td>사원명</td>
			<td>직책</td>
			<td>관리자 번호</td>
			<td>입사일</td>
			<td>급여</td>
			<td>보너스</td>
			<td>연봉</td>
			<td>부서 번호</td>
		</tr>
	<c:forEach var="emp" items="${emps }">
		<tr>
			<td>${emp.empno }</td>
			<td>${emp.ename }</td>
			<td>${emp.job }</td>
			<td>${emp.mgr }</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${emp.hiredate }"/></td>
			<td><fmt:formatNumber pattern="#,###,###.0" value="${emp.sal }" /></td>
			<td><fmt:formatNumber pattern="#,###,###.0" value="${emp.comm }" /></td>
			<td><fmt:formatNumber pattern="#,###,###.0" value="${(emp.sal * 12) + emp.comm }" /></td>
			<td>${emp.deptno }</td>
		</tr>
	</c:forEach>
		<tr>
			<td colspan="9">총 ${emps.size() } 명 출력 되었습니다.</td>
		</tr>
	</table>
</c:if>	
<c:if test="${emps == null}">
	<table>
		<tr>
			<td>데이터가 없습니다.</td>
		</tr>
	</table>
</c:if>
</body>
</html>