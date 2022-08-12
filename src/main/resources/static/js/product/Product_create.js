$(document).ready(function() {

  $('.back-btn').click(function() {
    location.href = "/main";
  });

  $('.uplopad-product-btn').click(function() {
    let title = $('.title').val();
    let content = $('.content').val();
    let stock = $('.stock').val();
    let imgUrl = URL.createObjectURL($('#uploadImageInput')[0].files[0]);

    $.ajax({
      type : "POST",
      url : "/product/create",
      data : {
        "title" : title,
        "content" : content,
        "stock" : stock,
        "imgUrl" : imgUrl
      },
      success : function(data) {
        alert("성공")
      },
      error : function(e) {
        alert("실패")
      }
    })
  });

  $('#uploadImageInput').change(function() {
    let imgUrl = URL.createObjectURL($('#uploadImageInput')[0].files[0]);
    $('.sample-image').attr("src", imgUrl);
  });
});