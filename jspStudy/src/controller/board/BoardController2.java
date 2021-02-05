package controller.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Util;
import common.UtilBoard;
import model.board.dao.BoardDAO;
import model.board.dto.BoardDTO;
import model.board.dto.BoardReplyDTO;

@WebServlet("/board_servlet2/*")
public class BoardController2 extends HttpServlet {
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
		Util util = new UtilBoard();
		
		String[] serverInfo = util.getServerInfo(request);
		
		String referer = serverInfo[0]; //이전 페이지 URL
		String path = serverInfo[1]; //컨텍스트 경로
		String url = serverInfo[2]; //전체주소
		String uri = serverInfo[3]; //도메인 주소를 제외한 주소
		String servletPath = serverInfo[4]; // 서블링 경로
		String ip = serverInfo[5];
		//String ip6 = serverInfo[6];
		
		
		String previousPageUrl = url.replace(uri,"") + path + servletPath;
		String gubun = ""; //main에 출력할 페이지
		String msg = ""; //Proc 처리 후 출력할 메시지
		String reUrl = ""; //Proc 처리 후 redirect 할 url
		String page = "/main/main.jsp"; //기본 포워딩 페이지
		
		int[] DateTime = util.getDateTime();
		Map<String,Integer> nowDate = new HashMap<>();
		nowDate.put("nowYear", DateTime[0]);
		nowDate.put("nowMonth", DateTime[1]);
		nowDate.put("nowDay", DateTime[2]);
		request.setAttribute("nowDate", nowDate);
		
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
		
		if(uri.indexOf("index.do") != -1) {
			gubun = "/board2/board_index.jsp";
			
		}else if(uri.indexOf("list.do") != -1) {
			page = "/board2/board_list.jsp";
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
			page = "/board2/board_chuga.jsp";
		}else if(uri.indexOf("chugaProc.do") != -1) {
			page = "/board2/board_list.do";
			previousPageUrl += "/chuga.do";
			String bSubject = request.getParameter("bSubject");
			String bWriter = request.getParameter("bWriter");
			String bContent = request.getParameter("bContent");
			String bPasswd = request.getParameter("bPasswd");
			String bSecretChk_ = request.getParameter("bSecretChk");
			int bSecretChk = util.numberCheck(bSecretChk_, 0);
			int maxGroupNo = dao.getMaxNo("bGroupNo", "board");
			BoardDTO dto = new BoardDTO();
			dto.setbSubject(bSubject);
			dto.setbWriter(bWriter);
			dto.setbContent(bContent);
			dto.setbSecretChk(bSecretChk);
			dto.setbPasswd(bPasswd);
			dto.setbGroupNo(maxGroupNo);
			int result = dao.setInsert(dto);
			if(result>0) {
				msg = "게시글 등록 성공";
				reUrl = "/board_servlet/list.do";
			}else {
				msg = "게시글 등록 실패";
				reUrl = "/board_servlet/chuga.do";
			}
		}else if(uri.indexOf("view.do") != -1) {
			gubun = "/board/board_view.jsp";
			String bNo_ = request.getParameter("bNo");
			int bNo = util.numberCheck(bNo_, 0);
			BoardDTO dto = dao.getView(bNo);
			request.setAttribute("dto", dto);
		}else if(uri.indexOf("replyList.do") != -1) {
			page = "/board/board_reply_list.jsp";
			String bNo_ = request.getParameter("bNo");
			int bNo = util.numberCheck(bNo_, 0);
			
			int conPerPage = 10;
			int pageNavLength = 5;
			int totalConCount = dao.getReplyCount(bNo);
					
			int jj = totalConCount - conPerPage * (pageNumber -1);
			int startRecord = conPerPage * (pageNumber -1) + 1;
			int endRecord = conPerPage * pageNumber;
			int totalPage = (int)Math.ceil((totalConCount / (double)conPerPage));
			int startPage = 1;
			int lastPage = 1;
			
			startPage = (pageNumber / pageNavLength - (pageNumber % pageNavLength!=0 ? 0:1)) * pageNavLength +1; 
			lastPage = startPage + pageNavLength -1;
			if(lastPage>totalPage)lastPage=totalPage;
			
			request.setAttribute("bNo", bNo);
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
			
			ArrayList<BoardReplyDTO> list = dao.getReply(bNo, startRecord, endRecord);
			request.setAttribute("list", list);
		}else if(uri.indexOf("replyReg.do") != -1) {
			page = "/board_servlet/replyList.do";
			String bNo_ = request.getParameter("bNo");
			int bNo = util.numberCheck(bNo_, 0);
			String rStepNo_ = request.getParameter("rStepNo");
			int rStepNo = util.numberCheck(rStepNo_, 0);
			String rWriter = request.getParameter("rWriter");
			String rPasswd = request.getParameter("rPasswd");
			String rContent = request.getParameter("rContent");
			int rGroupNo = dao.getMaxNo("rGroupNo", "board_reply");
			BoardReplyDTO dto = new BoardReplyDTO(bNo, rWriter, rContent, rPasswd, rGroupNo, rStepNo);
			dao.setInsertReply(dto);
		}else if(uri.indexOf("reReply.do") != -1) {
			page = "/board_servlet/replyList.do";
			String bNo_ = request.getParameter("bNo");
			int bNo = util.numberCheck(bNo_, 0);
			String rStepNo_ = request.getParameter("rStepNo");
			int rStepNo = util.numberCheck(rStepNo_, 1);
			String rWriter = request.getParameter("rWriter");
			String rPasswd = request.getParameter("rPasswd");
			String rContent = request.getParameter("rContent");
			String rGroupNo_ = request.getParameter("rGroupNo");
			int rGroupNo = util.numberCheck(rGroupNo_, dao.getMaxNo("rGroupNo", "board_reply"));
			BoardReplyDTO dto = new BoardReplyDTO(bNo, rWriter, rContent, rPasswd, rGroupNo, rStepNo);
			dao.setInsertReply(dto);
		}
		
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("reUrl", path+reUrl);
		request.setAttribute("msg", msg);
		request.setAttribute("menu_gubun", gubun);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
