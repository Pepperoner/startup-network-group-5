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

@RunWith(MockitoJUnitRunner.class)
public class AdminTranslatorTest {

    @Spy
    @InjectMocks
    private AdminTranslator adminTranslator;

    @Test
    public void testToDto(){
        Admin admin = new Admin();
        admin.setRole(UserRole.ADMIN);
        UserDto userDto = adminTranslator.toDto(admin);
        Assert.assertEquals(UserRole.ADMIN, userDto.getRole());
    }

    @Test
    public void testFromDto(){
        UserDto userDto = new UserDto();
        userDto.setRole(UserRole.ADMIN);
        Admin admin = adminTranslator.fromDto(userDto);
        Assert.assertEquals(UserRole.ADMIN, admin.getRole());
    }
}
