package com.ssbit.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssbit.emp.dao.IIs_MaterDao;
import com.ssbit.emp.model.Is_Mater;

@Service
public class Is_MaterService implements IIs_MaterService {

	@Autowired
	private IIs_MaterDao is_MaterDao;
	
	@Override
	public List<Is_Mater> Is_MaterList(Is_Mater is_marter) {
		return is_MaterDao.Is_MaterList(is_marter);
	}

	@Override
	public Is_Mater is_MaterOneRow(Is_Mater is_mater) {
		return is_MaterDao.is_MaterOneRow(is_mater);
	}
	
	@Override
	public int cntIs_Marter() {
		return is_MaterDao.cntIs_Marter();
	}

	@Override
	public int modify_is_mater(Is_Mater is_mater) {
		return is_MaterDao.modify_is_mater(is_mater);
	}

	@Override
	public int write_is_mater(Is_Mater is_mater) {
		return is_MaterDao.write_is_mater(is_mater);
	}

}
