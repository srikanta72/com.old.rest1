package com.cfn.integration.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.cfn.dao.EmpDao;
import com.cfn.model.dto.Employee;
import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.core.spi.factory.ResponseBuilderImpl;

@Path("/emp")
public class EmpRestProvider {

	String responseMessage;
	boolean isClientValid;
	private EmpDao empDao;

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveEmp(Employee employee, @HeaderParam("Authorization") String auth) {
		boolean isClientValid = ClientAuthorization.validateClient(auth);
		ResponseBuilder responseBuilder = new ResponseBuilderImpl();

		if (isClientValid) {
			boolean isRequestValid = ClientRequestValidator.validaterequest(auth, employee);
			if (isRequestValid) {
				boolean isEmployeeExist = empDao.isEmployeeExist(employee.getEmpId());
				if (isEmployeeExist) {
					responseBuilder.entity("This id :" + employee.getEmpId() + " is not available");
					responseBuilder.status(Status.OK);
				} else {
					responseMessage = empDao.saveEmployee(employee);
					responseBuilder.entity(responseMessage);
					responseBuilder.status(Status.OK);
				}
			} else {
				responseBuilder.entity("Invlid Details");
				responseBuilder.status(Status.BAD_REQUEST);
			}
		} else {
			responseBuilder.entity("Invalid Client details");
			responseBuilder.status(Status.UNAUTHORIZED);

		}
		return responseBuilder.build();
	}

}
