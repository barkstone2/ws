package email.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import common.Util;
import email.MemberDTO;
import email.model.dto.EmailDTO;
import email.service.EmailService;
import oracle.sql.DATE;

@WebServlet("/email_servlet/*")
public class EmailController extends HttpServlet {
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
		Util util = new Util();
		
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
		String page = "/email/email_index.jsp"; //기본 포워딩 페이지
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
		String pageNumber_ = request.getParameter("pageNumber"); 
		int pageNumber = util.numberCheck(pageNumber_,1);
		
		if(uri.indexOf("chuga.do") != -1) {
			page = "/email/email_chuga.jsp";
			JSONParser parser = new JSONParser();
	        Object obj = null;
	        String jsonPath = "/email/";
			String realPath = request.getServletContext().getRealPath(jsonPath);
			try {
				obj = parser.parse(new FileReader(realPath+"member_Data1.json"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			JSONObject json = (JSONObject) obj;
			
			List<MemberDTO> list = new ArrayList<>();
			
			for(int i=1; i<=json.size(); i++) {
				JSONObject j = (JSONObject) json.get("json"+i);
				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = null;
				try {
					date = transFormat.parse(j.get("birthDay").toString());
				} catch (java.text.ParseException e) {
					e.printStackTrace();
				}
				MemberDTO dto = new MemberDTO(j.get("no").toString(), 
												j.get("name").toString(), 
												j.get("email").toString(),
												date);



				list.add(dto);
			}
			
			request.setAttribute("list", list);
			
		}else if(uri.indexOf("chugaProc.do") != -1||uri.indexOf("sendBirth.do")!=-1) {
			String fromName = "테스트회사";
			String fromEmail = "testCompany@tcmail.com";
			String[] toEmails = request.getParameterValues("toEmail"); 
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			EmailService service = new EmailService();
			
			if(uri.indexOf("sendBirth.do")!=-1) {
				JSONParser parser = new JSONParser();
		        Object obj = null;
		        String jsonPath = "/email/";
				String realPath = request.getServletContext().getRealPath(jsonPath);
				try {
					obj = parser.parse(new FileReader(realPath+"member_Data1.json"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				JSONObject json = (JSONObject) obj;
				LocalDate today = LocalDate.now();
				String tempToEmail = "";
				
				for(int i=1; i<=json.size(); i++) {
					JSONObject j = (JSONObject) json.get("json"+i);
					LocalDate date = LocalDate.parse(j.get("birthDay").toString(), DateTimeFormatter.ISO_DATE);
					
					if(today.getMonth()==date.getMonth()&&today.getDayOfMonth()==date.getDayOfMonth()) {
						tempToEmail += j.get("email")+",";
						System.out.println(j.get("name"));
					}
				}
				tempToEmail.substring(0, tempToEmail.length()-1);
				toEmails = tempToEmail.split(",");
			}
			
		
			EmailDTO dto = new EmailDTO(fromName, fromEmail, toEmails, subject, content);
			try {
				service.mailSender(dto);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			response.sendRedirect(path);
			return;
		}
		
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("reUrl", path+reUrl);
		request.setAttribute("msg", msg);
		request.setAttribute("menu_gubun", gubun);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
		
	}

}
