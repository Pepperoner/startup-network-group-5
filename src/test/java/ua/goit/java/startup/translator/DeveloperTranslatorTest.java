package ua.goit.java.startup.translator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import ua.goit.java.startup.bom.Developer;
import ua.goit.java.startup.bom.UserRole;
import ua.goit.java.startup.dto.UserDto;

@RunWith(MockitoJUnitRunner.class)
public class DeveloperTranslatorTest {

    @Spy
    @InjectMocks
    private DeveloperTranslator developerTranslator;

    @Test
    public void testToDto(){
        Developer developer = new Developer();
        developer.setRole(UserRole.DEVELOPER);
        UserDto userDto = developerTranslator.toDto(developer);
        Assert.assertEquals(UserRole.DEVELOPER, userDto.getRole());
    }

    @Test
    public void testFromDto(){
        UserDto userDto = new UserDto();
        userDto.setRole(UserRole.DEVELOPER);
        Developer developer = developerTranslator.fromDto(userDto);
        Assert.assertEquals(UserRole.DEVELOPER, developer.getRole());
    }
}
