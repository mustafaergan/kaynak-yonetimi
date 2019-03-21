package com.mustafaergan.microservis.oauth.entity;

import com.mustafaergan.microservis.oauth.entity.enums.RoleEnum;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * @author Mustafa.Ergan
 */
@Entity
@Table(name = "ROLE")
@Data
public class Role {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;


    @Column(name="ROLE_NAME", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;

    @ManyToMany(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
    @JoinTable(name="ROLE_PRIVILEGE",
            joinColumns = {@JoinColumn(name="ROLE_ID", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="PRIVILEGE_ID", referencedColumnName="id")}
    )
    private List<Privilege> privilegeList;

}
