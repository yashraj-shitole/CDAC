package com.blogs.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.blogs.pojos.BlogPost;

@DataJpaTest//enables Entity n DAO layer
@AutoConfigureTestDatabase(replace = Replace.NONE) // continue to use same database , 
//(Mysql) as configured in the main app
class BlogPostDaoTest {
	//depcy 
	@Autowired
	private BlogPostDao blogPostDao;

	@Test
	void testFindByStatusTrueAndBloggerIdAndBlogCategoryId() {
		List<BlogPost> posts = blogPostDao.findByStatusTrueAndBloggerIdAndBlogCategoryId(1l, 1l);
		assertEquals(2, posts.size());
	}

}
