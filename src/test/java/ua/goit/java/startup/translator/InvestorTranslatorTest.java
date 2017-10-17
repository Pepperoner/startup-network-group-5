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

import java.util.HashSet;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
public class InvestorTranslatorTest {

    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";
    private static final String EMAIL = "Email";
    private static final String CONTACTS = "Contacts";
    private static final Long PAIDCOST = 1500L;

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

    @Test
    public void testGetInvestorListFromDto() {
        UserDto userDto = new UserDto();
        userDto.setUsername(USERNAME);
        userDto.setPassword(PASSWORD);
        userDto.setEmail(EMAIL);
        userDto.setContacts(CONTACTS);
        userDto.setPaidCost(PAIDCOST);
        userDto.setRole(UserRole.INVESTOR);
        Set<UserDto> userDtoSet = new HashSet<>();
        userDtoSet.add(userDto);
        Set<Investor> investors = investorTranslator.getListFromDto(userDtoSet);
        Investor element = investors.iterator().next();
        Assert.assertEquals(element.getUsername(),userDto.getUsername());
        Assert.assertEquals(element.getPassword(),userDto.getPassword());
        Assert.assertEquals(element.getEmail(),userDto.getEmail());
        Assert.assertEquals(element.getContacts(),userDto.getContacts());
        Assert.assertEquals(element.getPaidCost(),userDto.getPaidCost());
        Assert.assertTrue(element instanceof Investor);
    }
}