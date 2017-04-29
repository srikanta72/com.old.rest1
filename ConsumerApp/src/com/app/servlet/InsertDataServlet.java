package com.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.client.ClientApp;
import com.app.model.Employee;
import com.app.util.JsonUtil;

public class InsertDataServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//reading inputs from UI(JSP)
			String eid     = request.getParameter("eid");
			String empName = request.getParameter("ename");
			String esal    = request.getParameter("esal");
			
			//parsing inputs eid,esal
			int empId     = Integer.parseInt(eid);
			double empSal = Double.parseDouble(esal);
			
			//create empty employee obj
			Employee emp = new Employee();
			
			//set values to emp object
			emp.setEmpId(empId);
			emp.setEmpName(empName);
			emp.setEmpSal(empSal);
			
			//convert emp object to JSON using JsonUtil
			String json = JsonUtil.convertObjToJson(emp);
			
			//call client with JSON str input 
			//and get String as response
			String resMsg = ClientApp.doConnect(json);
			
			//add msg to request attribute
			request.setAttribute("msg", resMsg);
			
			//dispatch to UI
			request.getRequestDispatcher("index.jsp")
			.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

}
