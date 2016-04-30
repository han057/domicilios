/**
 * 
 */
package com.hsofttecnologies.domicilios.exception;

/**
 * Excepción que se lanza cuando no se encuentra un objeto
 * 
 * @author han
 *
 */
public class ObjectAlreadyExistException extends RuntimeException {
	
	public ObjectAlreadyExistException() {

	}

	public ObjectAlreadyExistException(String message) {
		super(message);
	}

	public ObjectAlreadyExistException(Throwable cause) {
		super(cause);
	}

	public ObjectAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectAlreadyExistException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
