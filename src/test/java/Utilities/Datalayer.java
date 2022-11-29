package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datalayer {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	static {
		File srcfile=new File("./Datafiles/Testdata.xlsx");
		try {
			FileInputStream fis=new FileInputStream(srcfile);
			try {
				workbook=new XSSFWorkbook(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static String getData(int sheetnum, int row, int col) {
		String celldata=workbook.getSheetAt(sheetnum).getRow(row).getCell(col).getStringCellValue();
		return celldata;	
	}
	
	/*
	 * public static void main(String args[]) {
	 * System.out.println(Datalayer.getData(0, 0, 1)); }
	 */
}
