/**
 * This program was written for 
 * University of Phoenix
 * @author Victor M. Beas, Daryn Herzberg
 */

import java.text.NumberFormat;

/** 
 * DonorInfo class defines class constructor, sets/gets data
 */ 
public class DonorInfo {
    private String donorFirstName;
    private String donorLastName;
    private String charityName;
    private String donorInfoString;
    private double donationAmount;
    private int charityIndex;
    
    public DonorInfo() {
        donorFirstName = new String();
        donorLastName = new String();
        charityName = new String();
        donationAmount = 0;
    }
    
    public void setDonorFirstName(String dFName) {
        this.donorFirstName = dFName;
    }
    
    public void setDonorLastName(String dLName) {
        this.donorLastName = dLName;
    }
    
    public void setCharityNameAndIndex(String cName, int cIndex) {
        this.charityName = cName;
        this.charityIndex = cIndex;
    }
    
    public void setDonationAmount(double dAmount) {
        this.donationAmount = dAmount;
    }
    
    public String getDonorFirstName() {
        return donorFirstName;
    }
    
    public String getDonorLastName() {
        return donorLastName;
    }
    
    public String getCharityName() {
        return charityName;
    }
    
    public int getCharityIndex() {
        return charityIndex;
    }
    
    public double getDonationAmount() {
        return donationAmount;
    }
    
    //Method creates a string containing all donor info
    public String getDonorInfoString() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        donorInfoString = "\n\tDonor Name: " + donorLastName + ", " + 
                donorFirstName + "\n\t" + "Charity Chosen: " + charityName + 
                "\n\t" + "Amount Donated: " + 
                currencyFormatter.format(donationAmount) + "\n";
        return donorInfoString;
    }
}

