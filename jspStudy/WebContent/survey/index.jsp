<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<div>
	<input type="text" name="a" style="display:;"><br>
	<div style="display:;">
		list_gubun : <span id="span_list_gubun">${list_gubun}</span><br>
		pageNumber : <span id="span_pageNumber">${pageNumber}</span><br>
		no : <span id="span_no">${no}</span><br>
		search_option : <span id="span_search_option">${search_option}</span><br>
		search_data : <span id="span_search_data">${search_data}</span><br>
		search_date_check : <span id="span_search_date_check">${search_date_check}</span><br>
		search_date_s : <span id="span_search_date_s">${search_date_s}</span><br>
		search_date_e : <span id="span_search_date_e">${search_date_e}</span><br>
	</div>
	<div id="result"></div>
</div>

<c:if test="${menu_gubun=='/survey/index.jsp'}">
	<script>
	$(document).ready(function(){
		goList();
	});
	</script>
</c:if>

<script>
function goChuga(value1){
	var param = "pageNumber="+value1;
	$.ajax({
			type: "post",
			data: param,
			url: "${path}/survey_servlet/chuga.do",
			success: function(data){
				$("#result").html(data);
			}
		});
}
function goChugaProc(){
	if(confirm('등록하시겠습니까?')){
		$.ajax({
				type: "post",
				data: $('form').serialize(),
				url: "${path}/survey_servlet/chugaProc.do",
				success: function(data){
					suntaek_page('1');
					alert('등록 성공');
					$("#result").html(data);
				},
				error: function(){
					alert('등록 실패');
				}
			});
	}
}
function goList(){
	//var param = "pageNumber="+pageNumber+"&no="+no;
	var param = {
			"list_gubun" : $("#span_list_gubun").text(),
			"pageNumber" : $("#span_pageNumber").text(),
			"search_option" : $("#span_search_option").text(),
			"search_data" : $("#span_search_data").text(),
			"search_date_s" : $("#span_search_date_s").text(),
			"search_date_e" : $("#span_search_date_e").text()
			};
	
	$.ajax({
			type: "post",
			data: param,
			url: "${path}/survey_servlet/list.do",
			success: function(data){
				$("#result").html(data);
				/* if($("#span_search_date_check").text()=="1"){
					$("input[id=search_date_check]:checkbox").prop("checked", true);
				}else{
					$("input[id=search_date_check]:checkbox").prop("checked", false);
				} */
			}
		});
}
function goView(value1, value2){
	var param = "pageNumber="+value1+"&no="+value2;
	$.ajax({
			type: "post",
			data: param,
			url: "${path}/survey_servlet/view.do",
			success: function(data){
				$("#result").html(data);
			}
		});
}
function goAnswer(){
	$.ajax({
			type: "post",
			data: $('form').serialize(),
			url: "${path}/survey_servlet/answer.do",
			success: function(data){
				$("#result").html(data);
			}
		});
}

function suntaek_page(value1){
	$("#span_pageNumber").text(value1);
}

</script>




    