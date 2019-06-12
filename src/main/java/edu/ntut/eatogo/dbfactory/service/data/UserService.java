package edu.ntut.eatogo.dbfactory.service.data;

import com.google.common.collect.Lists;
import edu.ntut.eatogo.dbfactory.converter.DomainDtoConverter;
import edu.ntut.eatogo.dbfactory.dto.UserDto;
import edu.ntut.eatogo.dbfactory.factory.RandomUserFactory;
import edu.ntut.eatogo.dbfactory.persistence.entity.User;
import edu.ntut.eatogo.dbfactory.persistence.repository.UserRepository;
import edu.ntut.eatogo.dbfactory.persistence.repository.UserStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private RandomUserFactory randomUserFactory;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserStatusRepository userStatusRepository;

    @Autowired
    private DomainDtoConverter domainDtoConverter;

    @Transactional
    public void insertRandomUser() {
        List<User> users = Lists.newArrayList();
        for (int number = 1; number <= 100; number++) {
            User user = domainDtoConverter.convertToDomain(randomUserFactory.generateRandomUser());
            user.setUserStatus(userStatusRepository.getOne(user.getUserStatus().getStatusType()));
            users.add(user);
        }
        userRepository.saveAll(users);
    }

    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(domainDtoConverter::convertToDto).collect(Collectors.toList());
    }
}
