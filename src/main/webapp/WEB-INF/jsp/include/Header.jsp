<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/include/Header.css">
</head>

<body>
	<header>
		<div class="header-inner">
		
			<h1>Inventory Manager</h1>
			
			<div class="header-button-area">
				<c:choose>
					<c:when test="${loginId eq 'admin'}">
						<button class="manager-menu">관리자</button>
					</c:when>
					<c:otherwise>
						<button class="none-btn"></button>
					</c:otherwise>
				</c:choose>
				<button class="product_create">상품등록</button>
				<button class="sign_out">로그아웃</button>
			</div>
				
		</div>
	</header>
	
	<script type="text/javascript" src="/js/include/Header.js"></script>
</body>

</html>