<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<form>
		이름 : <input type="text" name="name" id="name"><br>
		국어 : <input type="text" name="kor" id="kor"><br>
		영어 : <input type="text" name="eng" id="eng"><br>
		수학 : <input type="text" name="mat" id="mat"><br>
		과학 : <input type="text" name="sci" id="sci"><br>
		역사 : <input type="text" name="his" id="his"><br>
		<input type="button" value="제출" id="btnSave">
	</form>
	<hr>
	name : <span id="json_name"></span><br>
	kor : <span id="json_kor"></span><br>
	eng : <span id="json_eng"></span><br>
	mat : <span id="json_mat"></span><br>
	sci : <span id="json_sci"></span><br>
	his : <span id="json_his"></span><br>
	tot : <span id="json_tot"></span><br>
	avg : <span id="json_avg"></span><br>
	
	<div id="result_json"></div>
	
</body>
<script>
$(document).ready(function(){
	$("#btnSave").click(function(){
		json01Proc();
	});
});

function json01Proc(){
	var param = {
			"name" : $("#name").val(),
			"kor" : $("#kor").val(),
			"eng" : $("#eng").val(),
			"mat" : $("#mat").val(),
			"sci" : $("#sci").val(),
			"his" : $("#his").val()
	}
	$.ajax({
		type: "post",
		data: param,
		datatype : "json",
		url: "json02.jsp",
		success: function(data){
			//$("#result_json").text(data);
			var json_sj = JSON.parse(data);
			$("#json_name").text(json_sj.name);
			$("#json_kor").text(json_sj.kor);
			$("#json_eng").text(json_sj.eng);
			$("#json_mat").text(json_sj.mat);
			$("#json_sci").text(json_sj.sci);
			$("#json_his").text(json_sj.his);
			$("#json_tot").text(json_sj.tot);
			$("#json_avg").text(json_sj.avg);
		}
	});
	
}



</script>
</html>