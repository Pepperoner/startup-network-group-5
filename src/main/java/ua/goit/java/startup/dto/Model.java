package ua.goit.java.startup.dto;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Aleksandr on 29.09.2017.
 */
@MappedSuperclass
public abstract class Model implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {
        return (object != null) && (super.equals(object) || (getClass() == object.getClass()));
    }

    @Override
    public abstract int hashCode();

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                '}';
    }
}
