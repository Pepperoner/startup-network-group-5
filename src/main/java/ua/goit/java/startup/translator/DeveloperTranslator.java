package ua.goit.java.startup.translator;

import ua.goit.java.startup.bom.*;
//import ua.goit.java.startup.dto.ModelDTO;
import ua.goit.java.startup.dto.UserDto;

import java.util.HashSet;
import java.util.Set;


public class DeveloperTranslator {

//    public void fromDTO(UserDto source, Model destination) {
//        if (source == null) {
//            return;
//        }
//        if (source.getRole().equals(UserRole.DEVELOPER)) {
//            Developer developerDestination = (Developer) destination;
//            developerDestination.setId(source.getId());
//            developerDestination.setUsername(source.getUsername());
//            developerDestination.setPassword(source.getPassword());
//            developerDestination.setContacts(source.getContacts());
//            developerDestination.setRole(source.getRole());
//            developerDestination.setPaidcost(source.getPaidcost());
//            developerDestination.setLocked(source.isLocked());
//            developerDestination.setImage(source.getImage());
//            developerDestination.setStartup(source.getStartupDto());
//        }
//    }

    public void toDto(User source, UserDto destination) {
        if (source == null) {
            return;
        }

    }

    public void fromDto(UserDto source, User destination) {


    }
}

