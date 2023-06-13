package filereaders;

import java.util.Objects;

import constants.AutoConstants;
import constants.ENVIRONMENT;
import exceptions.EnvironmentException;
import utilities.PropertyUtilites;

/**
 * To Read the environment properties.
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
public class EnvironmentReader {

	/**
	 * Private constructor to avoid instantiation
	 * 
	 */
	private EnvironmentReader() {}
	
	private static PropertyUtilites envproperties = 
			new PropertyUtilites(AutoConstants.getENVPath());
	
	/**
	 * This method is used to get configuration properties.
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
	public static String getProperty(ENVIRONMENT environment) {
		
		if(Objects.nonNull(envproperties.get(environment.toString()))||
				!envproperties.get(environment.toString()).equals("")) {
			
			return envproperties.get(environment.toString());
			
		}else {
			
			throw new EnvironmentException("Environment URL for "+environment
					+" is null or empty");
			
		}
	
	}
	
}
