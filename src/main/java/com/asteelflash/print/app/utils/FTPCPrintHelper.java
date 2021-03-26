package com.asteelflash.print.app.utils;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Vector;

import com.asteelflash.print.app.models.BartenderDatabase;
import com.asteelflash.print.app.models.BartenderDatabases;
import com.asteelflash.print.app.models.BartenderFormat;
import com.asteelflash.print.app.models.BartenderFormats;
import com.asteelflash.print.app.models.BartenderTextFile;
import com.asteelflash.print.app.models.CodesoftDocument;
import com.asteelflash.print.app.models.CodesoftDocuments;
import com.asteelflash.print.app.models.FTPCResult;
import com.asteelflash.print.application.BartenderApp;
import com.asteelflash.print.application.CodesoftApp;

public class FTPCPrintHelper {

	public FTPCPrintHelper() {
	}

	/*
	 * print for bartender
	 */
	public static FTPCResult BartenderPrint(Vector<LinkedHashMap<String, String>> dataCollection, String labelFilePath,
			String printerName) {
		FTPCResult ftpcResult = new FTPCResult();
		String printer = "";
		if (null != printerName) {
			printer = printerName;
		}
		BartenderApp bartenderApp = null;
		File tempCSVFile = null;

		try {
			bartenderApp = new BartenderApp();
			Boolean isPrinting = bartenderApp.isPrinting();
			if (isPrinting) {
				ftpcResult.setResult(false);
				ftpcResult.setMessage("The document is printing....");
				if (null != bartenderApp) {
					bartenderApp.release();
				}
				return ftpcResult;
			}

			// bartender formats
			BartenderFormats bartenderFormats = bartenderApp.getBartenderFormats();
			// bartender format
			BartenderFormat bartenderFormat = bartenderFormats.OpenTemplate(labelFilePath, false, printer);
			// databases
			BartenderDatabases databases = bartenderFormat.getDatabases();
			// count of database
			Integer countOfDatabase = databases.getCount();
			// CSV file
			tempCSVFile = CSVFileHelper.getPrintCsvFileForFTPC(dataCollection);

			// version
			Double version = Double.parseDouble(bartenderApp.getApplicationVersion());
			if (version <= 10) {
				if (countOfDatabase <= 0) {
					ftpcResult.setMessage("No any database found , pelease to check you database setting!!");
					ftpcResult.setResult(false);
					if (null != bartenderApp) {
						bartenderApp.release();
						tempCSVFile.delete();
					}
					return ftpcResult;
				}

				BartenderDatabase bartenderDatabase = databases.getDatabaseById(1);
				// database type 0 = textFile
				String databaseType = bartenderDatabase.getType();
				if (!databaseType.equals("0")) {
					ftpcResult.setMessage("Incorrect database type!!");
					ftpcResult.setResult(false);
					if (null != bartenderApp) {
						tempCSVFile.delete();
					}
					return ftpcResult;
				}
				BartenderTextFile bartenderTextFile = bartenderDatabase.getTextFile();
				bartenderTextFile.setFileName(tempCSVFile.getAbsolutePath());

			} else {
				String dbConfiguration = BartenderDBConfigUtils.getSimpleBartenderDBConfig("Conn1",
						BartenderDBConfigUtils.TEXT_FILE, tempCSVFile.getAbsolutePath());
				databases.setConfiguration(dbConfiguration);
			}

			bartenderFormat.setUseDatabase(true);
			// bartenderFormat.save();
			// String dbConfig = databases.getConfiguration();
			// System.out.println(dbConfig);
			Integer printResult = bartenderFormat.printOut(false, false);
			bartenderApp.release();
			tempCSVFile.delete();
			ftpcResult.setObject(printResult);
		} catch (Exception ex) {
			if (bartenderApp != null) {
				bartenderApp.release();
				bartenderApp = null;
				ftpcResult.setResult(false);
				ftpcResult.setMessage(ex.getLocalizedMessage());
				return ftpcResult;
			}
			if (null != tempCSVFile) {
				tempCSVFile.delete();
			}
		}
		return ftpcResult;
	}

	/*
	 * print for code soft
	 */
	public static FTPCResult CodesoftPrint(Vector<LinkedHashMap<String, String>> dataCollection, String labelFilePath,
			String printerName) {
		FTPCResult ftpcResult = new FTPCResult();
		CodesoftApp codesoftApp = null;
		try {
			codesoftApp = new CodesoftApp();
			CodesoftDocuments codesoftDocuments = codesoftApp.getDocuments();
			CodesoftDocument codesoftDocument = codesoftDocuments.openDocument(labelFilePath, false);
			codesoftDocument = CSVFileHelper.createCodesoftPrintDocument(dataCollection, codesoftDocument);
			codesoftDocument.formFeed();
			codesoftDocument.colse(false);		
			codesoftApp.release();
		} catch (Exception ex) {
			if (codesoftApp != null) {
				codesoftApp.release();
				codesoftApp = null;
				ftpcResult.setResult(false);
				ftpcResult.setMessage(ex.getLocalizedMessage());
				return ftpcResult;
			}
		}
		return ftpcResult;
	}
}
