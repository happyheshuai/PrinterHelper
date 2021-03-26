package com.asteelflash.print.app.models;

import com.asteelflash.print.app.exceptions.BartenderRuntimeException;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class BartenderFormat {

	private Variant bartenderFormat = null;
	private Boolean autoPrintAgain = null;
	private String baseName = null;
	private String comment = null;
	private String directory = null;
	private String fileName = null;
	private Boolean isModified = null;
	private String jobName = null;
	private Integer latestSaveNumber = null;
	private String encryption = null;
	private String printer = null;
	private String printerFile = null;
	private String title = null;
	private Boolean useDatabase = null;
	private Boolean useInputDataFile = null;

	public BartenderFormat(Variant bartenderFormat) throws BartenderRuntimeException {
		this.bartenderFormat = bartenderFormat;
		init();
	}

	private void init() throws BartenderRuntimeException {
		getAutoPrintAgain();
		getBaseName();
		getComment();
		getDirectory();
		getFileName();
		getIsModified();
		getJobName();
		getLatestSaveNumber();
		getEncryption();
		getPrinter();
		getPrinterFile();
		getTitle();
		getUseDatabase();
		getUseInputDataFile();
	}

	/*
	 * get autoPrintAgain
	 */
	public Boolean getAutoPrintAgain() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderFormat.toDispatch(), "AutoPrintAgain");
			Boolean value = Boolean.parseBoolean(object.toString());
			this.autoPrintAgain = value;
			return value;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("autoPrintAgain():" + ex.getMessage());
		}
	}

	/*
	 * set auto print again
	 */
	public void setAutoPrintAgain(Boolean value) throws BartenderRuntimeException {
		try {
			Dispatch.put(bartenderFormat.toDispatch(), "AutoPrintAgain", new Variant(value));
			this.autoPrintAgain = value;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("autoPrintAgain():" + ex.getMessage());
		}
	}

	/*
	 * Base Name
	 */
	public String getBaseName() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderFormat.toDispatch(), "BaseName");
			this.baseName = object.toString();
			return object.toString();
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getBaseName():" + ex.getMessage());
		}
	}

	/*
	 * get comment
	 */
	private String getComment() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderFormat.toDispatch(), "Comment");
			this.comment = object.toString();
			return object.toString();
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getComment():" + ex.getMessage());
		}
	}

	/*
	 * set comment
	 */
	public void setComment(String comment) throws BartenderRuntimeException {
		try {
			Dispatch.put(bartenderFormat.toDispatch(), "Comment", comment);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("setComment():" + ex.getMessage());
		}
		this.comment = comment;
	}

	/*
	 * Save template
	 */
	public void save() throws BartenderRuntimeException {
		@SuppressWarnings("unused")
		Variant object = null;
		try {
			object = Dispatch.call(bartenderFormat.toDispatch(), "Save");
		} catch (Exception ex) {
			throw new BartenderRuntimeException("save():" + ex.getMessage());
		}
	}

	/*
	 * Get databases
	 */
	public BartenderDatabases getDatabases() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderFormat.toDispatch(), "Databases");
			return new BartenderDatabases(object);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getDatabases():" + ex.getMessage());
		}
	}

	/*
	 * get directory
	 */
	public String getDirectory() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderFormat.toDispatch(), "Directory");
			this.directory = object.toString();
			return object.toString();
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getDirectory():" + ex.getMessage());
		}
	}

	/*
	 * get file name
	 */
	public String getFileName() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderFormat.getDispatch(), "FileName");
			this.fileName = object.toString();
			return object.toString();
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getFileName():" + ex.getMessage());
		}
	}

	/*
	 * get is modified
	 */
	public Boolean getIsModified() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderFormat.getDispatch(), "IsModified");
			Boolean result = Boolean.parseBoolean(object.toString());
			this.isModified = result;
			return result;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("IsModified():" + ex.getMessage());
		}

	}

	/*
	 * set is modified
	 */
	public void setIsModified(Boolean isModified) throws BartenderRuntimeException {
		try {
			Dispatch.put(bartenderFormat.toDispatch(), "IsModified", isModified);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("setIsModified():" + ex.getMessage());
		}
		this.isModified = isModified;
	}

	/*
	 * get job name
	 */
	public String getJobName() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderFormat.getDispatch(), "IsModified");
			String result = object.toString();
			this.jobName = result;
			return result;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getJobName():" + ex.getMessage());
		}
	}

	/*
	 * set job name
	 */
	public void setJobName(String jobName) throws BartenderRuntimeException {
		try {
			Dispatch.put(bartenderFormat.toDispatch(), "JobName", jobName);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("setJobName():" + ex.getMessage());
		}
		this.jobName = jobName;
	}

	/*
	 * get latest save number
	 */
	public Integer getLatestSaveNumber() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderFormat.getDispatch(), "LatestSaveNumber");
			Integer result = Integer.parseInt(object.toString());
			this.latestSaveNumber = result;
			return result;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getLatestSaveNumber():" + ex.getMessage());
		}
	}

	/*
	 * get named sub string
	 */
	public BtNamedSubStrings getNamedSubstring() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderFormat.getDispatch(), "NamedSubStrings");
			return new BtNamedSubStrings(object);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getNamedSubstring():" + ex.getMessage());
		}
	}

	/*
	 * get encryption
	 */
	public String getEncryption() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderFormat.getDispatch(), "Encryption");
			String result = object.toString();
			this.encryption = result;
			return result;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getEncryption():" + ex.getMessage());
		}
	}

	/*
	 * set encryption
	 */
	public void setEncryption(String encryption) throws BartenderRuntimeException {
		try {
			Dispatch.put(bartenderFormat.toDispatch(), "Encryption", encryption);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("setEncryption():" + ex.getMessage());
		}
		this.encryption = encryption;
	}

	/*
	 * get printer
	 */
	public String getPrinter() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderFormat.getDispatch(), "Printer");
			String result = object.toString();
			this.printer = result;
			return result;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getPrinter():" + ex.getMessage());
		}
	}

	/*
	 * set printer
	 */
	public void setPrinter(String printer) throws BartenderRuntimeException {
		try {
			Dispatch.put(bartenderFormat.toDispatch(), "Printer", printer);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("setPrinter():" + ex.getMessage());
		}
		this.printer = printer;
	}

	/*
	 * get printer file
	 */
	public String getPrinterFile() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderFormat.getDispatch(), "PrinterFile");
			String result = object.toString();
			this.printerFile = result;
			return result;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getPrinterFile():" + ex.getMessage());
		}
	}

	/*
	 * set printer file
	 */
	public void setPrinterFile(String printerFile) throws BartenderRuntimeException {
		try {
			Dispatch.put(bartenderFormat.toDispatch(), "PrinterFile", printerFile);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("setPrinterFile():" + ex.getMessage());
		}
		this.printerFile = printerFile;
	}

	/*
	 * get title
	 */
	public String getTitle() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderFormat.getDispatch(), "Title");
			String result = object.toString();
			this.title = result;
			return result;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getTitle():" + ex.getMessage());
		}
	}

	/*
	 * get use database
	 */
	public Boolean getUseDatabase() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderFormat.getDispatch(), "UseDatabase");
			Boolean result = Boolean.parseBoolean(object.toString());
			this.useDatabase = result;
			return result;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getUseDatabase():" + ex.getMessage());
		}
	}

	/*
	 * set use database
	 */
	public void setUseDatabase(Boolean useDatabase) throws BartenderRuntimeException {
		try {
			Dispatch.put(bartenderFormat.toDispatch(), "UseDatabase", useDatabase);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("setPrinterFile():" + ex.getMessage());
		}
		this.useDatabase = useDatabase;
	}

	/*
	 * get use input data file
	 */
	public Boolean getUseInputDataFile() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderFormat.getDispatch(), "UseInputDataFile");
			Boolean result = Boolean.parseBoolean(object.toString());
			this.useInputDataFile = result;
			return result;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getUseInputDataFile():" + ex.getMessage());
		}
	}

	/*
	 * set use input data file
	 */
	public void setUseInputDataFile(Boolean useInputDataFile) throws BartenderRuntimeException {
		try {
			Dispatch.put(bartenderFormat.toDispatch(), "UseInputDataFile", useInputDataFile);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("setUseInputDataFile():" + ex.getMessage());
		}
		this.useInputDataFile = useInputDataFile;
	}

	/*
	 * Returns the value of a named data source.
	 */
	public String getNamedSubStringValue(String SubStringName) throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderFormat.toDispatch(), "GetNamedSubStringValue", SubStringName);
			return object.toString();
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getNamedSubStringValue():" + ex.getMessage());
		}
	}

	/*
	 * Prints the document.
	 */
	public Integer printOut(Boolean showStatusWindow, Boolean showPrintDialog) throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderFormat.toDispatch(), "PrintOut", showStatusWindow, showPrintDialog);
			Integer value = Integer.parseInt(object.toString());
			return value;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("PrintOut():" + ex.getMessage());
		}
	}

	/*
	 * Sets the value of a named data source.
	 */
	public void setNamedSubStringValue(String subStringName, String value) throws BartenderRuntimeException {
		try {
			Dispatch.call(bartenderFormat.toDispatch(), "SetNamedSubStringValue", subStringName, value);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("setNamedSubStringValue():" + ex.getMessage());
		}
	}

	/*
	 * Close
	 */
	public void close() throws BartenderRuntimeException {
		try {
			Dispatch.call(bartenderFormat.toDispatch(), "Close", 1);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("close():" + ex.getMessage());
		}

	}

}
