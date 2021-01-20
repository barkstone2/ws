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
	
	/* var id = $("#id").val();
	if(id==''){
		$("#label_id").html('아이디를 입력하세요.');
		$("#label_id").css('color', 'green');
		$("#label_id").css('font-size', '12px');
		return;
	}
	var param = "id=" + id;
	
	$.ajax({
		type: "post",
		data: param,
		url: "${path}/member_servlet/id_check.do",
		success: function(result){
			if(result>0){
				$("#id").val('');
				$("#label_id").html('사용할 수 없는 아이디입니다.');
				$("#label_id").css('color', 'red');
				$("#label_id").css('font-size', '12px');
			}else{
				$("#label_id").html('사용할 수 있는 아이디입니다.');
				$("#label_id").css('color', 'blue');
				$("#label_id").css('font-size', '12px');
			}
		}
	}); */
}
</script>