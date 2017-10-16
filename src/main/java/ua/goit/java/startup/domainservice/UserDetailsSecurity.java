package ua.goit.java.startup.domainservice;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import ua.goit.java.startup.bom.UserRole;

import java.util.Collection;
/*
Security part for involving roles
 */
public class UserDetailsSecurity extends User{

    private UserRole userRole;

    public UserDetailsSecurity(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}