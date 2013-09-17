package dip.lab1.student.solution1;

import javax.swing.JOptionPane;

/**
 * A high-level class that delegates to employee objects to do the work. Does
 * this class design follow the DIP? If not, fix it.
 *
 * @author your name goes here
 */
public class HRService {
    ///moving all code responsible for employee to the employee interface
    private UserOutput userOut;
    private UserInput userIn;
    
    
    /** 
     * Constants can be used for retrieving annual wages of
     * various employee types. Is this the best way to go? Do we have
     * type safety?
     */
   // public static final String SALARIED_TYPE = "Salaried";
   // public static final String HOURLY_TYPE = "Hourly";

    /**
     * Alternatively to the above, we could use an enum. Does this improve
     * type safety?
     * 
     * Yes it does as the values must be in the enumerated list.
     */
   
    //removed all code and preserved in readme file
    
}
