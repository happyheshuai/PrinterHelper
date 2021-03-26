package com.asteelflash.print.app.utils;

import java.util.LinkedList;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.asteelflash.print.app.models.BartenderDatabaseConnection;
import com.asteelflash.print.app.models.BartenderDatasourceType;
import com.asteelflash.print.app.models.BartenderRecordSet;

public class BartenderDBConfigUtils implements BartenderDatasourceType {

	public BartenderDBConfigUtils() {
	}

	/*
	 * database configuration text builder
	 */
	public static String databaseConfigurationTextBuilder(LinkedList<BartenderDatabaseConnection> databaseConnections)
			throws Exception {
		Document document = DocumentHelper.createDocument();
		// DatabaseSetup
		Element databaseSetup = document.addElement("DatabaseSetup");
		databaseSetup.addNamespace("xsd", "http://www.w3.org/2001/XMLSchema");
		databaseSetup.addNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");

		// DatabaseConnections
		Element databaseConns = databaseSetup.addElement("DatabaseConnections");
		Boolean isEmpty = true;
		for (int i = 0; i < databaseConnections.size(); i++) {
			BartenderDatabaseConnection bartenderDatabaseConnection = databaseConnections.get(i);
			// Database Connection
			Element databaseConnection = databaseConns.addElement("DatabaseConnection");
			databaseConnection.addAttribute("Name", bartenderDatabaseConnection.getName());
			databaseConnection.addAttribute("Type", bartenderDatabaseConnection.getType());
			StringBuilder ConstrBuilder = new StringBuilder();
			ConstrBuilder.append("pathname=").append(bartenderDatabaseConnection.getPathName()).append(";");
			ConstrBuilder.append("codepage=").append(bartenderDatabaseConnection.getCodePage()).append(";");
			ConstrBuilder.append("first record is header=")
					.append(bartenderDatabaseConnection.getFirstRecordIsHeader().toString()).append(";");
			ConstrBuilder.append("delimitation=").append(bartenderDatabaseConnection.getDelimitation()).append(";");
			if (bartenderDatabaseConnection.getFieldCount() > 0) {
				ConstrBuilder.append("field count=").append(bartenderDatabaseConnection.getFieldCount().toString())
						.append(";");
			}
			if (null != bartenderDatabaseConnection.getFileDirPath()) {
				ConstrBuilder.append("filedirpath=").append(bartenderDatabaseConnection.getFileDirPath());
			}
			databaseConnection.addText(ConstrBuilder.toString());

			LinkedList<BartenderRecordSet> bartenderRecordSets = bartenderDatabaseConnection.getBartenderRecordSets();
			for (int j = 0; j < bartenderRecordSets.size(); j++) {
				BartenderRecordSet bartenderRecordSet = bartenderRecordSets.get(j);
				// RecordSets
				Element recordSets = databaseSetup.addElement("RecordSets");
				// RecordSet
				Element recordSet = recordSets.addElement("RecordSet");

				recordSet.addAttribute("Name", bartenderRecordSet.getName());
				recordSet.addAttribute("Connection", bartenderDatabaseConnection.getName());
				recordSet.addAttribute("Primary", bartenderRecordSet.getPirmary().toString());

				// SelectCommend
				Element selectCommend = recordSet.addElement("SelectCommand");
				selectCommend.addAttribute("Custom", bartenderRecordSet.getCustom().toString());
				selectCommend.addAttribute("ProviderParameters", bartenderRecordSet.getProviderParameters());
				selectCommend.setText(bartenderRecordSet.getSelectCommend());
			}
			isEmpty = false;
		}
		if (isEmpty) {
			return null;
		} else {
			return document.asXML().toString();
		}
	}

	/*
	 * get simple bartender DB configuration
	 */
	public static String getSimpleBartenderDBConfig(String connectionName, String dataSourceType, String filePath)
			throws Exception {
		LinkedList<BartenderDatabaseConnection> bartenderDatabaseConnections = new LinkedList<BartenderDatabaseConnection>();
		BartenderDatabaseConnection bartenderDatabaseConnection = new BartenderDatabaseConnection();
		bartenderDatabaseConnection.setName(connectionName);
		bartenderDatabaseConnection.setType(dataSourceType);
		// bartenderDatabaseConnection.setFileDirPath("D:\\");
		bartenderDatabaseConnection.setPathName(filePath);
		bartenderDatabaseConnection.setFirstRecordIsHeader(true);
		// bartenderDatabaseConnection.setFieldCount(2);
		BartenderRecordSet bartenderRecordSet = new BartenderRecordSet();
		bartenderRecordSet.setName("DB_1");
		bartenderRecordSet.setPirmary(true);
		bartenderRecordSet.setSelectCommend("select * from [DB_1]");
		bartenderDatabaseConnection.getBartenderRecordSets().add(bartenderRecordSet);
		bartenderDatabaseConnections.add(bartenderDatabaseConnection);
		return databaseConfigurationTextBuilder(bartenderDatabaseConnections);
	}
}
