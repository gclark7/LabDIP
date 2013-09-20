/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab3;

/**
 *
 * @author gcDataTechnology
 */
public interface MessageHandlerTemplate {
     public abstract void deliverMessageToDesination(Message message,  MessageSource source,MessageDestination destination);
     public abstract void enrollDevice(Device device);
}
