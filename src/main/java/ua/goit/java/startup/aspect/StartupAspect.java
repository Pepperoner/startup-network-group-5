package ua.goit.java.startup.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.goit.java.startup.bom.Startup;
import ua.goit.java.startup.dao.StartupDTORepository;
import ua.goit.java.startup.dto.StartupDto;
import ua.goit.java.startup.translator.StartupTranslator;

@Aspect
@Component
public class StartupAspect {

    private final StartupDTORepository startupDTORepository;
    private final StartupTranslator startupTranslator;

    @Autowired
    public StartupAspect(StartupDTORepository startupDTORepository, StartupTranslator startupTranslator) {
        this.startupDTORepository = startupDTORepository;
        this.startupTranslator = startupTranslator;
    }

    @Before("execution(* ua.goit.java.startup.bom.Startup.get*(..))")
    public void fillStarupInfo(JoinPoint joinPoint) {
        Startup startup = (Startup) joinPoint.getTarget();
        StartupDto startupDto = startupDTORepository.findOne(startup.getId());
        startupTranslator.fromDto(startupDto, startup);
    }
}
