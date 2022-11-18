

package com.tdh.mybatisplus.config;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {


	static{
		//字段名首字母不自动转小写
//    	TypeUtils.compatibleWithFieldName = true;
	}


	private JsonUtil() {
	}

	public static String toJson(Object obj) {
		if (obj == null) {
			return null;
		}
		return JSON.toJSONString(obj);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getObject(String json) {
		if (json == null) {
			return null;
		}
		return (T)JSON.parse(json);
	}


	@SuppressWarnings("unchecked")
	public static <T> List<T> getObjectList(String json, Class<T> clazz){
		if (json == null){
			return null;
		}
		System.out.println("Json String is " + json);
		JSONArray array = JSON.parseArray(json);
		List<T> list = new ArrayList<T>();
		for( int i = 0; i < array.size(); ++i ){
			JSONObject o = array.getJSONObject(i);
			list.add((T)JSON.parseObject(o.toJSONString(),clazz));
		}
		return list;
	}

	public static <T> T getObject(String json, Class<T> clazz) {
		if (json == null || clazz == null) {
			return null;
		}
		return JSON.parseObject(json, clazz);
	}


	public static <T> T getObject(String json, Type type) {
		if (json == null || type == null) {
			return null;
		}
		return JSON.parseObject(json, type);
	}



	public static List<String> conStr2Array(String dotsplitStr){
		if(StringUtils.isEmpty(dotsplitStr))
			return  new ArrayList<String>();
		String[] idList = dotsplitStr.split(",");
		List<String> list = new ArrayList<String>();
		for(int i=0; i<idList.length; i++){
			list.add(idList[i]);
		}
		return list;
	}



}
