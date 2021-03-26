package com.asteelflash.print.app.models;

import com.asteelflash.print.app.exceptions.BartenderRuntimeException;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class BartenderDatabases implements IBartenderDatabases {

	public BartenderDatabases(Variant bartenderDatabases) {
		this.bartenderDatabases = bartenderDatabases;
	}

	private Variant bartenderDatabases = null;
	private String configuration = null;

	private Integer count = null;

	/*
	 * get database by id
	 */

	public BartenderDatabase getDatabaseById(Integer id) throws BartenderRuntimeException {
		Variant obj = null;
		try {
			obj = Dispatch.call(bartenderDatabases.toDispatch(), "GetDatabase", id);
			return new BartenderDatabase(obj);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getDatabaseById():" + ex.getMessage());
		}
	}

	/*
	 * get configuration
	 */
	public String getConfiguration() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderDatabases.toDispatch(), "Configuration");
			this.configuration = object.toString();
			return this.configuration;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getConfiguration():" + ex.getMessage());
		}
	}

	/*
	 * set configuration
	 */
	public void setConfiguration(String configuration) throws BartenderRuntimeException {
		try {
			Dispatch.put(bartenderDatabases.getDispatch(), "Configuration", configuration);
			this.configuration = configuration;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("setConfiguration():" + ex.getMessage());
		}
	}

	/*
	 * get count
	 */
	public Integer getCount() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderDatabases.getDispatch(), "Count");
			this.count = Integer.parseInt(object.toString());
			return this.count;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getCount()" + ex.getMessage());
		}

	}

}
