package ua.goit.java.startup.domainservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.startup.bom.Developer;

import ua.goit.java.startup.bom.UserRole;
import ua.goit.java.startup.dao.DataRepository;
import ua.goit.java.startup.dao.UserDTORepository;
import ua.goit.java.startup.domainservice.DeveloperService;

import ua.goit.java.startup.dto.UserDto;
import ua.goit.java.startup.translator.DataTranslator;
import ua.goit.java.startup.translator.DeveloperTranslator;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Implementation of the developer's methods
 */
@Service
public class DeveloperServiceImpl extends DataServiceImpl<UserDto, Developer> implements DeveloperService {

    private UserDTORepository userRepository;

    @Autowired
    public DeveloperServiceImpl(DataRepository<UserDto> repository,
                                DataTranslator<UserDto, Developer> translator,
                                UserDTORepository userRepository) {
        super(repository, translator);
        this.userRepository = userRepository;
    }

    @Transactional
    public Developer findByEmail(String email) {
        UserDto userDTO = userRepository.findByEmail(email);
        DeveloperTranslator userTranslator = new DeveloperTranslator();
        Developer developer = new Developer();
        userTranslator.fromDto(userDTO, developer);
        return developer;
    }

    @Override
    @Transactional
    public Collection<Developer> getAll() {
        Set<UserDto> modelDto = new HashSet<>();
        List<UserDto> userDtoList = repository.findAll();
        for (UserDto userDto : userDtoList) {
            if (userDto.getRole().equals(UserRole.DEVELOPER)) {
                modelDto.add(userDto);
            }
        }
        Set<Developer> model = new HashSet<>();
        model.addAll(translator.getListFromDto(modelDto));
        return model;
    }
}