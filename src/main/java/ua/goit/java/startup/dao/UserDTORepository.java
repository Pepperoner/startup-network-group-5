package ua.goit.java.startup.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.goit.java.startup.dto.UserDto;

//@Repository
public interface UserDTORepository extends CrudRepository<UserDto, Integer> {
    UserDto findByEmail(String email);
    //UserDto findByEmail(String email);
    //User findByConfirmationToken(String confirmationToken);
}
