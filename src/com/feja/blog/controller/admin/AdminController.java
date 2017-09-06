package com.feja.blog.controller.admin;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.feja.blog.constant.BlogConstant;
import com.feja.blog.controller.Controller;
import com.feja.blog.model.Article;
import com.feja.blog.model.Config;
import com.feja.blog.model.ConfigWithBLOBs;
import com.feja.blog.model.Type;
import com.feja.blog.model.form.AddArticleForm;


@org.springframework.stereotype.Controller
public class AdminController extends Controller{

	private Log logger = LogFactory.getLog(AdminController.class);

	
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
	 * 页面 博客配置管理
	 * @return
	 */
	@RequestMapping(value="/admin/website/manage", method=RequestMethod.GET)
	public ModelAndView webSiteManage(){
		ModelAndView modelAndView = new ModelAndView("website-manage");
		renderHeaderAndFooter(modelAndView);
		return modelAndView;
	}
	
	
	@RequestMapping(value="/admin/website/manage/edit", method=RequestMethod.POST)
	public String editWebSiteConfig(ConfigWithBLOBs config){
		logger.info(config);
		service.updateBlogName(config.getBlogName());
		service.updateBlogDescribe(config.getBlogDescribe());
		service.updateCopyRight(config.getCopyright());
		service.updateProfile(config.getProfile());
		return "redirect:/admin/website/manage";
	}
	
	
	
	/**
	 * 页面 回收站管理
	 * @return
	 */
	@RequestMapping(value="admin/recycleBin/manage", method=RequestMethod.GET)
	public ModelAndView recycleBinManage(){
		ModelAndView modelAndView = new ModelAndView("recycle-bin-manage");
		ArrayList<Article> articles = service.getAllArticlesDelete();
		modelAndView.addObject("articles", articles);
		renderHeaderAndFooter(modelAndView);
		return modelAndView;
	}
	
	
	
	
	
	
	
	
	
	
	
}