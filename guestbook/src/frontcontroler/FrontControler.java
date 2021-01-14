package frontcontroler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.BCommand;
import command.BListCommand;
import command.BViewCommand;
import command.BWriteCommand;
import command.BWriteViewCommand;


/**
 * Servlet implementation class FrontControler
 */
@WebServlet("*.do")
public class FrontControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("actionDo");
		request.setCharacterEncoding("utf-8");
		
		String viewPage = null;
		BCommand command = null;
		String servletPath = request.getServletPath();
		int pathIndex = servletPath.lastIndexOf("/");
		String com = servletPath.substring(pathIndex);
		
		if(com.equals("/write.do")) {
			command = new BWriteCommand();
			command.execute(request, response);
			response.sendRedirect("list.do");
			return;
		}else if(com.equals("/list.do")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		}else if(com.equals("/view.do")){
			command = new BViewCommand();
			command.execute(request, response);
			viewPage = "view.jsp";
		}else if(com.equals("/writeView.do")) {
			command = new BWriteViewCommand();
			command.execute(request, response);
			viewPage ="write.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
	
	

}
