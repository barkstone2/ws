package shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

import common.UtilBoard;
import shop.model.dao.CartDAO;
import shop.model.dao.ProductDAO;
import shop.model.dto.CartDTO;
import shop.model.dto.ProductDTO;

/**
 * Servlet implementation class MallController
 */
@WebServlet("/mall_servlet/*")
public class MallController extends HttpServlet {
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
		Map<String,Integer> nowDate = util.getDateTime();
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
			gubun = "/shop/mall/mall_index.jsp";
			
		}else if(uri.indexOf("list.do") != -1) {
			page = "/shop/mall/mall_list.jsp";
			
			int conPerPage = 12; // 페이지 당 개시글 수
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
		}else if(uri.indexOf("view.do") != -1) {
			page = "/shop/mall/mall_view.jsp";
			String no_ = request.getParameter("no");
			int no = util.numberCheck(no_, 0);
			ProductDTO dto = dao.getView(no);
			request.setAttribute("dto", dto);
		}else if(uri.indexOf("addProc.do") != -1) {
			
			if(cookNo==0) {
				out.print("로그인 후 이용하세요");
				return;
			}
			
			String productNo_ = request.getParameter("no");
			int productNo = util.numberCheck(productNo_, 0);
			
			CartDAO cartDao = new CartDAO();
			CartDTO dto = new CartDTO();
			
			int amount = cartDao.checkCart(cookNo, productNo);
			
			dto.setMemberNo(cookNo);
			dto.setProductNo(productNo);
			dto.setAmount(amount);
			int result = 0;
			if(amount>1) {
				result = cartDao.updateAmount(dto);
			}else {
				result = cartDao.add(dto);
			}
			
			if(result>0) {
				out.print("장바구니 추가 성공");
				return;
			}else {
				out.print("장바구니 추가 실패");
				return;
			}
			
		}else if(uri.indexOf("cart.do") != -1) {
			page = "/shop/mall/mall_cart_list.jsp";
			if(cookNo==0) {
				out.print("로그인 후 이용하세요");
				return;
			}
			
			CartDAO cartDao = new CartDAO();
			List<CartDTO> list = cartDao.getList(cookNo);
			request.setAttribute("list", list);
		}else if(uri.indexOf("deleteAllProc.do") != -1) {
			
			if(cookNo==0) {
				out.print("로그인 후 이용하세요");
				return;
			}
			
			CartDAO cartDao = new CartDAO();
			
			int result = cartDao.deleteAll(cookNo);
			
			if(result>0) {
				out.print("장바구니를 비웠습니다.");
				return;
			}else {
				out.print("장바구니 비우기 실패");
				return;
			}
			
		}else if(uri.indexOf("deleteProc.do") != -1) {
			if(cookNo==0) {
				out.print("로그인 후 이용하세요");
				return;
			}
			
			String[] productNoArr = request.getParameterValues("productNos");
			
			if(productNoArr.length>0) {
				CartDAO cartDao = new CartDAO();
				
				int[] resultArr = cartDao.delete(productNoArr);
				int result = 1;
				for(int i=0; i<resultArr.length; i++) {
					if(resultArr[i]==Statement.EXECUTE_FAILED) {
						result = 0;
					}
				}
				
				if(result>0) {
					out.print("선택한 항목을 장바구니에서 삭제했습니다.");
					return;
				}else {
					out.print("선택 항목 삭제 실패");
					return;
				}
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
