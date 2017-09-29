package ua.goit.java.startup.bom;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public abstract class Model {

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
        return "ModelDTO{" +
                "id=" + id +
                '}';
    }
}
