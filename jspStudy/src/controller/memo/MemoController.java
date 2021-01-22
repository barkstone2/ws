package controller.memo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.memo.dao.MemoDAO;
import model.memo.dto.MemoDTO;

@WebServlet("/memo_servlet/*")
public class MemoController extends HttpServlet {
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
		MemoDAO dao;
		String pageNumber_ = request.getParameter("pageNumber"); 
		int pageNumber = 
				pageNumber_==null||
				pageNumber_.trim().equals("")||
				!Pattern.matches("^[0-9]*$", pageNumber_)?
						1:Integer.parseInt(pageNumber_);
		
		if(url.indexOf("memo.do") != -1) {//메모장 페이지 이동
			dao = new MemoDAO();
			int conPerPage = 10;
			int pageNavLength = 5;
			int totalConCount = dao.getTotalCount();
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
			
			ArrayList<MemoDTO> list = dao.getListAll(startRecord, endRecord);
			request.setAttribute("list", list);
			gubun = "/memo/memo.jsp";
		}else if(url.indexOf("memoProc.do") != -1) {//메모작성 처리
			previousPageUrl += "/memo.do";
			gubun = "/memo/memo.jsp";
			page = "/message.jsp";
			reUrl = path + "/memo_servlet/memo.do";
			
			String id = request.getParameter("id");
			String content = request.getParameter("content");
			if(!referer.contains(previousPageUrl)) {
				msg = "비정상적인 접근입니다.";
			}else {
				id = replaceAll(id);
				content = replaceAll(content);
				dao = new MemoDAO();
				MemoDTO dto = new MemoDTO(id, content);
				int result = dao.setInsert(dto);
				if(result>0) {
					msg = "메모작성 성공";
				}else {
					msg = "메모작성 실패";
				}
			}
		}else if(url.indexOf("memo_view.do") != -1) {//메모상세 보기
			previousPageUrl += "/memo.do";
			gubun = "/memo/memo_view.jsp";
			String no_ = request.getParameter("no");
			int no = no_==null||no_.trim().equals("")||!Pattern.matches("^[0-9]*$", no_)?0:Integer.parseInt(no_);
			
			if(!referer.contains(previousPageUrl)) {
				msg = "비정상적인 접근입니다.";
				page = "/message.jsp";
				reUrl = path + "/memo_servlet/memo.do";
			}else {
				dao = new MemoDAO();
				MemoDTO dto = dao.getView(no);
				request.setAttribute("dto", dto);
				PrintWriter out = response.getWriter();
				String id = dto.getId();
				String content = dto.getContent();
				out.print(id+"/"+content);
				return;
			}
		}
		
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("reUrl", reUrl);
		request.setAttribute("msg", msg);
		request.setAttribute("menu_gubun", gubun);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	
	private String replaceAll(String target) {
		target = target.replace("&", "&amp;");
		target = target.replace("<", "&lt;");
		target = target.replace(">", "&gt;");
		target = target.replace("/", "&#47;");
		target = target.replace("'", "&apos;");
		target = target.replace("\"", "&quot;");
		return target;
	}
	
	private String replaceReturn(String target) {
		target = target.replace("&amp;","&");
		target = target.replace("&lt;","<");
		target = target.replace("&gt;",">");
		target = target.replace("&#47;","/");
		target = target.replace("&apos;","'");
		target = target.replace("&quot;","\"");
		return target;
	}

}
