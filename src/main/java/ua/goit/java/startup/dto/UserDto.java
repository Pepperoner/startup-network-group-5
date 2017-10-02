package ua.goit.java.startup.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.goit.java.startup.bom.UserRole;

import javax.persistence.*;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Entity
@Table(name = "user")
public class UserDto extends ModelDTO implements UserDetails {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "contacts")
    private String contacts;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private UserRole role;

    @Column(name = "paidcost")
    private long paidcost;
    @Column(name = "locked")
    private boolean isLocked;

    @Column(name = "image")
    private byte[] image;

    @ManyToMany/*(cascade = CascadeType.ALL)*/(mappedBy = "userDto")
    /*@JoinTable(name = "users_startups",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "startup_id"))*/

    private Set<StartupDto> startupDto = new HashSet<>();

    public UserDto() {
        /*username = "";
        password = "";
        contacts = "";
        role = UserRole.INVESTOR;
        paidcost = 0;
        startupDto = new HashSet<>();
        image = new byte[0];*/
    }

    public UserDto(String username, String password, String contacts, UserRole role, long paidcost) {
        this();
        setUsername(username);
        setPassword(password);
        setContacts(contacts);
        setRole(role);
        setPaidcost(paidcost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        UserDto userDto = (UserDto) o;

        if (paidcost != userDto.paidcost) return false;
        if (!username.equals(userDto.username)) return false;
        if (!password.equals(userDto.password)) return false;
        if (!contacts.equals(userDto.contacts)) return false;
        return role == userDto.role;
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + contacts.hashCode();
        result = 31 * result + role.hashCode();
        result = 31 * result + (int) (paidcost ^ (paidcost >>> 32));
        return result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = isNotBlank(username) ? username : "";
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
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
        this.email = email;
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
        this.role = (role != null) ? role : UserRole.INVESTOR;
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

    public Set<StartupDto> getStartupDto() {
        return startupDto;
    }

    public void setStartupDto(Set<StartupDto> startupDto) {
        this.startupDto = startupDto != null ? startupDto : new HashSet<>();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + getRole().name());
        grantedAuthorities.add(simpleGrantedAuthority);
        return grantedAuthorities;
    }

    @Override
    public String toString() {
        return "UserDto{" + super.toString() + " " +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", contacts='" + contacts + '\'' +
                ", role=" + role +
                ", paidcost=" + paidcost +
                ", isLocked=" + isLocked +
                ", image=" + Arrays.toString(image) +
                //", startupDto=" + startupDto +
                '}';
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
}
