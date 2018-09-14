/**
 * 
 */
package com.serole.wims.eventlistener;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author SONJOY CHAKRABORTY
 *
 */
@Component
public class SingleTonDataLoader {

	private static final Logger LOG = LoggerFactory.getLogger(SingleTonDataLoader.class);
	
	private static List<String> users = null;

	/**
	 * 
	 */
	private SingleTonDataLoader() {
		// TODO Auto-generated constructor stub
	}

	static {
		if (users == null) {
			users = new ArrayList<String>();
		}

		users.add("a");
		users.add("b");
		users.add("c");
		users.add("d");

	}

	public static List<String> getUsers() {
		return users;
	}

}
