package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.GoodsDao;
import com.tj.ex.dto.GoodsDto;

public class GetStockService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String gname = request.getParameter("gname");
		GoodsDao gdao = new GoodsDao();
		GoodsDto gdto = gdao.getGoods(gname);
		int stock = gdto.getGstock();
		
		if (gdto != null){
			if (stock > 0){
				request.setAttribute("requestStock", stock + "개 남아있습니다.");
			} else {
				request.setAttribute("requestStock", "재고가 없습니다.");
			}
		} else {
			request.setAttribute("requestStock", "없는 상품 입니다.");
		}
	}
}
