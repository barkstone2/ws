<%@page import="java.util.regex.Pattern"%>
<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%
	MemberDAO dao = new MemberDAO();
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String passwdChk = request.getParameter("passwdChk");
	
	String pattern = "^[0-9a-z]*$";
	if(!Pattern.matches(pattern, passwd)){
		out.println("<script>alert('비밀번호에는 숫자와 영어 소문자만 입력할 수 있습니다.\\n다시 입력하세요.');location.href='change.jsp';</script>");
	}else if(!Pattern.matches(pattern, passwdChk)){
		out.println("<script>alert('비밀번호 확인에는 숫자와 영어 소문자만 입력할 수 있습니다.\\n다시 입력하세요.');location.href='change.jsp';</script>");
	}else if(!passwd.equals(passwdChk)){
		out.println("<script>alert('비밀번호가 일치하지 않습니다.');location.href='change.jsp';</script>");
	}else{
		int result = dao.setUpdate(passwd, id);
		if(result>0){
			out.println("<script>alert('비밀번호 수정 완료');location.href='main.jsp';</script>");
		}else{
			out.println("<script>alert('비밀번호 수정 중 오류 발생');location.href='change.jsp';</script>");
		}
	}
	
	
%>
