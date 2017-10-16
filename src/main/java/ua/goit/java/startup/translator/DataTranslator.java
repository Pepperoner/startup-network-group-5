package ua.goit.java.startup.translator;

import org.springframework.stereotype.Component;
import ua.goit.java.startup.bom.Model;
import ua.goit.java.startup.dto.ModelDTO;

import java.util.Set;
/*
A class for transfer entities(BOMs) from/to DataBase
 */
@Component
public abstract class DataTranslator<T extends ModelDTO, V extends Model> {

    public abstract void toDto(V source, T destination);

    public abstract T toDto(V source);

    public abstract void fromDto(T source, V destination);

    public abstract V fromDto(T source);

    public abstract Set<V> getListFromDto(Set<T> dtoSet);
}