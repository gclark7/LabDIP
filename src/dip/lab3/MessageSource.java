/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab3;

/**
 *
 * @author gcDataTechnology
 */
public interface MessageSource {
    
    //public abstract void provideMessageToDevice();
    public abstract void createMessage(MessageType type);
    public abstract Message getMessage();
    public abstract void sendMessageToDestination(Message message, MessageDestination destination);
    
}
