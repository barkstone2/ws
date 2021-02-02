<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
	<form name="regForm" method="post" action="${path}/member_servlet/regProc.do">
		<table border="1">
			<tr>
				<td colspan="2">
					<h2>회원가입</h2>
				</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" id="id">
					<input type="button" value="아이디찾기" onclick="id_check();">
					<input type="button" value="아이디찾기(새창)" onclick="id_check_window();">
				</td>
			</tr>
			<tr>
				<td>
					비밀번호
				</td>
				<td>
					<input type="password" name="pw" id="pw">
				</td>
			</tr>
			<tr>
				<td>
					비밀번호확인
				</td>
				<td>
					<input type="password" name="pwc" id="pwc">
				</td>
			</tr>
			<tr>
				<td>
					이름
				</td>
				<td>
					<input type="text" name="name" id="name">
				</td>
			</tr>
			<tr>
				<td>
					성별
				</td>
				<td>
					<input type="radio" value="M" name="gender">남자
					<input type="radio" value="F" name="gender">여자
				</td>
			</tr>
			<tr>
				<td>
					태어난년도
				</td>
				<td>
					<input type="text" name="bornYear" id="bornYear">
				</td>
			</tr>
			<tr>
				<td rowspan="3">
					주소
				</td>
				<td>
					<input type="text" name="postCode" id="postCode" readonly="readonly" placeholder="우편번호">
					<input type="button" value="우편번호 찾기" onclick="get_Postcode();">
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="bAddr" id="bAddr" readonly="readonly" placeholder="주소">
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="sAddr" id="sAddr" placeholder="상세주소">
					<input type="text" name="rAddr" id="rAddr" readonly="readonly" placeholder="참고항목">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="JOIN" onclick="reg();">
				</td>
			</tr>
		</table>
	</form>
<script>
function reg(){
	if($("#id").val()==''){
		alert('아이디를 입력하세요.');
		$("#id").focus();
	}else if($("#pw").val()==''){
		alert('비밀번호를 입력하세요.');
		$("#pw").focus();
	}else if($("#pwc").val()==''){
		alert('비밀번호 확인을 입력하세요.');
		$("#pwc").focus();
	}else if($("#name").val()==''){
		alert('이름을 입력하세요.');
		$("#name").focus();
	}else if(!$('input:radio[name=gender]').is(':checked')){
		alert('성별을 선택하세요.');
	}else if($("#bornYear").val()==''){
		alert('태어난년도를 입력하세요.');
		$("#bornYear").focus();
	}else if($("#postCode").val()==''){
		alert('우편번호를 입력하세요.');
		$("#postCode").focus();
	}else if($("#sAddr").val()==''){
		alert('상세주소를 입력하세요.');
		$("#sAddr").focus();
	}else if($("#pw").val()!=$("#pwc").val()){
		alert('비밀번호가 서로 일치하지 않습니다.');
		$("#pwc").focus();
	}else{
		regForm.submit();
	}
}
function id_check(){
	var id = $("#id").val();
	if(id==''){
		alert('아이디를 입력하세요.');
		$("#id").focus();
		return;
	}
	var param = "id=" + id;
	
	$.ajax({
		type: "post",
		data: param,
		url: "${path}/member_servlet/id_check.do",
		success: function(result){
			if(result>0){
				alert('사용할 수 없는 아이디입니다.');
				$("#id").val('');
				$("#id").focus();
			}else{
				alert('사용할 수 있는 아이디입니다.');
			}
		}
	});
}
function id_check_window(){
	window.open("${path}/member_servlet/id_check_win.do","idcheck", 'width=640, height=480, toolbar=no, menubar=no, scrollbars=no, resizable=no');
}
</script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function get_Postcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var bAddr = ''; // 주소 변수
                var rAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    bAddr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    bAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        rAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        rAddr += (rAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(rAddr !== ''){
                        rAddr = ' (' + rAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("rAddr").value = rAddr;
                
                } else {
                    document.getElementById("rAddr").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postCode').value = data.zonecode;
                document.getElementById("bAddr").value = bAddr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sAddr").focus();
            }
        }).open();
    }
</script>