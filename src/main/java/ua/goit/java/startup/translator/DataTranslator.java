package ua.goit.java.startup.translator;

import org.springframework.stereotype.Component;
import ua.goit.java.startup.bom.Model;
import ua.goit.java.startup.dto.ModelDTO;

import java.util.Set;

@Component
public class DataTranslator<T extends ModelDTO, V extends Model> {

    public void toDto(V source, T destination) { }
    public T toDto(V source) { return null;}

    public void fromDto(T source, V destination) { }
    public V fromDto(T source) { return null;}

    public Set<V> getListFromDto(Set<T> dtoSet){
        return null;
    }
}
