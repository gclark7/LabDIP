/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab2.student.solution1;

/**
 *
 * @author GClark7
 */
public interface TipCalculator {
    
   //originally placed the enum list for ServiceQuality here...
    //changed so that each class can define ServiceQuality
   //9-17-2013 Jim says it is better to place enums in own file..easier to share with other projects
    //did confirm enum can go here to be available publicly and inherited
    
    public abstract void calculateTip();
    
    
}
