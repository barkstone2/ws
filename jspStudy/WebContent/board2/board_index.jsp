<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>


<div id="result"></div>  

<c:if test="${menu_gubun=='/board2/board_index.jsp'}">
	<script>
	$(document).ready(function(){
		goPage('list');
	});
	</script>
</c:if>

<script>
function goPage(value1, value2, value3, value4, value5, value6){
	var param = {
			"pageNumber" : value2,
			"search_option" : value3,
			"search_data" : value4,
			"bNo" : value5,
			"bPasswd" : value6
	};
	var url = "";
		//var param = "pageNumber="+pageNumber+"&no="+no;
		/* var param = {
				"pageNumber" : $("#span_pageNumber").text(),
				"search_option" : $("#span_search_option").text(),
				"search_data" : $("#span_search_data").text()
				}; */
	if(value1=='list'){
		url = "${path}/board_servlet2/list.do";
	}else if(value1=='chuga'){
		url = "${path}/board_servlet2/chuga.do";
	}else if(value1=='chugaProc'){
		url = "${path}/board_servlet2/chugaProc.do";
		param = {
			"bSubject" : $("#bSubject").val(),
			"bWriter" : $("#bWriter").val(),
			"bPasswd" : $("#bPasswd").val(),
			"bSecretChk" : $("#bSecretChk").val(),
			"bContent" : $("#bContent").val(),
			"bEmail" : $("#bEmail").val(),
			"bNoticeNum" : $("#bNoticeNum").val()
		}
	}else if(value1=='search'){
		url = "${path}/board_servlet2/list.do";
		param = {
				"search_option" : $("#search_option").val(),
				"search_data" : $("#search_data").val()
		}
	}else if(value1=='view'){
		url = "${path}/board_servlet2/view.do";
	}else if(value1=='answer'){
		url = "${path}/board_servlet2/answer.do";
	}else if(value1=='answerProc'){
		url = "${path}/board_servlet2/answerProc.do";
		param = {
				"bSubject" : $("#bSubject").val(),
				"bWriter" : $("#bWriter").val(),
				"bPasswd" : $("#bPasswd").val(),
				"bSecretChk" : $("#bSecretChk").val(),
				"bContent" : $("#bContent").val(),
				"bEmail" : $("#bEmail").val(),
				"bNoticeNum" : $("#bNoticeNum").val(),
				"bNo" : $("#bNo").val(),
				"bGroupNo" : $("#bGroupNo").val(),
				"bStepNo" : $("#bStepNo").val(),
				"bLevelNo" : $("#bLevelNo").val()
			}
	}else if(value1=='modify'){
		url = "${path}/board_servlet2/modify.do";
	}else if(value1=='modifyProc'){
		url = "${path}/board_servlet2/modifyProc.do";
		param = {
				"bSubject" : $("#bSubject").val(),
				"bWriter" : $("#bWriter").val(),
				"bPasswd" : $("#bPasswd").val(),
				"bSecretChk" : $("#bSecretChk").val(),
				"bContent" : $("#bContent").val(),
				"bEmail" : $("#bEmail").val(),
				"bNoticeNum" : $("#bNoticeNum").val(),
				"bNo" : $("#bNo").val()
			}
	}else if(value1=='delete'){
		url = "${path}/board_servlet2/delete.do";
	}else if(value1=='deleteProc'){
		url = "${path}/board_servlet2/deleteProc.do";
		param = {
				"bNo" : $("#bNo").val(),
				"bPasswd" : $("#bPasswd").val()
			}
	}
				
	$.ajax({
			type: "post",
			data: param,
			url: url,
			success: function(data){
				$("#result").html(data);
				
				
				/* if($("#span_search_date_check").text()=="1"){
					//$("input[id=search_date_check]:checkbox").prop("checked", true);
					$("#search_date_check").prop("checked", true);
				}else{
					$("input[id=search_date_check]:checkbox").prop("checked", false);
				}
				if($("#span_search_option").text()=="question"){
					$("#op_question").prop("selected", true);
				} */
				/* $("#search_data").val($("#span_search_data").text());
				$("#search_date_s").val($("#span_search_date_s").text());
				$("#search_date_e").val($("#span_search_date_e").text()); */
			}
		});
}

function suntaek_page(value1){
	//$("#span_pageNumber").text(value1);
	goPage('list');
}
</script>