package com.asteelflash.print.application;

import java.io.IOException;

import com.asteelflash.print.app.exceptions.CodesoftRuntimeException;
import com.asteelflash.print.app.models.CodesoftDocuments;
import com.asteelflash.print.app.utils.WindowsTaskManager;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class CodesoftApp extends PrintApplication implements ICodesoftApp {

	public CodesoftApp() throws Exception {
		super("lppx2.application");
		init();
	}

	private String processID = null;
	private String activePrinterName = null;
	private String caption = null;
	private String defaultFilePath = null;
	private String fullName = null;
	private Long height = null;
	private Boolean isEval = null;
	private Long left = null;
	private Boolean locked = null;
	private String name = null;
	private String path = null;
	private String programCode = null;
	private Long top = null;
	private Boolean userControl = null;
	private Boolean useUserInterface = null;
	private String version = null;
	private Boolean visible = null;
	private Long width = null;

	private void init() throws CodesoftRuntimeException {
		getProcessID();
		getActivePrinterName();
		getDefaultFilePath();
		getCaption();
		getFullName();
		getHeight();
		getIsDemoVersion();
		getLeft();
		getLocked();
		getName();
		getPath();
		getProgramCode();
		getTop();
		getUserControl();
		getUseUserInterface();
		getVisible();
		getVersion();
		getWidth();
	}

	/*
	 * release
	 */
	@Override
	public void release() {
		if (null != ACTIVEX_COMPONENT.get()) {
			if (null != processID) {
				try {
					WindowsTaskManager.killTask(Integer.parseInt(processID));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		super.release();
	}

	/*
	 * get current process id
	 */
	public String getProcessID() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = getPropertyByName("PID");
			this.processID = object.toString();
			return processID;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("getProcessID():" + ex.getMessage());
		}
	}

	/*
	 * get active Printer name
	 */
	public String getActivePrinterName() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = getPropertyByName("ActivePrinterName");
			this.activePrinterName = object.toString();
			return activePrinterName;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("getActivePrinterName():" + ex.getMessage());
		}
	}

	/*
	 * get caption text
	 */
	public String getCaption() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = getPropertyByName("Caption");
			this.caption = object.toString();
			return caption;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("getCaption():" + ex.getMessage());
		}

	}

	/*
	 * set caption text
	 */
	public void setCaption(String caption) throws CodesoftRuntimeException {
		try {
			setPropertyByName("Caption", caption);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("setCaption():" + ex.getMessage());
		}
		this.caption = caption;
	}

	/*
	 * get default file path
	 */
	public String getDefaultFilePath() throws CodesoftRuntimeException {
		try {
			Variant object = getPropertyByName("DefaultFilePath");
			this.defaultFilePath = object.toString();
			return defaultFilePath;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("getDefaultFilePath():" + ex.getMessage());
		}

	}

	/*
	 * get full name
	 */
	public String getFullName() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = getPropertyByName("FullName");
			this.fullName = object.toString();
			return fullName;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("getFullName():" + ex.getMessage());
		}

	}

	/*
	 * get the height of the ma 	in window of the application (in pixel unit).
	 */
	public Long getHeight() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = getPropertyByName("Height");
			this.height = Long.parseLong(object.toString());
			return height;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("getHeight():" + ex.getMessage());
		}
	}

	/*
	 * set the height of the main window of the application (in pixel unit).
	 */
	public void setHeight(Long height) throws CodesoftRuntimeException {
		try {
			setPropertyByName("Height", height);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("setHeight():" + ex.getMessage());
		}
		this.height = height;
	}

	/*
	 * get application is a demo version.
	 */
	public Boolean getIsDemoVersion() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = getPropertyByName("IsEval");
			this.isEval = Boolean.parseBoolean(object.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("getIsDemoVersion():" + ex.getMessage());
		}
		return isEval;
	}

	/*
	 * get the distance between the left edge of the main window of the application
	 * and the left edge of the screen (in pixel unit).
	 */
	public Long getLeft() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = getPropertyByName("Left");
			this.left = Long.parseLong(object.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("getLeft():" + ex.getMessage());
		}
		return left;
	}

	/*
	 * set the distance between the left edge of the main window of the application
	 * and the left edge of the screen (in pixel unit).
	 */
	public void setLeft(Long left) throws CodesoftRuntimeException {
		try {
			setPropertyByName("Left", left);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("setLeft():" + ex.getMessage());
		}
		this.left = left;
	}

	/*
	 * get Locks the User Interface if True.
	 */
	public Boolean getLocked() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = getPropertyByName("Locked");
			this.locked = Boolean.parseBoolean(object.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("getLocked():" + ex.getMessage());
		}
		return locked;
	}

	/*
	 * set Locks the User Interface if True.
	 */
	public void setLocked(Boolean locked) throws CodesoftRuntimeException {
		try {
			setPropertyByName("Locked", locked);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("setLocked():" + ex.getMessage());
		}
		this.locked = locked;
	}

	/*
	 * get name of the application
	 */
	public String getName() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = getPropertyByName("Name");
			this.name = object.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("getName():" + ex.getMessage());
		}
		return name;
	}

	/*
	 * return the path of this application
	 */
	public String getPath() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = getPropertyByName("Path");
			this.path = object.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("getPath():" + ex.getMessage());
		}
		return path;
	}

	/*
	 * get the program code
	 */
	public String getProgramCode() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = getPropertyByName("ProgramCode");
			this.programCode = object.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("getProgramCode():" + ex.getMessage());
		}
		return programCode;
	}

	/*
	 * gets the distance between the top edge of the main window of the application
	 * and the top edge of the screen (in pixel unit).
	 */
	public Long getTop() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = getPropertyByName("Top");
			this.top = Long.parseLong(object.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("getSharedOwner():" + ex.getMessage());
		}
		return top;
	}

	/*
	 * sets the distance between the top edge of the main window of the application
	 * and the top edge of the screen (in pixel unit).
	 */
	public void setTop(Long top) throws CodesoftRuntimeException {
		try {
			setPropertyByName("Top", top);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("setTop():" + ex.getMessage());
		}
		this.top = top;
	}

	/*
	 * True if the application was created by the user. False if the application was
	 * created in programming (with the CreateObject or GetObject method in Visual
	 * Basic).
	 */
	public Boolean getUserControl() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = getPropertyByName("UserControl");
			this.userControl = Boolean.parseBoolean(object.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("getUserControl():" + ex.getMessage());
		}
		return userControl;
	}

	/*
	 * gets dialog boxes interfaces that are masked in ActiveX invisible mode.
	 */
	public Boolean getUseUserInterface() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = getPropertyByName("UseUserInterface");
			this.useUserInterface = Boolean.parseBoolean(object.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("getUseUserInterface():" + ex.getMessage());
		}
		return useUserInterface;
	}

	/*
	 * sets dialog boxes interfaces that are masked in ActiveX invisible mode.
	 */
	public void setUseUserInterface(Boolean useUserInterface) throws CodesoftRuntimeException {
		try {
			setPropertyByName("UseUserInterface", useUserInterface);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("setUseUserInterface():" + ex.getMessage());
		}
		this.useUserInterface = useUserInterface;
	}

	/*
	 * get visible
	 */
	public Boolean getVisible() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = getPropertyByName("Visible");
			this.visible = Boolean.parseBoolean(object.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("getVisible():" + ex.getMessage());
		}
		return visible;
	}

	/*
	 * set visible
	 */
	public void setVisible(Boolean visible) throws CodesoftRuntimeException {
		try {
			setPropertyByName("Visible", visible);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("setVisible():" + ex.getMessage());
		}
		this.visible = visible;
	}

	public Long getWidth() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = getPropertyByName("Width");
			this.width = Long.parseLong(object.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("getWidth():" + ex.getMessage());
		}
		return width;
	}

	public void setWidth(Long width) throws CodesoftRuntimeException {
		try {
			setPropertyByName("Width", width);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("setWidth():" + ex.getMessage());
		}
		this.width = width;
	}

	/*
	 * get version
	 */
	public String getVersion() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = getPropertyByName("Version");
			this.version = object.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("getVersion():" + ex.getMessage());
		}
		return version;
	}

	/*
	 * Returns the date of last version of the document (stored on hard drive or
	 * LabelArchive database)
	 */
	public String documentStatus(String docName) throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(ACTIVEX_COMPONENT.get(), "DocumentStatus", docName);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("documentStatus(docName):" + ex.getMessage());
		}
		return object.toString();
	}

	/*
	 * Returns the string message error associated with the error code parameter.
	 * Return value: Message associated.
	 */
	public String ErrorMessage(Integer intErrorCode) throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(ACTIVEX_COMPONENT.get(), "ErrorMessage", intErrorCode);
			return object.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("ErrorMessage(intErrorCode):" + ex.getMessage());
		}
	}

	/*
	 * Returns the last error code generated.
	 */
	public Integer GetLastError() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = Dispatch.call(ACTIVEX_COMPONENT.get(), "GetLastError");
			return Integer.parseInt(object.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CodesoftRuntimeException("GetLastError():" + ex.getMessage());
		}

	}
	/*
	 * Returns the document object
	 */
	public CodesoftDocuments getDocuments() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = this.ACTIVEX_COMPONENT.get().getProperty("Documents");
			return new CodesoftDocuments(object);
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("getDocument():" + ex.getMessage());
		}
	}

	/*
	 * Quits the current application. No effect if the application has been launched
	 * manually. First executes a Document.CloseAll (False) then releases the
	 * application.
	 */
	public void quit() throws CodesoftRuntimeException {
		Variant object = null;
		try {
			object = getPropertyByName("Quit");
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("quit():" + ex.getMessage());
		}
	}

}
