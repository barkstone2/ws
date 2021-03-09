<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../include/inc_header.jsp" %>

<script>
	//구글 차트 라이브러리 로딩
	google.load('visualization', '1', {'packages':['corechart']});
	//로딩이 완료되면 drawChart 함수 호출
	google.charts.setOnLoadCallback(drawChart);

	function drawChart() {
		var jsonData = $.ajax({
			url : "${path}/chart/google_chart_Data1.json",
			dataType : "json",
			async : false
			}).responseText; //responseText;
        console.log(jsonData);
        //데이타 테이블 생성
        var data = new google.visualization.DataTable(jsonData);
        //var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
        //var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        
		chart.draw(data, {
			title : "차트 예제",
			curveType : "function",
			width : 600,
			height : 440
		});
	}
</script>

<div id="chart_div"></div>
<button id="btn" type="button" onclick="drawChart();">refresh</button>
