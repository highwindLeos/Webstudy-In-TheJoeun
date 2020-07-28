package com.leo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.BoardDao;
import com.leo.dto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BModifyService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String path = request.getRealPath("freeboardFile");
		int maxFilesize = 1024 * 1024 *5; // 5Mbyte
		
		String paramStr = "";
		String bFile1 = "";
		String originFilename = "";
		
		MultipartRequest multipartRequest = null;
		try {
			// cos 라이브러리 사용 file 업로드 
			multipartRequest = new MultipartRequest(request, path, maxFilesize, "utf-8", new DefaultFileRenamePolicy()); 
			Enumeration<String> fileParams = multipartRequest.getFileNames(); 
			
			while(fileParams.hasMoreElements()) {
				paramStr = fileParams.nextElement(); 
				bFile1 = multipartRequest.getFilesystemName(paramStr); 
				originFilename = multipartRequest.getOriginalFileName(paramStr); 
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		InputStream is = null;
		OutputStream os = null;
		
		try {
			File upFile = new File(path + "/" + bFile1); 
			if(upFile.exists()) { // 파일 복사
				is = new FileInputStream(upFile);
			
				String copyFolder = "C:/Users/Leodays/Desktop/Dev/webstudy/JSPProject/Retrotori/WebContent/freeboardFile/" + bFile1;
				os = new FileOutputStream(copyFolder); 
				
				byte[] bs = new byte[(int)upFile.length()]; 
				while (true){
					int readByte = is.read(bs); 
					if (readByte == -1) {
						break;
					}
					os.write(bs, 0, readByte); 
				}
			}	
		} catch (Exception e){
			System.out.println(e.getMessage());
		} finally {
			try {				
				if (os != null) os.close();
				if (is != null) is.close();
			} catch (Exception e2) {}
		}
		
		// 입력에 필요한 파라메터들
		
		int bNum = Integer.parseInt(multipartRequest.getParameter("bNum"));
		String bTitle = multipartRequest.getParameter("bTitle");
		String bContent = multipartRequest.getParameter("bContent");
		
		if (bFile1 == null) {
			bFile1 = "";
		}
		
		String bIp = request.getRemoteAddr();

		BoardDao bdao = BoardDao.getInstance();		
		int modifyresult = bdao.modifyBoard(bNum, bTitle, bContent, bFile1, bIp);
		
		if (modifyresult == BoardDao.SUCCESS) {
			System.out.println("게시판 글쓰기 성공 : service");
			request.setAttribute("bModifyResult", "자유게시판에 글이 수정되었습니다.");
		} else {
			System.out.println("게시판 글쓰기 실패 : service");
			request.setAttribute("bModifyResult", "자유게시판에 글쓰기가 수정 했습니다.");		
		}

	}

}
