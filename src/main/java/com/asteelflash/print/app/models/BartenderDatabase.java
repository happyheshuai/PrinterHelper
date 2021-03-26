package com.asteelflash.print.app.models;

import com.asteelflash.print.app.exceptions.BartenderRuntimeException;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class BartenderDatabase {

	public BartenderDatabase(Variant bartenderDatabase) {
		this.bartenderDatabase = bartenderDatabase;
	}

	private Variant bartenderDatabase = null;
	private String configuration = null;

	private String type;

	/*
	 * get database configuration
	 */
	public String getConfiguration() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderDatabase.toDispatch(), "Configuration");
			this.configuration = object.toString();
			return configuration;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getConfiguration():" + ex.getMessage());
		}
	}

	/*
	 * set database configuration
	 */
	public void setConfiguration(String configuration) throws BartenderRuntimeException {
		try {
			Dispatch.put(bartenderDatabase.toDispatch(), "Configuration", configuration);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("setConfiguration():" + ex.getMessage());
		}
		this.configuration = configuration;
	}

	/*
	 * gets text file
	 */
	public BartenderTextFile getTextFile() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderDatabase.toDispatch(), "TextFile");
			return new BartenderTextFile(object);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getConfiguration():" + ex.getMessage());
		}
	}

	/*
	 * gets database type
	 */
	public String getType() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderDatabase.getDispatch(),"Type");
			String value = object.toString();
			this.type = value;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getType():" + ex.getMessage());
		}
		return type;
	}

}
