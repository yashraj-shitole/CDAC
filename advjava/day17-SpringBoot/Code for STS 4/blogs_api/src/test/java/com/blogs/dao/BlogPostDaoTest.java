package com.blogs.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.blogs.pojos.BlogPost;
import com.blogs.pojos.UserRole;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)//DB - MySQL
class BlogPostDaoTest {
	//depcy - dao 
	@Autowired
	private BlogPostDao blogPostDao;

	@Test
	void testFindAvailableBlogPostsByBlogger() {
		//invoker dao's method
		List<BlogPost> posts = blogPostDao.findByStatusTrueAndBloggerId(1l);
		assertEquals(2,posts.size());
	}

}
