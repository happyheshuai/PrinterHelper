package com.asteelflash.printerHelper;

import java.util.LinkedHashMap;
import java.util.Vector;

import com.asteelflash.print.app.utils.FTPCPrintHelper;

public class Test {
	public static void main(String[] args) throws Exception {
		Vector printList = new Vector();
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		linkedHashMap.put("Happy", "haha");
		printList.add(linkedHashMap);
		String labelFilePath = "D:\\var1.btw";
		FTPCPrintHelper.BartenderPrint(printList, labelFilePath, null);

	}

}
