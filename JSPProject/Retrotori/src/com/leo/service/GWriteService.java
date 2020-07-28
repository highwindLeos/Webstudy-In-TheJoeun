package com.leo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.GameDao;
import com.leo.dto.GameDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class GWriteService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String path = request.getRealPath("gameImg");
		int maxFilesize = 1024 * 1024 *5; // 5Mbyte
		
		String paramStr = "";
		String gImage = "";
		String originFilename = "";
		
		MultipartRequest multipartRequest = null;
		try {
			// cos 라이브러리 사용 file 업로드 
			multipartRequest = new MultipartRequest(request, path, maxFilesize, "utf-8", new DefaultFileRenamePolicy()); 
			Enumeration<String> fileParams = multipartRequest.getFileNames(); 
			
			while(fileParams.hasMoreElements()) {
				paramStr = fileParams.nextElement(); 
				gImage = multipartRequest.getFilesystemName(paramStr); 
				originFilename = multipartRequest.getOriginalFileName(paramStr); 
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		InputStream is = null;
		OutputStream os = null;
		
		try {
			File upFile = new File(path + "/" + gImage); 
			if(upFile.exists()) { // 파일 복사
				is = new FileInputStream(upFile);
			
				String copyFolder = "C:/Users/Leodays/Desktop/Dev/webstudy/JSPProject/Retrotori/WebContent/gameImg/" + gImage;
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
		// 서버의 파일을 프로젝트에 복사 완료
		
		// 게임 등록에 필요한 파라메터들
		String gId = "";
		String gName = multipartRequest.getParameter("gName");
		String mPw = multipartRequest.getParameter("gImage");
		String mName = multipartRequest.getParameter("mName");
		String mEmail = multipartRequest.getParameter("mEmail");
		
		if (gImage == null) {
			gImage = "emptyGame.png";
		}
		
		String gIdTag = multipartRequest.getParameter("gIdTag");
		String gDes = multipartRequest.getParameter("gDes");
		String gPub = multipartRequest.getParameter("gPub");
		
		Date gRdate = null;
		
		if(multipartRequest.getParameter("gRdate") != null) {
			gRdate = Date.valueOf(multipartRequest.getParameter("gRdate"));
		}
		
		GameDto gDto = new GameDto(gIdTag, gId, gName, gImage, gDes, gPub, gRdate);
		GameDao gDao = GameDao.getInstance();
		
		int writeResult = gDao.writeGame(gDto);
		
		if (writeResult == GameDao.SUCCESS) {
			System.out.println("게임등록 성공 : service");
			request.setAttribute("writeGameResult", "게임등록 성공했습니다 : " + gDto.getgName());
		} else {
			System.out.println("게임등록 실패 : service");
		}

	}

}
