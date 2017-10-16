package ua.goit.java.startup.bom;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/*
A BOM class for Investor content
 */
public class Investor extends BaseUser implements UserDetails {

    private long paidCost;
    private boolean isLocked;
    private Set<Startup> startup = new HashSet<>();

    public Investor(){}

    public Investor(long paidCost, boolean isLocked, Set<Startup> startup) {
        this.paidCost = paidCost;
        this.isLocked = isLocked;
        this.startup = startup;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + getRole().name());
        grantedAuthorities.add(simpleGrantedAuthority);
        return grantedAuthorities;
    }

    public void addMoneyToInvestor(long sum) {
        this.paidCost += sum;
    }

    public long getPaidCost() {
        return paidCost;
    }

    public void setPaidCost(long paidCost) {
        this.paidCost = paidCost > 0 ? paidCost : 0;
    }

    public Set<Startup> getStartup() {
        return startup;
    }

    public void setStartup(Set<Startup> startup) {

        this.startup = startup != null ? startup : new HashSet<>();
    }
}