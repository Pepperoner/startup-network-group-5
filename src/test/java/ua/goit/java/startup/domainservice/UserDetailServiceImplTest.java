package ua.goit.java.startup.domainservice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;
import ua.goit.java.startup.bom.Admin;
import ua.goit.java.startup.bom.Developer;
import ua.goit.java.startup.bom.Investor;
import ua.goit.java.startup.bom.UserRole;
import ua.goit.java.startup.dao.UserDTORepository;
import ua.goit.java.startup.domainservice.impl.UserDetailServiceImpl;
import ua.goit.java.startup.dto.UserDto;
import ua.goit.java.startup.translator.AdminTranslator;
import ua.goit.java.startup.translator.DeveloperTranslator;
import ua.goit.java.startup.translator.InvestorTranslator;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailServiceImplTest {

    private static final String EMAIL = "google@gmail.com";

    @Mock
    private UserDTORepository userRepository;
    @Mock
    private DeveloperTranslator developerTranslator;
    @Mock
    private InvestorTranslator investorTranslator;
    @Mock
    private AdminTranslator adminTranslator;

    @Spy
    @InjectMocks
    private UserDetailServiceImpl userDetailServiceImpl;

    @Test
    public void testLoadInvestorByUsername(){
        UserDto userDto = new UserDto();
        Investor investor = new Investor();
        userDto.setEmail(EMAIL);
        userDto.setRole(UserRole.INVESTOR);
        when(userRepository.findByEmail(EMAIL)).thenReturn(userDto);
        when(investorTranslator.fromDto(userDto)).thenReturn(investor);
        UserDetails userDetails = userDetailServiceImpl.loadUserByUsername(EMAIL);
        Assert.assertTrue(userDetails instanceof Investor);

    }
    @Test
    public void testLoadDeveloperByUsername(){
        UserDto userDto = new UserDto();
        Developer developer = new Developer();
        userDto.setEmail(EMAIL);
        userDto.setRole(UserRole.DEVELOPER);
        when(userRepository.findByEmail(EMAIL)).thenReturn(userDto);
        when(developerTranslator.fromDto(userDto)).thenReturn(developer);
        UserDetails userDetails = userDetailServiceImpl.loadUserByUsername(EMAIL);
        Assert.assertTrue(userDetails instanceof Developer);
    }

    @Test
    public void testLoadAdminByUsername(){
        UserDto userDto = new UserDto();
        Admin admin = new Admin();
        userDto.setEmail(EMAIL);
        userDto.setRole(UserRole.ADMIN);
        when(userRepository.findByEmail(EMAIL)).thenReturn(userDto);
        when(adminTranslator.fromDto(userDto)).thenReturn(admin);
        UserDetails userDetails = userDetailServiceImpl.loadUserByUsername(EMAIL);
        Assert.assertTrue(userDetails instanceof Admin);
    }
}