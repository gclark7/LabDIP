/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab3;

/**
 *
 * @author gcDataTechnology
 */
public interface Destination {
    public abstract MessageType[] getCompatibleMessageTypes();
    public abstract void setCompatibleMessageTypes(MessageType[] types);
    public abstract void receiveMessageFromSource(Message message);
    public abstract void useMessage(Message message);
    
}
