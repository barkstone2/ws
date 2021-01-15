package memo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memo.model.dao.MemoDAO;
import memo.model.dto.MemoDTO;

//url Mapping
@WebServlet("/memo_servlet/*")
public class MemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String path = request.getContextPath();
		String url = request.getRequestURL().toString();
		//System.out.println("URL : "+url);
		int comIndex = url.lastIndexOf("/"); 
		String com = url.substring(comIndex);
		MemoDAO dao = new MemoDAO();
		
		if(url.indexOf("write.do") != -1) {
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			MemoDTO dto = new MemoDTO(0,writer, content,"");
			int result = dao.setInsert(dto);
		}else if(url.indexOf("list.do") != -1) {
			ArrayList<MemoDTO> list = dao.getListAll();
			request.setAttribute("list", list);
			String page = "/memo/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
		
		
		
		
		//doProc(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		//doProc(request, response);
	}
	
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}	
	

}
