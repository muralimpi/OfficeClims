/**
 * 
 */
package com.elseco.nyms.utils;

//Java program to check if an email address
//is valid using Regex.
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author SONJOY CHAKRABORTY
 *
 */
public class EmailUtil {

	/**
	 * 
	 */
	public EmailUtil() {
		// TODO Auto-generated constructor stub
	}

	public static boolean isEmailAddressValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

}
