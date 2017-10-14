package ua.goit.java.startup.domainservice;

import org.springframework.security.core.userdetails.UserDetailsService;
import ua.goit.java.startup.bom.Investor;

public interface InvestorService extends DataService<Investor> {
    Investor findByEmail(String email);
}