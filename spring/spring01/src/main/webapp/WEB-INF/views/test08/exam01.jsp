<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form>
		id : <input type="text" name="id" id="id"><br>
		pwd : <input type="text" name="pwd" id="pwd"><br>
		<input type="button" value="로그인" onclick="login();">
	</form>
	
	<div id="result"></div>
	
<script>

function login(){
	var id = document.querySelector("#id").value;
	var pwd = document.querySelector("#pwd").value;
	var resultDiv = document.querySelector("#result");
	var value = "id="+id+"&pwd="+pwd;
	var xhr = new XMLHttpRequest(); 
	xhr.onreadystatechange = function() {
	  if (xhr.readyState === 4) {
	    if (xhr.status === 200) {
	    	resultDiv.innerHTML = xhr.responseText;
	       }
	    }
	};
	xhr.open("POST", "test08Proc.do");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send(value);
}
</script>
	

</body>
</html>