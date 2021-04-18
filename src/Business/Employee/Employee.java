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
    
    private Date employedDate;
    private int salary;
    public Employee(int personId, int age, String firstName, String lastName, Date employedDate, int salary) {
        super(personId, age, firstName, lastName);
        this.employedDate = employedDate;
        this.salary = salary;
    }
    
}
