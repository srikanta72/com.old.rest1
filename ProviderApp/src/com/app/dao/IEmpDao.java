package com.app.dao;

import com.app.model.EmpData;
//POJI
public interface IEmpDao {

	public boolean isEmpIdExistInDb(int empId);
	public int saveEmpDataToDb(EmpData ob);
}
