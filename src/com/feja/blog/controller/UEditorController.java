package com.feja.blog.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baidu.ueditor.ActionEnter;
import com.feja.blog.util.JsonUtil;
import com.feja.blog.util.Util;

@org.springframework.stereotype.Controller
public class UEditorController extends Controller{

	private Log logger = LogFactory.getLog(UEditorController.class);
	
//	/**
//	 * 文件读写相关
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping(value="/ueditor", method={RequestMethod.GET, RequestMethod.POST})
//	public void checkUEditor(HttpServletRequest request, HttpServletResponse response){
//	        String rootPath = request.getSession().getServletContext().getRealPath("/");
//	        try {
//	            String exec = new ActionEnter(request, rootPath).exec();
//	            PrintWriter writer = response.getWriter();
//	            writer.write(exec);
//	            writer.flush();
//	            writer.close();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	}
//	
//	/**
//	 * 文件读写相关
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping(value="/admin/ueditor", method={RequestMethod.GET, RequestMethod.POST})
//	public void checkUEditor2(HttpServletRequest request, HttpServletResponse response){
//	        String rootPath = request.getSession().getServletContext().getRealPath("/");
//	        try {
//	            String exec = new ActionEnter(request, rootPath).exec();
//	            PrintWriter writer = response.getWriter();
//	            writer.write(exec);
//	            writer.flush();
//	            writer.close();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	}

	@RequestMapping(value="/admin/ueditor", method=RequestMethod.GET)
	public String checkUEditor3(){
		return "controller";
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/ueditor", method=RequestMethod.POST)
	public String actionUEditor(@RequestParam String action, @RequestParam MultipartFile upfile,
			HttpServletRequest request,HttpServletResponse response){
		if(action.equals("uploadimage")){
			if (!upfile.isEmpty()) {  
	            try {  
	                // 文件保存路径  
	            	String originalFilename = upfile.getOriginalFilename();
	                String filePath = request.getSession().getServletContext().getRealPath("/") + "ueditor/upload/image/" + originalFilename;
	                String url = Util.getWebappRootPath(request) + "/ueditor/upload/image/" + originalFilename;
	                // 转存文件  
	                upfile.transferTo(new File(filePath));  
	                
	                Map<String, String> json = new HashMap<String, String>();
	                json.put("state", "SUCCESS");
	                json.put("url", url);
	                json.put("title", originalFilename);
	                json.put("original", originalFilename);
	                return JsonUtil.writeValueAsString(json);
	            } catch (FileNotFoundException e) {  
	                e.printStackTrace();
	            } catch (IllegalStateException e) {  
					e.printStackTrace();
				} catch (IOException e) {  
					e.printStackTrace();
				}
	        }
		}
		
		return null;
	}
	
	
	/**
	 * 文件上传
	 * @param upfile
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/admin/ueditor/uploadfile")
	public String uploadFile(@RequestParam MultipartFile upfile,
			HttpServletRequest request,HttpServletResponse response){

		if (!upfile.isEmpty()) {  
            try {  
                // 文件保存路径  
            	String originalFilename = upfile.getOriginalFilename();
                String filePath = request.getSession().getServletContext().getRealPath("/") + "ueditor/upload/file/"  
                        + originalFilename;
                String url = Util.getWebappRootPath(request) + "/ueditor/upload/file/" + originalFilename;
                // 转存文件  
                upfile.transferTo(new File(filePath));  
                
                Map<String, String> json = new HashMap<String, String>();
                json.put("state", "SUCCESS");
                json.put("url", url);
                json.put("title", originalFilename);
                json.put("original", originalFilename);
                return JsonUtil.writeValueAsString(json);
            } catch (FileNotFoundException e) {  
                e.printStackTrace();
            } catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
        } 
		return null;
	}
}
