/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Person.Person;
import java.util.Date;

/**
 *
 * @author medas
 */
public class Customer extends Person {
    
    private Date registrationDate;
    public Customer(int personId, int age, String firstName, String lastName, Date registrationDate) {
        super(personId, age, firstName, lastName);
        this.registrationDate = registrationDate;
    }
    
}
