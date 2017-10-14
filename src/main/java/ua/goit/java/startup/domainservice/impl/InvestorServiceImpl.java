package ua.goit.java.startup.domainservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.startup.bom.Developer;
import ua.goit.java.startup.bom.Investor;
import ua.goit.java.startup.bom.UserRole;
import ua.goit.java.startup.dao.DataRepository;
import ua.goit.java.startup.dao.UserDTORepository;
import ua.goit.java.startup.domainservice.InvestorService;
import ua.goit.java.startup.dto.UserDto;
import ua.goit.java.startup.translator.DataTranslator;
import ua.goit.java.startup.translator.InvestorTranslator;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class InvestorServiceImpl extends DataServiceImpl<UserDto, Investor> implements InvestorService {

    private UserDTORepository userRepository;

    @Autowired
    public InvestorServiceImpl(DataRepository<UserDto> repository, DataTranslator<UserDto, Investor> translator, UserDTORepository userRepository) {
        super(repository, translator);
        this.userRepository = userRepository;
    }
    @Transactional
    public Investor findByEmail(String email) {
        UserDto userDTO = userRepository.findByEmail(email);
        InvestorTranslator investorTranslator = new InvestorTranslator();
        Investor investor = new Investor();
        investorTranslator.fromDto(userDTO, investor);
        return investor;
    }

    @Override
    @Transactional
    public Collection<Investor> getAll() {

        Set<UserDto> modelDto = new HashSet<>();
        List<UserDto> userDtoList = repository.findAll();
        for (UserDto userDto : userDtoList) {
            if (userDto.getRole().equals(UserRole.INVESTOR)){
                modelDto.add(userDto);
            }
        }
        Set<Investor> model = new HashSet<>();
        model.addAll(translator.getListFromDto(modelDto));
        return model;
    }
}
