package com.cfn.integration.rest;

import com.cfn.model.dto.Employee;

public class ClientRequestValidator {

	public static boolean validaterequest(String auth, Employee employee) {
		if (auth == null || auth.trim().equals("") || employee == null || employee.getEmpId() <= 0) {

			return false;
		} else {
			return true;
		}
	}
}
