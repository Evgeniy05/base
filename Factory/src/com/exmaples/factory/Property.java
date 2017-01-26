package com.exmaples.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Property {
	private static Map<String, String> loadProperty() {
		Map<String, String> listConfig = new HashMap<>();
		FileInputStream fileInputStream;
		Properties config = new Properties();
		try {
			fileInputStream = new FileInputStream(filename);
			config.load(fileInputStream);
			listConfig.put(STORAGE_BODY_SIZE, config.getProperty(STORAGE_BODY_SIZE));
			listConfig.put(STORAGE_ENGINE_SIZE, config.getProperty(STORAGE_ENGINE_SIZE));
			listConfig.put(STORAGE_ACCESSORY_SIZE, config.getProperty(STORAGE_ACCESSORY_SIZE));
			listConfig.put(STORAGE_AUTO_SIZE, config.getProperty(STORAGE_AUTO_SIZE));
			listConfig.put(ACCESSORY_SUPPLIERS, config.getProperty(ACCESSORY_SUPPLIERS));
			listConfig.put(ENGINE_SUPPLIERS, config.getProperty(ENGINE_SUPPLIERS));
			listConfig.put(BODY_SUPPLIERS, config.getProperty(BODY_SUPPLIERS));
			listConfig.put(WORKERS, config.getProperty(WORKERS));
			listConfig.put(DEALERS, config.getProperty(DEALERS));
			listConfig.put(LOGSALE, config.getProperty(LOGSALE));
		} catch (IOException e) {
			System.out.println("Error: file " + "not found");
			e.printStackTrace();
		}
		return listConfig;
	}

	public static Map<String, String> getConfig() {
		if (listConfig == null || listConfig.isEmpty()) {
			listConfig = loadProperty();
		}
		return listConfig;
	}

	private static Map<String, String> listConfig = null;
	private static final String filename = "config.properties";
	public static final String STORAGE_ACCESSORY_SIZE = "StorageAccessorySize";
	public static final String STORAGE_ENGINE_SIZE = "StorageEngineSize";
	public static final String STORAGE_BODY_SIZE = "StorageBodySize";
	public static final String STORAGE_AUTO_SIZE = "StorageAutoSize";
	public static final String ACCESSORY_SUPPLIERS = "AccessorySuppliers";
	public static final String ENGINE_SUPPLIERS = "EngineSuppliers";
	public static final String BODY_SUPPLIERS = "BodySuppliers";
	public static final String WORKERS = "Workers";
	public static final String DEALERS = "Dealers";
	public static final String LOGSALE = "LogSale";
}
