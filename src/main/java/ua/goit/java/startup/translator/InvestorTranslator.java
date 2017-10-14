package ua.goit.java.startup.translator;

import org.springframework.stereotype.Component;
import ua.goit.java.startup.bom.Investor;
import ua.goit.java.startup.bom.Startup;
import ua.goit.java.startup.dto.StartupDto;
import ua.goit.java.startup.dto.UserDto;

import java.util.HashSet;
import java.util.Set;

@Component
public class InvestorTranslator extends AbstractUserTranslator<Investor> {

    @Override
    public void fromDto(UserDto source, Investor destination) {
        if (source == null) {
            return;
        }
        super.fromDto(source, destination);
        Set<Startup> startups = new HashSet<>();
        destination.setStartup(startups);
        destination.setPaidcost(source.getPaidcost());
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
    public void toDto(Investor source, UserDto destination) {
        if (source == null) {
            return;
        }
        super.toDto(source, destination);
        Set<StartupDto> startupDtos = new HashSet<>();
        destination.setStartupDto(startupDtos);
        destination.setPaidcost(source.getPaidcost());
        for (Startup startup : source.getStartup()) {
            StartupDto startupDto = new StartupDto();
            startupDto.setId(startup.getId());
            startupDtos.add(startupDto);
        }
    }

    @Override
    public UserDto toDto(Investor source) {
        UserDto destination = new UserDto();
        toDto(source, destination);
        return destination;
    }

    @Override
    public Investor fromDto(UserDto source) {
        Investor destination = new Investor();
        fromDto(source, destination);
        return destination;
    }

    @Override
    public Set<Investor> getListFromDto(Set<UserDto> dtoSet) {
        Set<Investor> investorSet = new HashSet<>();
        for (UserDto userDto : dtoSet) {
            Investor investor = new Investor();
            fromDto(userDto, investor);
            investorSet.add(investor);
        }
        return investorSet;
    }
}