package survey.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Util;
import survey.model.dao.SurveyDAO;
import survey.model.dto.SurveyAnswerDTO;
import survey.model.dto.SurveyDTO;

@WebServlet("/survey_servlet2/*")
public class SurveyController extends HttpServlet {
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
		
		Map<String,Integer> nowDate = util.getDateTime();
		request.setAttribute("nowDate", nowDate);
		
		String list_gubun = request.getParameter("list_gubun");
		list_gubun = util.list_gubunCheck(list_gubun);
		String search_option = request.getParameter("search_option");
		String search_data = request.getParameter("search_data");
		String search_date_s = request.getParameter("search_date_s");
		String search_date_e = request.getParameter("search_date_e");
		String search_date_check = request.getParameter("search_date_check");
		String[] searchArray = util.searchCheck(search_option, search_data, search_date_s, search_date_e, search_date_check);
		
		search_option = searchArray[0];
		search_data = searchArray[1];
		search_date_s = searchArray[2];
		search_date_e = searchArray[3];
		search_date_check = searchArray[4];
		
		request.setAttribute("list_gubun", list_gubun);
		request.setAttribute("search_option", search_option);
		request.setAttribute("search_data", search_data);
		request.setAttribute("search_date_s", search_date_s);
		request.setAttribute("search_date_e", search_date_e);
		request.setAttribute("search_date_check", search_date_check);
		
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
		int pageNumber = util.numberCheck(pageNumber_,1);
		
		SurveyDAO dao = null;
		if(url.indexOf("index.do") != -1) {
			dao = new SurveyDAO();
			gubun = "/survey/index.jsp";
		}else if(url.indexOf("chuga.do") != -1) {
			gubun = "/survey2/survey_chuga.jsp";
		}else if(url.indexOf("chugaProc.do") != -1) {
			page = "/message.jsp";
			previousPageUrl += "/chuga.do";
			dao = new SurveyDAO();
			String question = request.getParameter("question");
			String ans1 = request.getParameter("ans1");
			String ans2 = request.getParameter("ans2");
			String ans3 = request.getParameter("ans3");
			String ans4 = request.getParameter("ans4");
			
			String sYear = request.getParameter("sYear");
			String sMonth = request.getParameter("sMonth");
			String sDay = request.getParameter("sDay");
			String start_date_ = sYear+"-"+sMonth+"-"+sDay;
			start_date_ += " 00:00:00.0";
			
			String eYear = request.getParameter("eYear");
			String eMonth = request.getParameter("eMonth");
			String eDay = request.getParameter("eDay");
			String end_date_ = eYear+"-"+eMonth+"-"+eDay;
			end_date_ += " 23:59:59.9";
			
			Timestamp start_date = Timestamp.valueOf(start_date_);
			Timestamp end_date = Timestamp.valueOf(end_date_);
			String status_ = request.getParameter("status");
			char status = status_.charAt(0);
			SurveyDTO dto = new SurveyDTO(question, ans1, ans2, ans3, ans4, status, start_date, end_date);
			
			int result = dao.setInsert(dto);
			if(result>0) {
				reUrl = "/survey_servlet2/list.do";
				msg = "설문이 정상적으로 등록됐습니다.";
			}else {
				reUrl = "/survey_servlet2/chuga.do";
				msg = "설문 등록 중 오류가 발생했습니다.";
			}
			
			
//			if(!referer.contains(previousPageUrl)) {
//				msg = "비정상적인 접근입니다.";
//			}else if(!Pattern.matches("^[0-9a-z]*$", passwd)||passwd==null) {
//				msg = "비밀번호에는 영문소문자와 숫자만 사용가능합니다.";
//			}else if(!Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", email)||email==null) {
//				msg = "잘못된 이메일 주소입니다.";
//			}else {
//				dao = new GuestBookDAO();
//				GuestBookDTO dto = new GuestBookDTO(name, email, passwd, content);
//				int result = dao.setInsert(dto);
//				if(result>0) {
//					msg = "방명록 작성 성공";
//				}else {
//					msg = "방명록 작성 실패";
//					reUrl = "/guestbook_servlet/write.do";
//				}
//			}
		}else if(url.indexOf("list.do") != -1) {
			gubun = "/survey2/survey_list.jsp";
			dao = new SurveyDAO();
			int conPerPage = 5;
			int pageNavLength = 5;
			
			int totalConCount = dao.getTotalCount(list_gubun, search_option, search_data, search_date_s, search_date_e);
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
			
			List<SurveyDTO> list = dao.getListAll(startRecord, endRecord, 
			list_gubun,search_option,search_data,search_date_s,search_date_e);
			request.setAttribute("list", list);
		}else if(url.indexOf("view.do") != -1) {
			gubun = "/survey2/survey_view2.jsp";
			dao = new SurveyDAO();
			String no_ = request.getParameter("no");
			int no = util.numberCheck(no_, 0);
			SurveyDTO dto = dao.getView(no);
			request.setAttribute("dto", dto);
		}else if(url.indexOf("answer.do") != -1) {
			page = "/message.jsp";
			dao = new SurveyDAO();
			String no_ = request.getParameter("no");
			int no = util.numberCheck(no_, 0);
			String answer_ = request.getParameter("answer");
			int answer = util.numberCheck(answer_, 0);
			SurveyAnswerDTO dto = new SurveyAnswerDTO();
			dto.setNo(no);
			dto.setAnswer(answer);
			int result = dao.setAnswer(dto);
			if(result>0) {
				reUrl = "/survey_servlet2/result.do?no="+no;
				msg = "답변이 정상적으로 제출됐습니다.";
			}else {
				reUrl = "/survey_servlet2/view.do?no="+no;
				msg = "답변 제출 중 오류가 발생했습니다.";
			}
		}else if(url.indexOf("modify.do") != -1) {
			gubun = "/survey2/survey_modify.jsp";
			dao = new SurveyDAO();
			String no_ = request.getParameter("no");
			int no = util.numberCheck(no_, 0);
			SurveyDTO dto = dao.getView(no);
			request.setAttribute("dto", dto);
		}else if(url.indexOf("modifyProc.do") != -1) {
			page = "/message.jsp";
			dao = new SurveyDAO();
			String no_ = request.getParameter("no");
			int no = util.numberCheck(no_, 0);
			
			String question = request.getParameter("question");
			String ans1 = request.getParameter("ans1");
			String ans2 = request.getParameter("ans2");
			String ans3 = request.getParameter("ans3");
			String ans4 = request.getParameter("ans4");
			
			String sYear = request.getParameter("sYear");
			String sMonth = request.getParameter("sMonth");
			String sDay = request.getParameter("sDay");
			String start_date_ = sYear+"-"+sMonth+"-"+sDay;
			start_date_ += " 00:00:00.0";
			
			String eYear = request.getParameter("eYear");
			String eMonth = request.getParameter("eMonth");
			String eDay = request.getParameter("eDay");
			String end_date_ = eYear+"-"+eMonth+"-"+eDay;
			end_date_ += " 23:59:59.9";
			
			Timestamp start_date = Timestamp.valueOf(start_date_);
			Timestamp end_date = Timestamp.valueOf(end_date_);
			String status_ = request.getParameter("status");
			char status = status_.charAt(0);
			SurveyDTO dto = new SurveyDTO(question, ans1, ans2, ans3, ans4, status, start_date, end_date);
			dto.setNo(no);
			int result = dao.setUpdate(dto);
			if(result>0) {
				reUrl = "/survey_servlet2/list.do";
				msg = "정상적으로 수정됐습니다.";
			}else {
				reUrl = "/survey_servlet2/modify.do?no="+no;
				msg = "수정 중 오류가 발생했습니다.";
			}
		}else if(url.indexOf("result.do") != -1) {
			gubun = "/survey2/survey_result.jsp";
			dao = new SurveyDAO();
			String no_ = request.getParameter("no");
			int no = util.numberCheck(no_, 0);
			SurveyDTO dto = dao.getView(no);
			request.setAttribute("dto", dto);
		}else if(url.indexOf("solve.do") != -1) {
			gubun = "/survey2/survey_solve.jsp";
			dao = new SurveyDAO();
			
			int totalConCount = dao.getTotalCount(list_gubun, search_option, search_data, search_date_s, search_date_e);
			int conPerPage = totalConCount;
			int pageNavLength = 5;
			int jj = totalConCount - conPerPage * (pageNumber -1);
			
			int startRecord = 1;
			int endRecord = conPerPage;
			int totalPage = (int)Math.ceil((totalConCount / (double)conPerPage));
			int startPage = 1;
			int lastPage = 1;
			
			//startPage = (pageNumber / pageNavLength - (pageNumber % pageNavLength!=0 ? 0:1)) * pageNavLength +1; 
			//lastPage = startPage + pageNavLength -1;
			//if(lastPage>totalPage)lastPage=totalPage;
			
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
			
			//ArrayList<SurveyDTO> list = dao.getListAll(startRecord, endRecord);
			List<SurveyDTO> list = dao.getListAll(startRecord, endRecord, 
			list_gubun,search_option,search_data,search_date_s,search_date_e);
			request.setAttribute("list", list);
		}else if(url.indexOf("solveProc.do") != -1) {
			page = "/message.jsp";
			reUrl = "/survey_servlet2/list.do";
			msg = "답변을 정상적으로 제출했습니다.";
			String[] noArr_ = request.getParameterValues("no");
			String[] answerArr_ = request.getParameterValues("answer");
			int[] noArr = util.numArrCheck(noArr_, 0);
			int[] answerArr = util.numArrCheck(answerArr_, 0);
			if(noArr_.length!=answerArr_.length) {
				msg = "답변하지 않은 문제가 있습니다.";
			}else if(util.valueCheck(noArr)==1||util.valueCheck(answerArr)==1) {
				msg = "비정상적인 답변이 존재합니다.";
			}
			for(int i=0; i<noArr.length; i++) {
				dao = new SurveyDAO();
				int no = noArr[i];
				int answer = answerArr[i];
				SurveyAnswerDTO dto = new SurveyAnswerDTO();
				dto.setNo(no);
				dto.setAnswer(answer);
				
				dao.setAnswer(dto);
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
