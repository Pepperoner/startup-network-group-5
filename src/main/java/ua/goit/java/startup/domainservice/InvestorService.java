package ua.goit.java.startup.domainservice;

import ua.goit.java.startup.bom.Investor;
/*
A main method for Investor's side
 */
public interface InvestorService extends DataService<Investor> {
    Investor findByEmail(String email);
}