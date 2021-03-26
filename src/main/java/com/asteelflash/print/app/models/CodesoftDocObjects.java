package com.asteelflash.print.app.models;

import com.asteelflash.print.app.exceptions.CodesoftRuntimeException;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * @author Happy.He
 */
public class CodesoftDocObjects {

	private Variant codesoftDocObjs;

	public CodesoftDocObjects(Variant codesoftDocObjs) throws CodesoftRuntimeException {
		this.codesoftDocObjs = codesoftDocObjs;
		init();
	}

	private Integer count = null;

	private void init() throws CodesoftRuntimeException {
		getCount();
	}

	/*
	 * Returns the number of items in the specified collection.
	 */
	public Integer getCount() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(codesoftDocObjs.toDispatch(), "Count");
			this.count = Integer.parseInt(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getCount()" + ex.getMessage());
		}
		return count;
	}

	/*
	 * get an member by item name or index id
	 */
	public CodesoftDocObject getItem(String name) throws CodesoftRuntimeException {
		try {
			Variant object = Dispatch.call(codesoftDocObjs.toDispatch(), "Item", name);
			return new CodesoftDocObject(object);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getItem():" + ex.getMessage());
		}
	}

}
