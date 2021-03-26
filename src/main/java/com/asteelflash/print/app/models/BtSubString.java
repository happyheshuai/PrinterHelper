package com.asteelflash.print.app.models;

import com.asteelflash.print.app.exceptions.BartenderRuntimeException;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class BtSubString {

	private Variant btSubString = null;

	private String name = null;
	private Boolean rollover = null;

	private String rolloverLimit = null;
	private String rolloverResetValue = null;

	private String serializeBy = null;
	private Integer serializeEvery = null;
	private String type = null;

	private String value = null;

	public BtSubString(Variant btSubString) throws BartenderRuntimeException {
		this.btSubString = btSubString;
		init();
	}

	private void init() throws BartenderRuntimeException {
		getName();
		getRollover();
		getRolloverResetValue();
		getRolloverLimit();
		getSerializeBy();
		getSerializeEvery();
		getType();
		getValue();
	}

	/*
	 * get name
	 */
	public String getName() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(btSubString.toDispatch(), "Name");
			String value = object.toString();
			this.name = value;
			return value;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getName():" + ex.getMessage());
		}
	}

	/*
	 * get rollover
	 */
	public Boolean getRollover() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(btSubString.toDispatch(), "Rollover");
			Boolean value = Boolean.parseBoolean(object.toString());
			this.rollover = value;
			return value;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getRollover():" + ex.getMessage());
		}
	}

	/*
	 * set rollover
	 */
	public void setRollover(Boolean rollover) throws BartenderRuntimeException {
		try {
			Dispatch.put(btSubString.toDispatch(), "Rollover", rollover);
			this.rollover = rollover;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("setRollover():" + ex.getMessage());
		}
	}

	/*
	 * get rollover reset value
	 */
	public String getRolloverResetValue() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(btSubString.toDispatch(), "RolloverResetValue");
			String value = object.toString();
			this.rolloverResetValue = value;
			return value;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("RolloverResetValue():" + ex.getMessage());
		}
	}

	/*
	 * set rollover reset value
	 */
	public void setRolloverResetValue(String rolloverResetValue) throws BartenderRuntimeException {
		try {
			Dispatch.put(btSubString.toDispatch(), "RolloverResetValue", rolloverResetValue);
			this.rolloverResetValue = rolloverResetValue;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("rolloverResetValue():" + ex.getMessage());
		}
	}

	/*
	 * get rollover limit
	 */
	public String getRolloverLimit() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(btSubString.toDispatch(), "RolloverLimit");
			String value = object.toString();
			this.rolloverLimit = value;
			return value;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getRolloverLimit():" + ex.getMessage());
		}
	}

	/*
	 * set rollover limit
	 */
	public void setRolloverLimit(String rolloverLimit) throws BartenderRuntimeException {
		try {
			Dispatch.put(btSubString.toDispatch(), "RolloverLimit", rolloverLimit);
			this.rolloverLimit = rolloverLimit;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("setRolloverLimit():" + ex.getMessage());
		}
	}

	/*
	 * get seriallize by
	 */
	public String getSerializeBy() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(btSubString.toDispatch(), "SerializeBy");
			String value = object.toString();
			this.serializeBy = value;
			return value;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getSerializeBy():" + ex.getMessage());
		}
	}

	/*
	 * set seriallize by
	 */
	public void setSerializeBy(String serializeBy) throws BartenderRuntimeException {
		try {
			Dispatch.put(btSubString.toDispatch(), "SerializeBy", serializeBy);
			this.serializeBy = serializeBy;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("setSerializeBy():" + ex.getMessage());
		}
	}

	/*
	 * set serialize every
	 */
	public void setSerializeEvery(Integer serializeEvery) throws BartenderRuntimeException {
		try {
			Dispatch.put(btSubString.toDispatch(), "SerializeEvery", serializeEvery);
			this.serializeEvery = serializeEvery;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("setSerializeEvery():" + ex.getMessage());
		}
	}

	/*
	 * get serialize every
	 */
	public Integer getSerializeEvery() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(btSubString.toDispatch(), "SerializeEvery");
			Integer value = Integer.parseInt(object.toString());
			this.serializeEvery = value;
			return value;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getSerializeEvery():" + ex.getMessage());
		}
	}

	/*
	 * get type
	 */
	public String getType() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(btSubString.toDispatch(), "Type");
			String value = object.toString();
			this.type = value;
			return value;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getType():" + ex.getMessage());
		}
	}

	/*
	 * set type
	 */
	public void setType(String type) throws BartenderRuntimeException {
		try {
			Dispatch.put(btSubString.toDispatch(), "Type", type);
			this.type = type;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("setType():" + ex.getMessage());
		}
	}

	/*
	 * get value
	 */
	public String getValue() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(btSubString.toDispatch(), "Value");
			String value = object.toString();
			this.value = value;
			return value;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getValue():" + ex.getMessage());
		}
	}

	/*
	 * set value
	 */
	public void setValue(String value) throws BartenderRuntimeException {
		try {
			Dispatch.put(btSubString.toDispatch(), "Value", value);
			this.value = value;
		} catch (Exception ex) {
			throw new BartenderRuntimeException("setValue():" + ex.getMessage());
		}
	}

}
