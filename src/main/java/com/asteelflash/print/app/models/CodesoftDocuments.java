package com.asteelflash.print.app.models;

import com.asteelflash.print.app.exceptions.CodesoftRuntimeException;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import com.asteelflash.print.app.models.CodesoftDocument;

public class CodesoftDocuments {

	public CodesoftDocuments(Variant codesoftDocuments) throws CodesoftRuntimeException {
		this.codesoftDocuments = codesoftDocuments;
		init();
	}

	private Variant codesoftDocuments = null;

	private Integer count = null;
	private String defaultExt = null;

	private void init() throws CodesoftRuntimeException {
		getCount();
		getDefaultExt();
	}

	/*
	 * get the number of items in specified collection
	 */
	public Integer getCount() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(codesoftDocuments.toDispatch(), "Count");
			this.count = Integer.parseInt(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getCount():" + ex.getMessage());
		}
		return count;
	}

	/*
	 * get property of default document filename and extension for this application
	 */
	public String getDefaultExt() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(codesoftDocuments.toDispatch(), "DefaultExt");
			this.defaultExt = object.toString();
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getDefaultExt():" + ex.getMessage());
		}
		return this.defaultExt;
	}

	/*
	 * closes all documents
	 */
	public void closesAllDocuments(Boolean isSave) throws CodesoftRuntimeException {
		try {
			Dispatch.call(codesoftDocuments.toDispatch(), "CloseAll", isSave);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("closesAllDocuments():" + ex.getMessage());
		}
	}

	/*
	 * get document by index id
	 */
	public CodesoftDocument getDocumentByIndexId(Integer index) throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(codesoftDocuments.toDispatch(), "Item", index);
			return new CodesoftDocument(object);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getDocumentByIndexId(index):" + ex.getMessage());
		}
	}

	/*
	 * Open document
	 */
	public CodesoftDocument openDocument(String filePath, Boolean isReadonly) throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(codesoftDocuments.toDispatch(), "Open", filePath, isReadonly);
			return new CodesoftDocument(object);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getDocumentByIndexId(index):" + ex.getMessage());
		}
	}

}
