package ua.goit.java.startup.translator;

import ua.goit.java.startup.bom.BaseUser;
import ua.goit.java.startup.bom.Model;
import ua.goit.java.startup.bom.Startup;
import ua.goit.java.startup.dto.ModelDTO;
import ua.goit.java.startup.dto.StartupDto;
import ua.goit.java.startup.dto.UserDto;

import java.util.HashSet;
import java.util.Set;

public abstract class UserAbstractTranslator  <T extends BaseUser> extends DataTranslator <UserDto, T> {

//    @Override
//    public void toDto(T source, UserDto destination) {
//        if (source == null) {
//            return;
//        }
//        destination.setId(source.getId());
//        destination.setUsername(source.getUsername());
//        destination.setPassword(source.getPassword());
//        destination.setEmail(source.getEmail());
//        destination.setContacts(source.getContacts());
//        destination.setRole(source.getRole());
//        destination.setLocked(source.isLocked());
//        destination.setImage(source.getImage());
//    }
//
//    @Override
//    public void fromDto(UserDto source, T destination) {
//        if (source == null) {
//            return;
//        }
//        destination.setId(source.getId());
//        destination.setUsername(source.getUsername());
//        destination.setPassword(source.getPassword());
//        destination.setEmail(source.getEmail());
//        destination.setContacts(source.getContacts());
//        destination.setRole(source.getRole());
//        destination.setLocked(source.isLocked());
//        destination.setImage(source.getImage());
//    }
}