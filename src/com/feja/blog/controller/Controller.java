package com.feja.blog.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.feja.blog.constant.BlogConstant;
import com.feja.blog.model.Article;
import com.feja.blog.model.ConfigWithBLOBs;
import com.feja.blog.service.Service;

public class Controller {
	@Autowired
	protected Service service;

	
	/**
	 * 渲染页眉和页脚
	 * @param modelAndView
	 */
	protected void renderHeaderAndFooter(ModelAndView modelAndView){
		//获取基本信息
		ConfigWithBLOBs config = service.getConfig(BlogConstant.USED_CONFIG);
		//获取日期归档
		ArrayList<String[]> dates = service.getAllDatesSorted();
		ArrayList<HashMap<String, String>> datesMap = new ArrayList<>();
		for(int i=0;i<dates.size();i++){
			HashMap<String, String> d = new HashMap<>();
			d.put("date", dates.get(i)[0]);
			d.put("num", dates.get(i)[1]);
			datesMap.add(d);
		}
		//获取分类归档
		ArrayList<String[]> types = service.getAllTypesSorted();
		ArrayList<HashMap<String, String>> typesMap = new ArrayList<>();
		for(int i=0;i<types.size();i++){
			HashMap<String, String> d = new HashMap<>();
			d.put("type", types.get(i)[0]);
			d.put("num", types.get(i)[1]);
			typesMap.add(d);
		}
		ArrayList<Article> recommendArticles = service.getAllRecommandArticles();
		modelAndView.addObject("config", config);
		modelAndView.addObject("dates", datesMap);
		modelAndView.addObject("types", typesMap);
		modelAndView.addObject("recommendArticles", recommendArticles);
	}
	

}
