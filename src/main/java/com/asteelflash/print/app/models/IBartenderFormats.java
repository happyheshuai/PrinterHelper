package com.asteelflash.print.app.models;

import com.asteelflash.print.app.exceptions.BartenderRuntimeException;

public interface IBartenderFormats {
	// get bartender format count
	public Integer getFormatCount() throws BartenderRuntimeException;

	// get bartender format by index id
	public BartenderFormat getFormatById(Integer id) throws BartenderRuntimeException;

	// Open template by file name
	public BartenderFormat OpenTemplate(String fileName, Boolean closeOutFirstFormat, String usePrinter)
			throws BartenderRuntimeException;

	// Open template with password
	public BartenderFormat openTemplateWithPassword(String fileName, String password, Boolean closeOutFirstFormat,
			String usePrinter) throws BartenderRuntimeException;

}
