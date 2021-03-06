/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Person.Person;
import java.util.Date;

/**
 *
 * @author medas
 */
public class Employee extends Person {
    private String userName;
    private String password;
    private Date employedDate;
    private int salary;
    private String saltValue;
    public Employee(String personId, int age, String firstName, String lastName) {
        super(personId, age, firstName, lastName);
    }
    
    public Employee(String personId, int age, String firstName, String lastName, Date employedDate, int salary, String userName, String password,String saltValue) {

        super(personId, age, firstName, lastName);
        this.employedDate = employedDate;
        this.salary = salary;
        this.userName = userName;
        this.password = password;
        this.saltValue = saltValue;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getEmployedDate() {
        return employedDate;
    }

    public void setEmployedDate(Date employedDate) {
        this.employedDate = employedDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getSaltValue() {
        return saltValue;
    }

    public void setSaltValue(String saltValue) {
        this.saltValue = saltValue;
    }
    
    
}
