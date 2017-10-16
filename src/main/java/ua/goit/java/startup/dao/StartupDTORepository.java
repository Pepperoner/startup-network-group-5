package ua.goit.java.startup.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.goit.java.startup.dto.StartupDto;

import java.util.List;

/*
Interface that extend methods from DataRepository for StartupDto
 */
public interface StartupDTORepository extends DataRepository<StartupDto> {
    StartupDto findByName(String name);
    void deleteByName(String name);
    @Query("Select s from StartupDto s where s.name like CONCAT('%',:key,'%') or s.description like CONCAT('%',:key,'%')")
    List<StartupDto> findStartupsByKeyWord(@Param("key") String key);
}