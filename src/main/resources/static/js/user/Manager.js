$(document).ready(function() {

  $('.back-btn').click(function () {
    location.href = "/manager/main_view"
  });

  $('.delete-btn').click(function () {
    let userId = $(this).data('user-id');

    $.ajax({
      type : "DELETE",
      url : "/user/delete",
      data : {"userId" : userId},
      success : function(data) {
        if (data.result === 'success') {
          alert("삭제 완료했습니다.");
          location.reload();
        } else {
          alert("삭제 실패했습니다.");
        }
      },
      error : function(e) {
        alert("삭제에 실패했습니다.");
      }
    });
  });
});