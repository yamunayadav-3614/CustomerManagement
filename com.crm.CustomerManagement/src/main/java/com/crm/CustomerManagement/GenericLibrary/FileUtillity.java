package com.crm.CustomerManagement.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * @author Yamuna Yadav
 * This class is a selenium class which is used to read and update data from property and excel file.
 */
public class FileUtillity {
	/**
	 * This method is a generic method which is used to read data from property file.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDatafromProperty(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IpathConstants.propertypath);
	Properties p=new Properties();
	p.load(fis);
	String data= p.getProperty(key);
	return data;
}
	/**
	 * This method is a generic method which is used to read string data from excel file.
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelStringData(String sheet,int row,int cell) throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream(IpathConstants.excelpath);
 Workbook wb=WorkbookFactory.create(fis);
String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
 return data;
}
/**
 * This method is a generic method which is used to read numeric data from excel file.
 * @param sheet
 * @param row
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String readDataFromExcelNumericData(String sheet,int row,int cell) throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream(IpathConstants.excelpath);
 Workbook wb=WorkbookFactory.create(fis);
String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
 return data;
}
	/**
	 * This method is a generic method which is used to update data into excel file.
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void updateDataIntoExcel(String sheet,int row,int cell,String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IpathConstants.excelpath);
 Workbook wb=WorkbookFactory.create(fis);
 wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(value);
 FileOutputStream fos=new FileOutputStream(IpathConstants.excelpath );
 wb.write(fos);
 wb.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
