/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab3;

/**
 *
 * @author gcDataTechnology
 */
public class MessageHandler {
    
   //takes the destination and runs the checks
    //delivers the message
    
    public void deliverMessageToDesination(Message message, Destination destination){
        //perform type check
        
            destination.receiveMessageFromSource(message);
        
    }
}
