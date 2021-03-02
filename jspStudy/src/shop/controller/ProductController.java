package shop.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.UtilBoard;
import shop.model.dao.ProductDAO;
import shop.model.dto.ProductDTO;

@WebServlet("/product_servlet/*")
public class ProductController extends HttpServlet {
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
		UtilBoard util = new UtilBoard();
		
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
		String search_option = request.getParameter("search_option");
		String search_data = request.getParameter("search_data");
		String[] searchArray = util.searchCheck(search_option, search_data);
		search_option = searchArray[0];
		search_data = searchArray[1];
		
		String boardType = request.getParameter("boardType");
		boardType = util.boardTypeCheck(boardType, "free");
		
		request.setAttribute("boardType", boardType);
		request.setAttribute("search_option", search_option);
		request.setAttribute("search_data", search_data);
		
		if(uri.indexOf("index.do") != -1) {
			gubun = "/shop/product/product_index.jsp";
			
		}else if(uri.indexOf("list.do") != -1) {
			page = "/shop/product/product_list.jsp";
			
			int conPerPage = 10; // 페이지 당 개시글 수
			int pageNavLength = 5; // 페이징 범위
			// 공지글을 제외한 총 게시글 수
			int totalConCount = dao.getTotalCount(search_option, search_data);
			// 게시글 순번
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
			
			ArrayList<ProductDTO> list = dao.getListAll(startRecord, endRecord, search_option, search_data);
			request.setAttribute("list", list);
		}else if(uri.indexOf("chuga.do") != -1) {
			page = "/shop/product/product_chuga.jsp";
		}else if(uri.indexOf("chugaProc.do") != -1) {
			//page = "/board2/board_list.jsp";
			reUrl = "/shop/product_servlet2/index.do";
			previousPageUrl += "/chuga.do";
			String webPath = "/attach/product_img/";
			String realPath = request.getServletContext().getRealPath(webPath);
			
			File savePath = new File(realPath);
			if(!savePath.exists()) {
				savePath.mkdirs();
			}
			
			int maxSize = 10 * 1024 * 1024; // 10MB
			
			MultipartRequest multi = new MultipartRequest(request, realPath, 
					maxSize, "UTF-8", new DefaultFileRenamePolicy());
			
			String name = multi.getParameter("pName");
			String price_ = multi.getParameter("price");
			String description = multi.getParameter("description");
			String product_img = "0"; //multi.getFile(arg0);
			int price = util.numberCheck(price_, 0);
			
			String[] fileNames = new String[3];
			
			Enumeration files = multi.getFileNames();
			
			while(files.hasMoreElements()) {
				String formName = (String) files.nextElement();
				String fileName = multi.getFilesystemName(formName);
				
				int fileNamesIndex = Integer.parseInt(formName);
				fileNames[fileNamesIndex] = fileName;
			}
		
			for(int i=0; i<fileNames.length; i++) {
				
				// 파일 확장자, null 체크
				// 리눅스 환경에서는 확장자가 jpg라도 원래 타입으로 실행됨
				// fileType check가 필수(img/jpg 형식으로 출력됨)
				//String fileOrgName = multi.getOriginalFileName(formName);
				//String fileType = multi.getContentType(formName);
				
				// 파일이름이 null일 경우 continue
				if(fileNames[i] == null) continue;
				
				// 파일 확장자 추출, 파일 객체 생성
				int extIndex = fileNames[i].lastIndexOf(".");
				String fileExt = fileNames[i].substring(extIndex+1).toLowerCase();
				String tempPath = realPath + File.separator + fileNames[i];
				File tempFile = new File(tempPath);
				
				// 파일이 실제로 존재하는 지 확인
				if(!tempFile.exists()) {
					fileNames[i] = null;
					continue;
				}
				
				// 파일 확장자가 없을 경우 업로드된 파일 삭제
				if(extIndex==-1) {
					tempFile.delete();
					fileNames[i] = null;
					continue;
				}
				
				// 파일 확장자 확인 후 허용되지 않을 경우 업로드 된 파일 삭제 
				if(!(fileExt.equals("jpg") || fileExt.equals("jpeg") ||
						fileExt.equals("gif") || fileExt.equals("png"))) {
					tempFile.delete();
					fileNames[i] = null;
					continue;
				}
				
				// 파일 이름 재정의
				String uuid = util.create_uuid();
				String new_fileName = util.getDateTimeType() + "_" + uuid + "." + fileExt;
				File newFile = new File(realPath + File.separator + new_fileName);
				tempFile.renameTo(newFile);
				
				fileNames[i] = fileNames[i] + "|" + new_fileName;
				
			}
			
			String tempFileNames = "";
			for(int i=0; i<fileNames.length; i++) {
				if(fileNames[i] == null) fileNames[i] = "-";
				tempFileNames += "," + fileNames[i];
			}
			tempFileNames = tempFileNames.substring(1);
			System.out.println(tempFileNames);
			
			
			
			ProductDTO dto = new ProductDTO();
			dto.setName(name);
			dto.setPrice(price);
			dto.setDescription(description);
			dto.setProduct_img(tempFileNames);
			int result = dao.setInsert(dto);
			if(result>0) {
				msg = "게시글 등록 성공";
			}else {
				msg = "게시글 등록 실패";
			}
			
			out.print(msg);
			return;
		}else if(uri.indexOf("view.do") != -1) {
			page = "/shop/product/product_view.jsp";
			String no_ = request.getParameter("no");
			int no = util.numberCheck(no_, 0);
			ProductDTO dto = dao.getView(no);
			request.setAttribute("dto", dto);
		}else if(uri.indexOf("modify.do") != -1) {
			page = "/shop/product/product_modify.jsp";
			String no_ = request.getParameter("no");
			int no = util.numberCheck(no_, 0);
			ProductDTO dto = dao.getView(no);
			
			
			String tempImgNames = dto.getProduct_img();
			String[] imgNames = tempImgNames.split(",");
			
			request.setAttribute("imgNames", imgNames);
			request.setAttribute("dto", dto);
		}else if(uri.indexOf("modifyProc.do") != -1) {
			//page = "/board2/board_list.jsp";
			//reUrl = "/board_servlet2/index.do";
			
			String webPath = "/attach/product_img/";
			String realPath = request.getServletContext().getRealPath(webPath);
			
			File savePath = new File(realPath);
			if(!savePath.exists()) {
				savePath.mkdirs();
			}
			
			int maxSize = 10 * 1024 * 1024; // 10MB
			
			MultipartRequest multi = new MultipartRequest(request, realPath, 
					maxSize, "UTF-8", new DefaultFileRenamePolicy());
			
			String no_ = multi.getParameter("no");
			int no = util.numberCheck(no_, 0);
			String name = multi.getParameter("pName");
			String price_ = multi.getParameter("price");
			int price = util.numberCheck(price_, 0);
			String description = multi.getParameter("description");
			String product_img = "0"; //multi.getFile(arg0);
			String[] curImgNames = multi.getParameterValues("curImgNames");
			
			System.out.println("dto Info");
			System.out.println(no);
			System.out.println(name);
			System.out.println(price);
			System.out.println(description);
			System.out.println("---------------");
			
			String[] fileNames = new String[3];
			Enumeration files = multi.getFileNames();
			
			while(files.hasMoreElements()) {
				String formName = (String) files.nextElement();
				String fileName = multi.getFilesystemName(formName);
				
				int fileNamesIndex = Integer.parseInt(formName);
				fileNames[fileNamesIndex] = fileName;
			}
		
			for(int i=0; i<fileNames.length; i++) {
				
				// 파일이름이 null일 경우 continue
				if(fileNames[i] == null) {
					fileNames[i] = "-";
					continue;
				}
				
				// 파일 확장자 추출, 파일 객체 생성
				int extIndex = fileNames[i].lastIndexOf(".");
				String fileExt = fileNames[i].substring(extIndex+1).toLowerCase();
				String tempPath = realPath + File.separator + fileNames[i];
				File tempFile = new File(tempPath);
				
				// 파일이 실제로 존재하는 지 확인
				if(!tempFile.exists()) {
					fileNames[i] = null;
					continue;
				}
				
				// 파일 확장자가 없을 경우 업로드된 파일 삭제
				if(extIndex==-1) {
					tempFile.delete();
					fileNames[i] = null;
					continue;
				}
				
				// 파일 확장자 확인 후 허용되지 않을 경우 업로드 된 파일 삭제 
				if(!(fileExt.equals("jpg") || fileExt.equals("jpeg") ||
						fileExt.equals("gif") || fileExt.equals("png"))) {
					tempFile.delete();
					fileNames[i] = null;
					continue;
				}
				
				// 파일 이름 재정의
				String uuid = util.create_uuid();
				String new_fileName = util.getDateTimeType() + "_" + uuid + "." + fileExt;
				File newFile = new File(realPath + File.separator + new_fileName);
				tempFile.renameTo(newFile);
				
				fileNames[i] = fileNames[i] + "|" + new_fileName;
			}
			
				for(int i=0; i<curImgNames.length; i++) {
					
					if(!(curImgNames[i].equals("")||curImgNames[i]==null)){
						int index = -1;
						String imgName = "";
						int tempIndex = curImgNames[i].lastIndexOf("|");
						imgName = curImgNames[i].substring(0, tempIndex);
						index = Integer.parseInt(curImgNames[i].substring(tempIndex+1));
						
						if(fileNames[index].equals("-")) fileNames[index] = imgName;
					}
				}
			
			String tempFileNames = "";
			for(int i=0; i<fileNames.length; i++) {
				tempFileNames += "," + fileNames[i];
			}
			tempFileNames = tempFileNames.substring(1);
			System.out.println(tempFileNames);
			
			ProductDTO dto = new ProductDTO();
			dto.setNo(no);
			dto.setName(name);
			dto.setPrice(price);
			dto.setDescription(description);
			dto.setProduct_img(tempFileNames);
			
			int result = dao.setUpdate(dto);
			if(result>0) {
				msg = "게시글 수정 성공";
			}else {
				msg = "게시글 수정 실패";
			}
			out.print(msg);
			return;
//		}else if(uri.indexOf("delete.do") != -1) {
//			page = "/board2/board_delete.jsp";
//			String bNo_ = request.getParameter("bNo");
//			int bNo = util.numberCheck(bNo_, 0);
//			request.setAttribute("bNo", bNo);
//		}else if(uri.indexOf("deleteProc.do") != -1) {
//			page = "/board2/board_index.jsp";
//			//reUrl = "/board_servlet2/index.do"; 
//			String bNo_ = request.getParameter("bNo");
//			int bNo = util.numberCheck(bNo_, 0);
//			String bPasswd = request.getParameter("bPasswd");
//			bPasswd = util.nullCheck(bPasswd);
//			BoardDTO2 dto = dao.getView(bNo);
//			if(bPasswd.equals(dto.getbPasswd())) {
//				dao = new BoardDAO2();
//				int result = dao.setDelete(bNo);
//				if(result>0) {
//					msg = "삭제 성공";
//				}else {
//					msg = "삭제 실패";
//				}
//			}else if(bPasswd.equals("")){
//			}else {
//				msg = "비밀번호가 일치하지 않습니다.";
//			}
//			out.print(msg);
//			return;
		}
		
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("reUrl", path+reUrl);
		request.setAttribute("msg", msg);
		request.setAttribute("menu_gubun", gubun);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
