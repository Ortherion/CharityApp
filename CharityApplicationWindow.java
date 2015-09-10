/**
 * This program was written for 
 * University of Phoenix
 * @author Victor M. Beas, Daryn Herzberg
 */

import javax.swing.JFrame;
import javax.swing.JPanel;

//Extended JFrame class that builds charity app GUI in a window
public class CharityApplicationWindow extends JFrame {

    static CharityApplicationPanel panel;
    private JPanel panelBuilder;
    
    public CharityApplicationWindow() {
        super("Charity Information Program");
        
        panel = new CharityApplicationPanel();
        
        this.buildCharityWindow();
    }
    
    private void buildCharityWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelBuilder = panel.createCharityAppPanel();
        add(panelBuilder);
        
        setSize(650, 350);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
