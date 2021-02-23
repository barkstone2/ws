<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>

<div id="result"></div>  

<c:if test="${menu_gubun=='/product/product_index.jsp'}">
	<script>
	$(document).ready(function(){
		goPage('list');
	});
	</script>
</c:if>

<script>
function goPage(v_location, v_pageNumber, v_bNo, v_passwd){
	var param = {
			"pageNumber" : v_pageNumber,
			"no" : v_bNo,
			"search_option" : '${search_option}',
			"search_data" : '${search_data}',
			"boardType" : '${boardType}',
			"bPasswd" : v_passwd
	};
	var prefix = "${path}/product_servlet/";
	var suffix = ".do";
	var url = prefix + v_location +suffix; 
	if(v_location=='chugaProc'){
		param = {
			"pName" : $("#pName").val(),
			"price" : $("#price").val(),
			"description" : $("#description").val()
		}
	}else if(v_location=='search'){
		url = "${path}/product_servlet/list.do";
		param = {
				"search_option" : $("#search_option").val(),
				"search_data" : $("#search_data").val()
		}
	}/* else if(v_location=='modifyProc'){
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
	}else if(v_location=='deleteProc'){
		param = {
				"bNo" : $("#bNo").val(),
				"bPasswd" : $("#bPasswd").val()
			}
	} */
				
	$.ajax({
			type: "post",
			data: param,
			url: url,
			success: function(data){
				if(/.*Proc/.exec(v_location)){
					alert(data);
					goPage('list');
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