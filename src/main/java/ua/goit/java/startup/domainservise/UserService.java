package ua.goit.java.startup.domainservise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.java.startup.bom.User;
import ua.goit.java.startup.dao.UserDTORepository;
import ua.goit.java.startup.dto.UserDto;
import ua.goit.java.startup.translator.DeveloperTranslator;
import ua.goit.java.startup.translator.UserTranslator;


@Service
public class UserService implements UserServiceI {
    @Autowired
    private UserDTORepository userRepository;

    public User findByEmail(String email) {
        UserDto userDTO = userRepository.findByEmail(email);
        UserTranslator developerTranslator = new UserTranslator();
        User user = new User();
        developerTranslator.fromDto(userDTO, user);

        return user;
    }

    //public User findByConfirmationToken(String confirmationToken) {
    //    return userRepository.findByConfirmationToken(confirmationToken);
    //}

    public void saveUser(User user) {

        UserDto userDTO = new UserDto();
        UserTranslator developerTranslator = new UserTranslator();
        developerTranslator.toDto(user, userDTO);
        userRepository.save(userDTO);
    }

}
