package ua.goit.java.startup.domainservise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.goit.java.startup.bom.User;
import ua.goit.java.startup.dao.UserDTORepository;
import ua.goit.java.startup.domainservise.UserDetailsSecurity;
import ua.goit.java.startup.domainservise.UserService;
import ua.goit.java.startup.dto.UserDto;
import ua.goit.java.startup.translator.UserTranslator;

import java.util.HashSet;
import java.util.Set;


@Service
public class UserServiceImpl extends DataServiceImpl<UserDto, User> implements UserService {


    @Autowired
    private UserDTORepository userRepository;

    public User findByEmail(String email) {
        UserDto userDTO = userRepository.findByEmail(email);
        UserTranslator userTranslator = new UserTranslator();
        User user = new User();
        userTranslator.fromDto(userDTO, user);
        return user;
    }




    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = findByEmail(s);
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(user.getRoleList().name()));
        UserDetailsSecurity userSecurity = new UserDetailsSecurity(s,user.getPassword(),roles);
        userSecurity.setUserRole(user.getRoleList());
        return userSecurity;
    }


}
