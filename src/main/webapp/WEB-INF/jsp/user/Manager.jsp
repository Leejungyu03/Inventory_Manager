<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/user/Manager.css">
</head>

<body>
	<section class="manager">
		<div class="manager-inner">
		
			<h1>Inventory Manager</h1>
			
      <table>
        <tr>
          <th>번호</th>
          <th>아이디</th>
          <th>비밀번호</th>
          <th>이름</th>
          <th>가입일</th>
          <th>삭제</th>
        </tr>
        <c:forEach items="${userList}" var="user" varStatus="status">
        	<c:if test="${user.loginId != 'admin'}">
		        <tr>
		          <td>${status.count - 1}</td>
		          <td>${user.loginId}</td>
		          <td>${user.password}</td>
		          <td>${user.name}</td>
		          <td>
		          	<fmt:formatDate value="${user.createdAt}" pattern="M월 dd일 H시 mm분"/>
		          </td>
              <td>
                <button class="delete-btn" data-user-id="${user.id}">삭제</button>
              </td>
		        </tr>
        	</c:if>
        </c:forEach>
      </table>

      <div class="back-btn-area">
        <button class="back-btn">뒤로가기</button>
      </div>
				
		</div>
	</section>
	
	<script type="text/javascript" src="/js/user/Manager.js"></script>
</body>

</html>