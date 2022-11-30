package com.example.esd_project.Controller;

import com.example.esd_project.Bean.employee;
import com.example.esd_project.DAO.DAOImplementation.EmployeeDAOImpl;
import com.example.esd_project.DAO.EmployeeDAO;
import com.example.esd_project.service.EmployeeService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
@Path("/employee")
public class EmployeeController {

    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @GET
    @Path("/get_employee")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_employee(){
        List<employee> emp = this.employeeDAO.getEmployeeID();

        return Response.status(200).entity(emp).build();
    }

    EmployeeService employeeService =new EmployeeService();
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(employee employee) {
        com.example.esd_project.Bean.employee loggedInEmployee = employeeService.login(employee);

        if (loggedInEmployee == null)
            return Response.status(401).build();
        else
            return Response.ok().entity(loggedInEmployee).build();
    }




}
