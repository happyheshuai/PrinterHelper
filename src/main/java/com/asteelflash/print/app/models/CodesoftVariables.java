package com.asteelflash.print.app.models;

import com.asteelflash.print.app.exceptions.CodesoftRuntimeException;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class CodesoftVariables {

	public CodesoftVariables(Variant codesoftVariables) throws CodesoftRuntimeException {
		this.CODESOFT_VARIABLES = codesoftVariables;
		init();
	}

	private void init() throws CodesoftRuntimeException {
		getCount();
	}

	private Variant CODESOFT_VARIABLES = null;

	private Integer count = null;

	/*
	 * Returns the number of items in the specified collection.
	 */
	public Integer getCount() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CODESOFT_VARIABLES.getDispatch(), "Count");
			this.count = Integer.parseInt(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getCount():" + ex.getMessage());
		}
		return count;
	}

	/*
	 * Returns a member of a collection, either by position or by name.
	 */
	public CodesoftVariable getItemByName(String itemName) throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CODESOFT_VARIABLES.getDispatch(), "Item", itemName);
			return new CodesoftVariable(object);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getItemByName():" + ex.getMessage());
		}
	}

}
