package com.asteelflash.print.app.models;

import com.asteelflash.print.app.exceptions.CodesoftRuntimeException;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class CodesoftDatabaseVariables {

	public CodesoftDatabaseVariables(Variant codesoftDatabaseVariables) throws CodesoftRuntimeException {
		this.CODESOFT_DATABASE_VARIBALES = codesoftDatabaseVariables;
		init();
	}

	private void init() throws CodesoftRuntimeException {
		getCount();
	}

	private Variant CODESOFT_DATABASE_VARIBALES = null;

	private Integer count = null;

	/*
	 * Returns the number of items in the specified collection.
	 */
	public Integer getCount() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CODESOFT_DATABASE_VARIBALES.getDispatch(), "Count");
			this.count = Integer.parseInt(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getCount():" + ex.getMessage());
		}
		return count;
	}

	

}
