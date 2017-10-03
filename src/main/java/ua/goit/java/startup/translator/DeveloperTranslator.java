package ua.goit.java.startup.translator;

import org.springframework.stereotype.Component;
import ua.goit.java.startup.bom.*;
import ua.goit.java.startup.dto.UserDto;


@Component
public class DeveloperTranslator extends DataTranslator<UserDto, Developer>  {

    @Override
    public void toDto(Developer source, UserDto destination) {
        if (source == null) {
            return;
        }

        source.setId(destination.getId());
        source.setUsername(destination.getUsername());
        source.setPassword(destination.getPassword());
        source.setContacts(destination.getContacts());
        source.setRole(destination.getRole());
        source.setPaidcost(destination.getPaidcost());
        source.setLocked(destination.isLocked());
        source.setImage(destination.getImage());
        //source.setStartup(destination.getStartupDto());



//        destination.setUsername(source.getFirstName());
//        //destination.setLastName(source.getLastName());
//        destination.setEmail(source.getEmail());
//        destination.setRole(source.getRoleList());
//        destination.setPassword(source.getPassword());
    }

    @Override
    public UserDto toDto(Developer source) {
        UserDto destination = new UserDto();
        toDto(source, destination);
        return destination;
    }


    @Override
    public void fromDto(UserDto source, Developer destination) {
        destination.setId(source.getId());
        destination.setUsername(source.getUsername());
        destination.setPassword(source.getPassword());
        destination.setContacts(source.getContacts());
        destination.setRole(source.getRole());
        destination.setPaidcost(source.getPaidcost());
        destination.setLocked(source.isLocked());
        destination.setImage(source.getImage());
        //destination.setStartup(source.getStartupDto());

    }



    @Override
    public Developer fromDto(UserDto source) {
        Developer destination = new Developer();
        fromDto(source, destination);
        return destination;
    }


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


}

