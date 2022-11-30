package com.example.esd_project.DAO.DAOImplementation;


import com.example.esd_project.Bean.employee_Salary;
import com.example.esd_project.DAO.employeeSalaryDAO;
import com.example.esd_project.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class employeeSalaryDAOImpl implements employeeSalaryDAO {

    public List<employee_Salary> getSalary(Integer emp_id, Integer month) {
        List<employee_Salary> salaryList = new ArrayList<>();

        try(Session session = HibernateSessionUtil.getSession()){
            for(
                    final Object salary : session
                    .createQuery("FROM employee_Salary WHERE employee.employee_id=:emp_id AND MONTH(payment_date)=:month").
                    setParameter("emp_id", emp_id)
                    .setParameter("month", month).list()
            )
                salaryList.add((employee_Salary) salary);
        }
        catch (HibernateException e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        return salaryList;
    }


    public List<employee_Salary> getSalaryHistory(Integer emp_id) {
        List<employee_Salary> salaryHistoryList = new ArrayList<>();

        try(Session session = HibernateSessionUtil.getSession()){
            for(
                    final Object salary : session
                    .createQuery("FROM employee_Salary WHERE employee.employee_id=:emp_id").
                    setParameter("emp_id", emp_id).list()
            )
                salaryHistoryList.add((employee_Salary) salary);
        }
        catch (HibernateException e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        return salaryHistoryList;
    }

}
