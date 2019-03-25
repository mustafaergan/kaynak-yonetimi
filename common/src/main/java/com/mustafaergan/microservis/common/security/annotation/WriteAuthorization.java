package com.mustafaergan.microservis.common.security.annotation;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.*;

/**
 * @author Mustafa.Ergan
 *
 * //    @PreAuthorize("#oauth2.hasScope('WRITE')")
 * //    @PreAuthorize("@securityService.hasPermission('ROLE_WRITE')")
 *
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@PreAuthorize("hasRole('ROLE_WRITE')")
public @interface WriteAuthorization {
}