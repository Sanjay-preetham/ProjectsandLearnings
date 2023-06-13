package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import org.testng.annotations.DataProvider;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class SbsDataprovider {
	
	String[][] data;
	String sbsQtvalue = "C:\\Users\\Sanjay\\Documents\\Selenium TestCases\\LoginTestCases.xls";

	@DataProvider(name="SbsQTValuesSell")
	public String[][] dataProvider() throws BiffException, IOException{
		data=sbsExcelData();
		return data;
	}
	public String[][] sbsExcelData() throws BiffException, IOException{
		FileInputStream excel = new FileInputStream(sbsQtvalue);
		Workbook wrkBook = Workbook.getWorkbook(excel);
		Sheet loginSheet = wrkBook.getSheet("Sheet2");

		int col = loginSheet.getColumns();
		int row = loginSheet.getRows();

		String[][] testdata = new String[row - 1][col];

		for (int i = 1; i <= row - 1; i++) {
			for (int j = 0; j < col; j++) {
				testdata[i - 1][j] = loginSheet.getCell(j, i).getContents();
			}}
		return testdata;
	}
	
	
	@DataProvider(name="SbsQTValuesBuy")
	public String[][] dataprovider() throws BiffException, IOException{
		data=sbsExcelData1();
		return data; }
	
	public String[][] sbsExcelData1() throws BiffException, IOException{
		FileInputStream excel = new FileInputStream(sbsQtvalue);
		Workbook wrkBook = Workbook.getWorkbook(excel);
		Sheet loginSheet = wrkBook.getSheet("Sheet3");
		int col = loginSheet.getColumns();
		int row = loginSheet.getRows();
		String[][] testdata = new String[row - 1][col];
		for (int i = 1; i <= row - 1; i++) {
			for (int j = 0; j < col; j++) {
				testdata[i - 1][j] = loginSheet.getCell(j, i).getContents();
			}}
		return testdata;
	}
	
	@DataProvider(name="SbsSearch")
	public String[][] dataprovider1() throws BiffException, IOException{
		data=sbsExcelData1();
		return data; }
	
	public String[][] sbsExcelData2() throws BiffException, IOException{
		FileInputStream excel = new FileInputStream(sbsQtvalue);
		Workbook wrkBook = Workbook.getWorkbook(excel);
		Sheet loginSheet = wrkBook.getSheet("Sheet4");
		int col = loginSheet.getColumns();
		int row = loginSheet.getRows();
		String[][] testdata = new String[row - 1][col];
		for (int i = 1; i <= row - 1; i++) {
			for (int j = 0; j < col; j++) {
				testdata[i - 1][j] = loginSheet.getCell(j, i).getContents();
			}}
		return testdata;
	}

}
