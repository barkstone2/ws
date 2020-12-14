<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
    
    
    <%
    String[] titles = {"이름", "국어", "영어", "수학", "과학", "역사", "총점", "평균", "등급"};
	String name = request.getParameter("name");
	String kor_ = request.getParameter("kor");
	String eng_ = request.getParameter("eng");
	String mat_ = request.getParameter("mat");
	String sci_ = request.getParameter("sci");
	String his_ = request.getParameter("his");
	
	int kor = Integer.parseInt(kor_);
	int eng = Integer.parseInt(eng_);
	int mat = Integer.parseInt(mat_);
	int sci = Integer.parseInt(sci_);
	int his = Integer.parseInt(his_);
	
	int tot = kor+eng+mat+sci+his;
	double avg = tot /5.0;
	String grade;
	if(avg>=90){
		grade="수";
	}else if(avg>=80){
		grade="우";
	}else if(avg>=70){
		grade="미";
	}else if(avg>=60){
		grade="양";
	}else{
		grade="가";
	}

	//response.sendRedirect("point2.jsp?name="+name+"&tot="+tot);
%>
<%-- <script>
	location.href = "point2.jsp?name=<%=name%>&tot=<%=tot%>";
</script> --%>

<%-- <form name="form" method="post" action="point2.jsp">
	<input type="text" name="name" value="<%=name %>">
	<input type="text" name=kor value="<%=kor %>">
	<input type="text" name="eng" value="<%=eng %>">
	<input type="text" name="mat" value="<%=mat %>">
	<input type="text" name="sci" value="<%=sci %>">
	<input type="text" name="his" value="<%=his %>">
	<input type="text" name="tot" value="<%=tot %>">
	<input type="text" name="avg" value="<%=avg %>">
	<input type="text" name="grade" value="<%=grade %>">
</form>
<script>
	document.form.submit();
</script> --%>



	<table border="1">
		<tr>
			<%for(int i=0; i<titles.length; i++) {%>
			<td><%=titles[i] %></td>
			<%} %>
		</tr>
		<tr>
			<td><%=name %></td>
			<td><%=kor %></td>
			<td><%=eng %></td>
			<td><%=mat %></td>
			<td><%=sci %></td>
			<td><%=his %></td>
			<td><%=tot %></td>
			<td><%=avg %></td>
			<%
			if(grade.equals("가")){%>
				<td style="color: red;"><%=grade %></td>
			<%}else{
			%>
				<td><%=grade %></td>
			<%} %>
		</tr>
	</table>
	

	
	
	