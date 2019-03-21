package com.mustafaergan.microservis.oauth.repository;

import com.mustafaergan.microservis.oauth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mustafa.Ergan
 */
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}

