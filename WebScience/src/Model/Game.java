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
	private IntegerProperty sells;
	private StringProperty webshop;
	private Date releasedate;
	private StringProperty genre;

	public Game()
	{
		this(null,0,null,null,null);
	}
	
	public Game(String name, int sells, Date date, String genre, String webshop)
	{
		this.name = new SimpleStringProperty(name);
		this.sells = new SimpleIntegerProperty(sells);
		this.releasedate = date;
		this.genre = new SimpleStringProperty(genre);
		this.webshop = new SimpleStringProperty(webshop);
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

	public int getSells() {
		return sells.get();
	}
	public void setSells(int number) {
		this.sells.set(number);
	}	
	public IntegerProperty SellProperty()
	{
		return sells;
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
		this.genre.set(webstore);
	}
	public StringProperty webshopProperty()
	{
		return webshop;
	}

}
