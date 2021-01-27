<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<div>
	<input type="text" name="a" style="display:;"><br>
	<div style="display:none;">
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
function goChuga(){
	var param = {"pageNumber" : $("#span_pageNumber").text()};
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
			"search_date_check" : $("#span_search_date_check").text(),
			"search_date_s" : $("#span_search_date_s").text(),
			"search_date_e" : $("#span_search_date_e").text()
			};
	
	$.ajax({
			type: "post",
			data: param,
			url: "${path}/survey_servlet/list.do",
			success: function(data){
				$("#result").html(data);
				if($("#span_search_date_check").text()=="1"){
					//$("input[id=search_date_check]:checkbox").prop("checked", true);
					$("#search_date_check").prop("checked", true);
				}else{
					$("input[id=search_date_check]:checkbox").prop("checked", false);
				}
				if($("#span_search_option").text()=="question"){
					$("#op_question").prop("selected", true);
				}
				$("#search_data").val($("#span_search_data").text());
				$("#search_date_s").val($("#span_search_date_s").text());
				$("#search_date_e").val($("#span_search_date_e").text());
			}
		});
}
function suntaek_list(value1){
	$("#span_list_gubun").text(value1);
	$("#span_pageNumber").text(1);
	goList();
}
function goView(){
	var param = {
			"pageNumber" : $("#span_pageNumber").text(),
			"no" : $("#span_no").text()
			};
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
	if($('input:radio[name=answer]').is(':checked')){
		$.ajax({
			type: "post",
			data: $('form').serialize(),
			url: "${path}/survey_servlet/answer.do",
			success: function(result){
				if(result>0){
					alert('설문 제출 성공');
				}else{
					alert('설문 제출 실패');
				}
				goList();
				//$("#result").html(data);
			},
			error: function(result){
				alert('설문 제출 실패');
				goList();
			}
		}); 
	}else{
		alert('답을 선택해주세요.');
	}
}
function goModify(){
	var param = {
			"pageNumber" : $("#span_pageNumber").text(),
			"no" : $("#span_no").text()
			};
	$.ajax({
		type: "post",
		data: param,
		url: "${path}/survey_servlet/modify.do",
		success: function(data){
			$("#result").html(data);
		}
	});
}

function goModifyProc(){
	if(confirm('수정하시겠습니까?')){
		$.ajax({
				type: "post",
				data: $('form').serialize(),
				url: "${path}/survey_servlet/modifyProc.do",
				success: function(data){
					alert('수정 성공');
					$("#result").html(data);
				},
				error: function(){
					alert('수정 실패');
				}
			});
	}
}
function goResult(){
	var param = {
			"pageNumber" : $("#span_pageNumber").text(),
			"no" : $("#span_no").text()
			};
	$.ajax({
			type: "post",
			data: param,
			url: "${path}/survey_servlet/result.do",
			success: function(data){
				$("#result").html(data);
			}
		});
}
function suntaek_page(value1){
	$("#span_pageNumber").text(value1);
	goList();
}


</script>




    