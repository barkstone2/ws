<%@page import="board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<style>
.bdlAlign {
	text-align: center;
}
a {
	text-decoration: none;
	color: blue;
}
</style>
</head>
<body>
	<h2>게시글 목록</h2>
		<table width="800" border="1">
			<tr>
				<td class="bdlAlign">글번호</td>
				<td width="400" class="bdlAlign">제목</td>
				<td class="bdlAlign">작성자</td>
				<td class="bdlAlign">작성일</td>
				<td class="bdlAlign">조회수</td>
			</tr>
			<%
				BoardDAO dao = new BoardDAO();
				ArrayList<BoardDTO> list = dao.getListAll();
				
				int pageNum = 1;
				try{
					String pageNum_ = request.getParameter("pageNum");
					pageNum = Integer.parseInt(pageNum_);
				}catch(Exception e){
				}
				int maxCon = 10;
				int count = 1;
				int pageCount = (int)Math.ceil(list.size()/(double)maxCon);
				for(int i=list.size()-1-((pageNum-1)*maxCon); i>=0; i--){
					if(count>maxCon){
						count = 1;
						break;
					}else{
						count++;
						BoardDTO dto = list.get(i);
						
		%>
					<tr>
						<td class="bdlAlign" height=><%=dto.getRowNum() %></td>
						<td><a href="view.jsp?no=<%=dto.getNo()%>">
						<%
							if(dto.getStepNo()>1){
								for(int k=1; k<dto.getStepNo(); k++){
									out.print("&nbsp;&nbsp;");
								}
								for(int j=1; j<dto.getStepNo(); j++){%>
									Re:
								<%}
							}
						%>
						<%=dto.getSubject() %></a></td>
						<td class="bdlAlign"><%=dto.getWriter() %></td>
						<td class="bdlAlign"><%=dto.getRegiDate() %></td>
						<td class="bdlAlign"><%=dto.getHit() %></td>
					</tr>
		<%			}
				}
				if(list.size()==0){%>
					<tr align="center">
						<td colspan="5" height="400px">등록된 내용이 없습니다.</td>
					</tr>
				<%}
		%>
		</table>
		<br>
	<div style="text-align: center; width:800px;">
	<%
		int navNum = 1;
		try{
			String navNum_ = request.getParameter("navNum");
			navNum = Integer.parseInt(navNum_);
		}catch(Exception e){
		}
		int maxNavNum = 3;
		int navCount = (int)Math.ceil(pageCount/(double)maxNavNum);
		int count2 = 1;%>
			
		<a href="#" onclick="navMove('P');"><<</a>&nbsp;
		<%for(int i=((navNum-1)*maxNavNum)+1; i<=pageCount; i++){
			if(count2>maxNavNum){
				count2 = 1;
				break;
			}else{%>
				<a href="#" onclick="pageMove('<%=i%>');"><%=i %></a>&nbsp;
		<%}
			count2++;
		}%>
		<a href="#" onclick="navMove('N');">>></a>&nbsp;
	</div>
	
	<div style="width:800px; display: flex; justify-content: flex-end;">
		<a href="write.jsp">[글쓰기]</a>
	</div>
</body>
<script>
	function pageMove(value1){
		location.href='boardList.jsp?pageNum='+value1+'&navNum=<%=navNum%>';
	}
	
	function navMove(value1){
		if(value1=='P'){
			if(<%=navNum%>==1){
				alert('첫 페이지입니다.');
			}else{
				location.href='boardList.jsp?navNum=<%=navNum-1%>&pageNum=<%=pageNum%>';
			}
			
		}else{
			if(<%=navNum%>==<%=navCount%>){
				alert('마지막 페이지입니다.');
			}else{
				location.href='boardList.jsp?navNum=<%=navNum+1%>&pageNum=<%=pageNum%>';
			}
		}
		
	}

</script>
</html>