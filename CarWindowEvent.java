package wholeProjectSecondVersion;

import java.util.EventObject;

public class CarWindowEvent extends EventObject {
	
	private String carName;
	private String gasCost;
	private String miles;
	private String mpg;
	private String name;
	private String month;
	private String year;
	private String id;
	
	public CarWindowEvent(Object source) {
		super(source);
	}
	
	public CarWindowEvent(Object source, String carName, String gasCost, String miles, String mpg, String name,
						  String month, String year, String id) {
		super(source);
		this.carName = carName;
		this.gasCost = gasCost;
		this.miles = miles;
		this.mpg= mpg;
		this.name = name;
		this.month = month;
		this.year = year;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

	public String getCarName() {
		return carName;
	}
	
	public String getGasCost() {
		return gasCost;
	}
	public String getMiles() {
		return miles;
	}
	public String getMpg() {
		return mpg;
	}
	public String getId() {
		return id;
	}
}
