package com.exception;

public class UnsupportedFunctionException extends RuntimeException {

	final private int ERR_CODE;
	
	public UnsupportedFunctionException(String str, int errCode) {
		super(str);
		this.ERR_CODE = errCode;
	}
	
	public UnsupportedFunctionException(String str) {
		this(str, 100);
	}
	
	public int getErrorCode() {
		return ERR_CODE;
	}
	
	@Override
	public String getMessage() {
		return "[" + getErrorCode() + "]"+super.getMessage();
	}
	
	
}
