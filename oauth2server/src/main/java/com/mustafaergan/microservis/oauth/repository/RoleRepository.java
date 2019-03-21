package com.mustafaergan.microservis.oauth.repository;

import com.mustafaergan.microservis.oauth.entity.Role;
import com.mustafaergan.microservis.oauth.entity.User;
import com.mustafaergan.microservis.oauth.entity.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mustafa.Ergan
 */
public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByRoleEnum(RoleEnum roleEnum);
}

