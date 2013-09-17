/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab1.student.solution1;

/**
 *
 * @author gcDataTechnology
 */
public class HourlyPayType implements PayType{
    
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
            
    public HourlyPayType(){
         userIn = new KeyboardInput();
         userOut = new ConsoleOutput();
    }
    
    @Override
    public double calculateWage(){
        double hours=0.00;
        double overTimeHours=0.00;
        double overTimeRate=0.00;
        double basePayRate=0.00;
       
        
        boolean ready=false;
        String uIn="";
        
        //get user hours
        do{
            
            userOut.writeLine(PROMPT_FOR_HOURS);
            uIn=userIn.readLine();
            try{
                hours=Double.parseDouble(uIn);
                if(hours < MIN) {
                    userOut.writeLine(ENTRY_ERR);
                }else{
                    hours=Double.parseDouble(uIn);
                    ready=true;
                    break;
                }
            }catch(NumberFormatException e){userOut.writeLine(NEED_NUMBER);}
            if(!ready){
                userOut.writeLine(PROMPT_AGAIN);
            }
            
        }while(!ready);
        
        //get base rate
        ready=false;
         
        do{
            
            userOut.writeLine(PROMPT_FOR_BASERATE);
            uIn=userIn.readLine();
            try{
                basePayRate=Double.parseDouble(uIn);
                if(basePayRate < MIN) {
                    userOut.writeLine(ENTRY_ERR);
                }else{
                    basePayRate=Double.parseDouble(uIn);
                    ready=true;
                    break;
                }
            }catch(NumberFormatException e){userOut.writeLine(NEED_NUMBER);}
            if(!ready){
                userOut.writeLine(PROMPT_AGAIN);
            }
            
        }while(!ready);
        
        //get overtime hours
        ready=false;
        
        do{
            
            userOut.writeLine(PROMPT_FOR_OVERTIME_HOURS);
            uIn=userIn.readLine();
            try{
                overTimeHours=Double.parseDouble(uIn);
                if(overTimeHours < MIN) {
                    userOut.writeLine(ENTRY_ERR);
                }else{
                    overTimeHours=Double.parseDouble(uIn);
                    ready=true;
                    break;
                }
            }catch(NumberFormatException e){userOut.writeLine(NEED_NUMBER);}
            if(!ready){
                userOut.writeLine(PROMPT_AGAIN);
            }
            
        }while(!ready);
        
        //get overtime rate
        ready=false;
        
        do{
            
            userOut.writeLine(PROMPT_FOR_OVERTIME_RATE);
            uIn=userIn.readLine();
            try{
                overTimeRate=Double.parseDouble(uIn);
                if(overTimeRate < MIN) {
                    userOut.writeLine(ENTRY_ERR);
                }else{
                    ready=true;
                    break;
                }
            }catch(NumberFormatException e){userOut.writeLine(NEED_NUMBER);}
            if(!ready){
                userOut.writeLine(PROMPT_AGAIN);
            }
            
        }while(!ready);
        
        
        return (overTimeRate*overTimeHours)+(hours*basePayRate);
        
    }
    
    
    
}
