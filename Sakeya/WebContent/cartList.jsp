<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap.css">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
<!-- 폰트 어썸 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/headercss.css">
<link rel="stylesheet" type="text/css" href="css/default.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="icon" type="image/png" href="images/sake.ico">
<script type ="text/javascript" src = "js/mypage.js"></script>
</head>
<body>
	<div class ="wrapper">
	<article>
		<h2>Cart List</h2>
		<form name="formm" method="post">
			<c:choose>
				<c:when test="${cartList.size() == 0}">
					<h3 style="color: red; text-align: center;">장바구니가 비었습니다.</h3>
				</c:when>
				<c:otherwise>
					<table id="cartList">
						<tr>
							<th>
							<th>상품명</th>
							<th>수량</th>
							<th>가격</th>
							<th>주문일</th>
							<th>삭제</th>
						</tr>

						<c:forEach items="${cartList}" var="cartVO">
							<tr>
								<td>
								<a href="SakeyaServlet?command=product_detail&pseq=${cartVO.pseq}">
										<h3>${cartVO.pname}</h3>
										
								</a></td>
								<td>${cartVO.quantity}</td>
								<td><fmt:formatNumber
										value="${cartVO.price2*cartVO.quantity}" type="currency" /></td>
								<td><fmt:formatDate value="${cartVO.indate}" type="date" /></td>
								<td><input type="checkbox" name="cseq"
									value="${cartVO.cseq}"></td>
							</tr>
						</c:forEach>

						<tr>
							<th colspan="2">총 액</th>
							<th colspan="2"><fmt:formatNumber value="${totalPrice}"
									type="currency" /><br></th>
							<th><a href="#" onclick="go_cart_delete()"><h3>삭제하기</h3></a></th>
						</tr>
					</table>
				</c:otherwise>
			</c:choose>

			<div class="clear"></div>

			<div id="buttons" style="float: right">
				<input type="button" value="쇼핑 계속하기" class="cancel"
					onclick="location.href='SakeyaServlet?command=index'">
				<c:if test="${cartList.size() != 0}">
					<input type="button" value="주문하기" class="submit"
						onclick="go_order_insert()">
				</c:if>
			</div>
		</form>
	</article>
	</div>
</body>
</html>