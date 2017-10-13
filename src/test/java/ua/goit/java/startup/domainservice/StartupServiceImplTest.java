package ua.goit.java.startup.domainservice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import ua.goit.java.startup.bom.Startup;
import ua.goit.java.startup.dao.StartupDTORepository;
import ua.goit.java.startup.domainservice.impl.StartupServiceImpl;
import ua.goit.java.startup.dto.StartupDto;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StartupServiceImplTest {

    private static final String NAME = "A";

    @Mock
    private StartupDTORepository startupDTORepository;

    @Spy
    @InjectMocks
    private StartupServiceImpl startupServiceImpl;

    @Test
    public void testFindByName() {
        StartupDto startupDto = new StartupDto();
        startupDto.setName(NAME);
        when(startupDTORepository.findByName(NAME)).thenReturn(startupDto);
        Startup startup = startupServiceImpl.findByName(NAME);
        Assert.assertEquals(NAME, startup.getName());
        verify(startupDTORepository, times(1)).findByName(NAME);
    }

    @Test
    public void testDeleteByName() {
        StartupDto startupDto = new StartupDto();
        startupDto.setName(NAME);
        startupDTORepository.deleteByName(NAME);
        verify(startupDTORepository,times(1)).deleteByName(NAME);
    }
}
