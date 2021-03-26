package com.asteelflash.print.app.models;

public class FTPCResult {

	public FTPCResult() {
	}
	
	public Boolean getResult() {
		return result;
	}
	public void setResult(Boolean result) {
		this.result = result;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}

	private Boolean result = true;
	private String Message = "Success";
	private Object object = null;

}
