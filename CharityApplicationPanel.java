/**
 * This program was written for 
 * University of Phoenix
 * @author Victor M. Beas, Daryn Herzberg
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/** 
 * Extended JPanel class loads a panel with components and adds it to main JFrame
 * @author Victor M. Beas 
 */
public class CharityApplicationPanel extends JPanel {
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel charityLabel;
    private JLabel amountLabel;
    
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField amountField;
    
    private JComboBox charityComboBox;
    
    static JTextArea charityDisplayArea;
    
    private JButton saveButton;
    private JButton clearButton;
    private JButton exitButton;
    private JButton loadButton;
    private JButton clearDisplayButton;
    
    private JPanel infoPanel;
    private JPanel buttonPanel;
    private JPanel displayPanel;
    
    private JScrollPane scrollPane;
    
    private static final String[] charityChoices = 
    { "Select Charity", "United Way", "Child's Play", "Operation Supply Drop",
      "Gamers Outreach", "St. Jude", "Salvation Army", "American National Red Cross",
      "Goodwill Industries International", "YMCA", "American Cancer Society"};
    
    /**
     * Class constructor instantiates private variables and defines their
     * parameters
     */
    public CharityApplicationPanel() {
        firstNameLabel = new JLabel("First Name: ");
        lastNameLabel = new JLabel("Last Name: ");
        charityLabel = new JLabel("Charity: ");
        amountLabel = new JLabel("Amount: ");
        
        // Initializes and sets size of fields
        firstNameField = new JTextField("", 20);
        lastNameField = new JTextField("", 20);
        amountField = new JTextField("", 20);
        firstNameField.setMinimumSize(new Dimension(150, 25));
        lastNameField.setMinimumSize(new Dimension(150, 25));
        amountField.setMinimumSize(new Dimension(150, 25));
        
        // Initializes and populates the Combo Box
        charityComboBox = new JComboBox(charityChoices);
        charityComboBox.setMaximumRowCount(4);
        
        // Creates panels
        infoPanel = new JPanel(new GridBagLayout());
        buttonPanel = new JPanel(new GridBagLayout());
        displayPanel = new JPanel();
        
        // Creates buttons
        saveButton = new JButton("Save");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");
        loadButton = new JButton("Load");
        clearDisplayButton = new JButton("Clear Display");
        
        // Creates Text Area for output
        String displayText = "\tFirst Name\tLast Name\tCharity\tAmount\n";
        charityDisplayArea = new JTextArea(displayText);
        scrollPane = new JScrollPane(charityDisplayArea, JScrollPane.
                VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 175));
        charityDisplayArea.setEditable(false);
    }
    
    public JPanel createCharityAppPanel() {
        // Borderlayout will be used for parent panel
        setLayout(new BorderLayout());
        
        // Adds panels and draws layout and text fields to info panel
        GridBagConstraints gbcInfo = new GridBagConstraints();
        gbcInfo.insets = new Insets(5, 0, 5, 10);
        
        gbcInfo.gridx = 0;
        gbcInfo.gridy = 0;
        infoPanel.add(firstNameLabel, gbcInfo);
        gbcInfo.gridx = 1;
        gbcInfo.gridy = 0;
        infoPanel.add(firstNameField, gbcInfo);
        gbcInfo.gridx = 2;
        gbcInfo.gridy = 0;
        infoPanel.add(lastNameLabel, gbcInfo);
        gbcInfo.gridx = 3;
        gbcInfo.gridy = 0;
        infoPanel.add(lastNameField, gbcInfo);
        gbcInfo.gridx = 0;
        gbcInfo.gridy = 1;
        infoPanel.add(charityLabel, gbcInfo);
        gbcInfo.gridx = 1;
        gbcInfo.gridy = 1;
        infoPanel.add(charityComboBox, gbcInfo);
        gbcInfo.gridx = 2;
        gbcInfo.gridy = 1;
        infoPanel.add(amountLabel, gbcInfo);
        gbcInfo.gridx = 3;
        gbcInfo.gridy = 1;
        infoPanel.add(amountField, gbcInfo);
        
        add(infoPanel, BorderLayout.NORTH);
        
        // Adds buttons to button panel
        GridBagConstraints gbcButtons = new GridBagConstraints();
        JPanel topButtons = new JPanel(new FlowLayout(0, 0, 0));
        JPanel bottomButtons = new JPanel(new FlowLayout(0, 0, 0));
        Dimension buttonSize = new Dimension(125,25);
        
        topButtons.add(saveButton);
        saveButton.addActionListener(new SaveButtonListener());
        saveButton.setPreferredSize(buttonSize);
        topButtons.add(loadButton);
        loadButton.addActionListener(new LoadButtonListener());
        loadButton.setPreferredSize(buttonSize);
        bottomButtons.add(clearButton);
        clearButton.addActionListener(new ClearButtonListener());
        clearButton.setPreferredSize(buttonSize);
        bottomButtons.add(clearDisplayButton);
        clearDisplayButton.addActionListener(new ClearDisplayButtonListener());
        clearDisplayButton.setPreferredSize(buttonSize);
        bottomButtons.add(exitButton);
        exitButton.addActionListener(new ExitButtonListener());
        exitButton.setPreferredSize(buttonSize);
        
        gbcButtons.gridx = 0;
        gbcButtons.gridy = 0;
        buttonPanel.add(topButtons, gbcButtons);
        gbcButtons.gridx = 0;
        gbcButtons.gridy = 1;
        buttonPanel.add(bottomButtons, gbcButtons);
        
        add(buttonPanel, BorderLayout.CENTER);
        
        // Adds JTextArea to panel
        charityDisplayArea.setLineWrap(true);
        
        add(scrollPane, BorderLayout.SOUTH);
        
        return (this);
    }
    
    public JTextField getFirstName() {
        return firstNameField;
    }
    
    public JTextField getLastName() {
        return lastNameField;
    }
    
    public JTextField getAmount() {
        return amountField;
    }
    
    public JComboBox getCharityBox() {
        return charityComboBox;
    }
    
    public String getCharityItem() {
        return (String) charityComboBox.getSelectedItem();
    }

    public int getCharityIndex() {
        return charityComboBox.getSelectedIndex();
    }
    
    public JTextArea getDisplayInfo() {
        return charityDisplayArea;
    }
}
