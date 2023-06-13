package utilities;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 
 * @author Nandhalala.
 * @Created_on 26 MAY,2023
 * 
 * @Last_Modified_by.
 * @Last_Modified_on.
 * 
 * @version 1.0.
 * @since 1.0.
 */
public class SystemProperties {

	private static String DeviceName = "Unknown";
	
	public static String getDeviceName() {
		
		try {
			
			DeviceName = InetAddress.getLocalHost().getHostName();
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
			
		}
		
		return DeviceName;

	}
	
}
