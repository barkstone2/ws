package web.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.board.model.BoardDAO;
import web.board.model.BoardDTO;

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
		
		BoardDAO dao = new BoardDAO();
		String uri = request.getRequestURI();
		String page = "/board/list.jsp";
		String msg = "";
		String path = request.getContextPath(); 
		String reUrlPath = path + "/board_servlet/";
		String reUrl = "";
		String pageNumber_ = request.getParameter("pageNumber"); 
		int pageNumber = pageNumber_!=null&&!pageNumber_.equals("")?Integer.parseInt(pageNumber_):1;
		
		if(uri.indexOf("reg.do")!=-1) {
			page = "/board/reg.jsp";
		}else if(uri.indexOf("regProc.do")!=-1) {
			String name = request.getParameter("name");
			String content = request.getParameter("content");
			String title = request.getParameter("title");
			String pwd = request.getParameter("pwd");
			BoardDTO dto = new BoardDTO(name, title, content, pwd);
			int result = dao.insert(dto);
			reUrl = reUrlPath + "list.do";
			page = "/message.jsp";
			if(result>0) {
				msg = "게시글 등록 성공";
			}else {
				msg = "게시글 등록 실패";
			}
			
		}else if(uri.indexOf("list.do")!=-1) {
			page = "/board/list.jsp";
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
			List<BoardDTO> list = dao.getList(startRecord, endRecord);
			request.setAttribute("list", list);
		}else if(uri.indexOf("view.do")!=-1) {
			page = "/board/view.jsp";
			String no_ = request.getParameter("no");
			int no = no_!=null&&!no_.equals("")?Integer.parseInt(no_):0;
			BoardDTO dto = dao.getView(no);
			request.setAttribute("dto", dto);
		}else if(uri.indexOf("modify.do")!=-1) {
			String pwd = request.getParameter("pwd");
			String no_ = request.getParameter("no");
			int no = no_!=null&&!no_.equals("")?Integer.parseInt(no_):0;
			if(pwd==null||pwd.equals("")) {
				page = "/board/pwd_chk.jsp";
				request.setAttribute("no", no);
			}else {
				BoardDTO dto = dao.getView(no);
				if(dto.getPwd().equals(pwd)) {
					page = "/board/modify.jsp";
					request.setAttribute("dto", dto);
					
				}else {
					page ="/message.jsp";
					msg = "비밀번호가 일치하지 않습니다.";
					reUrl = reUrlPath + "modify.do?no="+no;
				}
				
			}
		}else if(uri.indexOf("modifyProc.do")!=-1) {
			String no_ = request.getParameter("no");
			int no = no_!=null&&!no_.equals("")?Integer.parseInt(no_):0;
			String name = request.getParameter("name");
			String content = request.getParameter("content");
			String title = request.getParameter("title");
			String pwd = request.getParameter("pwd");
			BoardDTO dto = new BoardDTO(name, title, content, pwd);
			dto.setNo(no);
			int result = dao.update(dto);
			reUrl = reUrlPath + "view.do?no="+no;
			page = "/message.jsp";
			if(result>0) {
				msg = "게시글 수정 성공";
			}else {
				msg = "게시글 수정 실패";
			}
		}else if(uri.indexOf("delete.do")!=-1) {
			page = "/board/delete.jsp";
			String no_ = request.getParameter("no");
			int no = no_!=null&&!no_.equals("")?Integer.parseInt(no_):0;
			BoardDTO dto = dao.getView(no);
			request.setAttribute("dto", dto);
		}else if(uri.indexOf("deleteProc.do")!=-1) {
			String no_ = request.getParameter("no");
			int no = no_!=null&&!no_.equals("")?Integer.parseInt(no_):0;
			String pwd = request.getParameter("pwd");
			int pwdChk = dao.pwdChk(no, pwd);
			
			reUrl = reUrlPath + "list.do";
			page = "/message.jsp";
			
			if(pwdChk==-1) {
				msg = "비밀번호가 일치하지 않습니다";
				reUrl = reUrlPath + "delete.do?no="+no;
			}else if(pwdChk==0) {
				msg = "잘못된 게시글 번호입니다.";
			}else if(pwdChk>0) {
				int result = dao.delete(no);
				
				if(result>0) {
					msg = "게시글 삭제 성공";
				}else {
					msg = "게시글 삭제 실패";
				}
			}
			
		}else {
			response.sendRedirect(path+"/board_servlet/list.do");
			return;
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("reUrl", reUrl);
		RequestDispatcher rd = request.getRequestDispatcher(page);	
		rd.forward(request, response);
		
	}

}
