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
        	<input type="hidden" name="prodNo" value ="${purchase.purchaseProd.prodNo}" />
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
            	${purchase.star.checkB }
        		<c:if test="${purchase.tranCode =='1  '}">
					현재 구매 완료 상태입니다.
				</c:if>
				<c:if test="${purchase.tranCode =='2  '}">
					현재 배송중 상태 입니다.
				</c:if>
				<c:if test="${purchase.tranCode =='3  '}">
					현재 배송완료 상태 입니다.
				</c:if>
			</p>
			<c:if test="${purchase.tranCode =='2  '}">
				<a href="/updateTranCode.do?tranNo=${purchase.tranNo}&tranCode=3&con=user">물건도착</a>
			</c:if>
			<c:if test="${purchase.tranCode =='3  '&& purchase.star.checkB ==null}">
				<div class="score" style="text-align: center;"
						onClick="window.open('/score.html?prodNo=${purchase.purchaseProd.prodNo}',
						'popWin','left=300, top=200, width=300, height=400, marginwidth=0, marginheight=0, scrollbars=no, scrolling=no, menubar=no, resizable=no')">
						후기등록
				</div>
			</c:if>
			<c:if test="${purchase.star.checkB =='1' }">
				<div style="text-align: center;">후기 등록완료</div>
			</c:if>
        </div>
    </div>        
    </div>
    </c:forEach>