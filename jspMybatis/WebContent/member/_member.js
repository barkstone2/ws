
$(document).ready(function(){
});

var path;
var search_option;
var search_data;
var boardType;

function getPath(value1){path = value1;}
function getSearchOption(value1){search_option = value1;}
function getSearchData(value1){search_data = value1;}
function getBoardType(value1){boardType = value1;}


function goPage(v_location, v_pageNumber, v_no, v_passwd){
	var param = {
			"pageNumber" : v_pageNumber,
			"no" : v_no,
			"search_option" : search_option,
			"search_data" : search_data,
			"boardType" : boardType,
			"bPasswd" : v_passwd
	};
	var contentType;
	var processData;
	var prefix = path+"/member_servlet/";
	var suffix = ".do";
	var url = prefix + v_location +suffix;
	if(/.*Proc/.exec(v_location)){
		param = $('form').serialize();
		
	}else if(v_location=='search'){
		url = prefix + "list" +suffix;
		search_option = $("#search_option").val();
		search_data = $("#search_data").val();
		param = {
				"search_option" : search_option,
				"search_data" : search_data
		}
	}else if(v_location=='searchClear'){
		url = prefix + "list" +suffix;
		param = '';
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
				}else if(v_location=='view'){
					if(data=='권한이 없습니다.'){
						alert(data);
					}else{
						$("#result").html(data);
					}
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

function move(v_location, v_pageNumber, v_no){
	goPage(v_location, v_pageNumber, v_no);
}
