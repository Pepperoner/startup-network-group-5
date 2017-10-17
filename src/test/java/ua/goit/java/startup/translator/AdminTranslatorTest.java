package ua.goit.java.startup.translator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import ua.goit.java.startup.bom.Admin;
import ua.goit.java.startup.bom.UserRole;
import ua.goit.java.startup.dto.UserDto;

import java.util.HashSet;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
public class AdminTranslatorTest {

    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";
    private static final String EMAIL = "Email";
    private static final String CONTACTS = "Contacts";

    @Spy
    @InjectMocks
    private AdminTranslator adminTranslator;

    @Test
    public void testToDto() {
        Admin admin = new Admin();
        admin.setRole(UserRole.ADMIN);
        UserDto userDto = adminTranslator.toDto(admin);
        Assert.assertEquals(UserRole.ADMIN, userDto.getRole());
    }

    @Test
    public void testFromDto() {
        UserDto userDto = new UserDto();
        userDto.setRole(UserRole.ADMIN);
        Admin admin = adminTranslator.fromDto(userDto);
        Assert.assertEquals(UserRole.ADMIN, admin.getRole());
    }

    @Test
    public void testGetAdminListFromDto() {
        UserDto userDto = new UserDto();
        userDto.setUsername(USERNAME);
        userDto.setPassword(PASSWORD);
        userDto.setEmail(EMAIL);
        userDto.setContacts(CONTACTS);
        userDto.setRole(UserRole.ADMIN);
        Set<UserDto> userDtoSet = new HashSet<>();
        userDtoSet.add(userDto);
        Set<Admin> admins = adminTranslator.getListFromDto(userDtoSet);
        for (Admin admin : admins) {
            Assert.assertEquals(USERNAME, admin.getUsername());
            Assert.assertEquals(PASSWORD, admin.getPassword());
            Assert.assertEquals(EMAIL, admin.getEmail());
            Assert.assertEquals(CONTACTS, admin.getContacts());
            Assert.assertEquals(UserRole.ADMIN, admin.getRole());
        }
    }
}