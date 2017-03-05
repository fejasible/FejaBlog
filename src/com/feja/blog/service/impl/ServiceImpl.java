package com.feja.blog.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.Spring;

import com.feja.blog.context.SpringContextHolder;
import com.feja.blog.mapper.ArticleMapper;
import com.feja.blog.mapper.ArticleTypeMapper;
import com.feja.blog.mapper.ConfigMapper;
import com.feja.blog.mapper.RecommendMapper;
import com.feja.blog.mapper.TypeMapper;
import com.feja.blog.model.Article;
import com.feja.blog.model.ArticleExample;
import com.feja.blog.model.ArticleType;
import com.feja.blog.model.ArticleTypeExample;
import com.feja.blog.model.Config;
import com.feja.blog.model.ConfigWithBLOBs;
import com.feja.blog.model.Recommend;
import com.feja.blog.model.RecommendExample;
import com.feja.blog.model.Type;
import com.feja.blog.model.TypeExample;
import com.feja.blog.service.Service;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

	@Override
	public ConfigWithBLOBs getConfig(int configId) {
		ConfigMapper configMapper = SpringContextHolder.getBean("configMapper");
		ConfigWithBLOBs config = configMapper.selectByPrimaryKey(configId);
		return config;
	}

	@Override
	public Article getArticle(int articleId) {
		ArticleMapper articleMapper = SpringContextHolder.getBean("articleMapper");
		Article article = articleMapper.selectByPrimaryKey(articleId);
		return article;
	}

	@Override
	public Type getType(int typeId) {
		TypeMapper typeMapper = SpringContextHolder.getBean("typeMapper");
		Type type = typeMapper.selectByPrimaryKey(typeId);
		return type;
	}

	@Override
	public ArticleType getArticleType(int articleTypeId) {
		ArticleTypeMapper articleTypeMapper = SpringContextHolder.getBean("articleTypeMapper");
		ArticleType articleType = articleTypeMapper.selectByPrimaryKey(articleTypeId);
		return articleType;
	}

	@Override
	public Recommend getRecommand(int recommendId) {
		RecommendMapper recommendMapper = SpringContextHolder.getBean("recommendMapper");
		Recommend recommend = recommendMapper.selectByPrimaryKey(recommendId);
		return recommend;
	}
	
	@Override
	public ArrayList<Article> getAllRecommandArticles() {
		List<Integer> articleIds = getAllrecommandArticleIds();
		ArticleExample articleExample = new ArticleExample();
		ArticleMapper articleMapper = SpringContextHolder.getBean("articleMapper");
		articleExample.or().andArticleIdIn(articleIds);
		List<Article> articles = articleMapper.selectByExample(articleExample);
		return (ArrayList<Article>) articles;
	}
	
	/**
	 * 从recommend中获取所有article的id
	 * @return
	 */
	public List<Integer> getAllrecommandArticleIds(){
		RecommendExample recommendExample = new RecommendExample();
		RecommendMapper recommendMapper = SpringContextHolder.getBean("recommendMapper");
		List<Recommend> recommends = recommendMapper.selectByExample(recommendExample);
		List<Integer> articleIds = new ArrayList<Integer>();
		for(Recommend recommend: recommends){
			articleIds.add(recommend.getArticleId());
		}
		return articleIds;
		
	}
	

	@Override
	public ArrayList<Article> getArticlesByType(String type) {
		int typeId = getTypeIdByTypeString(type);
		List<Integer> articleIds = getArticleIdsByTypeId(typeId);
		ArticleMapper articleMapper = SpringContextHolder.getBean("articleMapper");
		ArticleExample articleExample = new ArticleExample();
		articleExample.or().andArticleIdIn(articleIds);
		List<Article> articles = articleMapper.selectByExample(articleExample);
		return (ArrayList<Article>) articles;
	}
	
	/**
	 * 通过type string获取type id
	 * @param type
	 * @return
	 */
	public int getTypeIdByTypeString(String type){
		TypeExample typeExample = new TypeExample();
		TypeMapper typeMapper = SpringContextHolder.getBean("typeMapper");
		typeExample.or().andTypeEqualTo(type);
		typeExample.setDistinct(true);
		List<Type> types = typeMapper.selectByExample(typeExample);
		if(type == null || types.size() < 1){
			return 0;
		}
		int typeId = types.get(0).getTypeId();
		return typeId;
	}
	
	/**
	 * 获取某一分类的所有文章的id
	 * @param typeId
	 * @return
	 */
	public List<Integer> getArticleIdsByTypeId(int typeId){
		ArticleTypeMapper articleTypeMapper = SpringContextHolder.getBean("articleTypeMapper");
		ArticleTypeExample articleTypeExample = new ArticleTypeExample();
		articleTypeExample.or().andTypeIdEqualTo(typeId);
		List<ArticleType> articleTypes = articleTypeMapper.selectByExample(articleTypeExample);
		List<Integer> articleIds = new ArrayList<>();
		for(ArticleType articleType: articleTypes){
			articleIds.add(articleType.getArticleId());
		}
		return articleIds;
		
	}
	

	@Override
	public ArrayList<Article> getArticlesByType(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Article> getArticlesByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String[]> getAllTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String[]> getAllDates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validate(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addArticle(Article article) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean editArticle(Article article) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveArticle(Article article) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recycleArticle(int articleId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addTypeToArticle(int articleId, String type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addTypeToArticle(int articleId, int typeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateArticleVisible(Article article, boolean visible) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateArticleToRecommand(Article article, boolean recommand) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addType(String type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editType(Type type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteType(Type type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTypeVisible(Type type, boolean visible) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBlogName(String blogName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBlogDescribe(String describe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCopyRight(String copyright) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recoverArticle(Article article) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean destroyArticle(int articleId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
