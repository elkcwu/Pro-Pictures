package com.kwu.propictures.service;

import com.kwu.propictures.model.User;
import com.kwu.propictures.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.transaction.Transactional;

@Service
@EnableSwagger2
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addNewUser(User user){
        return userRepository.save(user);
    }

}
