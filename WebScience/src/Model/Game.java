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

	public Game()
	{
		this(null,0,null,null);
	}
	
	public Game(String name, int sells, Date date, String webshop)
	{
		this.name = new SimpleStringProperty(name);
		this.sells = new SimpleIntegerProperty(sells);
		this.releasedate = date;
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
	
	public String getWebshop() {
		return webshop.get();
	}
	public void setWebshop(String notes) {
		this.webshop.set(notes);
	}
	public StringProperty notesProperty()
	{
		return webshop;
	}
}
