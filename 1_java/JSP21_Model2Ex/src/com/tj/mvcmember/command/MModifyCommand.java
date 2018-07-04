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
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tj.mvcmember.dao.MemberDao;
import com.tj.mvcmember.dto.MemberDto;

public class MModifyCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String path = request.getRealPath("memberPhoto");
		int maxSize = 1024*1024*5; //5 Mbyte
		String mPhoto = "";
		
		MultipartRequest multipartRequest = null;
		try {
			multipartRequest = 
			 new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> fileparams = multipartRequest.getFileNames();
			
			while(fileparams.hasMoreElements()) {
				String paramStr = fileparams.nextElement();
				mPhoto = multipartRequest.getFilesystemName(paramStr);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}// file 업로드
		
		File serverfile = new File(path + "/" + mPhoto);
		if(serverfile.exists()){
		InputStream is = null;
		OutputStream os = null;
		try {
				is = new FileInputStream(serverfile);
				String copyFolder = "C:/Users/Leodays/Desktop/Dev/webstudy/1_java/JSP21_Model2Ex/WebContent/memberPhoto/" + mPhoto;
				os = new FileOutputStream(copyFolder);
				
				byte[] bs = new byte[(int)serverfile.length()];
				while(true){
					int nReadbyte = is.read(bs);
					if(nReadbyte == -1) break;
					os.write(bs, 0, nReadbyte);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally{
				try {
					if(os!=null) os.close();
					if(is!=null) is.close();
				}catch (Exception e) { }
			}
		} //file copy
		
		String dbmPhoto = multipartRequest.getParameter("dbmPhoto");
		String mId = multipartRequest.getParameter("mId");
		String mPw = multipartRequest.getParameter("mPw");
		String mName = multipartRequest.getParameter("mName");
		String mEmail = multipartRequest.getParameter("mEmail");
		
		if(mPhoto == null) {
			mPhoto = dbmPhoto;
		}
		
		Date mBirth = null;
		if (!multipartRequest.getParameter("mBirth").equals("")) {
			mBirth = Date.valueOf(multipartRequest.getParameter("mBirth"));
		}
		
		String mAddress = multipartRequest.getParameter("mAddress");
		Timestamp mRdate = new Timestamp(System.currentTimeMillis());
		
		MemberDto dto = new MemberDto(mId, mPw, mName, mEmail, mPhoto, mBirth, mAddress, mRdate);		
		MemberDao mDao = new MemberDao();
		int modifyResult = mDao.modifyMember(dto);
		
		if(modifyResult == MemberDao.SUCCESS) {
			
			HttpSession session = request.getSession();
			session.setAttribute("member", dto);
			request.setAttribute("modifyMsg","수정 성공했습니다.");
			
		} else if(modifyResult == MemberDao.FAIL) {
			request.setAttribute("modifyMsg","수정 실패했습니다.");
		}
		
	}

}
