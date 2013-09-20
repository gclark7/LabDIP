/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab3;

/**
 *
 * @author gcDataTechnology
 */
public class MessageHandler implements MessageHandlerTemplate {
    private final String SOURCE_ERROR="Source Message Error";
    
           
    @Override
    public void enrollDevice(Device device){
        
    }
    
    
    
   //takes the destination and runs the checks
    //delivers the message
    @Override
    public void deliverMessageToDesination(Message message, MessageSource source, MessageDestination destination){
        //perform type check
        if(message!=null && destination !=null){
            destination.receiveMessageFromSource(message,source);
        }else{
            //throws exception
            source.getSourceUserOutput().writeLine(SOURCE_ERROR);
        }
        
    }
    
    
    
}
