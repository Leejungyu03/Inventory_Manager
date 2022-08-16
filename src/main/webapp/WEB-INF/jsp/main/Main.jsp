<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/main/Main.css">
</head>

<body>
	<section class="main">
		<div class="main-inner">

			<div class="main-card-list">

				<c:forEach items="${productList}" var="product">
					<div class="main-card">
		
						<div class="card-image-area">
							<c:choose>
								<c:when test="${product.imageUrl eq null}">
									<img src="/image/smapleImageIcon.png" alt="">
								</c:when>
								<c:otherwise>
									<img src="${product.imageUrl}" alt="">
								</c:otherwise>
							</c:choose>
						</div>
		
						<div class="card-text-area">
							<div class="title">${product.title}</div>
							<div class="content">${product.content}</div>
							<div class="stock">수량 : ${product.stock}</div>
							<div class="writer">작성자 : ${product.userName}</div>

							<jsp:useBean id="nowDate" class="java.util.Date" />
							<fmt:parseNumber value="${nowDate.time / (1000*60*60*24)}" var="today" integerOnly="true" scope="request"/>
							<fmt:parseNumber value="${product.updatedAt.time / (1000*60*60*24)}" var="updatedDate" integerOnly="true" scope="request" />

							<c:choose>
								<c:when test="${(today - updatedDate) eq 0}">
									<div class="updatedDate">수정일 : 오늘</div>
								</c:when>
								<c:otherwise>
									<div class="updatedDate">수정일: ${today - updatedDate}일전</div>
								</c:otherwise>
							</c:choose>

						</div>
						
						<c:if test="${userId eq product.userId}">
							<div class="card-btn-area">
								<button class="modify-btn" data-product-id="${product.id}">수정하기</button>
								<button class="delete-btn" data-product-id="${product.id}">삭제하기</button>
							</div>
						</c:if>

					</div>
				</c:forEach>
			</div>

		</div>
	</section>
	
	<script type="text/javascript" src="/js/main/Main.js"></script>
</body>

</html>