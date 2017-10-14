package ua.goit.java.startup.translator;

import org.springframework.stereotype.Component;
import ua.goit.java.startup.bom.*;
import ua.goit.java.startup.dto.StartupDto;
import ua.goit.java.startup.dto.UserDto;

import java.util.HashSet;
import java.util.Set;

@Component
public class DeveloperTranslator extends AbstractUserTranslator<Developer> {

    @Override
    public void fromDto(UserDto source, Developer destination) {
        if (source == null) {
            return;
        }
        super.fromDto(source, destination);
        Set<Startup> startups = new HashSet<>();
        destination.setStartup(startups);
        for (StartupDto startupDto : source.getStartupDto()) {
            Startup startup = new Startup();
            startup.setId(startupDto.getId());
            startup.setName(startupDto.getName());
            startup.setDescription(startupDto.getDescription());
            startup.setCost(startupDto.getCost());
            startup.setCurrentsum(startupDto.getCurrentsum());
            startups.add(startup);
        }
    }

    @Override
    public void toDto(Developer source, UserDto destination) {
        if (source == null) {
            return;
        }
        super.toDto(source, destination);
        Set<StartupDto> startupDtos = new HashSet<>();
        destination.setStartupDto(startupDtos);
        for (Startup startup : source.getStartup()) {
            StartupDto startupDto = new StartupDto();
            startupDto.setId(startup.getId());
            startupDtos.add(startupDto);
        }
    }

    @Override
    public UserDto toDto(Developer source) {
        UserDto destination = new UserDto();
        toDto(source, destination);
        return destination;
    }


    @Override
    public Developer fromDto(UserDto source) {
        Developer destination = new Developer();
        fromDto(source, destination);
        return destination;
    }

    public Set<Developer> getListFromDto(Set<UserDto> dtoSet) {
        Set<Developer> developerSet = new HashSet<>();
        for (UserDto userDto : dtoSet) {
            Developer developer = new Developer();
            fromDto(userDto, developer);
            developerSet.add(developer);
        }
        return developerSet;
    }
}