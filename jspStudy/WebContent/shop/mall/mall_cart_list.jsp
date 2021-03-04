<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../include/inc_header.jsp" %>

<c:set var="totalPrice" value="0" />
<form name="deleteCart" id="deleteCart" method="post">
	<c:forEach var="dto" items="${list}">
		<div id="imgPathConfig">
			<c:set var="mainImgName" value="${fn:substringBefore(dto.product_img,',')}"/>
			<c:if test="${mainImgName!='-'}">
				<c:set var="mainImgName" value="${fn:substringAfter(fn:substringBefore(dto.product_img,','),'|')}"/>
			</c:if>
			<c:set var="imgPath" value="${path}/attach/product_img/${mainImgName}"/>
			<c:if test="${mainImgName=='-'}">
				<c:set var="imgPath" value="이미지X"/>
			</c:if>
		</div>
		<div style="display:flex; align-items: center; justify-content: center;">
			<div style="margin-right:10px;">
				<input type="checkbox" style="zoom:2.0;" name="productNos" value="${dto.productNo}">
			</div>
			<div style="cursor:pointer; display:flex; align-items: center; justify-content: center;">
				<c:if test="${imgPath=='이미지X'}">
					<div style="width:250px; height:250px; display:flex; align-items: center; justify-content: center;">
						${imgPath}
					</div>
				</c:if>
				<c:if test="${imgPath!='이미지X'}">
					<img src="${imgPath}" width="250px" height="250px" />
				</c:if>
				<div>
					상품번호 : ${dto.productNo}<br>
					상품명 : ${dto.product_name}<br>
					상품설명 : ${dto.product_description}<br>
					상품가격 : <fmt:formatNumber type="number" maxFractionDigits="3" value="${dto.product_price}" /><br>
					장바구니 수량 : ${dto.amount}<br>
					금액 합 : <fmt:formatNumber type="number" maxFractionDigits="3" value="${dto.buy_money}" />
				</div>
			</div>
		</div>
		<c:set var="totalPrice" value="${totalPrice+dto.buy_money}" />
	</c:forEach>
	총 금액 합 : <fmt:formatNumber type="number" maxFractionDigits="3" value="${totalPrice}" />
</form>
<div class="btn">
	<div style="width:400px; display:flex; justify-content: space-around;">
		<div>
			<input type="button" value="목록으로" onclick="move('list','${pageNumber}');" id="btnList">
		</div>
		<div>
			<input type="button" value="선택 항목 삭제" onclick="move('deleteProc','${pageNumber}');" id="btnList">
		</div>
		<div>
			<input type="button" value="장바구니 비우기" onclick="move('deleteAllProc','${pageNumber}');" id="btnList">
		</div>
	</div>
</div>

<script>
function move(v_location, v_pageNumber, v_bNo){
	goPage(v_location, v_pageNumber, v_bNo);
}
</script>
