package com.asteelflash.print.app.models;

import com.asteelflash.print.app.exceptions.CodesoftRuntimeException;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class CodesoftDocument {

	public CodesoftDocument(Variant codesoftDocument) throws CodesoftRuntimeException {
		this.codesoftDocument = codesoftDocument;
		init();
	}

	private void init() throws CodesoftRuntimeException {
		getAutoPageIncrement();
		getBackground();
		getFullName();
		getIsModified();
		getName();
		getPrinter();
		getReadOnly();
		getVersion();

	}

	private Variant codesoftDocument = null;

	private Boolean autoPageIncrement = null;
	private Boolean background = null;

	private String fullName = null;
	private Boolean isModified = null;
	private String name = null;
	private String printer = null;
	private Boolean readOnly = null;

	private Long version = null;

	/*
	 * get allows to print the last label of a page without incrementing the page
	 * (switch to next page).
	 */
	public Boolean getAutoPageIncrement() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(codesoftDocument.getDispatch(), "AutoPageIncrement");
			this.autoPageIncrement = Boolean.parseBoolean(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getAutoPageIncrement():" + ex.getMessage());
		}
		return autoPageIncrement;
	}

	/*
	 * set allows to print the last label of a page without incrementing the page
	 * (switch to next page).
	 */
	public void setAutoPageIncrement(Boolean autoPageIncrement) throws CodesoftRuntimeException {
		try {
			Dispatch.put(codesoftDocument.getDispatch(), "AutoPageIncrement", autoPageIncrement);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("setAutoPageIncrement():" + ex.getMessage());
		}
		this.autoPageIncrement = autoPageIncrement;
	}

	/*
	 * get the background object associated with the document
	 */
	public Boolean getBackground() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(codesoftDocument.getDispatch(), "Background");
			this.background = Boolean.parseBoolean(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getBackground():" + ex.getMessage());
		}
		return background;
	}

	/*
	 * Returns the Database object associated with the document.
	 */
	public CodesoftDatabase getDatabase() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(codesoftDocument.toDispatch(), "Database");
			return new CodesoftDatabase(object);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getDatabase():" + ex.getMessage());
		}
	}

	/*
	 * Returns the file specification for the document, including the path.
	 */
	public String getFullName() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(codesoftDocument.getDispatch(), "FullName");
			this.fullName = object.toString();
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getFullName():" + ex.getMessage());
		}
		return fullName;
	}

	/*
	 * Tests that the document has been modified since the last save operation.
	 */
	public Boolean getIsModified() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(codesoftDocument.getDispatch(), "IsModified");
			this.isModified = Boolean.parseBoolean(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getIsModified():" + ex.getMessage());
		}
		return isModified;
	}

	/*
	 * Returns the document name. Default property.
	 */
	public String getName() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(codesoftDocument.getDispatch(), "Name");
			this.name = object.toString();
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getName():" + ex.getMessage());
		}
		return name;
	}

	/*
	 * Returns the Printer object that represents the associated printer.
	 */
	public String getPrinter() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(codesoftDocument.getDispatch(), "Printer");
			this.printer = object.toString();
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getPrinter():" + ex.getMessage());
		}
		return printer;
	}

	/*
	 * True, if the changes of the current document cannot be saved to the original
	 * document.
	 */
	public Boolean getReadOnly() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(codesoftDocument.getDispatch(), "ReadOnly");
			this.readOnly = Boolean.parseBoolean(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getReadOnly():" + ex.getMessage());
		}
		return readOnly;
	}

	/*
	 * Returns the Variables collection that represents all the created Variable
	 * objects in the document.
	 */
	public CodesoftVariables getVariables() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(codesoftDocument.getDispatch(), "Variables");
			return new CodesoftVariables(object);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getVariables():" + ex.getMessage());
		}
	}

	/*
	 * get serialization version of document file
	 */
	public Long getVersion() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(codesoftDocument.getDispatch(), "Version");
			this.version = Long.parseLong(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getVersion():" + ex.getMessage());
		}
		return version;
	}

	/*
	 * get document objects of document file
	 */
	public CodesoftDocObjects getDocObjects() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(codesoftDocument.getDispatch(), "DocObjects");
			return new CodesoftDocObjects(object);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getDocObjects():" + ex.getMessage());
		}
	}

	/*
	 * close document
	 */
	public void colse(Boolean isSave) throws CodesoftRuntimeException {
		try {
			Dispatch.call(codesoftDocument.getDispatch(), "Close", isSave);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("colse():" + ex.getMessage());
		}
	}

	/*
	 * End process job
	 */
	public void formFeed() throws CodesoftRuntimeException {
		try {
			Dispatch.call(codesoftDocument.getDispatch(), "FormFeed");
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("formFeed():" + ex.getMessage());
		}
	}

	/*
	 * prints documents and executes an automatic form feed
	 */
	public void printDocument(Integer quantity) throws CodesoftRuntimeException {
		try {
			Dispatch.call(codesoftDocument.getDispatch(), "PrintDocument", quantity);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("printDocument():" + ex.getMessage());
		}
	}

	/*
	 * print this document
	 */
	public void printLabel(Integer quantity) throws CodesoftRuntimeException {
		try {
			Dispatch.call(codesoftDocument.getDispatch(), "PrintLabel", quantity);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("printLabel():" + ex.getMessage());
		}
	}

	/*
	 * save current document
	 */

	public void save() throws CodesoftRuntimeException {
		try {
			Dispatch.call(codesoftDocument.getDispatch(), "Save");
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("save():" + ex.getMessage());
		}
	}

}
