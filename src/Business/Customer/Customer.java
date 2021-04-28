/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Immunization.Vaccine;
import Business.Person.Person;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author medas
 */
public class Customer extends Person {
    private String userName;
    private String password;
    private List<Vaccine> vaccinesList;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
    private Date registrationDate;
    public Customer(int personId, int age, String firstName, String lastName, Date registrationDate, String userName, String password) {
        super(personId, age, firstName, lastName);
        this.registrationDate = registrationDate;
        this.userName = userName;
        this.password = password;
        this.vaccinesList = new ArrayList<>();
    }
    
}
