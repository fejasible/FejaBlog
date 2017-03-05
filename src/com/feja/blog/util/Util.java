package com.feja.blog.util;

import java.text.ParseException;
import java.util.Date;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.format.datetime.DateFormatter;

public class Util{
	
	public static String dateToStringyyyy_MM(Date date) throws ParseException{
		DateFormatter dateFormatter = new DateFormatter("yyyy-MM");
		String dateString = dateFormatter.print(date, LocaleContextHolder.getLocale());
		return dateString;
	}
	
}