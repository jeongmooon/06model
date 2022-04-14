<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>��ǰ ��� ��ȸ</title>

<link rel="stylesheet" href="/css/admin.css" type="text/css">

<script type="text/javascript">
	// �˻� / page �ΰ��� ��� ��� Form ������ ���� JavaScrpt �̿�
	const num = /^[0-9]+/g;
	
	function fncGetUserList(currentPage) {
		const con = document.getElementById("searchCondition").value;
		const keyword = document.getElementById("searchKeyword").value;
		//if(keyword != ""){
		//	if(!num.test(keyword)){
		//		alert("���ڸ�");
		//		return;
		//	}
		//}		
		document.getElementById("currentPage").value = currentPage;
	   	document.detailForm.submit();		
	}
	
	function fncPageProductList(currentPage){
		document.getElementById("currentPage").value = currentPage;
	   	document.detailForm.submit();
	}
	
	function fncSearchPrice(currentPage){
		const price = document.getElementById("priceKeyword").value;	
		console.log(price)
		if(price != ""){
			if(!num.test(price)){
				alert("���ڸ�");
				return;
			}
		}
		
		document.detailForm.action = "/listProduct.do?menu=${param.menu }&searchValue=5";
		document.getElementById("currentPage").value = currentPage;
	   	document.detailForm.submit();
	}
	
	
</script>
</head>

<body bgcolor="#ffffff" text="#000000">

<div style="width:98%; margin-left:10px;">

<form name="detailForm" action="/listProduct.do?menu=${param.menu }" method="post">

<table width="100%" height="37" border="0" cellpadding="0"	cellspacing="0">
	<tr>
		<td width="15" height="37">
			<img src="/images/ct_ttl_img01.gif" width="15" height="37"/>
		</td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left:10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">
					<c:if test="${param.menu =='search' }">
						��ǰ �����ȸ
					</c:if>
					<c:if test="${param.menu !='search' }">
						��ǰ ����
					</c:if>
					</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37">
			<img src="/images/ct_ttl_img03.gif" width="12" height="37">
		</td>
	</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td align="right">
			<select name="searchCondition" class="ct_input_g" style="width:80px">
				<option id="searchCondition" value="1" ${ ! empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }>��ǰ��ȣ</option>
				<option id="searchCondition" value="2" ${ ! empty search.searchCondition && search.searchCondition==2 ? "selected" : "" }>��ǰ��</option>
			</select>
			<input 	type="text" name="searchKeyword" value="${search.searchKeyword}"  class="ct_input_g" id="searchKeyword"
							style="width:200px; height:20px" >
		</td>
		<td align="right" width="70">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17" height="23">
						<img src="/images/ct_btnbg01.gif" width="17" height="23"/>
					</td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;">
						<a href="javascript:fncGetProductList('1');">�˻�</a>
					</td>
					<td width="14" height="23">
						<img src="/images/ct_btnbg03.gif" width="14" height="23"/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td colspan="11" >
			��ü  ${resultPage.totalCount } �Ǽ�, ���� ${resultPage.currentPage}  ������
		</td>
	</tr>
	<tr>
		<input type="hidden" value="${search.searchValue}" name="searchValue" />
		<td class="ct_list_b" width="100"><a href="/listProduct.do?menu=${param.menu }&searchValue=0">��ǰ��ȣ��</a></td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150"><a href="/listProduct.do?menu=${param.menu }&searchValue=1">�̸� ����</a></td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150"><a href="/listProduct.do?menu=${param.menu }&searchValue=2">���ݳ�����</a></td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150"><a href="/listProduct.do?menu=${param.menu }&searchValue=3">����Ϻ�����</a></td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150"><a href="/listProduct.do?menu=${param.menu }&searchValue=4">���ȸ�����</a></td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">
			<details>
				<summary>���� ��</summary>
				<c:if test="${search.searchValue==5}">
					<input id="priceKeyword" name="sPriceKeyword" type="text" value="${search.searchKeyword.split(',')[0]}">
					<h3>~</h3>
					<input id="priceKeyword" name="bPriceKeyword" type="text" value="${search.searchKeyword.split(',')[1]}" />
				</c:if>
				<c:if test="${search.searchValue !=5}">
					<input id="priceKeyword" name="sPriceKeyword" type="text">
					<h3>~</h3>
					<input id="priceKeyword" name="bPriceKeyword" type="text" />
				</c:if>
				<a href="javascript:fncSearchPrice('1');">�˻�</a>
			</details></td>	
	</tr>
	<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>
	<c:set var="i" value="0" />
</table>
<jsp:include page="productCard.jsp" />

<!-- PageNavigation Start... -->
<table width="100%" border="0" cellspacing="0" cellpadding="0"	style="margin-top:10px;">
	<tr>
		<td align="center">
		   <input type="hidden" id="currentPage" name="currentPage" value=""/>
			<jsp:include page="../common/pageNavigator.jsp"/>
    	</td>
	</tr>
</table>
<!-- PageNavigation End... -->

</form>
</div>

</body>
</html>