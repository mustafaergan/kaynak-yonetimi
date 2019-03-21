package com.mustafaergan.microservis.oauth.repository;

import com.mustafaergan.microservis.oauth.entity.Privilege;
import com.mustafaergan.microservis.oauth.entity.enums.PrivilegeEnum;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mustafa.Ergan
 */
public interface PrivilegeRepository extends JpaRepository<Privilege, String> {
    Privilege findByPrivilegeEnum(PrivilegeEnum privilegeEnum);
}

