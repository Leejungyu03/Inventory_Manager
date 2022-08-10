$(document).ready(function() {
	
  $('.signUp-btn').click(function() {
    location.href="/manager/sign_up_view"
  })

  $('.login-btn').click(function() {
    const userId = $('.userId').val().trim();
    const password = $('.password').val();
    alert(password)

    // $.ajax({
    //   type: "POST",
    //   url: "/user/sign_in",
    //   data
    // })
  })
})