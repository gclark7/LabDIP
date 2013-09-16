package dip.lab2.student.solution1;

/**
 * An example low-level class. Does this class definition follow the DIP?
 * If not, fix it.
 *
 * Any other best practice violations? Fix them too.
 *
 * @author your name goes here
 */
public class BaggageServiceTipCalculator implements TipCalculator{
    
    private UserInput userIn;//abstraction
    private UserOutput userOut;//abstraction
    
    private static final double MIN_BILL = 0.00;
    private static final double MAX_BILL = 100.00;
    private static final double NUM_TOO_LOW=0.00;
    private static final double NUM_TOO_HIGH=1.0;
    
    //messages
    private static final String PROMPT_FOR_BASETIP_PERBAG="Please Enter Base Tip Per Bag";
    private static final String BASETIP_ERR="Please enter number greater than or equal to 0";
    private static final String PROMPT_FOR_BAGS="Pleae enter the number of bags";
    private static final String BAG_ENTRY_ERR =
            "Error: Number of bags must be a whole number greater than or equal to " + MIN_BILL;
    
    private static final String PROMPT_USER_FOR_SERVICEQUALITY="Please Enter a Service Quality Rating";
    private static final String PROMPT_FOR_TIPPERCENT="Please enter a tip for Service Quality. "+
            "We recommend: ";
    private static final String TIP_ENTRY_ERR="Please enter a decimal value larger than 0.00, less than 1.0";
    
    private static final String NEED_NUMBER="Please enter a number value";
    private static final String NEED_INTEGER="Pleaes enter a whole number";
    private static final String NEED_DECIMAL="Please enter a decimal value";
    private static final String PROMPT_AGAIN="Please Try Again";
    
    
    
    //changed in the setter -- used these as suggestions
    private static final double GOOD_RATE = 0.20;
    private static final double FAIR_RATE = 0.15;
    private static final double POOR_RATE = 0.10;
    //keeping the quality choices by class to be more dynamic
    public static enum ServiceQuality {
        GOOD, FAIR, POOR
    }
    //use the tipRate sequence to correspond to the ServiceQuality sequence
    private final double[] tipRates={GOOD_RATE,FAIR_RATE,POOR_RATE };
    

    private double baseTipPerBag;
    private int bagCount;
    private double tip;

    
    
    private ServiceQuality serviceQuality;
    
    //constructors
    public BaggageServiceTipCalculator(){
        userIn=new KeyboardInput();//Abstraction
        userOut=new ConsoleOutput();//Abstraction
        
        baseTipPerBag = 1.00; // set default value
    }

    
    //*************************************************************
    //Starting new codes here 9/12/2013
    //Testing 9/15/2013
    //*************************************************************
    
    @Override
    public final void calculateTip() {
        
        setBagCount();
        setBaseTipPerBag(); 
        setTip();
        userOut.writeLine(Double.toString(getTipForBaggageHandler()));//returns calcualted values
                
    }
    
    private final void setBaseTipPerBag() {//step 2
        boolean ready=false;
        String uIn="";
        
        do{
            userOut.writeLine(PROMPT_FOR_BASETIP_PERBAG);
            uIn=userIn.readLine();
            //test user input for a number
            try{
                Double.parseDouble(uIn);
                if(Double.parseDouble(uIn) < NUM_TOO_LOW) {
                    userOut.writeLine(BASETIP_ERR);
                }else{
                    ready=true;
                    this.baseTipPerBag = Double.parseDouble(uIn);
                    break;
                }
            }catch(NumberFormatException e){userOut.writeLine(NEED_NUMBER);}
            if(!ready){
                userOut.writeLine(PROMPT_AGAIN);
            }
        }while(!ready);
        
    }
    
     private final void setBagCount() {//step 1
        String uIn="";
        boolean ready=false;
        
        //need an integer from user
        do{
            userOut.writeLine(PROMPT_FOR_BAGS);
            uIn=userIn.readLine();
        
            try{
                    Integer.parseInt(uIn);
                    if(Integer.parseInt(uIn) < NUM_TOO_LOW) {
                        userOut.writeLine(BAG_ENTRY_ERR);
                    }else{
                        ready=true;
                        this.bagCount = Integer.parseInt(uIn);
                        break;
                    }
            }catch(NumberFormatException e){userOut.writeLine(NEED_INTEGER);}
            
            if(!ready){
                userOut.writeLine(PROMPT_AGAIN);
            }
        }while(!ready);
    }

     
     private final void setTip(){//step 3
        double tip = 0.00; // always initialize local variables
        boolean ready=false;
        String uIn="";
        
        do{
            userOut.writeLine(PROMPT_FOR_TIPPERCENT);
            int i=0;
            for(ServiceQuality q:ServiceQuality.values()){
                userOut.writeLine(q.toString() + ": " + tipRates[i]);
                i++;
            }
               
            //get user input
            uIn=userIn.readLine();
            //test input for proper value
            try{
                Double.parseDouble(uIn);
                if(Double.parseDouble(uIn) <= NUM_TOO_LOW || Double.parseDouble(uIn)>=NUM_TOO_HIGH) {
                    userOut.writeLine(TIP_ENTRY_ERR);
                }else{
                    ready=true;
                    tip=baseTipPerBag * bagCount * (1 + Double.parseDouble(uIn));
                    break;
                }
            }catch(NumberFormatException e){userOut.writeLine(NEED_DECIMAL);}
            if(!ready){
                userOut.writeLine(PROMPT_AGAIN);
            }
        }while(!ready);
    }
     
    private final double getTipForBaggageHandler() {//last step
        
        return baseTipPerBag * bagCount * (1 + tip);
    }
    
   
    public final double getTip(){
        return tip;
    }
    
     public final double getBaseTipPerBag() {
        return baseTipPerBag;
    }
    
    public final ServiceQuality getServiceQuality() {
        return serviceQuality;
    }

    public final int getBagCount() {
        return bagCount;
    }
    
    
    
    

}//close BaggageServiceTC
