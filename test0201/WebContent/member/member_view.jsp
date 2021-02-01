<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<h2>회원정보 상세보기</h2>
<table border="1">
	<tr>
		<td>
			회원번호
		</td>
		<td>
			${dto.no}
		</td>
	</tr>
	<tr>
		<td>
			아이디
		</td>
		<td>
			${dto.id}
		</td>
	</tr>
	<tr>
		<td>
			이름
		</td>
		<td>
			${dto.name}
		</td>
	</tr>
	<tr>
		<td>
			성별
		</td>
		<td>
			${dto.gender}
		</td>
	</tr>
	<tr>
		<td>
			태어난년도
		</td>
		<td>
			${dto.bornYear}
		</td>
	</tr>
	<tr>
		<td>
			주소
		</td>
		<td>
			${dto.bAddr} ${dto.sAddr} ${dto.rAddr}
		</td>
	</tr>
	<tr>
		<td>
			가입일
		</td>
		<td>
			${dto.regiDate}
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" value="회원정보수정" onclick="modify('${dto.no}');">
			<input type="button" value="JSON 보기" onclick="jsonView();">
		</td>
	</tr>
</table>
<hr>
	<div id="jsonDiv" style="display:none;">
		no : <span id="json_no"></span><br>
		id : <span id="json_id"></span><br>
		pw : <span id="json_pw"></span><br>
		name : <span id="json_name"></span><br>
		gender : <span id="json_gender"></span><br>
		bornYear : <span id="json_bornYear"></span><br>
		bAddr : <span id="json_bAddr"></span><br>
		sAddr : <span id="json_sAddr"></span><br>
		rAddr : <span id="json_rAddr"></span><br>
		regiDate : <span id="json_regiDate"></span><br>
	</div>

<script>
function jsonView(){
	var param = {
			"no" : '${dto.no}'
	}
	$.ajax({
		type: "post",
		data: param,
		datatype : "json",
		url: "${path}/member_servlet/jsonView.do",
		success: function(data){
			$("#jsonDiv").css("display","block");
			var json_sj = JSON.parse(data);
			$("#json_no").text(json_sj.no);
			$("#json_id").text(json_sj.id);
			$("#json_pw").text(json_sj.pw);
			$("#json_name").text(json_sj.name);
			$("#json_gender").text(json_sj.gender);
			$("#json_bornYear").text(json_sj.bornYear);
			$("#json_bAddr").text(json_sj.bAddr);
			$("#json_sAddr").text(json_sj.sAddr);
			$("#json_rAddr").text(json_sj.rAddr);
			$("#json_regiDate").text(json_sj.regiDate);
		}
	});
}
function modify(value1){
	location.href="${path}/member_servlet/modify.do?no="+value1
}
</script>