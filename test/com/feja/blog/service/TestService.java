package com.feja.blog.service;

import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.feja.blog.model.Article;
import com.feja.blog.model.Type;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:WebContent/WEB-INF/config/springmvc-config.xml")
public class TestService {
	
	@Resource
	protected Service service;
	
	protected Article testArticle;
	protected Type testType;
	
	@Before
	public void setUp(){
		int articleId = service.addArticle(createTestArticle());
		int typeId = service.addType(createTestType().getType());
		testArticle = service.getArticle(articleId);
		testType = service.getType(typeId);
	}
	
	@After
	public void tearDown(){
		service.destroyArticle(testArticle.getArticleId());
		service.deleteType(testType.getTypeId());
	}
	
	private Article createTestArticle(){
		Article article = new Article();
		article.setTitle("testTitle");
		article.setContent("testContent");
		return article;
	}
	
	private Type createTestType(){
		Type type = new Type();
		type.setType("java" + new Random().nextInt() + UUID.randomUUID());
		return type;
	}
}
