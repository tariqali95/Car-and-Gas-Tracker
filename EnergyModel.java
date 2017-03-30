package wholeProjectSecondVersion;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;

public class EnergyModel
{
	private String appliance;
	private double pwrCon;
	private double time;
	private double pwrConDay;
	private double pwrConMonth;
	private double pwrConYear;
	private double pwrCostDay;
	private double pwrCostMonth;
	private double pwrCostYear;
	private String name;
	private String month;
	private String year;
	private int id;
	
	
	public EnergyModel(){}
	public EnergyModel(String appliance, double pwrCon, double time, String name, String month, String year, int id) {
		super();
		this.appliance = appliance;
		this.pwrCon = pwrCon;
		this.time = time;
		this.name = name;
		this.month = month;
		this.year = year;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	FileWriter fw = null; 
	PrintWriter pw = null;

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
	public double getPwrCostDay() {
		return pwrCostDay;
	}
	public void setPwrCostDay(double pwrCostDay) {
		this.pwrCostDay = pwrCostDay;
	}
	public double getPwrCostMonth() {
		return pwrCostMonth;
	}
	public void setPwrCostMonth(double pwrCostMonth) {
		this.pwrCostMonth = pwrCostMonth;
	}
	public double getPwrCostYear() {
		return pwrCostYear;
	}
	public void setPwrCostYear(double pwrCostYear) {
		this.pwrCostYear = pwrCostYear;
	}
	public void setPwrCon(double pwrCon) {
		this.pwrCon = pwrCon;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public String getAppliance() {
		return appliance;
	}
	public void setAppliance(String appliance) {
		this.appliance = appliance;
	}
	public double getPwrCon() {
		return pwrCon;
	}
	public void setPwrCon(int pwrCon) {
		this.pwrCon = pwrCon;
	}
	public double getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public double getPwrConDay() {
		return pwrConDay;
	}
	public void setPwrConDay(double pwrConDay) {
		this.pwrConDay = pwrConDay;
	}
	public double getPwrConMonth() {
		return pwrConMonth;
	}
	public void setPwrConMonth(double pwrConMonth) {
		this.pwrConMonth = pwrConMonth;
	}
	public double getPwrConYear() {
		return pwrConYear;
	}
	public void setPwrConYear(double pwrConYear) {
		this.pwrConYear = pwrConYear;
	}
	
	public double calculateDay(double pwrCon, double time)
	{
		/*this.pwrCon = pwrCon;
		this.time = time;*/
		pwrConDay = ((pwrCon * time)/1000);
		return pwrConDay;
	}
	public double calculateMonth(double pwrCon, double time)
	{
		this.pwrCon = pwrCon;
		this.time = time;
		pwrConMonth = (30 * ((pwrCon * time)/1000));
		return pwrConMonth;
	}
	public double calculateYear(double pwrCon, double time)
	{
		this.pwrCon = pwrCon;
		this.time = time;
		pwrConYear = (365*(pwrCon * time)/1000);
		return pwrConYear;
	}
	public double calculateDayCost(double pwrConDay){
		this.pwrConDay = pwrConDay;
		pwrCostDay = (pwrConDay * 12)/100;
		return pwrCostDay;
	}
	public double calculateMonthCost(double pwrConMonth){
		this.pwrConMonth = pwrConMonth;
		pwrCostMonth = (pwrConMonth * 12)/100;
		return pwrCostMonth;
	}
	public double calculateYearCost(double pwrConYear){
		this.pwrConYear = pwrConYear;
		pwrCostYear = (pwrConYear * 12)/100;
		return pwrCostYear;
	}
	public void save(int id) throws FileNotFoundException
	{
		try 
		{
			//true entered for appending(or adding thing to file)
			fw = new FileWriter("ApplianceIdNumbers.txt",true);
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
		pw.println(" ID: " + id);
		pw.println("Name: " +name );
		pw.println("Month: " +month );
		pw.println("Year: " +year );
		pw.println("Appliance: " +appliance );
		pw.println("Power Consumption: " +pwrCon  + "/kWh");
		pw.println("Time: " +time + " hours");
		pw.println("Power Consumption Per Day: " +pwrConDay + "/kWh");
		pw.println("Power Consumption Per Month: " +pwrConMonth+ "/kWh" );
		pw.println("Power Consumption Per Year: " +pwrConYear + "/kWh");
		pw.println("Cost per Day: " +formatter.format(pwrCostDay) );
		pw.println("Cost per Month: " +formatter.format(pwrCostMonth) );
		pw.println("Cost per Year: " +formatter.format(pwrCostYear) );
		pw.println("-----------------------------------------");
		pw.close();
		pw.println("-----------------------------------------");
		pw.close();
	}
	@Override
	public String toString() {
		return "Name: " + name +"\nMonth: "+ month+" Year: "+year + "\nAppliance: " + appliance + "\nPower Consumption: " + pwrCon + " kWh/hr \nTime: " + time + 
				"hours \nPower Consumption Per Day: "+ pwrConDay + " kWh \nPower Consumption Per Month: " + pwrConMonth + 
				" kWh \nPower Consumption Per Year: " + pwrConYear + " kWh " + "\nCost per Day: " + formatter.format(pwrCostDay)
				+ "\nCost Per Month: " + formatter.format(pwrCostMonth) + "\nCost Per Year: " + formatter.format(pwrCostYear) + "\n------------------------------";
	}
	
}
