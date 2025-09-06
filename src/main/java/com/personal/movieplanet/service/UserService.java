package com.personal.movieplanet.service;


import com.personal.movieplanet.entity.User;
import com.personal.movieplanet.repository.UserRepository;
import com.personal.movieplanet.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserDto addUser(UserDto userResource) {

        if (userRepository.existsByMobile(userResource.getMobile())) {
            return userResource;
        }

		User user = User.toEntity(userResource);

        user = userRepository.save(user);

        log.info("Added New User"+user.toString());

        return User.toResource(user);
    }


    public UserDto getUser(long id) {
        Optional<User> userEntity = userRepository.findById(id);

        if (userEntity.isEmpty()) {
            log.error("User not found for id: " + id);
            throw new EntityNotFoundException("User Not Found with ID: " + id);

        }

        return User.toResource(userEntity.get());
    }

}