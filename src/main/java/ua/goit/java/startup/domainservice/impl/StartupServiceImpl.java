package ua.goit.java.startup.domainservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.java.startup.bom.Startup;
import ua.goit.java.startup.dao.DataRepository;
import ua.goit.java.startup.domainservice.StartupService;
import ua.goit.java.startup.dto.StartupDto;
import ua.goit.java.startup.translator.DataTranslator;

@Service
public class StartupServiceImpl extends DataServiceImpl<StartupDto, Startup> implements StartupService {
    @Autowired
    public StartupServiceImpl(DataRepository<StartupDto> repository, DataTranslator<StartupDto, Startup> translator) {
        super(repository, translator);
    }
}
