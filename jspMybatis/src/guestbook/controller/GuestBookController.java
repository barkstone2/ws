package guestbook.controller;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.model.dao.GuestBookDAO;
import guestbook.model.dto.GuestBookDTO;

@WebServlet("/guestbook_servlet/*")
public class GuestBookController extends HttpServlet {
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
		String pageNumber_ = request.getParameter("pageNumber"); 
		int pageNumber = 
				pageNumber_==null||
				pageNumber_.trim().equals("")||
				!Pattern.matches("^[0-9]*$", pageNumber_)?
						1:Integer.parseInt(pageNumber_);
		
		GuestBookDAO dao = null;
		
		if(url.indexOf("list.do") != -1) {
			dao = new GuestBookDAO();
			gubun = "/guestbook/guestbook_list.jsp";
			int conPerPage = 2;
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
			
			dao = new GuestBookDAO();
			List<GuestBookDTO> list = dao.getListAll(startRecord, endRecord);
			request.setAttribute("list", list);
		}else if(url.indexOf("write.do") != -1) {
			gubun = "/guestbook/guestbook_write.jsp";
		}else if(url.indexOf("writeProc.do") != -1) {
			page = "/message.jsp";
			reUrl = "/guestbook_servlet/list.do";
			previousPageUrl += "/write.do";
			String name = request.getParameter("name");
			String passwd = request.getParameter("passwd");
			String email = request.getParameter("email");
			String content = request.getParameter("content");
			
			name = replaceAll(name);
			content = replaceAll(content);
			
			if(!referer.contains(previousPageUrl)) {
				msg = "비정상적인 접근입니다.";
			}else if(!Pattern.matches("^[0-9a-z]*$", passwd)||passwd==null) {
				msg = "비밀번호에는 영문소문자와 숫자만 사용가능합니다.";
			}else if(!Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", email)||email==null) {
				msg = "잘못된 이메일 주소입니다.";
			}else {
				dao = new GuestBookDAO();
				GuestBookDTO dto = new GuestBookDTO(name, email, passwd, content);
				int result = dao.setInsert(dto);
				if(result>0) {
					msg = "방명록 작성 성공";
				}else {
					msg = "방명록 작성 실패";
					reUrl = "/guestbook_servlet/write.do";
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
	
	private String replaceAll(String target) {
		target = target.replace("&", "&amp;");
		target = target.replace("<", "&lt;");
		target = target.replace(">", "&gt;");
		target = target.replace("/", "&#47;");
		target = target.replace("'", "&apos;");
		target = target.replace("\"", "&quot;");
		return target;
	}
}
