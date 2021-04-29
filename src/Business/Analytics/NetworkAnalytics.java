/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Analytics;

import Business.Customer.Customer;
import Business.Immunization.Vaccine;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author medas
 */
public class NetworkAnalytics {
        
        private Customer c;
        private List<Customer> listCust;
        public NetworkAnalytics(){
            c = new Customer();
            listCust = c.getDetails();
        }
        
        public HashMap<String,Integer> getVaccinationDetails(){
            HashMap<String,Integer> ent = new HashMap<>();
            HashMap<String,Integer> pending = new HashMap<>();
            
         MongoClient mongoClient = new MongoClient("localhost", 27017); 
         DB db = mongoClient.getDB("TestDB");
         DBCollection userCollection = db.getCollection("Customers");
         DBCursor cursor = null;
         cursor = userCollection.find();
         
         while(cursor.hasNext()){
            DBObject obj = cursor.next();
            
            List<BasicDBObject> vl = (List<BasicDBObject>) obj.get("vaccineInfo");
      
            for(BasicDBObject v : vl) {
                String vacName = (String) v.get("vaccineName");
                if(ent.containsKey(vacName)) {
                    if(v.get("vaccineStatus").toString().equals("Completed")) {
                        ent.put(vacName, ent.get(vacName) + 1);
                    }
                } else {
                    ent.put(vacName, 0);
                    if(v.get("vaccineStatus").toString().equals("Completed")) {
                        ent.put(vacName, ent.get(vacName) + 1);
                    }
                }
                
               
            }
        }
         System.out.println(ent);
            return ent;
    }
        
        public HashMap<String,Integer> getPendingDetails(){
            
            HashMap<String,Integer> pending = new HashMap<>();
            
         MongoClient mongoClient = new MongoClient("localhost", 27017); 
         DB db = mongoClient.getDB("TestDB");
         DBCollection userCollection = db.getCollection("Customers");
         DBCursor cursor = null;
         cursor = userCollection.find();
         
         while(cursor.hasNext()){
            DBObject obj = cursor.next();
            
            List<BasicDBObject> vl = (List<BasicDBObject>) obj.get("vaccineInfo");
      
            for(BasicDBObject v : vl) {
                String vacName = (String) v.get("vaccineName");
               
                
                if(pending.containsKey(vacName)) {
                    if(v.get("vaccineStatus").toString().equals("Pending")) {
                        pending.put(vacName, pending.get(vacName) + 1);
                    }
                } else {
                    pending.put(vacName, 0);
                    if(v.get("vaccineStatus").toString().equals("Pending")) {
                        pending.put(vacName, pending.get(vacName) + 1);
                    }
                }
            }
        }
         System.out.println(pending);
            return pending;
    }
}
