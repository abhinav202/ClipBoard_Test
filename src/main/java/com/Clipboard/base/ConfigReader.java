package com.Clipboard.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	Properties prop;
	FileInputStream fis = null;

	public ConfigReader() {
		try {
			File src = new File(System.getProperty("user.dir") + "//Configuration//config.property");
			fis = new FileInputStream(src);
			prop = new Properties();

			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String app_url() {
		return prop.getProperty("AMAZON_URL");
	}

	public String extentConfigPath() {
		return prop.getProperty("EXTENT_CONFIG_PATH");
	}
}