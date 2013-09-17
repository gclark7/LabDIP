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
    //no magic numbers 
    private  final String TEST_FNAME = "Jim";
    private  final String TEST_LNAME = "Jhones";
    private  final double TEST_BASERATE=20.00;
    private  final double TEST_SALARY_COMPENSATION=53000;
    private final String PROMPT_EMPLOYEE_TYPE="Which Type of Employee Are You Hiring?";
    private final String TRY_AGAIN="Please Try Again";
    
    
    private Employee[] e = new Employee[0];
    
    public HRService(){
        userIn=new KeyboardInput();
        userOut = new ConsoleOutput();
        
    }
    
    public final void payAllEmployees(){
        
        for(int i=0;i<e.length;i++){
        
        userOut.writeLine(e[i].getEmployeeFname() + ", " + e[i].payEmployee());
        }
    }
    
    public final void hireEmployee(){
        boolean ready=false;
        String uIn="";
        int newSize=e.length+1;
        Employee n=null;
        Employee[] x=new Employee[newSize];//resize our temp array
        x=e.clone();//grab the current employees
        
        userOut.writeLine(PROMPT_EMPLOYEE_TYPE);
        for(PayType.WageType w: PayType.WageType.values()){
            userOut.writeLine(w.toString());
        }
        
        
        do{
            uIn=userIn.readLine();
            for(int j=0;j<PayType.WageType.values().length;j++){
                if(uIn.equals(PayType.WageType.values()[j].toString())){
                    ready=true;
                }
            }
            if(!ready){
            userOut.writeLine(TRY_AGAIN);
            }
        }while(!ready);
        
        switch(PayType.WageType.valueOf(uIn)){
            case HOURLY: n=new HourlyEmployee();break;
            case SALARIED: n=new SalariedEmployee();break;
            
        }
        x[newSize]=n;//enroll the employee in our array
        e=x;//giver 'er the ol' swich-er-roo
    }
    
    
    
    
    
    
    
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
