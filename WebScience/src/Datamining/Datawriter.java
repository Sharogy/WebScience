package Datamining;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Model.Game;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Datawriter {

    private static String[] columns = {"id", "label"};
    private static String[] columns2 = {"source","target","weight"};
    private static String[] columns3 = {"Name", "Genre", "Releaseyear", "Epicsells", "Steamsells"};
    private static String outputpath = "../WebScience/Data/gamenodes2.xlsx";
    private static String outputpath2 = "../WebScience/Data/gameedges2.xlsx";
    private static String outputpath3 = "../WebScience/Data/gamenodes.xlsx";
    private static String outputpath4 = "../WebScience/Data/gameedges.xlsx";
    private static String outputpath5 = "../WebScience/Data/gamenodes3.xlsx";
    private static String outputpath6 = "../WebScience/Data/gameedges3.xlsx";
    private static String outputpath7 = "../WebScience/Data/gamesells.xlsx";
    
    private static List<Game> games = new ArrayList<Game>();

	// Initializing employees data to insert into the excel file   
    
    public static void setpath(String path)
    {
    	outputpath = path;
    }
    
    public static void loaddata()
    {
    	Datacompiler compiler = new Datacompiler();
    	if (games.size() == 0)
    	{
    		games = compiler.compile(250000,"01/01/2017");
    	}
    }
    
    
    public static void writeNode() throws IOException{
    	
    	// load data
    	loaddata();
    	// Create a Workbook
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Gamesnode");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Create Other rows and cells with employees data
        int rowNum =1;
        for (Game game: games)
        {
        	Row row = sheet.createRow(rowNum++);
        	
        	row.createCell(0).setCellValue(game.getGameid());
        	row.createCell(1).setCellValue(game.getName());
        	
        }
        

        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue(rowNum-1);
        row.createCell(1).setCellValue("Steam");
        Row row2 = sheet.createRow(rowNum++);
        row2.createCell(0).setCellValue(rowNum-1);
        row2.createCell(1).setCellValue("Epic");  
        Row row3 = sheet.createRow(rowNum++);
        row3.createCell(0).setCellValue(rowNum-1);
        row3.createCell(1).setCellValue("Shooter"); 
        Row row4 = sheet.createRow(rowNum++);
        row4.createCell(0).setCellValue(rowNum-1);
        row4.createCell(1).setCellValue("RPG"); 
        Row row5 = sheet.createRow(rowNum++);
        row5.createCell(0).setCellValue(rowNum-1);
        row5.createCell(1).setCellValue("Puzzle"); 
        Row row6 = sheet.createRow(rowNum++);
        row6.createCell(0).setCellValue(rowNum-1);
        row6.createCell(1).setCellValue("Strategy"); 
        Row row7 = sheet.createRow(rowNum++);
        row7.createCell(0).setCellValue(rowNum-1);
        row7.createCell(1).setCellValue("Racing"); 
        Row row8 = sheet.createRow(rowNum++);
        row8.createCell(0).setCellValue(rowNum-1);
        row8.createCell(1).setCellValue("2017");
        Row row9 = sheet.createRow(rowNum++);
        row9.createCell(0).setCellValue(rowNum-1);
        row9.createCell(1).setCellValue("2018"); 
        Row row10 = sheet.createRow(rowNum++);
        row10.createCell(0).setCellValue(rowNum-1);
        row10.createCell(1).setCellValue("2019"); 
        Row row11 = sheet.createRow(rowNum++);
        row11.createCell(0).setCellValue(rowNum-1);
        row11.createCell(1).setCellValue("2020"); 
        
        
        


		// Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream(outputpath);
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }
    
public static void writeNode2() throws IOException{
    	
    	// load data
    	loaddata();
    	// Create a Workbook
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Gamesnode");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Create Other rows and cells with employees data
        int rowNum =1;
        for (Game game: games)
        {
        	Row row = sheet.createRow(rowNum++);
        	
        	row.createCell(0).setCellValue(game.getGameid());
        	row.createCell(1).setCellValue(game.getName());
        	
        }
        

        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue(rowNum-1);
        row.createCell(1).setCellValue("Steam");
        Row row2 = sheet.createRow(rowNum++);
        row2.createCell(0).setCellValue(rowNum-1);
        row2.createCell(1).setCellValue("Epic");   


		// Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream(outputpath3);
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }

public static void writeNode3() throws IOException{
	
	// load data
	loaddata();
	// Create a Workbook
    Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

    // Create a Sheet
    Sheet sheet = workbook.createSheet("Gamesnode");

    // Create a Font for styling header cells
    Font headerFont = workbook.createFont();
    headerFont.setBold(true);
    headerFont.setFontHeightInPoints((short) 14);
    headerFont.setColor(IndexedColors.RED.getIndex());

    // Create a CellStyle with the font
    CellStyle headerCellStyle = workbook.createCellStyle();
    headerCellStyle.setFont(headerFont);

    // Create a Row
    Row headerRow = sheet.createRow(0);

    // Create cells
    for(int i = 0; i < columns.length; i++) {
        Cell cell = headerRow.createCell(i);
        cell.setCellValue(columns[i]);
        cell.setCellStyle(headerCellStyle);
    }

    // Create Other rows and cells with employees data
    int rowNum =1;
    for (Game game: games)
    {
    	Row row = sheet.createRow(rowNum++);
    	
    	row.createCell(0).setCellValue(game.getGameid());
    	row.createCell(1).setCellValue(game.getName());
    	
    }
    

    Row row = sheet.createRow(rowNum++);
    row.createCell(0).setCellValue(rowNum-1);
    row.createCell(1).setCellValue("Steam");
    Row row2 = sheet.createRow(rowNum++);
    row2.createCell(0).setCellValue(rowNum-1);
    row2.createCell(1).setCellValue("Epic");  
    Row row3 = sheet.createRow(rowNum++);
    row3.createCell(0).setCellValue(rowNum-1);
    row3.createCell(1).setCellValue("Shooter 2017"); 
    Row row4 = sheet.createRow(rowNum++);
    row4.createCell(0).setCellValue(rowNum-1);
    row4.createCell(1).setCellValue("Shooter 2018"); 
    Row row5 = sheet.createRow(rowNum++);
    row5.createCell(0).setCellValue(rowNum-1);
    row5.createCell(1).setCellValue("Shooter 2019"); 
    Row row6 = sheet.createRow(rowNum++);
    row6.createCell(0).setCellValue(rowNum-1);
    row6.createCell(1).setCellValue("Shooter 2020"); 
    Row row7 = sheet.createRow(rowNum++);
    row7.createCell(0).setCellValue(rowNum-1);
    row7.createCell(1).setCellValue("RPG 2017"); 
    Row row8 = sheet.createRow(rowNum++);
    row8.createCell(0).setCellValue(rowNum-1);
    row8.createCell(1).setCellValue("RPG 2018"); 
    Row row9 = sheet.createRow(rowNum++);
    row9.createCell(0).setCellValue(rowNum-1);
    row9.createCell(1).setCellValue("RPG 2019"); 
    Row row10 = sheet.createRow(rowNum++);
    row10.createCell(0).setCellValue(rowNum-1);
    row10.createCell(1).setCellValue("RPG 2020"); 
    Row row11 = sheet.createRow(rowNum++);
    row11.createCell(0).setCellValue(rowNum-1);
    row11.createCell(1).setCellValue("Puzzle 2017"); 
    Row row12 = sheet.createRow(rowNum++);
    row12.createCell(0).setCellValue(rowNum-1);
    row12.createCell(1).setCellValue("Puzzle 2018"); 
    Row row13 = sheet.createRow(rowNum++);
    row13.createCell(0).setCellValue(rowNum-1);
    row13.createCell(1).setCellValue("Puzzle 2019"); 
    Row row14 = sheet.createRow(rowNum++);
    row14.createCell(0).setCellValue(rowNum-1);
    row14.createCell(1).setCellValue("Puzzle 2020"); 
    Row row15 = sheet.createRow(rowNum++);
    row15.createCell(0).setCellValue(rowNum-1);
    row15.createCell(1).setCellValue("Strategy 2017"); 
    Row row16 = sheet.createRow(rowNum++);
    row16.createCell(0).setCellValue(rowNum-1);
    row16.createCell(1).setCellValue("Strategy 2018"); 
    Row row17 = sheet.createRow(rowNum++);
    row17.createCell(0).setCellValue(rowNum-1);
    row17.createCell(1).setCellValue("Strategy 2019"); 
    Row row18 = sheet.createRow(rowNum++);
    row18.createCell(0).setCellValue(rowNum-1);
    row18.createCell(1).setCellValue("Strategy 2020"); 
    Row row19 = sheet.createRow(rowNum++);
    row19.createCell(0).setCellValue(rowNum-1);
    row19.createCell(1).setCellValue("Racing 2017"); 
    Row row20 = sheet.createRow(rowNum++);
    row20.createCell(0).setCellValue(rowNum-1);
    row20.createCell(1).setCellValue("Racing 2018"); 
    Row row21 = sheet.createRow(rowNum++);
    row21.createCell(0).setCellValue(rowNum-1);
    row21.createCell(1).setCellValue("Racing 2019"); 
    Row row22 = sheet.createRow(rowNum++);
    row22.createCell(0).setCellValue(rowNum-1);
    row22.createCell(1).setCellValue("Racing 2020"); 
        
	// Resize all columns to fit the content size
    for(int i = 0; i < columns.length; i++) {
        sheet.autoSizeColumn(i);
    }

    // Write the output to a file
    FileOutputStream fileOut = new FileOutputStream(outputpath5);
    workbook.write(fileOut);
    fileOut.close();

    // Closing the workbook
    workbook.close();
}
    
    public static void writeEdge() throws IOException{
    	
    	// load data
    	loaddata();
    	// Create a Workbook
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Gamesedge");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for(int i = 0; i < columns2.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns2[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Create Other rows and cells with employees data
        int rowNum =1;
        
      for (Game game: games)
      {
	      	Row row = sheet.createRow(rowNum++);
	      	
	      	if (game.getWebshop().equalsIgnoreCase("Steam"))
	      	{
	      		row.createCell(0).setCellValue(game.getGameid());
	      		row.createCell(1).setCellValue(games.size()+1);
	          	row.createCell(2).setCellValue(game.getSteamsells());
	      	}
	      	
	      	if (game.getWebshop().equalsIgnoreCase("Epic"))
	      	{
	      		row.createCell(0).setCellValue(game.getGameid());
	      		row.createCell(1).setCellValue(games.size()+2);
	          	row.createCell(2).setCellValue(game.getEpicsells());
	      	}
	      	
	      	if (game.getWebshop().equalsIgnoreCase("Both"))
	      	{
	      		//System.out.println("BOTH");
	      		row.createCell(0).setCellValue(game.getGameid());
	      		row.createCell(1).setCellValue(games.size()+1);
	          	row.createCell(2).setCellValue(game.getSteamsells());
	          	Row row2 = sheet.createRow(rowNum++);
	          	row2.createCell(0).setCellValue(game.getGameid());
	      		row2.createCell(1).setCellValue(games.size()+2);
	          	row2.createCell(2).setCellValue(game.getEpicsells());
	      	}        	
      }
      
      String a = null;
	  String b = "test";
	  int c = 0;
	  int d = 1;

	  for (int i = 0; i<games.size(); i++) 
	      {			  
		      	for (int j = i; j<games.size(); j++)
		      	{
		      		if (games.get(i).getGenre().equalsIgnoreCase(games.get(j).getGenre()))
		      		{
		      			if (games.get(i).getReleasedate().getYear() == games.get(j).getReleasedate().getYear()) {
		      				if (i!=j)
		              			{
		      						Row row3 = sheet.createRow(rowNum++);
		              				row3.createCell(0).setCellValue(games.get(i).getGameid());
		              				row3.createCell(1).setCellValue(games.get(j).getGameid());
		                          	row3.createCell(2).setCellValue(1);
		              			}
		      			}       				
		      		}       			
		      	}
	      }
	  
	  for (int i = 0; i<games.size(); i++)
	  {
		  if (games.get(i).getGenre().equalsIgnoreCase("Shooter"))
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+3);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getGenre().equalsIgnoreCase("RPG"))
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+4);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getGenre().equalsIgnoreCase("Puzzle"))
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+5);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getGenre().equalsIgnoreCase("Strategy"))
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+6);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getGenre().equalsIgnoreCase("Racing"))
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+7);
			  row.createCell(2).setCellValue(1);
		  }
		  
	  }
	  
	  for (int i = 0; i<games.size(); i++)
	  {
		  if (games.get(i).getReleasedate().getYear() == 117)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+8);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getReleasedate().getYear() == 118)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+9);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getReleasedate().getYear() == 119)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+10);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getReleasedate().getYear() == 120)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+11);
			  row.createCell(2).setCellValue(1);
		  }		  
	  }
	  
		// Resize all columns to fit the content size
      for(int i = 0; i < columns.length; i++) {
          sheet.autoSizeColumn(i);
      }

      // Write the output to a file
      FileOutputStream fileOut = new FileOutputStream(outputpath2);
      workbook.write(fileOut);
      fileOut.close();

      // Closing the workbook
      workbook.close();
    }
    
public static void writeEdge2() throws IOException{
    	
    	// load data
    	loaddata();
    	// Create a Workbook
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Gamesedge");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for(int i = 0; i < columns2.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns2[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Create Other rows and cells with employees data
        int rowNum =1;
        
      for (Game game: games)
      {
	      	Row row = sheet.createRow(rowNum++);
	      	
	      	if (game.getWebshop().equalsIgnoreCase("Steam"))
	      	{
	      		row.createCell(0).setCellValue(game.getGameid());
	      		row.createCell(1).setCellValue(games.size()+1);
	          	row.createCell(2).setCellValue(game.getSteamsells());
	      	}
	      	
	      	if (game.getWebshop().equalsIgnoreCase("Epic"))
	      	{
	      		row.createCell(0).setCellValue(game.getGameid());
	      		row.createCell(1).setCellValue(games.size()+2);
	          	row.createCell(2).setCellValue(game.getEpicsells());
	      	}
	      	
	      	if (game.getWebshop().equalsIgnoreCase("Both"))
	      	{
	      		//System.out.println("BOTH");
	      		row.createCell(0).setCellValue(game.getGameid());
	      		row.createCell(1).setCellValue(games.size()+1);
	          	row.createCell(2).setCellValue(game.getSteamsells());
	          	Row row2 = sheet.createRow(rowNum++);
	          	row2.createCell(0).setCellValue(game.getGameid());
	      		row2.createCell(1).setCellValue(games.size()+2);
	          	row2.createCell(2).setCellValue(game.getEpicsells());
	      	}        	
      }
      
      String a = null;
	  String b = "test";
	  int c = 0;
	  int d = 1;

	  for (int i = 0; i<games.size(); i++) 
	      {			  
		      	for (int j = i; j<games.size(); j++)
		      	{
		      		if (games.get(i).getGenre().equalsIgnoreCase(games.get(j).getGenre()))
		      		{
		      			if (games.get(i).getReleasedate().getYear() == games.get(j).getReleasedate().getYear()) {
		      				if (i!=j)
		              			{
		      						Row row3 = sheet.createRow(rowNum++);
		              				row3.createCell(0).setCellValue(games.get(i).getGameid());
		              				row3.createCell(1).setCellValue(games.get(j).getGameid());
		                          	row3.createCell(2).setCellValue(1);
		              			}
		      			}       				
		      		}       			
		      	}
	      }

		// Resize all columns to fit the content size
      for(int i = 0; i < columns.length; i++) {
          sheet.autoSizeColumn(i);
      }

      // Write the output to a file
      FileOutputStream fileOut = new FileOutputStream(outputpath4);
      workbook.write(fileOut);
      fileOut.close();

      // Closing the workbook
      workbook.close();
  }
  
public static void writeEdge3() throws IOException{
	
	// load data
	loaddata();
	// Create a Workbook
    Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

    // Create a Sheet
    Sheet sheet = workbook.createSheet("Gamesedge");

    // Create a Font for styling header cells
    Font headerFont = workbook.createFont();
    headerFont.setBold(true);
    headerFont.setFontHeightInPoints((short) 14);
    headerFont.setColor(IndexedColors.RED.getIndex());

    // Create a CellStyle with the font
    CellStyle headerCellStyle = workbook.createCellStyle();
    headerCellStyle.setFont(headerFont);

    // Create a Row
    Row headerRow = sheet.createRow(0);

    // Create cells
    for(int i = 0; i < columns2.length; i++) {
        Cell cell = headerRow.createCell(i);
        cell.setCellValue(columns2[i]);
        cell.setCellStyle(headerCellStyle);
    }

    // Create Other rows and cells with employees data
    int rowNum =1;
    
  for (Game game: games)
  {
      	Row row = sheet.createRow(rowNum++);
      	
      	if (game.getWebshop().equalsIgnoreCase("Steam"))
      	{
      		row.createCell(0).setCellValue(game.getGameid());
      		row.createCell(1).setCellValue(games.size()+1);
          	row.createCell(2).setCellValue(game.getSteamsells());
      	}
      	
      	if (game.getWebshop().equalsIgnoreCase("Epic"))
      	{
      		row.createCell(0).setCellValue(game.getGameid());
      		row.createCell(1).setCellValue(games.size()+2);
          	row.createCell(2).setCellValue(game.getEpicsells());
      	}
      	
      	if (game.getWebshop().equalsIgnoreCase("Both"))
      	{
      		//System.out.println("BOTH");
      		row.createCell(0).setCellValue(game.getGameid());
      		row.createCell(1).setCellValue(games.size()+1);
          	row.createCell(2).setCellValue(game.getSteamsells());
          	Row row2 = sheet.createRow(rowNum++);
          	row2.createCell(0).setCellValue(game.getGameid());
      		row2.createCell(1).setCellValue(games.size()+2);
          	row2.createCell(2).setCellValue(game.getEpicsells());
      	}        	
  }
  
  String a = null;
  String b = "test";
  int c = 0;
  int d = 1;

  for (int i = 0; i<games.size(); i++) 
      {			  
	      	for (int j = i; j<games.size(); j++)
	      	{
	      		if (games.get(i).getGenre().equalsIgnoreCase(games.get(j).getGenre()))
	      		{
	      			if (games.get(i).getReleasedate().getYear() == games.get(j).getReleasedate().getYear()) {
	      				if (i!=j)
	              			{
	      						Row row3 = sheet.createRow(rowNum++);
	              				row3.createCell(0).setCellValue(games.get(i).getGameid());
	              				row3.createCell(1).setCellValue(games.get(j).getGameid());
	                          	row3.createCell(2).setCellValue(1);
	              			}
	      			}       				
	      		}       			
	      	}
      }
  
  for (int i = 0; i<games.size(); i++)
  {
	  if (games.get(i).getGenre().equalsIgnoreCase("Shooter"))
	  {
		  if (games.get(i).getReleasedate().getYear() == 117)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+3);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getReleasedate().getYear() == 118)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+4);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getReleasedate().getYear() == 119)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+5);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getReleasedate().getYear() == 120)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+6);
			  row.createCell(2).setCellValue(1);
		  }
	  }
	  if (games.get(i).getGenre().equalsIgnoreCase("RPG"))
	  {
		  if (games.get(i).getReleasedate().getYear() == 117)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+7);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getReleasedate().getYear() == 118)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+8);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getReleasedate().getYear() == 119)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+9);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getReleasedate().getYear() == 120)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+10);
			  row.createCell(2).setCellValue(1);
		  }
	  }
	  if (games.get(i).getGenre().equalsIgnoreCase("Puzzle"))
	  {
		  if (games.get(i).getReleasedate().getYear() == 117)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+11);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getReleasedate().getYear() == 118)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+12);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getReleasedate().getYear() == 119)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+13);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getReleasedate().getYear() == 120)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+14);
			  row.createCell(2).setCellValue(1);
		  }
	  }
	  if (games.get(i).getGenre().equalsIgnoreCase("Strategy"))
	  {
		  if (games.get(i).getReleasedate().getYear() == 117)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+15);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getReleasedate().getYear() == 118)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+16);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getReleasedate().getYear() == 119)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+17);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getReleasedate().getYear() == 120)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+18);
			  row.createCell(2).setCellValue(1);
		  }
	  }
	  if (games.get(i).getGenre().equalsIgnoreCase("Racing"))
	  {
		  if (games.get(i).getReleasedate().getYear() == 117)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+19);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getReleasedate().getYear() == 118)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+20);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getReleasedate().getYear() == 119)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+21);
			  row.createCell(2).setCellValue(1);
		  }
		  if (games.get(i).getReleasedate().getYear() == 120)
		  {
			  Row row = sheet.createRow(rowNum++);
			  row.createCell(0).setCellValue(games.get(i).getGameid());
			  row.createCell(1).setCellValue(games.size()+22);
			  row.createCell(2).setCellValue(1);
		  }
	  }	  
  }
 
  
	// Resize all columns to fit the content size
  for(int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
  }

  // Write the output to a file
  FileOutputStream fileOut = new FileOutputStream(outputpath6);
  workbook.write(fileOut);
  fileOut.close();

  // Closing the workbook
  workbook.close();
}

public static void writesells() throws IOException{
	
	// load data
	loaddata();
	// Create a Workbook
    Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

    // Create a Sheet
    Sheet sheet = workbook.createSheet("Gamesnode");

    // Create a Font for styling header cells
    Font headerFont = workbook.createFont();
    headerFont.setBold(true);
    headerFont.setFontHeightInPoints((short) 14);
    headerFont.setColor(IndexedColors.RED.getIndex());

    // Create a CellStyle with the font
    CellStyle headerCellStyle = workbook.createCellStyle();
    headerCellStyle.setFont(headerFont);

    // Create a Row
    Row headerRow = sheet.createRow(0);

    // Create cells
    for(int i = 0; i < columns3.length; i++) {
        Cell cell = headerRow.createCell(i);
        cell.setCellValue(columns3[i]);
        cell.setCellStyle(headerCellStyle);
    }

    // Create Other rows and cells with employees data
    int rowNum =1;
    for (Game game: games)
    {
    	Row row = sheet.createRow(rowNum++);
    	
    	row.createCell(0).setCellValue(game.getName());
    	row.createCell(1).setCellValue(game.getGenre());
    	row.createCell(2).setCellValue(game.getReleasedate().getYear()+1900);
    	row.createCell(3).setCellValue(game.getEpicsells());
    	row.createCell(4).setCellValue(game.getSteamsells());
    	
    }
   

	// Resize all columns to fit the content size
    for(int i = 0; i < columns.length; i++) {
        sheet.autoSizeColumn(i);
    }

    // Write the output to a file
    FileOutputStream fileOut = new FileOutputStream(outputpath7);
    workbook.write(fileOut);
    fileOut.close();

    // Closing the workbook
    workbook.close();
}
        
    
    public static void main(String[] argz) throws InvalidFormatException, IOException
	{
    	Datawriter.writeNode();
    	Datawriter.writeEdge();
    	Datawriter.writeNode2();
    	Datawriter.writeEdge2();
    	Datawriter.writeNode3();
    	Datawriter.writeEdge3();
    	Datawriter.writesells();
    	System.out.println("finished");
	}
    	
}