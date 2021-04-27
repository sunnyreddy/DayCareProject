/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DayCare;

import Business.Employee.Employee;

/**
 *
 * @author medas
 */
public class ConfigureSystem {
    public static DayCareOrg configure(){
        DayCareOrg system = DayCareOrg.getInstance();
        return system;
    }
}
