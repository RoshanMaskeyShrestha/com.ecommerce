package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readdatafromProperty(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(Ipathconstants.filepath);
	Properties	p=new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	
	return value;
	
	}

}
