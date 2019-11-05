package com.forum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String parseDateToStr(Date date,String pattern){
		if(null != date){
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.format(date);
		}else {
			return null;
		}
	}
	
	public static Date parseStrToDate(String dateStr,String pattern){
		Date date = null;
		if(!dateStr.contains(":")) {
			dateStr = dateStr.trim() + " 00:00:00";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if(null != dateStr){
			try {
				date = sdf.parse(dateStr);
			} catch (ParseException e) {
				System.out.println("日期格式错误");
			}
		}
		return date; 
	}
}
