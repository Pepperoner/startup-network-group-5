package ua.goit.java.startup.translator;

import org.springframework.stereotype.Component;
import ua.goit.java.startup.bom.Admin;
import ua.goit.java.startup.bom.Startup;
import ua.goit.java.startup.dto.StartupDto;
import ua.goit.java.startup.dto.UserDto;

import java.util.HashSet;
import java.util.Set;

@Component
public class AdminTranslator extends DataTranslator<UserDto, Admin> {

    @Override
    //TODO: Please, move this logic to abstract translator.
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
        destination.setPaidcost(source.getPaidcost());
        destination.setLocked(source.isLocked());
        destination.setImage(source.getImage());

        Set<Startup> startups = new HashSet<>();
        destination.setStartup(startups);
        for (StartupDto startupDto : source.getStartupDto()) {
            Startup startup = new Startup();
            startup.setId(startupDto.getId());
            startups.add(startup);
        }
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
        destination.setPaidcost(source.getPaidcost());
        destination.setLocked(source.isLocked());
        destination.setImage(source.getImage());

        Set<StartupDto> startupDtos = new HashSet<>();
        destination.setStartupDto(startupDtos);
        for (Startup startup : source.getStartup()) {
            StartupDto startupDto = new StartupDto();
            startupDto.setId(startup.getId());
            startupDtos.add(startupDto);
        }
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
