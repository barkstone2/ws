<%@page import="java.util.Iterator"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.Inet4Address"%>
<%@page import="board.model.dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.model.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
String referer = request.getHeader("REFERER");
String ip = Inet4Address.getLocalHost().getHostAddress();

String searchType = request.getParameter("searchType");
String searchData = request.getParameter("searchData");


if(searchType == null || searchData == null){
	searchType = null;
	searchData = null;
}
out.print("searchType : "+searchType+"<br>");
out.print("searchData : "+searchData+"<br>");

BoardDAO dao = new BoardDAO();

//전체 게시글의 갯수
int count = dao.getTotalRecordCount(searchType,searchData);
//화면에 보여질 갯수
int pageSize = 10;
//현재 페이지 번호
String pageNum = request.getParameter("pageNum");
if(pageNum==null || pageNum.length()<=0 || pageNum.equals("null"))pageNum = "1";

int currentPage = Integer.parseInt(pageNum);
//현재 페이지에 보여질 시작번호, 끝번호
int startRow = (currentPage-1)*pageSize + 1;
int endRow = currentPage * pageSize;
//테이블에 표시할 번호
int number = count - (currentPage-1) * pageSize;
int pageCount = 0;
int startPage = 1;
int endPage = 1;
if(count >0){
	pageCount = count / pageSize + (count % pageSize == 0 ? 0:1);
	if(currentPage % 10 != 0){
		startPage = (int)(currentPage /10) * 10 +1;
	}else{
		startPage = ((int)(currentPage/10)-1)*10 +1;
	}
	
	int pageBlock = 10; //카운링 처리 숫자
	endPage = startPage + pageBlock -1;//화면에 보여질 페이지의 마지막 숫자
	if(endPage > pageCount){
		endPage = pageCount;
	}
}

double totalPageDou = Math.ceil(count / (double)pageSize);
int totalPage = (int)totalPageDou;




out.print("count : "+count+"<br>");
out.print("currentPage : "+currentPage+"<br>");
out.print("startRow : "+startRow+"<br>");
out.print("endRow : "+endRow+"<br>");
out.print("number : "+number+"<br>");
out.print("pageCount : "+pageCount+"<br>");
out.print("startPage : "+startPage+"<br>");
out.print("endPage : "+endPage+"<br>");
dao = new BoardDAO();
ArrayList<BoardDTO> dtos = dao.getListAll(startRow,endRow,searchType,searchData);


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
referer : <%=referer %><br>
클라이언트IP: <%=request.getRemoteAddr() %><br>
요청URI: <%=request.getRequestURI() %><br>
컨텍스트경로: <%=request.getContextPath() %><br>
서버이름: <%=request.getServerName() %><br>
서버포트: <%=request.getServerPort() %><br>
<br>
requested URL: <%=request.getRequestURL() %><br>
requested Info: <%=request.getRequestURI() %><br>

create index 인덱스명 on 테이블명 (필드명);
drop index 인덱스명;

	
	
	
	<table border="1" width="600">
		<tr>
			<td>번호</td>
			<td width="200">제목</td>
			<td>글쓴이</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
<%
dao = new BoardDAO();

/* ArrayList<Integer> cList = new ArrayList<>();
for(int i=0; i<dtos.size(); i++){
	BoardDTO dto = dtos.get(i);
	if(dto.getParentNo()!=0){
		cList.add(dto.getParentNo());
	} 
}*/

for(int i=0; i<dtos.size(); i++){
	BoardDTO dto = dtos.get(i);
	int ref = dto.getRef();
	int no = dto.getNo();
	int re_step = dto.getRe_step();
	int maxReStep = dao.getMaxRestep(ref);
	
	/* int ansNum = 0;
	Iterator<Integer> it = cList.iterator();
	while(it.hasNext()){
		if(it.next()==no){
			ansNum++;	
		}
		
	} */
	
	//int ansNum = dao.getAnsNum(no);
	/* ArrayList<BoardDTO> childs = dao.getChild(no);
	ArrayList<ArrayList<BoardDTO>> llist = new ArrayList<>();
	for(int mrs=1; mrs<maxReStep; mrs++){
		for(int childN=0; childN<childs.size(); childN++){
			no = childs.get(childN).getNo();
			ansNum += dao.getAnsNum(no);
			llist.add(dao.getChild(no));
		}
		
		
	} */
	
	
	%>
		<tr>
			<td><%=number--%></td>
			<td><%for(int rs=1; rs<dto.getRe_step(); rs++){out.print("&nbsp;&nbsp;");} %><a href="view.jsp?no=<%=dto.getNo()%>
			&pageNum=<%=pageNum%><%if(searchType!=null&&searchData!=null) {%>
			&searchType=<%=searchType%>
			&searchData=<%=searchData%><%}%>"><%=dto.getSubject()+"("+dto.getChildNum()+")" %></a></td>
			<td><%=dto.getWriter() %></td>
			<td><%=dto.getRegi_date() %></td>
			<td><%=dto.getHit() %></td>
		</tr>
<%}

%>
	<tr>
		<td colspan="10" align="center">
			<a href="list.jsp?pageNum=<%=1%><%if(searchType!=null&&searchData!=null) {%>
			&searchType=<%=searchType%>
			&searchData=<%=searchData%><%}%>">첫페이지</a>
			<%if(startPage>10){%><a href="list.jsp?pageNum=<%=startPage-10%>
			<%if(searchType!=null&&searchData!=null) {%>
			&searchType=<%=searchType%>
			&searchData=<%=searchData%><%}%>">이전</a>&nbsp;
			<%} %>
			<%for(int n=startPage; n<=endPage; n++) {
				if(n==currentPage){%>
					<span style="color:red; font-weight: bold;">
					[<%=n%>]</span>
				<%}else{%>
					<a href="list.jsp?pageNum=<%=n%><%if(searchType!=null&&searchData!=null) {%>
			&searchType=<%=searchType%>
			&searchData=<%=searchData%><%}%>"><%=n%></a>&nbsp;	
				<%}%>
					
			<%}%>
			
			<%if(endPage<pageCount){%><a href="list.jsp?pageNum=<%=startPage+10%>
			<%if(searchType!=null&&searchData!=null) {%>
			&searchType=<%=searchType%>
			&searchData=<%=searchData%><%}%>">다음</a>
			<%} %>
			<a href="list.jsp?pageNum=<%=pageCount%><%if(searchType!=null&&searchData!=null) {%>
			&searchType=<%=searchType%>
			&searchData=<%=searchData%><%}%>">마지막페이지</a>
		</td>
	</tr>
	</table>
	<div style="display:flex; justify-content: center; width:600;">
		<form name="searchForm" method="post" action="listSearch.jsp">
			<select name="searchType">
				<option value="">-선택-</option>
				<option value="subject">제목</option>
				<option value="content">내용</option>
				<option value="all">제목+내용</option>
				<option value="writer">글쓴이</option>
			</select>
			<input type="text" name="searchData">
			<button type="button" onclick="search();">검색하기</button>
		</form>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="write.jsp">[글쓰기]</a>
	</div>
	<%dao.quitConn(); %>
</body>
<script>
	function search(){
		searchForm.submit();
	}
</script>
</html>