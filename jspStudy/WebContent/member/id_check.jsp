<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<style>
#idCheckFrame{
	width:640px;
	height:480px;
	display:flex;
	justify-content: center;
	align-items: center;
}
</style>
	
	<div id="idCheckFrame">
		<div>
			<div style="text-align: center;">
				<h2>아이디 찾기</h2>
			</div>
			<div style="border: 1px solid black">
				<div style="margin: 20px; text-align: center;">
					아이디
				</div>
				<div style="margin: 20px; text-align: center;">
					<form name="idCheckForm" method="post" action="${path}/member_servlet/id_check_win_open_Proc.do">
						<input type="text" name="id" id="id" value="${inputId}">
					</form>
				</div>
				<div style="margin: 20px; text-align: center;">
					<label id="label_id" style="font-size: 12px;">
						${idCheckMsg}&nbsp;
					</label>
				</div>
				<div style="margin: 20px; text-align: center;">
					<input type="button" value="중복확인" onclick="search();">
					<input type="button" value="적용" onclick="save();">
				</div>
			</div>
		</div>
	</div>
	
<script>
function save(){
	var id = document.getElementById('id').value;
	if(confirm('해당 아이디를 사용하시겠습니까?')){
		opener.document.getElementById('id').value = id;
		window.close();
	}
}
function search(){
	idCheckForm.submit();
}
</script>