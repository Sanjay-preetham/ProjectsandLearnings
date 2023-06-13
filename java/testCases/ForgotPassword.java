package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException; 
public class ForgotPassword {
	String[] data;
	String rstpswrdFile="C:\\Users\\Sanjay\\Documents\\Selenium TestCases\\ForgotPassword.xls";

	@DataProvider(name="EmailData")
	public String[] dataProvider() throws BiffException, IOException{
		data=emailExcelData();
		return data;
	}
	public String[] emailExcelData() throws BiffException, IOException{
		FileInputStream file=new FileInputStream(rstpswrdFile);
		Workbook workbook=Workbook.getWorkbook(file);
		Sheet sheet=workbook.getSheet("Sheet1");
		int row=sheet.getRows();
		String[] testData= new String[row-1];
		if(row!=0) {
			for (int i = 1,j=0; i <= row - 1; i++) {
				testData[i - 1]= sheet.getCell(j, i).getContents();
			}}
		return testData;
	}
	@DataProvider(name="PswrdData")
	public String[] dataprovider() throws BiffException, IOException {
		data=excelpswrd();
		return data;
	}
	public String[] excelpswrd() throws BiffException, IOException
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		FileInputStream file=new FileInputStream(rstpswrdFile);
		Workbook workbook=Workbook.getWorkbook(file);
		Sheet pswrdSheet=workbook.getSheet("Sheet2");
		int row=pswrdSheet.getRows();
		String[] paswrdSheet=new String[row-1];
		if(row!=0) {
		for(int i=1,j=0;i<=row-1;i++) {
			paswrdSheet[i-1]=pswrdSheet.getCell(j,i).getContents();
		}
		}
    	return paswrdSheet;
	}


	
}


