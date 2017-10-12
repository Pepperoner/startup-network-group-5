package ua.goit.java.startup.bom;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.goit.java.startup.dto.UserDto;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class Developer extends BaseUser implements UserDetails {

//    private String username;
//
//    private String password;
//
//    private String email;
//
//    private String contacts;
//
//    private UserRole role;

    private boolean isLocked;

//    private byte[] image;

    private Set<Startup> startup = new HashSet<>();

    public Developer(boolean isLocked, Set<Startup> startup) {
        this.isLocked = isLocked;
        this.startup = startup;
    }

    public Developer() {
    }

    //    public Developer() {}
//
//    public Developer(String username, String password, String contacts, UserRole role) {
//        this();
//        setUsername(username);
//        setPassword(password);
//        setContacts(contacts);
//        setRole(role);
//    }

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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + getRole().name());
        grantedAuthorities.add(simpleGrantedAuthority);
        return grantedAuthorities;
    }

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = isNotBlank(username) ? username : "";
//    }
//
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
////
//    public void setRole(UserRole role) {
//        this.role = (role != null) ? role : UserRole.DEVELOPER;
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

    public Set<Startup> getStartup() {
        return startup;
    }

    public void setStartup(Set<Startup> startup) {
        this.startup = startup != null ? startup : new HashSet<>();
    }

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
