<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<h2>회원정보 수정</h2>
<form name="modifyForm" method="post" action="${path}/member_servlet/modifyProc.do">
	<table border="1">
		<tr>
			<td>
				회원번호
			</td>
			<td>
				<input type="hidden" name="no" value="${dto.no}">
				${dto.no}
			</td>
		</tr>
		<tr>
			<td>
				아이디
			</td>
			<td>
				${dto.id}
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
				이름
			</td>
			<td>
				${dto.name}
			</td>
		</tr>
		<tr>
			<td>
				성별
			</td>
			<td>
				<input type="radio" name="gender" value="M">남자
				<input type="radio" name="gender" value="F">여자
			</td>
		</tr>
		<tr>
			<td>
				태어난년도
			</td>
			<td>
				<input type="text" name="bornYear" id="bornYear" value="${dto.bornYear}">
			</td>
		</tr>
		<tr>
			<td rowspan="3">
				주소
			</td>
			<td>
				<input type="text" name="postCode" id="postCode" value="${dto.postCode}">
				<input type="button" value="우편번호 찾기" onclick="get_Postcode();">
			</td>
		</tr>
		<tr>
			<td>
				<input type="text" name="bAddr" id="bAddr" value="${dto.bAddr}">
			</td>
		</tr>
		<tr>
			<td>
				<input type="text" name="sAddr" id="sAddr" value="${dto.sAddr}">
				<input type="text" name="rAddr" id="rAddr" value="${dto.rAddr}">
			</td>
		</tr>
		<tr>
			<td>
				가입일
			</td>
			<td>
				${dto.regiDate}
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="회원정보수정" onclick="modify();">
			</td>
		</tr>
	</table>
</form>
<script>
var genders = document.getElementsByName('gender');
var gender = '${dto.gender}';
if(gender==genders[0].value){
	genders[0].checked = true;
	genders[1].checked = false;
}else if(gender==genders[1].value){
	genders[1].checked = true;
	genders[0].checked = false;
}
function modify(){
	if($("#pw").val()==''){
		alert('비밀번호를 입력하세요.');
		$("#pw").focus();
	}else if($("#bornYear").val()==''){
		alert('태어난년도를 입력하세요.');
		$("#bornYear").focus();
	}else if($("#postCode").val()==''){
		alert('우편번호를 입력하세요.');
		$("#postCode").focus();
	}else if($("#sAddr").val()==''){
		alert('상세주소를 입력하세요.');
		$("#sAddr").focus();
	}else if($("#pw").val() != '${dto.pw}'){
		alert('비밀번호가 일치하지 않습니다.');
	}else{
		modifyForm.submit();
	}
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