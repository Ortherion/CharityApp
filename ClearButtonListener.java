/**
 * This program was written for 
 * University of Phoenix
 * @author Victor M. Beas, Daryn Herzberg
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;

//ActionListener clears TextFields and ComboBox when clear button is clicked
class ClearButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        CharityApplicationPanel mainPanel = CharityApplicationWindow.panel;
        
        JTextField fName = mainPanel.getFirstName();
        JTextField lName = mainPanel.getLastName();
        JTextField amount = mainPanel.getAmount();
        JComboBox charityChoice = mainPanel.getCharityBox();
        
        fName.setText("");
        lName.setText("");
        amount.setText("");
        charityChoice.setSelectedIndex(0);
    }

}
