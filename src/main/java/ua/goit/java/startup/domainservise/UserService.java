package ua.goit.java.startup.domainservise;


import org.springframework.security.core.userdetails.UserDetailsService;
import ua.goit.java.startup.bom.User;


public interface UserService extends DataService<User>, UserDetailsService {
    User findByEmail(String email);
}
