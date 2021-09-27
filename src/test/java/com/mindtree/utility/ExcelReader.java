package com.mindtree.utility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader
{
	public static Object[][] getexceldata(String sheet) throws IOException
	{
		FileInputStream file =new FileInputStream(Propertyfilereader.getXllocation());
	    XSSFWorkbook workbook=new XSSFWorkbook(file);
	    XSSFSheet sheett=workbook.getSheet(sheet);
	    Object[][] data=new Object[sheett.getLastRowNum()][sheett.getRow(0).getLastCellNum()];
	    for(int i=0;i<sheett.getLastRowNum();i++)
	    {
	    	for(int j=0;j<sheett.getRow(0).getLastCellNum();j++)
	    	{
	    		data[i][j]=sheett.getRow(i+1).getCell(j).toString();
	    	}
	    }
	 return data;
	}
}