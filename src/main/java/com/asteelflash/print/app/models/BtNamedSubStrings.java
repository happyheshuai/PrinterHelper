package com.asteelflash.print.app.models;

import com.asteelflash.print.app.exceptions.BartenderRuntimeException;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class BtNamedSubStrings {

	public BtNamedSubStrings(Variant namedSubString) throws BartenderRuntimeException {
		this.namedSubString = namedSubString;
		init();
	}

	private Variant namedSubString = null;

	private Integer count = null;
	private String allNamedSubStringText = null;

	private void init() throws BartenderRuntimeException {
		getCount();
		getAllNamedSubStringText(",", ",");
	}

	/*
	 * get sub string by index id
	 */
	public BtSubString getSubStringByIndexId(Integer index) throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(this.namedSubString.toDispatch(), "GetSubString", index);
			return new BtSubString(object);
		} catch (Exception ex) {
			throw new BartenderRuntimeException("getSubStringByIndexId():" + ex.getMessage());
		}
	}

	/*
	 * get count
	 */
	public Integer getCount() throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(this.namedSubString.toDispatch(), "Count");
			Integer value = Integer.parseInt(object.toString());
			this.count = value;
			return value;

		} catch (Exception ex) {
			throw new BartenderRuntimeException("getCount():" + ex.getMessage());
		}
	}

	/*
	 * get all
	 */
	public String getAllNamedSubStringText(String nameValueDelimiter, String recordDelimter)
			throws BartenderRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(this.namedSubString.toDispatch(), "GetAll", nameValueDelimiter, recordDelimter);
			String value = object.toString();
			this.allNamedSubStringText = value;
			return value;

		} catch (Exception ex) {
			throw new BartenderRuntimeException("getAllNamedSubStringText():" + ex.getMessage());
		}
	}

}
