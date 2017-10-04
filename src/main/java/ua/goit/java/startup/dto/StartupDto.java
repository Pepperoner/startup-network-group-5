package ua.goit.java.startup.dto;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Entity
@Table(name = "startups")
public class StartupDto extends ModelDTO {

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "cost", nullable = false)
    private long cost;
    @Column(name = "currentsum", nullable = false)
    private long currentsum;
    @Column(name = "image")
    private byte[] image;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "users_startups",
            joinColumns = @JoinColumn(name = "startup_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<UserDto> userDto = new HashSet<>();

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

    public Set<UserDto> getUserDto() {
        return userDto;
    }

    public void setUserDto(Set<UserDto> userDto) {
        this.userDto = userDto != null ? userDto : new HashSet<>();
    }

    public StartupDto() {}

    public StartupDto(String name, String description, long cost, long currentsum, byte[] image, Set<UserDto> userDto) {
        this();
        setName(name);
        setDescription(description);
        setCost(cost);
        setCurrentsum(currentsum);
        setImage(image);
        setUserDto(userDto);
    }

    @Override
    public String toString() {
        return "StartupDto{" + super.toString() + " " +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", currentsum=" + currentsum +
                ", image=" + Arrays.toString(image) +
                ", userDto=" + userDto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        StartupDto that = (StartupDto) o;

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
