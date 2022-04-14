<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<style>
	.container{
		justify-content: center;
		border: 1px solid #ddd;
		box-shadow: 0.5px 0.5px gray;
	}
    .product {
        display: flex;
        padding: 10px;
        justify-content: center;
    }
    .thumbnail {
        max-width: 200px;
        width: 200px;
        border-radius: 10px;
        background-size: cover;
        background-position: center;        
        
    }
    .flex-grow-1{
    	padding-left:50px;
    }
    .product .price {
        font-size: 16px;
        font-weight: 600;
    }
    .product .title {
        font-size: 17px;
        font-weight: 600;
    }
    .product .date {
        color: grey;
        font-size: 13px;
    }
</style>
	<c:forEach var="product" items="${list}">
		${product.proTranCode }
		<c:set var="i" value="${ i+1 }" />
    <div class="container">
        <div class="product">
          <div class="thumbnail" style="background-image: url('http://folo.co.kr/img/gm_noimage.png')">
          <img style="width:200px; height:200px;" src="../images/uploadFiles/${product.fileName}"/>
          </div>
          <div class="flex-grow-1 p-4">          	
          	<c:if test="${param.menu=='search'}">
				<h5 class="title"><a style="font-size:larger; text-align:center;" href="/getProduct.do?prodNo=${product.prodNo}">${product.prodName}</a></h5>
			</c:if>
			<c:if test="${param.menu !='search'}">
				<c:if test="${product.stock !='0'}">
					<h5 class="title"><a style="font-size:larger; text-align:center;" href="/updateProductView.do?prodNo=${product.prodNo}">${product.prodName}</a></h5>
				</c:if>
				<c:if test="${product.stock == '0'}">
					<h5 class="title"><a style="font-size:larger; text-align:center;" href="/updateProductView.do?prodNo=${product.prodNo}">${product.prodName}</a></h5>
				</c:if>
			</c:if>            
            <p class="date">등록일 : ${product.regDate}</p>
            <p class="price">가격 : ${product.price}</p>
            <p class="float-end">재고 : ${product.stock }</p>
			<h4 style="text-align:center;">
				<c:if test="${param.menu =='search'}">
					<c:if test="${product.stock !=0}">
						판매중
					</c:if>
					<c:if test="${product.stock == 0}">
						재고없음
					</c:if>
				</c:if>
				<c:if test="${param.menu !='search'}">
					<c:if test="${product.proTranCode=='0'}">
						판매중
					</c:if>
					<c:if test="${product.proTranCode== '1  '}">
						구매완료 <a href="/updateTranCode.do?prodNo=${product.prodNo}&tranCode=2&menu=${param.menu}&con=''">배송하기</a>
					</c:if>
					<c:if test="${product.proTranCode== '2  '}">
						구매확인 대기중
					</c:if>
					<c:if test="${product.proTranCode =='3  '}">
						배송완료
					</c:if>
				</c:if>				
			</h4>
          </div>
        </div>        
    </div>
    </c:forEach>