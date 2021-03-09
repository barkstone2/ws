<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../include/inc_header.jsp" %>

<div id="result"></div>

<c:if test="${menu_gubun=='/email/email_index.jsp'}">
	<script>
		$(document).ready(function(){
			goPage('chuga');
		});
	</script>
</c:if>
<script>
	function goPage(value1){
		var url = "${path}/email_servlet/" + value1 + ".do";
		
		if(value1 == 'chuga'){
			var param = {}
		}else if(value1 == 'chugaProc'){
			var param = {
					"fromName" : $("#fromName").val(),
					"fromEmail" : $("#fromEmail").val(),
					"toEmail" : $("#toEmail").val(),
					"subject" : $("#subject").val(),
					"content" : $("#content").val()
			}
		}
		
		$.ajax({
			type: "post",
			data: param,
			url: url,
			success: function(data){
				if(value1 == 'chuga'){
					$("#result").html(data);
				}else{
					goPage('chuga');
				}
			}
		});
	}	
</script>