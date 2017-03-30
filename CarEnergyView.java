package wholeProjectSecondVersion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.NumberFormat;
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
public class CarEnergyView implements Serializable
{
	//Declaring all of the objects, and items to place in GUI
	private EnergyData data;
	private int CarEnergyModel;
	private CarWindowListener windowListener;
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	private CarEnergyModel model;
	private Label carType;
	private Label milesDrivenDaily;
	private Label gasoline;
	private Label mpg;
	private Label gasDayLabel;
	private Label gasMonthLabel;
	private Label gasYearLabel;
	private Label id;
	
	private Button calculate;
	private Button reset;
	private Button load;
	private Button save;
	
	private TextField carText;
	private TextField milesDrivenDailyText;
	private TextField gasText;
	private TextField milesText;
	private TextField idText;
	
	private TextField name;
	private TextField month;
	private TextField year;
	private Label nameLbl;
	private Label monthLbl;
	private Label yearLbl;
	
	private TextArea gasDayText;
	private TextArea gasMonthText;
	private TextArea gasYearText;
	
	private TextArea result;
	private TextArea suggestions;
	
	private Text saveMessage;
	private Text instructions;
	
	private Menu carMenu;
	private	MenuItem nissanAltima;
	private MenuItem nissanMaxima;
	private MenuItem nissanSentra;
	private MenuItem nissanPathfinder;
	private MenuItem hondaAccord;
	private MenuItem hondaCrv;
	private MenuItem hondaCivic;
	private MenuItem toyotaCorolla;
	private MenuItem toyotaCamry;
	private MenuItem toyotaRav4;
	private	MenuItem vwJetta;
	private MenuItem vwMurano;
	private MenuItem vwGolf;
	private MenuItem bmw3;
	private MenuItem bmw5;
	private MenuItem bmw7;
	private MenuItem mercedesC;
	private MenuItem mercedesE;
	private MenuItem mercedesS;
	private MenuItem chevyAvalanche;
	private	MenuItem jeepGC;
	private MenuItem jeepWrangler;
	private MenuItem gmcSierra;
	private MenuItem toyotaTundra;
	private MenuItem ford250;
	private MenuItem mustang;
	private MenuItem miniCooper;
	private MenuItem mazda6;
	private MenuItem mazda3;
	private MenuItem chevyCamaro;
	private MenuBar menuBar;
	private MenuBar topMenuBar;
	
	
	private Menu fileMenu;
	private MenuItem newMenuItem;
	private MenuItem appliancesMenuItem;
	private MenuItem exitMenuItem;
	private MenuItem mainMenuItem;
	
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

	private BorderPane root;
	private HBox carPane;
	private HBox milesPane;
	private HBox milesPGGame;
	private HBox gasPane;
	private HBox gasDayPane;
	private HBox gasMonthPane;
	private HBox gasYearPane;
	private HBox buttonPane;
	private HBox personPane;
	private VBox gasPaneTop;
	private VBox gasPaneBottom;
	private VBox paneWhole;
	private VBox paneTop;
	private HBox paneBottom;
	private Stage stage;
	

	//Constuctor for GUI
	public CarEnergyView(Stage stage) {
		//Initializing all items for GUI. Such as labels, text areas/fields,buttons,etc. 
		data = new EnergyData();
		stage.setTitle("Gas Cost Calculator");
		model = new CarEnergyModel();
		carType = new Label("Car Type: ");
		carType.setAlignment(Pos.CENTER);		
		milesDrivenDaily = new Label("Mi/Day");
		milesDrivenDaily.setAlignment(Pos.CENTER);
		gasoline = new Label ("Current cost of Gasoline per gallon: ");
		gasoline.setAlignment(Pos.CENTER);
		mpg = new Label("Miles Per Gallon ");
		mpg.setAlignment(Pos.CENTER);
		gasDayLabel = new Label("Cost of Gas Per Day:");
		gasDayLabel.setAlignment(Pos.CENTER);
		gasMonthLabel = new Label("Cost of Gas Per Month:");
		gasMonthLabel.setAlignment(Pos.CENTER);
		gasYearLabel = new Label("Cost of Gas Per Year: ");
		gasYearLabel.setAlignment(Pos.CENTER);
		calculate = new Button("Calculate");
		reset = new Button("Reset");
		load = new Button("Load");
		id = new Label("ID: ");
		save = new Button("Save");
		carText = new TextField();
		milesDrivenDailyText = new TextField();
		gasText = new TextField();
		milesText = new TextField();
		idText = new TextField();
		suggestions = new TextArea();
		suggestions.setPrefSize(500,100);
		gasDayText = new TextArea();
		gasDayText.setPrefSize(200,50);
		gasMonthText = new TextArea();
		gasMonthText.setPrefSize(200,50);
		gasYearText = new TextArea();
		gasYearText.setPrefSize(200,50);
		result = new TextArea();
		instructions = new Text
				("Type in your name, month & year. "
						+ "Choose your car from the menu or add your own, and type in "
						+ "how many miles you drive daily in a day. And press the 'calculate' button."
						+ "\nThe program will calculate and save your data in [your name] cardata.txt" );
		instructions.setTextAlignment(TextAlignment.CENTER);
		saveMessage = new Text();
		nameLbl = new Label("Name:");
		monthLbl = new Label("Month:");
		yearLbl = new Label ("Year: ");
		name = new TextField();
		month = new TextField();
		year = new TextField();
		
	
		//Menu for list of cars
		carMenu = new Menu ("Car");
		nissanAltima = new MenuItem ("Nissan Altima");
		nissanMaxima = new MenuItem("Nissan Maxima");
		nissanSentra = new MenuItem("Nissan Sentra");
		nissanPathfinder = new MenuItem("Nissan PathFinder");
		hondaAccord = new MenuItem("Honda Accord");
		hondaCrv = new MenuItem("Honda C-RV");
		hondaCivic = new MenuItem("Honda Civic");
		toyotaCorolla = new MenuItem("Toyota Corolla");
		toyotaCamry = new MenuItem("Toyota Camry");
		toyotaRav4 = new MenuItem("Toyota Rav 4");
		toyotaTundra = new MenuItem("Toyota Tundra");
		vwJetta = new Menu ("Volkswagon Jetta");
		vwGolf = new MenuItem("Volkswagon Golf");
		vwMurano = new MenuItem("Volkswagon Murano");
		bmw3 = new MenuItem("BMW 3 Series");
		bmw5 = new MenuItem("BMW 5 Series");
		bmw7 = new MenuItem("BMW 7 Series");
		mercedesC = new MenuItem("Mercedes C Class");
		mercedesE = new MenuItem("Mercedes E Class");
		mercedesS = new MenuItem("Mercedes S Class");
		jeepGC = new MenuItem("Jeep Grand Cherokee");
		chevyAvalanche = new MenuItem("Chevy Avalanche");
		chevyCamaro = new MenuItem("Chevy Camaro");
		jeepWrangler = new MenuItem("Jeep Wrangler");
		gmcSierra = new Menu ("GMC Sierra");
		ford250 = new MenuItem("Ford F-250");
		mustang = new MenuItem("Ford Mustang");
		miniCooper = new MenuItem("Mini Cooper");
		mazda6 = new MenuItem("Mazda 6");
		mazda3 = new MenuItem("Mazda 3");
		menuBar = new MenuBar();
		
		//menu for months
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
		
		//Initializing panes
		carPane = new HBox(30);
		milesPane = new HBox(30);
		milesPGGame = new HBox(30);
		gasPane = new HBox(30);
		gasDayPane = new HBox(30);
		gasMonthPane = new HBox(30);
		gasYearPane = new HBox(30);
		buttonPane = new HBox(30);
		personPane = new HBox(30);
		paneTop = new VBox(30);
		paneBottom = new HBox(30);
		paneTop.setAlignment(Pos.CENTER);
		paneWhole = new VBox(30);
		paneWhole.setAlignment(Pos.CENTER);
		root = new BorderPane();
		MenuBar topMenuBar = new MenuBar();
		topMenuBar.prefWidthProperty().bind(root.widthProperty());
		root.setTop(topMenuBar);
		
		//adding items to main menu on top
		fileMenu = new Menu ("File");
		newMenuItem = new MenuItem("New");
		appliancesMenuItem = new MenuItem("Appliances");
		exitMenuItem = new MenuItem("Exit");
		mainMenuItem = new MenuItem("Main");
		
		//Action Event for when calculate button is clicked
		//Window event class is invoked and suggestion text and cost text fields
		// are updated
		calculate.setOnAction(event -> {
			gasDayText.clear();
			gasMonthText.clear();
			gasYearText.clear();
			suggestions.clear();
			
			String carName = carText.getText();
			
			String miles = milesDrivenDailyText.getText();
			//double pwrCon = Double.parseDouble(powerConsumptionText.getText());
			
			String gas = gasText.getText();
			//double hours = Double.parseDouble(hoursText.getText());
			
			String mpg = milesText.getText();
			
			String nameString = name.getText();
			String monthString = month.getText();
			String yearString = year.getText();
			String idString = idText.getText();
			saveMessage.setText("Data saved to: " + nameString+ "cardata.txt!");
			result.clear();
	
			CarWindowEvent ev = new CarWindowEvent(this, carName, gas, miles, mpg, nameString, monthString , yearString, idString);
			if(windowListener != null) {
				windowListener.buttonClicked(ev);
			}
			if(model.getGasCostDay()<=5){
				suggestions.setText("Try driving a little less"
						+ "\nIf it is necessary to drive a lot, invest in a hybrid");
			}
			else if(model.getGasCostDay()>=5){
				suggestions.setText("You are saving money, take a joy trip if you get a chance");
			}
					
		});
		//Action event when save button is clicked, variables get saved into arraylist
		//and then a file. 
		save.setOnAction(event->{

				CarEnergyModel model;
				try {
					data.loadArrays(data);
					
				} catch (FileNotFoundException | ClassNotFoundException ex) {
					
				}
				try {
					model = new CarEnergyModel(carText.getText(), Double.parseDouble(gasText.getText()), 
							Double.parseDouble(milesText.getText()), Double.parseDouble(milesDrivenDailyText.getText()), 
									name.getText(), month.getText(),
									year.getText(), Integer.parseInt(idText.getText()));				
					data.getcModel().add(model);
					
				} catch (NumberFormatException e) {
					
					e.printStackTrace();
				} catch (InputMismatchException e) {
					
					e.printStackTrace();
				}
				data.saveArrays(data);
				CarEnergyModel = Integer.parseInt(idText.getText());		
		});
		//Action Event for load button, loaded from he id number
		load.setOnAction(event->{
			int idNo;
			try {
				data.loadArrays(data);
				
			} catch (FileNotFoundException | ClassNotFoundException ex) {
				
			}
			try{
				idNo = Integer.valueOf(idText.getText());
			} catch(Exception e) {
				return;
			}
			CarEnergyModel model = (CarEnergyModel)EnergyData.searchCarArrays(idNo, data);
			if(model == null) {
				saveMessage.setText(null);
				name.clear();
				month.clear();
				year.clear();
				carText.clear();
				milesDrivenDailyText.clear();
				gasText.clear();
				milesText.clear();
				gasDayText.clear();
				gasMonthText.clear();
				gasYearText.clear();
				result.clear();
				suggestions.clear();
			}
			else if(model != null)
			{

				name.setText(model.getName());
				month.setText(model.getMonth());
				year.setText(model.getYear());
				carText.setText(model.getCarName());
				gasText.setText(String.valueOf(model.getGasCost()));
				milesDrivenDailyText.setText(String.valueOf(model.getMilesDrivenDaily()));
				milesText.setText(String.valueOf(model.getMiles()));
				idText.setText(String.valueOf(model.getId()));
			}
		});
		//Reset button clears all text from fields/area
		reset.setOnAction(event ->{
			saveMessage.setText(null);
			name.clear();
			month.clear();
			year.clear();
			carText.clear();
			milesDrivenDailyText.clear();
			gasText.clear();
			milesText.clear();
			gasDayText.clear();
			gasMonthText.clear();
			gasYearText.clear();
			result.clear();
			suggestions.clear();
		});
		
		appliancesMenuItem.setOnAction(event -> {
			EnergyView energyView = new EnergyView(stage);
			EnergyModel energyModel = new EnergyModel();
			EnergyController energyController = new EnergyController(energyModel, energyView);
			});
		nissanAltima.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("Nissan Altima");
			milesText.appendText("24");});
		nissanMaxima.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("Nissan Maxima");
			milesText.appendText("18");});
	     nissanSentra.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("Nissan Sentra");
			milesText.appendText("27");});
		nissanPathfinder.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("Nissan PathFinder");
			milesText.appendText("20");});
		hondaAccord.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("Honda Accord");
			milesText.appendText("24");});
		hondaCrv.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("Honda CRV");
			milesText.appendText("20");});
		hondaCivic.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("Honda Civic");
			milesText.appendText("27");});
		toyotaCorolla.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("Toyota Corolla");
			milesText.appendText("24");});
	    toyotaCamry.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("Toyota Camry");
			milesText.appendText("27");});
		toyotaRav4.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("Toyota Rav 4");
			milesText.appendText("21");});
		vwJetta.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("Volkswagon Jetta");
			milesText.appendText("24");});
		vwMurano.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("Volkswagon Murano");
			milesText.appendText("20");});
		vwGolf.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("Volkswagon Golf");
			milesText.appendText("24");});
	    bmw3.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("BMW 3 Series");
			milesText.appendText("25");});
		bmw5.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("BMW 5 Series");
			milesText.appendText("21");});
		bmw7.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("BMW 7 Series");
			milesText.appendText("18");});
		mercedesC.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("Mercedes C Class");
			milesText.appendText("25");});
		mercedesE.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("Mercedes E Class");
			milesText.appendText("21");});
		mercedesS.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("Mercedes S Class");
			milesText.appendText("17");});
		chevyAvalanche.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("Chevy Avalanche");
			milesText.appendText("15");});
		jeepGC.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("Jeep Grand Cherokee");
			milesText.appendText("18");});
		jeepWrangler.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("Jeep Wrangler");
			milesText.appendText("17");});
		gmcSierra.setOnAction(event -> {
			carText.clear();
			milesText.clear();
			carText.appendText("GMC Sierra");
			milesText.appendText("15");});
	    toyotaTundra.setOnAction(event -> {
				carText.clear();
				milesText.clear();
				carText.appendText("Toyota Tundra");
				milesText.appendText("16");});
		ford250.setOnAction(event -> {
				carText.clear();
				milesText.clear();
				carText.appendText("Ford F - 250");
				milesText.appendText("15");});
		mustang.setOnAction(event -> {
				carText.clear();
				milesText.clear();
				carText.appendText("Ford Mustang");
				milesText.appendText("14");});
		miniCooper.setOnAction(event -> {
				carText.clear();
				milesText.clear();
				carText.appendText("MiniCooper");
				milesText.appendText("27");});
		mazda6.setOnAction(event -> {
				carText.clear();
				milesText.clear();
				carText.appendText("Mazda 6");
				milesText.appendText("24");});
		mazda3.setOnAction(event -> {
				carText.clear();
				milesText.clear();
				carText.appendText("Mazda 3");
				milesText.appendText("24");});
		chevyCamaro.setOnAction(event -> {
				carText.clear();
				milesText.clear();
				carText.appendText("Chevy Camaro");
				milesText.appendText("18");});
		exitMenuItem.setOnAction(event -> Platform.exit());
		newMenuItem.setOnAction(event -> {
			name.clear();
			month.clear();
			year.clear();
			carText.clear();
			milesDrivenDailyText.clear();
			gasText.clear();
			milesText.clear();
			gasDayText.clear();
			gasMonthText.clear();
			gasYearText.clear();
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
		
		fileMenu.getItems().addAll(mainMenuItem ,newMenuItem, appliancesMenuItem, new SeparatorMenuItem(), exitMenuItem);
		
		carMenu.getItems().addAll(nissanAltima,nissanMaxima, nissanSentra, nissanPathfinder, 
							      hondaAccord,hondaCrv,hondaCivic,toyotaCorolla,toyotaCamry,
							      toyotaRav4,vwJetta,vwMurano,vwGolf,bmw3,bmw5,bmw7,mercedesC,mercedesE,
							      mercedesS, chevyAvalanche,jeepGC,jeepWrangler,gmcSierra,toyotaTundra,
							      ford250,mustang,miniCooper,mazda6,mazda3,chevyCamaro);
		months.getItems().addAll(january,february,march,april,may,june,july,august,september,october,november,december);
		monthBar.getMenus().addAll(months);
		menuBar.getMenus().addAll(carMenu);
		topMenuBar.getMenus().addAll(fileMenu);

		personPane.getChildren().addAll(nameLbl, name, monthBar, month,yearLbl,year,id,idText);
		carPane.getChildren().addAll(menuBar, carText);
		milesPane.getChildren().addAll(milesDrivenDaily, milesDrivenDailyText);
		milesPGGame.getChildren().addAll(mpg, milesText);
		gasPane.getChildren().addAll(gasoline, gasText);
		gasDayPane.getChildren().addAll(gasDayLabel, gasDayText);
		gasMonthPane.getChildren().addAll(gasMonthLabel, gasMonthText);
		gasYearPane.getChildren().addAll(gasYearLabel, gasYearText);
		buttonPane.getChildren().addAll(calculate,reset,save,load,suggestions);
		
		paneTop.getChildren().addAll(instructions, personPane, carPane, milesPane,gasPane, milesPGGame, buttonPane);
		paneBottom.getChildren().addAll(gasDayPane, gasMonthPane,gasYearPane);
		
		paneWhole.getChildren().addAll(root, paneTop,paneBottom);
		stage.setScene(new Scene(paneWhole));
		stage.show();
	}

	public void displayDataDay(double gasDay){
		gasDayText.appendText(formatter.format(gasDay) + " /day");
		
	}
	public void displayDataMonth(double gasMonth){
		gasMonthText.appendText(formatter.format(gasMonth)+ " /month");
		
	}
	public void displayDataYear(double gasYear){
		gasYearText.appendText(formatter.format(gasYear)+ " /year");
		
	}
	public void setWindowListener(CarWindowListener windowListener) {
		this.windowListener = windowListener;
		
	}

}

