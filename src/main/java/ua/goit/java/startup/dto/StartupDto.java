package ua.goit.java.startup.dto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Aleksandr on 28.09.2017.
 */
public class StartupDto extends Model {

    private String name;

    private String description;

    private long cost;

    private long currentsum;

    private byte[] image;

    Set<UserDto> userDto;

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

    public StartupDto() {
        this.name = "";
        this.description = "";
        this.cost = 0;
        this.currentsum = 0;
        this.image = new byte[0];
        this.userDto = new HashSet<>();
    }

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
