$(document).ready(function() {
	
  $('.modify-btn').click(function() {
    let productId = $(this).data('product-id');
    location.href = "/product/update_view?productId=" + productId;
  });

  $('.delete-btn').click(function() {
    let productId = $(this).data('product-id');

    $.ajax ({
      type : "DELETE",
      url : "/product/delete",
      data : {"productId" : productId},
      success : function(data) {
        if (data.result === 'success') {
          alert("게시물 삭제되었습니다.");
          location.reload();
        } else {
          alert("게시물 삭제에 실패했습니다.");
        }
      },
      error : function(e) {
        alert("게시물 삭제에 실패했습니다.");
      }
    });
  });
});