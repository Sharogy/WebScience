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

import Math.LinearRegression;
import Model.Game;

public class Datacompiler {
	
	private List<Game> gamelist = new ArrayList();
	private String[][] steamdata;
	private String[][] epicdata;
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
		int nonex = 0;
		try {
			dfilter = new SimpleDateFormat("dd/MM/yyyy").parse(datefilter);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			steamdata = Dataextractor.getDatasteam();
			epicdata = Dataextractor.getDataepic();
			
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int k = 1; k<epicdata.length; k++)
		{
			String reviewnumber = epicdata[k][2];
			//System.out.println(reviewnumber);
			int epicreviews = Integer.valueOf(reviewnumber);
			int tempsales = (int) Math.round(epicreviews*LinearRegression.calculateglobal());
			tempdate = epicdata[k][3];
			try
			{
				date = new SimpleDateFormat("dd/MM/yyyy").parse(tempdate);
				if (date.after(dfilter))
				{
					Game game = new Game(epicdata[k][0],0,tempsales,date,epicdata[k][5],epicdata[k][4],gamelist.size()+1);
					if (isunique(game.getName()))
					{
						gamelist.add(game);
					}
				}
			}
			catch (ParseException e) {
					// TODO Auto-generated catch block
				System.out.println(date);
				System.out.println(i);
				System.out.println(tempdate);
				e.printStackTrace();
			}		
		}
		
				
		for (int k = 1; k<steamdata.length; k++)
		{
			if (steamdata[k][1].isEmpty()==false)
			{
				if (steamdata[k][2].isEmpty()==false)
				{
					String tempreviews = steamdata[k][2];
					tempreviews = tempreviews.replaceAll("[\\(\\)\\[\\]\\{\\}\\,]","");
					int reviews = Integer.valueOf(tempreviews);
					int sales = (int) Math.round(reviews*LinearRegression.calculatesteam());
					if (sales > sellsfilter)
					{
						tempdate = steamdata[k][3];
						String tempdate2 = datereplacer(tempdate);
						try {
							date = new SimpleDateFormat("dd/MM/yyyy").parse(tempdate2);
							if (date.after(dfilter))
							{
								Game game = new Game(steamdata[k][0],(int) Math.round(reviews*LinearRegression.calculatesteam()),0,date,steamdata[k][5],steamdata[k][4],gamelist.size()+1);
								if (isunique(game.getName()))
								{
									gamelist.add(game);
								}
								else
								{
									for (int j = 0; j < gamelist.size(); j++)
									{
										if (gamelist.get(j).getName().equalsIgnoreCase(game.getName()))
										{
											if (gamelist.get(j).getEpicsells() > 0)
											{
												nonex++;
												gamelist.get(j).setSteamsells(sales);
												int globalsale = gamelist.get(j).getEpicsells();
												int epicsale = globalsale;
												gamelist.get(j).setEpicsells(epicsale);
												gamelist.get(j).setWebshop("Both");
											}
										}
									}
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
					else
					{
						Game game = new Game(steamdata[k][0],(int) Math.round(reviews*LinearRegression.calculatesteam()),0,date,steamdata[k][5],steamdata[k][4],gamelist.size()+1);
						if (isunique(game.getName()))
						{
						}
						else
						{
							for (int j = 0; j < gamelist.size(); j++)
							{
								if (gamelist.get(j).getName().equalsIgnoreCase(game.getName()))
								{
									if (gamelist.get(j).getEpicsells() > 0)
									{
										nonex++;
										gamelist.get(j).setSteamsells(sales);
										int globalsale = gamelist.get(j).getEpicsells();
										int epicsale = globalsale;
										gamelist.get(j).setEpicsells(epicsale);
										gamelist.get(j).setWebshop("Both");
									}
								}
							}
						}
					}
				}
				else
				{
					if (steamdata[k][1].equalsIgnoreCase("- Need more user reviews to generate a score"))
					{
						
					}
					else
					{					
						String tempreviews = steamdata[k][1];
						tempreviews = tempreviews.replaceAll("[\\(\\)\\[\\]\\{\\}\\,]","");
						int reviews = Integer.valueOf(tempreviews);
						int sales = (int) Math.round(reviews*LinearRegression.calculatesteam());
						if (sales > sellsfilter)
						{
							tempdate = steamdata[k][3];
							String tempdate2 = datereplacer(tempdate);
							try {
								date = new SimpleDateFormat("dd/MM/yyyy").parse(tempdate2);
								if (date.after(dfilter))
								{
									Game game = new Game(steamdata[k][0],(int) Math.round(reviews*LinearRegression.calculatesteam()),0,date,steamdata[k][5],steamdata[k][4],gamelist.size()+1);
									if (isunique(game.getName()))
									{
										gamelist.add(game);
									}
									else
									{
										for (int j = 0; j < gamelist.size(); j++)
										{
											if (gamelist.get(j).getName().equalsIgnoreCase(game.getName()))
											{
												if (gamelist.get(j).getEpicsells() > 0)
												{
													nonex++;
													gamelist.get(j).setSteamsells(sales);
													int globalsale = gamelist.get(j).getEpicsells();
													int epicsale = globalsale;
													gamelist.get(j).setEpicsells(epicsale);
													gamelist.get(j).setWebshop("Both");
												}
											}
										}
									}
								}
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								System.out.println("2");
								e.printStackTrace();
							}
						}
						else
						{
							Game game = new Game(steamdata[k][0],(int) Math.round(reviews*LinearRegression.calculatesteam()),0,date,steamdata[k][5],steamdata[k][4],gamelist.size()+1);
							if (isunique(game.getName()))
							{
							}
							else
							{
								for (int j = 0; j < gamelist.size(); j++)
								{
									if (gamelist.get(j).getName().equalsIgnoreCase(game.getName()))
									{
										if (gamelist.get(j).getEpicsells() > 0)
										{
											nonex++;
											gamelist.get(j).setSteamsells(sales);
											int globalsale = gamelist.get(j).getEpicsells();
											int epicsale = globalsale;
											gamelist.get(j).setEpicsells(epicsale);
											gamelist.get(j).setWebshop("Both");
										}
									}
								}
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
	
	public String datereplacerepic(String date)
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
		date = date.replace("-", "/");
		
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
		
		List<Game> games = compiler.compile(150000,"01/01/2017");
		for (int i = 0; i<games.size(); i++)
		{
			System.out.println(games.get(i).getName() + "    " + games.get(i).getGenre() + "       " +"Release Date:" + " " + (games.get(i).getReleasedate().getYear()+1900) +  "     " + "EpicSells:" + " " + games.get(i).getEpicsells() + "     " + "SteamSells:" + " " + games.get(i).getSteamsells());
				//System.out.println(games.get(i).getName());
		}
		
		for (int i = 0; i<games.size(); i++)
		{
//			if (games.get(i).getName().equalsIgnoreCase("Borderlands 3"))
//			{
//				System.out.println(games.get(i).getName());
//				System.out.println(games.get(i).getSteamsells());
//				System.out.println(games.get(i).getEpicsells());
//				System.out.println(games.get(i).getWebshop());
//				System.out.println(games.get(i).getGenre());
//				System.out.println(games.get(i).getReleasedate().getYear());
//				for (int j = 0; j<games.size(); j++)
//				{
//					if (games.get(j).getGenre().equalsIgnoreCase(games.get(i).getGenre()))			
//					{
//						System.out.println(games.get(j).getName());
////						if (games.get(j).getReleasedate().getYear() == games.get(i).getReleasedate().getYear())
////						{
////							System.out.println(games.get(j).getReleasedate().getYear());
////						}
//					}
//				}
//			}
//			if (games.get(i).getName().equalsIgnoreCase("Halo: The Master Chief Collection"))
//			{
//				System.out.println(games.get(i).getName());
//				System.out.println(games.get(i).getSteamsells());
//				System.out.println(games.get(i).getEpicsells());
//				System.out.println(games.get(i).getWebshop());
//				System.out.println(games.get(i).getGenre());
//				System.out.println(games.get(i).getReleasedate().getYear());
//			}
			//System.out.println(games.get(i).getName());
		}
		System.out.println(games.size());		
	}

}
