package com.example.esd_project.service;

import com.example.esd_project.Bean.employee;
import com.example.esd_project.DAO.DAOImplementation.EmployeeDAOImpl;

public class EmployeeService {

    EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

    public employee login(employee employee){
        com.example.esd_project.Bean.employee loggedInEmployee = employeeDAO.login(employee);

        // If no login happens, then return null
        if (loggedInEmployee == null)
            return null;

//        // Setting billList to null to avoid cyclic dependency issues
//        loggedInEmployee.setBillList(null);

        return loggedInEmployee;
    }
}
