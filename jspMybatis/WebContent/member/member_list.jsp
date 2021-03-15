<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<style>
#listLabel{
	display:flex;
	justify-content: center;
	align-items: center;
}
#mList{
	min-width:900px;
	height:550px;
	min-height: 550px;
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
	width:80px;
}
.column2{
	border-right: 1px solid black;
	width:120px;
}
.column3{
	border-right: 1px solid black;
	width:130px;
}
.column4{
	border-right: 1px solid black;
	width:120px;
}
.column5{
	border-right: 1px solid black;
	width:100px;
}
.column6{
	border-right: 1px solid black;
	width:120px;
}
.column7{
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
<div id="mList">
	<div id="formTitle">
		<h2>회원목록</h2>
	</div>
	<div id="memcount">
		* ${totalConCount}명의 회원이 존재합니다.
	</div>
	<div id="listLabel">
		<div class="column1">
			회원번호
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
<c:if test="${totalConCount==0}">
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
			<a href="#" onclick="move('view','${pageNumber}','${dto.no}');">${dto.id}</a>
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
	<div>
		<form name="searchForm" id="searchForm" method="post" action="${path}/board_servlet2/list.do">
			<div>
				<select name="search_option" id="search_option">
					<option value="">-선택-</option>
					<option value="id" id="op_id">아이디</option>
					<option value="name" id="op_name">이름</option>
					<option value="gender" id="op_gender">이름</option>
					<option value="id_name_gender" id="op_id_name_gender">아이디+이름+성별</option>
				</select>
			</div>
			<div>
				<input type="text" name="search_data" id="search_data" value="${search_data}">
			</div>
			<div>
				<input type="button" value="검색" onclick="move('search','','');">
			</div>
			<div>
				<input type="button" value="전체목록" onclick="move('searchClear','','');">
			</div>
			<div id="btn">
				<input type="button" value="회원가입" onclick="move('reg','','');">
			</div>	
		</form>
	</div>
</div>
<script>
var search_option = '${search_option}';
if(search_option=='id'){
	$("#op_id").prop("selected",true);
}else if(search_option=='name'){
	$("#op_name").prop("selected",true);
}else if(search_option=='gender'){
	$("#op_gender").prop("selected",true);
}else if(search_option=='id_name_gender'){
	$("#op_id_name_gender").prop("selected",true);
}


</script>

<%-- <%
String pageNumber_ = "12a45";
char imsi;
for (int i=0; i<pageNumber_.length(); i++){
	imsi = pageNumber_.charAt(i);
	if(imsi >= '0' && imsi <='9'){
		out.println(imsi+"숫자다<br>");
	}else if(imsi >= 'a' && imsi <='z'){
		out.println(imsi+"영소문자다<br>");
	}else if(imsi >= 'A' && imsi <='Z'){
		out.println(imsi+"영대문자다<br>");
	}else{
		out.println(imsi+"그냥문자다<br>");
	}
}
%> --%>


