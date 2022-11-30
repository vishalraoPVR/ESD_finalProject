package com.example.esd_project.Controller;


import com.example.esd_project.Bean.employee_Salary;
import com.example.esd_project.service.SalaryService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
@Path("/salary")
public class employeeSalaryController {


    SalaryService salaryService = new SalaryService();

    @GET
    @Path("/get_month")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSalaryHistory(@QueryParam("employee_id") int employee_id, @QueryParam("month") int month){
        List<employee_Salary> salaryList = salaryService.getSalary(employee_id, month);
        return Response.ok()
                .entity(salaryList)
                .build();
    }

    @GET
    @Path("/history")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSalary(@QueryParam("employee_id") int employee_id){
        List<employee_Salary> salaryList = salaryService.getSalaryHistory(employee_id);
        return Response.ok()
                .entity(salaryList)
                .build();
    }
}
