package wholeProjectSecondVersion;

import java.util.EventObject;

public class WindowEvent extends EventObject {
	
	private String appliance;
	private String pwrCon;
	private String hours;
	private String name;
	private String month;
	private String year;
	private String id;
	

	public WindowEvent(Object source) {
		super(source);
	}
	
	public WindowEvent(Object source, String appliance, String pwrCon, String hours, String name,
			  String month, String year, String id) {
		super(source);
		this.appliance = appliance;
		this.pwrCon = pwrCon;
		this.hours = hours;
		this.name = name;
		this.month = month;
		this.year = year;
		this.id = id;
	}
	
	public String getAppliance() {
		return appliance;
	}
	
	public String getPwrCon() {
		return pwrCon;
	}
	public String getHour() {
		return hours;
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
	public String getId() {
		return id;
	}
}
