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

import java.util.HashSet;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
public class DeveloperTranslatorTest {

    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";
    private static final String EMAIL = "Email";
    private static final String CONTACTS = "Contacts";

    @Spy
    @InjectMocks
    private DeveloperTranslator developerTranslator;

    @Test
    public void testToDto() {
        Developer developer = new Developer();
        developer.setRole(UserRole.DEVELOPER);
        UserDto userDto = developerTranslator.toDto(developer);
        Assert.assertEquals(UserRole.DEVELOPER, userDto.getRole());
    }

    @Test
    public void testFromDto() {
        UserDto userDto = new UserDto();
        userDto.setRole(UserRole.DEVELOPER);
        Developer developer = developerTranslator.fromDto(userDto);
        Assert.assertEquals(UserRole.DEVELOPER, developer.getRole());
    }

    @Test
    public void testGetDeveloperListFromDto() {
        UserDto userDto = new UserDto();
        userDto.setUsername(USERNAME);
        userDto.setPassword(PASSWORD);
        userDto.setEmail(EMAIL);
        userDto.setContacts(CONTACTS);
        userDto.setRole(UserRole.DEVELOPER);
        Set<UserDto> userDtoSet = new HashSet<>();
        userDtoSet.add(userDto);
        Set<Developer> developers = developerTranslator.getListFromDto(userDtoSet);
        for (Developer developer : developers) {
            Assert.assertEquals(USERNAME, developer.getUsername());
            Assert.assertEquals(PASSWORD, developer.getPassword());
            Assert.assertEquals(EMAIL, developer.getEmail());
            Assert.assertEquals(CONTACTS, developer.getContacts());
            Assert.assertEquals(UserRole.DEVELOPER, developer.getRole());
        }
    }
}