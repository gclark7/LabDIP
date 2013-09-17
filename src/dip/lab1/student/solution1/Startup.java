package dip.lab1.student.solution1;

import java.text.NumberFormat;

/**
 * Just a start and test class for this program. You may modify this class
 * in any way you see fit.
 *
 * @author jlombardo
 */
public class Startup {
   //no magic numbers 
    /*
    private static final String TEST_FNAME = "Jim";
    private static final String TEST_LNAME = "Jhones";
    private static final double TEST_BASERATE=20.00;
    private static final double TEST_SALARY_COMPENSATION=53000;
    *///testing
    
    public static void main(String[] args) {
        
        
        /*
         * We'll just use this class for testing our ccde.
         * We'll provide input and get some output...
         */

        //Low-level modules
        /*
        HourlyEmployee emp1 = new HourlyEmployee(10.50, 2020);
        SalariedEmployee emp2 = new SalariedEmployee(45000, 1250);
        SalariedEmployee emp3 = new SalariedEmployee(90000,0);
        */
        
       //removed employees from here and placed them in HR
        
              
        // High-level module
        HRService hr = new HRService();
        
        hr.hireEmployee();
        hr.payAllEmployees();
        
        // Just utility code to format numbers nicely.
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        
        /*
        // Test input/output..
        System.out.println("Employee 1 annual compensation: " +
            nf.format(hr.getAnnualCompensationForEmployee(emp1)));
        System.out.println("Employee 2 annual compensation: " +
            nf.format(hr.getAnnualCompensationForEmployee(emp2)));
        System.out.println("Employee 3 annual compensation: " +
            nf.format(hr.getAnnualCompensationForEmployee(emp3,
            HRService.SALARIED_TYPE)));
        */
        
        
        
        
    }

}
