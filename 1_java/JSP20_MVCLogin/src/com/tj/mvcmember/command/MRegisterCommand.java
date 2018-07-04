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
		
		// ������ �ö� ÷�� ������ �ҽ����Ͽ� copy �ϴ� �۾�
		InputStream is = null;
		OutputStream os = null;
		
		try {
			File upFile = new File(path + "/" + mPhoto); //������ �ö� ����
			if(upFile.exists()) { // ������ �����ϴ� ��츸 copy
				is = new FileInputStream(upFile);
			
				String copyFolder = "C:/Users/Leodays/Desktop/Dev/webstudy/1_java/JSP21_Model2Ex/memberPhoto/" + mPhoto;
				os = new FileOutputStream(copyFolder); // ������ ������ ����� ��η� ��ü ����
				
				byte[] bs = new byte[(int)upFile.length()]; // ������ �뷮��ŭ�� �迭 ����.
				while (true){
					int readByte = is.read(bs); // �о���̱�
					if (readByte == -1) {
						break;
					}
					os.write(bs, 0, readByte); // �����۾�
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
			System.out.println("�ߺ� ȸ�� ����");
			request.setAttribute("registerResuilt", "ȸ�� ���̵� �����մϴ�.");
		} else {
			System.out.println("�ߺ� ȸ�� ���� : controll");
			
			int registerResuilt = mdao.insertMember(dto);
			
			if (registerResuilt == MemberDao.SUCCESS) {
				System.out.println("ȸ�� ���� ����");
				request.setAttribute("registerResuilt", "ȸ�� ���� ����");
			} else {
				System.out.println("ȸ�� ���� ����");
				request.setAttribute("registerResuilt", "ȸ�� ���� ����");
			}
		
		}// if end
		
	}// excute()

}
