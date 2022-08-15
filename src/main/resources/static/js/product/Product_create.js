$(document).ready(function() {

  $('.back-btn').click(function() {
    location.href = "/main";
  });

  $('.uplopad-product-btn').click(function() {
    let title = $('.title').val();
    let content = $('.content').val();
    let stock = $('.stock').val();
    let imageFile = ($('#uploadImageInput')[0].files[0]);

    if (title === '') {
      alert("상품명을 입력해주세요.");
      return;
    }

    if (content === '') {
      alert("상품 설명을 입력해주세요.");
      return;
    }

    if (stock === '') {
      alert("수량을 입력해주세요.");
      return;
    }

    let formData = new FormData();
    formData.append("title", title);
    formData.append("content", content);
    formData.append("stock", stock);
    formData.append("imageFile", imageFile);

    $.ajax({
      type : "POST",
      url : "/product/create",
      enctype : "multipart/form-data",
      data : formData,
      processData : false,
			contentType : false,
      success : function(data) {
        if (data.result === 'success') {
          alert("업로드 완료되었습니다");
          location.href = "/manager/main_view"
        } else {
          alert("업로드에 실패하였습니다.");
        }
      },
      error : function(e) {
        alert("업로드 실패하였습니다.");
      }
    })
  });

  $('#uploadImageInput').change(function() {
    let imgUrl = URL.createObjectURL($('#uploadImageInput')[0].files[0]);
    $('.sample-image').attr("src", imgUrl);
  });
});