<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<style>
.row{
	display:flex;
	margin-bottom: 5px;
	align-items: center;
}
.label{
	width:120px;
	text-align: center;
}
#btn{
	display:flex;
	justify-content: center;
}
#radioInput{
	width:180px;
	display:flex;
	justify-content: space-around;
}
#formTitle{
	text-align: center;
}
.postcode{
	margin-bottom: 5px;
}
#postcode{
	width:120px;
}
#bAddr, #sAddr{
	width:350px;
}
#listLabel{
	display:flex;
	justify-content: center;
	align-items: center;
}
#mList{
	width:700px;
	height:400px;
	min-height: 400px;
}
.mlistcon{
	display:flex;
	justify-content: center;
	align-items: center;
}
#formTitle {
	text-align: center;
}
.mlistcon, #listLabel {
	border-bottom: 1px solid black;
	height:30px;
	text-align: center;
}
.column1{
	border-right: 1px solid black;
	width:60px;
}
.column2{
	border-right: 1px solid black;
	width:120px;
}
.column3{
	border-right: 1px solid black;
	width:300px;
}
.column4{
	border-right: 1px solid black;
	width:200px;
}
#memcount{
	margin-left: 10px;
	margin-bottom: 10px;
}
#btn{
	display:flex;
	justify-content: flex-end;
}
#btn > div {
	padding: 10px;
}
#pager {
	--display:flex;
	justify-content: center;
	padding: 10px;
}
#pager > div{
	padding: 5px;
}
</style>
<div>
	<form name="regForm" method="post" action="${path}/memo_servlet/memoProc.do" style="width:700px;">
		<div id="formTitle">
			<h2>한줄메모장</h2>
		</div>
		<div class="row">
			<div class="label">
				작성자
			</div>
			<div>
				<input type="text" name="id" id="id" value="">
			</div>
		</div>
		<div class="row">
			<div class="label">
				내용
			</div>
			<div>
				<input type="text" name="content" id="content" style="width:300px;" value="">
				<input type="button" value="등록" onclick="reg();">
			</div>
		</div>
	</form>
	<div id="mList">
		<div id="memcount">
			* ${totalConCount}개의 메모가 존재합니다.
		</div>
		<div id="listLabel">
			<div class="column1">
				순번
			</div>
			<div class="column2">
				작성자
			</div>
			<div class="column3">
				내용
			</div>
			<div class="column4">
				작성일
			</div>
		</div>
	<c:if test="${totalConCount==0}">
		<div style="text-align:center;">
			등록된 메모가 없습니다.
		</div>
	</c:if>
	<c:forEach var="dto" items="${list}">
		<div class="mlistcon">
			<div class="column1">
				${dto.no}
			</div>
			<div class="column2">
				${dto.id}
			</div>
			<div class="column3">
				<a href="#" onclick="move('view','${pageNumber}','${dto.no}');">${dto.content}</a>
			</div>
			<div class="column4">
				${fn:substringBefore(dto.regi_date,".")}
			</div>
		</div>
	</c:forEach>
		<div id="pager" style="${totalConCount>0?'display:flex;':'display:none;'}">
			<div><a href="#" onclick="move('list','1','');">[첫페이지]</a></div>
			<c:if test="${startPage>pageNavLength}">
				<div><a href="#" onclick="move('list','${startPage-pageNavLength}','');">[이전${pageNavLength}개]</a></div>
			</c:if>
			<c:if test="${startPage<=pageNavLength}">
				<div>[이전${pageNavLength}개]</div>
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${lastPage}" step="1">
				<c:if test="${i==pageNumber}">
					<div>[${i}]</div>
				</c:if>
				<c:if test="${i!=pageNumber}">
					<div><a href="#" onclick="move('list','${i}','');">${i}</a></div>
				</c:if>
			</c:forEach>
			<c:if test="${lastPage<totalPage}">
				<div><a href="#" onclick="move('list','${startPage+pageNavLength}','');">[다음${pageNavLength}개]</a></div>
			</c:if>
			<c:if test="${lastPage>=totalPage}">
				<div>[다음${pageNavLength}개]</div>
			</c:if>
			<div><a href="#" onclick="move('list','${totalPage}','');">[끝페이지]</a></div>
			<div style="display:none;" id="pagerInfo">
				conPerPage:${conPerPage} / pageNavLength:${pageNavLength} / totalConCount:${totalConCount}
				/ jj:${jj} / startRecord:${startRecord} <br>
				endRecord:${endRecord} / totalPage:${totalPage} / startPage:${startPage} / lastPage:${lastPage} / pageNumber:${pageNumber} 
			</div>
		</div>
	</div>
</div>



<script>
function reg(){
	if(confirm('등록하시겠습니까?')){
		regForm.submit();
	}
}
function move(value1, value2, value3){
	if(value1=='list'){
		location.href='${path}/memo_servlet/memo.do?pageNumber='+value2;
	}else if(value1=='view'){
		var param = "pageNumber="+value2+"&no="+value3;
		$.ajax({
			type: "post",
			data: param,
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			url: "${path}/memo_servlet/memo_view.do",
			success: function(result){
				var results = result.split('/');
				$("#id").val(results[0]);
				$("#content").val(results[1]);
			}
		});
	}
}





</script>
