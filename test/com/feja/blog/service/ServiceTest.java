package com.feja.blog.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.format.datetime.DateFormatter;

import com.feja.blog.constant.BlogConstant;
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
		ArticleType articleType = service.getArticleType(7);
		Assert.assertTrue(7 == articleType.getArticleTypeId());
		Assert.assertTrue(5 == articleType.getArticleId());
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
		ArrayList<Article> articles = service.getArticlesByType("java");
		Assert.assertTrue(articles.size() > 0);
		for(Article article: articles){
			Assert.assertNotNull(article.getTitle());
		}
	}

	@Test
	public void testGetArticlesByDate() throws Exception{
		Date date = new Date();
		DateFormatter dateFormatter = new DateFormatter("yyyy-MM");
		date = dateFormatter.parse("2017-03", LocaleContextHolder.getLocale());
		ArrayList<Article> articles = service.getArticlesByDate(date);
		Assert.assertTrue(articles.size() > 0);
		for(Article article: articles){
			Assert.assertNotNull(article.getTitle());
		}
	}

	@Test
	public void testGetAllTypes() {
		ArrayList<String[]> strings = service.getAllTypesSorted();
		Assert.assertTrue(strings.size() > 0);
		for(String[] string: strings){
			Assert.assertNotNull(string[0]);
			Assert.assertNotNull(string[1]);
		}
	}

	@Test
	public void testGetAllDates() {
		ArrayList<String[]> strings = service.getAllDatesSorted();
		Assert.assertTrue(strings.size() > 0);
		for(String[] string: strings){
			Assert.assertNotNull(string[0]);
			Assert.assertNotNull(string[1]);
		}
	}

	@Test
	public void testValidate() {
		boolean result = service.validate("username", "password");
		Assert.assertTrue(result);
	}

	@Test
	public void testAddArticle() {
		Article article = new Article();
		article.setTitle("title");
		article.setContent("content");
		int id = service.addArticle(article);
		Assert.assertTrue(id > 0);
	}

	@Test
	public void testEditArticle() {
		int id = service.addArticle(new Article());
		Article article = service.getArticle(id);
		service.editArticle(article);
		Article editedArticle = service.getArticle(article.getArticleId());
		Assert.assertEquals(article.getTitle(), editedArticle.getTitle());
		Assert.assertEquals(article.getContent(), editedArticle.getContent());
		service.destroyArticle(id);
		
	}

	@Test
	public void testSaveArticle() {
		int id = service.addArticle(new Article());
		Article article = service.getArticle(id);
		boolean result = service.saveArticleAsDraft(article);
		Assert.assertTrue(result);
		article = service.getArticle(id);
		Assert.assertTrue(BlogConstant.IS_DRAFT == article.getIsDraft());
		service.destroyArticle(id);
	}

	@Test
	public void testRecycleArticle() {
		boolean result = service.recycleArticle(8, BlogConstant.IS_NOT_DELETE);
		Assert.assertTrue(result);
		
	}

	@Test
	public void testAddTypeToArticleIntString() {
		int articleId = 10;
		String typeString = "java";
		int id = service.addTypeToArticle(articleId, typeString);
		ArticleType articleType = service.getArticleType(id);
		Assert.assertTrue(articleId == articleType.getArticleId());
		Assert.assertTrue(typeString.equals(service.getType(articleType.getTypeId()).getType()));
	}

	@Test
	public void testAddTypeToArticleIntInt() {
		int articleId = 8;
		int typeId = 1;
		int id = service.addTypeToArticle(articleId, typeId);
		ArticleType articleType = service.getArticleType(id);
		Assert.assertTrue(articleId == articleType.getArticleId());
		Assert.assertTrue(typeId == articleType.getTypeId());
		int removeId = service.removeTypeFromArticle(articleId, typeId);
		Assert.assertTrue(id == removeId);
		
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
		Article article = new Article();
		article.setTitle("titleWillDestroy");
		int id = service.addArticle(article);
		service.destroyArticle(id);
	}

}
