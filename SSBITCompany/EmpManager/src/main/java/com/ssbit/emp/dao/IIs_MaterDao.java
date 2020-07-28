package com.ssbit.emp.dao;

import java.util.List;

import com.ssbit.emp.model.Is_Mater;

public interface IIs_MaterDao {
	
	public List<Is_Mater> Is_MaterList(Is_Mater is_marter);
	
	public Is_Mater is_MaterOneRow(Is_Mater is_mater);
	
	public int cntIs_Marter();
	
	public int modify_is_mater(Is_Mater is_mater);
	
	public int write_is_mater(Is_Mater is_mater);

}
