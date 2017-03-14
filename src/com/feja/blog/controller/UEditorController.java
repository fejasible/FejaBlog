package com.feja.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.baidu.ueditor.ActionEnter;

@org.springframework.stereotype.Controller
public class UEditorController extends Controller{

	private Log logger = LogFactory.getLog(UEditorController.class);
	
	@RequestMapping(value="/ueditor", method={RequestMethod.GET, RequestMethod.POST})
	public void checkUEditor(HttpServletRequest request, HttpServletResponse response){
	        String rootPath = request.getSession().getServletContext().getRealPath("/");
	        try {
	            String exec = new ActionEnter(request, rootPath).exec();
	            PrintWriter writer = response.getWriter();
	            writer.write(exec);
	            writer.flush();
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	
	@RequestMapping(value="/admin/ueditor", method={RequestMethod.GET, RequestMethod.POST})
	public void checkUEditor2(HttpServletRequest request, HttpServletResponse response){
	        String rootPath = request.getSession().getServletContext().getRealPath("/");
	        try {
	            String exec = new ActionEnter(request, rootPath).exec();
	            PrintWriter writer = response.getWriter();
	            writer.write(exec);
	            writer.flush();
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	@RequestMapping(value="/admin/ueditor/uploadfile")
	public void uploadFile(@RequestParam MultipartFile upfile,
			HttpServletRequest request,HttpServletResponse response){
		logger.info("get upload file");
	}
	
}
