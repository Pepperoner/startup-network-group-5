package ua.goit.java.startup.domainservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.goit.java.startup.bom.Developer;

import ua.goit.java.startup.dao.DataRepository;
import ua.goit.java.startup.dao.UserDTORepository;
import ua.goit.java.startup.domainservice.DeveloperService;

import ua.goit.java.startup.dto.UserDto;
import ua.goit.java.startup.translator.DataTranslator;
import ua.goit.java.startup.translator.DeveloperTranslator;

@Service
@Primary
public class DeveloperServiceImpl extends DataServiceImpl<UserDto, Developer> implements DeveloperService {

    private UserDTORepository userRepository;

    @Autowired
    public DeveloperServiceImpl(DataRepository<UserDto> repository, DataTranslator<UserDto, Developer> translator, UserDTORepository userRepository) {
        super(repository, translator);
        this.userRepository = userRepository;
    }

    public Developer findByEmail(String email) {
        UserDto userDTO = userRepository.findByEmail(email);
        DeveloperTranslator userTranslator = new DeveloperTranslator();
        Developer developer = new Developer();
        userTranslator.fromDto(userDTO, developer);
        return developer;
    }




    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        return findByEmail(s);
    }


}