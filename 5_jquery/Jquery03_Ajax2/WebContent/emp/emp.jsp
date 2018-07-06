
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>total Example</title>
	<style></style>
	<link rel="stylesheet" href="${conPath }/css/board.css" />
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script>
		$(document).ready(function(){
			
			$.get('${conPath}/searchEmp.do', function(data, status){
				$('#showEmp').html(data);
			}); // 
			
			$('#search').click(function(){
				var sandData = 'searchEname='+$('#searchEname').val()+'&searchJob='+$('#searchJob').val();
				$.ajax({
					url : '${conPath}/searchEmp.do',
					type : 'post',
					data : sandData,
					dataType : 'html',
					success : function(data, status){
						$('#showEmp').html(data);
					},
					error : function(){
						$('#showEmp').html('');
					}
				});
			});
			
			 $('#searchEname, #searchJob').keyup(function(){
				var sandData = 'searchEname='+$('#searchEname').val()+'&searchJob='+$('#searchJob').val();
				$.ajax({
					url : '${conPath}/searchEmp.do',
					type : 'post',
					data : sandData,
					dataType : 'html',
					success : function(data, status){
						$('#showEmp').html(data);
					},
					error : function(){
						$('#showEmp').html('');
					}
				});
			}); 
		}); 
	</script>
</head>
<body>
<div id="wrap">
	<table>
		<tr>
			<td colspan="8"></td>
		</tr>
		<tr>
			<td colspan="8">
				<p>사원명 : <input type="text" id="searchEname" name="searchEname" /></p>
				<br>
				<p>직 책 : <input type="text" id="searchJob" name="searchJob" /></p>
				<input type="button" id="search" value="검색" />
			</td>
		</tr>
	</table>
	<div id="showEmp"></div>
</div>	
</body>
</html>