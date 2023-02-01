package com.jwt.ServicesTesting;

import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jwt.entity.JwtRequest;
import com.jwt.service.JwtService;

@SpringBootTest
public class JwtServiceTest {

	@Autowired
	private JwtService jwtService;

	@Test
	@DisplayName("Junit fail!!")
	public void TestCreateJwtToken() throws Exception {
		JwtRequest jwtRequest = new JwtRequest();
		jwtRequest.setUserName(anyString());
		jwtRequest.setUserPassword(anyString());
	}

	public JwtService getJwtService() {
		return jwtService;
	}

	public void setJwtService(JwtService jwtService) {
		this.jwtService = jwtService;
	}
	
}
