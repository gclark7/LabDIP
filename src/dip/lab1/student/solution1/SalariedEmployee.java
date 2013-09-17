package dip.lab1.student.solution1;

/**
 * A simple implementation sub-class of Employee. These are low-level classes
 * in the DIP. Does it meet the rules of DIP? If not fix it.
 *
 * @author your name goes here
 */
public class SalariedEmployee implements Employee {
    
    private PayType payType;
    private String fName;
    private String lName;
    private UserInput userIn;
    private UserOutput userOut;
    
    public SalariedEmployee(){
        
        payType=new SalariedPayType();
        userIn=new KeyboardInput();
        userOut=new ConsoleOutput();
    }

    @Override
    public double payEmployee() {
        return payType.calculateWage();
    }
    
    public double howMuchDoWePayEmployeeAnnually(){
        double x = payType.getAnnualWage();
        return x;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEmployeeFname(String fName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmployeeLname() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEmployeeLname(String lName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    

   
    
}
