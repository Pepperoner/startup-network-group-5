package ua.goit.java.startup.bom;


import java.util.List;

public class User{

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private UserRole roleList;

    private String password;

    public User() {}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRoleList() {
        return roleList;
    }

    public void setRoleList(UserRole roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {

        return String.format("UserDTO{id=%d, firstName='%s', lastName='%s', email='%s', roleList=[%s]}",
                id,
                firstName,
                lastName,
                email,
                roleList
        );
    }
}
