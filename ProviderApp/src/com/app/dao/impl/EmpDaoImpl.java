package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.app.dao.IEmpDao;
import com.app.dao.util.ConnectionUtil;
import com.app.model.EmpData;

public class EmpDaoImpl implements IEmpDao{

	@Override
	public boolean isEmpIdExistInDb(int empId) {
		String sql="select count(*) from etab where eid=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=-1;
		try {
			con=ConnectionUtil.getConn();
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, empId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count>0?true:false;
	}
	@Override
	public int saveEmpDataToDb(EmpData ob) {
		String sql="insert into etab values(?,?,?)";
		Connection con=null;
		PreparedStatement pstmt=null;
		int count=-1;
		try {
			con=ConnectionUtil.getConn();
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, ob.getEmpId());
			pstmt.setString(2, ob.getEmpName());
			pstmt.setDouble(3, ob.getEmpSal());
			
			count=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
