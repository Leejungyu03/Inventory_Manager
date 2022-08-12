$(document).ready(function() {
  
  $('.signIn-btn').click(function() {
    location.href="/user/sign_in_view"
  });

  $('.loginId-check').click(function() {
    const loginId = $('.loginId').val().trim();
    
    if (loginId === '') {
      alert("아이디를 입력해주세요.");
      return;
    }

    $.ajax({
      type : "POST",
      url : "/user/is_duplicated_loginId",
      data : {"loginId" : loginId},
      success : function(data) {
        if (data.result === 'success') {
          // 중복일때
          $('.loginId-ok').css('display', 'none')
          $('.loginId-duplicated').css('display', 'block')
        } else {
          // 중복이 아닐때
          $('.loginId-duplicated').css('display', 'none')
          $('.loginId-ok').css('display', 'block')
        }
      },
      error : function(e) {
        alert("아이디 중복확인에 실패했습니다.");
      }
    });
  });

  $('.signUp-btn').click(function() {
    const loginId = $('.loginId').val().trim();
    const password = $('.password').val();
    const passwordConfirm = $('.password-confirm').val();
    const name = $('.name').val().trim();

    if ($('.loginId-ok').css('display') === 'none') {
      alert("아이디 중복확인을 확인해주세요.");
      return;
    }

    if (password === '') {
      alert("비밀번호를 입력해주세요");
      return;
    }

    if (password != passwordConfirm) {
      alert("비밀번호가 일치하지 않습니다. 다시 입력해주세요");
      $('#passwordConfirm').val('');
      return
      ;
    }

    if (name == '') {
      alert("이름을 입력해주세요.");
      return;
    }
    
    $.ajax ({
      type : "POST",
      url : "/user/sign_up",
      data : {"loginId" : loginId, "password" : password, "name" : name},
      success : function(data) {
        if (data.result === 'success') {
          alert("회원가입 완료");
          location.href = "/user/sign_in_view";
        } else {
          alert(data.error_message);
        }
      },
      error : function(e) {
        alert("회원가입에 실패하였습니다.");
      }
    })
  })
})