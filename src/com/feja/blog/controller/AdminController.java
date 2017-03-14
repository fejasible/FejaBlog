package com.feja.blog.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.feja.blog.constant.BlogConstant;
import com.feja.blog.model.Article;
import com.feja.blog.model.Config;


@org.springframework.stereotype.Controller
public class AdminController extends Controller{

	private Log logger = LogFactory.getLog(AdminController.class);
	
	/**
	 * 请求登录页面
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView("login");
		Config config = new Config();
		this.renderHeaderAndFooter(modelAndView);
		modelAndView.addObject("config", config);
		return modelAndView;
	}
	
	
	/**
	 * 提交登录表单
	 * @param config
	 * @param redirectAttributes
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Config config, RedirectAttributes redirectAttributes, HttpServletRequest request){
		boolean result = service.validate(config.getUsername(), config.getPassword());
		if(result){
			HttpSession session = request.getSession();
			session.setAttribute(BlogConstant.SENSSION_KEY_USERNAME, BlogConstant.SENSSION_KEY_USERNAME);
			return "redirect:/admin/view";
		}
		redirectAttributes.addFlashAttribute("loginResult", BlogConstant.LOGIN_FAILED_TEXT);
		return "redirect:/login";
	}
	
	/**
	 * 管理员页面
	 * @return
	 */
	@RequestMapping(value="/admin/view", method=RequestMethod.GET)
	public ModelAndView adminView(){
		ModelAndView modelAndView = new ModelAndView("admin-view");
		modelAndView.addObject("article", new Article());
		this.renderHeaderAndFooter(modelAndView);
		return modelAndView;
	}
	
	
	/**
	 * 登出
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/admin/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute(BlogConstant.SENSSION_KEY_USERNAME);
		return "redirect:/index";
	}
	
	
	/**
	 * 文章页面请求
	 * @return
	 */
	@RequestMapping(value="/admin/article/add", method=RequestMethod.GET)
	public ModelAndView addArticle(){
		ModelAndView modelAndView = new ModelAndView("admin-view");
		modelAndView.addObject("article", new Article());
		this.renderHeaderAndFooter(modelAndView);
		return modelAndView;
	}
	
	
	/**
	 * 添加文章请求
	 * @param editorValue
	 * @return
	 */
	@RequestMapping(value="/admin/article/add", method=RequestMethod.POST)
	public String addArticle(@RequestParam String editorValue, Article article){
		logger.info(editorValue);
		return "redirect:/index";
	}
	
	/**
	 * 文章管理
	 * @return
	 */
	@RequestMapping(value="/admin/article/manage", method=RequestMethod.GET)
	public ModelAndView articleManage(){
		ModelAndView modelAndView = new ModelAndView("article-manage");
		ArrayList<Article> articles = service.getAllArticles();
		modelAndView.addObject("articles", articles);
		renderHeaderAndFooter(modelAndView);
		return modelAndView;
	}
	
	
	/**
	 * 类别管理
	 * @return
	 */
	@RequestMapping(value="/admin/type/manage", method=RequestMethod.GET)
	public ModelAndView typeManage(){
		ModelAndView modelAndView = new ModelAndView("type-manage");
		return modelAndView;
	}
	
	
	/**
	 * 博客配置管理
	 * @return
	 */
	@RequestMapping(value="/admin/website/manage", method=RequestMethod.GET)
	public ModelAndView webSiteManage(){
		ModelAndView modelAndView = new ModelAndView("website-manage");
		return modelAndView;
	}
	
	/**
	 * 草稿箱管理
	 * @return
	 */
	@RequestMapping(value="/admin/draft/manage", method=RequestMethod.GET)
	public ModelAndView draftManage(){
		ModelAndView modelAndView = new ModelAndView("draft-manage");
		return modelAndView;
	}
	
	
	/**
	 * 回收站管理
	 * @return
	 */
	@RequestMapping(value="admin/recycleBin/manage", method=RequestMethod.GET)
	public ModelAndView recycleBinManage(){
		ModelAndView modelAndView = new ModelAndView("recycle-bin-manage");
		return modelAndView;
	}
	
}