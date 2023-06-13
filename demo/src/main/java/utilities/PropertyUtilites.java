package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;

import com.google.common.io.Files;

import exceptions.PropertyFileUsageException;

/**
 * Read the property file and store it in a HashMap for faster processing.
 * This can read only configuration.properties file.
 * 
 * @author Nandhalala.
 * @created on MAY 22, 2023.
 * 
 * @Last_Modified_by.
 * @Last_Modified_on.
 * 
 * @version 1.0.
 * @since 1.0.
 */
public class PropertyUtilites {

	private Properties property = new Properties();
	
	private final Map <String, String> configmap = 
			new HashMap<String, String>();
	
	private File propertyfile;
	
	/**
	 * Constructor with property file as argument.
	 * 
	 * @author Nandhalala.
	 * @created on MAY 21,2023.
	 * 
	 * @param propertyfile
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
 	 */
	public PropertyUtilites(File propertyfile) {
		
		try {
			
			this.propertyfile = propertyfile;
			
			if(Files.getFileExtension(propertyfile.getPath())
					.equalsIgnoreCase("properties")) {
				
				FileInputStream fis = new FileInputStream(propertyfile);
				
				property.load(fis);
				
				for(Map.Entry<Object, Object> entry:property.entrySet()) { 
					configmap.put(String.valueOf(entry.getKey()),
							String.valueOf(entry.getValue()).trim()); 
				}
				
				fis.close();
				
			}else {
				
				throw new FileFormatException(propertyfile 
						+" is not a property file");
			
			}
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	/**
	 * Constructor with property filepath as argument.
	 * 
	 * @author Nandhalala.
	 * @created on MAY 21,2023.
	 * 
	 * @param propertyfile
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public PropertyUtilites(String propertyfilepath) {
		
		try {
			
			this.propertyfile = new File(propertyfilepath);
			
			if(Files.getFileExtension(propertyfile.getPath())
					.equalsIgnoreCase("properties")) {
				
				FileInputStream fis = new FileInputStream(propertyfile);
				
				property.load(fis);
				
				for(Map.Entry<Object, Object> entry:property.entrySet()) {
					
					configmap.put(String.valueOf(entry.getKey()),
							String.valueOf(entry.getValue()).trim()); 	
					
				}
				
				fis.close();
				
			}else {
				
				throw new FileFormatException(propertyfile 
						+" is not a property file");
			
			}
		
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
	}
	/*
	/**
	 * Load the configuration property file and save the key and value of
	 * property file in hash map
	 * 
	 * @author nandhalala
	 * @created on APR 02, 2023
	 * 
	 */
	/*
	 * static { try(FileInputStream fis = new FileInputStream(AutoConstants
	 * .getConfigPath())){ property.load(fis); for(Map.Entry<Object, Object>
	 * entry:property.entrySet()) { configmap.put(String.valueOf(entry.getKey()),
	 * String.valueOf(entry.getValue()).trim()); } } catch (FileNotFoundException e)
	 * { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); } }
	 */
	
	/**
	 * Receives the from configproperties, converts to lowercase and return the corresponding value for the key from the HashMap.
	 * 
	 * @author Nandhalala.
	 * @created on MAY 21,2023.
	 * 
	 * @param key To be fetched from property file
	 * @return corresponding value for the requested key if found 
	 * else throws PropertyFile usage Exception
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public String get(String key)  {
		
		if (Objects.isNull(key) ) {
			
			throw new PropertyFileUsageException("Property name " 
				+ key + " is not found.\nPlease check the properties file : "
					+propertyfile.getAbsolutePath());
			
		}else if(Objects.isNull(configmap.get(key))) {
			throw new PropertyFileUsageException("The Value for the Property key "
					+key+ " is not found.\nPlease verify the key and pair value "
					+"in "+propertyfile.getAbsolutePath()+" FIle");
		}
		
		return configmap.get(key);
	}
	
}
