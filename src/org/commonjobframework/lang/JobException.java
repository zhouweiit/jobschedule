package org.commonjobframework.lang;

public class JobException extends Exception {

	private static final long serialVersionUID = 1000L;

	public static final int ERR_UNSPECIFIED = 0;

	private Throwable cause;
    
	private int errorCode = ERR_UNSPECIFIED;
    
	public JobException() {
		super();
	}
	
	public JobException(String msg) {
		super(msg);
	}
 
	public JobException(String msg, int errorCode) {
		super(msg);
		setErrorCode(errorCode);
	}

	public JobException(Throwable cause) {
		super(cause.toString());
		setCause(cause);
	}

	public JobException(String msg, Throwable cause) {
		super(msg);
		setCause(cause);
	}
 
	public JobException(String msg, Throwable cause, int errorCode) {
		super(msg);
		setCause(cause);
		setErrorCode(errorCode);
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
    
	public int getErrorCode() {
		return errorCode;
	}

	public Throwable getCause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}
}
