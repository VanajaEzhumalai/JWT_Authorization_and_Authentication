package com.jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class RepoTesting {
	@Test
	@DisplayName("Junit fail!!")
	public void test1() {
		assertEquals(1,1);
	}
	
}
