package com.jwt.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.dao.RoleDao;
import com.jwt.dao.UserDao;
import com.jwt.entity.Role;
import com.jwt.entity.User;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {
    	//
//    	        Role adminRole = new Role();
////    	        adminRole.setRoleName("Admin");
////    	        adminRole.setRoleDescription("Admin role");
////    	        roleDao.save(adminRole);
    	////
////    	        Role userRole = new Role();
////    	        userRole.setRoleName("User");
////    	        userRole.setRoleDescription("Default role for newly created record");
////    	        roleDao.save(userRole);
    	//
//    	        User adminUser = new User();
//    	        adminUser.setUserName("admin123");
//    	        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
//    	        adminUser.setUserFirstName("admin");
//    	        adminUser.setUserLastName("admin");
//    	        adminUser.setEmail("Admin123@gmail.com");
//    	        adminUser.setPhoneNumber("8754885240");
//    	        Set<Role> adminRoles = new HashSet<>();
//    	        adminRoles.add(adminRole);
//    	        adminUser.setRole(adminRoles);
//    	        userDao.save(adminUser);
    	//
////    	        User user = new User();
////    	        user.setUserName("vanaja123");
////    	        user.setUserPassword(getEncodedPassword("vanaja@123"));
////    	        user.setUserFirstName("vanaja");
////    	        user.setUserLastName("ezhumalai");
////    	        user.setEmail("Admin123@gmail.com");
////    	        user.setPhoneNumber("8754885240");
////    	        Set<Role> userRoles = new HashSet<>();
////    	        userRoles.add(userRole);
////    	        user.setRole(userRoles);
////    	        userDao.save(user);
    	    }

    public User registerNewUser(User user) {
        Role role = roleDao.findById(user.getUserLastName()).get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
    public List<User> allUsers() {
    	return (List<User>) userDao.findAll();
    }
    public void deleteUsers(String roleName) {
    	List<User> users=userDao.findByUserLastName(roleName);
    	userDao.deleteAll(users);
    	System.out.println("From User Table Deleted Successfully");
    }

}
