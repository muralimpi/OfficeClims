package com.serole.claims.service.util;

import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ElsecoClaimsUtil {

	private static final Set<Class<?>> WRAPPER_TYPES = getWrapperTypes();
	private static final Set<Class<?>> PRIMITIVE_TYPES = getPrimitiveTypes();

    public static boolean isJavaDataType(Class<?> clazz)
    {
    	if(WRAPPER_TYPES.contains(clazz) ||
    			PRIMITIVE_TYPES.contains(clazz) ||
    				String.class.equals(clazz) ) {
    		return true;
    	}
        return false;
    }

    private static Set<Class<?>> getPrimitiveTypes()
    {
        Set<Class<?>> ret = new HashSet<Class<?>>();
        ret.add(boolean.class);
        ret.add(char.class);
        ret.add(byte.class);
        ret.add(short.class);
        ret.add(int.class);
        ret.add(long.class);
        ret.add(float.class);
        ret.add(double.class);
        ret.add(void.class);
        return ret;
    }
    
    private static Set<Class<?>> getWrapperTypes()
    {
        Set<Class<?>> ret = new HashSet<Class<?>>();
        ret.add(Boolean.class);
        ret.add(Character.class);
        ret.add(Byte.class);
        ret.add(Short.class);
        ret.add(Integer.class);
        ret.add(Long.class);
        ret.add(Float.class);
        ret.add(Double.class);
        ret.add(Void.class);
        return ret;
    }
    
	/**
	 * A method that converts the JSON String to a MAP of Type <String, String>
	 * 
	 * @param json
	 * @return
	 */
	public static HashMap<String, String> getJsonAsMap(String json) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<Map<String, String>> typeRef = new TypeReference<Map<String, String>>() {
			};
			HashMap<String, String> result = mapper.readValue(json, typeRef);
			return result;
		} catch (Exception e) {
			throw new RuntimeException("Couldnt parse json:" + json, e);
		}
	}
	
	/**
	 * A method that converts the JSON String to a MAP of Type <String, String>
	 * 
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static HashMap<String, String> getJsonMapToHashMap(Object json) {
		try {
			JSONObject jsonObject = new JSONObject((Map<String, String>)json);			
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<Map<String, String>> typeRef = new TypeReference<Map<String, String>>() {
			};
			HashMap<String, String> result = mapper.readValue(jsonObject.toString(), typeRef);
			return result;
		} catch (Exception e) {
			throw new RuntimeException("Couldnt parse json:" + json, e);
		}
	}

	/**
	 * A method that converts the JSON String to a MAP of Type <String, Object>
	 * 
	 * @param t
	 * @return
	 * @throws JSONException
	 */
	@SuppressWarnings("rawtypes")
	public static Map jsonToMap(String jsonString) throws JSONException {		
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject jObject = new JSONObject(jsonString);
		Iterator<?> keys = jObject.keys();

		while (keys.hasNext()) {
			String key = (String) keys.next();
			Object value = jObject.getJSONObject(key);
			map.put(key, value);

		}
		return map;
	}
	
	/**
	 * A method that converts the JSON String to a MAP of Type <String, Object>
	 * 
	 * @param t
	 * @return
	 * @throws JSONException
	 */
	@SuppressWarnings("rawtypes")
	public static Map jsonWithChildElementsToMap(Map<String, String> map, String jsonString) throws JSONException {	
		JSONObject jObject = new JSONObject(jsonString);
		Iterator<?> keys = jObject.keys();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			Object value = jObject.get(key);
			if(isJavaDataType(value.getClass())) {
				map.put(key, value.toString());
			}else {
				jsonWithChildElementsToMap(map, value.toString());
			}
		}
		return map;
	}
	
	/**
	 * Returns the current date for storing in database compatible
	 * 
	 * @return
	 */
	public static Date getCurrentDateForSQL() {
		long millis=System.currentTimeMillis();  
        Date date=new Date(millis); 
        return date;
	}
	
	/**
	 * Returns the current date for storing in database compatible
	 * 
	 * @return
	 */
	public static Timestamp getCurrentTimestampForSQL() {
		long millis=System.currentTimeMillis();  
        Timestamp dateTime=new Timestamp(millis); 
        return dateTime;
	}
	
	/**
	 * Get all the fields in a class using reflection
	 * 
	 * @param klass
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Field[] getAllFields(Class klass) {
		List<Field> fields = new ArrayList<Field>();
		fields.addAll(Arrays.asList(klass.getDeclaredFields()));
		if (klass.getSuperclass() != null) {
			fields.addAll(Arrays.asList(getAllFields(klass.getSuperclass())));
		}
		return fields.toArray(new Field[] {});
	}	
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public static String getValidString(Object input) {
		if (input == null) {
	        return "";
	    }else if (input.toString().equals("") || input.toString().isEmpty()) {
	    	 return "";
	    }
		return input.toString();
	}
	
	/**
	 * Change the Date Format from YYYY-MM-DD  to  DD.MM.YYYY  for Hybris RFC Call
	 * 
	 * @return
	 */
	public static String HybrisDateFormatConversion(String givenDate) {
		StringBuffer str = new StringBuffer();
		if(givenDate!=null && !("").equals(givenDate)) {
			String [] eachDate = givenDate.split("-");
			str.append(eachDate[2]).append(".").append(eachDate[1]).append(".").append(eachDate[0]);
		}
		return str.toString();
	}	
}
