<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<style>
.row{
	display:flex;
	padding: 10px;
	align-items: center;
	border-bottom:1px solid black;
}
.label{
	width:120px;
	text-align: center;
	border-right: 1px solid black;
}
#formTitle{
	text-align: center;
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
.column{
	border-right: 1px solid black;
	text-align: center;
	width:120px;
}
.oneLineCon{
	margin-left: 30px;
}
</style>


<div style="min-width:750px; min-height: 500px;">
	<div id="formTitle">
		<h2>방명록</h2>
	</div>
	<div>
		<select name="searchType" id="searchType">
			<option value="name">이름</option>
			<option value="content">내용</option>
			<option value="all">이름+내용</option>
		</select>
		<input type="text" name="searchValue" id="searchValue">
		<input type="button" value="검색" onclick="search();">
	</div>
	<div>
		<input type="button" value="글쓰기" onclick="move('write','','');">
	</div>
	<div id="memcount">
		* ${totalConCount}개의 방명록이 존재합니다.
	</div>
	<c:if test="${totalConCount==0}">
		<div style="text-align:center;">
			등록된 방명록이 없습니다.
		</div>
	</c:if>
	<c:forEach var="dto" items="${list}">
		<div style="border: 1px solid black; margin: 10px;">
			<div class="row">
				<div class="label">
					글번호
				</div>
				<div class="column">
					${dto.no}
				</div>
				<div class="label">
					작성자
				</div>
				<div class="column">
					${dto.name}
				</div>
				<div class="label">
					작성일
				</div>
				<div style="width:120; text-align: center;">
					${dto.regi_date}
				</div>
			</div>
			<div class="row">
				<div class="label">
					이메일
				</div>
				<div class="oneLineCon">
					${dto.email}
				</div>
			</div>
			<div>
				<div class="label">
				</div>
				<div style="height:40px; line-height:40px; margin-left:30px;">
					${dto.content}
				</div>
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
<script>
function move(value1, value2, value3){
	if(value1=='list'){
		location.href='${path}/guestbook_servlet/list.do?pageNumber='+value2;
	}else if(value1=='write'){
		location.href='${path}/guestbook_servlet/write.do?pageNumber='+value2;
	}
}
	
function search(){
	var searchType = document.getElementById("searchType");
	var searchValue = document.getElementById("searchValue");
	location.href='${path}/guestbook_servlet/search.do?searchType='+searchType+'&searchValue='+searchValue;
}
</script>