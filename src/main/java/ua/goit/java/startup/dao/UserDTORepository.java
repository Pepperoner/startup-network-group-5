package ua.goit.java.startup.dao;

import ua.goit.java.startup.dto.UserDto;
/*
Interface that extend methods from DataRepository for UserDto
 */
public interface UserDTORepository extends DataRepository<UserDto> {
    UserDto findByEmail (String email);
}