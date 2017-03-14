package com.feja.blog.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.format.datetime.DateFormatter;

import com.feja.blog.constant.BlogConstant;
import com.feja.blog.model.Article;
import com.feja.blog.model.ArticleType;
import com.feja.blog.model.Config;
import com.feja.blog.model.ConfigWithBLOBs;
import com.feja.blog.model.Recommend;
import com.feja.blog.model.Type;

public class ServiceTest extends TestService{
	
	
	@Test
	public void testGetConfig() {
		ConfigWithBLOBs config = service.getConfig(BlogConstant.USED_CONFIG);
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
		Article article = service.getArticle(testArticle.getArticleId());
		Assert.assertTrue(article != null);
	}

	@Test
	public void testGetType() {
		Type type = service.getType(testType.getTypeId());
		Assert.assertTrue(type != null);
	}

	@Test
	public void testGetArticleType() {
		int id = service.addTypeToArticle(testArticle.getArticleId(), testType.getTypeId());
		ArticleType articleType = service.getArticleType(id);
		Assert.assertTrue(articleType != null);
		Assert.assertTrue(articleType.getArticleTypeId() == id);
		Assert.assertEquals(articleType.getArticleId(), testArticle.getArticleId());
		Assert.assertEquals(articleType.getTypeId(), testType.getTypeId());
		service.removeTypeFromArticle(testArticle.getArticleId(), testType.getTypeId());
		articleType = service.getArticleType(id);
		Assert.assertTrue(articleType == null);
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
		ArrayList<Article> articles = service.getArticlesByType(testType.getType());
		if(articles != null){
			for(Article article: articles){
				Assert.assertNotNull(article.getTitle());
			}
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
		service.destroyArticle(id);
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
		int id = service.addArticle(new Article());
		boolean result = service.recycleArticle(id, BlogConstant.IS_NOT_DELETE);
		Assert.assertTrue(result);
		result = service.recycleArticle(id, BlogConstant.IS_DELETE);
		Assert.assertTrue(result);
		service.destroyArticle(id);
		
	}

	@Test
	public void testAddTypeToArticleIntString() {
		int id = service.addTypeToArticle(testArticle.getArticleId(), testType.getType());
		ArticleType articleType = service.getArticleType(id);
		Assert.assertEquals(testArticle.getArticleId(), articleType.getArticleId());
		Assert.assertTrue(testType.getType().equals(service.getType(articleType.getTypeId()).getType()));
		service.removeTypeFromArticle(testArticle.getArticleId(), testType.getTypeId());
	}

	@Test
	public void testAddTypeToArticleIntInt() {
		int articleId = testArticle.getArticleId();
		String typeString = testType.getType();
		int typeId = testType.getTypeId();
		int id = service.addTypeToArticle(articleId, typeId);
		ArticleType articleType = service.getArticleType(id);
		Assert.assertTrue(articleId == articleType.getArticleId());
		Assert.assertTrue(typeString.equals(service.getType(articleType.getTypeId()).getType()));
	}
	
	@Test
	public void testUpdateArticleVisible() {
		int articleId = service.addArticle(new Article());
		service.updateArticleVisible(articleId, true);
		int result = service.getArticle(articleId).getVisible();
		Assert.assertTrue(result == BlogConstant.IS_VISIBLE);
		service.updateArticleVisible(articleId, false);
		result = service.getArticle(articleId).getVisible();
		Assert.assertTrue(result == BlogConstant.IS_NOT_VISIBLE);
		service.destroyArticle(articleId);
	}

	@Test
	public void testUpdateArticleToRecommand() {
		int articleId = service.addArticle(new Article());
		Assert.assertTrue(service.updateArticleToRecommend(articleId, true));
		Assert.assertTrue(service.isArticleRecommend(articleId) == true);
		Assert.assertTrue(service.updateArticleToRecommend(articleId, false));
		Assert.assertTrue(service.isArticleRecommend(articleId) == false);
		service.destroyArticle(articleId);
		
		
	}

	@Test
	public void testAddType() {
		String typeString = "java" + new Random().nextInt();
		int id = service.addType(typeString);
		Type type = service.getType(id);
		Assert.assertTrue(type != null);
		Assert.assertTrue(type.getType().equals(typeString));
		Assert.assertTrue(type.getTypeId() == id);
		
		int id2 = service.addType(typeString);
		type = service.getType(id2);
		Assert.assertTrue(type == null);
		service.deleteType(id);
	}

	@Test
	public void testEditType() {
		String typeString = "java" + new Random().nextInt();
		String typeStringEdit = typeString + "edit";
		int id = service.addType(typeString);
		Type type = service.getType(id);
		type.setType(typeStringEdit);
		Assert.assertTrue(service.editType(type));
		type = service.getType(id);
		Assert.assertTrue(type.getType().equals(typeStringEdit));
		service.deleteType(id);
	}

	@Test
	public void testDeleteType() {
		String typeString = "java" + new Random().nextInt();
		int id = service.addType(typeString);
		service.deleteType(id);
		Type type = service.getType(id);
		Assert.assertTrue(type == null);
	}

	
	@Test
	public void testUpdateTypeVisible() {
		service.updateTypeVisible(testType.getTypeId(), true);
		service.updateTypeVisible(testType.getTypeId(), false);
	}

	@Test
	public void testUpdateBlogName() {
		Config config = service.getConfig(BlogConstant.USED_CONFIG);
		String blogOriginName = config.getBlogName();
		String blogName = "testBlogName";
		service.updateBlogName(blogName);
		Assert.assertTrue(service.getConfig(BlogConstant.USED_CONFIG).getBlogName().equals(blogName));
		service.updateBlogName(blogOriginName);
		Assert.assertTrue(service.getConfig(BlogConstant.USED_CONFIG).getBlogName().equals(blogOriginName));
		
	}

	@Test
	public void testUpdateBlogDescribe() {
		ConfigWithBLOBs config = service.getConfig(BlogConstant.USED_CONFIG);
		String blogOriginDescribe = config.getBlogDescribe();
		String blogDescribe = "testBlogDescribe";
		service.updateBlogDescribe(blogDescribe);
		Assert.assertTrue(service.getConfig(BlogConstant.USED_CONFIG).getBlogDescribe().equals(blogDescribe));
		service.updateBlogDescribe(blogOriginDescribe);
		Assert.assertTrue(service.getConfig(BlogConstant.USED_CONFIG).getBlogDescribe().equals(blogOriginDescribe));
	}

	@Test
	public void testUpdateCopyRight() {
		ConfigWithBLOBs config = service.getConfig(BlogConstant.USED_CONFIG);
		String blogOriginCopyright = config.getCopyright();
		String blogCopyright = "testCopyright";
		service.updateCopyRight(blogCopyright);
		Assert.assertTrue(service.getConfig(BlogConstant.USED_CONFIG).getCopyright().equals(blogCopyright));
		service.updateCopyRight(blogOriginCopyright);
		Assert.assertTrue(service.getConfig(BlogConstant.USED_CONFIG).getCopyright().equals(blogOriginCopyright));
	}

	@Test
	public void testDeleteArticle() {
		int status = testArticle.getIsDelete();
		service.deleteArticle(testArticle.getArticleId(), true);
		Assert.assertTrue(service.getArticle(testArticle.getArticleId()).getIsDelete() == BlogConstant.IS_DELETE);
		service.deleteArticle(testArticle.getArticleId(), false);
		Assert.assertTrue(service.getArticle(testArticle.getArticleId()).getIsDelete() == BlogConstant.IS_NOT_DELETE);
		service.deleteArticle(testArticle.getArticleId(), status == BlogConstant.IS_DELETE ? true: false);
	}

	@Test
	public void testDestroyArticle() {
		Article article = new Article();
		article.setTitle("titleWillDestroy");
		int id = service.addArticle(article);
		service.destroyArticle(id);
	}
	
}
