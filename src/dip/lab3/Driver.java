/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab3;

/**
 *
 * @author gcDataTechnology
 */
public class Driver {
    
    
    public static void main(String[] args) {
        
        //2 ways to output message
        //As much code portable and flexible
        //High & Low Level Classes
        
        //Simulates the Cloud or Server or External activity
        //demonstrating the use of arrays as well as Liskov Substitution Principle
        int EXPANDARRAY=1;
        int STARTING_INDEX=0;
        Device[] tempDevices;//to expand enrollment
        Device[] userDevices= new Device[0];//real enrollment
        //to define device message compatibility
        MessageType[] msgTypes={MessageType.TEXT,MessageType.VIDEO,MessageType.AUDIO,MessageType.PICTURE,MessageType.MIXEDMEDIA};
        
        
        
        //waits for a user to enroll and begin messaging
        
        //new enrollment requsted & approved
        //Device 0
        tempDevices  = new Device[userDevices.length+EXPANDARRAY];
        System.arraycopy(userDevices, STARTING_INDEX, tempDevices, STARTING_INDEX, userDevices.length);   
        
        tempDevices[userDevices.length]= new LaptopDevice(msgTypes);
        userDevices=tempDevices;
        
         //Device 1
        tempDevices  = new Device[userDevices.length+EXPANDARRAY];
        System.arraycopy(userDevices, STARTING_INDEX, tempDevices, STARTING_INDEX, userDevices.length);     
        tempDevices[userDevices.length]= new LaptopDevice(msgTypes);
        userDevices=tempDevices;
        
        
        //************************************//High Level Class//******************************************//
        
        //message handler envoked by a user Device
        int INDEX=0;
        Device d1=userDevices[0];
        Device d2=userDevices[1];
        
        //simulates user & drop down box selectin of messages available...If I have enough time I would modify to pass an input & output class
        d1.createMessage(d2.getCompatibleMessageTypes()[INDEX]);
        d1.sendMessageToDestination(d1.getMessage(),d2);
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
}