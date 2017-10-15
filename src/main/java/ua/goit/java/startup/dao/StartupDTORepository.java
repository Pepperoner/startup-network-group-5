package ua.goit.java.startup.dao;

import ua.goit.java.startup.dto.StartupDto;
/*
Interface that extend methods from DataRepository for StartupDto
 */
public interface StartupDTORepository extends DataRepository<StartupDto> {
    StartupDto findByName(String name);
    void deleteByName(String name);
}

