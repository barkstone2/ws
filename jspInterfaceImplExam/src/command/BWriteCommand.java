package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspInterfaceImplExam.model.resume.ResumeDAO;
import jspInterfaceImplExam.model.resume.ResumeDTO;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String pic = request.getParameter("pic");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		String toeic_ = request.getParameter("toeic");
		String toefl_ = request.getParameter("toefl");
		String japan_ = request.getParameter("japan");
		String china_ = request.getParameter("china");
		int toeic = 0;
		int toefl = 0;
		int japan = 0;
		int china = 0;
		if(toeic_!=null) {
			toeic = Integer.parseInt(toeic_);
			toefl = Integer.parseInt(toefl_);
			japan = Integer.parseInt(japan_);
			china = Integer.parseInt(china_);
		}
		
		String gigan1 = request.getParameter("gigan1");
		String school1 = request.getParameter("school1");
		String jeongong1 = request.getParameter("jeongong1");
		
		String gigan2 = request.getParameter("gigan2");
		String school2 = request.getParameter("school2");
		String jeongong2 = request.getParameter("jeongong2");
		
		String gigan3 = request.getParameter("gigan3");
		String school3 = request.getParameter("school3");
		String jeongong3 = request.getParameter("jeongong3");
		
		String gigan4 = request.getParameter("gigan4");
		String school4 = request.getParameter("school4");
		String jeongong4 = request.getParameter("jeongong4");
		
		ResumeDTO dto = new ResumeDTO(pic, name, email, phone, 
				address, toeic, toefl, japan, china, gigan1, school1, jeongong1, 
				gigan2, school2, jeongong2, gigan3, school3, jeongong3, gigan4, school4, jeongong4);
		ResumeDAO dao = new ResumeDAO();
		dao.setInsert(dto);
	}

	public BWriteCommand() {
	}
	
	
	
}
