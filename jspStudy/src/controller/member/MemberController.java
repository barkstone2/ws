package controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.member.dao.MemberDAO;
import model.member.dto.MemberDTO;

@WebServlet("/member_servlet/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}

	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
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
		MemberDAO dao;
		HttpSession session = request.getSession();
		
//		passwd.replace("<", "&lt;");
//		replace(">","&gt;");
//		replace("&","&amp;");
//		replace("/","&quot;");
//		replace("'","&apos;");
		
		
		
		
		if(url.indexOf("chuga.do") != -1) {//회원가입 페이지 이동
			gubun = "/member/member_chuga.jsp";
		}else if(url.indexOf("chugaProc.do") != -1) {//회원가입 처리
			page = "/message.jsp";
			dao = new MemberDAO();
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String pwc = request.getParameter("pwc");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String bornYear_ = request.getParameter("bornYear");
			int bornYear = bornYear_==null||bornYear_.trim().equals("")?0:Integer.parseInt(bornYear_);
			String postcode = request.getParameter("postcode");
			String bAddr = request.getParameter("bAddr");
			String sAddr = request.getParameter("sAddr");
			String refAddr = request.getParameter("refAddr");
//			id = replace(id);
//			id.replace("<", "&lt;");
//			id.replace(">","&gt;");
//			id.replace("&","&amp;");
//			id.replace("/","&quot;");
//			id.replace("'","&apos;");
			int idCheck = dao.idCheck(id);
			reUrl = "/member_servlet/chuga.do";
			
			previousPageUrl += "/chuga.do";
			if(!referer.contains(previousPageUrl)) {
				msg = "비정상적인 접근입니다. 회원가입 페이지를 이용해주세요.";
			}else if(!Pattern.matches("^[0-9a-z]*$", id)||id==null) {
				msg = "아이디를 잘못 입력하셨습니다. 다시 확인해주세요.";
			}else if(!Pattern.matches("^[0-9a-z]*$", pw)||pw==null) {
				msg = "비밀번호를 잘못 입력하셨습니다. 다시 확인해주세요.";
			}else if(!Pattern.matches("^[0-9a-z]*$", pwc)||pwc==null) {
				msg = "비밀번호 확인을 잘못 입력하셨습니다. 다시 확인해주세요.";
			}else if(!(gender.equals("남자")||gender.equals("여자"))||gender==null) {
				msg = "잘못된 성별 값입니다.";
			}else if(!pw.equals(pwc)) {
				msg = "비밀번호가 서로 일치하지 않습니다.";
			}else if(idCheck>0) {
				msg = "이미 등록된 아이디입니다.";
			}else if(!Pattern.matches("\\d{4}$", bornYear_)||bornYear_==null){
				msg = "태어난 년도를 잘못 입력하셨습니다. 다시 확인해주세요.";
			}else {
				dao = new MemberDAO();
				MemberDTO dto = new MemberDTO(id, pw, name, gender, bornYear, postcode, bAddr, sAddr, refAddr);
				int result = dao.setInsert(dto);
				//String temp = "";
				if(result>0) {
					int cookNo = session.getAttribute("cookNo")!=null?(Integer)session.getAttribute("cookNo"):0;
					if(cookNo!=0) {
						reUrl = "/index.do";
					}else {
						reUrl = "/member_servlet/login.do";
					}
					//temp = path+"/member_servlet/login.do";
					msg = "회원가입 성공";
				}else {
					//temp = path+"/member_servlet/chuga.do";
					msg = "회원가입 실패";
					reUrl = "/member_servlet/chuga.do";
				}
			}
			
			//response.sendRedirect(temp);
			//return;
		}else if(url.indexOf("login.do") != -1) {//로그인 페이지 이동
			int cookNo = session.getAttribute("cookNo")!=null?(Integer)session.getAttribute("cookNo"):0;
			if(cookNo!=0) {
				msg = "이미 로그인되어 있습니다.";
				reUrl = "/index.do";
				page = "/message.jsp";
			}else {
				gubun = "/member/member_login.jsp";
			}
		}else if(url.indexOf("loginProc.do") != -1) {//로그인 처리
			previousPageUrl += "/login.do";
			reUrl = "/member_servlet/login.do";
			page = "/message.jsp";
			if(!referer.contains(previousPageUrl)) {
				msg = "비정상적인 접근입니다. 로그인 페이지를 이용해주세요.";
			}else{
				dao = new MemberDAO();
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				
				if(!Pattern.matches("^[0-9a-z]*$", id)||id==null) {
					msg = "아이디를 잘못 입력하셨습니다. 다시 확인해주세요.";
				}else if(!Pattern.matches("^[0-9a-z]*$", pw)||pw==null) {
					msg = "비밀번호를 잘못 입력하셨습니다. 다시 확인해주세요.";
				}else {
					int result = dao.getLogin(id, pw);//로그인 처리결과 출력용 메소드
					dao = new MemberDAO();
					MemberDTO dto = dao.getSelect(id);//session 처리용 메소드
					//String temp = "";
					if(result==1) {
						msg = "로그인 성공";
						reUrl = "/index.do";
						session.setAttribute("cookId", id);
						session.setAttribute("cookNo", dto.getNo());
						session.setAttribute("cookName", dto.getName());
						if(id.equals("admin")) {
							session.setAttribute("adminCheck", 1);
						}
						//temp = "/index.do";
					}else if(result==0) {
						msg = "등록되지 않은 ID입니다.";
						//temp = path+"/member_servlet/login.do";
					}else {
						msg = "비밀번호가 일치하지 않습니다.";
						//temp = path+"/member_servlet/login.do";
					}
					//response.sendRedirect(temp);
					//return;
				}
			}
		}else if(url.indexOf("list.do") != -1) {//리스트 페이지 이동
			dao = new MemberDAO();
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
			
			
			ArrayList<MemberDTO> list = dao.getListAll2(startRecord, endRecord);
			request.setAttribute("list", list);
			gubun = "/member/member_list.jsp";
		}else if(url.indexOf("logout.do") != -1) {//로그아웃 처리
			session.invalidate();
			msg = "로그아웃되었습니다.";
			reUrl = "/index.do";
			page = "/message.jsp";
			//gubun = "/main/main_sub.jsp";
		}else if(url.indexOf("view.do") != -1) {//회원 상세보기 페이지 이동
			dao = new MemberDAO();
			int cookNo = session.getAttribute("cookNo")!=null?(Integer)session.getAttribute("cookNo"):0;
			int adminCheck = session.getAttribute("adminCheck")!=null?(int)session.getAttribute("adminCheck"):0;
			String no_ = request.getParameter("no");
			int no = no_!=null?Integer.parseInt(no_):0;
			if(cookNo!=no&&adminCheck!=1) {
				msg = "권한이 없습니다.";
				reUrl = "/member_servlet/list.do";
				page = "/message.jsp";
			}else {
				MemberDTO dto = dao.getView(no);
				request.setAttribute("dto", dto);
				gubun = "/member/member_view.jsp";
			}
		}else if(url.indexOf("modify.do") != -1) {//회원 정보수정 페이지 이동
			dao = new MemberDAO();
			int cookNo = session.getAttribute("cookNo")!=null?(Integer)session.getAttribute("cookNo"):0;
			int adminCheck = session.getAttribute("adminCheck")!=null?(int)session.getAttribute("adminCheck"):0;
			String no_ = request.getParameter("no");
			int no = no_!=null?Integer.parseInt(no_):0;
			if(no==0&&cookNo!=0) {
				MemberDTO dto = dao.getView(cookNo);
				request.setAttribute("dto", dto);
				gubun = "/member/member_modify.jsp";
			}else {
				if(cookNo!=no&&adminCheck!=1) {
					msg = "권한이 없습니다.";
					reUrl = "/member_servlet/list.do";
					page = "/message.jsp";
				}else {
					MemberDTO dto = dao.getView(no);
					request.setAttribute("dto", dto);
					gubun = "/member/member_modify.jsp";
				}
			}
		}else if(url.indexOf("delete.do") != -1) {//회원탈퇴 페이지 이동
			dao = new MemberDAO();
			int cookNo = session.getAttribute("cookNo")!=null?(int)session.getAttribute("cookNo"):0;
			int adminCheck = session.getAttribute("adminCheck")!=null?(int)session.getAttribute("adminCheck"):0;
			String no_ = request.getParameter("no");
			int no = no_!=null?Integer.parseInt(no_):0;
			if(no==0&&cookNo!=0) {
				MemberDTO dto = dao.getView(cookNo);
				request.setAttribute("dto", dto);
				gubun = "/member/member_delete.jsp";
			}else {
				if(cookNo!=no&&adminCheck!=1) {
					msg = "권한이 없습니다.";
					reUrl = "/member_servlet/list.do";
					page = "/message.jsp";
				}else {
					MemberDTO dto = dao.getView(no);
					request.setAttribute("dto", dto);
					gubun = "/member/member_delete.jsp";
				}
			}
		}else if(url.indexOf("modifyProc.do") != -1) {//회원정보 수정 처리
			page = "/message.jsp";
			previousPageUrl += "/modify.do";
			if(!referer.contains(previousPageUrl)) {
				msg = "비정상적인 접근입니다.";
				reUrl = "/index.do";
			}else {
				dao = new MemberDAO();
				String no_ = request.getParameter("no");
				int no = no_==null||no_.trim().equals("")?0:Integer.parseInt(no_);
				String pw = request.getParameter("pw");
				String gender = request.getParameter("gender");
				String bornYear_ = request.getParameter("bornYear");
				int bornYear = bornYear_==null||bornYear_.trim().equals("")?0:Integer.parseInt(bornYear_);
				String postcode = request.getParameter("postcode");
				String bAddr = request.getParameter("bAddr");
				String sAddr = request.getParameter("sAddr");
				String refAddr = request.getParameter("refAddr");
				int adminCheck = session.getAttribute("adminCheck")!=null?(int)session.getAttribute("adminCheck"):0;
				reUrl = "/member_servlet/modify.do";
				if(adminCheck==1) reUrl = "/member_servlet/modify.do?no="+no;
				
				if(!Pattern.matches("^[0-9]*$", no_)||no_==null) {
					msg = "비정상적인 접근입니다. 다시 확인해주세요.";
					reUrl = "/index.do";
				}else if(!Pattern.matches("^[0-9a-z]*$", pw)||pw==null) {
					msg = "비밀번호에는 영소문자와 숫자만 입력할 수 있습니다. 다시 확인해주세요.";
				}else if(!(gender.equals("남자")||gender.equals("여자"))||gender==null) {
					msg = "잘못된 성별 값입니다.";
				}else if(!Pattern.matches("\\d{4}$", bornYear_)||bornYear_==null){
					msg = "태어난 년도를 잘못 입력하셨습니다. 다시 확인해주세요.";
				}else {
					MemberDTO dto = new MemberDTO();
					dto.setBornYear(bornYear);
					dto.setGender(gender);
					dto.setNo(no);
					dto.setPw(pw);
					dto.setPostcode(postcode);
					dto.setbAddr(bAddr);
					dto.setsAddr(sAddr);
					dto.setRefAddr(refAddr);
					int result = dao.setUpdate(dto);
					if(result>0) {
						msg = "정상적으로 수정됐습니다.";
						if(adminCheck==1) {
							reUrl = "/member_servlet/view.do?no="+no;
						}
					}else {
						msg = "비밀번호가 일치하지 않습니다.";
					}
				}
			}
			
		}else if(url.indexOf("deleteProc.do") != -1) {//회원탈퇴 처리
			page = "/message.jsp";
			previousPageUrl += "/delete.do";
			reUrl = "/index.do";
			if(!referer.contains(previousPageUrl)) {
				msg = "비정상적인 접근입니다.";
			}else {
				dao = new MemberDAO();
				String no_ = request.getParameter("no");
				int no = no_==null||no_.trim().equals("")?0:Integer.parseInt(no_);
				String pw = request.getParameter("pw");
				int adminCheck = session.getAttribute("adminCheck")!=null?(int)session.getAttribute("adminCheck"):0;
				
				if(!Pattern.matches("^[0-9]*$", no_)||no_==null) {
					msg = "비정상적인 접근입니다. 다시 확인해주세요.";
				}else if(!Pattern.matches("^[0-9a-z]*$", pw)||pw==null) {
					msg = "비밀번호에는 영소문자와 숫자만 입력할 수 있습니다. 다시 확인해주세요.";
					if(adminCheck==1) {
						reUrl = "/member_servlet/delete.do?no="+no;
					}else {
						reUrl = "/member_servlet/delete.do";
					}
				}else {
					MemberDTO dto = new MemberDTO();
					dto.setNo(no);
					dto.setPw(pw);
					int result = dao.setDelete(dto);
					if(result>0) {
						msg = "정상적으로 삭제됐습니다.";
						if(adminCheck==1) {
							reUrl = "/member_servlet/list.do";
						}else {
							session.invalidate();
						}
					}else {
						msg = "비밀번호가 일치하지 않습니다.";
						if(adminCheck==1) {
							reUrl = "/member_servlet/delete.do?no="+no;
						}else {
							reUrl = "/member_servlet/delete.do";
						}
					}
				}
			}
			
		}else if(url.indexOf("id_check.do") != -1) {//아이디 중복체크
			dao = new MemberDAO();
			String id = request.getParameter("id");
			int result = dao.idCheck(id);
			if(!Pattern.matches("^[0-9a-z]*$", id)||id==null) result = 0;
			PrintWriter out = response.getWriter();
			out.println(result);
			return;
		}else if(url.indexOf("id_check_win.do") != -1) {//아이디 중복체크 새창
			page = "/member/id_check.jsp";
		}else if(url.indexOf("id_check_win_open_Proc.do") != -1) {//아이디 중복체크 새창 처리
			page = "/member/id_check.jsp";
			dao = new MemberDAO();
			String inputId = request.getParameter("id");
			String idCheckMsg = "";
			if(!Pattern.matches("^[0-9a-z]*$", inputId)||inputId==null) {
				idCheckMsg = "사용 불가능한 아이디입니다.";
			}else {
				int result = dao.idCheck(inputId);
				if(result>0) {
					idCheckMsg = "중복된 아이디입니다.";
				}else {
					idCheckMsg = "사용 가능한 아이디입니다.";
					request.setAttribute("inputId", inputId);
				}
			}
			request.setAttribute("idCheckMsg", idCheckMsg);
		}
		
		/*
		 * 입력값 invalid check.
		 * id - 공백체크, 영어 알파벳(소문자)인지 체크
		 * pw - pwc와 같은지 체크, 공백 체크, 영어, 숫자만 가능.
		 * pwc - 위와 동일
		 * name - 공백 체크
		 * bornYear - 숫자체크, 공백 체크.
		 */
		
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


