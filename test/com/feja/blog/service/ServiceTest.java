package com.feja.blog.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceTest extends TestService{
	
	@Resource
	private Service service;
	
	
	@Test
	public void testService_001(){
		service.getAllDates();
	}
	
}
