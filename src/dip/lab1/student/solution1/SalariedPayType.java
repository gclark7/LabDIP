/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab1.student.solution1;

/**
 *
 * @author gcDataTechnology
 */
public class SalariedPayType implements PayType{
    
    private static final String NEED_NUMBER="Please enter a number value";
    private static final String PROMPT_AGAIN="Please Try Again";
    private static final String PROMPT_FOR_HOURS="Please enter base hours worked";
    private static final String PROMPT_FOR_OVERTIME_HOURS="Please enter overtime hours worked";
    private static final String PROMPT_FOR_BASERATE="Please enter base pay rate";
    private static final String PROMPT_FOR_OVERTIME_RATE="Please enter overtime pay rate";
    private static final String ENTRY_ERR="Please enter a positive number or ZERO";
    private static final double MIN=0.00;
    
    UserInput userIn;
    UserOutput userOut;
    
    public SalariedPayType(){
        userIn = new KeyboardInput();
        userOut = new ConsoleOutput();
    }
    
     public double calculateWage(){
          double something=0;
          return something;
     }
    
    @Override
    public double getAnnualWage(){
        double x=0;
        return x;
    }
    
    
    
}
