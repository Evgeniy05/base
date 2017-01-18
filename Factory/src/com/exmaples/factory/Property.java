package com.exmaples.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Property {
	private static Map<String, Integer> loadProperty() {
		Map<String, Integer> listConfig = new HashMap<String, Integer>();
		FileInputStream fileInputStream;
		Properties config = new Properties();
		try {
			fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
			config.load(fileInputStream);
			listConfig.put("StorageBody", Integer.parseInt(config.getProperty("StorageBodySize")));
			listConfig.put("StorageEngine", Integer.parseInt(config.getProperty("StorageEngineSize")));
			listConfig.put(STORAGE_ACCESSORY_SIZE, Integer.parseInt(config.getProperty(STORAGE_ACCESSORY_SIZE)));
			listConfig.put("StorageAuto", Integer.parseInt(config.getProperty("StorageAutoSize")));
			listConfig.put("AccessorySuppliers", Integer.parseInt(config.getProperty("AccessorySuppliers")));
			listConfig.put("EngineSuppliers", Integer.parseInt(config.getProperty("EngineSuppliers")));
			listConfig.put("BodySuppliers", Integer.parseInt(config.getProperty("BodySuppliers")));
			listConfig.put("Workers", Integer.parseInt(config.getProperty("Workers")));
			listConfig.put("Dealers", Integer.parseInt(config.getProperty("Dealers")));
			listConfig.put("LogSale", Integer.parseInt(config.getProperty("LogSale")));
			// listConfig.put("Engine",Integer.parseInt("1"));
			// listConfig.put("Body",Integer.parseInt("2"));
			// listConfig.put("Accessory",Integer.parseInt("3"));
		} catch (IOException e) {
			System.out.println("Error: file " + PATH_TO_PROPERTIES + "not found");
			e.printStackTrace();
		}
		return listConfig;
	}

	public static Map<String, Integer> getConfig() {
		if (listConfig == null || listConfig.isEmpty()) {
			listConfig = loadProperty();
		}
		return listConfig;
	}

	// public LinkedHashMap<Integer, String> getListNameComponent() {
	// listName.put(1, "Engine");
	// listName.put(2, "Body");
	// listName.put(3, "Accessory");
	// return listName;
	// }

	private static Map<String, Integer> listConfig = null;
	// LinkedHashMap<Integer, String> listName = new LinkedHashMap<Integer,
	// String>(0);
	// Исправить путь.
	public static final String PATH_TO_PROPERTIES = "C:\\Users\\Евгений\\workspace\\Factory\\src\\com\\exmaples\\factory\\config.properties";
	public static final String STORAGE_ACCESSORY_SIZE = "StorageAccessorySize";
	public static final String STORAGE_ENGINE_SIZE = "StorageEngineSize";
	public static final String STORAGE_ACCESSORY_SIZE = "StorageAccessorySize";
	public static final String STORAGE_ACCESSORY_SIZE = "StorageAccessorySize";
	public static final String STORAGE_ACCESSORY_SIZE = "StorageAccessorySize";
	public static final String STORAGE_ACCESSORY_SIZE = "StorageAccessorySize";
	public static final String STORAGE_ACCESSORY_SIZE = "StorageAccessorySize";
	public static final String STORAGE_ACCESSORY_SIZE = "StorageAccessorySize";
}
