<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
function test01(){
	$("#d1").show();
	$("#d2").hide();
	$("#d3").hide();
}
function test02(){
	$("#d1").hide();
	$("#d2").show();
	$("#d3").hide();
}
function test03(){
	$("#d1").hide();
	$("#d2").hide();
	$("#d3").show();
}
</script>
</head>
<body>
		
	<button type="button" id="btn01" onclick="test01();">버튼1</button>
	<button type="button" id="btn02" onclick="test02();">버튼2</button>
	<button type="button" id="btn03" onclick="test03();">버튼3</button>
	
	<br><br>
	
	<div id="d1" style="display: none;">
		<textarea id="t1" style="width:100%; height: 50px;">01</textarea>
	</div>
	
	<div id="d2" style="display: none;">
		<textarea id="t1" style="width:100%; height: 50px;">02</textarea>
	</div>
		
	<div id="d3" style="display: none;">
		<textarea id="t3" style="width:100%; height: 50px;">03</textarea>
	</div>	
	
</body>
</html>