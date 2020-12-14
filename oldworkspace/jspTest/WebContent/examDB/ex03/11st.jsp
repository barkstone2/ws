<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<form name="form" method="post" action="11stProc.jsp">
		<div style="margin-bottom: 10px;">
			<div style="font-size: 20px; font-weight: bold;">
				상담정보
			</div>
			<div style="display: flex">
				<div style="margin-right:10px;">
					상담분류 : 
				</div>
				<div>
					<select name="qChoice">
						<option>선택</option>
						<option value="buy">구매관련</option>
						<option value="sell">판매관련</option>
					</select>
				</div>
			</div>
		</div>
		
		<div style="margin-bottom: 10px;">
			<div style="font-size: 20px; font-weight: bold;">
				회원정보
			</div>
			<div style="display: flex">
				<div style="margin-right:10px;">
					이름 :
				</div>
				<div>
					<input type="text" name="name">
				</div>
			</div>
			
			<div style="display: flex">
				<div style="margin-right:10px;">
					 연락처(선택) :
				</div>
				<div>
					<input type="text" name="phone">
				</div>
			</div>
			
			<div style="display: flex">
				<div style="margin-right:10px;">
					답변 E-Mail :
				</div>	
				<div>
					<input type="text" name="email">
				</div>
			</div>
		</div>
		
		<div style="margin-bottom: 10px;">
			<div style="font-size: 20px; font-weight: bold;">
				질문내용
			</div>
			
			<div style="display: flex">
				<div style="margin-right:10px;">
					제목 :
				</div>
				<div>
					<input type="text" name="subj">
				</div>
			</div>

			<div style="display: flex">
				<div style="margin-right:10px; display: flex; align-items: center;">
					내용 :
				</div>
				<div>
					<textarea rows="10" cols="40" name="content"></textarea>
				</div>
			</div>
		</div>
		
		<div>
			<input type="submit">
		</div>
	</form>
	
</body>
</html>