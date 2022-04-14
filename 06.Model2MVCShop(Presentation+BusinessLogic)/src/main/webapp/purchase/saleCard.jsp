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
    .score{
    	text-align: center;
    	cursor: pointer;
    }
    .score:hover{
    	color:red;
    	trasition:3s;
    }
</style>
	<c:forEach var="purchase" items="${list}">
		<c:set var="i" value="${ i+1 }" />
    <div class="container">
        <div class="product">
        	<input type="hidden" name="tranNo" value ="${purchase.tranNo}" />
        	<div class="thumbnail" style="background-image: url('http://folo.co.kr/img/gm_noimage.png')">
          		<img style="width:200px; height:200px;" src="../images/uploadFiles/${purchase.purchaseProd.fileName}"/>
          	</div>
          	<div class="flex-grow-1 p-4">
          		<c:if test="${purchase.tranCode=='1  '||purchase.tranCode=='2  '}">
          			<h5 class="title"><a href="/getPurchase.do?tranNo=${purchase.tranNo}">${purchase.purchaseProd.prodName}</a></h5>
				</c:if>
				<c:if test="${purchase.tranCode != '1  ' && purchase.tranCode !='2  '}">
					<h5 class="title">${purchase.purchaseProd.prodName}</h5>
				</c:if>        
            <p class="date">받는사람 : ${purchase.receiverName}</p>
            <p class="price">받는사람번호 : ${purchase.receiverPhone}</p>
            <p class="float-end">
        		<c:if test="${purchase.tranCode=='0'}">
						판매중
				</c:if>
				<c:if test="${purchase.tranCode== '1  '}">
					구매완료 <a href="/updateTranCode.do?tranNo=${purchase.tranNo}&tranCode=2&menu=${param.menu}&con=''">배송하기</a>
				</c:if>
				<c:if test="${purchase.tranCode== '2  '}">
					구매확인 대기중
				</c:if>
				<c:if test="${purchase.tranCode =='3  '}">
					배송완료
				</c:if>
			</p>
        </div>
    </div>        
    </div>
    </c:forEach>