<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/product/Product_create.css">
</head>

<body>
	<section class="product-create">
		<div class="product-create-inner">
      
      <div class="product-create-head">

        <div class="head-image-area">
          <img src="/image/backIcon.png" 
          alt="뒤로가기 아이콘"
          class="back-btn"
        />
        </div>

        <div class="title">상품 추가</div>
        
        <div class="uplopad-product-btn-area">
          <img 
            src="/image/uploadIcon.png"
            alt="업로드 버튼"
            class="uplopad-product-btn"
          />
        </div>
      </div>

      <div class="product-create-content">
        <input 
          type="text"
          class="title"
          placeholder="제목을 입력해주세요."
          maxlength="30"
        />

        <textarea 
          class="content"
          placeholder="내용을 입력해주세요."
          rows="10"
          maxlength="100"
        ></textarea>

        <input 
          type="number"
          class="stock"
          placeholder="수량을 입력해주세요."
          min="0"
        />
      </div>

      <div class="product-create-image">
        <div class="upload-icon-area">
          <label for="uploadImageInput">
            <img 
              src="/image/imageIcon.png"
              class="upload-image-btn"
              alt="이미지 추가 아이콘"
            />
          </label>
          <input 
            type="file" 
            id="uploadImageInput" 
            accept="image/*"
          />
        </div>

        <div class="sample-image-area">
	         <img 
	           src="/image/smapleImageIcon.png" 
	           alt="추가된 이미지"
             class="sample-image"
	         />
        </div>
      </div>
				
		</div>
	</section>
	
	<script type="text/javascript" src="/js/product/Product_create.js"></script>
</body>

</html>