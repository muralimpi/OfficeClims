/**
 * 
 */
package com.elseco.nyms.utils;

/**
 * @author SONJOY CHAKRABORTY
 *
 */

import net.htmlparser.jericho.*;
import java.util.*;
import java.io.*;
import java.net.*;

public final class Html2TextParse {

	/**
	 * 
	 */
	public Html2TextParse() {
		// TODO Auto-generated constructor stub
	}

	
	public static String html2text(String html) throws Exception {
		String sourceUrlString=html;

		MicrosoftConditionalCommentTagTypes.register();
		PHPTagTypes.register();
		PHPTagTypes.PHP_SHORT.deregister(); // remove PHP short tags for this example otherwise they override processing instructions
		MasonTagTypes.register();
		Source source=new Source(sourceUrlString);

		// Call fullSequentialParse manually as most of the source will be parsed.
		source.fullSequentialParse();
		StringBuilder strBldr = new StringBuilder();
		
		strBldr.append(source.getTextExtractor().setIncludeAttributes(true).toString());
		TextExtractor textExtractor=new TextExtractor(source) {
			public boolean excludeElement(StartTag startTag) {
				return startTag.getName()==HTMLElementName.P || "control".equalsIgnoreCase(startTag.getAttributeValue("class"));
			}
		};
		strBldr.append(textExtractor.setIncludeAttributes(true).toString());
		
		return strBldr.toString();
  }

	private static String getTitle(Source source) {
		Element titleElement=source.getFirstElement(HTMLElementName.TITLE);
		if (titleElement==null) return null;
		// TITLE element never contains other tags so just decode it collapsing whitespace:
		return CharacterReference.decodeCollapseWhiteSpace(titleElement.getContent());
	}

	private static String getMetaValue(Source source, String key) {
		for (int pos=0; pos<source.length();) {
			StartTag startTag=source.getNextStartTag(pos,"name",key,false);
			if (startTag==null) return null;
			if (startTag.getName()==HTMLElementName.META)
				return startTag.getAttributeValue("content"); // Attribute values are automatically decoded
			pos=startTag.getEnd();
		}
		return null;
	}
	
}
