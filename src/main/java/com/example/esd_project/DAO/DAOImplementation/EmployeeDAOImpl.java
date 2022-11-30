package com.example.esd_project.DAO.DAOImplementation;

import com.example.esd_project.Bean.employee;
import com.example.esd_project.DAO.EmployeeDAO;
import com.example.esd_project.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    public List<employee> getEmployeeID(){
        try (Session session = HibernateSessionUtil.getSession()){
            List<employee> empList = new ArrayList<>();
            for (final Object d : session.createQuery("FROM employee ").list()) {
                empList.add((employee) d);
            }
//            List<Object> empList = new ArrayList<~>(
//                session.createQuery("from Employee ").list()
//            });
            return empList;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    public employee login(employee employee) {
        try (Session session = HibernateSessionUtil.getSession()){
            String employeeEmail = employee.getEmployeeEmail();
            String employeePassword = employee.getEmployeePassword();

            List<Object> result = new ArrayList<Object>(
                    session.createQuery(
                                    "FROM employee WHERE employeeEmail = :employeeEmail and employeePassword = :employeePassword"
                            )
                            .setParameter("employeeEmail", employeeEmail)
                            .setParameter("employeePassword", employeePassword)
                            .list()
            );

            // If no valid Student found, return null so that login failure is understood
            if (result.size() == 0)
                return null;
            else
                return (com.example.esd_project.Bean.employee) result.get(0);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return null;
    }



}
