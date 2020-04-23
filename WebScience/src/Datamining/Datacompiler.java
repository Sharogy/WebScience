package Datamining;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import Model.Game;

public class Datacompiler {
	
	private List<Game> gamelist = new ArrayList();
	private String[][] data;
	Date date;
	String tempdate;
	Date dfilter;
	Set<String> uniqueset = new HashSet<String>();
	int size = 0;
	
// THIS METHOD COMPILES THE String[][] Data INTO A LIST OF GAMES, USE THIS FOR YOUR MODULES.
// TWO ADDITION PARAMETERS ARE USED AS FILTERS, SUCH AS MINIMUM NUMBER OF SELLS AND RELEASED AFTER CERTAIN DATE
// NOTE: THE FORMAT FOR THE SELLSFILTER IS AN INTEGER, WHILE FOR DATEFILTER IS IN "DD/MM/YYYY"
	
	
	public List<Game> compile(int sellsfilter, String datefilter){
		int i = 1;
		try {
			dfilter = new SimpleDateFormat("dd/MM/yyyy").parse(datefilter);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			data = Dataextractor.getData();
			
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (i<data.length)
		{
			if (data[i][1].isEmpty()==false)
			{
				if (data[i][2].isEmpty()==false)
				{
					String tempreviews = data[i][2];
					tempreviews = tempreviews.replaceAll("[\\(\\)\\[\\]\\{\\}\\,]","");
					int reviews = Integer.valueOf(tempreviews);
					if (reviews*15 > sellsfilter)
					{
						tempdate = data[i][3];
						String tempdate2 = datereplacer(tempdate);
						try {
							date = new SimpleDateFormat("dd/MM/yyyy").parse(tempdate2);
							if (date.after(dfilter))
							{
								Game game = new Game(data[i][0],reviews*15,0,date,data[i][5],data[i][4],gamelist.size()+1);
								if (isunique(game.getName()))
								{
									gamelist.add(game);
								}
							}
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							System.out.println(date);
							System.out.println(i);
							System.out.println(tempdate);
							e.printStackTrace();
						}
					}
				}
				else
				{
					if (data[i][1].equalsIgnoreCase("- Need more user reviews to generate a score"))
					{
						
					}
					else
					{					
						String tempreviews = data[i][1];
						tempreviews = tempreviews.replaceAll("[\\(\\)\\[\\]\\{\\}\\,]","");
						int reviews = Integer.valueOf(tempreviews);
						if (reviews*15 > sellsfilter)
						{
							tempdate = data[i][3];
							tempdate = datereplacer(tempdate);
							try {
								date = new SimpleDateFormat("dd/MM/yyyy").parse(tempdate);
								if (date.after(dfilter))
								{
									Game game = new Game(data[i][0],reviews*15,0,date,data[i][5],data[i][4],gamelist.size()+1);
									if (isunique(game.getName()))
									{
										gamelist.add(game);
									}
								}
								
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								System.out.println("2");
								e.printStackTrace();
							}
						}
					}
				}
			}
			i++;					
		}
		return gamelist;
	}
	
	public String datereplacer(String date)
	{
		date = date.replace("Jan", "01");
		date = date.replace("Feb", "02");
		date = date.replace("Mar", "03");
		date = date.replace("Apr", "04");
		date = date.replace("May", "05");
		date = date.replace("Jun", "06");
		date = date.replace("Jul", "07");
		date = date.replace("Aug", "08");
		date = date.replace("Sep", "09");
		date = date.replace("Oct", "10");
		date = date.replace("Nov", "11");
		date = date.replace("Dec", "12");
		date = date.replace(" ", "/");
		date = date.replace(",", "");
		
		return date;
		
	}
	
	public boolean isunique(String name)
	{
		//System.out.println("yues");
		uniqueset.add(name);
		if (uniqueset.size()>size)
		{
			size = uniqueset.size();
			return true;
		}
		else return false;
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] argz) throws InvalidFormatException, IOException
	{
		//URL url = getClass().getResource("BrowsingShooter.xlsx");
		Datacompiler compiler = new Datacompiler();
		
		List<Game> games = compiler.compile(100000,"01/07/2017");
		for (int i = 0; i<games.size(); i++)
		{
			System.out.println(games.get(i).getName() + "    " + games.get(i).getGenre() + "       " +"Release Date:" + " " + (games.get(i).getReleasedate().getYear()+1900) +  "     " + "Sells:" + " " + games.get(i).getSteamsells());
				//System.out.println(games.get(i).getName());
		}
		System.out.println(games.size());		
	}

}
