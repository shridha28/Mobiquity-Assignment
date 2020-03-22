/**
 * 
 */
package com.mobiquity.exception;

/**
 * Exception thrown when a package is not parsed correctly/
 * the package is not valid
 * @author Shridha Jalihal
 **/
public class PackageParseException extends APIException {

	
	private static final long serialVersionUID = 4657106205213850085L;

	/**
	 * @param message
	 */
	public PackageParseException(String message) {
		super(message);
	}

}
