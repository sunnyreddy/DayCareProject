/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Customer.CustomerDirectory;
import Business.Employee.EmployeeDirectory;
import java.util.ArrayList;

/**
 *
 * @author medas
 */
public abstract class Organization {

    private String name;
    private EmployeeDirectory employeeDirectory;
    private CustomerDirectory customerDirectory;
    private int organizationID;
    private static int counter = 0;

    public Organization(String name) {
        this.name = name;
        employeeDirectory = new EmployeeDirectory();
        customerDirectory = new CustomerDirectory();
        organizationID = counter;
        ++counter;
    }
    
    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
