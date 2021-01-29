<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
		<div class="logo">
			<img src="">${path}
			${menu_gubun}<br>
			<%-- <c:set var="aaa" value="010-1111-2222"/>
			${fn:length(aaa)}<br>
			${fn:substring(aaa,0,3)}<br>
			${fn:substring(aaa,4,8)}<br>
			${fn:substring(aaa,9,13)}<br> --%>
			${fn:indexOf(fn:substringAfter(menu_gubun,'/'),'/')} /
			${fn:substringBefore(fn:substringAfter(menu_gubun,'/'),'/')}
		</div>
		<div id="menu">
			<nav id="mainMenu" class="menu">
				<div id="menuMove_main">
					<a href="${path}">
						Home
					</a>
				</div>
				<div id="menuMove_member">
					<a href="${path}/member_servlet/list.do">
						회원관리
					</a>
				</div>
				<div id="menuMove_memo">
					<a href="${path}/memo_servlet/memo.do">
						메모장
					</a>
				</div>
				<div id="menuMove_guestbook">
					<a href="${path}/guestbook_servlet/list.do">
						방명록
					</a>
				</div>
				<div id="menuMove_survey">
					<a href="${path}/survey_servlet/index.do">
						설문조사
					</a>
				</div>
				<div id="menuMove_survey2">
					<a href="${path}/survey_servlet2/list.do">
						설문조사2
					</a>
				</div>
				<div id="menuMove_board">
					<a href="#">
						게시판
					</a>
				</div>
				<div id="menuMove_shop">
					<a href="#">
						쇼핑몰
					</a>
				</div>
				<div id="menuMove_admin">
					<a href="#">
						관리자
					</a>
				</div>
				<div id="menuMove_util">
					<a href="${path}/util.do">
						유틸리티
					</a>
				</div>
			</nav>
			<nav id="userMenu" class="menu">
				<div>
					<div id="nologin">
						<a href="${path}/member_servlet/login.do">로그인</a>
					</div>
					<div id="yeslogin">
						<div>
							${cookName}님 환영합니다.
						</div>
						<div>
							<a href="${path}/member_servlet/modify.do">[회원정보수정]</a>
							<a href="${path}/member_servlet/delete.do">[회원탈퇴]</a>
							<a href="${path}/member_servlet/logout.do">[로그아웃]</a>
						</div>
					</div>
					<%-- <c:if test="${sessionScope.cookNo==null||sessionScope.cookNo == 0}">
						<div id="nologin">
							<a href="${path}/member_servlet/login.do">로그인</a>
						</div>
					</c:if>
					<c:if test="${sessionScope.cookNo!=null&&sessionScope.cookNo != 0}">
						<div id="yeslogin">
							<div>
								${cookName}님 환영합니다.
							</div>
							<div>
								[회원정보수정]
								[회원탈퇴]
								<a href="${path}/member_servlet/logout.do">[로그아웃]</a>
							</div>
						</div>
					</c:if> --%>
				</div>
			</nav>
		</div>
<script>
var cookId = '${cookId}';
if(cookId==''){
	document.getElementById('yeslogin').style.display='none';
	document.getElementById('nologin').style.display='block';
}else{
	document.getElementById('yeslogin').style.display='block';
	document.getElementById('nologin').style.display='none';
}
</script>

<script>
var selectedMenu = '${fn:substringBefore(fn:substringAfter(menu_gubun,'/'),'/')}';
var toChangeDivId = 'menuMove_'+selectedMenu;
document.getElementById(toChangeDivId).style.backgroundColor ='#dcdce6';
/* 
if(selectedMenu.indexOf('member')!=-1){
	document.getElementById(toChangeDivId).style.backgroundColor ='#dcdce6';
}else if(selectedMenu.indexOf('memo')!=-1){
	document.getElementById(toChangeDivId).style.backgroundColor ='#dcdce6';
}else if(selectedMenu.indexOf('guestbook')!=-1){
	document.getElementById(toChangeDivId).style.backgroundColor ='#dcdce6';
}else if(selectedMenu.indexOf('survey')!=-1){
	document.getElementById(toChangeDivId).style.backgroundColor ='#dcdce6';
}else if(selectedMenu.indexOf('board')!=-1){
	document.getElementById(toChangeDivId).style.backgroundColor ='#dcdce6';
}else if(selectedMenu.indexOf('shop')!=-1){
	document.getElementById(toChangeDivId).style.backgroundColor ='#dcdce6';
}else if(selectedMenu.indexOf('admin')!=-1){
	document.getElementById(toChangeDivId).style.backgroundColor ='#dcdce6';
}else if(selectedMenu.indexOf('main')!=-1){
	document.getElementById(toChangeDivId).style.backgroundColor ='#dcdce6';
} */
</script>