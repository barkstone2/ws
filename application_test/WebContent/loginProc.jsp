<%@page import="java.util.regex.Pattern"%>
<%@page import="java.util.Date"%>
<%@page import="model.MemberDTO"%>
<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%
		
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String pattern = "^[0-9a-z]*$";
	if(!Pattern.matches(pattern, id)){
		out.println("<script>alert('아이디에는 숫자와 영어 소문자만 입력할 수 있습니다.\\n다시 입력하세요.');location.href='login.jsp';</script>");
	}else if(!Pattern.matches(pattern, passwd)){
		out.println("<script>alert('비밀번호에는 숫자와 영어 소문자만 입력할 수 있습니다.\\n다시 입력하세요.');location.href='login.jsp';</script>");
	}else{
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getLogin(id,passwd);
		
		if(dto==null){
			out.println("<script>alert('아이디나 비밀번호가 일치하지 않습니다.\\n다시 입력하세요.');location.href='login.jsp';</script>");
		}else{
			long day = 24 * 60 * 60 * 1000;
			long month = day * 30;
			
			Date nowDate = new Date();
			Date changeDate = dto.getChangeDate();
			
			long timeDiff = nowDate.getTime() - changeDate.getTime();
			long monthDiff = timeDiff / month;
			
			session.setMaxInactiveInterval(60);
			session.setAttribute("cookId", dto.getId());
			
			if(monthDiff>=6){
				out.println("<script>alert('비밀번호를 수정한지 6개월이 지났습니다.\\n비밀번호를 수정하세요.');location.href='change.jsp';</script>");
			}else{
				out.println("<script>alert('로그인 성공\\n메인페이지로 이동합니다.');location.href='main.jsp';</script>");
			}
		}
	}
	
%>
    