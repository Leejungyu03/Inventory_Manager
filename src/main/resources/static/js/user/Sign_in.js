$(document).ready(function() {
	
  $('.signUp-btn').click(function() {
    location.href="/user/sign_up_view"
  })

  $('.login-btn').click(function() {
    const userId = $('.userId').val().trim();
    const password = $('.password').val();

    if (userId === '') {
      alert("아이디를 입력해주세세요");
      return;
    }

    if (password === '') {
      alert("비밀번호를 입력해주세요");
      return;
    }

    $.ajax({
      type: "POST",
      url: "/user/sign_in",
      data: {"userId" : userId, "password" : password},
      success : function(data) {
        if (data.result === 'success') {
          alert(`${data.name}님 환영합니다.`);
          location.href = "/manager/main_view"
        } else {
          alert(data.error_message);
          userId.val('');
          password.val('');
        }
      },
      error : function(e) {
        
      }
    })
  })
})