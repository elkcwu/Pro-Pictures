package com.kwu.propictures.repository;

import com.kwu.propictures.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
//https://www.youtube.com/watch?v=TNt3GHuayXs&t=71s

@Repository
public interface SecurityRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String userName);
}
