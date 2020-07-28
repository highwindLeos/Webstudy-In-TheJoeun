package com.leo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.MemberDao;
import com.leo.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MJoinService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String path = request.getRealPath("memberPhoto");
		int maxFilesize = 1024 * 1024 *5; // 5Mbyte
		
		String paramStr = "";
		String mPhoto = "";
		String originFilename = "";
		
		MultipartRequest multipartRequest = null;
		try {
			// cos 라이브러리 사용 file 업로드 
			multipartRequest = new MultipartRequest(request, path, maxFilesize, "utf-8", new DefaultFileRenamePolicy()); 
			Enumeration<String> fileParams = multipartRequest.getFileNames(); 
			
			while(fileParams.hasMoreElements()) {
				paramStr = fileParams.nextElement(); 
				mPhoto = multipartRequest.getFilesystemName(paramStr); 
				originFilename = multipartRequest.getOriginalFileName(paramStr); 
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		InputStream is = null;
		OutputStream os = null;
		
		try {
			File upFile = new File(path + "/" + mPhoto); 
			if(upFile.exists()) { // 파일 복사
				is = new FileInputStream(upFile);
			
				String copyFolder = "C:/Users/Leodays/Desktop/Dev/webstudy/JSPProject/Retrotori/WebContent/memberPhoto/" + mPhoto;
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
		
		
		String mId = multipartRequest.getParameter("mId");
		String mPw = multipartRequest.getParameter("mPw");
		String mName = multipartRequest.getParameter("mName");
		String mEmail = multipartRequest.getParameter("mEmail");
		
		if (mPhoto == null) {
			mPhoto = "nothing.jpg";
		}
		
		String mTel = multipartRequest.getParameter("mTel");
		String mGender = multipartRequest.getParameter("mGender");
		String mText = multipartRequest.getParameter("mText");
		
		Timestamp mBirth = null;
		
		if(multipartRequest.getParameter("mBirth") != null) {
			mBirth = Timestamp.valueOf(multipartRequest.getParameter("mBirth")+ " 00:00:00");
		}
		
		String mAddr = multipartRequest.getParameter("mAddr");
		Timestamp mRdate = null;
		int mPoint = 100;
		
		MemberDto dto = new MemberDto(mId, mPw, mName, mEmail, mPhoto, mTel, mGender, mAddr, mText, mBirth, mRdate, mPoint);
		MemberDao mdao = new MemberDao();
		
		int confirm = mdao.confirmId(mId);
		
		if (confirm == MemberDao.MEMBER_EXISTENT) {
			System.out.println("중복아이디 있음");
			request.setAttribute("registerResuilt", "이미 존재하는 아이디입니다.");
		} else {
			System.out.println("중복 아이디 없습니다. : controll");
			
			int registerResuilt = mdao.insertMember(dto);
			
			if (registerResuilt == MemberDao.SUCCESS) {
				System.out.println("회원가입 성공");
				request.setAttribute("registerResuilt", "회원가입 성공");
			} else {
				System.out.println("회원가입 실패");
				request.setAttribute("registerResuilt", "회원가입 실패");
			}
		
		}// if end
	}
}
