package com.feja.blog.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.Spring;

import com.feja.blog.constant.BlogConstant;
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
import com.feja.blog.util.Util;

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
		int typeId = getTypeByTypeString(type).getTypeId();
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
	public Type getTypeByTypeString(String type){
		TypeExample typeExample = new TypeExample();
		TypeMapper typeMapper = SpringContextHolder.getBean("typeMapper");
		typeExample.or().andTypeEqualTo(type);
		typeExample.setDistinct(true);
		List<Type> types = typeMapper.selectByExample(typeExample);
		if(type == null || types.size() < 1){
			return null;
		}
		return types.get(0);
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
	public ArrayList<Article> getArticlesByType(int typeId) {
		List<Integer> articleIds = getArticleIdsByTypeId(typeId);
		ArticleMapper articleMapper = SpringContextHolder.getBean("articleMapper");
		ArticleExample articleExample = new ArticleExample();
		articleExample.or().andArticleIdIn(articleIds);
		List<Article> articles = articleMapper.selectByExample(articleExample);
		
		return (ArrayList<Article>) articles;
	}

	@Override
	public ArrayList<Article> getArticlesByDate(Date date) {
		ArticleMapper articleMapper = SpringContextHolder.getBean("articleMapper");
		ArticleExample articleExample = new ArticleExample();
		Calendar calendar = Calendar.getInstance(); 
	    calendar.setTime(date); 
	    calendar.add(Calendar.MONTH,1);
		Date afterDate = calendar.getTime();
		articleExample.or().andDateBetween(date, afterDate);
		List<Article> articles = articleMapper.selectByExample(articleExample);
		return (ArrayList<Article>) articles;
	}
	

	@Override
	public ArrayList<String[]> getAllTypesSorted() {
		List<Type> types = getAllTypes();
		ArrayList<String[]> typeSorted = new ArrayList<>();
		for(Type type: types){
			boolean isIntypeSorted = false;
			String typeString = type.getType();
			for(String[] count: typeSorted){
				if(count[0].equals(typeString)){
					isIntypeSorted = true;
					count[1] = String.valueOf(Integer.valueOf(count[1]) + 1);
				}
			}
			if(isIntypeSorted == false){
				typeSorted.add(new String[]{type.getType(), "1"});
			}
		}
		return typeSorted;
	}
	
	
	
	public List<Type> getAllTypes(){
		TypeExample typeExample = new TypeExample();
		TypeMapper typeMapper = SpringContextHolder.getBean("typeMapper");
		List<Type> types = typeMapper.selectByExample(typeExample);
		return types;
	}
	
	
	@Override
	public ArrayList<Article> getAllArticles(){
		ArticleMapper articleMapper = SpringContextHolder.getBean("articleMapper");
		ArticleExample articleExample = new ArticleExample();
		List<Article> articles = articleMapper.selectByExample(articleExample);
		return (ArrayList<Article>) articles;
	}
	

	@Override
	public ArrayList<String[]> getAllDatesSorted() {
		ArrayList<String[]> datesSorted = new ArrayList<>();
		ArrayList<Article> articles = getAllArticles();
		for(Article article: articles){
			String date = null;
			try {
				date = Util.dateToStringyyyy_MM(article.getDate());
			} catch (ParseException e) {
				e.printStackTrace();
				continue;
			}
			boolean isIndatesSorted = false;
			for(String[] count: datesSorted){
				if(date.equals(count[0])){
					isIndatesSorted = true;
					count[0] = String.valueOf(Integer.valueOf(count[1]) + 1);
				}
			}
			if(isIndatesSorted == false){
				datesSorted.add(new String[]{date, "1"});
			}
		}
		return datesSorted;
	}
	
	
	@Override
	public boolean validate(String username, String password) {
		Config config = getConfig(BlogConstant.USED_CONFIG);
		if(config.getUsername().equals(username) && config.getPassword().equals(password)){
			return true;
		}
		return false;
	}

	@Override
	public int addArticle(Article article) {
		if(article.getTitle() == null) article.setTitle("");
		if(article.getContent() == null) article.setContent("");
		if(article.getIsDraft() == null) article.setIsDraft(BlogConstant.IS_NOT_DRAFT);
		if(article.getIsDelete() == null) article.setIsDelete(BlogConstant.IS_NOT_DELETE);
		if(article.getVisible() == null) article.setVisible(BlogConstant.IS_VISIBLE);
		if(article.getDate() == null) article.setDate(new Date());

		ArticleMapper articleMapper = SpringContextHolder.getBean("articleMapper");
		articleMapper.insertSelective(article);
		return article.getArticleId();
	}

	@Override
	public boolean editArticle(Article article) {
		if(article.getArticleId() == null){
			return false;
		}
		ArticleMapper articleMapper = SpringContextHolder.getBean("articleMapper");
		articleMapper.updateByPrimaryKeySelective(article);
		return true;
	}

	@Override
	public boolean saveArticleAsDraft(Article article) {
		article.setIsDraft(BlogConstant.IS_DRAFT);
		if(article.getArticleId() == null){
			addArticle(article);
		}
		else{
			ArticleMapper articleMapper = SpringContextHolder.getBean("articleMapper");
			articleMapper.updateByPrimaryKeySelective(article);
		}
		return true;
	}

	@Override
	public boolean recycleArticle(int articleId, int isDelete) {
		ArticleMapper articleMapper = SpringContextHolder.getBean("articleMapper");
		Article article = articleMapper.selectByPrimaryKey(articleId);
		if(article == null){
			return false;
		}
		article.setIsDelete(isDelete);
		int impact = articleMapper.updateByPrimaryKeySelective(article);
		if(impact == 0){
			return false;
		}
		return true;
	}

	@Override
	public int addTypeToArticle(int articleId, String typeString) {
		Type type = getTypeByTypeString(typeString);
		if(type == null){
			return 0;
		}
		ArticleTypeMapper articleTypeMapper = SpringContextHolder.getBean("articleTypeMapper");
		ArticleTypeExample articleTypeExample = new ArticleTypeExample();
		articleTypeExample.or().andArticleIdEqualTo(articleId).andTypeIdEqualTo(type.getTypeId());
		List<ArticleType> articleTypes = articleTypeMapper.selectByExample(articleTypeExample);
		if(articleTypes == null || articleTypes.size() == 0){
			ArticleType articleType = new ArticleType();
			articleType.setArticleId(articleId);
			articleType.setTypeId(type.getTypeId());
			articleTypeMapper.insertSelective(articleType);
			return articleType.getArticleTypeId();
		}
		else{
			return 0;
		}
	}

	@Override
	public int addTypeToArticle(int articleId, int typeId) {
		ArticleTypeMapper articleTypeMapper = SpringContextHolder.getBean("articleTypeMapper");
		ArticleTypeExample articleTypeExample = new ArticleTypeExample();
		articleTypeExample.or().andArticleIdEqualTo(articleId).andTypeIdEqualTo(typeId);
		List<ArticleType> articleTypes = articleTypeMapper.selectByExample(articleTypeExample);
		if(articleTypes == null || articleTypes.size() == 0){
			ArticleType articleType = new ArticleType();
			articleType.setArticleId(articleId);
			articleType.setTypeId(typeId);
			articleTypeMapper.insertSelective(articleType);
			return articleType.getArticleTypeId();
		}
		else{
			return 0;
		}
	}

	
	@Override
	public int removeTypeFromArticle(int articleId, int typeId) {
		ArticleTypeMapper articleTypeMapper = SpringContextHolder.getBean("articleTypeMapper");
		ArticleTypeExample articleTypeExample = new ArticleTypeExample();
		articleTypeExample.or().andArticleIdEqualTo(articleId).andTypeIdEqualTo(typeId);
		List<ArticleType> articleTypes = articleTypeMapper.selectByExample(articleTypeExample);
		if(articleTypes == null || articleTypes.size() == 0){
			return 0;
		}else{
			int id = articleTypes.get(0).getArticleTypeId();
			articleTypeMapper.deleteByPrimaryKey(id);
			return id;
		}
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
	public int addType(String type) {
		// TODO Auto-generated method stub
		return 0;
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
		ArticleMapper articleMapper = SpringContextHolder.getBean("articleMapper");
		articleMapper.deleteByPrimaryKey(articleId);
		return true;
	}
	
	
	
}
