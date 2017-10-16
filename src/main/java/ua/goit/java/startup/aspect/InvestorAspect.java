package ua.goit.java.startup.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.goit.java.startup.bom.Investor;
import ua.goit.java.startup.dao.UserDTORepository;
import ua.goit.java.startup.dto.UserDto;
import ua.goit.java.startup.translator.InvestorTranslator;
/*
Class implements end-to-end functionality for the Investor's side
 */
@Aspect
@Component
public class InvestorAspect {

    private final UserDTORepository userDTORepository;
    private final InvestorTranslator investorTranslator;

    @Autowired
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