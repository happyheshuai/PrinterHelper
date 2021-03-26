package com.asteelflash.print.app.models;

public class BartenderRecordSet {

	public BartenderRecordSet() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConnection() {
		return connection;
	}
	public void setConnection(String connection) {
		this.connection = connection;
	}
	public Boolean getPirmary() {
		return pirmary;
	}
	public void setPirmary(Boolean pirmary) {
		this.pirmary = pirmary;
	}
	public String getSelectCommend() {
		return selectCommend;
	}
	public void setSelectCommend(String selectCommend) {
		this.selectCommend = selectCommend;
	}
	public Boolean getCustom() {
		return custom;
	}
	public void setCustom(Boolean custom) {
		this.custom = custom;
	}
	public String getProviderParameters() {
		return providerParameters;
	}
	public void setProviderParameters(String providerParameters) {
		this.providerParameters = providerParameters;
	}

	private String name;
	private String connection;
	private Boolean pirmary = true;
	
	private String selectCommend;
	private Boolean custom = false;
	private String providerParameters = "";

}
