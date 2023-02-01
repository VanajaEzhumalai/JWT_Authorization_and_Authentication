package com.jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jwt.controller.UserController;
import com.jwt.entity.User;

@SpringBootTest
public class ControllersTesting {
	@Autowired
	private UserController userController;
	
	@BeforeEach
	public void testBefore(){
		System.out.println("ok from Junit Test");
	}
	
	@Test
	@DisplayName("Junit fail!!")
	public void me() {
		assertEquals(1,1);
	}

	public UserController getUserController() {
		return userController;
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}
	
//	//User Controller [Testing for new user]
	@Test
	@DisplayName("Junit fail!!")
	public void registerNewUserTest() {
		User user=new User("Vanaja@123","Vanaja","Admin","Vanaja31122001@gmail.com","8754885240","Vanaja@123");
		assertEquals(user.getUserFirstName(),userController.registerNewUser(user).getUserFirstName());
	}
	
	@Test
	@DisplayName("Junit fail!!")
	public void registerNewUserTests() {
		User user=new User("Kavya123","Kavya","User","Kavya@gmail.com","9021987510","Kavya");
		assertEquals(user.getEmail(),userController.registerNewUser(user).getEmail());
	}
	
}
