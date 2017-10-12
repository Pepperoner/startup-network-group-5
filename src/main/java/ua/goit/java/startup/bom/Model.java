package ua.goit.java.startup.bom;

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