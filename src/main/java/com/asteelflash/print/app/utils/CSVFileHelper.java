package com.asteelflash.print.app.utils;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;

import com.asteelflash.print.app.exceptions.BartenderRuntimeException;
import com.asteelflash.print.app.exceptions.CodesoftRuntimeException;
import com.asteelflash.print.app.models.CodesoftDocument;
import com.asteelflash.print.app.models.CodesoftVariables;

public class CSVFileHelper {

	public CSVFileHelper() {
	}

	/*
	 * get now text string
	 */
	private static String getNowText() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return simpleDateFormat.format(new Date()).toString();
	}

	/*
	 * get keys from map
	 */
	private static LinkedList<String> getkeysFromMap(HashMap<String, String> map) {
		LinkedList<String> keys = new LinkedList<String>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey().toString();
			keys.add(key);
		}
		return keys;
	}

	/*
	 * list to text line
	 */
	private static String list2TextLine(LinkedList<String> list) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			String element = list.get(i);
			stringBuffer.append(element).append(",");
		}
		String tempText = stringBuffer.toString();
		return tempText.substring(0, tempText.length() - 1);
	}

	/*
	 * create temp csv file
	 */
	private static File createTempCsvFile() throws Exception {
		String nowText = getNowText();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		File file = File.createTempFile("LAB_FTPC_" + nowText + "_" + uuid, ".csv");
		return file;
	}

	/*
	 * get print csv file
	 */
	public static File getPrintCsvFileForFTPC(Vector<LinkedHashMap<String, String>> vector)
			throws BartenderRuntimeException {
		File inputFile = null;
		PrintWriter printWriter = null;
		try {
			inputFile = createTempCsvFile();
			// get header
			LinkedHashMap<String, String> firstElement = vector.get(0);
			LinkedList<String> headerList = getkeysFromMap(firstElement);
			String headerStr = list2TextLine(headerList);
			// print writer
			printWriter = new PrintWriter(inputFile);
			// header
			printWriter.write(headerStr + "\n");
			for (int i = 0; i < vector.size(); i++) {
				boolean isAppend = true;
				StringBuffer stringBufferTextLine = new StringBuffer();
				LinkedHashMap<String, String> item = vector.get(i);
				for (int j = 0; j < headerList.size(); j++) {
					String headerItem = headerList.get(j);
					String field = item.get(headerItem);
					if (null == field) {
						isAppend = false;
						continue;
					} else {
						stringBufferTextLine.append(field).append(",");
					}
				}
				if (isAppend) {
					String tempTextLine = stringBufferTextLine.toString();
					tempTextLine = tempTextLine.substring(0, tempTextLine.length() - 1);
					printWriter.write(tempTextLine + "\n");
				}
			}
			printWriter.close();
		} catch (Exception ex) {
			if (null != printWriter) {
				printWriter.close();
			}
			throw new BartenderRuntimeException("getPrintCsvFileForFTPC():" + ex.getMessage());
		}
		return inputFile;
	}

	/*
<<<<<<< HEAD
	 * create print document for codesoft
=======
	 * create print document for CodeSoft
>>>>>>> happy Jan.06.2021
	 */
	public static CodesoftDocument createCodesoftPrintDocument(Vector<LinkedHashMap<String, String>> vector,
			CodesoftDocument codesoftDocument) throws CodesoftRuntimeException {
		try {
			// get header
			LinkedHashMap<String, String> firstElement = vector.get(0);
			LinkedList<String> headerList = getkeysFromMap(firstElement);
			// header
			CodesoftVariables codesoftVariables = codesoftDocument.getVariables();
			for (int i = 0; i < vector.size(); i++) {
				boolean isAppend = true;
				LinkedHashMap<String, String> item = vector.get(i);
				for (int j = 0; j < headerList.size(); j++) {
					String headerItem = headerList.get(j);
					String field = item.get(headerItem);
					if (null == field) {
						isAppend = false;
						continue;
					} else {
						codesoftVariables.getItemByName(headerItem).setValue(field);
					}
				}
				if (isAppend) {
					codesoftDocument.printLabel(1);
				}
			}
		} catch (Exception ex) {
			throw new CodesoftRuntimeException("createCodesoftPrintDocument():" + ex.getMessage());
		}
		return codesoftDocument;
	}

	/*
	 * getTestDataCollection
	 */
	public static Vector<LinkedHashMap<String, String>> getTestDataCollection() {
		Vector<LinkedHashMap<String, String>> printCollection = new Vector<LinkedHashMap<String, String>>();
		for (int i = 0; i < 10000; i++) {
			LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
			map.put("Account", "Meritek");
			map.put("PartNumber", "550-123456ME-R");
			map.put("PartRevision", "A");
			printCollection.add(map);
		}
		/*
		 * LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		 * map.put("Account", "aMeritek"); map.put("PartNumber", "a550-123456ME-R");
		 * map.put("PartRevision", "aA"); printCollection.add(map);
		 */
		return printCollection;
	}

	public static void main(String[] args) throws Exception {
		Vector<LinkedHashMap<String, String>> printCollection = getTestDataCollection();
		File csvFile = getPrintCsvFileForFTPC(printCollection);
		System.out.println(csvFile.getAbsolutePath());
		System.out.println("Done..................");

	}

}
