<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<style>
.row{
	display:flex;
	margin-bottom: 5px;
	border-bottom: 1px solid black;
	align-items: center;
	height:30px;
}
.row > :nth-child(2){
	margin-left: 15px;
}
.label{
	width:120px;
	text-align: center;
	border-right: 1px solid black;
}
#btn{
	display:flex;
	justify-content: center;
	margin-top: 20px;
}
#radioInput{
	width:180px;
	display:flex;
	justify-content: space-around;
}
#formTitle{
	text-align: center;
}
#btn > div {
	padding: 10px;
}
</style>    

<form name="modifyForm" method="post" action="modifyProc.do" width="300">
	<div id="formTitle">
		<h2>회원정보 수정</h2>
	</div>
	<div class="row">
		<div class="label">
			회원번호
		</div>
		<div>
			<input type="hidden" name="no" value="${dto.no}">
			${dto.no}
		</div>
	</div>
	<div class="row">
		<div class="label">
			아이디
		</div>
		<div>
			ID : ${dto.id} / 세션ID : ${cookId}
		</div>
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
			이름
		</div>
		<div>
			${dto.name}
		</div>
	</div>
	<div class="row">
		<div class="label">
			성별
		</div>
		<div id="radioInput">
			<div>
				<input type="radio" name="gender" value="남자" id='M'>남자
			</div>
			<div>
				<input type="radio" name="gender" value="여자" id='F'>여자
			</div>
		</div>
	</div>
	<div class="row">
		<div class="label">
			태어난년도
		</div>
		<div>
			<input type="text" name="bornYear" value="${dto.bornYear}">
		</div>
	</div>
	<div class="row">
		<div class="label">
			가입일
		</div>
		<div>
			${dto.regi_date}
		</div>
	</div>
	<div class="row">
		<div class="label">
			우편번호
		</div>
		<div>
			<input type="text" id="postcode" name="postcode" placeholder="우편번호" readonly="readonly" value="${dto.postcode}">
			<input type="button" onclick="getPostcode()" value="우편번호 찾기">
		</div>
	</div>
	<div class="row">
		<div class="label">
			기본주소
		</div>
		<div>
			<input type="text" id="bAddr" name="bAddr" placeholder="주소" readonly="readonly" value="${dto.bAddr}">
		</div>
	</div>
	<div class="row">
		<div class="label">
			상세주소
		</div>
		<div>
			<input type="text" id="sAddr" name="sAddr" placeholder="상세주소" value="${dto.sAddr}">
		</div>
	</div>
	<div class="row">
		<div class="label">
			참고주소
		</div>
		<div>
			<input type="text" id="refAddr" name="refAddr" placeholder="참고항목" readonly="readonly" value="${dto.refAddr}">
		</div>
	</div>
	<div id="btn">
		<div>
			<input type="button" value="수정하기" onclick="move('modifyProc','','');">
		</div>
		<div>
			<input type="button" value="돌아가기" onclick="move('view','${pageNumber}','${dto.no}');">
		</div>
		<div>
			<input type="button" value="목록으로" onclick="move('list','${pageNumber}','');">
		</div>
	</div>
</form>
<script>
var gender = '${dto.gender}';
if(gender == '남자'){
	document.getElementById('M').checked = true;
}else{
	document.getElementById('F').checked = true;
}

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
