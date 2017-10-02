package ua.goit.java.startup.translator;

import ua.goit.java.startup.bom.Developer;
import ua.goit.java.startup.bom.Model;
import ua.goit.java.startup.bom.Startup;
import ua.goit.java.startup.bom.UserRole;
import ua.goit.java.startup.dto.StartupDto;
import ua.goit.java.startup.dto.UserDto;

import java.util.HashSet;
import java.util.Set;

public class StartupTranslator {

    public void fromDTO(StartupDto source, Model destination){
        if (source == null){
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
            if(UserRole.DEVELOPER.equals(userDto.getRole())) {
                Developer developer = new Developer();
                developer.setId(userDto.getId());
                developers.add(developer);
            }
        }

//        startupDestination.setDeveloper(source.getUserDto().stream().filter(user -> UserRole.DEVELOPER.equals(user.getRole())).map(userDto -> ));
//        startupDestination.setDeveloper(source.getUserDto().forEach(dev -> dev.getRole().equals(UserRole.DEVELOPER)));
//        startupDestination.setInvestor(source.getUserDto().forEach(inv -> inv.getRole().equals(UserRole.INVESTOR)));
    }

//    public Set<Startup> getSetFromDTO(Set<StartupDto> dtoSet){
//        Set<Startup> startupSet = new HashSet<>();
//        for (StartupDto startupDto : dtoSet) {
//            Startup startup = new Startup();
//            startupSet.add((Startup) startupDto)
//        }
//    }

}
