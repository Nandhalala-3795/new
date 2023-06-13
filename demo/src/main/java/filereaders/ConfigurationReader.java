package filereaders;

import constants.AutoConstants;
import constants.CONFIGPROPERTIES;
import utilities.PropertyUtilites;

/**
 * Get configuration values.
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
public final class ConfigurationReader {

	/**
	 * Private constructor to avoid instantiation
	 */
	private ConfigurationReader() {}
	
	private static PropertyUtilites configproperties = 
			new PropertyUtilites(AutoConstants.getConfigPath());
	
	/**
	 * This method is used to get configuration properties.
	 * 
	 * @author Nandhalala.
	 * @created on 22 MAY,2023
	 * 
	 * @param key.
	 * @return configuration values.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public static String getProperty(CONFIGPROPERTIES key) {
		
		return configproperties.get(key.toString());
	
	}
	
}
