/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab2.student.solution1;

/**
 *
 * @author GClark7
 */
public class TipManager {
    
    private TipCalculator tipCalc;//can be any TipCalculator
    
    
    //constructor
    public TipManager(TipCalculator calc){
        tipCalc= calc;
    }
    
    //tip calculate method
    public void calculateTip(){
        tipCalc.calculateTip();
    }
    
}
