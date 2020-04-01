package com.kwu.propictures.repository;

import com.kwu.propictures.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//https://www.youtube.com/watch?v=TNt3GHuayXs&t=71s
public interface SecurityRepository extends JpaRepository<User, Long> {

//    Optional<User> findByUserName(String userName)
}
