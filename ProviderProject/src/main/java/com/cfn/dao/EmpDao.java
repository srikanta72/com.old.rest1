package com.cfn.dao;

import com.cfn.model.dto.Employee;

public interface EmpDao {

	boolean isEmployeeExist(int empId);
	String saveEmployee(Employee employee);
}
