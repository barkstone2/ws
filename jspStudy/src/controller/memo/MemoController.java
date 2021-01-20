package controller.memo;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
		
		String path = request.getContextPath();
		String url = request.getRequestURL().toString();
		
		String gubun = ""; //main에 출력할 페이지
		String msg = ""; //Proc 처리 후 출력할 메시지
		String reUrl = ""; //Proc 처리 후 redirect 할 url
		String page = "/main/main.jsp"; //기본 포워딩 페이지
		MemoDAO dao;
		
		if(url.indexOf("memo.do") != -1) {//메모장 페이지 이동
			dao = new MemoDAO();
			ArrayList<MemoDTO> list = dao.getListAll();
			request.setAttribute("list", list);
			gubun = "/memo/memo.jsp";
		}else if(url.indexOf("memoProc.do") != -1) {//메모작성 처리
			dao = new MemoDAO();
			String id = request.getParameter("id");
			String content = request.getParameter("content");
			MemoDTO dto = new MemoDTO(id, content);
			int result = dao.setInsert(dto);
			if(result>0) {
				msg = "메모작성 성공";
				reUrl = path + "/memo_servlet/memo.do";
				gubun = "/main/memo.jsp";
				page = "/message.jsp";
			}else {
				msg = "메모작성 실패";
				reUrl = path + "/memo_servlet/memo.do";
				gubun = "/main/memo.jsp";
				page = "/message.jsp";
			}
		}
		
		request.setAttribute("reUrl", reUrl);
		request.setAttribute("msg", msg);
		request.setAttribute("menu_gubun", gubun);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	
	
	

}
