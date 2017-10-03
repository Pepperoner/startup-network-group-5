package ua.goit.java.startup.translator;


import org.springframework.stereotype.Component;
import ua.goit.java.startup.bom.Investor;
import ua.goit.java.startup.dto.UserDto;

@Component
public class InvestorTranslator extends DataTranslator<UserDto, Investor>   {


    @Override
    public void toDto(Investor source, UserDto destination) {
        if (source == null) {
            return;
        }

        source.setId(destination.getId());
        source.setUsername(destination.getUsername());
        source.setPassword(destination.getPassword());
        source.setContacts(destination.getContacts());
        source.setRole(destination.getRole());
        source.setPaidcost(destination.getPaidcost());
        source.setLocked(destination.isLocked());
        source.setImage(destination.getImage());
        //source.setStartup(destination.getStartupDto());


    }

    @Override
    public UserDto toDto(Investor source) {
        UserDto destination = new UserDto();
        toDto(source, destination);
        return destination;
    }


    @Override
    public void fromDto(UserDto source, Investor destination) {
        destination.setId(source.getId());
        destination.setUsername(source.getUsername());
        destination.setPassword(source.getPassword());
        destination.setContacts(source.getContacts());
        destination.setRole(source.getRole());
        destination.setPaidcost(source.getPaidcost());
        destination.setLocked(source.isLocked());
        destination.setImage(source.getImage());
        //destination.setStartup(source.getStartupDto());

    }



    @Override
    public Investor fromDto(UserDto source) {
        Investor destination = new Investor();
        fromDto(source, destination);
        return destination;
    }

}
