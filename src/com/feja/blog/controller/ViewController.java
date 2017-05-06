package com.feja.blog.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.feja.blog.model.Article;
import com.feja.blog.util.Util;

@org.springframework.stereotype.Controller
public class ViewController extends com.feja.blog.controller.Controller{
	
	private Log logger = LogFactory.getLog(ViewController.class);
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping(value={"/", "/index"}, method=RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView("index");
		
		//获取推荐到首页的文章
		ArrayList<Article> articles = service.getAllVisibleAndRecommendAndNotDeleteArticles();
		modelAndView.addObject("articles", articles);
		this.renderHeaderAndFooter(modelAndView);
		return modelAndView;
	}
	
	/**
	 * 按指定日期显示的文章
	 * @param dateString
	 * @return
	 */
	@RequestMapping(value="/date/{dateString:[0-9][0-9][0-9][0-9]-[0-9][0-9]}", method=RequestMethod.GET)
	public ModelAndView indexDate(@PathVariable String dateString){
		ModelAndView modelAndView = new ModelAndView("index");
		//获取指定日期的文章
		ArrayList<Article> articles = null;
		try {
			Date date = Util.Stringyyyy_MMToDate(dateString);
			articles = service.getArticlesByDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
			articles = service.getAllVisibleAndRecommendAndNotDeleteArticles();
		}
		modelAndView.addObject("articles", articles);
		this.renderHeaderAndFooter(modelAndView);
		return modelAndView;
	}
	

	/**
	 * 按指定分类显示的文章
	 * @param typeString
	 * @return
	 */
	@RequestMapping(value="/type/{typeString:.*}", method=RequestMethod.GET)
	public ModelAndView indexType(@PathVariable String typeString){
		ModelAndView modelAndView = new ModelAndView("index");
		//获取指定分类的文章
		ArrayList<Article> articles = service.getArticlesByType(typeString);
		if(articles == null){
			articles = service.getAllVisibleAndRecommendAndNotDeleteArticles();
		}
		modelAndView.addObject("articles", articles);
		this.renderHeaderAndFooter(modelAndView);
		return modelAndView;
	}

	/**
	 * 页面 得到指定id的文章
	 * @param articleId
	 * @return
	 */
	@RequestMapping(value="/blog/{articleId:[0-9]*}", method=RequestMethod.GET)
	public ModelAndView blog(@PathVariable int articleId){
		ModelAndView modelAndView = new ModelAndView("page-with-sidebar");
		Article article = null;
		if(articleId != 0){
			article = service.getArticle(articleId);
		}
		else{//为零，随机附上一篇推荐文章
			ArrayList<Article> articles = service.getAllRecommendArticles();
			article = articles.get(new Random().nextInt(articles.size()));
		}
		modelAndView.addObject("article", article);
		this.renderHeaderAndFooter(modelAndView);
		return modelAndView;
	}
	
	
	/**
	 * 页面 得到简介信息
	 * @return
	 */
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public ModelAndView profile(){
		ModelAndView modelAndView = new ModelAndView("profile");
		this.renderHeaderAndFooter(modelAndView);
		return modelAndView;
	}

	/**
	 * 页面 联系我
	 * @return
	 */
	@RequestMapping(value="/contact", method=RequestMethod.GET)
	public ModelAndView contact(){
		ModelAndView modelAndView = new ModelAndView("contact");
		this.renderHeaderAndFooter(modelAndView);
		return modelAndView;
	}
	
	@RequestMapping(value="/contact", method=RequestMethod.POST)
	public void contact(String data){
		logger.info(data);
	}
	
}
