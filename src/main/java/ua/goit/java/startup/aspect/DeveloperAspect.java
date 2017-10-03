package ua.goit.java.startup.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.goit.java.startup.bom.Developer;
import ua.goit.java.startup.dao.UserDTORepository;
import ua.goit.java.startup.dto.UserDto;
import ua.goit.java.startup.translator.DeveloperTranslator;

@Aspect
@Component
public class DeveloperAspect {

    private final UserDTORepository userDTORepository;
    private final DeveloperTranslator developerTranslator;

    @Autowired
    public DeveloperAspect(UserDTORepository userDTORepository, DeveloperTranslator developerTranslator) {
        this.userDTORepository = userDTORepository;
        this.developerTranslator = developerTranslator;
    }

    @Before("execution(* ua.goit.java.startup.bom.Developer.get*(..))")
    public void fillDeveloperInfo(JoinPoint joinPoint) {
        Developer developer = (Developer) joinPoint.getTarget();
        UserDto userDto = userDTORepository.findOne(developer.getId());
        developerTranslator.fromDto(userDto, developer);
    }
}
