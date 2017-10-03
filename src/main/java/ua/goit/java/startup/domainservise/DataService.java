package ua.goit.java.startup.domainservise;

import ua.goit.java.startup.bom.Model;
import ua.goit.java.startup.dto.ModelDTO;
import java.util.Collection;

public interface DataService<T> {

    T add(T t);

    Collection<T> addAll(Collection<T> collection);

    T update(T t);

    Collection<T> updateAll(Collection<T> collection);

    T get(long id);

    Collection<T> getAll();

    void remove(long id);

    void remove(T t);

    void remove(Collection<T> collection);

    void removeAll();

    boolean exist(long id);

    boolean exist(T t);
}
