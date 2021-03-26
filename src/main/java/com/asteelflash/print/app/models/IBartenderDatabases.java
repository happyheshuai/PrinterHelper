package com.asteelflash.print.app.models;

import com.asteelflash.print.app.exceptions.BartenderRuntimeException;

public interface IBartenderDatabases {
	/*
	 * get database by id
	 */
	public BartenderDatabase getDatabaseById(Integer id) throws BartenderRuntimeException;

	/*
	 * get configuration
	 */

	public String getConfiguration() throws BartenderRuntimeException;
	
	/*
	 * set configuration
	 * */
	
	public void setConfiguration(String value) throws BartenderRuntimeException;
}
