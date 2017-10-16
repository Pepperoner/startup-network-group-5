package ua.goit.java.startup.ui.form;

import ua.goit.java.startup.bom.Investor;
import ua.goit.java.startup.bom.Startup;
/*
An ancillary class for the investorPage and investMoney methods for the startup controllers
 */
public class InvestorStartupForm {
    private Investor investor;
    private Startup startup;
    private long paidCost;

    public long getPaidCost() {
        return paidCost;
    }

    public void setPaidCost(long paidCost) {
        this.paidCost = paidCost;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public Startup getStartup() {
        return startup;
    }

    public void setStartup(Startup startup) {
        this.startup = startup;
    }
}