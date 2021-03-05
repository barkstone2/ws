<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../include/inc_header.jsp" %>
<style>
.row{
	display:flex;
	align-items: center;
	justify-content: center;
	margin-bottom: 5px;
}
.row-block{
	width: 80%;
	height: 80%;
	display:flex;
	align-items: center;
	justify-content: flex-start;
}
.content > div{
	text-align: center;
}
.content-block{
	width:300px;
	height:300px;
	display:flex;
	justify-content: center;
	align-items: center;
}
.content{
	width:297px;
	height:297px;
	margin:5px;
	border: 1px solid black;
	cursor: pointer;
}
.label{
	width:120px;
	text-align: center;
}
#btn{
	display:flex;
	justify-content: center;
}
#btn > div{
	margin-right:10px;
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
	height: 45px;
}
#mList{
	width:1200px;
	min-height: 400px;
}
.mlistcon{
	display:flex;
	justify-content: flex-start;
	align-items: center;
}
.mlistcon, #listLabel {
	border-bottom: 1px solid black;
	text-align: center;
}
.mlistcon{
	min-height:100px;
}
.mlistcon > div{
	min-height:70px;
	display: flex;
	align-items: center;
	justify-content: center;
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
<c:set var="nowYear" value="${nowDate.nowYear}"/>
<c:set var="nowMonth" value="${nowDate.nowMonth}"/>
<c:set var="nowDay" value="${nowDate.nowDay}"/>
<c:if test="${nowMonth<10}"><c:set var="nowMonth" value="0${nowDate.nowMonth}"/></c:if>
<c:if test="${nowDay<10}"><c:set var="nowDay" value="0${nowDate.nowDay}"/></c:if>
<c:set var="today" value="${nowYear}-${nowMonth}-${nowDay}"/>

<div style="min-width:750px; min-height: 500px; width:1200px;">
	<div id="formTitle">
		<h2>상품목록</h2>
	</div>
	<div id="mList">
		<div id="memcount">
			* ${totalConCount}개의 상품이 존재합니다.
		</div>
		
	<c:if test="${totalConCount==0}">
		<div style="text-align:center;">
			등록된 상품이 없습니다.
		</div>
	</c:if>
	
	<c:forEach var="i" begin="0" end="${list.size()}" step="3">
		<fmt:parseNumber var= "aa" integerOnly= "true" value= "${list.size()/3}" />
		<div class="row">
			<div class="row-block">
				<c:forEach var="dto" items="${list}" begin="${0+i}" end="${2+i}" step="1" >
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
					<div class="content-block">
						<div class="content" onclick="move('view','${pageNumber}','${dto.no}');">
							<div style="display:flex; align-items: center; justify-content: center;">
								<c:if test="${imgPath=='이미지X'}">
									<div style="width:250px; height:250px; display:flex; align-items: center; justify-content: center;">
										${imgPath}
									</div>
								</c:if>
								<c:if test="${imgPath!='이미지X'}">
									<img src="${imgPath}" width="250px" height="250px" />
								</c:if>
							</div>
							<div>
								${dto.name}
							</div>
							<div>
								<fmt:formatNumber type="number" maxFractionDigits="3" value="${dto.price}" />
							</div>
						</div>
					</div>
				</c:forEach>
				<c:if test="${i<12 and list.size()<(i+3) and i==aa*3}">
					<c:forEach begin="0" end="${(i+2)-list.size()}" step="1">
						<div class="content-block">
						<div class="content">
							<div style="display:flex; align-items: center; justify-content: center;">
							</div>
							<div>
							</div>
							<div>
							</div>
						</div>
					</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</c:forEach>
	<c:if test="${list.size()<12}">
		<c:forEach begin="0" end="${(9-i)/3-1}" step="1">
			<div class="row">
				<div class="row-block">
					<c:forEach begin="0" end="2" step="1">
						<div class="content-block">
							<div class="content">
								<div style="display:flex; align-items: center; justify-content: center;">
								</div>
								<div>
								</div>
								<div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</c:forEach>
	</c:if>
	
	
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
		<div><a href="#" onclick="move('list','${totalPage}');">[끝페이지]</a></div>
		<div style="display:none;" id="pagerInfo">
			conPerPage:${conPerPage} / pageNavLength:${pageNavLength} / totalConCount:${totalConCount}
			/ jj:${jj} / startRecord:${startRecord} <br>
			endRecord:${endRecord} / totalPage:${totalPage} / startPage:${startPage} / lastPage:${lastPage} / pageNumber:${pageNumber} 
		</div>
	</div>
	<div>
		<form name="searchForm" id="searchForm">
			<div>
				<select name="search_option" id="search_option">
					<option value="">-선택-</option>
					<option value="name" id="op_name">상품명</option>
					<option value="description" id="op_description">상품설명</option>
					<option value="nameDis" id="op_nameDis">상품명+상품설명</option>
				</select>
			</div>
			<div>
				<input type="text" name="search_data" id="search_data" value="${search_data}">
			</div>
			<div>
				<input type="button" value="검색" id="btnSearch">
			</div>
			<div id="btn">
				<div>
					<button type="button" id="btnCart">장바구니</button>
				</div>
			</div>
		</form>
	</div>
</div>

<script>
$(document).ready(function(){
	$("#btnCart").click(function(){
		goPage('cartList');
	});
	$("#btnSearch").click(function(){
		goPage('search','','');
	});
	
	var search_option = '${search_option}';
	if(search_option=='name'){
		$("#op_name").prop("selected",true);
	}else if(search_option=='description'){
		$("#op_description").prop("selected",true);
	}else if(search_option=='nameDis'){
		$("#op_nameDis").prop("selected",true);
	}
});

function move(v_location, v_pageNumber, v_bNo){
	goPage(v_location, v_pageNumber, v_bNo);
}


</script>
