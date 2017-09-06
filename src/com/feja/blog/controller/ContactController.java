package com.feja.blog.controller;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.feja.blog.model.Contact;

@org.springframework.stereotype.Controller
public class ContactController extends com.feja.blog.controller.Controller{
	private Log logger = LogFactory.getLog(ContactController.class);
	

	@RequestMapping(value="/contact/contactMe", method=RequestMethod.POST)
	public ModelAndView contatMe(Contact contact){
		contact.setDate(new Date());
		service.addContact(contact);
		ModelAndView modelAndView = new ModelAndView("contact-success");
		this.renderHeaderAndFooter(modelAndView);
		return modelAndView;
	}
	
}
