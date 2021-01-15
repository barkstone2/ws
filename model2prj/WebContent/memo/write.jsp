<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jquery 라이브러리 로딩 -->
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
	memoList();
	$("#btnSave").click(function(){
		memoInsert();
	});
});
function memoInsert(){
	var writer = $('#writer').val();
	var content = $('#content').val();
	var param = "writer="+writer + 
				"&content="+content;//쿼리스트링
	$.ajax({
		type: "post", 
		data: param,
		url: "<%=path%>/memo_servlet/write.do",
		success: function(){//콜백함수
			memoList();
			$('#writer').val("");
			$('#content').val("");
		}
	});
	
}
function memoList(){
	var param = "searchType=&searchData=";
	$.ajax({
		type:"post",
		data:param,
		url:"<%=path%>/memo_servlet/list.do",
		success: function(aaa){
			$("#result").html(aaa);
		}
	})
}
</script>
</head>
<body>
	이름 : <input type="text" id="writer" size="10"><br>
	내용 : <input type="text" id="content" size="40"><br>
	<input type="button" id="btnSave" value="확인">
	
	<!-- 결과과 출력되는 영역 -->
	<div id="result"></div>	
	
</body>
</html>