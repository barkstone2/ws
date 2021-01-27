<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_header.jsp" %>
<style>
.cell{
	display:flex;
	justify-content: center;
	align-items: center;
	border: 1px solid black;
	cursor: pointer;
	-ms-user-select: none; 
	-moz-user-select: -moz-none;
	-khtml-user-select: none;
	-webkit-user-select: none;
	user-select: none;
}
#result{
	max-width:320px;
	width:320px;
	max-height:80px;
	height:80px;
	resize:none;
	color: black;
	font-size: 30px;
	font-weight: bold;
	text-align: right;
	line-height:80px;
	border: black 1px solid;
}
#nowResult{
	border:none;
	width:320px;
	max-height:20px;
	height:20px;
	resize:none;
	display:block;
	text-align: right;
}
</style>
	<div>
		<div style="display:flex;">
			<div style="height:115px; display:block;">
				<textarea id="nowResult" readonly="readonly" disabled></textarea>
				<div style="display:flex;">
					<textarea id="result" readonly="readonly" disabled></textarea>
					<div style="height:86px; display:flex; align-items: center; margin-left:5px;">
						<div id="bSpace" class="cell" onclick="calc('bSpace');" style="width:40px; height:40px; display:flex; justify-content: center; align-items: center; border:1px solid black">&lt;-</div>
					</div>
				</div>
			</div>
		</div>
		<div style="display:flex; width:326px; height:80px">
			<div style="width:80px; height:80px;" class="cell" id="7" onclick="calc('7');">7</div>
			<div style="width:80px; height:80px;" class="cell" id="8" onclick="calc('8');">8</div>
			<div style="width:80px; height:80px;" class="cell" id="9" onclick="calc('9');">9</div>
			<div style="width:80px; height:80px;" class="cell" id="plus" onclick="calc('plus');">+</div>
		</div>
		<div style="display:flex; width:326px; height:80px">
			<div style="width:80px; height:80px;" class="cell" id="4" onclick="calc('4');">4</div>
			<div style="width:80px; height:80px;" class="cell" id="5" onclick="calc('5');">5</div>
			<div style="width:80px; height:80px;" class="cell" id="6" onclick="calc('6');">6</div>
			<div style="width:80px; height:80px;" class="cell" id="minus" onclick="calc('minus');">-</div>
		</div>
		<div style="display:flex; width:326px; height:80px">
			<div style="width:80px; height:80px;" class="cell" id="1" onclick="calc('1');">1</div>
			<div style="width:80px; height:80px;" class="cell" id="2" onclick="calc('2');">2</div>
			<div style="width:80px; height:80px;" class="cell" id="3" onclick="calc('3');">3</div>
			<div style="width:80px; height:80px;" class="cell" id="multipl" onclick="calc('multipl');">*</div>
		</div>
		<div style="display:flex; width:326px; height:80px">
			<div style="width:80px; height:80px;" class="cell" id="C" onclick="calc('C');">C</div>
			<div style="width:80px; height:80px;" class="cell" id="0" onclick="calc('0');">0</div>
			<div style="width:80px; height:80px;" class="cell" id="docal" onclick="calc('docal');">=</div>
			<div style="width:80px; height:80px;" class="cell" id="divide" onclick="calc('divide');">/</div>
		</div>
	</div>
<script>
var temp = '';
var i = 0;
var tempVal = 0;
var calcArray = new Array();
var numArray = new Array();
var opArray = new Array();
var op = '';
var k = 0;
var n = 0;
var nowTemp = '';
function calc(value1){
	var clickId = "#"+value1;
	$(clickId).css("backgroundColor", 'gray');
	setTimeout(function(){$(clickId).css("backgroundColor", 'transparent');},100);
	
	if(value1=='C'){
		temp = '';
		i = 0; 
		calcArray = new Array();
		numArray = new Array();
		opArray = new Array();
		op = '';
		k=0;
		tempVal = 0;
		n=0;
		nowTemp = '';
	}else if(value1=='plus'){
		if(temp!=''){
			calcArray[i++] = temp;
			calcArray[i++] = '+';
			nowTemp += temp + ' + ';
		}
		temp = '';
	}else if(value1=='minus'){
		if(temp!=''){
			calcArray[i++] = temp;
			calcArray[i++] = '-';
			nowTemp += temp + ' - ';
		}
		temp = '';
	}else if(value1=='multipl'){
		if(temp!=''){
			calcArray[i++] = temp;
			calcArray[i++] = '*';
			nowTemp += temp + ' * ';
		}
		temp = '';
	}else if(value1=='divide'){
		if(temp!=''){
			calcArray[i++] = temp;
			calcArray[i++] = '/';
			nowTemp += temp + ' / ';
		}
		temp = '';
	}else if(value1=='docal'){
		if(temp==''){
			$("#result").text('0');
			$("#nowResult").text('0 = ');
			return;
		}
		calcArray[i++] = temp;
		nowTemp += temp + ' = ';
		i = 0;
		for(var j=0; j<calcArray.length; j++){
			if(j==0||j%2==0){
				numArray[k] = calcArray[j];
				k++;
			}else{
				opArray[n] = calcArray[j];
				n++;
			}
		}
		tempVal = Number(numArray[0]);
		for(var g=0; g<numArray.length; g++){
			if(g==numArray.length){
				break;
			}
			op = opArray[g];
			
			if(op == '+'){
				tempVal += Number(numArray[g+1]);
			}else if(op == '-'){
				tempVal -= Number(numArray[g+1]);
			}else if(op == '*'){
				tempVal *= Number(numArray[g+1]);
			}else if(op == '/'){
				tempVal /= Number(numArray[g+1]);
			}
		}
		temp = Number(tempVal);
		calcArray = new Array();
		numArray = new Array();
		opArray = new Array();
		op = '';
		k=0;
		n= 0;
	}else if(value1=='bSpace'){
		temp = temp.substring(0,temp.length-1);
	}else{
		temp +=	value1;
	}
	
	$("#result").text(numberWithCommas(temp));
	$("#nowResult").text(nowTemp);
	if(tempVal!=0){
		temp='';
		tempVal='';
		nowTemp = '';
	}
}

function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

</script>