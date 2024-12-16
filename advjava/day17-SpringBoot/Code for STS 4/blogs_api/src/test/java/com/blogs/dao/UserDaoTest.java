package com.blogs.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.blogs.pojos.User;
import com.blogs.pojos.UserRole;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)//DB - MySQL
class UserDaoTest {
	//depcy - dao 
	@Autowired
	private UserDao userDao;

	@Test
	void testFindByEmailAndPassword() {
		//invoke method
		User user =
				userDao.findByEmailAndPassword
				("a2@gmail.com", "23456").orElseThrow();
		assertEquals(UserRole.ADMIN,user.getRole());
	}

}
