<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../include/inc_header.jsp" %>

<div id="result"></div>  

<c:if test="${menu_gubun=='/shop/product/product_index.jsp'}">
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
	var contentType;
	var processData;
	var prefix = "${path}/product_servlet/";
	var suffix = ".do";
	var url = prefix + v_location +suffix; 
	if(v_location=='chugaProc'){
		contentType = false;
		processData = false;
		param = new FormData();
		param.append("pName", $("#pName").val());
		param.append("price", $("#price").val());
		param.append("description", $("#description").val());
		
		/* console.log($('input[name="files"]')[0].files[0]);
		console.log($('input[name="files"]')[1].files[0]);
		console.log($('input[name="files"]')[2].files[0]);
		return; */
		
		
		var file_counter = parseInt($('input[name="files"]').length);
		for(i=0; i<file_counter; i++){
			param.append(i, $('input[name="files"]')[i].files[0]);
		}
		
	}else if(v_location=='search'){
		url = "${path}/product_servlet/list.do";
		param = {
				"search_option" : $("#search_option").val(),
				"search_data" : $("#search_data").val()
		}
	}else if(v_location=='modifyProc'){
		contentType = false;
		processData = false;
		param = new FormData();
		param.append("no", $("#no").val());
		param.append("pName", $("#pName").val());
		param.append("price", $("#price").val());
		param.append("description", $("#description").val());
		
		var curImgCounter = $("input[name='curImgNames']").length;
		var curImgArr = new Array(curImgCounter);
		for(var i=0; i<curImgCounter; i++){                          
			curImgArr[i] = $("input[name='curImgNames']")[i].value;
		}
		param.append("curImgNames", curImgArr);
		
		var file_counter = parseInt($('input[name="files"]').length);
		for(i=0; i<file_counter; i++){
			param.append(i, $('input[name="files"]')[i].files[0]);
		}
	}
				
	$.ajax({
			type: "post",
			data: param,
			processData: processData,
			contentType: contentType,
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