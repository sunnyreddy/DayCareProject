/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Immunization;

/**
 *
 * @author medas
 */
public class Vaccine {
    private String name;
    private String status;
    private String date;

    public Vaccine(String name, String status,String date) {
        this.name = name;
        this.status = status;//To change body of generated methods, choose Tools | Templates.
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
