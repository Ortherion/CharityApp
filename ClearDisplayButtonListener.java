/**
 * This program was written for 
 * University of Phoenix
 * @author Victor M. Beas, Daryn Herzberg
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

//Clears entries from the display area text
class ClearDisplayButtonListener implements ActionListener{
    CharityApplicationPanel mainPanel = CharityApplicationWindow.panel;
    JTextArea displayInfo = mainPanel.getDisplayInfo();
    String displayText = "\tFirst Name\tLast Name\tCharity\tAmount\n";
    
    @Override
    public void actionPerformed(ActionEvent e) {
        resetDisplay();
    }
    
    private void resetDisplay() {
        displayInfo.setText(displayText);
    }

}
