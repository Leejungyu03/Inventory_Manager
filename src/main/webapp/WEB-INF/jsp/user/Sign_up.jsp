<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/user/Sign_up.css">
</head>

<body>
	<section class="signUp">
		<div class="signUp-inner">
		
			<h1>Inventory Manager</h1>
			
			<div class="signUp-form-area">

        <div class="loginId-area">
          <input 
            type="text" 
            class="loginId"
            placeholder="아이디를 입력하세요."
          />
          <button 
            type="button" 
            class="loginId-check"
          >
            중복확인
          </button>
        </div>

        <div class="loginId-duplicated">이미 사용중인 ID입니다.</div>
				<div class="loginId-ok">사용 가능한 ID 입니다.</div>

				<input 
					type="password" 
					class="password"
					placeholder="비밀번호를 입력하세요."
				/>

        <input 
					type="password" 
					class="password-confirm"
					placeholder="비밀번호를 확인해주세요."
				/>

        <input 
					type="text" 
					class="name"
					placeholder="이름을 확인해주세요."
				/>
			</div>
			
			<div class="signUp-button-area">
				<button type="button" class="signIn-btn">로그인하기</button>
				<button type="button" class="signUp-btn">회원가입</button>
			</div>
				
		</div>
	</section>
	
	<script type="text/javascript" src="/js/user/Sign_up.js"></script>
</body>

</html>