package com.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private static final Properties props = new Properties();

	static {
		try (InputStream is = ConfigReader.class.getClassLoader().getResourceAsStream("config/config.properties")) {

			if (is == null) {
				throw new RuntimeException("config.properties not found under src/test/resources/config");
			}
			props.load(is);
		} catch (Exception e) {
			throw new RuntimeException("Failed to load config.properties", e);
		}
	}

	public static String get(String key) {
		String sys = System.getProperty(key);
		if (sys != null && !sys.trim().isEmpty())
			return sys.trim();

		String value = props.getProperty(key);
		if (value == null)
			throw new RuntimeException("Missing config key: " + key);
		return value.trim();
	}

}
