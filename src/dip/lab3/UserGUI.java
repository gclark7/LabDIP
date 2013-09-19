/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab3;

import javax.swing.*;

/**
 *
 * @author gcDataTechnology
 */
public class UserGUI implements UserOutput, UserInput{
    
    @Override
    public final void writeLine(String line) {
       JOptionPane.showMessageDialog(null,line);

    }
    
    @Override
   public final void readLine(String line){
        JOptionPane.showInputDialog(null, line);
    }
    
}
