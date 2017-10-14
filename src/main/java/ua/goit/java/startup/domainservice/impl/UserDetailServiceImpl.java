package ua.goit.java.startup.domainservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.startup.bom.UserRole;
import ua.goit.java.startup.dao.UserDTORepository;
import ua.goit.java.startup.dto.UserDto;
import ua.goit.java.startup.translator.AdminTranslator;
import ua.goit.java.startup.translator.DeveloperTranslator;
import ua.goit.java.startup.translator.InvestorTranslator;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserDTORepository userRepository;
    private final DeveloperTranslator developerTranslator;
    private final InvestorTranslator investorTranslator;

    private final AdminTranslator adminTranslator;

    @Autowired
    public UserDetailServiceImpl(UserDTORepository userRepository,
                                 DeveloperTranslator developerTranslator,
                                 InvestorTranslator investorTranslator,
                                 AdminTranslator adminTranslator) {
        this.userRepository = userRepository;
        this.developerTranslator = developerTranslator;
        this.investorTranslator = investorTranslator;
        this.adminTranslator = adminTranslator;
    }



    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        UserDto userDTO = userRepository.findByEmail(s);
        UserRole userRole = userDTO.getRole();
        if(userRole.equals(UserRole.DEVELOPER)){
            return developerTranslator.fromDto(userDTO);
        }else if(userRole.equals(UserRole.INVESTOR)){
            return investorTranslator.fromDto(userDTO);
        }else if(userRole.equals(UserRole.ADMIN)){
            return adminTranslator.fromDto(userDTO);
        }
        return null;
    }
}
