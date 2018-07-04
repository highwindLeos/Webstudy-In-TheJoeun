package com.tj.mvcmember.command;

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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tj.mvcmember.dao.MemberDao;
import com.tj.mvcmember.dto.MemberDto;

public class MRegisterCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// 파일 업로드 로직
		String path = request.getRealPath("memberPhoto");
		int maxFilesize = 1024 * 1024 *5; // 첨부 파일 용량
		
		String paramStr = "";
		String mPhoto = "";
		String originFilename = "";
		
		MultipartRequest multipartRequest = null;
		try {
			// cos 라이브러리에 있는 클래스.
			multipartRequest = new MultipartRequest(request, path, maxFilesize, "utf-8", new DefaultFileRenamePolicy()); 
			// 중복된 파일 이름을 rename 처리하게됨.
			Enumeration<String> fileParams = multipartRequest.getFileNames(); // 파일이름들을 가져옴.
			
			while(fileParams.hasMoreElements()) {
				paramStr = fileParams.nextElement(); // 파일과 연결된 파라메터
				mPhoto = multipartRequest.getFilesystemName(paramStr); // 파라미터의 파일 이름을 가져온다
				originFilename = multipartRequest.getOriginalFileName(paramStr); // 파일의 원래이름을 담는다.
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// 서버에 올라간 첨부 파일을 소스파일에 copy 하는 작업
		InputStream is = null;
		OutputStream os = null;
		
		try {
			File upFile = new File(path + "/" + mPhoto); //서버에 올라간 파일
			if(upFile.exists()) { // 파일이 존재하는 경우만 copy
				is = new FileInputStream(upFile);
			
				String copyFolder = "C:/Users/Leodays/Desktop/Dev/webstudy/1_java/JSP21_Model2Ex/memberPhoto/" + mPhoto;
				os = new FileOutputStream(copyFolder); // 복사한 파일이 저장된 경로로 객체 생성
				
				byte[] bs = new byte[(int)upFile.length()]; // 파일의 용량만큼의 배열 생성.
				while (true){
					int readByte = is.read(bs); // 읽어들이기
					if (readByte == -1) {
						break;
					}
					os.write(bs, 0, readByte); // 복사작업
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
		
		
		String mId = multipartRequest.getParameter("mId");
		String mPw = multipartRequest.getParameter("mPw");
		String mName = multipartRequest.getParameter("mName");
		String mEmail = multipartRequest.getParameter("mEmail");
		
		if (mPhoto == null) {
			mPhoto = "nothing.jpg";
		}
		
		Date mBirth = null;
		
		if(multipartRequest.getParameter("mBirth") != null) {
			mBirth = Date.valueOf(multipartRequest.getParameter("mBirth"));
		}
		
		String mAddress = multipartRequest.getParameter("mAddress");
		Timestamp mRdate = null;
		
		MemberDto dto = new MemberDto(mId, mPw, mName, mEmail, mPhoto, mBirth, mAddress, mRdate);
		MemberDao mdao = new MemberDao();
		
		int confirm = mdao.confirmId(mId);
		
		if (confirm == MemberDao.MEMBER_EXISTENT) {
			System.out.println("중복 회원 존재");
			request.setAttribute("registerResuilt", "회원 아이디가 존재합니다.");
		} else {
			System.out.println("중복 회원 없음 : controll");
			
			int registerResuilt = mdao.insertMember(dto);
			
			if (registerResuilt == MemberDao.SUCCESS) {
				System.out.println("회원 가입 성공");
				request.setAttribute("registerResuilt", "회원 가입 성공");
			} else {
				System.out.println("회원 가입 실패");
				request.setAttribute("registerResuilt", "회원 가입 실패");
			}
		
		}// if end
		
	}// excute()

}
