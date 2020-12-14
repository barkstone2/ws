<%@page import="jdk.nashorn.internal.ir.annotations.Ignore"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("utf-8");%>
        
<%-- <%

	String name = request.getParameter("name");
%> --%>
    
				<table border="0" width="800" align="center">
					<tr height="50">
						<td colspan="5" align="right"><%=name%></td>
					</tr>
					<tr height="50">
						<td width="160" align="center">메뉴1</td>
						<td align="center">메뉴2</td>
						<td align="center">메뉴3</td>
						<td align="center">메뉴4</td>
						<td align="center">메뉴5</td>
					</tr>
				</table>
