package com.jwt.ServicesTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jwt.dao.UserDao;
import com.jwt.entity.Role;
import com.jwt.entity.User;
import com.jwt.service.UserService;

@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@MockBean
	private UserDao userDao;
	
	@Mock
	private PasswordEncoder passwordEncoder;
	
	@Test
	@DisplayName("Junit fail!!")
	public void registerNewUserTest() {

		User user = new User();
		user.setUserFirstName("First Name");
		user.setUserLastName("User");
		user.setUserName("UserName");
		user.setUserPassword("UserPassword");
		user.setEmail("UserEmail@gmail.com");
		user.setPhoneNumber("6587236872");
		when(userDao.save(user)).thenReturn(user);
		assertEquals(user.getUserLastName(), userService.registerNewUser(user).getUserLastName());
	}

	@Test
	@DisplayName("Junit fail!!")
	public void allUsersTest() {
		
		Role role = new Role();
		role.setRoleName("User");
		role.setRoleDescription("User can view the application");
		Set<Role> roleSet1 = new HashSet<>();
		roleSet1.add(role);
		User user = new User("Vanaja@123","Vanaja","Ezhumalai","Vanaja31122001@gmail.com","723865328756","Vanaja@123");
		user.setRole(roleSet1);
		when(userDao.findAll()).thenReturn(Stream.of(user).collect(Collectors.toList()));
		assertEquals(1, userService.allUsers().size());
	}
	@Test
	public void registerNewAdminTest() {

		User Admin = new User();
		Admin.setUserFirstName("First Name");
		Admin.setUserLastName("Admin");
		Admin.setUserName("AdminName");
		Admin.setUserPassword("AdminPassword");
		Admin.setEmail("AdminEmail@gmail.com");
		Admin.setPhoneNumber("6587236872");
		when(userDao.save(Admin)).thenReturn(Admin);
		assertEquals(Admin.getUserLastName(), userService.registerNewUser(Admin).getUserLastName());
	}
	@Test
	public void allAdminTest() {
		
		Role admin = new Role();
		admin.setRoleName("User");
		admin.setRoleDescription("User can view the application");
		Set<Role> roleSet1 = new HashSet<>();
		roleSet1.add(admin);
		User admins = new User("Vanaja@123","Vanaja","Ezhumalai","Vanaja31122001@gmail.com","723865328756","Vanaja@123");
		admins.setRole(roleSet1);
		when(userDao.findAll()).thenReturn(Stream.of(admins).collect(Collectors.toList()));
		assertEquals(1, userService.allUsers().size());
	}
	

}
