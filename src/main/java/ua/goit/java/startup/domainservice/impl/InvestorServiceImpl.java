package ua.goit.java.startup.domainservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.goit.java.startup.bom.Investor;
import ua.goit.java.startup.dao.UserDTORepository;
import ua.goit.java.startup.domainservice.InvestorService;
import ua.goit.java.startup.domainservice.UserDetailsSecurity;
import ua.goit.java.startup.dto.UserDto;
import ua.goit.java.startup.translator.InvestorTranslator;

import java.util.HashSet;
import java.util.Set;


@Service
public class InvestorServiceImpl extends DataServiceImpl<UserDto, Investor> implements InvestorService {

    @Autowired
    private UserDTORepository userRepository;

    public Investor findByEmail(String email) {
        UserDto userDTO = userRepository.findByEmail(email);
        InvestorTranslator investorTranslator = new InvestorTranslator();
        Investor investor = new Investor();
        investorTranslator.fromDto(userDTO, investor);
        return investor;
    }




    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Investor investor = findByEmail(s);
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(investor.getRole().name()));
        UserDetailsSecurity userSecurity = new UserDetailsSecurity(s,investor.getPassword(),roles);
        userSecurity.setUserRole(investor.getRole());
        return userSecurity;
    }
}
