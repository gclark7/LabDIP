/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab3;
import javax.swing.JOptionPane;
/**
 *
 * @author gcDataTechnology
 */
public class MobilePhoneDevice implements Device{
    
      private DeviceType deviceType;
     private MessageHandler messageHandler;
     private MessageType[] compatibleMessages;
     private final int EXPANDARRAY=1;
     private final int STARTING_INDEX=0;
     //UserOutput userOut;
     Message message;
     
    
     
     public MobilePhoneDevice(MessageType[] types){
         deviceType=DeviceType.MOBILEPHONE;
         messageHandler = new MessageHandler();
         
         
         //set message types
         setCompatibleMessageTypes(types);
         
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
