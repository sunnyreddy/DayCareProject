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

    public Vaccine(String name, String status) {
        this.name = name;
        this.status = status;//To change body of generated methods, choose Tools | Templates.
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
}
