package com.ssbit.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssbit.emp.dao.Is_MaterDao;
import com.ssbit.emp.model.Is_Mater;
import com.ssbit.emp.service.IIs_MaterService;
import com.ssbit.emp.util.Paging;

@Controller
public class MainController {
	
	@Autowired
	IIs_MaterService is_materService;

	@RequestMapping(value="main", method = RequestMethod.GET)
	public String mainGet(Is_Mater is_marter, String pageNum, Model model) {
		
		int cntMater = is_materService.cntIs_Marter();
		Paging paging = new Paging(cntMater, pageNum, 10, 5); //  pageSize = 10, blockSize 5블럭 출력
		
		is_marter.setStartRow(paging.getStartRow());
		is_marter.setEndRow(paging.getEndRow());
		
		model.addAttribute("marterList", is_materService.Is_MaterList(is_marter));
		model.addAttribute("paging", paging);
		
		return "index";
	}
	@RequestMapping(value="main", method = RequestMethod.POST)
	public String mainPost(Is_Mater is_marter, String pageNum, Model model) {
		
		int cntMater = is_materService.cntIs_Marter();
		Paging paging = new Paging(cntMater, pageNum, 10, 5); //  pageSize = 10, blockSize 5블럭 출력
		
		is_marter.setStartRow(paging.getStartRow());
		is_marter.setEndRow(paging.getEndRow());
		
		model.addAttribute("marterList", is_materService.Is_MaterList(is_marter));
		model.addAttribute("paging", paging);
		
		return "index";
	}
	
	@RequestMapping(value="modify_is_materForm")
	public String modify_is_materForm(Is_Mater is_mater, Model model) {		
		Is_Mater mater = is_materService.is_MaterOneRow(is_mater);
				
		String jumin_No = mater.getJumin_No();
		String[] jumin = jumin_No.split("-");
		for (int i=0; i < jumin.length; i++) {
			model.addAttribute("jumin" + i, jumin[i]) ;
		}
		
		String tel = mater.getTel();
		String[] telArr = tel.split("-");
		for (int i=0; i < telArr.length; i++) {
			model.addAttribute("tel" + i, telArr[i]) ;
		}
		
		String addr = mater.getAddr();
		String[] addrArr = addr.split("/");
		for (int i=0; i < addrArr.length; i++) {
			model.addAttribute("addr" + i, addrArr[i]) ;
		}
		
		String birth_Ymd = mater.getBirth_Ymd();		
		String birth0 = birth_Ymd.substring(0, 4); //4자리
		String birth1 = birth_Ymd.substring(4, 6); //4자리부터 2자리
		String birth2 = birth_Ymd.substring(6, 8); //6자리부터 2자리
		
		model.addAttribute("birth0", birth0);
		model.addAttribute("birth1", birth1);
		model.addAttribute("birth2", birth2);
		
		model.addAttribute("ismater", mater);
		
		return "modify";
	}
	
	@RequestMapping(value="modify_is_mater")
	public String modify_is_mater(Is_Mater is_mater, MultipartHttpServletRequest is_materRequest, Model model) {
		
		String jumin_No1 = is_materRequest.getParameter("jumin_No1");
		String jumin_No2 = is_materRequest.getParameter("jumin_No2");		
		is_mater.setJumin_No(jumin_No1 + "-" +jumin_No2);
		
		String birth0 = is_materRequest.getParameter("birth0");
		String birth1 = is_materRequest.getParameter("birth1");
		String birth2 = is_materRequest.getParameter("birth2");
		is_mater.setBirth_Ymd(birth0+birth1+birth2);
		
		String tel0 = is_materRequest.getParameter("tel0");
		String tel1 = is_materRequest.getParameter("tel1");
		String tel2 = is_materRequest.getParameter("tel2");
		is_mater.setTel(tel0+"-"+tel1+"-"+tel2);
		
		String addr0 = is_materRequest.getParameter("addr0");
		String addr1 = is_materRequest.getParameter("addr1");
		is_mater.setAddr(addr0+"/"+addr1);
		
		int modifyResult = is_materService.modify_is_mater(is_mater);
		
		if (modifyResult == Is_MaterDao.SUCCESS) {
			model.addAttribute("modifyMsg", "성공");
		} else {
			model.addAttribute("modifyMsg", "실패");	
		}
		
		return "forward:main.do";
	}
	
	@RequestMapping(value="write_is_materForm")
	public String write_is_materForm() {
		
		return "write";
	}
	
	@RequestMapping(value="write_is_mater")
	public String write_is_mater(Is_Mater is_mater, MultipartHttpServletRequest is_materRequest, Model model) {
		
		String jumin_No1 = is_materRequest.getParameter("jumin_No1");
		String jumin_No2 = is_materRequest.getParameter("jumin_No2");		
		is_mater.setJumin_No(jumin_No1 + "-" +jumin_No2);
		
		String birth0 = is_materRequest.getParameter("birth0");
		String birth1 = is_materRequest.getParameter("birth1");
		String birth2 = is_materRequest.getParameter("birth2");
		is_mater.setBirth_Ymd(birth0+birth1+birth2);
		
		String tel0 = is_materRequest.getParameter("tel0");
		String tel1 = is_materRequest.getParameter("tel1");
		String tel2 = is_materRequest.getParameter("tel2");
		is_mater.setTel(tel0+"-"+tel1+"-"+tel2);
		
		String addr0 = is_materRequest.getParameter("addr0");
		String addr1 = is_materRequest.getParameter("addr1");
		is_mater.setAddr(addr0+"/"+addr1);
		
		int writeResult = is_materService.write_is_mater(is_mater);
		
		if (writeResult == Is_MaterDao.SUCCESS) {
			model.addAttribute("writeMsg", "성공");
		} else {
			model.addAttribute("writeMsg", "실패");	
		}
		
		return "forward:main.do";
	}
	
}
