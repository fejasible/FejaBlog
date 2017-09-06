package com.feja.blog.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.feja.blog.constant.BlogConstant;
import com.feja.blog.controller.Controller;
import com.feja.blog.model.Config;


@org.springframework.stereotype.Controller
public class AccountController extends Controller{
	private Log logger = LogFactory.getLog(AccountController.class);

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
			return "redirect:/admin/article/manage";
		}
		redirectAttributes.addFlashAttribute("loginResult", BlogConstant.LOGIN_FAILED_TEXT);
		return "redirect:/login";
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
}
