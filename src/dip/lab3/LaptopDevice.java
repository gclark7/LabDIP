/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab3;

/**
 *
 * @author gcDataTechnology
 */
public class LaptopDevice implements Device{
     private DeviceType deviceType=DeviceType.LAPTOP;
     private MessageHandler messageHandler;
     private MessageType[] compatibleMessages;
     //private final int EXPANDARRAY=1;
     private final int STARTING_INDEX=0;
     private UserOutput userOut;
     private Message message;
     
     private final String WRONG_MESSAGE_TYPE="I cannot receive that message type";
     private String SENDING_STARTED="I am sending a message from a " + deviceType + " to a ";
     private final String ERROR="ERROR...MyBad";
     private final String MESSAGE_RECEIVED="The package has been received";
     
    
     //constructors
        
     public LaptopDevice(MessageType[] types, UserOutput userOut){
         if(types!=null && userOut!=null){
             
             messageHandler = new MessageHandler();
             this.userOut=userOut;


             //set message types
             setCompatibleMessageTypes(types);
         }else{
             //throws exception
             userOut.writeLine(ERROR);
         }
         
     }
     
     //Destination Methods
     @Override
     public final void receiveMessageFromSource(Message message){
            userOut.writeLine(MESSAGE_RECEIVED);
         //useMessage has exhausive error handling since it was declared public abstract in the interface
             useMessage(message);
            
            
     }
     
    public final boolean checkMessageCompatibility(Message message){
        boolean goodMessage=false;
        if(message!=null){
            for(MessageType m:compatibleMessages){
                if(message.getMessageType().equals(m)){
                    goodMessage=true;
                }
            }
        }else{
            //throws exception
            userOut.writeLine(ERROR);
        
        }
        return goodMessage;
    }
    
    @Override
    public  final void setCompatibleMessageTypes(MessageType[] types){
       boolean ready=true;
       for(MessageType t:types){
           if(t==null){
               ready=false;
           }
       }
       if(ready){
       compatibleMessages=new MessageType[types.length];
       System.arraycopy(types,STARTING_INDEX, compatibleMessages, STARTING_INDEX, types.length);
       }else{
           //throw an exception
           userOut.writeLine(ERROR);
       }
    }
    
    @Override
    public final MessageType[] getCompatibleMessageTypes(){
        
        return compatibleMessages;
    }
            
    @Override
    public final void useMessage(Message message){
        if(message!=null){
        //checks for compatibility
             if(checkMessageCompatibility(message)){

                 //uses the data appropriately
                 for(MessageType m:compatibleMessages){
                    if(message.getMessageType().equals(m)){
                        //use message accordingly
                        userOut.writeLine(message.getMessageEncoding());//using as a substitute reality
                    }
                 }
             }else{
                 //throwsException;
                 userOut.writeLine(WRONG_MESSAGE_TYPE);
             }
        }else{
            //throws exception
            userOut.writeLine(ERROR);
        }
            
    }
        
        
    
    
    //Source Methods
    @Override
    public  final void createMessage(MessageType type){
        if(type!=null){
        message=new Message(type);
        }else{
            //throw exception
            userOut.writeLine(ERROR);
        }
    }
    
    @Override
    public final Message getMessage(){
        return message;
    }
    
    @Override
    public  final void sendMessageToDestination(Message message, MessageDestination destination){
        if(message!=null && destination!=null){
            userOut.writeLine(SENDING_STARTED + destination.getDeviceType().toString());
            
            //delegates the work
            messageHandler.deliverMessageToDesination(message, destination);
        }else{
            //throw exception
            userOut.writeLine(ERROR);
        }
        
    }
    
    //Getters & Setters
    public final DeviceType getDeviceType() {
        return deviceType;
    }

    public final void setDeviceType(DeviceType deviceType) {
        if(deviceType!=null){
        this.deviceType = deviceType;
        }else{
            //throws exception
            userOut.writeLine(ERROR);
        }
    }

    public final MessageHandler getMessageHandler() {
        return messageHandler;
    }

    public final void setMessageHandler(MessageHandler messageHandler) {
        if(messageHandler!=null){
        this.messageHandler = messageHandler;
        }else{
            //throws exception
            userOut.writeLine(ERROR);
        }
        
    }

    
    
    
}
