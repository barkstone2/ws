<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
		<div class="logo">
			<img src="">${path}
			${menu_gubun}
		</div>
		<div id="menu">
			<nav id="mainMenu" class="menu">
				<div>
					<a href="${path}">
						Home
					</a>
				</div>
				<div>
					<a href="${path}/member_servlet/list.do">
						회원관리
					</a>
				</div>
				<div>
					<a href="#">
						메모장
					</a>
				</div>
				<div>
					<a href="#">
						방명록
					</a>
				</div>
				<div>
					<a href="#">
						설문조사
					</a>
				</div>
				<div>
					<a href="#">
						게시판
					</a>
				</div>
				<div>
					<a href="#">
						쇼핑몰
					</a>
				</div>
				<div>
					<a href="#">
						관리자
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