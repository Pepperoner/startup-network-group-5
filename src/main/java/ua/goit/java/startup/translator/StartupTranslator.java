package ua.goit.java.startup.translator;

import org.springframework.stereotype.Component;
import ua.goit.java.startup.bom.*;
import ua.goit.java.startup.dto.StartupDto;
import ua.goit.java.startup.dto.UserDto;

import java.util.HashSet;
import java.util.Set;

@Component
public class StartupTranslator extends DataTranslator<StartupDto, Startup> {

    @Override
    public void fromDto(StartupDto source, Startup destination) {
        if (source == null) {
            return;
        }
        destination.setId(source.getId());
        destination.setName(source.getName());
        destination.setDescription(source.getDescription());
        destination.setCost(source.getCost());
        destination.setCurrentsum(source.getCurrentsum());
        destination.setImage(source.getImage());

        Set<Developer> developers = new HashSet<>();
        destination.setDeveloper(developers);
        for (UserDto userDto : source.getUserDto()) {
            if (UserRole.DEVELOPER.equals(userDto.getRole())) {
                Developer developer = new Developer();
                developer.setId(userDto.getId());
                developers.add(developer);
            }
        }
        Set<Investor> investors = new HashSet<>();
        destination.setInvestor(investors);
        for (UserDto userDto : source.getUserDto()) {
            if (UserRole.INVESTOR.equals(userDto.getRole())) {
                Investor investor = new Investor();
                investor.setId(userDto.getId());
                investors.add(investor);
            }
        }
    }

    @Override
    public void toDto(Startup source, StartupDto destination) {
        if (source == null) {
            return;
        }
        destination.setId(source.getId());
        destination.setName(source.getName());
        destination.setDescription(source.getDescription());
        destination.setCost(source.getCost());
        destination.setCurrentsum(source.getCurrentsum());
        destination.setImage(source.getImage());
        Set<UserDto> userDtos = new HashSet<>();
        destination.setUserDto(userDtos);
        for (Developer developer : source.getDeveloper()) {
            UserDto userDto = new UserDto();
            userDto.setId(developer.getId());
            userDtos.add(userDto);
        }
        for (Investor investor : source.getInvestor()) {
            UserDto userDto = new UserDto();
            userDto.setId(investor.getId());
            userDtos.add(userDto);
        }
    }

    @Override
    public StartupDto toDto(Startup source) {
        StartupDto destination = new StartupDto();
        toDto(source, destination);
        return destination;
    }

    @Override
    public Startup fromDto(StartupDto source) {
        Startup destination = new Startup();
        fromDto(source,destination);
        return destination;
    }

    @Override
    public Set<Startup> getListFromDto(Set<StartupDto> dtoSet){
        Set <Startup> startupSet = new HashSet<>();
        for (StartupDto startupDto : dtoSet){
            Startup startup = new Startup();
            fromDto(startupDto, startup);
            startupSet.add(startup);
        }
        return startupSet;
    }
}