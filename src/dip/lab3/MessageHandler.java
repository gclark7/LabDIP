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
    
   //takes the destination and runs the checks
    //delivers the message
    @Override
    public void deliverMessageToDesination(Message message, MessageDestination destination){
        //perform type check
        if(message!=null && destination !=null){
            destination.receiveMessageFromSource(message);
        }else{
            //throws exception
        }
        
    }
}
