package ua.goit.java.startup.bom;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class Admin extends BaseUser implements UserDetails {


//    private String username;
//
//    private String password;
//
//    private String email;
//
//    private String contacts;
//
//    private UserRole role;
//
    private boolean isLocked;

    public Admin(boolean isLocked) {
        this.isLocked = isLocked;
    }

    //
//    private byte[] image;

//    public Admin() {
//        username = "";
//        password = "";
//        contacts = "";
//        role = UserRole.ADMIN;
//        image = new byte[0];
//    }

//    public Admin(String username, String password, String contacts, UserRole role) {
//        this();
//        setUsername(username);
//        setPassword(password);
//        setContacts(contacts);
//        setRole(role);
//    }

//    public String getUsername() {
//        return username;
//    }
public Admin() {

}

    @Override
    public boolean isAccountNonExpired() {
        return !isLocked;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !isLocked;
    }

    @Override
    public boolean isEnabled() {
        return !isLocked;
    }

//    public void setUsername(String username) {
//        this.username = isNotBlank(username) ? username : "";
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + getRole().name());
        grantedAuthorities.add(simpleGrantedAuthority);
        return grantedAuthorities;
    }

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = isNotBlank(password) ? password : "";
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = isNotBlank(email) ? email : "";
//    }
//
//    public String getContacts() {
//        return contacts;
//    }
//
//    public void setContacts(String contacts) {
//        this.contacts = isNotBlank(contacts) ? contacts : "";
//    }
//
//    public UserRole getRole() {
//        return role;
//    }
//
//    public void setRole(UserRole role) {
//        this.role = (role != null) ? role : UserRole.ADMIN;
//    }
//
//    public boolean isLocked() {
//        return isLocked;
//    }
//
//    public void setLocked(boolean locked) {
//        isLocked = locked;
//    }
//
//    public byte[] getImage() {
//        return image;
//    }
//
//    public void setImage(byte[] image) {
//        this.image = image;
//    }

//    @Override
//    public boolean equals(Object obj) {
//        return EqualsBuilder.reflectionEquals(this, obj);
//    }
//
//    @Override
//    public int hashCode() {
//        return HashCodeBuilder.reflectionHashCode(this);
//    }
//
//    @Override
//    public String toString() {
//        return ReflectionToStringBuilder.toString(this);
//    }
}
