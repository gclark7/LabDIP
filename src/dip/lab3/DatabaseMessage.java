/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab3;

/**
 *
 * @author gcDataTechnology
 */
public class DatabaseMessage implements MessageTemplate{
    
     private MessageType type;
    private String messageEncoding="";
    
    
    public DatabaseMessage(MessageType type){
        
        this.type=type;
        messageEncoding="ImaginaryData of Type: " + this.type.toString();
    }
    
    @Override
   public final MessageType getMessageType(){
       return type;
   }
   
   @Override
   public final String getMessageEncoding(){
       return messageEncoding;
   }
}
