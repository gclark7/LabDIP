package dip.lab1.student.solution1;

/**
 * An implementation sub-class of an Employee. These are low-level classes
 * in the DIP. Does it meet the rules of DIP? If not fix it.
 *
 * @author your name goes here
 */
public class HourlyEmployee implements Employee{
                                       
    
    private PayType payType;
    private String fName;
    private String lName;
    private double hourlyRate;
    private double overTimeRate;
    
    
    
    public HourlyEmployee(String fName, String lName, double hourlyRate) {
        this.fName=fName;
        this.lName=lName;
        this.hourlyRate=hourlyRate;//negotiated through HR
        
        payType= new HourlyPayType();//no need to ask for it
        //PayType has its own methods for calculating pay  
        //used this instead of enum...I like enums but this seems more efficient
    }

    //copied from Employee Class to preserve them
    /*
     * 
     * 
     */

    @Override
    public double payEmployee() {
        return payType.calculateWage();
    }

    @Override
    public double raiseEmployeeBasePay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEmployeeID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getEmployeeID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmployeeFname() {
        return fName;
    }

    @Override
    public void setEmployeeFname(String fName) {
        this.fName=fName;
    }

    @Override
    public String getEmployeeLname() {
        return lName;
    }

    @Override
    public void setEmployeeLname(String lName) {
        this.lName=lName;
               
    }
    
    
    

}
