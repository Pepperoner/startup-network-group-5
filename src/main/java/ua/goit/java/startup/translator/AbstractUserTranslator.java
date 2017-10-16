package ua.goit.java.startup.translator;

import ua.goit.java.startup.bom.BaseUser;
import ua.goit.java.startup.dto.UserDto;
/*
A class with common methods for entities(BOMs) for transfer from/to DataBase
 */
public abstract class AbstractUserTranslator<T extends BaseUser> extends DataTranslator<UserDto, T> {

    @Override
    public void toDto(T source, UserDto destination) {
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
    public void fromDto(UserDto source, T destination) {
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
}