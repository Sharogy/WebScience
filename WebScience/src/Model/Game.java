package Model;

import java.util.Date;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Game {
	
	private StringProperty name;
	private IntegerProperty steamsells;
	private IntegerProperty epicsells;
	private StringProperty webshop;
	private Date releasedate;
	private StringProperty genre;
	private IntegerProperty gameid;

	public Game()
	{
		this(null,0,0,null,null,null,0);
	}
	
	public Game(String name, int steamsells, int epicsells, Date date, String genre, String webshop, int gameid)
	{
		this.name = new SimpleStringProperty(name);
		this.steamsells = new SimpleIntegerProperty(steamsells);
		this.epicsells = new SimpleIntegerProperty(epicsells);
		this.releasedate = date;
		this.genre = new SimpleStringProperty(genre);
		this.webshop = new SimpleStringProperty(webshop);
		this.gameid = new SimpleIntegerProperty(gameid);
	}
		
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}	
	public StringProperty nameProperty()
	{
		return name;
	}

	public int getSteamsells() {
		return steamsells.get();
	}
	public void setSteamsells(int number) {
		this.steamsells.set(number);
	}	
	public IntegerProperty SteamsellProperty()
	{
		return steamsells;
	}
	
	public int getEpicsells() {
		return epicsells.get();
	}
	public void setEpicsells(int number) {
		this.epicsells.set(number);
	}	
	public IntegerProperty EpicsellProperty()
	{
		return epicsells;
	}

	
	public Date getReleasedate() {
		return releasedate;
	}
	
	@SuppressWarnings("deprecation")
	public void setReleasedate(int date)
	{
		this.releasedate.setDate(date);
	}
	
	public String getGenre() {
		return genre.get();
	}
	public void setGenre(String genre) {
		this.genre.set(genre);
	}
	public StringProperty genreProperty()
	{
		return genre;
	}
	
	public String getWebshop() {
		return webshop.get();
	}
	public void setWebshop(String webstore) {
		this.webshop.set(webstore);
	}
	public StringProperty webshopProperty()
	{
		return webshop;
	}
	
	public int getGameid() {
		return gameid.get();
	}
	public void setGameid(int gameid) {
		this.gameid.set(gameid);
	}
	public IntegerProperty gameidProperty()
	{
		return gameid;
	}

}
