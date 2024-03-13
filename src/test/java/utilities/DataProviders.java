package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="inputdataforcar")
	public String[][] getinputdetails() throws IOException{
		String path=".\\testData\\input.xlsx";
		ExcelDataFile util=new ExcelDataFile(path);
		int totalrows=util.getRowCount("sheet1");
		int totalcols=util.getCellCount("sheet1",1);
		
		String inputdetails[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				inputdetails[i-1][j]=util.getCellData("sheet1", i, j);
				
			}
		}
		return inputdetails;
		
	}
}
