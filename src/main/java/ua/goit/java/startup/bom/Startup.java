package ua.goit.java.startup.bom;

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

    //TODO: All fields in BOM should be private.
    Set<Developer> developer;
    Set<Investor> investor;

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
    public String toString() {
        return "StartupDto{" + super.toString() + " " +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", currentsum=" + currentsum +
                ", image=" + Arrays.toString(image) +
                ", developer=" + developer +
                ", investor=" + investor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Startup that = (Startup) o;

        if (cost != that.cost) return false;
        if (currentsum != that.currentsum) return false;
        if (!name.equals(that.name)) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (int) (cost ^ (cost >>> 32));
        result = 31 * result + (int) (currentsum ^ (currentsum >>> 32));
        return result;
    }
}
