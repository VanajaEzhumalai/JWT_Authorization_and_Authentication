package com.jwt.ServicesTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jwt.entity.Role;
import com.jwt.service.RoleService;

@SpringBootTest
public class RoleServiceTest {

	@Autowired
	private RoleService roleService;
	
	@Test
	public void createNewRoleTesting() {
		Role role1 = new Role();
		role1.setRoleDescription("Can Do anything");
		role1.setRoleName("Admin");

//		Role role2 = new Role();
//		role2.setRoleDescription("User can view the dashboard");
//		role2.setRoleName("User");
//		
//		Role role3= new Role();
//		role3.setRoleDescription("User can view the dashboard");
//		role3.setRoleName("User");

		assertEquals(role1.getRoleName(),roleService.createNewRole(role1).getRoleName());
//		assertEquals(role2.getRoleDescription(),roleService.createNewRole(role2).getRoleDescription());
//		assertEquals(role3.getRoleName(),roleService.createNewRole(role3).getRoleName());

	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
}
