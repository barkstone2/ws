package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Util;
import model.board.dao.BoardDAO;
import model.board.dto.BoardDTO;

@WebServlet("/board_servlet/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}
	
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String url = request.getRequestURL().toString(); //전체주소
		String uri = request.getRequestURI(); //도메인 주소를 제외한 주소
		String path = request.getContextPath(); //컨텍스트 경로
		String servletPath = request.getServletPath(); // 서블링 경로
		String previousPageUrl = url.replace(uri,"") + path + servletPath;
		String referer = request.getHeader("REFERER")!=null?(String)request.getHeader("REFERER"):"";//이전 페이지 URL
		String gubun = ""; //main에 출력할 페이지
		String msg = ""; //Proc 처리 후 출력할 메시지
		String reUrl = ""; //Proc 처리 후 redirect 할 url
		String page = "/main/main.jsp"; //기본 포워딩 페이지
		Util util = new Util();
		BoardDAO dao = new BoardDAO();
		String pageNumber_ = request.getParameter("pageNumber"); 
		int pageNumber = util.numberCheck(pageNumber_,1);
		
		String search_option = request.getParameter("search_option");
		String search_data = request.getParameter("search_data");
		String[] searchArray = util.searchCheck(search_option, search_data, "", "", "");
		
		search_option = searchArray[0];
		search_data = searchArray[1];
		
		request.setAttribute("search_option", search_option);
		request.setAttribute("search_data", search_data);
		
		if(uri.indexOf("list.do") != -1) {
			gubun = "/board/board_list.jsp";
			int conPerPage = 5;
			int pageNavLength = 5;
			
			int totalConCount = dao.getTotalCount(search_option, search_data);
			int jj = totalConCount - conPerPage * (pageNumber -1);
			
			int startRecord = conPerPage * (pageNumber -1) + 1;
			int endRecord = conPerPage * pageNumber;
			int totalPage = (int)Math.ceil((totalConCount / (double)conPerPage));
			int startPage = 1;
			int lastPage = 1;
			
			startPage = (pageNumber / pageNavLength - (pageNumber % pageNavLength!=0 ? 0:1)) * pageNavLength +1; 
			lastPage = startPage + pageNavLength -1;
			if(lastPage>totalPage)lastPage=totalPage;
			
			request.setAttribute("pageNumber", pageNumber);
			request.setAttribute("conPerPage", conPerPage);
			request.setAttribute("pageNavLength", pageNavLength);
			request.setAttribute("totalConCount", totalConCount);
			request.setAttribute("jj", jj);
			request.setAttribute("startRecord", startRecord);
			request.setAttribute("endRecord", endRecord);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("lastPage", lastPage);
			ArrayList<BoardDTO> list = dao.getListAll(startRecord, endRecord, search_option, search_data);
			request.setAttribute("list", list);
		}else if(uri.indexOf("chuga.do") != -1) {
			gubun = "/board/board_chuga.jsp";
		}else if(uri.indexOf("chugaProc.do") != -1) {
			page = "/message.jsp";
			previousPageUrl += "/chuga.do";
			String bSubject = request.getParameter("bSubject");
			String bWriter = request.getParameter("bWriter");
			String bContent = request.getParameter("bContent");
			String bPasswd = request.getParameter("bPasswd");
			String bSecretChk_ = request.getParameter("bSecretChk");
			int bSecretChk = util.numberCheck(bSecretChk_, 0);
			BoardDTO dto = new BoardDTO();
			dto.setbSubject(bSubject);
			dto.setbWriter(bWriter);
			dto.setbContent(bContent);
			dto.setbSecretChk(bSecretChk);
			dto.setbPasswd(bPasswd);
			int result = dao.setInsert(dto);
			if(result>0) {
				msg = "게시글 등록 성공";
				reUrl = "/board_servlet/list.do";
			}else {
				msg = "게시글 등록 실패";
				reUrl = "/board_servlet/chuga.do";
			}
		}
		
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("reUrl", path+reUrl);
		request.setAttribute("msg", msg);
		request.setAttribute("menu_gubun", gubun);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
