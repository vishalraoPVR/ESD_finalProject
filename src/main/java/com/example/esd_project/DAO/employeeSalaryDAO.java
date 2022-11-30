package com.example.esd_project.DAO;


import com.example.esd_project.Bean.employee_Salary;

import java.util.List;

public interface employeeSalaryDAO {

    List<employee_Salary> getSalary(Integer employee_id, Integer month);
    List<employee_Salary> getSalaryHistory(Integer employee_id);


}
