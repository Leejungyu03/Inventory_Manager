$(document).ready(function() {
	
  $('.sign_out').click(function() {

    $.ajax({
      type : "POST",
      url : "/user/sign_out",
      success : function(e) {
        alert("로그아웃되었습니다.");
        location.reload();
      },
      error : function(e) {
        alert("로그아웃에 실패했습니다.")
      }
    });
  });

  $('.product_create').click(function() {
    location.href = "/product/create_view";
  });

  $('.manager-menu').click(function() {
    location.href = "/user/manager_view";
  });
})