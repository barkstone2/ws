package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resume.ResumeDAO;
import resume.ResumeDTO;


public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ResumeDAO dao = new ResumeDAO();
		ArrayList<ResumeDTO> dtos = dao.getListAll();
		request.setAttribute("list", dtos);
	}

	public BListCommand() {
	}
}
