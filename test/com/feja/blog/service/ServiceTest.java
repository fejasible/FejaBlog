package com.feja.blog.service;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.feja.blog.model.Article;
import com.feja.blog.model.ArticleType;
import com.feja.blog.model.ConfigWithBLOBs;
import com.feja.blog.model.Recommend;
import com.feja.blog.model.Type;

public class ServiceTest extends TestService{
	
	@Resource
	private Service service;
	
	@Test
	public void testGetConfig() {
		ConfigWithBLOBs config = service.getConfig(1);
		Assert.assertTrue(1 == config.getConfigId());
		Assert.assertEquals("Feja", config.getBlogName());
		Assert.assertEquals("describe", config.getBlogDescribe());
		Assert.assertEquals("copyright", config.getCopyright());
		Assert.assertEquals("username", config.getUsername());
		Assert.assertEquals("password", config.getPassword());
		Assert.assertEquals("profile", config.getProfile());
	}

	@Test
	public void testGetArticle() {
		Article article = service.getArticle(1);
		Assert.assertTrue(1 == article.getArticleId());
		Assert.assertEquals("标题", article.getTitle());
		Assert.assertEquals("内容", article.getContent());
		Assert.assertTrue(0 == article.getIsDelete());
		Assert.assertTrue(0 == article.getIsDraft());
		Assert.assertTrue(0 == article.getVisible());
	}

	@Test
	public void testGetType() {
		Type type = service.getType(1);
		Assert.assertTrue(1 == type.getTypeId());
		Assert.assertEquals("java", type.getType());
	}

	@Test
	public void testGetArticleType() {
		ArticleType articleType = service.getArticleType(1);
		Assert.assertTrue(1 == articleType.getArticleTypeId());
		Assert.assertTrue(1 == articleType.getArticleId());
		Assert.assertTrue(1 == articleType.getTypeId());
	}

	@Test
	public void testGetRecommand() {
		Recommend recommend = service.getRecommand(1);
		Assert.assertTrue(1 == recommend.getArticleId());
		Assert.assertTrue(1 == recommend.getRecommendId());
	}

	@Test
	public void testGetAllRecommandArticles() {
		ArrayList<Article> articles = service.getAllRecommandArticles();
		Assert.assertTrue(articles.size() > 0);
		for(Article article: articles){
			Assert.assertNotNull(article.getTitle());
		}
	}

	@Test
	public void testGetArticlesByTypeString() {
		ArrayList<Article> articles = service.getArticlesByType("java");
		Assert.assertTrue(articles.size() > 0);
		for(Article article: articles){
			Assert.assertNotNull(article.getTitle());
		}
	}

	@Test
	public void testGetArticlesByTypeInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetArticlesByDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllTypes() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllDates() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidate() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddArticle() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditArticle() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveArticle() {
		fail("Not yet implemented");
	}

	@Test
	public void testRecycleArticle() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddTypeToArticleIntString() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddTypeToArticleIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateArticleVisible() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateArticleToRecommand() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddType() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditType() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteType() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateTypeVisible() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateBlogName() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateBlogDescribe() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateCopyRight() {
		fail("Not yet implemented");
	}

	@Test
	public void testRecoverArticle() {
		fail("Not yet implemented");
	}

	@Test
	public void testDestroyArticle() {
		fail("Not yet implemented");
	}

}
