package com.mustafaergan.microservis.common.security.enums;

/**
 * @author Mustafa.Ergan
 */
public enum PrivilegeEnum {
    ROLE_READ("READ"),
    ROLE_WRITE("WRITE"),
    ROLE_CLIENT("CLIENT");

    private String role;

    PrivilegeEnum(String role) {
        this.role = role;
    }

}
