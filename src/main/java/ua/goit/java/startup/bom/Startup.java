package ua.goit.java.startup.bom;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import ua.goit.java.startup.dto.StartupDto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class Startup extends Model {

    private String name;

    private String description;

    private long cost;

    private long currentsum;

    private byte[] image;

    private Set<Developer> developer;
    private Set<Investor> investor;

    public Startup() {
        this.name = "";
        this.description = "";
        this.cost = 0;
        this.currentsum = 0;
        this.image = new byte[0];
        this.developer = new HashSet<>();
        this.investor = new HashSet<>();
    }

    public Startup(String name, String description, long cost, long currentsum, byte[] image, Set<Developer> developer, Set<Investor> investor) {
        this();
        setName(name);
        setDescription(description);
        setCost(cost);
        setCurrentsum(currentsum);
        setImage(image);
        setDeveloper(developer);
        setInvestor(investor);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = isNotBlank(name) ? name : "";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = isNotBlank(description) ? description : description;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost > 0 ? cost : 0;
    }

    public long getCurrentsum() {
        return currentsum;
    }

    public void setCurrentsum(long currentsum) {
        this.currentsum = currentsum > 0 ? currentsum : 0;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Set<Developer> getDeveloper() {
        return developer;
    }

    public void setDeveloper(Set<Developer> developer) {
        this.developer = developer != null ? developer : new HashSet<>();
    }

    public Set<Investor> getInvestor() {
        return investor;
    }

    public void setInvestor(Set<Investor> investor) {
        this.investor = investor != null ? investor : new HashSet<>();
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
