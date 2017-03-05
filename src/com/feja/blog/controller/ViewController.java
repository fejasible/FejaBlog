package com.feja.blog.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewController {
	
	private Log logger = LogFactory.getLog(ViewController.class);
	
	@ResponseBody
	@RequestMapping(value="/")
	public Map<String, String> index(){
		Map<String, String> data = new HashMap<String, String>();
		
		data.put("1", "2");
		
		return data;
	}
	
}
