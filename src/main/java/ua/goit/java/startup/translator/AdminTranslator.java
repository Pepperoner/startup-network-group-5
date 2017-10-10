package ua.goit.java.startup.translator;

import org.springframework.stereotype.Component;
import ua.goit.java.startup.bom.Admin;
import ua.goit.java.startup.dto.UserDto;

import java.util.HashSet;
import java.util.Set;

@Component
public class AdminTranslator extends DataTranslator<UserDto, Admin> {

    @Override
    public void fromDto(UserDto source, Admin destination) {
        if (source == null) {
            return;
        }
        destination.setId(source.getId());
        destination.setUsername(source.getUsername());
        destination.setPassword(source.getPassword());
        destination.setEmail(source.getEmail());
        destination.setContacts(source.getContacts());
        destination.setRole(source.getRole());
        destination.setLocked(source.isLocked());
        destination.setImage(source.getImage());
    }

    @Override
    //TODO: Please, move this logic to abstract translator.
    public void toDto(Admin source, UserDto destination) {
        if (source == null) {
            return;
        }
        destination.setId(source.getId());
        destination.setUsername(source.getUsername());
        destination.setPassword(source.getPassword());
        destination.setEmail(source.getEmail());
        destination.setContacts(source.getContacts());
        destination.setRole(source.getRole());
        destination.setLocked(source.isLocked());
        destination.setImage(source.getImage());
    }

    @Override
    public UserDto toDto(Admin source) {
        UserDto destination = new UserDto();
        toDto(source, destination);
        return destination;
    }

    @Override
    public Admin fromDto(UserDto source) {
        Admin destination = new Admin();
        fromDto(source, destination);
        return destination;
    }

    @Override
    public Set<Admin> getListFromDto(Set<UserDto> dtoSet){
        Set <Admin> adminSet = new HashSet<>();
        for (UserDto userDto : dtoSet){
            Admin admin = new Admin();
            fromDto(userDto, admin);
            adminSet.add(admin);
        }
        return adminSet;
    }
}
