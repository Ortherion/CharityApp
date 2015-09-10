/**
 * This program was written for 
 * University of Phoenix
 * @author Victor M. Beas, Daryn Herzberg
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//ActionListener saves user input to data file when save button is clicked
public class SaveButtonListener implements ActionListener {
    //Instantiate View and Model
    CharityApplicationPanel mainPanel = CharityApplicationWindow.panel;
    DonorInfo donorInfo = new DonorInfo();

    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    
    
    @Override
    //Send user inputs as arguments to DonorInfo methods
    public void actionPerformed(ActionEvent e) {
        
        donorInfo.setDonorFirstName(mainPanel.getFirstName().getText());
        donorInfo.setDonorLastName(mainPanel.getLastName().getText());
        donorInfo.setCharityNameAndIndex(mainPanel.getCharityItem(), 
                mainPanel.getCharityIndex());
        
        if (donorInfo.getDonorFirstName().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter donor's first "
                    + "name.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (donorInfo.getDonorLastName().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter donor's last "
                        + "name.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if(donorInfo.getCharityIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Please select a "
                            + "charity.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        donorInfo.setDonationAmount(Double.parseDouble
                                (mainPanel.getAmount().getText()));
                        
                        saveDonorInformation();
                        
                    } catch (NumberFormatException numError) {
                        JOptionPane.showMessageDialog(null, "Please enter a "
                                + "numeric amount for donation.", "Error", 
                                JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        Logger.getLogger(SaveButtonListener.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    // Save donor information to CharityDB
    private void saveDonorInformation() throws SQLException {
        final String DB_URL = "jdbc:derby:CharityDB";
        
        // Connecting to database
        Connection conn = DriverManager.getConnection(DB_URL);
        
        // Get a statement object
        Statement stmt = conn.createStatement();
        
        // Insert rows to Charity DB
        String sqlUpdate = "INSERT INTO DONORINFORMATION VALUES" + "(?, ?, ?, ?)";
        
        // Prepared statement allows for safer insertion
        PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
        pstmt.setString(1, donorInfo.getDonorFirstName());
        pstmt.setString(2, donorInfo.getDonorLastName());
        pstmt.setString(3, donorInfo.getCharityName());
        pstmt.setDouble(4, donorInfo.getDonationAmount());
        pstmt.executeUpdate();
        
        // Closes Statement
        stmt.close();
        
    }

}
