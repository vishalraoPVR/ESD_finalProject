package com.example.esd_project.DAO;

import com.example.esd_project.Bean.employee;

import java.util.List;

public interface EmployeeDAO {

    List<employee> getEmployeeID();

    employee login(employee employee);
}
