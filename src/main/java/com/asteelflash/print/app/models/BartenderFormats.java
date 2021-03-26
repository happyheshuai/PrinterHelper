package com.asteelflash.print.app.models;

import com.asteelflash.print.app.exceptions.BartenderRuntimeException;
import com.asteelflash.print.application.BartenderApp;
import com.asteelflash.print.app.models.BartenderFormat;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class BartenderFormats implements IBartenderFormats {

	private BartenderApp bartenderApp = null;
	private Variant dFormats = null;

	public BartenderFormats(BartenderApp bartenderApp) throws Exception {
		this.bartenderApp = bartenderApp;
		init();
	}

	private void init() throws BartenderRuntimeException {
		dFormats = _getFormatsObject();
	}

	/*
	 * get format count
	 */
	public Integer getFormatCount() throws BartenderRuntimeException {
		Object object = Dispatch.call(dFormats.toDispatch(), "Count");
		return Integer.parseInt(object.toString());
	}

	// get bartender formats object
	private Variant _getFormatsObject() throws BartenderRuntimeException {
		Variant obj = null;
		try {
			obj = Dispatch.call(bartenderApp.ACTIVEX_COMPONENT.get(), "Formats");
		} catch (Exception ex) {
			throw new BartenderRuntimeException("_getFormatsObject():" + ex.getMessage());
		}
		return obj;
	}

	// get bartender format by index id
	public BartenderFormat getFormatById(Integer id) throws BartenderRuntimeException {
		Variant obj = null;
		try {
			obj = Dispatch.call(dFormats.toDispatch(), "GetFormat", id);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getFormatById():" + ex.getMessage());
		}
		return new BartenderFormat(obj);
	}

	// Open template by file name
	public BartenderFormat OpenTemplate(String fileName, Boolean closeOutFirstFormat, String usePrinter)
			throws BartenderRuntimeException {
		Variant obj = null;
		try {
			obj = Dispatch.call(dFormats.toDispatch(), "Open", fileName, closeOutFirstFormat, usePrinter);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("OpenTemplate():" + ex.getMessage());
		}
		return new BartenderFormat(obj);
	}

	// Open template with password
	public BartenderFormat openTemplateWithPassword(String fileName, String password, Boolean closeOutFirstFormat,
			String usePrinter) throws BartenderRuntimeException {
		Variant obj = null;
		try {
			obj = Dispatch.call(dFormats.toDispatch(), "OpenWithPassword", fileName, password, closeOutFirstFormat,
					usePrinter);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("OpenTemplate():" + ex.getMessage());
		}
		return new BartenderFormat(obj);
	}

}
