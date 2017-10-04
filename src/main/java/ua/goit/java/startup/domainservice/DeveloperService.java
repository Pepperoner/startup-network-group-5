package ua.goit.java.startup.domainservice;

import org.springframework.security.core.userdetails.UserDetailsService;
import ua.goit.java.startup.bom.Developer;

public interface DeveloperService extends DataService<Developer>, UserDetailsService {
    Developer findByEmail(String email);
}