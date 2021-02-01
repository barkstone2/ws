package member.controller;

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

import org.json.simple.JSONObject;

import member.model.MemberDAO;
import member.model.MemberDTO;

@WebServlet("/member_servlet/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String path = request.getContextPath();
		String url = request.getRequestURL().toString();
		String page = "/main/main.jsp";
		String viewPage = "/main/main_sub.jsp";
		String msg = "";
		String reUrl = "";
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();
		if(url.indexOf("reg.do") != -1) {
			viewPage = "/member/member_reg.jsp";
		}else if(url.indexOf("id_check.do") != -1) {
			String id = request.getParameter("id");
			int result = dao.idCheck(id);
			out.print(result);
			return;
		}else if(url.indexOf("regProc.do") != -1) {
			page = "/message.jsp";
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String pwc = request.getParameter("pwc");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String bornYear_ = request.getParameter("bornYear");
			int bornYear = bornYear_!=null&&!bornYear_.equals("")&&bornYear_.length()>0?Integer.parseInt(bornYear_):0;
			String postCode = request.getParameter("postCode");
			String bAddr = request.getParameter("bAddr");
			String sAddr = request.getParameter("sAddr");
			String rAddr = request.getParameter("rAddr");
			int idCheck = dao.idCheck(id);
			
			if(!Pattern.matches("^[0-9a-z]*$", id)||id==null) {
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
			}else if(!Pattern.matches("^[가-힣]*$",name)||name==null){
				msg = "이름을 잘못 입력하셨습니다. 다시 확인해주세요.";
			}else {
				MemberDTO dto = new MemberDTO(id, pw, name, gender, bornYear, postCode, bAddr, sAddr, rAddr);
				dao = new MemberDAO();
				int result = dao.setInsert(dto);
				if(result > 0) {
					msg = "회원가입 성공";
					reUrl = "/member_servlet/list.do";
				}else {
					msg = "회원가입 실패";
					reUrl = "/member_servlet/reg.do";
				}
			}
		}else if(url.indexOf("list.do") != -1) {
			viewPage = "/member/member_list.jsp";
			ArrayList<MemberDTO> list = dao.getListAll();
			request.setAttribute("list", list);
		}else if(url.indexOf("id_check_win.do") != -1) {
			page = "/member/id_check.jsp";
		}else if(url.indexOf("id_check_win_open_Proc.do") != -1) {
			page = "/member/id_check.jsp";
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
		}else if(url.indexOf("view.do") != -1) {
			viewPage = "/member/member_view.jsp";
			String no_ = request.getParameter("no");
			int no = no_!=null&&!no_.equals("")&&no_.length()>0?Integer.parseInt(no_):0;
			MemberDTO dto = dao.getView(no);
			request.setAttribute("dto", dto);
		}else if(url.indexOf("modify.do") != -1) {
			viewPage = "/member/member_modify.jsp";
			String no_ = request.getParameter("no");
			int no = no_!=null&&!no_.equals("")&&no_.length()>0?Integer.parseInt(no_):0;
			MemberDTO dto = dao.getView(no);
			request.setAttribute("dto", dto);
		}else if(url.indexOf("modifyProc.do") != -1) {
			page = "/message.jsp";
			String no_ = request.getParameter("no");
			String gender = request.getParameter("gender");
			String bornYear_ = request.getParameter("bornYear");
			String postCode = request.getParameter("postCode");
			String bAddr = request.getParameter("bAddr");
			String sAddr = request.getParameter("sAddr");
			String rAddr = request.getParameter("rAddr");
			if(!Pattern.matches("^[0-9]*$", no_)||no_==null) {
				msg = "잘못된 접근입니다. 다시 확인해주세요.";
			}else if(!(gender.equals("남자")||gender.equals("여자"))||gender==null) {
				msg = "잘못된 성별 값입니다.";
			}else if(!Pattern.matches("\\d{4}$", bornYear_)||bornYear_==null){
				msg = "태어난 년도를 잘못 입력하셨습니다. 다시 확인해주세요.";
			}else {
				int no = no_!=null&&!no_.equals("")&&no_.length()>0?Integer.parseInt(no_):0;
				int bornYear = bornYear_!=null&&!bornYear_.equals("")&&bornYear_.length()>0?Integer.parseInt(bornYear_):0;
				MemberDTO dto = new MemberDTO();
				dto.setNo(no);
				dto.setGender(gender);
				dto.setBornYear(bornYear);
				dto.setPostCode(postCode);
				dto.setbAddr(bAddr);
				dto.setsAddr(sAddr);
				dto.setrAddr(rAddr);
				int result = dao.setUpdate(dto);
				if(result > 0) {
					msg = "수정 성공";
					reUrl = "/member_servlet/list.do";
				}else {
					msg = "수정 실패";
					reUrl = "/member_servlet/modify.do";
				}
			}
		}else if(url.indexOf("jsonView.do") != -1) {
			String no_ = request.getParameter("no");
			int no = no_!=null&&!no_.equals("")&&no_.length()>0?Integer.parseInt(no_):0;
			MemberDTO dto = dao.getView(no);
			String id = dto.getId();
			String pw = dto.getPw();
			String name = dto.getName();
			String gender = dto.getGender();
			int bornYear = dto.getBornYear();
			String postCode = dto.getPostCode();
			String bAddr = dto.getbAddr();
			String sAddr = dto.getsAddr();
			String rAddr = dto.getrAddr();
			String regiDate = dto.getRegiDate().toString();

			JSONObject jsonobj = new JSONObject();
			jsonobj.put("no", no);
			jsonobj.put("id", id);
			jsonobj.put("pw", pw);
			jsonobj.put("name", name);
			jsonobj.put("gender", gender);
			jsonobj.put("bornYear", bornYear);
			jsonobj.put("postCode", postCode);
			jsonobj.put("bAddr", bAddr);
			jsonobj.put("sAddr", sAddr);
			jsonobj.put("rAddr", rAddr);
			jsonobj.put("regiDate", regiDate);
			String json_sj = jsonobj.toJSONString();
			out.println(json_sj);
			return;
		}
		
		request.setAttribute("reUrl", path+reUrl);
		request.setAttribute("msg", msg);
		request.setAttribute("viewPage", viewPage);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
		
	}
	
}
