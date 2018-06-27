
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:requestEncoding value="utf-8"/>
<%-- <c:set var="conPath" value="<%= request.getContextPath() %>" /> --%>
<c:set var="conPath" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>EMP</title>
	<link rel="stylesheet" href="${ conPath }/css/board.css">
	<script>
		
	</script>
</head>
<body>
<div id="wrap">
	<table>
		<tr>
			<td colspan="9"><h1>사원테이블</h1></td>
		</tr>
		<tr>
			<td colspan="5">
				<form action="${ conPath }/EMPSeach" method="POST">
					<p>사원명 : <input type="text" name="ename" value="${ fn:toUpperCase(ename) }" /></p>
					<p>직책명 : <input type="text" name="job" value="${ fn:toUpperCase(job) }"/></p>
					<p><input type="submit" value="검색" /></p>
				</form>
			</td>
			<td colspan="4">
				<form action="${ conPath }/EMPSal" method="POST">
					<p>월급여 검색 (해당 급여 이상인 사원) : </p> 
					<p><input type="number" name="sal" value="${ sal }" required="required"/></p>
					<p><input type="submit" value="급여검색" /></p>
				</form>
			</td>
		</tr>
		<tr>
			<td>사번</td>
			<td>사원명</td>
			<td>직책</td>
			<td>상사번호</td>
			<td>입사일</td>
			<td>월 급여</td>
			<td>상여금</td>
			<td>연봉</td>
			<td>부서번호</td>
		</tr>
		<c:forEach var="etemp" items="${ emps }" >
		<tr>
			<td>${ etemp.empno }</td>
			<td>${ etemp.ename }</td>
			<td>${ etemp.job }</td>
			<td>${ etemp.mgr eq 0 ? "상사없음" : etemp.mgr }</td>
			<td><fmt:formatDate value="${etemp.hiredate }" type="both" pattern="yyyy/MM/dd (E) hh:mm:ss (a)" /></td>
			<td><fmt:formatNumber value="${etemp.sal }" pattern="#,###.00" /> &#36;</td>
			<td><fmt:formatNumber value="${etemp.comm }" pattern="#,###.00" /> &#36;</td>
			<td><fmt:formatNumber value="${(etemp.sal*12) + etemp.comm }" pattern="#,###.00" /> &#36;</td>
			<td>${ etemp.deptno }</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="9"><h4>Leo Publising</h4></td>
		</tr>
	</table>
</div>
</body>
</html>