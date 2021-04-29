/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

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

/**
 *
 * @author medas
 */
public class Customer extends Person {
    private String userName;
    private String password;
    private List<Vaccine> vaccinesList;
    private String saltValue;
    private Date registrationDate;
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

    public List<Vaccine> getVaccinesList() {
        return vaccinesList;
    }

    public void setVaccinesList(List<Vaccine> vaccinesList) {
        this.vaccinesList = vaccinesList;
    }

    public String getSaltValue() {
        return saltValue;
    }

    public void setSaltValue(String saltValue) {
        this.saltValue = saltValue;
    }
    public Customer(){
    }
    
    public Customer(String personId, int age, String firstName, String lastName){
        super(personId, age, firstName, lastName);
    }
    
    public Customer(String personId, int age, String firstName, String lastName, Date registrationDate, String userName, String password, String salt) {

        super(personId, age, firstName, lastName);
        this.registrationDate = registrationDate;
        this.userName = userName;
        this.password = password;
        this.vaccinesList = new ArrayList<>();
        this.saltValue = salt;
    }
   public List<Customer>  getDetails(){
       List<Customer> empDetails = new ArrayList();
            MongoClient mongoClient = new MongoClient("localhost", 27017); 
         DB db = mongoClient.getDB("TestDB");
         DBCollection userCollection = db.getCollection("Customers");
         DBCursor cursor = null;
         cursor = userCollection.find();
         
            while(cursor.hasNext()){
                DBObject obj = cursor.next();
                String personId = obj.get("_id").toString();
                String firstName = obj.get("firstName").toString();
                String lastName = obj.get("lastName").toString();
                Date regDate = (Date)obj.get("registrationDate");
                userName = obj.get("userName").toString();
                password = obj.get("password").toString();
                int age =  (int)obj.get("age");
                saltValue = obj.get("saltValue")!=null?obj.get("saltValue").toString():PasswordUtils.getSalt(30);
                Customer Health= new Customer(personId,age,firstName,lastName,regDate,userName,password,saltValue);
                empDetails.add(Health);
            }
          return empDetails;

    }
    
    
}
