package com.kwu.propictures.repository;

import com.kwu.propictures.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityRepository extends JpaRepository<User, Long> {
}
