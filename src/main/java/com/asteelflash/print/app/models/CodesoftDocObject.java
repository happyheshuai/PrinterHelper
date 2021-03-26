package com.asteelflash.print.app.models;

import com.asteelflash.print.app.exceptions.CodesoftRuntimeException;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * @author Happy.He
 */

public class CodesoftDocObject {

	public CodesoftDocObject(Variant codesoftDocObject) throws CodesoftRuntimeException {
		this.CodesoftDocObject = codesoftDocObject;
		init();
	}

	private void init() throws CodesoftRuntimeException {
		getHeight();
		getWidth();
		getLeft();
		getMarginLeft();
		getMarginRight();
		getMarginTop();
		getMarginBottom();
		getName();
	}

	private Variant CodesoftDocObject;

	private Integer height = null;
	private Integer width = null;
	private Integer left = null;
	private Integer top = null;

	private Integer marginLeft = null;
	private Integer marginRight = null;
	private Integer marginTop = null;
	private Integer marginBottom = null;

	private String name = null;

	/*
	 * return current Code soft document object
	 */
	public Variant getCodesoftDocObject() {
		return CodesoftDocObject;
	}

	/*
	 * get height of the object
	 */
	public Integer getHeight() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(this.CodesoftDocObject.toDispatch(), "Height");
			this.height = Integer.parseInt(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getHeight():" + ex.getMessage());
		}
		return height;
	}

	/*
	 * set height of the object
	 */
	public void setHeight(Integer height) throws CodesoftRuntimeException {
		try {
			Dispatch.put(CodesoftDocObject.getDispatch(), "Height", height);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("setHeight():" + ex.getMessage());
		}
		this.height = height;
	}

	/*
	 * get with of the object
	 */
	public Integer getWidth() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CodesoftDocObject.getDispatch(), "Width");
			this.width = Integer.parseInt(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getWidth():" + ex.getMessage());
		}
		return width;
	}

	/*
	 * set with of the object
	 */
	public void setWidth(Integer width) throws CodesoftRuntimeException {
		try {
			Dispatch.put(CodesoftDocObject.getDispatch(), "width", width);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("setWidth():" + ex.getMessage());
		}
		this.width = width;
	}

	/*
	 * get the distance between the left edge of the anchor point of the object and
	 * the left edge of the document (in MeasureSystem unit).
	 */
	public Integer getLeft() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CodesoftDocObject.getDispatch(), "Left");
			this.left = Integer.parseInt(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getLeft():" + ex.getMessage());
		}
		return left;
	}

	/*
	 * set the distance between the left edge of the anchor point of the object and
	 * the left edge of the document
	 */
	public void setLeft(Integer left) throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CodesoftDocObject.toDispatch(), "Left", left);
			this.left = Integer.parseInt(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("setLeft():" + ex.getMessage());
		}
		this.left = left;
	}

	/*
	 * get the distance between the top edge of the anchor point of the object and
	 * the top edge of the document. (in MeasureSystem unit).
	 */

	public Integer getTop() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CodesoftDocObject.toDispatch(), "Top");
			this.top = Integer.parseInt(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getTop():" + ex.getMessage());
		}
		return top;
	}

	/*
	 * set the distance between the top edge of he anchor pint of the object and the
	 * top edge of the document
	 */
	public void setTop(Integer top) throws CodesoftRuntimeException {
		try {
			Dispatch.put(CodesoftDocObject.toDispatch(), "Top", top);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("setTop():" + ex.getMessage());
		}
		this.top = top;
	}

	/*
	 * gets the internal right margin of the Object.
	 */
	public Integer getMarginLeft() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CodesoftDocObject.getDispatch(), "MarginLeft");
			this.marginLeft = Integer.parseInt(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getMarginLeft()" + ex.getMessage());
		}
		return marginLeft;
	}

	/*
	 * set internal left margin of the object
	 */
	public void setMarginLeft(Integer marginLeft) throws CodesoftRuntimeException {
		try {
			Dispatch.put(CodesoftDocObject.getDispatch(), "MarginLeft", marginLeft);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("setMarginLeft():" + ex.getMessage());
		}
		this.marginLeft = marginLeft;
	}

	/*
	 * get internal left margin of the left
	 */
	public Integer getMarginRight() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CodesoftDocObject.getDispatch(), "MarginLeft");
			this.marginRight = Integer.parseInt(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getMarginRight()" + ex.getMessage());
		}
		return marginRight;
	}

	/*
	 * Set internal margin right of the object
	 */
	public void setMarginRight(Integer marginRight) throws CodesoftRuntimeException {
		try {
			Dispatch.put(CodesoftDocObject.getDispatch(), "MarginLeft", marginRight);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("setMarginRight():" + ex.getMessage());
		}
		this.marginRight = marginRight;
	}

	/*
	 * get internal margin top of the object
	 */
	public Integer getMarginTop() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CodesoftDocObject.getDispatch(), "MarginTop");
			this.marginTop = Integer.parseInt(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getMarginTop():" + ex.getMessage());
		}
		return marginTop;
	}

	/*
	 * set internal margin top of the object
	 */
	public void setMarginTop(Integer marginTop) throws CodesoftRuntimeException {
		try {
			Dispatch.put(CodesoftDocObject.getDispatch(), "MarginTop", marginTop);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("setMarginTop()" + ex.getMessage());
		}
		this.marginTop = marginTop;
	}

	/*
	 * get internal margin bottom of the object
	 */
	public Integer getMarginBottom() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CodesoftDocObject.getDispatch(), "MarginBottom");
			this.marginBottom = Integer.parseInt(object.toString());
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getMarginBottom():" + ex.getMessage());
		}
		return marginBottom;
	}

	/*
	 * set internal margin bottom of the object
	 */
	public void setMarginBottom(Integer marginBottom) throws CodesoftRuntimeException {
		try {
			Dispatch.call(CodesoftDocObject.getDispatch(), "MarginBottom", marginBottom);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("setMarginBottom():" + ex.getMessage());
		}
		this.marginBottom = marginBottom;
	}

	/*
	 * get name of the object
	 */
	public String getName() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(CodesoftDocObject.getDispatch(), "Name");
			this.name = object.toString();
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getName():" + ex.getMessage());
		}
		return name;
	}

	/*
	 * set visible
	 */
	public void setVisible(Boolean value) throws CodesoftRuntimeException {
		try {
			Dispatch.put(CodesoftDocObject.getDispatch(), "Visible", value);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("setVisible():" + ex.getMessage());
		}
	}

	/*
	 * set name of the object
	 */
	public void setName(String name) throws CodesoftRuntimeException {
		try {
			Dispatch.put(CodesoftDocObject.getDispatch(), "Name", name);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("setName():" + ex.getMessage());
		}
		this.name = name;
	}

}
