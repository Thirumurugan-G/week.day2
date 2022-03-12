package week5;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.DataProvider;

public class ReadExcel 
{	
	@DataProvider(name="Add")
	public static String[][]readData() throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook("E:\\\\Eclipse\\\\Eclipse 64 bit (2)\\\\MavenProject\\\\src\\\\main\\\\resources\\\\LoginData.xlsx");
		XSSFSheet sheet1 = workbook.getSheet("Sheet1");
		int rows = sheet1.getLastRowNum();
		System.out.println("rows "+rows);
		short cols = sheet1.getRow(0).getLastCellNum();
		System.out.println("cols "+cols);
		String[][] data=new String[rows][cols];
		for (int i = 1; i <=rows; i++) 
		{
			XSSFRow row = sheet1.getRow(i);
			for (int j = 0; j < cols; j++) 
			{
				DataFormatter formatter=new DataFormatter();
				data[i-1][j]= formatter.formatCellValue(row.getCell(j));
				System.out.println(data[i-1][j]);
				
			}
		}

		workbook.close();
		return data;
	}
}