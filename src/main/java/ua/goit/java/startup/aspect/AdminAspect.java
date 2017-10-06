package ua.goit.java.startup.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.goit.java.startup.bom.Admin;
import ua.goit.java.startup.dao.UserDTORepository;
import ua.goit.java.startup.dto.UserDto;
import ua.goit.java.startup.translator.AdminTranslator;

@Aspect
@Component
public class AdminAspect {

    private final UserDTORepository userDTORepository;
    private final AdminTranslator adminTranslator;

    @Autowired
    public AdminAspect(UserDTORepository userDTORepository, AdminTranslator adminTranslator) {
        this.userDTORepository = userDTORepository;
        this.adminTranslator = adminTranslator;
    }

    @Before("execution(* ua.goit.java.startup.bom.Admin.get*(..))")
    public void fillAdminInfo(JoinPoint joinPoint){
        Admin admin = (Admin) joinPoint.getTarget();
        UserDto userDto = userDTORepository.findOne(admin.getId());
        adminTranslator.fromDto(userDto, admin);
    }
}
