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
    
    UserInput userIn;//abstraction
    UserOutput userOut;//abstraction
    
    private static final double MIN_BILL = 0.00;
    private static final double MAX_BILL = 100.00;
    private static final double NUM_TOO_LOW=0;
    private static final double NUM_TOO_HIGH=1.0;
    
    //messages
    private static final String PROMPT_FOR_BILLAMOUNT="Please Enter Bill Amount";
    private static final String BILL_ENTRY_ERR =
            "Error: bill must be between " + MIN_BILL + " and "
            + MAX_BILL;
    private static final String PROMPT_USER_FOR_SERVICEQUALITY="Please Enter a Service Quality Rating";
    private static final String PROMPT_FOR_TIPPERCENT="Please enter a tip amount. "+
            "We recommend: ";
    private static final String TIP_ENTRY_ERR="Please enter decimal value larger than 0.00, less than 1.0";
    private static final String NEED_NUMBER="Please enter a number value";
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

    
    
    private ServiceQuality serviceQuality;
    
    //constructors
    public BaggageServiceTipCalculator(){
        userIn=new KeyboardInput();//Abstraction
        userOut=new ConsoleOutput();//Abstraction
        
        baseTipPerBag = 1.00; // set default value
    }

    
    public BaggageServiceTipCalculator(ServiceQuality q, int bags) {
        this.setServiceRating(q); // perform validation
        this.setBagCount(bags);

        baseTipPerBag = 1.00; // set default value
    }

    

    public final void setServiceRating(ServiceQuality q) {
        // No need to validate because enums provide type safety!
        serviceQuality = q;
    }

    public ServiceQuality getServiceQuality() {
        return serviceQuality;
    }

    public int getBagCount() {
        return bagCount;
    }

    public final void setBagCount(int bagCount) {
        if(bagCount < 0) {
            throw new IllegalArgumentException(
                    "bag count must be greater than or equal to zero");
        }
        this.bagCount = bagCount;
    }

    public double getBaseTipPerBag() {
        return baseTipPerBag;
    }

    public void setBaseTipPerBag(double baseTipPerBag) {
        if(baseTipPerBag < 0) {
            throw new IllegalArgumentException(
                    "error: base tip must be greater than or equal to zero");
        }
        this.baseTipPerBag = baseTipPerBag;
    }
    
    //*************************************************************
    //Starting new codes here 9/12/2013
    //
    //*************************************************************
    
    @Override
    public void calculateTip() {
        
    }
    
    public double getTipForBaggeHandler() {
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
            
        }while(!ready);

        return tip;
    }
    
    
    
    
    
    
    
    

}
