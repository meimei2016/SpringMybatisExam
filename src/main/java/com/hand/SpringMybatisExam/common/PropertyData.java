package com.hand.SpringMybatisExam.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

 final class PropertyData {
	static Map<String,String> getParam(){
		Map<String,String> map=new HashMap<String,String>();
		Properties property = new Properties();
		try {						 
			InputStream in =PropertyData.class.getClassLoader().getResourceAsStream("com/hand/dbconfig.properties");					      
			property.load(in);
			String driver=property.getProperty("driver").trim();
			String url=property.getProperty("url").trim();			
			String userName=property.getProperty("userName").trim();
			String password=property.getProperty("password").trim();			
			map.put("driver", driver);
			map.put("url", url);
			map.put("userName", userName);
			map.put("password", password);
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return map;		
	}
}
