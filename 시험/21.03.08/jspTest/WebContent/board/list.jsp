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
	justify-content: flex-start;
	align-items: center;
}
#mList{
	width:1100px;
}
.mlistcon{
	display:flex;
	justify-content: flex-start;
	align-items: center;
}
.mlistcon, #listLabel {
	border-bottom: 1px solid black;
	height:45px;
	text-align: center;
}
.column1{
	border-right: 1px solid black;
	width:100px;
}
.column2{
	border-right: 1px solid black;
	width:600px;
	text-align: left;
	margin-left:15px;
}
.column3{
	border-right: 1px solid black;
	width:250px;
}
.column4{
	width:150px;
}
#memcount{
	margin-left: 10px;
	margin-bottom: 10px;
}

#pager {
	--display:flex;
	justify-content: center;
	padding: 10px;
}
#pager > div{
	padding: 5px;
}
#search_data{
	width: 400px;
}
#searchForm{
	display:flex;
	justify-content: center;
}
#searchForm > div {
	padding: 10px;
}
</style>

<div style="min-width:750px; width:1100px;">
	<div id="formTitle">
		<h2>게시글 목록</h2>
	</div>
	<div id="mList">
		<div id="memcount">
			* ${totalConCount}개의 게시글이 존재합니다.
		</div>
		<div id="listLabel">
			<div class="column1">
				순번
			</div>
			<div class="column2" style="text-align: center;">
				제목
			</div>
			<div class="column3">
				작성자
			</div>
			<div class="column4">
				작성일
			</div>
		</div>
	<c:forEach var="dto" items="${list}">
		<div class="mlistcon">
			<div class="column1">
				${jj}
			</div>
			<div class="column2">
				<a href="#" onclick="move('view','${pageNumber}','${dto.no}');">${dto.title}</a>
			</div>
			<div class="column3">
				${dto.name}
			</div>
			<div class="column4">
				${dto.regDate}
			</div>
		</div>
		<c:set var="jj" value="${jj = jj-1}"/>
	</c:forEach>
	</div>
	<div id="pager" style="${totalConCount>0?'display:flex;':'display:none;'}">
		<div><a href="#" onclick="move('list','1');">[첫페이지]</a></div>
		<c:if test="${startPage>pageNavLength}">
			<div><a href="#" onclick="move('list','${startPage-pageNavLength}');">[이전${pageNavLength}개]</a></div>
		</c:if>
		<c:if test="${startPage<=pageNavLength}">
			<div>[이전${pageNavLength}개]</div>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${lastPage}" step="1">
			<c:if test="${i==pageNumber}">
				<div>[${i}]</div>
			</c:if>
			<c:if test="${i!=pageNumber}">
				<div><a href="#" onclick="move('list','${i}');">${i}</a></div>
			</c:if>
		</c:forEach>
		<c:if test="${lastPage<totalPage}">
			<div><a href="#" onclick="move('list','${startPage+pageNavLength}');">[다음${pageNavLength}개]</a></div>
		</c:if>
		<c:if test="${lastPage>=totalPage}">
			<div>[다음${pageNavLength}개]</div>
		</c:if>
		<div><a href="#" onclick="move('list','${totalPage}','');">[끝페이지]</a></div>
	</div>
	<div id="btn">
		<div>
			<button type="button" onclick="move('reg','','');">게시글작성</button>
		</div>
	</div>
</div>

<script>
function move(v_location, v_pageNumber, v_no){
	var prefix = '${path}/board_servlet/';
	var suffix = '.do?no='+v_no+'&pageNumber='+v_pageNumber;
	var url = prefix + v_location + suffix;
	location.href = prefix+v_location+suffix;
}
</script>
