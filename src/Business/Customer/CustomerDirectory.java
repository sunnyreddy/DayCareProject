/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Customer.Customer;
import java.util.ArrayList;

/**
 *
 * @author medas
 */
public class CustomerDirectory {
    private ArrayList<Customer> employeeList;

    public CustomerDirectory() {
        employeeList = new ArrayList();
    }

    public ArrayList<Customer> getCustomerList() {
        return employeeList;
    }
    
    public Customer createCustomer(String name){
       // create customer
       return null;
    }
}
