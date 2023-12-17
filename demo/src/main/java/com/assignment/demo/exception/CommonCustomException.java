package com.assignment.demo.exception;

public class CommonCustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode = "";
	private int statusCode;

	public CommonCustomException(String errorCode, int statusCode) {
		super();
		this.errorCode = errorCode;
		this.statusCode = statusCode;
	}
	   public CommonCustomException(int statusCode, String message, Throwable cause) {
	        super(message, cause);
	        this.statusCode = statusCode;
	    }
	public CommonCustomException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommonCustomException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CommonCustomException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CommonCustomException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CommonCustomException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public CommonCustomException(int statusCode2, String message) {
		// TODO Auto-generated constructor stub
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
