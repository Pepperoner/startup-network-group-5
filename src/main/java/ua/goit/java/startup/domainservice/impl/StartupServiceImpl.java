package ua.goit.java.startup.domainservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.startup.bom.Developer;
import ua.goit.java.startup.bom.Startup;
import ua.goit.java.startup.bom.UserRole;
import ua.goit.java.startup.dao.DataRepository;
import ua.goit.java.startup.dao.StartupDTORepository;
import ua.goit.java.startup.domainservice.StartupService;
import ua.goit.java.startup.dto.StartupDto;
import ua.goit.java.startup.dto.UserDto;
import ua.goit.java.startup.translator.DataTranslator;
import ua.goit.java.startup.translator.DeveloperTranslator;
import ua.goit.java.startup.translator.StartupTranslator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/*
Implementation of the startup's methods
 */
@Service
public class StartupServiceImpl extends DataServiceImpl<StartupDto, Startup> implements StartupService {

    private StartupDTORepository startupDTORepository;

    @Autowired
    public StartupServiceImpl(DataRepository<StartupDto> repository,
                              DataTranslator<StartupDto, Startup> translator,
                              StartupDTORepository startupDTORepository) {
        super(repository, translator);
        this.startupDTORepository = startupDTORepository;
    }

    @Override
    @Transactional
    public Startup findByName(String name) {
        StartupDto startupDto = startupDTORepository.findByName(name);
        StartupTranslator startupTranslator = new StartupTranslator();
        Startup startup = new Startup();
        startupTranslator.fromDto(startupDto, startup);
        return startup;
    }

    @Override
    @Transactional
    public void removeByName(String name) {
        startupDTORepository.deleteByName(name);
    }

    @Override
    @Transactional
    public Collection<Developer> getStartupsDevelopers(long id) {
        StartupDto startupDto = startupDTORepository.getOne(id);
        DeveloperTranslator developerTranslator = new DeveloperTranslator();
        Set<UserDto> userDtos = startupDto.getUserDto();
        Set<Developer> developers = new HashSet<>();
        for (UserDto user : userDtos) {
            if (user.getRole().equals(UserRole.DEVELOPER)) {
                developers.add(developerTranslator.fromDto(user));
            }
        }
        return developers;
    }

    @Override
    @Transactional
    public Set<Startup> findStartupsByKeyWord(String key) {
        Set<StartupDto> modelDto = new HashSet<>();
        modelDto.addAll(startupDTORepository.findStartupsByKeyWord(key));
        Set<Startup> model = new HashSet<>();
        model.addAll(translator.getListFromDto(modelDto));
        return model;
    }
}