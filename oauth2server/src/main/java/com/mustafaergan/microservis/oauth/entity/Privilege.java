package com.mustafaergan.microservis.oauth.entity;

import com.mustafaergan.microservis.oauth.entity.enums.PrivilegeEnum;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Mustafa.Ergan
 */
@Entity
@Table(name = "PRIVILEGE")
@Data
public class Privilege {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column(name="PRIVILEGE_NAME", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private PrivilegeEnum privilegeEnum;
}
