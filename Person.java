package wholeProjectSecondVersion;

import java.io.Serializable;

public class Person implements Serializable
{
	private String name;
	private String number;
	private String month;
	private String year;
	
	private String applianceName;
	private String hours;
	private String pwrCon;
	
	private String carName;
	private String mpg;
	private double milesDrivenDaily;
	private String costOfGas;
	
	public String getName() {
		return name;
	}
	
	public Person(String name, String month, String year, String applianceName, String hours,
			String pwrCon) {
		super();
		this.name = name;
		this.month = month;
		this.year = year;
		this.applianceName = applianceName;
		this.hours = hours;
		this.pwrCon = pwrCon;
	}

	public Person(String name, String month, String year, String carName) {
		super();
		this.name = name;
		this.number = number;
		this.month = month;
		this.year = year;
		this.carName = carName;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getApplianceName() {
		return applianceName;
	}
	public void setApplianceName(String applianceName) {
		this.applianceName = applianceName;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getPwrCon() {
		return pwrCon;
	}
	public void setPwrCon(String pwrCon) {
		this.pwrCon = pwrCon;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getMpg() {
		return mpg;
	}
	public void setMpg(String mpg) {
		this.mpg = mpg;
	}
	public double getMilesDrivenDaily() {
		return milesDrivenDaily;
	}
	public void setMilesDrivenDaily(double milesDrivenDaily) {
		this.milesDrivenDaily = milesDrivenDaily;
	}
	public String getCostOfGas() {
		return costOfGas;
	}
	public void setCostOfGas(String costOfGas) {
		this.costOfGas = costOfGas;
	}
	
	

}
