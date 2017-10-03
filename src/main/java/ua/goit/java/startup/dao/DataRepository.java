package ua.goit.java.startup.dao;

import org.springframework.data.repository.CrudRepository;
import ua.goit.java.startup.dto.ModelDTO;

public interface DataRepository<T extends ModelDTO> extends CrudRepository<T, Long> {
}
