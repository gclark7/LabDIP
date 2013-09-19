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
     private DeviceType deviceType;
     private MessageHandler messageHandler;
     private MessageType[] compatibleMessages;
     private final int EXPANDARRAY=1;
     private final int STARTING_INDEX=0;
     private UserOutput userOut;
     private Message message;
     
     private final String WRONG_MESSAGE_TYPE="I cannot receive that message type";
     
    
     //constructors
        
     public LaptopDevice(MessageType[] types, UserOutput userOut){
         if(types!=null && userOut!=null){
             deviceType=DeviceType.LAPTOP;
             messageHandler = new MessageHandler();
             this.userOut=userOut;


             //set message types
             setCompatibleMessageTypes(types);
         }else{
             //throws exception
         }
         
     }
     
     //Destination Methods
     @Override
     public final void receiveMessageFromSource(Message message){
            
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
                        System.out.println(message.getMessageEncoding());//using as a substitute reality
                    }
                 }
             }else{
                 //throwsException;
                 userOut.writeLine(WRONG_MESSAGE_TYPE);
             }
        }else{
            //throws exception
        }
            
    }
        
        
    
    
    //Source Methods
    @Override
    public  final void createMessage(MessageType type){
        if(type!=null){
        message=new Message(type);
        }else{
            //throw exception
        }
    }
    
    @Override
    public final Message getMessage(){
        return message;
    }
    
    @Override
    public  final void sendMessageToDestination(Message message, MessageDestination destination){
        if(message!=null && destination!=null){
        messageHandler.deliverMessageToDesination(message, destination);
        }else{
            //throw exception
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
        }
        
    }

    
    
    
}
