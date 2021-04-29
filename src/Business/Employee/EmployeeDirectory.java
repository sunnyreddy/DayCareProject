/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Customer.Customer;
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
public class EmployeeDirectory {

    public EmployeeDirectory() {
        
    }
    
    public List<Employee> getAllEmployeesDetails(){
        List<Employee> empDetails = new ArrayList();
        MongoClient mongoClient = new MongoClient("localhost", 27017); 
        DB db = mongoClient.getDB("TestDB");
        DBCollection userCollection = db.getCollection("Employees");
        DBCursor cursor = null;
        cursor = userCollection.find();
        while(cursor.hasNext()) {
            DBObject obj = cursor.next();
            String personId = obj.get("_id").toString();
            String firstName = obj.get("firstName").toString();
            String lastName = obj.get("lastName").toString();
            String regDate = (String)obj.get("EmployementDate");
            Date rDate = new Date(regDate);
            String userName = obj.get("userName").toString();
            String password = obj.get("password").toString();
            int age =  (int)obj.get("age");
            int salary = (int)obj.get("Salary");
            Employee emp= new Employee(personId,age,firstName,lastName,rDate,salary,userName,password);
            empDetails.add(emp);
        }
        return empDetails;
    }
}