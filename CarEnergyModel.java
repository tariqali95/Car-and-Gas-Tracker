package wholeProjectSecondVersion;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;

public class CarEnergyModel 
{
	//Declaring integers for all things that belong to car
	private String carName;
	private double gasCost;
	private double miles;
	private double milesDrivenDaily;
	private double gasCostDay;
	private double gasCostMonth;
	private double gasCostYear;
	private String name;
	private String month;
	private String year;
	private int id;
	
	//default constructors 
	public CarEnergyModel(){}
	public CarEnergyModel(String carName, double gasCost, double miles, double milesDrivenDaily, String name,
			String month, String year, int id) {
		super();
		this.carName = carName;
		this.gasCost = gasCost;
		this.miles = miles;
		this.milesDrivenDaily = milesDrivenDaily;
		this.name = name;
		this.month = month;
		this.year = year;
		this.id = id;
	}
	//getters and setters for variables.
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getMilesDrivenDaily() {
		return milesDrivenDaily;
	}
	public void setMilesDrivenDaily(double milesDrivenDaily) {
		this.milesDrivenDaily = milesDrivenDaily;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	NumberFormat formatter = NumberFormat.getCurrencyInstance();

	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public double getGasCost() {
		return gasCost;
	}
	public void setGasCost(double gasCost) {
		this.gasCost = gasCost;
	}
	public double getMiles() {
		return miles;
	}
	public void setMiles(double miles) {
		this.miles = miles;
	}
	public double getGasCostDay() {
		return gasCostDay;
	}
	public void setGasCostDay(double gasCostDay) {
		this.gasCostDay = gasCostDay;
	}
	public double getGasCostMonth() {
		return gasCostMonth;
	}
	public void setGasCostMonth(double gasCostMonth) {
		this.gasCostMonth = gasCostMonth;
	}
	public double getGasCostYear() {
		return gasCostYear;
	}
	public void setGasCostYear(double gasCostYear) {
		this.gasCostYear = gasCostYear;
	}
	//methods to calculate cost of gas for day/month/year
	public double calculateDay(double gasCost, double miles, double milesDrivenDaily)
	{
		/*this.gasCost = gasCost;
		this.miles = miles;
		this.milesDrivenDaily = milesDrivenDaily;*/
		gasCostDay = (gasCost * milesDrivenDaily)/miles;
		return gasCostDay;
	}
	public double calculateMonth(double gasCost, double miles, double milesDrivenDaily)
	{
		this.gasCost = gasCost;
		this.miles = miles;
		this.milesDrivenDaily = milesDrivenDaily;
		gasCostMonth = (30 * (gasCost * milesDrivenDaily)/miles);
		return gasCostMonth;
	}
	public double calculateYear(double gasCost, double miles, double milesDrivenDaily)
	{
		this.gasCost = gasCost;
		this.miles = miles;
		this.milesDrivenDaily = milesDrivenDaily;
		gasCostYear = (365*(gasCost * milesDrivenDaily)/miles);
		return gasCostYear;
	}
	//method to save info into text file
	FileWriter fw = null; 
	PrintWriter pw = null;
	NumberFormat formatter2 = NumberFormat.getCurrencyInstance();
	public void save(int id) throws FileNotFoundException
	{
		try 
		{
			//true entered for appending(or adding thing to file)
			fw = new FileWriter("CarIdNumbers.txt",true);
			pw = new PrintWriter (fw);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		pw.println("ID: " + id);
		pw.println("Name: " +name );
		pw.println("Month: " +month );
		pw.println("Year: " +year );
		pw.println("Cost of Gas:" + gasCost);
		pw.println("MPG: " + miles);
		pw.println("Miles Driven Daily: " +milesDrivenDaily );
		pw.println("Daily Cost of Gas: "+gasCostDay);
		pw.println("Monthly Cost of Gas: "+gasCostMonth);
		pw.println("Annual Cost of Gas: "+gasCostYear);
		pw.println("-----------------------------------------");
		pw.close();
	}
	
	@Override
	public String toString() {
		return "Name: " + name +"\nMonth: "+ month+" Year: "+year + "\nCar Name: " + carName + ", \nCost of Gas: " + gasCost + ", \nMPG: " + miles
				+ ", \nMiles Driven Daily: " + milesDrivenDaily + ", \nDaily Cost of Gas:" + formatter.format(gasCostDay) + ", \nMonthly Cost of gas: "
				+ formatter.format(gasCostMonth) + ", \nAnnual Cost of Gas: " +formatter.format( gasCostYear )+ "\n------------------------------";
	}
	
	
}
