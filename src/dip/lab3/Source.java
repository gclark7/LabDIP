/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab3;

/**
 *
 * @author gcDataTechnology
 */
public interface Source {
    
    //public abstract void provideMessageToDevice();
    public abstract void createMessage(MessageType type);
    public abstract Message getMessage();
    public abstract void sendMessageToDestination(Message message, Destination destination);
    
}
