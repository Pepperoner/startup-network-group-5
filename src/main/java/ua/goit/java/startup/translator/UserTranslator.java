package ua.goit.java.startup.translator;

import org.springframework.stereotype.Component;
import ua.goit.java.startup.bom.User;
import ua.goit.java.startup.dto.UserDto;

@Component
public class UserTranslator {


    public void toDto(User source, UserDto destination) {
        if (source == null) {
            return;
        }

        //UserDto.setId(source.getId());
        destination.setUsername(source.getFirstName());
        destination.setLastName(source.getLastName());
        destination.setEmail(source.getEmail());
        destination.setRole(source.getRoleList());
        destination.setPassword(source.getPassword());
        //destination.setPassword(source.ge());
        //destination.setContacts(source.getContacts());
        //destination.setRole(source.getRole());
        //destination.setPaidcost(source.getPaidcost());
        //destination.setLocked(source.isLocked());
        //destination.setImage(source.getImage());
        //destination.setStartup(source.getStartupDto());

    }

    public void fromDto(UserDto source, User destination) {

        if (source == null) {
            return;
        }

        //UserDto.setId(source.getId());
        destination.setFirstName(source.getUsername());
        destination.setLastName(source.getLastName());
        destination.setEmail(source.getEmail());
        destination.setRoleList(source.getRole());
        destination.setPassword(source.getPassword());
    }
}
