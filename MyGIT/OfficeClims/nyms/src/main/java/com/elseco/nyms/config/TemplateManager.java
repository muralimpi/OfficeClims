/**
 * 
 */
package com.elseco.nyms.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
/**
 * @author SONJOY CHAKRABORTY
 *
 */
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class TemplateManager {

	public static String getTemplateNGenReport(String name, Map<String, String> args) throws IOException, TemplateException {

		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		Writer fileWriter = null; 

		Configuration cfg = new Configuration();
		TemplateLoader loader = new ClassTemplateLoader(TemplateManager.class, "/templates");
		cfg.setTemplateLoader(loader);
		cfg.setEncoding(Locale.getDefault(), "ISO-8859-1");
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		
		  Template template; 
		  template = cfg.getTemplate(name + ".ftl"); 
		  
		  File file = new File("output.html");
		  fileWriter = new FileWriter(file);
		  template.process(args, fileWriter); 
		
		return fileWriter.toString();
	}
}
