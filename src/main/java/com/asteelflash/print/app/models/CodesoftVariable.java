package com.asteelflash.print.app.models;

import com.asteelflash.print.app.exceptions.CodesoftRuntimeException;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class CodesoftVariable {

	public CodesoftVariable(Variant codesoftVariable) throws CodesoftRuntimeException {
		this.CODESOFT_VARIABLE = codesoftVariable;
		init();
	}

	private void init() throws CodesoftRuntimeException {
		getValue();
		getName();
		getAutoLength();
	}

	private Variant CODESOFT_VARIABLE = null;

	private Boolean autoLength = null;
	private String name = null;
	private String value = null;

	/*
	 * Returns the name of the variable.
	 */
	public String getName() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CODESOFT_VARIABLE.getDispatch(), "Name");
			this.name = object.toString();
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getName():" + ex.getMessage());
		}
		return name;
	}

	/*
	 * set the name of the variable
	 */
	public void setName(String name) throws CodesoftRuntimeException {
		try {
			Dispatch.call(CODESOFT_VARIABLE.getDispatch(), "Name", name);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getName():" + ex.getMessage());
		}
		this.name = name;
	}

	/*
	 * get the value of this variable
	 */
	public String getValue() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CODESOFT_VARIABLE.getDispatch(), "Value");
			this.value = object.toString();
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getValue():" + ex.getMessage());
		}
		return value;
	}

	/*
	 * set value of this variable
	 */
	public void setValue(String value) throws CodesoftRuntimeException {
		try {
			Dispatch.put(CODESOFT_VARIABLE.getDispatch(), "Value", value);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("setValue(value):" + ex.getMessage());
		}
		this.value = value;
	}

	/*
	 * get the retrieves the automatic maximum length option when variable is
	 * counter
	 */
	public Boolean getAutoLength() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CODESOFT_VARIABLE.getDispatch(), "AutoLength");
			this.autoLength = Boolean.parseBoolean(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getAutoLength():" + ex.getMessage());
		}
		return autoLength;
	}

}
