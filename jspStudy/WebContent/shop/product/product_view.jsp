<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../include/inc_header.jsp" %>
<style>
.row{
	display:flex;
	padding:5px;
}
.label{
	width:120px;
	text-align: center;
}
.longInput{
	width:770px;
}
.shortInput{
	width: 190px;
}
.radioInp{
	display:flex;
	width:500px;
	justify-content: space-around;
}
.btn{
	display:flex;
	width:900px;
	justify-content: space-around;
	padding: 10px;
}
#formTitle{
	text-align: center;
}
.shotLine{
	display:flex;
	margin-bottom: 20px;
}
</style>
	<div>
		<form style="width:900px; border: 1px solid black;" name="chugaForm">
			<div id="formTitle">
				<h2>상품 상세 보기</h2>
			</div>
			<div class="row">
				<div style="width:200px; height:200px; border: 1px solid black; margin-left: 25px;">
					${dto.product_img}
				</div>
				<div style="height:202px; display: flex; align-items: center;">
					<div>
						<div class="shotLine">
							<div class="label">
								상품번호
							</div>
							<div>
								${dto.no}
							</div>
						</div>
						<div class="shotLine">
							<div class="label">
								상품명
							</div>
							<div>
								${dto.name}
							</div>
						</div>
						<div class="shotLine">
							<div class="label">
								상품가격
							</div>
							<div>
								${dto.price}
							</div>
						</div>
						<div class="shotLine">
							<div class="label">
								등록일
							</div>
							<div>
								${dto.regiDate}
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="label">
				상품설명
			</div>
			<div class="row" style="display:flex; justify-content: center;">	
				<div>
					<textarea name="bContent" style="padding:10px; width:850px; height:500px; resize: none; 
					background-color: transparent; color: black; border: 1px solid black;" disabled="disabled">${dto.description}</textarea>
				</div>
			</div>
			<div id="replyDiv"></div>
			<div class="row">	
				<div class="btn">
					<div style="width:400px; display:flex; justify-content: space-around;">
						<div>
							<input type="button" value="상품등록" onclick="move('chuga','${pageNumber}');" id="btnSave">
						</div>
						<div>
							<input type="button" value="수정하기" onclick="move('modify','${pageNumber}','${dto.no}');" id="btnSave">
						</div>
						<div>
							<input type="button" value="삭제하기" onclick="move('delete','${pageNumber}','${dto.no}');" id="btnSave">
						</div>
						<div>
							<input type="button" value="목록으로" onclick="move('list','${pageNumber}');" id="btnList">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
<script>
function move(v_location, v_pageNumber, v_bNo){
	goPage(v_location, v_pageNumber, v_bNo);
}
</script>