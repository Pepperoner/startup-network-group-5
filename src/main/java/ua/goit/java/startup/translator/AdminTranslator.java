package ua.goit.java.startup.translator;

import org.springframework.stereotype.Component;
import ua.goit.java.startup.bom.Admin;
import ua.goit.java.startup.dto.UserDto;

import java.util.HashSet;
import java.util.Set;
/*
A class with Admin's methods for transfer from/to DataBase
 */
@Component
public class AdminTranslator extends AbstractUserTranslator<Admin> {

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
    public Set<Admin> getListFromDto(Set<UserDto> dtoSet) {
        Set<Admin> adminSet = new HashSet<>();
        for (UserDto userDto : dtoSet) {
            Admin admin = new Admin();
            fromDto(userDto, admin);
            adminSet.add(admin);
        }
        return adminSet;
    }
}