import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * This program was written for 
 * University of Phoenix
 * @author Victor M. Beas, Daryn Herzberg
 */

public class CreateCharityTable {
    
    public static void createTable() throws SQLException {
        final String DB_URL = "jdbc:derby:CharityDB;create=true";
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            
            Statement stmt = conn.createStatement();
            
            stmt.execute("CREATE TABLE DONORINFORMATION (FirstName CHAR(20), "
                    + "LastName CHAR(20), Charity CHAR(40), Amount DOUBLE)");
            
            
        } catch (SQLException exception) {
            System.out.println(exception);
            
        }
    }

}
