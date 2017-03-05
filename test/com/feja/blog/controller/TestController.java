package com.feja.blog.controller;


import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "file:WebContent/WEB-INF/config/springmvc-config.xml")
public class TestController {
	
	
	@Autowired  
	private WebApplicationContext webApplicationContext;  
  
	protected MockMvc mockMvc; 
    
	@Before  
	public void setup() {   
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();  
	} 

}
