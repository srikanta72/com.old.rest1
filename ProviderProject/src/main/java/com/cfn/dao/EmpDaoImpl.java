package com.cfn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cfn.dao.util.ConnectionUtil;
import com.cfn.model.dto.Employee;

public class EmpDaoImpl implements EmpDao {

	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	int result = -1;
	String response=null;
	
	public boolean isEmployeeExist(int empId) {
		connection = ConnectionUtil.getConnection();
		String sql = "select count(empno) from emp3 where empno=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, empId);

			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			result = resultSet.getInt(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == 0) {
			return false;
		} else {
			return true;
		}
	}

	public String saveEmployee(Employee employee) {
		connection = ConnectionUtil.getConnection();
		String sql = "insert into emp values(?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employee.getEmpId());
			preparedStatement.setString(2, employee.getEmpName());
			preparedStatement.setDouble(3, employee.getEmpSal());

			int dbResult= preparedStatement.executeUpdate();
			if (dbResult==1){
				response="Inserted Succesfully";
			}else{
				response="Insertion failure";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

}
