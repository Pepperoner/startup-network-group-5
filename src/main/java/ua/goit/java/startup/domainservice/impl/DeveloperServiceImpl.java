package ua.goit.java.startup.domainservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.goit.java.startup.bom.Developer;

import ua.goit.java.startup.dao.UserDTORepository;
import ua.goit.java.startup.domainservice.DeveloperService;
import ua.goit.java.startup.domainservice.UserDetailsSecurity;

import ua.goit.java.startup.dto.UserDto;
import ua.goit.java.startup.translator.DeveloperTranslator;


import java.util.HashSet;
import java.util.Set;



@Service
public class DeveloperServiceImpl extends DataServiceImpl<UserDto, Developer> implements DeveloperService {


    @Autowired
    private UserDTORepository userRepository;

    public Developer findByEmail(String email) {
        UserDto userDTO = userRepository.findByEmail(email);
        DeveloperTranslator userTranslator = new DeveloperTranslator();
        Developer developer = new Developer();
        userTranslator.fromDto(userDTO, developer);
        return developer;
    }




    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Developer developer = findByEmail(s);
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(developer.getRole().name()));
        UserDetailsSecurity userSecurity = new UserDetailsSecurity(s,developer.getPassword(),roles);
        userSecurity.setUserRole(developer.getRole());
        return userSecurity;
    }


}