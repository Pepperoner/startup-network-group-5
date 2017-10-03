package ua.goit.java.startup.translator;

import org.springframework.stereotype.Component;
import ua.goit.java.startup.bom.User;
import ua.goit.java.startup.dto.UserDto;

@Component
public class UserTranslator extends DataTranslator<UserDto, User> {


    @Override
    public void toDto(User source, UserDto destination) {
        if (source == null) {
            return;
        }
        destination.setUsername(source.getFirstName());
        //destination.setLastName(source.getLastName());
        destination.setEmail(source.getEmail());
        destination.setRole(source.getRoleList());
        destination.setPassword(source.getPassword());
    }

    @Override
    public UserDto toDto(User source) {
        UserDto destination = new UserDto();
        toDto(source, destination);
        return destination;
    }


    @Override
    public void fromDto(UserDto source, User destination) {
        destination.setFirstName(source.getUsername());
        //destination.setLastName(source.getLastName());
        destination.setEmail(source.getEmail());
        destination.setRoleList(source.getRole());
        destination.setPassword(source.getPassword());
    }



    @Override
    public User fromDto(UserDto source) {
        User destination = new User();
        fromDto(source, destination);
        return destination;
    }


}
