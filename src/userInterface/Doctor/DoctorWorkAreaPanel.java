/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.Doctor;



import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tejaswi
 */
public class DoctorWorkAreaPanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctorWorkAreaPanel
     */
   
     JPanel userProcessContainer;
      String emp_id = null;String emp_name=null;
      enum status{
          Assigned,
          Completed,
          Inprogress
      }
    
    public DoctorWorkAreaPanel(JPanel userProcessContainer,String emp_id,String emp_name) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
       
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        patientTable.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,18));
        patientTable.setRowHeight(30);
       patientTable.setRowMargin(10);
        populateTable();
         DoctorLabelName.setText("Hello User:"+emp_name);
    }
    
    
    
    private void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel)patientTable.getModel();
        dtm.setRowCount(0);
         MongoClient mongoClient = new MongoClient("localhost", 27017); 
        DB db = mongoClient.getDB("TestDB");
        DBCollection userCollection = db.getCollection("Doctors");
        DBCursor cursor = null;
        cursor = userCollection.find();
        dtm.setRowCount(0);
        while(cursor.hasNext()){
            Object[] row = new Object[dtm.getColumnCount()];
            DBObject obj = cursor.next();
            if(obj.get("_id").equals(emp_id)){
                List<DBObject> list = (List)obj.get("patients");
                for(DBObject object : list){
                    row[0] = object.get("patient_id");
                    row[1] = object.get("patient_name");
                    List<DBObject> res = (List)object.get("vaccineInfo");
                    for(DBObject l : res){
                        row[2] = l.get("vaccineName");
                        row[3] = l.get("vaccineDate");
                        dtm.addRow(row);
                    }
                }
            }
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        checkBtn = new javax.swing.JButton();
        imgLabel = new javax.swing.JLabel();
        DoctorLabelName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        patientTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        patientTable.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        patientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient Id", "Patient name", "Vaccination Name", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patientTable.setRowHeight(20);
        patientTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(patientTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(260, 220, 660, 170);

        checkBtn.setBackground(new java.awt.Color(102, 102, 0));
        checkBtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        checkBtn.setText("Vaccination done");
        checkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBtnActionPerformed(evt);
            }
        });
        add(checkBtn);
        checkBtn.setBounds(490, 520, 250, 40);

        imgLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(imgLabel);
        imgLabel.setBounds(1280, 620, 0, 190);

        DoctorLabelName.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        DoctorLabelName.setText("jLabel2");
        add(DoctorLabelName);
        DoctorLabelName.setBounds(30, 30, 370, 40);

        jLabel6.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel6.setText("Your Patients");
        add(jLabel6);
        jLabel6.setBounds(480, 120, 220, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void checkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel)patientTable.getModel();
        int selectedRow = patientTable.getSelectedRow();
        MongoClient mongoClient = new MongoClient("localhost", 27017); 
        DB db = mongoClient.getDB("TestDB");
        DBCollection doctorCollection = db.getCollection("Doctors");
        DBCollection userCollection = db.getCollection("Customers");
        if(selectedRow <0 ){
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning!",JOptionPane.WARNING_MESSAGE);
        }else{
            String patient_id = (String) patientTable.getValueAt(selectedRow,0);
            String vaccineName = (String) patientTable.getValueAt(selectedRow,2);
            DBCursor cursor = null;
            cursor = doctorCollection.find();
            while(cursor.hasNext()){
                DBObject obj = cursor.next();
                if(obj.get("_id").equals(emp_id)){
                    List<DBObject> list = (List)obj.get("patients");
                    for(DBObject object : list){
                        if(object.get("patient_id").toString().equals(patient_id)){
                                list.remove(object);
                                break;
                        }
                    }
                    obj.put("patients",list);
                }
                BasicDBObject query = new BasicDBObject();
                query.append("_id",emp_id);
                doctorCollection.remove(query);
                doctorCollection.insert(obj);
            } 
            DBCursor cursor1 = null;
            cursor1 = userCollection.find();
            while(cursor1.hasNext()){
                DBObject obj = cursor1.next();
                if(obj.get("_id").equals(patient_id)){
                    List<DBObject> list = (List)obj.get("vaccineInfo");
                    for(DBObject object : list){
                        if(object.get("vaccineName").toString().equals(vaccineName)){
                                object.put("vaccineStatus","Completed");
                                break;
                        }
                    }
                    obj.put("vaccineInfo",list);
                    BasicDBObject query = new BasicDBObject();
                    query.append("_id",patient_id);
                    userCollection.remove(query);
                    userCollection.insert(obj);
                }
                
            } 
            
            populateTable();
            JOptionPane.showMessageDialog(null, "Vaccination Completed successfully", "Success",JOptionPane.PLAIN_MESSAGE);         
            
        }
       
    }//GEN-LAST:event_checkBtnActionPerformed

    private void patientTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_patientTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DoctorLabelName;
    private javax.swing.JButton checkBtn;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable patientTable;
    // End of variables declaration//GEN-END:variables
}
