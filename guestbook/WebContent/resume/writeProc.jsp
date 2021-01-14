<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="resume.ResumeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="resume.ResumeDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<%	
	String upload_path = application.getRealPath("/upload/img/");
	//String upload_path = "C:/upload";
	int maxSize = 10 * 1024 * 1024;
	String filename = "";
	
	try{
		MultipartRequest multi = new MultipartRequest(request, upload_path, maxSize, new DefaultFileRenamePolicy());
		Enumeration<?> files = multi.getFileNames();
		String file1 = (String)files.nextElement();
		
		filename = multi.getFilesystemName(file1);
		
	}catch(Exception e){
		e.printStackTrace();
	}

	System.out.println(filename);
	
	/* ResumeDAO dao = new ResumeDAO();
	int result = dao.setInsert(dto);
	if(result>0){
		out.println("<script>alert('성공');location.href='list.jsp';</script>");
	}else{
		out.println("<script>alert('실패');location.href='write.jsp';</script>");
	} */
%>
    
    
