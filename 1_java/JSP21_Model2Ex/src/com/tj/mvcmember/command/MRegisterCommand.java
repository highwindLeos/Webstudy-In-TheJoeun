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
		// ���� ���ε� ����
		String path = request.getRealPath("memberPhoto");
		int maxFilesize = 1024 * 1024 *5; // ÷�� ���� �뷮
		
		String paramStr = "";
		String mPhoto = "";
		String originFilename = "";
		
		MultipartRequest multipartRequest = null;
		try {
			// cos ���̺귯���� �ִ� Ŭ����.
			multipartRequest = new MultipartRequest(request, path, maxFilesize, "utf-8", new DefaultFileRenamePolicy()); 
			// �ߺ��� ���� �̸��� rename ó���ϰԵ�.
			Enumeration<String> fileParams = multipartRequest.getFileNames(); // �����̸����� ������.
			
			while(fileParams.hasMoreElements()) {
				paramStr = fileParams.nextElement(); // ���ϰ� ����� �Ķ����
				mPhoto = multipartRequest.getFilesystemName(paramStr); // �Ķ������ ���� �̸��� �����´�
				originFilename = multipartRequest.getOriginalFileName(paramStr); // ������ �����̸��� ��´�.
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
			
				String copyFolder = "C:/Users/Leodays/Desktop/Dev/webstudy/1_java/JSP21_Model2Ex/WebContent/memberPhoto/" + mPhoto;
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
		
	}// excute()

}
