package com.example.esd_project.service;
import com.example.esd_project.Bean.employee_Salary;
import com.example.esd_project.DAO.DAOImplementation.employeeSalaryDAOImpl;

import java.util.List;

public class SalaryService {

    employeeSalaryDAOImpl salaryDAO = new employeeSalaryDAOImpl();

    public List<employee_Salary> getSalary(Integer emp_id, Integer month){
        List<employee_Salary> salaryList = salaryDAO.getSalary(emp_id, month);

        //removing reference
        for(employee_Salary salary : salaryList)
            salary.setEmployee(null);

        return salaryList;
    }

    public List<employee_Salary> getSalaryHistory(Integer emp_id){
        List<employee_Salary> salaryList = salaryDAO.getSalaryHistory(emp_id);

        //removing reference
        for(employee_Salary salary : salaryList)
            salary.setEmployee(null);

        return salaryList;
    }
}
