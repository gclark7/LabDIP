/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab2.student.solution1;

import java.util.Scanner;

/**
 *
 * @author gcDataTechnology
 */
public class KeyboardInput implements UserInput{
    
    
    //using default constructors
    
    public final String readLine() {
            Scanner input = new Scanner(System.in);
            return input.nextLine();
	}
    
    
}
