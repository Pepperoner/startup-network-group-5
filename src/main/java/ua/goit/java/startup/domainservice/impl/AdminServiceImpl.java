package ua.goit.java.startup.domainservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.java.startup.bom.Admin;
import ua.goit.java.startup.bom.Developer;
import ua.goit.java.startup.dao.DataRepository;
import ua.goit.java.startup.dao.UserDTORepository;
import ua.goit.java.startup.domainservice.AdminService;
import ua.goit.java.startup.dto.UserDto;
import ua.goit.java.startup.translator.AdminTranslator;
import ua.goit.java.startup.translator.DataTranslator;
import ua.goit.java.startup.translator.DeveloperTranslator;
/*
Implementation of the administrator's method findByEmail
 */
@Service
public class AdminServiceImpl extends DataServiceImpl<UserDto, Admin> implements AdminService {

    private UserDTORepository userRepository;

    @Autowired
    public AdminServiceImpl(DataRepository<UserDto> repository,
                            DataTranslator<UserDto, Admin> translator,
                            UserDTORepository userRepository) {
        super(repository, translator);
        this.userRepository = userRepository;
    }

    @Override
    public Admin findByEmail(String email) {
        UserDto userDTO = userRepository.findByEmail(email);
        AdminTranslator adminTranslator = new AdminTranslator();
        Admin admin = new Admin();
        adminTranslator.fromDto(userDTO, admin);
        return admin;
    }
}