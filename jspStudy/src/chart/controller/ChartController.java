package chart.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import chart.service.ChartService;
import common.Util;
import shop.model.dao.ProductDAO;

@WebServlet("/chart_servlet/*")
public class ChartController extends HttpServlet {
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
		
		if(uri.indexOf("index.do") != -1) {
			gubun = "/chart/chart_index.jsp";
		}else if(uri.indexOf("createJson.do") !=-1) {
			page = "/chart/myChart.jsp";
			ChartService service = new ChartService();
			JSONObject json = service.getChartData();
			request.setAttribute("data", json);
			
			String img_path01 = request.getSession().getServletContext().getRealPath("/attach/json/");
			File isDir = new File(img_path01);
			if(!isDir.isDirectory()) {
				isDir.mkdir();
			}
			String img_path02 = img_path01.replace("\\", "/");
			String img_path03 = img_path01.replace("\\", "\\\\");
			
			util.fileDelete(request,img_path03);
			
			String newFileName = util.getDateTimeType() + "_" + util.create_uuid() + ".json";
			File file = new File(img_path03 + newFileName);
			file.createNewFile();
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write(json.toString());
			bufferedWriter.close();
			
			request.setAttribute("chart_subject", "차트 제목입니다.");
			request.setAttribute("chart_type", "PieChart");
			request.setAttribute("chart_subject", "차트 제목입니다.");
			request.setAttribute("chart_jsonFileName", newFileName);
			
		}else if(uri.indexOf("googleChartJson.do") !=-1) {
			page = "/chart/googleChartJson.jsp";
		}else if(uri.indexOf("googleChartDb.do") !=-1) {
			page = "/chart/googleChartDb.jsp";
		}else if(uri.indexOf("jfreeChartPdf.do") !=-1) {
			
		}
		
		
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("reUrl", path+reUrl);
		request.setAttribute("msg", msg);
		request.setAttribute("menu_gubun", gubun);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
