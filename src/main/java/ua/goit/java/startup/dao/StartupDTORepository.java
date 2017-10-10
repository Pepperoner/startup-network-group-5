package ua.goit.java.startup.dao;

import ua.goit.java.startup.dto.StartupDto;

public interface StartupDTORepository extends DataRepository<StartupDto> {
    StartupDto findByName(String name);
    void deleteByName(String name);
}

