package ua.goit.java.startup.bom;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class Admin extends Model implements UserDetails {

    private String username;

    private String password;

    private String email;

    private String contacts;

    private UserRole role;

    private long paidcost;

    private boolean isLocked;

    private byte[] image;

    Set<Startup> startup;

    public Admin() {
        username = "";
        password = "";
        contacts = "";
        role = UserRole.ADMIN;
        paidcost = 0;
        startup = new HashSet<>();
        image = new byte[0];
    }

    public Admin(String username, String password, String contacts, UserRole role, long paidcost) {
        this();
        setUsername(username);
        setPassword(password);
        setContacts(contacts);
        setRole(role);
        setPaidcost(paidcost);
    }

    public String getUsername() {
        return username;
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

    public void setUsername(String username) {
        this.username = isNotBlank(username) ? username : "";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + getRole().name());
        grantedAuthorities.add(simpleGrantedAuthority);
        return grantedAuthorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = isNotBlank(password) ? password : "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = isNotBlank(email) ? email : "";
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = isNotBlank(contacts) ? contacts : "";
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = (role != null) ? role : UserRole.ADMIN;
    }

    public long getPaidcost() {
        return paidcost;
    }

    public void setPaidcost(long paidcost) {
        this.paidcost = paidcost > 0 ? paidcost : 0;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Set<Startup> getStartup() {
        return startup;
    }

    public void setStartup(Set<Startup> startup) {

        this.startup = startup != null ? startup : new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Admin admin = (Admin) o;

        if (paidcost != admin.paidcost) return false;
        if (!username.equals(admin.username)) return false;
        if (!password.equals(admin.password)) return false;
        if (!email.equals(admin.email)) return false;
        if (!contacts.equals(admin.contacts)) return false;
        return role == admin.role;
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + contacts.hashCode();
        result = 31 * result + role.hashCode();
        result = 31 * result + (int) (paidcost ^ (paidcost >>> 32));
        return result;
    }
}
