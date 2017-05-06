package com.feja.blog.util;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {

	public static String writeValueAsStringTimestamp(Object object){
		try {
			return new ObjectMapper().writeValueAsString(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static String writeValueAsString(Object object){
		try {
			return new ObjectMapper().writeValueAsString(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static String writeValueAsStringDate(Object object){
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		try {
			return objectMapper.writeValueAsString(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static String writeValueAsStringDateTime(Object object){
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		try {
			return objectMapper.writeValueAsString(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}


