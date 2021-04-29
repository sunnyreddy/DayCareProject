/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Factory;

import Business.Customer.Customer;
import Business.Employee.Employee;
import Business.Person.Person;

/**
 *
 * @author medas
 */
public class UsersFactory {
    public static Person create(String userType, 
            String personId,
            int age,
            String firstName,
            String lastName
            ) {
        switch (userType) {
            case "Employee": 
                return new Employee(personId, age, firstName, lastName);
            case "Customer": 
                return new Customer(personId, age, firstName, lastName);
        }
        return null;
    }
}
