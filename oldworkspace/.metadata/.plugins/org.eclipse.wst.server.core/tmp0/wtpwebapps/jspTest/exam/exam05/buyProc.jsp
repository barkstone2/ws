<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%
	
		int sum = 0;
		int counter = Integer.parseInt(request.getParameter("counter"));
		
		for(int i=1; i<=counter; i++){
			String price_ = request.getParameter("price"+i);
			
			if(price_.equals("")){
			} else{
				int price = Integer.parseInt(price_);
				sum += price;
			}
		}
		
		if(sum>100000){
			out.print("카드 한도 초과");
		}else{%>
			<table border="1">
			<%
			int nullChecker = 0;
			for(int i=1; i<=counter; i++){
				String pName = request.getParameter("pName"+i);
				String price_ = request.getParameter("price"+i);
				
				if(pName.equals("") && price_.equals("")){
					nullChecker++;
				}else if(pName.equals("") && !price_.equals("")){
					out.print(i+"번째 상품이름이 입력되지 않았습니다.<br>");
				}else if(!pName.equals("") && price_.equals("")){
					out.print(i+"번째 상품가격이 입력되지 않았습니다.<br>");
				}else{
					
					int price = Integer.parseInt(price_);	%>
					<tr>
					<td><%=pName%></td>
					<td>.....</td>
					<td><%=price %></td>
					</tr>
				<%
				}
				
			}
			if(nullChecker == counter){
				out.print("입력된 값이 없습니다.<br>");
			}
		}
	%>		
		
			<tr>
				<td colspan="3">----------------</td>
			</tr>
			<tr>
				<td>합계</td>
				<td>.......</td>
				<td><%=sum%></td>
			</tr>
		</table>
	
