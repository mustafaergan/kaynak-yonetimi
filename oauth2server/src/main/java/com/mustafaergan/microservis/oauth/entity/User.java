package com.mustafaergan.microservis.oauth.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.List;

/**
 * @author Mustafa.Ergan
 */
@Entity
@Table(name = "USER")
@Data
public class User {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column(name="USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name="PASSWORD", nullable = false)
    private String password;

    @ManyToMany(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
    @JoinTable(name="USER_ROLE",
            joinColumns = {@JoinColumn(name="USER_ID", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="ROLE_ID", referencedColumnName="id")}
    )
    private List<Role> roleList;

}
