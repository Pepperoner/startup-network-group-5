package ua.goit.java.startup.domainservise;

//import com.dimas.entity.enums.UserRoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
//import com.dimas.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.goit.java.startup.bom.User;
import ua.goit.java.startup.bom.UserRole;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    /*
    public UserDetailsServiceImpl() {
        this.userService = new UserServiceImpl();
    }*/


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //User user = userService.getUser("login");
        User user = userService.findByEmail(email);
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(user.getRoleList().name()));

        UserDetailsSecurity userSecurity = new UserDetailsSecurity(email,user.getPassword(),roles);
        userSecurity.setUserRole(user.getRoleList());

        return userSecurity;
        //return new org.springframework.security.core.userdetails.User(email,user.getPassword(),roles);
    }
}
