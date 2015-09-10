import java.sql.SQLException;


/**
 * This program was written for 
 * University of Phoenix
 * @author Victor M. Beas, Daryn Herzberg
 */

// Main class
public class CharityApplication {
    /**
     * Creates an instance of CharityApplication Window and draws 
     * components and creates database
     * @param args 
     * @throws java.sql.SQLException 
     */
    public static void main(String[] args) throws SQLException {
        CreateCharityTable.createTable();
        CharityApplicationWindow window = new CharityApplicationWindow();
        
        
    }

}