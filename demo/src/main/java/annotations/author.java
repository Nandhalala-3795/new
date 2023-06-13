package annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * The author annotation is used to get the author of the Test case.
 * 
 * @author Nandhalala.
 * @create on 26 MAY,2023.
 *
 * @Last_Modified_by.
 * @Last_Modified_on.
 *
 * @version 1.0.
 * @since 1.0.
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface author {

	/**
	 * TO get the author  of the testcase at runtime.
	 * 
	 * @return the name of the author's or authors name who built the testcase.
	 */
	public String[] name();
	
//	/**
//	 * To get the modifier name of the testcase.
//	 * 
//	 * @return the modifiers of the testcase.
//	 */
//	public String[] modifiedby() default{};
//	
//	/**
//	 * To get the last modifier name of the testcase at run time.
//	 * 
//	 * @return the last modifier name of the testcase.
//	 */
//	public String lastmodifiedby() default"";
	
}
