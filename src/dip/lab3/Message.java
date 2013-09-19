/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab3;

/**
 *
 * @author gcDataTechnology
 */
public class Message implements MessageTemplate{
    
    MessageType type;
    String messageEncoding="";
    
    
    public Message(MessageType type){
        
        this.type=type;
        messageEncoding="ImaginaryData of Type: " + this.type.toString();
    }
    
    @Override
   public MessageType getMessageType(){
       return type;
   }
   
   @Override
   public String getMessageEncoding(){
       return messageEncoding;
   }
}
