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
	<style></style>"C:/Users/Leodays/Desktop/Responsive-jQuery-Content-slider-with-HTML5-Liquid Slider.zip"
	<script>
		$('document').ready(function(){
			$.ajax({
				url : 'ex.json',
				dataType : 'json',
				success : function(data, status){
					
					var output = '<tr><th>아이디</th><th>이름</th><th>가격</th><th>설명</th></tr>';
					$.each(data, function(index, item){
						output += '<tr>';
						output += '<td>'+ item.id + '</td>';
						output += '<td>'+ item.name + '</td>';
						output += '<td>'+ item.price + '</td>';
						output += '<td>'+ item.description + '</td>';
						output += '</tr>';
					});
					$('#treeData').append(output);
				}			
			});
			/* $.getJSON('ex.json', function(data, status){
				$.each(data, function(index, item){
					$('tr:nth-child('+(index+2)+') td').eq(0).html(item.id);
					$('tr:nth-child('+(index+2)+') td').eq(1).html(item.name);
					$('tr:nth-child('+(index+2)+') td').eq(2).html(item.price);
					$('tr:nth-child('+(index+2)+') td').eq(3).html(item.description);
				});
			}); */
		});
	</script>
	</head>
<body>
	<table id="treeData">
		
	</table>
</body>
</html>