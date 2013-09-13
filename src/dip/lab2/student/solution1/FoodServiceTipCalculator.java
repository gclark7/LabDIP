package dip.lab2.student.solution1;

/**
 * An example low-level class. Does this class definition follow the DIP?
 * If not, fix it.
 *
 * Any other best practice violations? Fix them too.
 *
 * @author your name goes here
 */
public class FoodServiceTipCalculator implements TipCalculator {
    
    UserInput userIn;//abstraction
    UserOutput userOut;//abstraction
    
    private static final double MIN_BILL = 1.00;
    private static final double NUM_TOO_LOW=0;
    private static final double NUM_TOO_HIGH=1.0;
    
    //messages
    private static final String PROMPT_FOR_BILLAMOUNT="Please Enter Bill Amount";
    private static final String BILL_ENTRY_ERR =
            "Error: bill must be a number greater than or equal to " + MIN_BILL;
    private static final String PROMPT_USER_FOR_SERVICEQUALITY="Please Enter a Service Quality Rating";
    private static final String PROMPT_FOR_TIPPERCENT="Please enter a tip amount. "+
            "We recommend: ";
    private static final String TIP_ENTRY_ERR="Please enter decimal value larger than 0.00, less than 1.0";
    private static final String NEED_NUMBER="Please enter a number value";
    private static final String NEED_DECIMAL="Please enter a decimal value";
    private static final String PROMPT_AGAIN="Please Try Again";
    
    //may want to change these to a user defined value
    //changed in the setter -- used these as suggestions
    private static final double GOOD_RATE = 0.20;
    private static final double FAIR_RATE = 0.15;
    private static final double POOR_RATE = 0.10;
     
    //use the tipRate sequence to correspond to the ServiceQuality sequence
    private final double[] tipRates={GOOD_RATE,FAIR_RATE,POOR_RATE };
      //a scale is provided to judge service quality
    //the enum is to be used to help calculate tip
    private static enum  ServiceQuality {GOOD, FAIR, POOR };

    private double bill;
    private ServiceQuality serviceQuality;
    
    //constructors
    //changed to a more dynamic system to avoid magic numbers
    //getting user input
    public FoodServiceTipCalculator(){
        userIn=new KeyboardInput();//Abstraction
        userOut=new ConsoleOutput();//Abstraction
    }
    

    
    
    /////********************************************
    //Happy with the code below here 9/12/2013
    //
    //***********************************************
    
    
    public final ServiceQuality getServiceQuality() {
        return serviceQuality;
    }
    
    
    //    public FoodServiceTipCalculator(ServiceQuality q, double billAmt) {
//        this.setServiceRating(q);
//        this.setBill(billAmt);
//    }
    
    private double getTip() {
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
            /*
            for(ServiceQuality q:ServiceQuality.values()){
                switch(q) {
                    case GOOD: 
                        userOut.writeLine(q.toString() + ": " + GOOD_RATE );
                        break;
                    case FAIR:
                        userOut.writeLine(q.toString() + ": " +  FAIR_RATE);
                        break;
                    case POOR:
                        userOut.writeLine(q.toString() + ": " + POOR_RATE);
                        break;
                }
            }
            * */
            
            //get user input
            uIn=userIn.readLine();
            //test input for proper value
            try{
                Double.parseDouble(uIn);
                if(Double.parseDouble(uIn) <= NUM_TOO_LOW || Double.parseDouble(uIn)>=NUM_TOO_HIGH) {
                    userOut.writeLine(TIP_ENTRY_ERR);
                }else{
                    ready=true;
                    tip=bill*Double.parseDouble(uIn);
                    break;
                }
            }catch(NumberFormatException e){userOut.writeLine(NEED_DECIMAL);}
            
        }while(!ready);
        
        return tip;
    }

    private final void setBill() {
        double billAmt=0;
        boolean ready=false;
        String uIn="";
        
        do{
            userOut.writeLine(PROMPT_FOR_BILLAMOUNT);
            uIn=userIn.readLine();
            try{
                billAmt=Double.parseDouble(uIn);
                if(billAmt < MIN_BILL) {
                    userOut.writeLine(BILL_ENTRY_ERR);
                }else{
                    ready=true;
                    break;
                }
            }catch(NumberFormatException e){userOut.writeLine(NEED_NUMBER);}
            
            
        }while(!ready);
        
        
        bill = billAmt;
    }


    @Override
    public final void calculateTip(){
        
        //set service quality
        this.setServiceQuality();
        
        //set the bill
        this.setBill();
        
        //run the calculations
        
        userOut.writeLine(Double.toString(this.getTip()));
        
    }
    
    // private void setServiceRating(ServiceQuality q) {
        // No need to validate because enums provide type safety!
        //I'm using an input to get enum...No magic numbers
    private final void setServiceQuality(){
        boolean ready=false;
        ServiceQuality sQ=ServiceQuality.GOOD;
        String uIn="";
        //set the service rating
        do{
            
            userOut.writeLine(PROMPT_USER_FOR_SERVICEQUALITY);
            //ouput ServiceQuality list
            for(ServiceQuality s:ServiceQuality.values()){
                userOut.writeLine(s.toString());
            }
            
            uIn=userIn.readLine();
            //test user input
            for(ServiceQuality s:ServiceQuality.values()){
                if(uIn.toUpperCase().equals(s.toString())){
                    ready=true;
                    sQ=s;
                    break;
                }
            }if(!ready){
                userOut.writeLine(PROMPT_AGAIN);
            }
        }while(!ready);
        
        serviceQuality = sQ;
    }
    
   

}
