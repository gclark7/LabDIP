/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab3;

/**
 *
 * @author gcDataTechnology
 */
public interface MessageDestination {
    public abstract MessageType[] getCompatibleMessageTypes();
    public abstract void setCompatibleMessageTypes(MessageType[] types);
    public abstract void receiveMessageFromSource(Message message, MessageSource source);
    public abstract void useMessage(Message message);
    public abstract DeviceType getDeviceType();
    public abstract void replyToSource(MessageSource source, String line);
    
    
}
