/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab1.student.solution1;

/**
 *
 * @author gcDataTechnology
 */
public interface PayType {
    
     public static enum WageType {SALARIED, HOURLY
    }
     
    public double calculateWage();
   // public void setPayType(WageType w);//I like enums, but a whole class is better for this project
    
}
