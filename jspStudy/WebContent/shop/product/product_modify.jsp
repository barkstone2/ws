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
		<h2>상품 수정</h2>
		<input type="hidden" name="no" id="no" value="${dto.no}">
	</div>
	<div class="row">
		<div class="label">
			상품명
		</div>
		<div>
			<input type="text" name="pName" id="pName" class="longInput" value="${dto.name}">
		</div>
	</div>
	<div class="row">
		<div class="shotLine">
			<div class="label">
				상품가격
			</div>
			<div>
				<input type="text" name="price" id="price" class="longInput" value="${dto.price}">
			</div>
		</div>
	</div>
	<div class="row">	
		<div class="label" style="display:flex; align-items: center; justify-content: center;">
			상품설명
		</div>
		<div>
			<textarea name="description" id="description" style="width:770px; height:500px; resize: none;">${dto.description}</textarea>
		</div>
	</div>
	<div class="row">	
		<div class="label">
			상품이미지
		</div>
		<div style="display:block;">
			<c:set var="i" value="0" />
			<c:forEach var="imgName" items="${imgNames}">
				<c:if test="${imgName!='-'}">
					<div id="curImgName${i}">
						<input type="hidden" name="curImgNames" value="${imgName}|${i}">
					</div>
					<c:set var="imgName" value="${fn:substringAfter(imgName,'|')}"/>
					<div id="currentImg${i}">
						<a style="none; cursor: pointer;" onclick="changeFile('${i}');">${imgName}</a>
						<input type="button" value="다시선택" onclick="changeFile('${i}');">
					</div>
					<div style="display:flex;">
						<div id="newImg${i}" style="display:none;">
							<input type="file" name="files">
						</div>
					</div>
				</c:if>
				<c:if test="${imgName=='-'}">
					<div id="fileInputDiv">
						<input type="file" name="files">
					</div>
				</c:if>
				<c:set var="i" value="${i+1}" />
			</c:forEach>
		</div>
	</div>
	<div class="row">	
		<div class="btn">
			<div style="width:300px; display:flex; justify-content: space-around;">
				<div>
					<input type="button" value="상품수정" id="btnSave">
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
		if(confirm('수정하시겠습니까?')){
			goPage('modifyProc');
		}
	});
	$("#btnList").click(function(){
		goPage('list');
	});
});

function changeFile(fileIndex){
	var i = fileIndex;
	var fileInput = $("#fileInputDiv").html();
	$("#currentImg"+i).hide();
	$("#newImg"+i).show();
	$("#curImgName"+i).html('');
}



</script>