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
function goPage(value1){
	var param = {};
	var url = "";
		//var param = "pageNumber="+pageNumber+"&no="+no;
		/* var param = {
				"list_gubun" : $("#span_list_gubun").text(),
				"pageNumber" : $("#span_pageNumber").text(),
				"search_option" : $("#span_search_option").text(),
				"search_data" : $("#span_search_data").text(),
				"search_date_check" : $("#span_search_date_check").text(),
				"search_date_s" : $("#span_search_date_s").text(),
				"search_date_e" : $("#span_search_date_e").text()
				}; */
	if(value1=='list'){
		url = "${path}/board_servlet2/list.do";
	}else if(value1=='chuga'){
		url = "${path}/board_servlet2/chuga.do";
	}else if(value1=='chugaProc'){
		//url = "${path}/board_servlet2/chugaProc.do";
		param = {
			"bSubject" : $("#bSubject").val(),
			"bWriter" : $("#bWriter").val(),
			"bPasswd" : $("#bPasswd").val(),
			"bSecretChk" : $("#bSecretChk").val(),
			"bContent" : $("#bContent").val(),
			"bEamil" : $("#bEamil").val(),
			"bNoticeChk" : $("#bNoticeChk").val()
		}
	}
		$.ajax({
				type: "post",
				//data: param,
				url: url,
				success: function(data){
					if(value1 == 'chugaProc'){
						suntaek_page('1');
					}else{
						$("#result").html(data);
					}
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