package com.asteelflash.print.application;

import java.io.IOException;

import com.asteelflash.print.app.exceptions.BartenderRuntimeException;
import com.asteelflash.print.app.models.BartenderFormats;
import com.asteelflash.print.app.utils.WindowsTaskManager;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class BartenderApp extends PrintApplication implements IBartenderApp {

	public Integer buildNumber = null;
	public String processID = null;
	public String edition = null;
	public String fullVersion = null;
	public String version = null;

	public String getProcessID() {
		return processID;
	}

	public String getEdition() {
		return edition;
	}

	public String getFullVersion() {
		return fullVersion;
	}

	public BartenderApp() throws Exception {
		super("BarTender.Application");
		init();
	}

	private void init() throws BartenderRuntimeException {
		getBuildNumber();
		getApplicationEdition();
		getApplicationFullVersion();
		getApplicationProcessID();
		getApplicationVersion();
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
					Dispatch.call(ACTIVEX_COMPONENT.get(), "Quit", 1);
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
	 * get build number
	 */
	public Integer getBuildNumber() throws BartenderRuntimeException {
		Object buildNumber = null;
		try {
			buildNumber = getPropertyByName("BuildNumber");
			Integer bnumber = Integer.parseInt(buildNumber.toString());
			this.buildNumber = bnumber;
			return bnumber;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BartenderRuntimeException("_getBuildNumber():" + ex.getMessage());
		}
	}

	/*
	 * get application edition
	 */
	/**
	 * Name:getApplicationEdition Description: get application edition number
	 * Author:Happy.He CreationTime:Jan 18, 2021 12:46:15 PM
	 */
	public String getApplicationEdition() throws BartenderRuntimeException {
		Object obj = null;
		try {
			obj = getPropertyByName("Edition");
			this.edition = obj.toString();
			return obj.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BartenderRuntimeException("_getApplicationEdition():" + ex.getMessage());
		}

	}

	/*
	 * Returns the version of the BarTender application, including any applicable
	 * service release numbers.
	 */
	public String getApplicationFullVersion() throws BartenderRuntimeException {
		Object obj = null;
		try {
			obj = getPropertyByName("FullVersion");
			this.fullVersion = obj.toString();
			return obj.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BartenderRuntimeException("_getApplicationFullVersion():" + ex.getMessage());
		}
	}

	// Returns the Process Identifier number by which Windows recognizes the
	// BarTender process.
	public String getApplicationProcessID() throws BartenderRuntimeException {
		Object obj = null;
		try {
			obj = getPropertyByName("ProcessID");
			this.processID = obj.toString();
			return obj.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BartenderRuntimeException("_getApplicationProcessID():" + ex.getMessage());
		}
	}

	// Returns the version of the BarTender application.
	public String getApplicationVersion() throws BartenderRuntimeException {
		Object obj = null;
		try {
			obj = getPropertyByName("Version");
			this.version = obj.toString();
			return obj.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BartenderRuntimeException("_getApplicationVersion():" + ex.getMessage());
		}
	}

	/*
	 * Saves all open BarTender documents
	 */
	public boolean save() throws BartenderRuntimeException {
		Variant result = null;
		try {
			/*
			 * btPromptSave = 0, btDoNotSaveChanges = 1, btSaveChanges = 2
			 */
			result = Dispatch.call(ACTIVEX_COMPONENT.get(), "Save", false);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BartenderRuntimeException("Save():" + ex.getMessage());
		}
		return Boolean.parseBoolean(result.toString());

	}

	// Returns the state of document printing.
	public boolean isPrinting() throws BartenderRuntimeException {
		Object result = false;
		try {
			result = getPropertyByName("IsPrinting");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BartenderRuntimeException("isPrinting()" + ex.getMessage());
		}
		return Boolean.parseBoolean(result.toString());
	}

	// If true, BarTender application will be visible. If false, BarTender will run
	// in the background.
	public void visible(boolean value) throws BartenderRuntimeException {
		try {
			setPropertyByName("Visible", value);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BartenderRuntimeException("visible(true/false)" + ex.getMessage());
		}

	}

	// Returns a reference to the Formats collection object.
	public BartenderFormats getBartenderFormats() throws BartenderRuntimeException {
		try {
			return new BartenderFormats(this);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BartenderRuntimeException("getBartenderFormats()" + ex.getMessage());
		}
	}

}
