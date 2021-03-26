package com.asteelflash.print.app.utils;

import com.jacob.activeX.ActiveXComponent;

public class ActivexUtils {
	/*
	 * get active x component by program id
	 */
	public static ActiveXComponent getActiveComponentByProgramId(String programID) {
		ActiveXComponent component = null;
		try {
			component = new ActiveXComponent(programID);
		} catch (Exception e) {
			return null;
		}
		return component;
	}
}
