<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/product/Product_modify.css">
</head>

<body>
	<section class="product-modify">
		<div class="product-modify-inner">
      
      <div class="product-modify-head">

        <div class="head-image-area">
          <img src="/image/backIcon.png" 
          alt="뒤로가기 아이콘"
          class="back-btn"
        />
        </div>

        <div class="product-modify-title">상품 수정</div>
        
        <div class="uplopad-product-btn-area">
          <img 
            src="/image/uploadIcon.png"
            alt="업로드 버튼"
            class="uplopad-product-btn"
            data-product-id="${product.id}"
          />
        </div>
      </div>

      <div class="product-modify-content">
        <input 
          type="text"
          class="title"
          placeholder="상품명을 입력해주세요."
          maxlength="30"
          value="${product.title}"
        />

        <textarea 
          class="content"
          placeholder="상품 설명을 입력해주세요."
          rows="10"
          maxlength="100"
        >${product.content}</textarea>

        <input 
          type="number"
          class="stock"
          placeholder="수량을 입력해주세요."
          min="0"
          value="${product.stock}"
        />
      </div>

      <div class="product-modify-image">
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
        	<c:choose>
        		<c:when test="!(${product.imageUrl eq null})">
        			<img 
	           		src="/image/smapleImageIcon.png" 
	           		alt="추가된 이미지"
             		class="sample-image"
	         		/>
        		</c:when>
        		<c:otherwise>
        			<img 
	           		src="${product.imageUrl}" 
	           		alt="업로드 된 이미지"
             		class="sample-image"
	         		/>
        		</c:otherwise>
        	</c:choose>
        </div>
      </div>
				
		</div>
	</section>
	
	<script type="text/javascript" src="/js/product/Product_modify.js"></script>
</body>

</html>