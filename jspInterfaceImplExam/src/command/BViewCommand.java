package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspInterfaceImplExam.model.resume.ResumeDAO;
import jspInterfaceImplExam.model.resume.ResumeDTO;

public class BViewCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String no = request.getParameter("no");
		ResumeDAO dao = new ResumeDAO();
		ResumeDTO dto = dao.getSelect(no);
		request.setAttribute("dto", dto);
	}

}
