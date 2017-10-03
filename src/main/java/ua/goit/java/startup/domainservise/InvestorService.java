package ua.goit.java.startup.domainservise;

import org.springframework.security.core.userdetails.UserDetailsService;
import ua.goit.java.startup.bom.Developer;
import ua.goit.java.startup.bom.Investor;


public interface InvestorService extends DataService<Investor>, UserDetailsService {
    Investor findByEmail(String email);
}