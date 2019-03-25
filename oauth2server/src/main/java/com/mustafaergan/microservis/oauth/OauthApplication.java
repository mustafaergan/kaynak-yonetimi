package com.mustafaergan.microservis.oauth;

import com.mustafaergan.microservis.oauth.entity.Privilege;
import com.mustafaergan.microservis.oauth.entity.Role;
import com.mustafaergan.microservis.oauth.entity.User;
import com.mustafaergan.microservis.oauth.entity.enums.PrivilegeEnum;
import com.mustafaergan.microservis.oauth.entity.enums.RoleEnum;
import com.mustafaergan.microservis.oauth.repository.PrivilegeRepository;
import com.mustafaergan.microservis.oauth.repository.RoleRepository;
import com.mustafaergan.microservis.oauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.util.Arrays;


@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
public class OauthApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PrivilegeRepository privilegeRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(OauthApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception {

		Privilege privilege = new Privilege();
		privilege.setPrivilegeEnum(PrivilegeEnum.ROLE_WRITE);
		privilegeRepository.save(privilege);

		Privilege privilege2= new Privilege();
		privilege2.setPrivilegeEnum(PrivilegeEnum.ROLE_READ);
		privilegeRepository.save(privilege2);


		Privilege privilege3= new Privilege();
		privilege3.setPrivilegeEnum(PrivilegeEnum.ROLE_CLIENT);
		privilegeRepository.save(privilege3);


		Role role = new Role();
		role.setRoleEnum(RoleEnum.ADMIN);
		role.setPrivilegeList(Arrays.asList(privilege,privilege2));
		roleRepository.save(role);
		role = roleRepository.findByRoleEnum(RoleEnum.ADMIN);



		Role role2 = new Role();
		role2.setRoleEnum(RoleEnum.USER);
		role2.setPrivilegeList(Arrays.asList(privilege2,privilege3));
		roleRepository.save(role2);
		role2 = roleRepository.findByRoleEnum(RoleEnum.USER);



		User user = new User();
		user.setUsername("admin");
		user.setPassword(passwordEncoder.encode("admin"));
		user.setRoleList(Arrays.asList(role));
		userRepository.save(user);

		User user2 = new User();
		user2.setUsername("mustafa");
		user2.setPassword(passwordEncoder.encode("mustafa"));
		user2.setRoleList(Arrays.asList(role2));
		userRepository.save(user2);
	}

}
