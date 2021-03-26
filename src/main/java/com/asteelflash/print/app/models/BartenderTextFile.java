package com.asteelflash.print.app.models;

import com.asteelflash.print.app.exceptions.BartenderRuntimeException;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class BartenderTextFile {

	private Variant bartenderTextFile = null;

	private String delimitation;
	private String fieldDelimiter;
	private String fileName;

	private Integer numberOfFields;
	private Boolean useFieldNamesFromFirstRecord;

	public BartenderTextFile(Variant bartenderTextFile) throws BartenderRuntimeException {
		this.bartenderTextFile = bartenderTextFile;
		init();
	}

	private void init() throws BartenderRuntimeException {
		getDelimitation();
		getFieldDelimiter();
		getFileName();
		getNumberOfFields();
		getUseFieldNamesFromFirstRecord();
	}

	/*
	 * gets field delimitation type for a database text file.
	 */
	public String getDelimitation() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderTextFile.toDispatch(), "Delimitation");
			String value = object.toString();
			this.delimitation = value;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getDelimitation()" + ex.getMessage());
		}
		return this.delimitation;
	}

	/*
	 * set field delimitation type for a database text file
	 */
	public void setDelimitation(String delimitation) throws BartenderRuntimeException {
		try {
			Dispatch.put(bartenderTextFile.toDispatch(), "Delimitation", delimitation);

		} catch (Exception ex) {
			throw new BartenderRuntimeException("setDelimitation()" + ex.getMessage());
		}
		this.delimitation = delimitation;
	}

	/*
	 * gets the field delimiter for a text file
	 */
	public String getFieldDelimiter() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderTextFile.toDispatch(), "FieldDelimiter");
			String value = object.toString();
			this.fieldDelimiter = value;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getFieldDelimiter()" + ex.getMessage());
		}
		return this.fieldDelimiter;
	}

	/*
	 * set filed delimiter for a text file
	 */
	public void setFieldDelimiter(String fieldDelimiter) throws BartenderRuntimeException {
		try {
			Dispatch.put(bartenderTextFile.toDispatch(), "FieldDelimiter", fieldDelimiter);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("FieldDelimiter()" + ex.getMessage());
		}

		this.fieldDelimiter = fieldDelimiter;
	}

	/*
	 * gets database text file name
	 */
	public String getFileName() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderTextFile.toDispatch(), "FileName");
			String value = object.toString();
			this.fileName = value;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getFileName()" + ex.getMessage());
		}
		return fileName;
	}

	/*
	 * set database text file name
	 */
	public void setFileName(String fileName) throws BartenderRuntimeException {
		try {
			Dispatch.put(bartenderTextFile.toDispatch(), "FileName", fileName);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("setFileName()" + ex.getMessage());
		}
		this.fileName = fileName;
	}

	/*
	 * gets number of fields
	 */
	public Integer getNumberOfFields() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderTextFile.toDispatch(), "NumberOfFields");
			Integer value = Integer.parseInt(object.toString());
			this.numberOfFields = value;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getNumberOfFields()" + ex.getMessage());
		}
		return numberOfFields;
	}

	/*
	 * gets whether or not use first filed names form the first record of a text
	 * file
	 */
	public Boolean getUseFieldNamesFromFirstRecord() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(bartenderTextFile.toDispatch(), "UseFieldNamesFromFirstRecord");
			Boolean value = Boolean.parseBoolean(object.toString());
			this.useFieldNamesFromFirstRecord = value;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getUseFieldNamesFromFirstRecord()" + ex.getMessage());
		}
		return useFieldNamesFromFirstRecord;
	}

	/*
	 * set whether or not use first filed names form the first record of a text
	 */
	public void setUseFieldNamesFromFirstRecord(Boolean useFieldNamesFromFirstRecord) throws BartenderRuntimeException {
		try {
			Dispatch.put(bartenderTextFile.toDispatch(), "UseFieldNamesFromFirstRecord", useFieldNamesFromFirstRecord);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("setUseFieldNamesFromFirstRecord()" + ex.getMessage());
		}
		this.useFieldNamesFromFirstRecord = useFieldNamesFromFirstRecord;
	}

}
