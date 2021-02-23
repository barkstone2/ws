package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.UtilBoard;
import model.product.dao.ProductDAO;
import model.product.dto.ProductDTO;

//@WebServlet("/product_servlet/*")
public class ProductController extends HttpServlet {
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
		UtilBoard util = new UtilBoard();
		
		//** ServerInfo **
		String[] serverInfo = util.getServerInfo(request);
		String referer = serverInfo[0]; //이전 페이지 URL
		String path = serverInfo[1]; //컨텍스트 경로
		String url = serverInfo[2]; //전체주소
		String uri = serverInfo[3]; //도메인 주소를 제외한 주소
		String servletPath = serverInfo[4]; // 서블링 경로
		String ip = serverInfo[5];
		//String ip6 = serverInfo[6];
		
		// ** 포워딩 & 메시지 출력 **
		String previousPageUrl = url.replace(uri,"") + path + servletPath; // 이전 페이지 URL
		String gubun = ""; //main에 출력할 페이지
		String msg = ""; //Proc 처리 후 출력할 메시지
		String reUrl = ""; //Proc 처리 후 redirect 할 url
		String page = "/main/main.jsp"; //기본 포워딩 페이지
		PrintWriter out = response.getWriter();
				
		// ** 현재 날짜 **
		int[] DateTime = util.getDateTime();
		Map<String,Integer> nowDate = new HashMap<>();
		nowDate.put("nowYear", DateTime[0]);
		nowDate.put("nowMonth", DateTime[1]);
		nowDate.put("nowDay", DateTime[2]);
		request.setAttribute("nowDate", nowDate);
		
		// ** 세션 처리 **
		String[] sessionInfo = util.sessionCheck(request);
		int cookNo = Integer.parseInt(sessionInfo[0]);
		String cookId = sessionInfo[1];
		String cookName = sessionInfo[2];
		
		
		// ** 공통 페이징 정보 **
		ProductDAO dao = new ProductDAO();
		String pageNumber_ = request.getParameter("pageNumber"); 
		int pageNumber = util.numberCheck(pageNumber_,1);
		String search_option = request.getParameter("search_option");
		String search_data = request.getParameter("search_data");
		String[] searchArray = util.searchCheck(search_option, search_data);
		search_option = searchArray[0];
		search_data = searchArray[1];
		
		
		
		String boardType = request.getParameter("boardType");
		boardType = util.boardTypeCheck(boardType, "free");
		
		
		request.setAttribute("boardType", boardType);
		request.setAttribute("search_option", search_option);
		request.setAttribute("search_data", search_data);
		
		if(uri.indexOf("index.do") != -1) {
			gubun = "/product/product_index.jsp";
			
		}else if(uri.indexOf("list.do") != -1) {
			page = "/product/product_list.jsp";
			
			int conPerPage = 10; // 페이지 당 개시글 수
			int pageNavLength = 5; // 페이징 범위
			// 공지글을 제외한 총 게시글 수
			int totalConCount = dao.getTotalCount(search_option, search_data);
			// 게시글 순번
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
			
			
			ArrayList<ProductDTO> list = dao.getListAll(startRecord, endRecord, search_option, search_data);
			
			request.setAttribute("list", list);
		}else if(uri.indexOf("chuga.do") != -1) {
			page = "/product/product_chuga.jsp";
		}else if(uri.indexOf("chugaProc.do") != -1) {
			//page = "/board2/board_list.jsp";
			reUrl = "/product_servlet2/index.do";
			previousPageUrl += "/chuga.do";
			
			String name = request.getParameter("pName");
			String price_ = request.getParameter("price");
			String description = request.getParameter("description");
			String product_img = "0";
			int price = util.numberCheck(price_, 0);
			
			ProductDTO dto = new ProductDTO();
			dto.setName(name);
			dto.setPrice(price);
			dto.setDescription(description);
			dto.setProduct_img(product_img);
			int result = dao.setInsert(dto);
			if(result>0) {
				msg = "게시글 등록 성공";
			}else {
				msg = "게시글 등록 실패";
			}
			
			out.print(msg);
			return;
		}else if(uri.indexOf("view.do") != -1) {
			page = "/product/product_view.jsp";
			String no_ = request.getParameter("no");
			int no = util.numberCheck(no_, 0);
			ProductDTO dto = dao.getView(no);
			request.setAttribute("dto", dto);
//		}else if(uri.indexOf("replyList.do") != -1) {
//			page = "/board2/board_reply_list.jsp";
//			String bNo_ = request.getParameter("bNo");
//			int bNo = util.numberCheck(bNo_, 0);
//			
//			int conPerPage = 10;
//			int pageNavLength = 5;
//			int totalConCount = dao.getReplyCount(bNo);
//					
//			int jj = totalConCount - conPerPage * (rePageNumber -1);
//			int startRecord = conPerPage * (rePageNumber -1) + 1;
//			int endRecord = conPerPage * rePageNumber;
//			int totalPage = (int)Math.ceil((totalConCount / (double)conPerPage));
//			int startPage = 1;
//			int lastPage = 1;
//			
//			startPage = (rePageNumber / pageNavLength - (rePageNumber % pageNavLength!=0 ? 0:1)) * pageNavLength +1; 
//			lastPage = startPage + pageNavLength -1;
//			if(lastPage>totalPage)lastPage=totalPage;
//			
//			request.setAttribute("bNo", bNo);
//			request.setAttribute("pageNumber", pageNumber);
//			request.setAttribute("rePageNumber", rePageNumber);
//			request.setAttribute("conPerPage", conPerPage);
//			request.setAttribute("pageNavLength", pageNavLength);
//			request.setAttribute("totalConCount", totalConCount);
//			request.setAttribute("jj", jj);
//			request.setAttribute("startRecord", startRecord);
//			request.setAttribute("endRecord", endRecord);
//			request.setAttribute("totalPage", totalPage);
//			request.setAttribute("startPage", startPage);
//			request.setAttribute("lastPage", lastPage);
//			
//			ArrayList<BoardReplyDTO> list = dao.getReply(bNo, startRecord, endRecord);
//			request.setAttribute("list", list);
//		}else if(uri.indexOf("replyReg.do") != -1) {
//			page = "/board_servlet2/replyList.do";
//			String bNo_ = request.getParameter("bNo");
//			int bNo = util.numberCheck(bNo_, 0);
//			String rStepNo_ = request.getParameter("rStepNo");
//			int rStepNo = util.numberCheck(rStepNo_, 0);
//			String rWriter = request.getParameter("rWriter");
//			String rPasswd = request.getParameter("rPasswd");
//			String rContent = request.getParameter("rContent");
//			int rGroupNo = dao.getMaxNo("rGroupNo", "board_reply2");
//			int rMemberNo = 0;
//			BoardReplyDTO dto = new BoardReplyDTO(bNo, rWriter, rContent, rPasswd, rGroupNo, rStepNo);
//			dto.setrIp(ip);
//			dto.setrMemberNo(rMemberNo);
//			dao.setInsertReply(dto);
//		}else if(uri.indexOf("reReply.do") != -1) {
//			page = "/board_servlet2/replyList.do";
//			String bNo_ = request.getParameter("bNo");
//			int bNo = util.numberCheck(bNo_, 0);
//			String rStepNo_ = request.getParameter("rStepNo");
//			int rStepNo = util.numberCheck(rStepNo_, 1);
//			String rWriter = request.getParameter("rWriter");
//			String rPasswd = request.getParameter("rPasswd");
//			String rContent = request.getParameter("rContent");
//			String rGroupNo_ = request.getParameter("rGroupNo");
//			int rGroupNo = util.numberCheck(rGroupNo_, dao.getMaxNo("rGroupNo", "board_reply2"));
//			int rMemberNo = 0;
//			BoardReplyDTO dto = new BoardReplyDTO(bNo, rWriter, rContent, rPasswd, rGroupNo, rStepNo);
//			dto.setrIp(ip);
//			dto.setrMemberNo(rMemberNo);
//			dao.setInsertReply(dto);
//		}else if(uri.indexOf("answer.do") != -1) {
//			page = "/board2/board_answer.jsp";
//			String bNo_ = request.getParameter("bNo");
//			int bNo = util.numberCheck(bNo_, 0);
//			BoardDTO2 dto = dao.getView(bNo);
//			int bGroupNo = dto.getbGroupNo();
//			int bStepNo = dto.getbStepNo();
//			int bLevelNo = dto.getbLevelNo();
//			request.setAttribute("bNo", bNo);
//			request.setAttribute("bGroupNo", bGroupNo);
//			request.setAttribute("bStepNo", bStepNo);
//			request.setAttribute("bLevelNo", bLevelNo);
//		}else if(uri.indexOf("answerProc.do") != -1) {
//			//page = "/board2/board_list.jsp";
//			reUrl = "/board_servlet2/index.do";
//			String bSubject = request.getParameter("bSubject");
//			String bWriter = request.getParameter("bWriter");
//			String bContent = request.getParameter("bContent");
//			String bPasswd = request.getParameter("bPasswd");
//			String bEmail = request.getParameter("bEmail");
//			
//			String bSecretChk_ = request.getParameter("bSecretChk");
//			String bNoticeNum_ = request.getParameter("bNoticeNum");
//			String bNo_ = request.getParameter("bNo");
//			String bGroupNo_ = request.getParameter("bGroupNo");
//			String bStepNo_ = request.getParameter("bStepNo");
//			String bLevelNo_ = request.getParameter("bLevelNo");
//			
//			int bSecretChk = util.numberCheck(bSecretChk_, 0);
//			int bNoticeNum = util.numberCheck(bNoticeNum_, 0);
//			int bNo = util.numberCheck(bNo_, 0);
//			int bGroupNo = util.numberCheck(bGroupNo_, 0);
//			int bStepNo = util.numberCheck(bStepNo_, 0);
//			int bLevelNo = util.numberCheck(bLevelNo_, 0);
//			
//			BoardDTO2 dto = new BoardDTO2();
//			dto.setBoardType(boardType);
//			dto.setbSubject(bSubject);
//			dto.setbWriter(bWriter);
//			dto.setbContent(bContent);
//			dto.setbSecretChk(bSecretChk);
//			dto.setbPasswd(bPasswd);
//			dto.setbEmail(bEmail);
//			dto.setbNoticeNum(bNoticeNum);
//			dto.setbIp(ip);
//			dto.setbMemberNo(cookNo);
//			dto.setbNo(bNo);
//			dto.setbGroupNo(bGroupNo);
//			dto.setbStepNo(bStepNo);
//			dto.setbLevelNo(bLevelNo);
//			
//			int result = dao.setAnswer(dto);
//			if(result>0) {
//				msg = "답변 등록 성공";
//			}else {
//				msg = "답변 등록 실패";
//			}
//			out.print(msg);
//			return;
//		}else if(uri.indexOf("modify.do") != -1) {
//			page = "/board2/board_modify.jsp";
//			String bNo_ = request.getParameter("bNo");
//			int bNo = util.numberCheck(bNo_, 0);
//			String bPasswd = request.getParameter("bPasswd");
//			bPasswd = util.nullCheck(bPasswd);
//			BoardDTO2 dto = dao.getView(bNo);
//			int accessChk = 0;
//			String viewMsg = "";
//			if(bPasswd.equals(dto.getbPasswd())) {
//				accessChk = 1;
//			}else if(bPasswd.equals("")){
//			}else {
//				viewMsg = "비밀번호가 일치하지 않습니다.";
//			}
//			request.setAttribute("viewMsg", viewMsg);
//			request.setAttribute("accessChk", accessChk);
//			request.setAttribute("dto", dto);
//		}else if(uri.indexOf("modifyProc.do") != -1) {
//			//page = "/board2/board_list.jsp";
//			//reUrl = "/board_servlet2/index.do";
//			String bNo_ = request.getParameter("bNo");
//			int bNo = util.numberCheck(bNo_, 0);
//			String bSubject = request.getParameter("bSubject");
//			String bWriter = request.getParameter("bWriter");
//			String bContent = request.getParameter("bContent");
//			String bPasswd = request.getParameter("bPasswd");
//			String bEmail = request.getParameter("bEmail");
//			String bSecretChk_ = request.getParameter("bSecretChk");
//			int bSecretChk = util.numberCheck(bSecretChk_, 0);
//			String bNoticeNum_ = request.getParameter("bNoticeNum");
//			int bNoticeNum = util.numberCheck(bNoticeNum_, 0);
//			BoardDTO2 dto = new BoardDTO2();
//			dto.setBoardType(boardType);
//			dto.setbSubject(bSubject);
//			dto.setbWriter(bWriter);
//			dto.setbContent(bContent);
//			dto.setbSecretChk(bSecretChk);
//			dto.setbPasswd(bPasswd);
//			dto.setbEmail(bEmail);
//			dto.setbNoticeNum(bNoticeNum);
//			dto.setbIp(ip);
//			dto.setbMemberNo(cookNo);
//			dto.setbNo(bNo);
//			int result = dao.setUpdate(dto);
//			if(result>0) {
//				msg = "게시글 수정 성공";
//			}else {
//				msg = "게시글 수정 실패";
//			}
//			out.print(msg);
//			return;
//		}else if(uri.indexOf("delete.do") != -1) {
//			page = "/board2/board_delete.jsp";
//			String bNo_ = request.getParameter("bNo");
//			int bNo = util.numberCheck(bNo_, 0);
//			request.setAttribute("bNo", bNo);
//		}else if(uri.indexOf("deleteProc.do") != -1) {
//			page = "/board2/board_index.jsp";
//			//reUrl = "/board_servlet2/index.do"; 
//			String bNo_ = request.getParameter("bNo");
//			int bNo = util.numberCheck(bNo_, 0);
//			String bPasswd = request.getParameter("bPasswd");
//			bPasswd = util.nullCheck(bPasswd);
//			BoardDTO2 dto = dao.getView(bNo);
//			if(bPasswd.equals(dto.getbPasswd())) {
//				dao = new BoardDAO2();
//				int result = dao.setDelete(bNo);
//				if(result>0) {
//					msg = "삭제 성공";
//				}else {
//					msg = "삭제 실패";
//				}
//			}else if(bPasswd.equals("")){
//			}else {
//				msg = "비밀번호가 일치하지 않습니다.";
//			}
//			out.print(msg);
//			return;
		}
		
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("reUrl", path+reUrl);
		request.setAttribute("msg", msg);
		request.setAttribute("menu_gubun", gubun);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
