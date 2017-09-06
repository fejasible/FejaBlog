package com.feja.blog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.format.datetime.DateFormatter;

public class Util{
	
	public static String dateToStringyyyy_MM(Date date) throws ParseException{
		DateFormatter dateFormatter = new DateFormatter("yyyy-MM");
		String dateString = dateFormatter.print(date, LocaleContextHolder.getLocale());
		return dateString;
	}
	
	public static Date Stringyyyy_MMToDate(String dateString) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");  
	    Date toDate = sdf.parse(dateString);
	    return toDate;
	}
	
	/**
	 * http://www.xxx.xx/webapp
	 * @param request
	 * @return
	 */
	public static String getWebappRootPath(HttpServletRequest request){
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		return basePath;
	}
}