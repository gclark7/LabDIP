package dip.lab1.student.solution1;

/**
 * The concrete super class of all employee types. What's wrong with this class?
 * Find and fix all encapsulation, DIP and best practice problems learned
 * so far.
 *
 * @author your name goes here
 */
public interface Employee extends Employable{
                                 //,PayType{//created actual PayTypeClasses
    
    
   
    //removed original code or I will struggle with trying to preserve it
    //to redesign the system I needed to see white space
    
    //the questions I start with are:
    //1) what does the service want to know (HRService)
    //2) What will be returned to the Service
    //3) What future services will utilize these objects..scheduling, department assignment
    //4) Is the enum an HR value or an Employee value - Determins where to place it...maybe in the interface
    
   
    
    public abstract double payEmployee();
    public abstract double raiseEmployeeBasePay();
    
    public abstract void setEmployeeID();//integer
    public abstract int getEmployeeID();
    public abstract String getEmployeeFname();
    public abstract void setEmployeeFname(String fName);
    public abstract String getEmployeeLname();
    public abstract void setEmployeeLname(String lName);
    
}
