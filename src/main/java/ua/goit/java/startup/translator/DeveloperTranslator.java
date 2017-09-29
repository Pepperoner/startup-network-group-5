package ua.goit.java.startup.translator;

import ua.goit.java.startup.bom.Developer;
import ua.goit.java.startup.dto.Model;
import ua.goit.java.startup.dto.UserDto;

/**
 * Created by Aleksandr on 29.09.2017.
 */
public class DeveloperTranslator {

    public void fromDTO(UserDto source, Developer destination){
        if (source == null){
            return;
        }
        Model modelSource = source;



    }
}
