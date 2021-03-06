package Datamining;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

// THIS IS A UTILITY CLASS, IT EXTRACTS EXCEL FILE INTO A String[][]


public class Dataextractor{
	//private static String datapath = Datasetting.datapath;
	private static String datapath = Datasetting.datapath;
	private static String datapath2 = Datasetting.datapath2;
	
	
	public static void setpath(String path)
	{
		datapath = path;
	}
	
	public static String[][] getDatasteam() throws IOException, InvalidFormatException {
		
    	Workbook workbook = WorkbookFactory.create(new File(datapath));
    	
    	Sheet sheet = workbook.getSheetAt(0);
    	
        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // 1. You can obtain a rowIterator and columnIterator and iterate over them
        Iterator<Row> rowIterator = sheet.rowIterator();
        
        String[][] dataarray = new String[sheet.getPhysicalNumberOfRows()][6];       
        int rownum = 0;
        int colnum = 0;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();
            colnum = -1;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                cellValue = cellValue.replaceAll("\\p{C}", "?");
                //System.out.print(cellValue + "\t");
                colnum = colnum+1;
                dataarray[rownum][colnum] = cellValue;                         
            }
            //System.out.println();
            rownum = rownum+1;
        }
        workbook.close();
        return dataarray;  	
    }
	
	public static String[][] getDataepic() throws IOException, InvalidFormatException {
		
    	Workbook workbook = WorkbookFactory.create(new File(datapath2));
    	
    	Sheet sheet = workbook.getSheetAt(0);
    	
        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // 1. You can obtain a rowIterator and columnIterator and iterate over them
        Iterator<Row> rowIterator = sheet.rowIterator();
        
        String[][] dataarray = new String[sheet.getPhysicalNumberOfRows()][6];       
        int rownum = 0;
        int colnum = 0;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();
            colnum = -1;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                cellValue = cellValue.replaceAll("\\p{C}", "?");
                //System.out.print(cellValue + "\t");
                colnum = colnum+1;
                dataarray[rownum][colnum] = cellValue;                         
            }
            //System.out.println();
            rownum = rownum+1;
        }
        workbook.close();
        return dataarray;  	
    }
	
	public static void main(String[] argz) throws InvalidFormatException, IOException
	{
		//URL url = getClass().getResource("BrowsingShooter.xlsx");
		String[][] data = Dataextractor.getDatasteam();
		System.out.println(data[10][0]);
	}
	
}
