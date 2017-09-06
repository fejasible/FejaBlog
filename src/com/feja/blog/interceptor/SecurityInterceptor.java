package com.feja.blog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.feja.blog.constant.BlogConstant;
import com.feja.blog.service.Service;


public class SecurityInterceptor implements HandlerInterceptor {  
	
	
	@Autowired
	private Service service;

	private static final Log logger = LogFactory.getLog(SecurityInterceptor.class);
  
    @Override  
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {  
        HttpSession session = request.getSession(true);  
        // 从session 里面获取用户名的信息
        String username = (String) session.getAttribute(BlogConstant.SENSSION_KEY_USERNAME);
        // 判断如果没有取到用户信息，就跳转到登陆页面，提示用户进行登陆  
        if (username == null || "".equals(username)) {
            response.sendRedirect(request.getContextPath()+"/login");
            return true;
        }else{
        	if(username.equals(BlogConstant.SENSSION_KEY_USERNAME)){
        		return true;
        	}
        }
        response.sendRedirect(request.getContextPath()+"/login");
        return true;
    }  
  
    @Override  
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object arg2, ModelAndView arg3) throws Exception {  
    }  
  
    @Override  
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception arg3) throws Exception {  
    }  
  
}  
