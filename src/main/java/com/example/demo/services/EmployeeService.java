package com.example.demo.services;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Lavet af Joakim
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    UserService userService;

    public Employee fetchEmployeeById(int id) {
        return employeeRepo.fetchEmployeeById(id);
    }

    public List<Employee> fetchAllEmployees() {
        return employeeRepo.fetchAllEmployees();
    }

    public void createEmployee(Employee e) {
        employeeRepo.createEmployee(e);
        // After creating an employee, a corresponding user is created
        userService.createUserFromEmployee(e);
    }

    public void updateEmployee(Employee e) {
        employeeRepo.updateEmployee(e);
        // After updating an employee, the corresponding user role is updated. It's the only thing that can be updated on a user.
        userService.updateUserRoleByUsername(e.getJob_title(), e.getFirst_name());
    }

    public void deleteEmployee(int id) {
        employeeRepo.deleteEmployee(id);
    }

    public String formatPhone(String phone) {
        // If user typed in number as xx-xx-xx-xx it will be formattted to xxxxxxxx
        if (phone.length() > 8) {
            phone = phone.replaceAll("[\\-]", "");
        }
        return phone;
    }

    public String formatCpr(String cpr) {
        // If user typed in cpr as xxxxxxxxxx it will be formattted to xxxxxx-xxxx
        if (cpr.length() == 10) {
            cpr = cpr.substring(0, 6) + "-" + cpr.substring(6);
        }
        return cpr;
    }

    // Methods used for checking for duplicates
    public boolean checkForDuplicateCpr(String cpr) {
        List<String> cprList = employeeRepo.fetchCprFromEmployee();
        return cprList.contains(cpr);
    }

    public boolean checkForDuplicateEmail(String email) {
        List<String> emailList = employeeRepo.fetchEmailFromEmployee();
        return emailList.contains(email);
    }

    public boolean checkForDuplicatePhoneNumber(String phonenumber) {
        List<String> phoneNumberList = employeeRepo.fetchPhoneNumberFromEmployee();
        return phoneNumberList.contains(phonenumber);
    }

    public boolean checkForOtherDuplicateCpr(String cpr, int id) {
        List<String> cprList = employeeRepo.fetchCprFromOtherEmployee(id);
        return cprList.contains(cpr);
    }

    public boolean checkForOtherDuplicateEmail(String email, int id) {
        List<String> emailList = employeeRepo.fetchEmailFromOtherEmployee(id);
        return emailList.contains(email);
    }

    public boolean checkForOtherDuplicatePhoneNumber(String phonenumber, int id) {
        List<String> phoneNumberList = employeeRepo.fetchPhoneNumberFromOtherEmployee(id);
        return phoneNumberList.contains(phonenumber);
    }
}