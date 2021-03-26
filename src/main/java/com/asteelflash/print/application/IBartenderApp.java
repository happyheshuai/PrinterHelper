package com.asteelflash.print.application;

import com.asteelflash.print.app.exceptions.BartenderRuntimeException;
import com.asteelflash.print.app.models.BartenderFormats;

public interface IBartenderApp {
	//Release Application
	public void release();
	//Save
	public boolean save() throws BartenderRuntimeException;
	//Returns the state of document printing.
	public boolean isPrinting()throws BartenderRuntimeException;
	//If true, BarTender application will be visible. If false, BarTender will run in the background.
	public void visible(boolean value) throws BartenderRuntimeException;
	//Returns a reference to the Formats collection object.
	public BartenderFormats getBartenderFormats() throws BartenderRuntimeException;	
}
