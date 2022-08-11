$(document).ready(function() {
  
  $('.signIn-btn').click(function() {
    location.href="/user/sign_in_view"
  });

  $('.userId-check').click(function() {
    const userId = $('.userId').val().trim();
    
    if (userId === "") {
      alert("아이디를 입력해주세요.");
      return;
    }

    $.ajax({
      type : "POST",
      url : "/user/is_duplicated_userId",
      data : {"userId" : userId},
      success : function(data) {
        if (data.result) {
          // 중복일때
          $('.userId-ok').css('display', 'none')
          $('.userId-duplicated').css('display', 'block')
        } else {
          // 중복이 아닐때
          alert()
          $('.userId-duplicated').css('display', 'none')
          $('.userId-ok').css('display', 'block')
        }
      },
      error : function(e) {
        console.log(e)
        alert("아이디 중복확인에 실패했습니다.");
      }
    });
  });

  $('.signUp-btn').click(function() {
    const userId = $('.userId').val().trim();
    const password = $('.password').val();
    const passwordConfirm = $('.password-confirm').val();
    const name = $('.name').val().trim();

    if ($('.userId-ok').css('display') === 'none') {
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
      data : {"userId" : userId, "password" : password, "name" : name},
      success : function(data) {
        if (data.result != 'error') {
          alert("회원가입 완료");
          location.href = "/user/sign_in_view";
        }
      },
      error : function(e) {
        alert("회원가입에 실패하였습니다.");
      }
    })
  })
})