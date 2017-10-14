package ua.goit.java.startup.translator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import ua.goit.java.startup.bom.Startup;
import ua.goit.java.startup.dto.StartupDto;

@RunWith(MockitoJUnitRunner.class)
public class StartupTranslatorTest {

    private static final int COST = 100;

    @Spy
    @InjectMocks
    private StartupTranslator startupTranslator;

    @Test
    public void testToDto(){
        Startup startup = new Startup();
        startup.setCost(COST);
        StartupDto startupDto = startupTranslator.toDto(startup);
        Assert.assertEquals(startupDto.getCost(), startup.getCost());
    }

    @Test
    public void testFromDto(){
        StartupDto startupDto = new StartupDto();
        startupDto.setCost(COST);
        Startup startup = startupTranslator.fromDto(startupDto);
        Assert.assertEquals(startup.getCost(), startupDto.getCost());
    }
}
