/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DayCare;

import Business.Organization.Organization;
import java.util.ArrayList;

/**
 *
 * @author medas
 */
public class DayCareOrg extends Organization{
    // singleton pattern
    private static DayCareOrg dayCareOrg;
    public static DayCareOrg getInstance(){
        if(dayCareOrg == null){
            dayCareOrg = new DayCareOrg("CsyeDayCare");
        }
        return dayCareOrg;
    }

    public DayCareOrg(String name) {
        super(name);
    }
}
