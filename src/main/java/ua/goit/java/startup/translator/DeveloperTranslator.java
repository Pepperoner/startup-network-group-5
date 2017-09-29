package ua.goit.java.startup.translator;

import ua.goit.java.startup.bom.Developer;
import ua.goit.java.startup.bom.Model;
import ua.goit.java.startup.dto.ModelDTO;
import ua.goit.java.startup.dto.UserDto;

/**
 * Created by Aleksandr on 29.09.2017.
 */
public class DeveloperTranslator {

    public void fromDTO(UserDto source, Developer destination){
        if (source == null){
            return;
        }
        ModelDTO modelDTOSource = source;
        Model modelDesination = destination;
        destination.setId(source.getId());
        destination.


    }
}
