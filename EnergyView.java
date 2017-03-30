package wholeProjectSecondVersion;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class EnergyView implements Serializable{
	private EnergyData data;
	private int EnergyModel;
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	private WindowListener windowListener;
	private Label appliance;
	private Label powerConsumption;
	private Label hours;
	private Label ecDay;
	private Label ecMonth;
	private Label ecYear;
	private Label hDay;
	private Label watts;
	private Label costOfkWh;
	private Label costEcDay;
	private Label costEcMonth;
	private Label costEcYear;
	
	private EnergyModel model;
	private EnergyModel emodel;
	private TextField name;
	private TextField month;
	private TextField year;
	private Label nameLbl;
	private Label monthLbl;
	private Label yearLbl;
	private Label id;
	
	private Menu applianceMenu;
	private	MenuItem fridge;
	private MenuItem television;
	private MenuItem computer;
	private MenuItem heat;
	private MenuItem airConditioner;
	private MenuItem dryer;
	private MenuItem washer;
	private MenuItem dishWasher;
	private MenuItem stove;
	private MenuItem microwave;
	private MenuBar menuBar;
	private MenuBar topMenuBar;
	
	private Menu fileMenu;
	private MenuItem newMenuItem;
	private MenuItem carMenuItem;
	private MenuItem mainMenuItem;
	private MenuItem exitMenuItem;
	
	private Menu months;
	private MenuItem january;
	private MenuItem february;
	private MenuItem march;
	private MenuItem april;
	private MenuItem may;
	private MenuItem june;
	private MenuItem july;
	private MenuItem august;
	private MenuItem september;
	private MenuItem october;
	private MenuItem november;
	private MenuItem december;
	private MenuBar monthBar;

	private Button calculate;
	private Button reset;
	private Button load;
	private Button save;
	private TextField applianceText;
	private TextField powerConsumptionText;
	private TextField hoursText;
	private TextField idText;
	private TextArea result;
	
	private TextArea ecDayText;
	private TextArea ecMonthText;
	private TextArea ecYearText;
	private TextArea ecCostDayText;
	private TextArea ecCostMonthText;
	private TextArea eCostYearText;
	
	private Text instructions;
	private Text saveMessage;
	private TextArea suggestion;
	
	private BorderPane root;
	private HBox appliancesPane;
	private HBox powerConsumptionPane;
	private HBox hoursPane;
	private HBox energyDayPane;
	private HBox energyMonthPane;
	private HBox energyYearPane;
	
	private HBox energyCostDayPane;
	private HBox energyCostMonthPane;
	private HBox energyCostYearPane;
	private HBox personPane;
	private HBox buttonPane;

	private VBox paneTop;
	private HBox paneBottom;
	private VBox paneWhole;
	private HBox paneCost;
	
	public EnergyView(Stage stage) {
		//this.stage = stage;
		
		ArrayList<String> string = new ArrayList(100);
		model = new EnergyModel();
		data = new EnergyData();
		NumberFormat f = NumberFormat.getInstance();
		stage.setTitle("Energy Consumption Calculator");
		appliance = new Label("Appliance: ");
		appliance.setAlignment(Pos.CENTER);		
		hDay = new Label("H/Day");
		hDay.setAlignment(Pos.CENTER);
		watts = new Label ("Watts");
		watts.setAlignment(Pos.CENTER);
		powerConsumption = new Label("Power Consumption: ");
		powerConsumption.setAlignment(Pos.CENTER);
		hours = new Label("Hours used in a day: ");
		hours.setAlignment(Pos.CENTER);
		ecDay = new Label("Energy Consumed Per Day:");
		ecDay.setAlignment(Pos.CENTER);
		ecMonth = new Label("Energy Consumed Per Month:");
		ecMonth.setAlignment(Pos.CENTER);
		ecYear = new Label("Energy Consumed Per Year: ");
		ecYear.setAlignment(Pos.CENTER);
		
		costOfkWh = new Label("1 kilowatt-hour (kWh) cost: ");
		costOfkWh.setAlignment(Pos.CENTER);
		costEcDay = new Label("Electricity cost per day: ");
		costEcDay.setAlignment(Pos.CENTER);
		costEcMonth = new Label("Electricity cost per month:");
		costEcMonth.setAlignment(Pos.CENTER);
		costEcYear = new Label("Electricity cost per year: ");
		costEcYear.setAlignment(Pos.CENTER);
		
		id = new Label ("ID: ");
		idText = new TextField();
		
		calculate = new Button("Calculate");
		reset = new Button("Reset");
		load = new Button ("Load");
		save = new Button("Save");
		applianceText = new TextField();
		powerConsumptionText = new TextField();
		hoursText = new TextField();
		
		applianceMenu = new Menu ("Appliance Type");
		fridge = new MenuItem("Fridge");
		television = new MenuItem("TV");
		computer = new MenuItem("Computer");
		heat = new MenuItem("Heater");
		airConditioner = new MenuItem("A/C");
		dryer = new MenuItem("Dryer");
		washer = new MenuItem("Washer");
		dishWasher = new MenuItem("Dish Washer");
		stove = new MenuItem("Stove");
		microwave = new MenuItem("Microwave");
		menuBar = new MenuBar();
		
		nameLbl = new Label("Name:");
		monthLbl = new Label("Month:");
		yearLbl = new Label ("Year: ");
		name = new TextField();
		month = new TextField();
		year = new TextField();
		
		fileMenu = new Menu ("File");
		newMenuItem = new MenuItem("New");
		carMenuItem = new MenuItem("Car");	
		exitMenuItem = new MenuItem("Exit");
		mainMenuItem = new MenuItem("Main");

		months = new Menu("Months");
		january = new MenuItem("January");
		february = new MenuItem("February");
		march = new MenuItem("March");
		april = new MenuItem("April");
		may = new MenuItem("May");
		june = new MenuItem("June");
		july = new Menu ("July");
		august = new MenuItem("August");
		september = new MenuItem("September");
		october = new MenuItem("October");
		november = new MenuItem("Novmeber");
		december = new MenuItem("December");
		monthBar = new MenuBar();
		
		fileMenu.getItems().addAll(mainMenuItem,newMenuItem, carMenuItem, new SeparatorMenuItem(), exitMenuItem);
		ecDayText = new TextArea();
		ecDayText.setPrefSize(200,25);
		ecMonthText = new TextArea();
		ecMonthText.setPrefSize(200,25);
		ecYearText = new TextArea();
		ecYearText.setPrefSize(200,25);
		ecCostDayText = new TextArea();
		ecCostDayText.setPrefSize(200,25);
		ecCostMonthText = new TextArea();
		ecCostMonthText.setPrefSize(200,25);
		eCostYearText = new TextArea();
		eCostYearText.setPrefSize(200,25);
		
		result = new TextArea();
		result.setPrefSize(500,100);
		
		suggestion = new TextArea();
		suggestion.setPrefSize(500,100);
		
		appliancesPane = new HBox(30);
		powerConsumptionPane = new HBox(30);
		hoursPane = new HBox(30);
		energyDayPane = new HBox(30);
		energyMonthPane = new HBox(30);
		energyYearPane = new HBox(30);
		buttonPane = new HBox(30);
		
		energyCostDayPane = new HBox(30);
		energyCostMonthPane = new HBox(30);
		energyCostYearPane = new HBox(30);
		personPane = new HBox(30);
		paneTop = new VBox(30);
		
		paneBottom = new HBox(30);
		//paneTop.setAlignment(Pos.TOP_CENTER);
		paneCost = new HBox(30);
		paneWhole = new VBox(30);
		paneWhole.setAlignment(Pos.TOP_CENTER);
		
		root = new BorderPane();
		MenuBar topMenuBar = new MenuBar();
		topMenuBar.prefWidthProperty().bind(root.widthProperty());
		root.setTop(topMenuBar);
		
		instructions = new Text
				("Type in your name, month & year. "
						+ "Choose your appliance from the menu or add your own, and type in how many hours"
						+ "in a day you use it. And press the 'calculate' button."
						+ "\nThe program will calculate and save your data in EnergyData.dat" );
		saveMessage = new Text();
		
		instructions.setTextAlignment(TextAlignment.CENTER);
		
		calculate.setOnAction(event -> {

			ecDayText.clear();
			ecMonthText.clear();
			ecYearText.clear();
			ecCostDayText.clear();
			ecCostMonthText.clear();
			eCostYearText.clear();
			suggestion.clear();
			String appliance = applianceText.getText();
			
			String pwrCon = powerConsumptionText.getText();
			//double pwrCon = Double.parseDouble(powerConsumptionText.getText());
			
			String hours = hoursText.getText();
			//double hours = Double.parseDouble(hoursText.getText());
			String nameString = name.getText();
			String monthString = month.getText();
			String yearString = year.getText();
			String idString = idText.getText();
			
			saveMessage.setText("Data saved to " +nameString +"appliancedata.txt!");

			WindowEvent ev = new WindowEvent(this, appliance, pwrCon, hours,nameString,monthString,yearString,idString);
			if(windowListener != null) {
				windowListener.buttonClicked(ev);
			}
			
			if(appliance.equalsIgnoreCase("tv") && model.getPwrCostDay()>= 5)
				{
					suggestion.clear();
					suggestion.setText("You are watching way too much TV"
							+ "\nGo ride a bike!");
				}
				else if(appliance.equalsIgnoreCase("tv")&& model.getPwrCostDay()<=5)
				{
					suggestion.clear();
					suggestion.setText("You are watching way too much TV"
							+ "\nGo ride a bike!");
				}
				else if(appliance.equalsIgnoreCase("a/c")&&  model.getPwrCostDay()>=10)
				{
					suggestion.clear();
					suggestion.setText("Turn down the a/c and turn on a fan");
				}
				else if(appliance.equalsIgnoreCase("a/c")&&  model.getPwrCostDay()>=10)
				{
					suggestion.clear();
					suggestion.setText("Stay Cool!");
				}
				else if(appliance.equalsIgnoreCase("dish washer")&&  model.getPwrCostDay()>=10)
				{
					suggestion.clear();
					suggestion.setText("Wash your dishes once a day instead of twice.");
				}
				else if(appliance.equalsIgnoreCase("dish washer")&&  model.getPwrCostDay()>=10)
				{
					suggestion.clear();
					suggestion.setText("Stay Clean!");
				}
				else if(appliance.equalsIgnoreCase("washer")&&  model.getPwrCostDay()>=10)
				{
					suggestion.clear();
					suggestion.setText("Wash your clothes once a week instead of twice a week");
				}
				
				else if(appliance.equalsIgnoreCase("washer")&&  model.getPwrCostDay()>=10)
				{
					suggestion.clear();
					suggestion.setText("Stay Clean.");
				}
				else if(appliance.equalsIgnoreCase("dryer")&&  model.getPwrCostDay()>=10)
				{
					suggestion.clear();
					suggestion.setText("Dry your clothes on a clothes line. ");
				}
				else if(appliance.equalsIgnoreCase("dryer")&&  model.getPwrCostDay()>=10)
				{
					suggestion.clear();
					suggestion.setText("Stay Dry!");
				}
				else if(appliance.equalsIgnoreCase("computer")&&  model.getPwrCostDay()>=10)
				{
					suggestion.clear();
					suggestion.setText("Happy Computing");
				}
				else if(appliance.equalsIgnoreCase("computer")&&  model.getPwrCostDay()>=10)
				{
					suggestion.clear();
					suggestion.setText("Get your ass off the computer");
				}
				else if(appliance.equalsIgnoreCase("heater")&&  model.getPwrCostDay()>=10)
				{
					suggestion.clear();
					suggestion.setText("Lower the temprature and wear a blanket or "
							+ "\nStart a fire in your fire place");
				}
				else if(appliance.equalsIgnoreCase("heater")&&  model.getPwrCostDay()>=10)
				{
					suggestion.clear();
					suggestion.setText("Stay toasty!");
				}
				else
				{
					suggestion.setText("Save Money!");
				}
		});
		save.setOnAction(event->{
			EnergyModel emodel;
			try {
				data.loadArrays(data);
				
			} catch (FileNotFoundException | ClassNotFoundException ex) {
				
			}
			try {
				emodel = new EnergyModel(applianceText.getText(),Double.parseDouble(powerConsumptionText.getText()),
						Double.parseDouble(hoursText.getText()),name.getText(),month.getText(),year.getText(),
						Integer.parseInt(idText.getText()));				
				data.geteModel().add(emodel);
				
			} catch (NumberFormatException e) {
				
				e.printStackTrace();
			} catch (InputMismatchException e) {
				
				e.printStackTrace();
			}
			data.saveArrays(data);
			EnergyModel = Integer.parseInt(idText.getText());		
	});
	load.setOnAction(event->{
		try {
			data.loadArrays(data);
			
		} catch (FileNotFoundException | ClassNotFoundException ex) {
			
		}
		int idNo;
		try{
			idNo = Integer.valueOf(idText.getText());
		} catch(Exception e) {
			return;
		}
		EnergyModel emodel = (EnergyModel)EnergyData.searchArrays(idNo, data);
		if(emodel == null) {
			name.clear();
			month.clear();
			year.clear();
			applianceText.clear();
			powerConsumptionText.clear();
			hoursText.clear();
			ecDayText.clear();
			ecMonthText.clear();
			ecYearText.clear();
			ecCostDayText.clear();
			ecCostMonthText.clear();
			eCostYearText.clear();
			result.clear();
			suggestion.clear();
		}
		else if(emodel != null)
		{
			name.setText(emodel.getName());
			month.setText(emodel.getMonth());
			year.setText(emodel.getYear());
			applianceText.setText(emodel.getAppliance());
			powerConsumptionText.setText(String.valueOf(emodel.getPwrCon()));
			hoursText.setText(String.valueOf(emodel.getTime()));
			idText.setText(String.valueOf(emodel.getId()));
			
		}
	});
		reset.setOnAction(event ->{
			name.clear();
			month.clear();
			year.clear();
			saveMessage.setText(null);
			applianceText.clear();
			powerConsumptionText.clear();
			hoursText.clear();
			ecDayText.clear();
			ecMonthText.clear();
			ecYearText.clear();
			ecCostDayText.clear();
			ecCostMonthText.clear();
			eCostYearText.clear();
			result.clear();
			suggestion.clear();
		});
		
		fridge.setOnAction(event -> {
			applianceText.clear();
			powerConsumptionText.clear();
			applianceText.appendText("Fridge");
			powerConsumptionText.appendText("1200");});
		television.setOnAction(event -> {
			applianceText.clear();
			powerConsumptionText.clear();
			applianceText.appendText("TV");
			powerConsumptionText.appendText("300");
			});
		computer.setOnAction(event -> { 
			applianceText.clear();
			powerConsumptionText.clear();
			applianceText.appendText("Computer");
			powerConsumptionText.appendText("500");
		});
		heat.setOnAction(event -> {
			applianceText.clear();
			powerConsumptionText.clear();
			applianceText.appendText("Heat");
			powerConsumptionText.appendText("500");
		});
		airConditioner.setOnAction(event -> { 
			applianceText.clear();
			powerConsumptionText.clear();
			applianceText.appendText("A/C");
			powerConsumptionText.appendText("5000");
			});
		dryer.setOnAction(event -> {
			applianceText.clear();
			powerConsumptionText.clear();
			applianceText.appendText("Dryer");
			powerConsumptionText.appendText("850");
			});
		washer.setOnAction(event -> {
			applianceText.clear();
			powerConsumptionText.clear();
			applianceText.appendText("Washer");
			powerConsumptionText.appendText("512");
			});
		dishWasher.setOnAction(event -> {
			applianceText.clear();
			powerConsumptionText.clear();
			applianceText.appendText("Dish Washer");
			powerConsumptionText.appendText("1200");
			});
		stove.setOnAction(event -> {
			applianceText.clear();
			powerConsumptionText.clear();
			applianceText.appendText("Stove");
			powerConsumptionText.appendText("3000");
			});
		microwave.setOnAction(event -> {
			applianceText.clear();
			powerConsumptionText.clear();
			applianceText.appendText("Microwave");
			powerConsumptionText.appendText("1500");
			});
		
		exitMenuItem.setOnAction(event -> Platform.exit());
		newMenuItem.setOnAction(event -> {
			name.clear();
			month.clear();
			year.clear();
			applianceText.clear();
			powerConsumptionText.clear();
			hoursText.clear();
			ecDayText.clear();
			ecMonthText.clear();
			ecYearText.clear();
			ecCostDayText.clear();
			ecCostMonthText.clear();
			eCostYearText.clear();		
		});
		carMenuItem.setOnAction(event ->{
			CarEnergyView carView = new CarEnergyView(stage);
			CarEnergyModel carModel = new CarEnergyModel();
			CarEnergyController carController = new CarEnergyController(carModel, carView);
		});
		mainMenuItem.setOnAction(event->
		{
			Demo demo = new Demo();
			try {
				demo.start(stage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		january.setOnAction(event->{
			month.clear();
			month.setText("January");
		});
		february.setOnAction(event->{
			month.clear();
			month.setText("February");
		});
		march.setOnAction(event->{
			month.clear();
			month.setText("March");
		});
		april.setOnAction(event->{
			month.clear();
			month.setText("April");
		});
		may.setOnAction(event->{
			month.clear();
			month.setText("May");
		});
		june.setOnAction(event->{
			month.clear();
			month.setText("June");
		});
		july.setOnAction(event->{
			month.clear();
			month.setText("July");
		});
		august.setOnAction(event->{
			month.clear();
			month.setText("August");
		});
		september.setOnAction(event->{
			month.clear();
			month.setText("September");
		});
		october.setOnAction(event->{
			month.clear();
			month.setText("October");
		});
		november.setOnAction(event->{
			month.clear();
			month.setText("November");
		});
		december.setOnAction(event->{
			month.clear();
			month.setText("December");
		});
		applianceMenu.getItems().addAll(fridge, television , computer, heat, airConditioner,
										dryer, washer, dishWasher, stove, microwave);
		menuBar.getMenus().addAll(applianceMenu);
		topMenuBar.getMenus().addAll(fileMenu);
		months.getItems().addAll(january,february,march,april,may,june,july,august,september,october,november,december);
		monthBar.getMenus().addAll(months);
		
		buttonPane.getChildren().addAll(calculate,reset,save,load,suggestion);
		personPane.getChildren().addAll(nameLbl, name, monthBar, month,yearLbl,year, id, idText);
		appliancesPane.getChildren().addAll(menuBar, applianceText );
		powerConsumptionPane.getChildren().addAll(powerConsumption, powerConsumptionText, watts);
		hoursPane.getChildren().addAll(hours, hoursText,hDay);
		energyDayPane.getChildren().addAll(ecDay, ecDayText);
		energyMonthPane.getChildren().addAll(ecMonth, ecMonthText);
		energyYearPane.getChildren().addAll(ecYear, ecYearText);

		energyCostDayPane.getChildren().addAll(costEcDay,ecCostDayText);
		energyCostMonthPane.getChildren().addAll(costEcMonth,ecCostMonthText);
		energyCostYearPane.getChildren().addAll(costEcYear,eCostYearText);
		
		paneTop.getChildren().addAll(instructions, personPane,appliancesPane, powerConsumptionPane,hoursPane,buttonPane);
		paneBottom.getChildren().addAll(energyDayPane, energyMonthPane,energyYearPane);
		paneCost.getChildren().addAll(energyCostDayPane,energyCostMonthPane,energyCostYearPane);
		paneWhole.getChildren().addAll(root, paneTop,paneBottom,paneCost);
		
		stage.setScene(new Scene(paneWhole));
		stage.show();
	}
	public void setWindowListener(WindowListener windowListener) {
		this.windowListener = windowListener;
	}
	public void displayDataDay(double pwrDay){
		ecDayText.appendText(pwrDay + " kWh/day");
		
	}
	public void displayDataMonth(double pwrMonth){
		ecMonthText.appendText(pwrMonth+ " kWh/month");
		
	}
	public void displayDataYear(double pwrYear){
		ecYearText.appendText(pwrYear+ " kWh/year");
		
	}
	public void displayDataDayCost(double pwrDayCost){
		ecCostDayText.appendText(formatter.format(pwrDayCost) + " /day");
		
	}
	public void displayDataMonthCost(double pwrMonthCost){
		ecCostMonthText.appendText(formatter.format(pwrMonthCost)+ " /month");
		
	}
	public void displayDataYearCost(double pwrYearCost){
		eCostYearText.appendText(formatter.format(pwrYearCost)+ " /year");
		
	}
	
		
}

