package com.asteelflash.print.app.models;

import com.asteelflash.print.app.exceptions.CodesoftRuntimeException;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class CodesoftDatabase {

	public CodesoftDatabase(Variant codesoftDatabase) throws CodesoftRuntimeException {
		this.CODESOFT_DATABASE = codesoftDatabase;
		init();
	}

	private void init() throws CodesoftRuntimeException {
		getConnectionString();
		getCreatingVariables();
		getBof();
		getEof();
		getIsOpen();
		getQueryFileName();
		getQueryString();

	}

	private Variant CODESOFT_DATABASE = null;

	private String connectionString = null;
	private Boolean creatingVariables = null;

	private Boolean bof = null;
	private Boolean eof = null;
	private Boolean isOpen = null;

	private String queryFileName = null;
	private String queryString = null;

	/*
	 * return describing the current database connection
	 */
	public String getConnectionString() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CODESOFT_DATABASE.toDispatch(), "ConnectionString");
			this.connectionString = object.toString();
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getConnectionString():" + ex.getMessage());
		}
		return connectionString;
	}

	/*
	 * get automatic creation of database variable when database connected
	 */
	public Boolean getCreatingVariables() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CODESOFT_DATABASE.toDispatch(), "CreatingVariables");
			this.creatingVariables = Boolean.parseBoolean(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getCreatingVariables():" + ex.getMessage());
		}
		return creatingVariables;
	}

	/*
	 * set automatic creation of database variable when database connected
	 */
	public void setCreatingVariables(Boolean creatingVariables) throws CodesoftRuntimeException {
		try {
			Dispatch.put(CODESOFT_DATABASE.getDispatch(), "CreatingVariables", creatingVariables);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("setCreatingVariables():" + ex.getMessage());
		}
		this.creatingVariables = creatingVariables;
	}

	/*
	 * Returns a value that indicates whether the current row position is after the
	 * last row in the current record set.
	 */
	public Boolean getBof() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CODESOFT_DATABASE.toDispatch(), "BOF");
			this.bof = Boolean.parseBoolean(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getBof():" + ex.getMessage());
		}
		return bof;
	}

	/*
	 * Returns a value that indicates whether the current row position is after the
	 * last row in the current record set.
	 */
	public Boolean getEof() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CODESOFT_DATABASE.toDispatch(), "EOF");
			this.eof = Boolean.parseBoolean(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getEof():" + ex.getMessage());
		}
		return eof;
	}

	/*
	 * test if the database object has been open successfully
	 */
	public Boolean getIsOpen() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CODESOFT_DATABASE.toDispatch(), "IsOpen");
			this.isOpen = Boolean.parseBoolean(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getIsOpen():" + ex.getMessage());
		}
		return isOpen;
	}

	/*
	 * return the name of the query file used
	 */
	public String getQueryFileName() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CODESOFT_DATABASE.toDispatch(), "QueryFileName");
			this.queryFileName = object.toString();
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getQueryFileName():" + ex.getMessage());
		}
		return queryFileName;
	}

	/*
	 * get the string defining the current query
	 */
	public String getQueryString() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CODESOFT_DATABASE.toDispatch(), "QueryString");
			this.queryString = object.toString();
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getQueryString():" + ex.getMessage());
		}
		return queryString;
	}

	/*
	 * close an opened database
	 */
	public void close() throws CodesoftRuntimeException {
		try {
			Dispatch.call(CODESOFT_DATABASE.toDispatch(), "Close");
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("close():" + ex.getMessage());
		}
	}

}
