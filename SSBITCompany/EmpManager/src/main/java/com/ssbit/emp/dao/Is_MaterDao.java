package com.ssbit.emp.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssbit.emp.model.Is_Mater;

@Repository
public class Is_MaterDao implements IIs_MaterDao {

	public static final int SUCCESS = 1; // 성공	
	public static final int FAIL = 0; // 실패
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Override
	public List<Is_Mater> Is_MaterList(Is_Mater is_marter) {
		return sessionTemplate.selectList("is_Materlist", is_marter) ;
	}

	@Override
	public Is_Mater is_MaterOneRow(Is_Mater is_mater) {
		return sessionTemplate.selectOne("is_MaterOneRow", is_mater);
	}

	@Override
	public int cntIs_Marter() {
		return sessionTemplate.selectOne("cntIs_Marter");
	}

	@Override
	public int modify_is_mater(Is_Mater is_mater) {
		return sessionTemplate.update("modifyMater", is_mater);
	}

	@Override
	public int write_is_mater(Is_Mater is_mater) {
		return sessionTemplate.insert("writeMater", is_mater);
	}
}
