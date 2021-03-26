package com.asteelflash.print.app.models;

import java.util.LinkedList;

public class BartenderDatabaseConnection {

	public BartenderDatabaseConnection() {
	}

	private String name;
	private String type;
	private String pathName;
	private Integer codePage = 65001;
	private Boolean firstRecordIsHeader = true;
	private String delimitation = "Comma";
	private Integer fieldCount = 0;
	private String fileDirPath;

	private LinkedList<BartenderRecordSet> bartenderRecordSets = new LinkedList<BartenderRecordSet>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = "@" + name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public Integer getCodePage() {
		return codePage;
	}

	public void setCodePage(Integer codePage) {
		this.codePage = codePage;
	}

	public Boolean getFirstRecordIsHeader() {
		return firstRecordIsHeader;
	}

	public void setFirstRecordIsHeader(Boolean firstRecordIsHeader) {
		this.firstRecordIsHeader = firstRecordIsHeader;
	}

	public String getDelimitation() {
		return delimitation;
	}

	public void setDelimitation(String delimitation) {
		this.delimitation = delimitation;
	}

	public Integer getFieldCount() {
		return fieldCount;
	}

	public void setFieldCount(Integer fieldCount) {
		this.fieldCount = fieldCount;
	}

	public String getFileDirPath() {
		return fileDirPath;
	}

	public void setFileDirPath(String fileDirPath) {
		this.fileDirPath = fileDirPath;
	}

	public LinkedList<BartenderRecordSet> getBartenderRecordSets() {
		return bartenderRecordSets;
	}

}
