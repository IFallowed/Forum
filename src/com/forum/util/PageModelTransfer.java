package com.forum.util;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * 分页模型转换器
 * @author Administrator
 *
 */
public class PageModelTransfer {
	public static <T> String transfer(PageModel<T> pageModel){
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("firstNo", pageModel.getFirstNo());
		jsonMap.put("preNo", pageModel.getPreNo());
		jsonMap.put("nextNo", pageModel.getNextNo());
		jsonMap.put("lastNo", pageModel.getLastNo());
		jsonMap.put("pageNo", pageModel.getPageNo());
		jsonMap.put("dataList", pageModel.getDataList());
		
		return JSONObject.fromObject(jsonMap).toString();
		
	}
}
