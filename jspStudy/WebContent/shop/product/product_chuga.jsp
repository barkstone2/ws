<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../include/inc_header.jsp" %>
<style>
.row{
	display:flex;
	padding:5px;
}
.label{
	width:100px;
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
	margin-right: 30px;
}
</style>
<form style="width:900px; border: 1px solid black;" name="chugaForm">
	<div id="formTitle">
		<h2>상품 등록</h2>
	</div>
	<div class="row">
		<div class="label">
			상품명
		</div>
		<div>
			<input type="text" name="pName" id="pName" class="longInput">
		</div>
	</div>
	<div class="row">
		<div class="shotLine">
			<div class="label">
				상품가격
			</div>
			<div>
				<input type="text" name="price" id="price" class="longInput">
			</div>
		</div>
	</div>
	<div class="row">	
		<div class="label" style="display:flex; align-items: center; justify-content: center;">
			상품설명
		</div>
		<div>
			<textarea name="description" id="description" style="width:770px; height:500px; resize: none;"></textarea>
		</div>
	</div>
	<div class="row">	
		<div class="label">
			상품이미지
		</div>
		<div>
			<input type="file" name="files">
			<input type="file" name="files">
			<input type="file" name="files">
		</div>
	</div>
	<div class="row">	
		<div class="btn">
			<div style="width:300px; display:flex; justify-content: space-around;">
				<div>
					<input type="button" value="상품등록" id="btnSave">
				</div>
				<div>
					<input type="button" value="목록으로" id="btnList">
				</div>
			</div>
		</div>
	</div>
</form>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#btnSave").click(function(){
		if(confirm('등록하시겠습니까?')){
			goPage('chugaProc');
		}
	});
	$("#btnList").click(function(){
		goPage('list');
	});
});

</script>