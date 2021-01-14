package command;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import resume.ResumeDAO;
import resume.ResumeDTO;


public class BWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ServletContext application = request.getServletContext();
		String upload_path = application.getRealPath("/upload/img/");
		//String upload_path = "C:\\Users\\hkit\\Desktop\\ws\\workspace\\guestbook\\WebContent\\upload\\img";
		int maxSize = 10 * 1024 * 1024;
		String pic = "";
		
		try{
			MultipartRequest multi = new MultipartRequest(request, upload_path, maxSize, "utf-8",new DefaultFileRenamePolicy());
			Enumeration<?> files = multi.getFileNames();
			String file1 = (String)files.nextElement();
			pic = multi.getFilesystemName(file1);
			
			String name = multi.getParameter("name");
			String email = multi.getParameter("email");
			String phone = multi.getParameter("phone");
			String address = multi.getParameter("address");
			
			String toeic_ = multi.getParameter("toeic");
			String toefl_ = multi.getParameter("toefl");
			String japan_ = multi.getParameter("japan");
			String china_ = multi.getParameter("china");
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
			
			String gigan1 = multi.getParameter("gigan1");
			String school1 = multi.getParameter("school1");
			String jeongong1 = multi.getParameter("jeongong1");
			
			String gigan2 = multi.getParameter("gigan2");
			String school2 = multi.getParameter("school2");
			String jeongong2 = multi.getParameter("jeongong2");
			
			String gigan3 = multi.getParameter("gigan3");
			String school3 = multi.getParameter("school3");
			String jeongong3 = multi.getParameter("jeongong3");
			
			String gigan4 = multi.getParameter("gigan4");
			String school4 = multi.getParameter("school4");
			String jeongong4 = multi.getParameter("jeongong4");
			
			ResumeDTO dto = new ResumeDTO(pic, name, email, phone, 
					address, toeic, toefl, japan, china, gigan1, school1, jeongong1, 
					gigan2, school2, jeongong2, gigan3, school3, jeongong3, gigan4, school4, jeongong4);
			ResumeDAO dao = new ResumeDAO();
			dao.setInsert(dto);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		//String pic = request.getParameter("pic");
		
	}

	public BWriteCommand() {
	}
	
	
	
}
