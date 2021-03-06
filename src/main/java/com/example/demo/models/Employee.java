package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;

//Lavet af Joakim
@Entity
public class Employee {

    @Id
    private int employee_id;
    private String first_name;
    private String last_name;
    private String cpr;
    private String email;
    private String job_title;
    private String phonenumber;
    private String employment_date;
    private String authority;

    public Employee() {
    }

    public Employee(int employee_id, String first_name, String last_name, String cpr, String email, String job_title, String phonenumber, String employment_date, String authority) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.cpr = cpr;
        this.email = email;
        this.job_title = job_title;
        this.phonenumber = phonenumber;
        this.employment_date = employment_date;
        this.authority = authority;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmployment_date() {
        return employment_date;
    }

    public void setEmployment_date(String employment_date) {
        this.employment_date = employment_date;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", cpr='" + cpr + '\'' +
                ", email='" + email + '\'' +
                ", job_title='" + job_title + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", employment_date='" + employment_date + '\'' +
                '}';
    }
}