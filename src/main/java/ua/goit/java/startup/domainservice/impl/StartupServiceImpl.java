package ua.goit.java.startup.domainservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.startup.bom.Startup;
import ua.goit.java.startup.dao.DataRepository;
import ua.goit.java.startup.dao.StartupDTORepository;
import ua.goit.java.startup.domainservice.StartupService;
import ua.goit.java.startup.dto.StartupDto;
import ua.goit.java.startup.translator.DataTranslator;
import ua.goit.java.startup.translator.StartupTranslator;

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
}