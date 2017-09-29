package ua.goit.java.startup.bom;

import java.util.Set;

/**
 * Created by Aleksandr on 29.09.2017.
 */
public class Developer {

    private String username;

    private String password;

    private String contacts;

    private UserRole role;

    private long paidcost;

    private boolean isLocked;

    private byte[] image;

    Set<Startup> startup;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public long getPaidcost() {
        return paidcost;
    }

    public void setPaidcost(long paidcost) {
        this.paidcost = paidcost;
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
        this.startup = startup;
    }
}
