package com.example.esd_project.Bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
    @Table(name = "Employee")
    public class employee {
        @Id
        @Column(name = "employee_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int employee_id;

        //Storing employee First Name
        @Column(name = "first_name", nullable = false)
        private String employeeFName;

        //Storing employee Last Name
        @Column(name = "last_name", nullable = false)
        private String employeeLName;

        //Storing Employee Email
        @Column(name = "email", nullable = false)
        private String employeeEmail;

        //Storing Title
        @Column(name = "title", nullable = false)
        private String employeeTitle;

        //Storing Title
        @Column(name = "password", nullable = false)
        private String employeePassword;



    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
        @JsonIgnore // Doesn't seem to work in this case
        private List<employee_Salary> emp_salary;

        public employee(int employee_id, String employeeFName, String employeeLName, String employeeEmail, String employeeTitle, String employeePassword) {
            this.employee_id = employee_id;
            this.employeeFName = employeeFName;
            this.employeeLName = employeeLName;
            this.employeeEmail = employeeEmail;
            this.employeeTitle = employeeTitle;
            this.employeePassword=employeePassword;
        }

    public employee() {

    }

    public int getEmployee_id() {return employee_id;}
        public String getEmployeeName() {
            return employeeFName+employeeLName;
        }
        public String getEmployeeEmail(){return employeeEmail; }
        public String getEmployeeTitle(){return employeeTitle; }
        public String getEmployeePassword(){return employeePassword; }


        public void setEmployee_id(int employeeID) {
            this.employee_id = employee_id;
        }

        public void setEmployeeFName(String employeeFName) {this.employeeFName = employeeFName;
        }

        public void setEmployeeLName(String employeeLName) {
            this.employeeLName = employeeLName;
        }

        public void setEmployeeEmail(String employeeEmail) {
            this.employeeEmail = employeeEmail;
        }

        public void setEmployeeTitle(String employeeTitle) {
            this.employeeTitle = employeeTitle;
        }

        public void setEmployeePassword(String employeePassword) {
            this.employeePassword = employeePassword;
        }


//    public List<employeeSalary> getEmp_salary() {
//        return emp_salary;
//    }
//
//    public void setEmp_salary(List<employeeSalary> emp_salary) {
//        this.emp_salary = emp_salary;
//    }

//         to string to print object as a string otherwise it returns object Hashcode
        @Override
        public String toString() {
            return "Employee{" +
                    "employeeID=" + employee_id +
                    ", employeeFName='" + employeeFName + '\'' +
                    ", employeeLName='" + employeeLName + '\'' +
                    ", employeeEmail='" + employeeEmail + '\'' +
                    ", employeeTitle=" + employeeTitle + '\'' +
                    ",employeePassword" +employeePassword+'\''+
                    '}';
        }
    }

