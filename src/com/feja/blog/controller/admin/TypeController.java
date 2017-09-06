package com.feja.blog.controller.admin;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.feja.blog.controller.Controller;


@org.springframework.stereotype.Controller
public class TypeController extends Controller{
	private Log logger = LogFactory.getLog(TypeController.class);


	
	/**
	 * 页面 类别管理
	 * @return
	 */
	@RequestMapping(value="/admin/type/manage", method=RequestMethod.GET)
	public ModelAndView typeManage(){
		ModelAndView modelAndView = new ModelAndView("type-manage");
		renderHeaderAndFooter(modelAndView);
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/type/manage/edit/{typeId:[0-9]*}", method=RequestMethod.POST)
	public String editType(@PathVariable int typeId){
		
		return null;
	}

	@RequestMapping(value="/admin/type/manage/delete/{typeId:[0-9]*}", method=RequestMethod.POST)
	public String deleteType(@PathVariable int typeId){
		service.deleteTypeSafely(typeId);
		return "redirect:/admin/article/manage";
	}
	
	
	
	
	
	
	
	
	
}
