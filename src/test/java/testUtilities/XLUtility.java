package testUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	
static XSSFWorkbook wb;

public static Object[][] getDataFromloginSheet(String excelfile,String sheetName)
{	
	String [][]arr=null;
	
	try 
	{
		wb=new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/Data_Files/"+excelfile)));
		
		int row=getRows(sheetName);
		
		int column=getColumns(sheetName);
		
		arr=new String[row-1][column];
		
		for(int i=1;i<row;i++)
		{
			
			for(int j=0;j<column;j++)
			{
				arr[i-1][j]=getData(sheetName, i, j);		  	
			}
			
		}
		

	} 
	catch (FileNotFoundException e) 
	{
		System.out.println("Could not find the file "+e.getMessage());
	} 
	catch (IOException e) 
	{
		System.out.println("Could not load the file "+e.getMessage());
	}
	
	return arr;
}


public static int getRows(String sheetName)
{
	return wb.getSheet(sheetName).getPhysicalNumberOfRows();
}

public static int getColumns(String sheetName)
{
	return wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
}

public static String getData(String sheetName,int row,int column)
{
	XSSFCell cell=wb.getSheet(sheetName).getRow(row).getCell(column);
	
	String data="";
	
	if(cell.getCellType()==CellType.NUMERIC)
	{
     DataFormatter dataFormatter = new DataFormatter();
     data = dataFormatter.formatCellValue(cell);
	 //data=String.valueOf(cell.getNumericCellValue()); 
	}
	else if(cell.getCellType()==CellType.STRING)
	{
		data=cell.getStringCellValue();
	}
	else if(cell.getCellType()==CellType.BLANK)
	{
		data="";
	}
	
	else if(cell.getCellType()==CellType.FORMULA)
	{
		data=cell.getStringCellValue();
	}
	return data;
}
}
