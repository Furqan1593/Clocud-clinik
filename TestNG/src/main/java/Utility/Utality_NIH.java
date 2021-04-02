package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utality_NIH {
	
	static File file;
	static FileInputStream fis;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	
	public Utality_NIH() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Utality_NIH(String excleName, String sheetName) throws Exception {
		file= new File("C:\\Users\\furqanm\\eclipse-workspace\\TestNG\\Excle\\login.xls.xlsx");//
		fis= new FileInputStream(file); // Start datadriven 
		workbook= new XSSFWorkbook(fis);
		sheet= workbook.getSheet("NIH Testing");
		
		

	}
	/*public String UserName=sheet.getRow(1).getCell(1).getStringCellValue();
	public String Password3=sheet.getRow(2).getCell(2).getStringCellValue();
	public String FirstName=sheet.getRow(0).getCell(0).getStringCellValue();
	public String LastName=sheet.getRow(0).getCell(0).getStringCellValue();
	public String LoginID=sheet.getRow(0).getCell(0).getStringCellValue();
	public String Password1=sheet.getRow(0).getCell(0).getStringCellValue();
	public String ConfirmPassword=sheet.getRow(0).getCell(0).getStringCellValue();
	public String DateOfBirth=sheet.getRow(0).getCell(0).getStringCellValue();
	public String Mobile=sheet.getRow(0).getCell(0).getStringCellValue();*/
	
	
	//public String name=sheet.getRow(0).getCell(0).getStringCellValue();
	//public String name=sheet.getRow(0).getCell(0).getStringCellValue();
	
	
	public XSSFSheet DataDriven() throws Exception
	{
		 file= new File("C:\\Users\\furqanm\\eclipse-workspace\\TestNG\\Excle\\login.xls.xlsx");//
		 fis= new FileInputStream(file); // Start datadriven 
		workbook= new XSSFWorkbook(fis);
		sheet= workbook.getSheet("NIH Testing");
		/*String Value=sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(Value);
		int rowcount=sheet.getPhysicalNumberOfRows();
		
		for (int i = 0; i < rowcount ; i++) {
			XSSFRow row=sheet.getRow(i);
			
			int cellcount=row.getPhysicalNumberOfCells();
			for (int j = 0; j < cellcount ; j++) {
			XSSFCell cell=row.getCell(j);
			
			String CellValue=getCellValue(cell);
			System.out.print(" || "+CellValue);
			}
			System.out.println();
		
		}*/
		return sheet;
		
	}
	public static String getCellValue(XSSFCell cell) {   // Change All the value into String Value 
		
		switch(cell.getCellType()) {
		case NUMERIC: 
			return String.valueOf(cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case STRING:
			return cell.getStringCellValue();
		case BLANK:
			return String.valueOf(cell.getNumericCellValue());
			
		default: 
			return cell.getStringCellValue();
		
		}                          // End Data Driven
	}
	
	public static void getcelldata(int rowNum, int cellNum)
	{
		XSSFCell cellData=sheet.getRow(rowNum).getCell(cellNum);
	}

}












