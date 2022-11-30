package com.example.esd_project.Bean;

import jakarta.persistence.*;

import java.util.Date;


import jakarta.persistence.*;

import java.util.Date;
        @Entity
        @Table(name="employee_Salary")
        public class employee_Salary {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Integer salaryid;
            @Temporal(TemporalType.DATE)
            @Column(nullable = false)
            private Date payment_date;

            @Column(nullable = false)
            private Double amount;
            @Column(nullable = false)
            private String description;


            @Column(nullable = false)
            private String month;

            @ManyToOne
            @JoinColumn(name = "employeeid")
            private employee employee;


            public Integer getSalaryid() {
                return salaryid;
            }

            public void setSalaryid(Integer salaryid) {
                this.salaryid = salaryid;
            }

            public Date getPayment_date() {
                return payment_date;
            }

            public void setPayment_date(Date payment_date) {
                this.payment_date = payment_date;
            }

            public Double getAmount() {
                return amount;
            }

            public void setAmount(Double amount) {
                this.amount = amount;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public employee getEmployee() {
                return employee;
            }

            public void setEmployee(employee employee) {
                this.employee = employee;
            }

            public String getMonth() {
                return month;
            }

            public void setMonth(String month) {
                this.month = month;
            }

            public employee_Salary(){

            }

            public employee_Salary(Integer salaryid, Date payment_date, Integer month, Double amount, String description) {
                this.salaryid = salaryid;
                this.payment_date = payment_date;
                this.amount = amount;
                this.description = description;
            }
        }


