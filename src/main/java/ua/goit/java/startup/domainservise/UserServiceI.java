package ua.goit.java.startup.domainservise;


import ua.goit.java.startup.bom.User;

public interface UserServiceI {

    User findByEmail(String email);

    //User findByConfirmationToken(String confirmationToken);

    void saveUser(User user);
}
