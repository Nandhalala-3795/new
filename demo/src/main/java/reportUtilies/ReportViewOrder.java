package reportUtilies;

import java.util.ArrayList;
import java.util.List;

import com.aventstack.extentreports.reporter.configuration.ViewName;

/**
 * An order of view about the category of reports view.
 * 
 * @author Nandhalala.
 * @Created_on 30 MAY,2023
 * 
 * @Last_Modified_by.
 * @Last_Modified_on.
 * 
 * @version 1.0.
 * @since 1.0.
 */
public class ReportViewOrder {

	/**
	 * Private list to store the view in a sequence.
	 */
	private static List<ViewName> vieworder = new ArrayList<ViewName>();
	
	/**
	 * Add the view in the order of how to display. 
	 */
	static {
		
		vieworder.add(ViewName.DASHBOARD);
		
		vieworder.add(ViewName.TEST);
		
		vieworder.add(ViewName.CATEGORY);
		
		vieworder.add(ViewName.EXCEPTION);
		
		vieworder.add(ViewName.AUTHOR);
		
		vieworder.add(ViewName.LOG);
		
		vieworder.add(ViewName.DEVICE);
		
	}
	
	/**
	 * This method will return the view order.
	 * 
	 * @author Nandhalala.
	 * @Created_on 30 MAY,2023.
	 * 
	 * @return the view order in a list.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	static List<ViewName> getReportViewOrder(){
		
		return vieworder;
		
	}
	
}
