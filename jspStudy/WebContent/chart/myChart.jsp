<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../include/inc_header.jsp" %>

<script>
	value1 = "${chart_type}";
	value2 = "${chart_subject}";
	value3 = "${chart_jsonFileName}";
	value4 = "";
	
	//구글 차트 라이브러리 로딩
	google.load('visualization', '1', {'packages':['corechart']});
	
	google.charts.setOnLoadCallback(drawChart);

	function drawChart(value1 = "${chart_type}", value2 = "${chart_subject}", 
						value3 = "${chart_jsonFileName}", value4 = "") {
		var jsonData = $.ajax({
			url : "${path}/attach/json/"+value3,
			dataType : "json",
			async : false
			}).responseText; //responseText;
        console.log(jsonData);
        //데이타 테이블 생성
        var data = new google.visualization.DataTable(jsonData);
        if(value1=='LineChart'){
	        var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
        }else if(value1=='ColumnChart'){
	        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        }else {
	        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        }
        
		chart.draw(data, {
			title : value2,
			curveType : value4, //curveType : "function"
			width : 600,
			height : 440
		});
	}
	
</script>

<div id="chart_div"></div>
<button id="btn" type="button" onclick="drawChart('PieChart', '${chart_subject}', '${chart_jsonFileName}', '');">PieChart</button>
<button id="btn" type="button" onclick="drawChart('LineChart', '${chart_subject}', '${chart_jsonFileName}', '');">LineChart(직선)</button>
<button id="btn" type="button" onclick="drawChart('LineChart', '${chart_subject}', '${chart_jsonFileName}', 'function');">LineChart(곡선)</button>
<button id="btn" type="button" onclick="drawChart('ColumnChart', '${chart_subject}', '${chart_jsonFileName}', '');">ColumnChart</button>

