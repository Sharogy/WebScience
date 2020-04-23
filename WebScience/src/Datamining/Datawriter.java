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
import java.util.List;

public class Datawriter {

    private static String[] columns = {"id", "label"};
    private static String[] columns2 = {"source","target","weight"};
    private static String outputpath = "../WebScience/Data/gamenodes.xlsx";
    private static String outputpath2 = "../WebScience/Data/gameedges.xlsx";
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
    		games = compiler.compile(100000,"01/07/2017");
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
        row4.createCell(1).setCellValue("Racing");
        Row row5 = sheet.createRow(rowNum++);
        row5.createCell(0).setCellValue(rowNum-1);
        row5.createCell(1).setCellValue("Strategy");
        Row row6 = sheet.createRow(rowNum++);
        row6.createCell(0).setCellValue(rowNum-1);
        row6.createCell(1).setCellValue("Puzzle");
        Row row7 = sheet.createRow(rowNum++);
        row7.createCell(0).setCellValue(rowNum-1);
        row7.createCell(1).setCellValue("RPG");
        
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
        
        int shooterweight = 0;
        int racingweight = 0;
        int strategyweight = 0;
        int puzzleweight = 0;
        int rpgweight = 0;
        
        for (Game game: games)
        {
        	Row row = sheet.createRow(rowNum++);
        	if (game.getGenre().equalsIgnoreCase("Shooter"))
        	{
        		row.createCell(0).setCellValue(game.getGameid());
        		row.createCell(1).setCellValue(154);
        		row.createCell(2).setCellValue(game.getSteamsells());
        		shooterweight = shooterweight + game.getSteamsells();
        	}
        	if (game.getGenre().equalsIgnoreCase("Racing"))
        	{
        		row.createCell(0).setCellValue(game.getGameid());
        		row.createCell(1).setCellValue(155);
        		row.createCell(2).setCellValue(game.getSteamsells());
        		racingweight = racingweight + game.getSteamsells();
        	}
        	if (game.getGenre().equalsIgnoreCase("Strategy"))
        	{
        		row.createCell(0).setCellValue(game.getGameid());
        		row.createCell(1).setCellValue(156);
        		row.createCell(2).setCellValue(game.getSteamsells());
        		strategyweight = strategyweight + game.getSteamsells();
        	}
        	if (game.getGenre().equalsIgnoreCase("Puzzle"))
        	{
        		row.createCell(0).setCellValue(game.getGameid());
        		row.createCell(1).setCellValue(157);
        		row.createCell(2).setCellValue(game.getSteamsells());
        		puzzleweight = puzzleweight + game.getSteamsells();
        	}
        	if (game.getGenre().equalsIgnoreCase("RPG"))
        	{
        		row.createCell(0).setCellValue(game.getGameid());
        		row.createCell(1).setCellValue(158);
        		row.createCell(2).setCellValue(game.getSteamsells());
        		rpgweight = rpgweight + game.getSteamsells();
        	}     			
        }
        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue(154);
        row.createCell(1).setCellValue(152);
        row.createCell(2).setCellValue(shooterweight);
        Row row2 = sheet.createRow(rowNum++);
        row2.createCell(0).setCellValue(155);
        row2.createCell(1).setCellValue(152);
        row2.createCell(2).setCellValue(racingweight);     
        Row row3 = sheet.createRow(rowNum++);
        row3.createCell(0).setCellValue(156);
        row3.createCell(1).setCellValue(152);
        row3.createCell(2).setCellValue(strategyweight);
        Row row4 = sheet.createRow(rowNum++);
        row4.createCell(0).setCellValue(157);
        row4.createCell(1).setCellValue(152);
        row4.createCell(2).setCellValue(puzzleweight);
        Row row5 = sheet.createRow(rowNum++);
        row5.createCell(0).setCellValue(158);
        row5.createCell(1).setCellValue(152);
        row5.createCell(2).setCellValue(rpgweight);
        
        int weight2017 = 0;
        int weight2018 = 0;
        int weight2019 = 0;
        int weight2020 = 0;
        
        for (Game game: games)
        {
        	Row row6 = sheet.createRow(rowNum++);
        	if (game.getReleasedate().getYear() == 117)
        	{
        		row6.createCell(0).setCellValue(game.getGameid());
        		row6.createCell(1).setCellValue(159);
        		row6.createCell(2).setCellValue(game.getSteamsells());
        		weight2017 = weight2017 + game.getSteamsells();
        	}
        	if (game.getReleasedate().getYear() == 118)
        	{
        		row6.createCell(0).setCellValue(game.getGameid());
        		row6.createCell(1).setCellValue(160);
        		row6.createCell(2).setCellValue(game.getSteamsells());
        		weight2018 = weight2018 + game.getSteamsells();
        	}
        	if (game.getReleasedate().getYear() == 119)
        	{
        		row6.createCell(0).setCellValue(game.getGameid());
        		row6.createCell(1).setCellValue(161);
        		row6.createCell(2).setCellValue(game.getSteamsells());
        		weight2019 = weight2019 + game.getSteamsells();
        	}
        	if (game.getReleasedate().getYear() == 120)
        	{
        		row6.createCell(0).setCellValue(game.getGameid());
        		row6.createCell(1).setCellValue(162);
        		row6.createCell(2).setCellValue(game.getSteamsells());
        		weight2020 = weight2020 + game.getSteamsells();
        	}
        }
        
        Row row7 = sheet.createRow(rowNum++);
        row7.createCell(0).setCellValue(159);
        row7.createCell(1).setCellValue(152);
        row7.createCell(2).setCellValue(weight2017);
        Row row8 = sheet.createRow(rowNum++);
        row8.createCell(0).setCellValue(160);
        row8.createCell(1).setCellValue(152);
        row8.createCell(2).setCellValue(weight2018);     
        Row row9 = sheet.createRow(rowNum++);
        row9.createCell(0).setCellValue(161);
        row9.createCell(1).setCellValue(152);
        row9.createCell(2).setCellValue(weight2019);
        Row row10 = sheet.createRow(rowNum++);
        row10.createCell(0).setCellValue(162);
        row10.createCell(1).setCellValue(152);
        row10.createCell(2).setCellValue(weight2020);
        

        
        
//        for (Game game: games)
//        {
//        	Row row = sheet.createRow(rowNum++);
//        	
//        	if (game.getWebshop().equalsIgnoreCase("Steam"))
//        	{
//        		System.out.println("yes");
//        		row.createCell(0).setCellValue(game.getGameid());
//        		row.createCell(1).setCellValue(games.size()+1);
//            	row.createCell(2).setCellValue(game.getSteamsells());
//        	}
//        	
//        	if (game.getWebshop() == "Epic")
//        	{
//        		row.createCell(0).setCellValue(game.getGameid());
//        		row.createCell(1).setCellValue(games.size()+2);
//            	row.createCell(2).setCellValue(game.getEpicsells());
//        	}
//        	
//        	if (game.getWebshop() == "Both")
//        	{
//        		row.createCell(0).setCellValue(game.getGameid());
//        		row.createCell(1).setCellValue(games.size()+1);
//            	row.createCell(2).setCellValue(game.getSteamsells());
//            	row.createCell(0).setCellValue(game.getName());
//        		row.createCell(1).setCellValue(games.size()+2);
//            	row.createCell(2).setCellValue(game.getEpicsells());
//        	}        	
//        }
        
//        for (int i = 0; i<games.size(); i++)
//        {
//        	for (int j = i; j<games.size(); j++)
//        	{
//        		if (games.get(i).getGenre() == games.get(j).getGenre())
//        		{
//        			if (i!=j)
//        			{
//        				Row row = sheet.createRow(rowNum++);
//        				row.createCell(0).setCellValue(games.get(i).getGameid());
//                		row.createCell(1).setCellValue(games.get(j).getGameid());
//                    	row.createCell(2).setCellValue(1);
//        			}			
//        		}
//        	}
//        }
        
//        for (int i = 0; i<games.size(); i++) {
//        	for (int j = i; j<games.size(); j++)
//        	{
//        		if (games.get(i).getReleasedate().getYear() == games.get(j).getReleasedate().getYear())
//        		{
//        			if (i!=j)
//        			{
//        				Row row = sheet.createRow(rowNum++);
//        				row.createCell(0).setCellValue(games.get(i).getGameid());
//        				row.createCell(1).setCellValue(games.get(j).getGameid());
//                    	row.createCell(2).setCellValue(1);
//        			}
//        		}
//        	}
//        }
        
//        for (int i = 0; i<games.size(); i++) 
//        {
//        	for (int j = i; j<games.size(); j++)
//        	{
//        		if (games.get(i).getGenre() == games.get(j).getGenre())
//        		{
//        			if (games.get(i).getReleasedate().getYear() == games.get(j).getReleasedate().getYear()) {
//        				if (i!=j)
//                			{
//                				Row row = sheet.createRow(rowNum++);
//                				row.createCell(0).setCellValue(games.get(i).getGameid());
//                				row.createCell(1).setCellValue(games.get(j).getGameid());
//                            	row.createCell(2).setCellValue(1);
//                			}
//        			}       				
//        		}       			
//        	}
//        }

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
    
    public static void main(String[] argz) throws InvalidFormatException, IOException
	{
    	Datawriter.writeNode();
    	Datawriter.writeEdge();
    	System.out.println("finished");
	}
    	
}