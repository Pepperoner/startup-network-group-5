package ua.goit.java.startup.domainservice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import ua.goit.java.startup.bom.Investor;
import ua.goit.java.startup.dao.UserDTORepository;
import ua.goit.java.startup.domainservice.impl.InvestorServiceImpl;
import ua.goit.java.startup.dto.UserDto;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class InvestorServiceImplTest {

    private static final String EMAIL = "Google@gmail.com";

    @Mock
    private UserDTORepository userDTORepository;

    @Spy
    @InjectMocks
    private InvestorServiceImpl developerServiceImpl;

    @Test
    public void testFindByEmail() {
        UserDto userDto = new UserDto();
        userDto.setEmail(EMAIL);
        when(userDTORepository.findByEmail(EMAIL)).thenReturn(userDto);
        Investor investor = developerServiceImpl.findByEmail(EMAIL);
        Assert.assertEquals(EMAIL, investor.getEmail());
        verify(userDTORepository, times(1)).findByEmail(EMAIL);
    }
}
