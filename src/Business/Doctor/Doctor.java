package Business.Doctor;

import Business.Customer.Customer;
import Business.Immunization.Vaccine;
import Business.Person.Person;
import Encrypt.Password.PasswordUtils;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tejaswi
 */
public class Doctor extends Person {
    private String userName;
    private String password;
    private List<Customer> customersList;
    private String saltValue;
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

    public List<Customer> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(List<Customer> customersList) {
        this.customersList = customersList;
    }

   

    public String getSaltValue() {
        return saltValue;
    }

    public void setSaltValue(String saltValue) {
        this.saltValue = saltValue;
    }
    public Doctor(){
    }
    public Doctor(String personId, int age, String firstName, String lastName, String userName, String password, String salt) {

        super(personId, age, firstName, lastName);
        this.userName = userName;
        this.password = password;
        this.customersList = new ArrayList<>();
        this.saltValue = salt;
    }
   public List<Doctor>  getDetails(){
       List<Doctor> empDetails = new ArrayList();
            MongoClient mongoClient = new MongoClient("localhost", 27017); 
         DB db = mongoClient.getDB("TestDB");
         DBCollection userCollection = db.getCollection("Doctors");
         DBCursor cursor = null;
         cursor = userCollection.find();
         
            while(cursor.hasNext()){
                DBObject obj = cursor.next();
                String personId = obj.get("_id").toString();
                String firstName = obj.get("firstName").toString();
                String lastName = obj.get("lastName").toString();
                userName = obj.get("userName").toString();
                password = obj.get("password").toString();
                saltValue = obj.get("saltValue")!=null?obj.get("saltValue").toString():PasswordUtils.getSalt(30);
                Doctor Health= new Doctor(personId,45,firstName,lastName,userName,password,saltValue);
                empDetails.add(Health);
            }
          return empDetails;

    }
    
    
}
