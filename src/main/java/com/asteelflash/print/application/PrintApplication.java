package com.asteelflash.print.application;


import com.asteelflash.print.app.utils.ActivexUtils;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public abstract class PrintApplication {

	public String APPLICATION_ID = null;
	public ThreadLocal<ActiveXComponent> ACTIVEX_COMPONENT = new ThreadLocal<ActiveXComponent>();

	public String getAPPLICATION_ID() {
		return APPLICATION_ID;
	}


	@SuppressWarnings("unused")
	private PrintApplication() {
	}

	public PrintApplication(String programID) {
		ComThread.InitSTA();
		APPLICATION_ID = programID;
		ActiveXComponent activeXComponent = ACTIVEX_COMPONENT.get();
		if (null == activeXComponent) {
			ACTIVEX_COMPONENT.set(ActivexUtils.getActiveComponentByProgramId(programID));
		}
	}

	public ActiveXComponent getPrintApplication() {
		return this.ACTIVEX_COMPONENT.get();
	}

	/*
	 * release active x component
	 */
	protected void release() {
		if (null != ACTIVEX_COMPONENT.get()) {
			ACTIVEX_COMPONENT.set(null);
		}
		ComThread.Release();
	}


	/*
	 * get property
	 */
	protected Variant getPropertyByName(String propertyName) throws Exception {
		return Dispatch.call(ACTIVEX_COMPONENT.get(), propertyName);
	}
	
	/*
	 * set property
	 */
	protected void setPropertyByName(String propertyName,Object i) throws Exception {
		 Dispatch.put(ACTIVEX_COMPONENT.get(),propertyName, i);
	}

}
