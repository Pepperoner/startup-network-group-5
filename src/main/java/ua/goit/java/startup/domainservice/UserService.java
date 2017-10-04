package ua.goit.java.startup.domainservice;

import org.springframework.security.core.userdetails.UserDetailsService;
import ua.goit.java.startup.bom.User;

public interface UserService extends DataService<User>, UserDetailsService {
    User findByEmail(String email);
}
