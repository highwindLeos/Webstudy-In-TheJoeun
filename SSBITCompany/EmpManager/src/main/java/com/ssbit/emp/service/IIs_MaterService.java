package com.ssbit.emp.service;

import java.util.List;

import com.ssbit.emp.model.Is_Mater;

public interface IIs_MaterService {
	
	public List<Is_Mater> Is_MaterList(Is_Mater is_marter);
	
	public Is_Mater is_MaterOneRow(Is_Mater is_Mater);

	public int cntIs_Marter();
	
	public int modify_is_mater(Is_Mater is_mater);
	
	public int write_is_mater(Is_Mater is_mater);

}
