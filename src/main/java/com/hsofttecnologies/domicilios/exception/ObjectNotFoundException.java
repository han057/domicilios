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
public class ObjectNotFoundException extends RuntimeException {
	
	public ObjectNotFoundException() {

	}

	public ObjectNotFoundException(String message) {
		super(message);
	}

	public ObjectNotFoundException(Throwable cause) {
		super(cause);
	}

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
