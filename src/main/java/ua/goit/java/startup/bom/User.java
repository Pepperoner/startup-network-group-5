package ua.goit.java.startup.bom;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class User extends Model implements UserDetails {

    private int id;

    private String firstName;

    private String email;

    private UserRole roleList;

    private String password;

    public User() {}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRoleList() {
        return roleList;
    }

    public void setRoleList(UserRole roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {

        return String.format("UserDTO{id=%d, firstName='%s', email='%s', roleList=[%s]}",
                id,
                firstName,
                email,
                roleList
        );
    }
}
