<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/user/Sign_in.css">
</head>

<body>
	<section class="signIn">
		<div class="signIn-inner">
		
			<h1>Inventory Manager</h1>
			
			<div class="signIn-form-area">
				<input 
					type="text" 
					class="loginId"
					placeholder="아이디를 입력하세요."
				/>

				<input 
					type="password" 
					class="password"
					placeholder="비밀번호를 입력하세요."
				/>
			</div>
			
			<div class="signIn-button-area">
				<button class="signUp-btn">회원가입</button>
				<button class="login-btn">로그인</button>
			</div>
				
		</div>
	</section>
	
	<script type="text/javascript" src="/js/user/Sign_in.js"></script>
</body>

</html>