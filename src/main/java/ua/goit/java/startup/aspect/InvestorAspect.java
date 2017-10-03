package ua.goit.java.startup.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ua.goit.java.startup.bom.Investor;
import ua.goit.java.startup.dao.UserDTORepository;
import ua.goit.java.startup.dto.UserDto;
import ua.goit.java.startup.translator.DeveloperTranslator;
import ua.goit.java.startup.translator.InvestorTranslator;

@Aspect
@Component
public class InvestorAspect {

    private final UserDTORepository userDTORepository;
    private final InvestorTranslator investorTranslator;

    public InvestorAspect(UserDTORepository userDTORepository, InvestorTranslator investorTranslator) {
        this.userDTORepository = userDTORepository;
        this.investorTranslator = investorTranslator;
    }

    @Before("execution(* ua.goit.java.startup.bom.Investor.get*(..))")
    public void fillInvestorInfo(JoinPoint joinPoint){
        Investor investor = (Investor) joinPoint.getTarget();
        UserDto userDto = userDTORepository.findOne(investor.getId());
        investorTranslator.fromDto(userDto, investor);
    }

}
