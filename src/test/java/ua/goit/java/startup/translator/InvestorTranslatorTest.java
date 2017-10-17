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
    private static final long PAIDCOST = 1500L;

    @Spy
    @InjectMocks
    private InvestorTranslator investorTranslator;

    @Test
    public void testToDto() {
        Investor investor = new Investor();
        investor.setRole(UserRole.INVESTOR);
        UserDto userDto = investorTranslator.toDto(investor);
        Assert.assertEquals(UserRole.INVESTOR, userDto.getRole());
    }

    @Test
    public void testFromDto() {
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
        for (Investor investor : investors) {
            Assert.assertEquals(USERNAME, investor.getUsername());
            Assert.assertEquals(PASSWORD, investor.getPassword());
            Assert.assertEquals(EMAIL, investor.getEmail());
            Assert.assertEquals(CONTACTS, investor.getContacts());
            Assert.assertEquals(PAIDCOST, investor.getPaidCost());
            Assert.assertEquals(UserRole.INVESTOR, investor.getRole());
        }
    }
}