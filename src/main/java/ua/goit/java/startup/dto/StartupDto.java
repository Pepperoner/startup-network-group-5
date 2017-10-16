package ua.goit.java.startup.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
/*
A (Data Transfer Object) class for Startups that will be connect the entity(BOM) and the database
 */
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
    private long currentSum;
    @Column(name = "image")
    private byte[] image;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
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

    public long getCurrentSum() {
        return currentSum;
    }

    public void setCurrentSum(long currentSum) {
        this.currentSum = currentSum > 0 ? currentSum : 0;
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
    }

    public StartupDto(String name, String description, long cost, long currentSum, byte[] image, Set<UserDto> userDto) {
        this();
        setName(name);
        setDescription(description);
        setCost(cost);
        setCurrentSum(currentSum);
        setImage(image);
        setUserDto(userDto);
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