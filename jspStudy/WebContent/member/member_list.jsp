<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<style>
#listLabel{
	display:flex;
	justify-content: center;
}
#mList{
	width:1000px;
	height:400px;
}
.mlistcon{
	display:flex;
	justify-content: center;
}
#formTitle {
	text-align: center;
}
.mlistcon, #listLabel {
	text-align: center;
}
.column1{
	border-right: 1px solid black;
	border-bottom: 1px solid black;
	width:60px;
}
.column2{
	border-right: 1px solid black;
	border-bottom: 1px solid black;
	width:120px;
}
.column3{
	border-right: 1px solid black;
	border-bottom: 1px solid black;
	width:130px;
}
.column4{
	border-right: 1px solid black;
	border-bottom: 1px solid black;
	width:120px;
}
.column5{
	border-right: 1px solid black;
	border-bottom: 1px solid black;
	width:100px;
}
.column6{
	border-right: 1px solid black;
	border-bottom: 1px solid black;
	width:120px;
}
.column7{
	border-bottom: 1px solid black;
	width:260px;
}
#memcount{
	margin-left: 20px;
	margin-bottom: 20px;
}
#btn{
	display:flex;
	justify-content: flex-end;
}
#btn > div {
	padding: 10px;
}
</style>
<div id="mList">
	<div id="formTitle">
		<h2>회원목록</h2>
	</div>
	<div id="memcount">
		* ${list.size()}명의 회원이 존재합니다.
	</div>
	<div id="listLabel">
		<div class="column1">
			순번
		</div>
		<div class="column2">
			아이디
		</div>
		<div class="column3">
			비밀번호
		</div>
		<div class="column4">
			이름
		</div>
		<div class="column5">
			성별
		</div>
		<div class="column6">
			출생년도
		</div>
		<div class="column7">
			가입일
		</div>
	</div>
<c:if test="${list.size()==0}">
	<div style="height:300px; text-align:center; line-height: 300px;">
		등록된 회원이 없습니다.
	</div>
</c:if>
<c:forEach var="dto" items="${list}">
	<div class="mlistcon">
		<div class="column1">
			${dto.no}
		</div>
		<div class="column2">
			<a href="#" onclick="move('view','','${dto.no}');">${dto.id}</a>
		</div>
		<div class="column3">
			${dto.pw}
		</div>
		<div class="column4">
			${dto.name}
		</div>
		<div class="column5">
			${dto.gender}
		</div>
		<div class="column6">
			${dto.bornYear}
		</div>
		<div class="column7">
			${dto.regi_date}
		</div>
	</div>
</c:forEach>
	<div id="btn">
		<div>
			<input type="button" value="회원가입" onclick="move('chuga','','');">
		</div>
	</div>	
</div>
<script>
function move(value1, value2, value3){
	if(value1 == 'chuga'){
		location.href='${path}/member_servlet/chuga.do';
	}else if(value1=='list'){
		location.href='${path}/member_servlet/list.do?pageNumber='+value2;
	}else if(value1=='view'){
		location.href='${path}/member_servlet/view.do?pageNumber='+value2+'&no='+value3;
	}
}
</script>