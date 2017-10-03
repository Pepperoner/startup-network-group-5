package ua.goit.java.startup.translator;

import ua.goit.java.startup.bom.*;
import ua.goit.java.startup.dto.StartupDto;
import ua.goit.java.startup.dto.UserDto;

import java.util.HashSet;
import java.util.Set;

public class StartupTranslator {

    public void fromDTO(StartupDto source, Model destination) {
        if (source == null) {
            return;
        }

        Startup startupDestination = (Startup) destination;
        startupDestination.setId(source.getId());
        startupDestination.setName(source.getName());
        startupDestination.setDescription(source.getDescription());
        startupDestination.setCost(source.getCost());
        startupDestination.setCurrentsum(source.getCurrentsum());
        startupDestination.setImage(source.getImage());
        Set<Developer> developers = new HashSet<>();
        startupDestination.setDeveloper(developers);
        for (UserDto userDto : source.getUserDto()) {
            if (UserRole.DEVELOPER.equals(userDto.getRole())) {
                Developer developer = new Developer();
                developer.setId(userDto.getId());
                developers.add(developer);
            }
        }
        Set<Investor> investors = new HashSet<>();
        startupDestination.setInvestor(investors);
        for (UserDto userDto : source.getUserDto()) {
            if (UserRole.INVESTOR.equals(userDto.getRole())) {
                Investor investor = new Investor();
                investor.setId(userDto.getId());
                investors.add(investor);
            }
        }
    }

    public void toDTO(Startup source, StartupDto destination) {
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
}
//    public Set<Startup> getSetFromDTO(Set<StartupDto> dtoSet){
//        Set<Startup> startupSet = new HashSet<>();
//        for (StartupDto startupDto : dtoSet) {
//            Startup startup = new Startup();
//            startupSet.add((Startup) startupDto)
//        }
//    }


