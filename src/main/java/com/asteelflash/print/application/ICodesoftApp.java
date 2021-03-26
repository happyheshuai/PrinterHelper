package com.asteelflash.print.application;

import com.asteelflash.print.app.exceptions.CodesoftRuntimeException;
import com.asteelflash.print.app.models.CodesoftDocuments;

public interface ICodesoftApp {
	/*
	 * Returns the date of last version of the document (stored on hard drive or
	 * LabelArchive database)
	 */
	public String documentStatus(String docName) throws CodesoftRuntimeException;

	/*
	 * Returns the string message error associated with the error code parameter.
	 * Return value: Message associated.
	 */
	public String ErrorMessage(Integer intErrorCode) throws CodesoftRuntimeException;

	/*
	 * Returns the last error code generated.
	 */
	public Integer GetLastError() throws CodesoftRuntimeException;

	/*
	 * Returns the document object
	 */
	public CodesoftDocuments getDocuments() throws CodesoftRuntimeException;

	/*
	 * Quits the current application. No effect if the application has been launched
	 * manually. First executes a Document.CloseAll (False) then releases the
	 * application.
	 */
	public void quit() throws CodesoftRuntimeException;

}
