package controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
		
		String path = request.getContextPath();
		String url = request.getRequestURL().toString();
		
		String gubun = ""; //main에 출력할 페이지
		String msg = ""; //Proc 처리 후 출력할 메시지
		String reUrl = ""; //Proc 처리 후 redirect 할 url
		String page = "/main/main.jsp"; //기본 포워딩 페이지
		MemberDAO dao;
		HttpSession session = request.getSession();
		
		if(url.indexOf("chuga.do") != -1) {//회원가입 페이지 이동
			gubun = "/member/member_chuga.jsp";
		}else if(url.indexOf("chugaProc.do") != -1) {//회원가입 처리
			dao = new MemberDAO();
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String pwc = request.getParameter("pwc");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String bornYear_ = request.getParameter("bornYear");
			int bornYear = bornYear_!=null?Integer.parseInt(bornYear_):0;
			String postcode = request.getParameter("postcode");
			String bAddr = request.getParameter("bAddr");
			String sAddr = request.getParameter("sAddr");
			String refAddr = request.getParameter("refAddr");
			
			int idCheck = dao.idCheck(id); 
			if(idCheck>0) {
				msg = "이미 등록된 아이디입니다.";
				reUrl = path + "/member_servlet/chuga.do";
				page = "/message.jsp";
				gubun = "/main/main_sub.jsp";
			}else {
				dao = new MemberDAO();
				MemberDTO dto = new MemberDTO(id, pw, name, gender, bornYear, postcode, bAddr, sAddr, refAddr);
				int result = dao.setInsert(dto);
				//String temp = "";
				if(result>0) {
					//temp = path+"/member_servlet/login.do";
					msg = "회원가입 성공";
					reUrl = path + "/member_servlet/login.do";
					page = "/message.jsp";
					gubun = "/main/main_sub.jsp";
				}else {
					//temp = path+"/member_servlet/chuga.do";
					msg = "회원가입 실패";
					reUrl = path + "/member_servlet/chuga.do";
					gubun = "/member/member_chuga.jsp";
					page = "/message.jsp";
				}
			}
			//response.sendRedirect(temp);
			//return;
		}else if(url.indexOf("login.do") != -1) {//로그인 페이지 이동
			int cookNo = session.getAttribute("cookNo")!=null?(Integer)session.getAttribute("cookNo"):0;
			if(cookNo!=0) {
				msg = "이미 로그인되어 있습니다.";
				reUrl = path + "/index.do";
				page = "/message.jsp";
			}else {
				gubun = "/member/member_login.jsp";
			}
		}else if(url.indexOf("loginProc.do") != -1) {//로그인 처리
			dao = new MemberDAO();
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			int result = dao.getLogin(id, pw);//로그인 처리결과 출력용 메소드
			
			dao = new MemberDAO();
			MemberDTO dto = dao.getSelect(id);//session 처리용 메소드
			//String temp = "";
			if(result==1) {
				msg = "로그인 성공";
				reUrl = path + "/index.do";
				page = "/message.jsp";
				session.setAttribute("cookId", id);
				session.setAttribute("cookNo", dto.getNo());
				session.setAttribute("cookName", dto.getName());
				if(id.equals("admin")) {
					session.setAttribute("adminCheck", 1);
				}
				//temp = path + "/index.do";
			}else if(result==0) {
				msg = "등록되지 않은 ID입니다.";
				reUrl = path + "/member_servlet/login.do";
				page = "/message.jsp";
				//temp = path+"/member_servlet/login.do";
			}else {
				msg = "비밀번호가 일치하지 않습니다.";
				reUrl = path + "/member_servlet/login.do";
				page = "/message.jsp";
				//temp = path+"/member_servlet/login.do";
			}
			//response.sendRedirect(temp);
			//return;
		}else if(url.indexOf("list.do") != -1) {//리스트 페이지 이동
			dao = new MemberDAO();
			ArrayList<MemberDTO> list = dao.getListAll();
			request.setAttribute("list", list);
			gubun = "/member/member_list.jsp";
		}else if(url.indexOf("logout.do") != -1) {//로그아웃 처리
			session.invalidate();
			msg = "로그아웃되었습니다.";
			reUrl = path + "/index.do";
			page = "/message.jsp";
			//gubun = "/main/main_sub.jsp";
		}else if(url.indexOf("view.do") != -1) {//회원 상세보기 페이지 이동
			dao = new MemberDAO();
			int cookNo = session.getAttribute("cookNo")!=null?(Integer)session.getAttribute("cookNo"):0;
			int adminCheck = session.getAttribute("adminCheck")!=null?(int)session.getAttribute("adminCheck"):0;
			String no_ = request.getParameter("no");
			int no = no_!=null?Integer.parseInt(no_):0;
			if(cookNo!=no&&adminCheck==0) {
				msg = "권한이 없습니다.";
				reUrl = path + "/member_servlet/list.do";
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
				if(cookNo!=no&&adminCheck==0) {
					msg = "권한이 없습니다.";
					reUrl = path + "/member_servlet/list.do";
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
				if(cookNo!=no&&adminCheck==0) {
					msg = "권한이 없습니다.";
					reUrl = path + "/member_servlet/list.do";
					page = "/message.jsp";
				}else {
					MemberDTO dto = dao.getView(no);
					request.setAttribute("dto", dto);
					gubun = "/member/member_delete.jsp";
				}
			}
		}else if(url.indexOf("modifyProc.do") != -1) {//회원정보 수정 처리
			dao = new MemberDAO();
			String no_ = request.getParameter("no");
			int no = no_!=null?Integer.parseInt(no_):0;
			String pw = request.getParameter("pw");
			String gender = request.getParameter("gender");
			String bornYear_ = request.getParameter("bornYear");
			int bornYear = bornYear_!=null?Integer.parseInt(bornYear_):0;
			String postcode = request.getParameter("postcode");
			String bAddr = request.getParameter("bAddr");
			String sAddr = request.getParameter("sAddr");
			String refAddr = request.getParameter("refAddr");
			
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
			int adminCheck = session.getAttribute("adminCheck")!=null?(int)session.getAttribute("adminCheck"):0;
			
			if(result>0) {
				msg = "정상적으로 수정됐습니다.";
				if(adminCheck==1) {
					reUrl = path + "/member_servlet/view.do?no="+no;
				}else {
					reUrl = path + "/member_servlet/modify.do";
				}
			}else {
				msg = "비밀번호가 일치하지 않습니다.";
				if(adminCheck==1) {
					reUrl = path + "/member_servlet/modify.do?no="+no;
				}else {
					reUrl = path + "/member_servlet/modify.do";
				}
			}
			page = "/message.jsp";
		}else if(url.indexOf("deleteProc.do") != -1) {//회원탈퇴 처리
			dao = new MemberDAO();
			String no_ = request.getParameter("no");
			int no = no_!=null?Integer.parseInt(no_):0;
			String pw = request.getParameter("pw");
			MemberDTO dto = new MemberDTO();
			dto.setNo(no);
			dto.setPw(pw);
			int result = dao.setDelete(dto);
			int adminCheck = session.getAttribute("adminCheck")!=null?(int)session.getAttribute("adminCheck"):0;
			if(result>0) {
				msg = "정상적으로 삭제됐습니다.";
				if(adminCheck==1) {
					reUrl = path + "/member_servlet/list.do";
				}else {
					session.invalidate();
					reUrl = path + "/index.do";
				}
			}else {
				msg = "비밀번호가 일치하지 않습니다.";
				if(adminCheck==1) {
					reUrl = path + "/member_servlet/delete.do?no="+no;
				}else {
					reUrl = path + "/member_servlet/delete.do";
				}
			}
			page = "/message.jsp";
		}else if(url.indexOf("id_check.do") != -1) {
			dao = new MemberDAO();
			String id = request.getParameter("id");
			int result = dao.idCheck(id);
			PrintWriter out = response.getWriter();
			out.println(result);
			return;
		}else if(url.indexOf("id_check_win.do") != -1) {
			response.sendRedirect(path+"/member/id_check.jsp");
			return;
		}else if(url.indexOf("id_check_win_open_Proc.do") != -1) {
			dao = new MemberDAO();
			String inputId = request.getParameter("id");
			int result = dao.idCheck(inputId);
			String idCheckMsg = "";
			if(result>0) {
				idCheckMsg = "중복된 아이디입니다.";
			}else {
				idCheckMsg = "사용 가능한 아이디입니다.";
				request.setAttribute("inputId", inputId);
			}
			request.setAttribute("idCheckMsg", idCheckMsg);
			page = "/member/id_check.jsp";
		}
		
		request.setAttribute("reUrl", reUrl);
		request.setAttribute("msg", msg);
		request.setAttribute("menu_gubun", gubun);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
}
