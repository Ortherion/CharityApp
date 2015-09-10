/**
 * This program was written for 
 * University of Phoenix
 * @author Victor M. Beas, Daryn Herzberg
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//An action listener class for the exit button to exit the application
public class ExitButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

}
