/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab3;



/**
 *
 * @author gcDataTechnology
 */
public class ConsoleOutput implements UserOutput{
    
    
    public final void writeLine( String line ) {
            
            System.out.println( line );
	}
    
}
