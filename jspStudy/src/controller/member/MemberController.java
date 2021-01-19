package controller.member;

import java.io.IOException;
import java.util.ArrayList;

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
		MemberDAO dao;
		String page = "/main/main.jsp";
		HttpSession session = request.getSession();
		if(url.indexOf("chuga.do") != -1) {
			gubun = "/member/member_chuga.jsp";
		}else if(url.indexOf("chugaProc.do") != -1) {
			dao = new MemberDAO();
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String pwc = request.getParameter("pwc");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String bornYear_ = request.getParameter("bornYear");
			int bornYear = bornYear_!=null?Integer.parseInt(bornYear_):0;
			MemberDTO dto = new MemberDTO(id, pw, pwc, name, gender, bornYear);
			int result = dao.setInsert(dto);
			String temp = "";
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
			//response.sendRedirect(temp);
			//return;
		}else if(url.indexOf("login.do") != -1) {
			int cookNo = session.getAttribute("cookNo")!=null?(Integer)session.getAttribute("cookNo"):0;
			gubun = "/member/member_login.jsp";
		}else if(url.indexOf("loginProc.do") != -1) {
			dao = new MemberDAO();
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			int result = dao.getLogin(id, pw);
			dao = new MemberDAO();
			MemberDTO dto = dao.getSelect(id);
			String temp = "";
			if(result==1) {
				msg = "로그인 성공";
				reUrl = path + "/index.do";
				page = "/message.jsp";
				session.setAttribute("cookId", id);
				session.setAttribute("cookNo", dto.getNo());
				session.setAttribute("cookName", dto.getName());
				//temp = path + "/index.do";
			}else if(result==0) {
				msg = "등록되지 않은 ID입니다.";
				reUrl = path + "/member_servlet/login.do";
				page = "/message.jsp";
				//temp = path+"/member_servlet/login.do";
				//등록되지 않은 ID
			}else {
				msg = "비밀번호가 일치하지 않습니다.";
				reUrl = path + "/member_servlet/login.do";
				page = "/message.jsp";
				//temp = path+"/member_servlet/login.do";
				//비밀번호 틀림
			}
			//response.sendRedirect(temp);
			//return;
		}else if(url.indexOf("list.do") != -1) {
			dao = new MemberDAO();
			ArrayList<MemberDTO> list = dao.getListAll();
			request.setAttribute("list", list);
			gubun = "/member/member_list.jsp";
		}else if(url.indexOf("logout.do") != -1) {
			session.invalidate();
			msg = "로그아웃되었습니다.";
			reUrl = path + "/index.do";
			page = "/message.jsp";
			//gubun = "/main/main_sub.jsp";
		}else if(url.indexOf("view.do") != -1) {
			dao = new MemberDAO();
			int cookNo = session.getAttribute("cookNo")!=null?(Integer)session.getAttribute("cookNo"):0;
			String no_ = request.getParameter("no");
			int no = no_!=null?Integer.parseInt(no_):0;
			if(cookNo!=no) {
				msg = "권한이 없습니다.";
				reUrl = path + "/member_servlet/list.do";
				page = "/message.jsp";
			}else {
				MemberDTO dto = dao.getView(no);
				request.setAttribute("dto", dto);
				gubun = "/member/member_view.jsp";
			}
		}else if(url.indexOf("modify.do") != -1) {
			dao = new MemberDAO();
			int cookNo = session.getAttribute("cookNo")!=null?(Integer)session.getAttribute("cookNo"):0;
			String no_ = request.getParameter("no");
			int no = no_!=null?Integer.parseInt(no_):0;
			if(no==0&&cookNo!=0) {
				MemberDTO dto = dao.getView(cookNo);
				request.setAttribute("dto", dto);
				gubun = "/member/member_modify.jsp";
			}else {
				if(cookNo!=no) {
					msg = "권한이 없습니다.";
					reUrl = path + "/member_servlet/list.do";
					page = "/message.jsp";
				}else {
					MemberDTO dto = dao.getView(no);
					request.setAttribute("dto", dto);
					gubun = "/member/member_modify.jsp";
				}
			}
			
		}else if(url.indexOf("delete.do") != -1) {
			dao = new MemberDAO();
			int cookNo = session.getAttribute("cookNo")!=null?(Integer)session.getAttribute("cookNo"):0;
			String no_ = request.getParameter("no");
			int no = no_!=null?Integer.parseInt(no_):0;
			if(no==0&&cookNo!=0) {
				MemberDTO dto = dao.getView(cookNo);
				request.setAttribute("dto", dto);
				gubun = "/member/member_delete.jsp";
			}else {
				if(cookNo!=no) {
					msg = "권한이 없습니다.";
					reUrl = path + "/member_servlet/list.do";
					page = "/message.jsp";
				}else {
					MemberDTO dto = dao.getView(no);
					request.setAttribute("dto", dto);
					gubun = "/member/member_delete.jsp";
				}
			}
		}else if(url.indexOf("modifyProc.do") != -1) {
			dao = new MemberDAO();
			String no_ = request.getParameter("no");
			int no = no_!=null?Integer.parseInt(no_):0;
			String pw = request.getParameter("pw");
			String gender = request.getParameter("gender");
			String bornYear_ = request.getParameter("bornYear");
			int bornYear = bornYear_!=null?Integer.parseInt(bornYear_):0;
			MemberDTO dto = new MemberDTO();
			dto.setBornYear(bornYear);
			dto.setGender(gender);
			dto.setNo(no);
			dto.setPw(pw);
			int result = dao.setUpdate(dto);
			if(result>0) {
				msg = "정상적으로 수정됐습니다.";
				reUrl = path + "/member_servlet/view.do?no="+no;
			}else {
				msg = "비밀번호가 일치하지 않습니다.";
				reUrl = path + "/member_servlet/modify.do?no="+no;
			}
			page = "/message.jsp";
		}else if(url.indexOf("deleteProc.do") != -1) {
			dao = new MemberDAO();
			String no_ = request.getParameter("no");
			int no = no_!=null?Integer.parseInt(no_):0;
			String pw = request.getParameter("pw");
			MemberDTO dto = new MemberDTO();
			dto.setNo(no);
			dto.setPw(pw);
			int result = dao.setDelete(dto);
			if(result>0) {
				msg = "정상적으로 삭제됐습니다.";
				reUrl = path + "/member_servlet/list.do";
			}else {
				msg = "비밀번호가 일치하지 않습니다.";
				reUrl = path + "/member_servlet/delete.do?no="+no;
			}
			page = "/message.jsp";
		}
		
		//회원용 수정&삭제 추가.
		//cookNo 값을 바로 받아서 처리.
		//cookNo 값이 비어있으면 redirect
		
		request.setAttribute("reUrl", reUrl);
		request.setAttribute("msg", msg);
		request.setAttribute("menu_gubun", gubun);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	
	
	

}
