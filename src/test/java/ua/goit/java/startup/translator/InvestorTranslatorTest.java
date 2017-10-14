package ua.goit.java.startup.translator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import ua.goit.java.startup.bom.Investor;
import ua.goit.java.startup.bom.UserRole;
import ua.goit.java.startup.dto.UserDto;

@RunWith(MockitoJUnitRunner.class)
public class InvestorTranslatorTest {

    @Spy
    @InjectMocks
    private InvestorTranslator investorTranslator;

    @Test
    public void testToDto(){
        Investor investor = new Investor();
        investor.setRole(UserRole.INVESTOR);
        UserDto userDto = investorTranslator.toDto(investor);
        Assert.assertEquals(UserRole.INVESTOR, userDto.getRole());
    }

    @Test
    public void testFromDto(){
        UserDto userDto = new UserDto();
        userDto.setRole(UserRole.INVESTOR);
        Investor investor = investorTranslator.fromDto(userDto);
        Assert.assertEquals(UserRole.INVESTOR, investor.getRole());
    }
}
