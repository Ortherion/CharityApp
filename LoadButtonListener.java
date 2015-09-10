/**
 * This program was written for 
 * University of Phoenix
 * @author Victor M. Beas, Daryn Herzberg
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextArea;

//Appends data from database to JTextArea when load button is clicked
class LoadButtonListener implements ActionListener {
    CharityApplicationPanel mainPanel = CharityApplicationWindow.panel;
    JTextArea displayInfo = mainPanel.getDisplayInfo();
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            updateDisplayArea();
        }
        catch (SQLException ex) {
            System.out.println(ex);          
        } 
    }
    
    //Connects to database, loops thru data and appends to JTextArea
    private void updateDisplayArea() throws SQLException {
        
        final String DB_URL = "jdbc:derby:CharityDB";
        Statement stmt = null;
        String sqlUpdate = "SELECT * FROM DONORINFORMATION";
        
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sqlUpdate);
            while (result.next()) {
                displayInfo.append("\n\t" + result.getString("FirstName") + 
                        result.getString("LastName") +
                        result.getString("Charity") +
                        result.getDouble("Amount") + "\n");
            }
            
        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            if (stmt != null) {stmt.close();}
        }
    }

}


            
            
            
            
            
            

