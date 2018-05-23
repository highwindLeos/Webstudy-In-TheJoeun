<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First JSP Page</title>
<link rel="stylesheet" href="./css/Showpingmall.css">
</head>
<body>
	<%@ include file="./header.jsp"%>
	<section id="content">
		<div class="section1">
			<div class="slide_banner">slide_banner</div>
			<div class="side_banner">side_banner</div>
			<div class="clear"></div>
		</div>
		<div class="section2">
			<div id="hit_product">
				<div class="hit_product1">hit_product1</div>
				<div class="hit_product2">hit_product2</div>
				<div class="hit_product3">hit_product3</div>
				<div class="hit_product4">hit_product4</div>
				<div class="clear"></div>
			</div>
			<div id="md_product">
				<div class="md_product1">md_product1</div>
				<div class="md_product2">md_product2</div>
				<div class="md_product3">md_product3</div>
				<div class="md_product4">md_product4</div>
				<div class="clear"></div>
			</div>	
		</div>
	</section>
	<div class="clear"></div>
	<%@ include file="./bottom.jsp"%>
</body>
</html>