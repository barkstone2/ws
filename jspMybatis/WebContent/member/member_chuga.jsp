<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<style>
.row{
	display:flex;
	margin-bottom: 5px;
	align-items: center;
}
.label{
	width:120px;
	text-align: center;
}
#btn{
	display:flex;
	justify-content: center;
}
#radioInput{
	width:180px;
	display:flex;
	justify-content: space-around;
}
#formTitle{
	text-align: center;
}
.postcode{
	margin-bottom: 5px;
}
#postcode{
	width:120px;
}
#bAddr, #sAddr{
	width:350px;
}

</style>
<form name="regForm" method="post" action="${path}/member_servlet/chugaProc.do" style="width:500px;">
	<div id="formTitle">
		<h2>회원가입</h2>
	</div>
	<div class="row">
		<div class="label">
			아이디
		</div>
		<div>
			<input type="text" name="id" id="id">
			<input type="button" value="중복확인" onclick="id_check();">
			<input type="button" value="중복확인(새창)" onclick="id_check_win_open();">
		</div>
	</div>
	<div class="row">
		<div class="label">
		</div>
		<label id="label_id">
		</label>
	</div>
	<div class="row">
		<div class="label">
			비밀번호
		</div>
		<div>
			<input type="password" name="pw">
		</div>
	</div>
	<div class="row">
		<div class="label">
			비밀번호 확인
		</div>
		<div>
			<input type="password" name="pwc">
		</div>
	</div>
	<div class="row">
		<div class="label">
			이름
		</div>
		<div>
			<input type="text" name="name">
		</div>
	</div>
	<div class="row">
		<div class="label">
			성별
		</div>
		<div id="radioInput">
			<div>
				<input type="radio" name="gender" value="남자">남자
			</div>
			<div>
				<input type="radio" name="gender" value="여자">여자
			</div>
		</div>
	</div>
	<div class="row">
		<div class="label">
			태어난년도
		</div>
		<div>
			<input type="text" name="bornYear">
		</div>
	</div>
	<div class="row">
		<div class="label">
			주소
		</div>
		<div>
			<div class="postcode">
				<input type="text" id="postcode" name="postcode" placeholder="우편번호" readonly="readonly">
				<input type="button" onclick="getPostcode()" value="우편번호 찾기">
			</div>
			<div class="postcode">
				<input type="text" id="bAddr" name="bAddr" placeholder="주소" readonly="readonly">
			</div>
			<div class="postcode">
				<input type="text" id="sAddr" name="sAddr" placeholder="상세주소">
			</div>
			<div class="postcode">
				<input type="text" id="refAddr" name="refAddr" placeholder="참고항목" readonly="readonly">
			</div>
		</div>
	</div>
	<div id="btn">
		<input type="button" value="가입하기" onclick="reg();">
	</div>
	<div>
		<input type="hidden" id="checkedId" value="">
	</div>
</form>

<%-- <c:forEach var="id" items="${ids}">
	<input type="hidden" name="ids" value="${id}">
</c:forEach> --%>

<script>
function reg(){
	if(confirm('가입하시겠습니까?')){
		if($("#id").val()!=$("#checkedId").val()){
			alert('아이디 중복확인을 해주세요.');
		}else{
			goPage('regProc','','');
		}
	}
}

function id_check(){
	var id = $("#id").val();
	if(id==''){
		$("#label_id").html('아이디를 입력하세요.');
		$("#label_id").css('color', 'green');
		$("#label_id").css('font-size', '8px');
		return;
	}
	var param = "id=" + id;
	
	$.ajax({
		type: "post",
		data: param,
		url: "${path}/member_servlet/id_check.do",
		success: function(result){
			if(result>0){
				$("#id").val('');
				$("#label_id").html('사용할 수 없는 아이디입니다.');
				$("#label_id").css('color', 'red');
				$("#label_id").css('font-size', '8px');
			}else{
				$("#label_id").html('사용할 수 있는 아이디입니다.');
				$("#label_id").css('color', 'blue');
				$("#label_id").css('font-size', '8px');
				$("#checkedId").val(id);
				
			}
		}
	});
}
function id_check_win_open(){
	window.open("${path}/member_servlet/id_check_win.do","idcheck", 'width=640, height=480, toolbar=no, menubar=no, scrollbars=no, resizable=no');
}


/* function sameCheck(){
	var inputId = regForm.id.value;
	var ids = document.getElementsByName('ids');
	if(inputId==''){
		alert('아이디를 입력하세요.');
		regForm.id.focus;
		return;
	}
	for(var i=0; i<ids.length; i++){
		var id = ids[i].value;
		if(inputId==id){
			alert('중복된 아이디입니다.');
			regForm.id.focus;
			regForm.id.value = '';
			return;
		}
	}
	if(regForm.id.value != ''){
		alert('사용가능한 아이디입니다.');
		regForm.pw.focus();
	}
} */


</script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function getPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("refAddr").value = extraAddr;
                
                } else {
                    document.getElementById("refAddr").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("bAddr").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sAddr").focus();
            }
        }).open();
    }
</script>