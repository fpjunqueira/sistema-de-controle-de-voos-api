package org.controlador.api.exception;

public class ControladorServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ControladorServiceException(String message) {
		super(message);
	}

	public ControladorServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
