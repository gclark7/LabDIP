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
     //UserOutput userOut;
     Message message;
     
    
     
     public LaptopDevice(MessageType[] types){
         deviceType=DeviceType.LAPTOP;
         messageHandler = new MessageHandler();
         
         
         //set message types
         setCompatibleMessageTypes(types);
         
     }
     
     //Destination Methods
     @Override
     public  void receiveMessageFromSource(Message message){
         if(checkMessageCompatibility(message)){
             useMessage(message);
         }else{//throwsException;
             
         }
     }
     
    public final boolean checkMessageCompatibility(Message message){
        boolean goodMessage=false;
        for(MessageType m:compatibleMessages){
            if(message.getMessageType().equals(m)){
                goodMessage=true;
            }
        }
        return goodMessage;
    }
    
    @Override
    public  final void setCompatibleMessageTypes(MessageType[] types){
       compatibleMessages=new MessageType[types.length];
       System.arraycopy(types,STARTING_INDEX, compatibleMessages, STARTING_INDEX, types.length);
    }
    
    @Override
    public MessageType[] getCompatibleMessageTypes(){
        //perform error hanlding ensure index > length
        return compatibleMessages;
    }
            
    @Override
    public final void useMessage(Message message){
        
        
            for(MessageType m:compatibleMessages){
                if(message.type.equals(m)){
                    //use message accordingly
                    System.out.println(message.getMessageEncoding());
                }
            }
    }
        
        
    
    
    //Source Methods
    @Override
    public  final void createMessage(MessageType type){
        message=new Message(type);
    }
    
    @Override
    public Message getMessage(){
        return message;
    }
    
    @Override
    public  final void sendMessageToDestination(Message message, Destination destination){
        messageHandler.deliverMessageToDesination(message, destination);
    }
    
    
}
