package wholeProjectSecondVersion;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Demo extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Final Project App");
		
		final ImageView carImageView = new ImageView();
		Image car = new Image(Demo.class.getResourceAsStream("car.png"));
		carImageView.setImage(car);
		
		final ImageView houseImageView = new ImageView();
		Image house = new Image(Demo.class.getResourceAsStream(("house.png")));
		houseImageView.setImage(house);
		
		BorderPane root = new BorderPane();
		
		carImageView.setFitHeight(150);
		carImageView.setFitWidth(200);
		houseImageView.setFitHeight(150);
		houseImageView.setFitWidth(150);
		Button carBtn = new Button("Car", carImageView);
		carBtn.setContentDisplay(ContentDisplay.TOP);
		Button houseBtn = new Button("Appliances", houseImageView);
		houseBtn.setContentDisplay(ContentDisplay.TOP);
		Text instructions = new Text
				("Welcome! \nTo calculate the cost of gas press the 'car' button"
						+ "\nTo calculate the cost and power consumption of appliances press the 'Appliances' button");
		instructions.setTextAlignment(TextAlignment.CENTER);
		
		MenuBar menuBar = new MenuBar();
		menuBar.prefWidthProperty().bind(stage.widthProperty());
		
		
		Menu fileMenu = new Menu ("File");
		MenuItem carMenuItem = new MenuItem("Car");
		MenuItem applianceMenuItem = new MenuItem("Appliances");
		MenuItem exitMenuItem = new MenuItem("Exit");
		
		exitMenuItem.setOnAction(event -> Platform.exit());
		fileMenu.getItems().addAll(carMenuItem, applianceMenuItem, new SeparatorMenuItem(), exitMenuItem);
		
		HBox buttons  = new HBox(30);
		buttons.setAlignment(Pos.CENTER);	
		HBox text = new HBox(30);
		text.setAlignment(Pos.CENTER);
		VBox pane = new VBox(30);
		
		carBtn.setOnAction(event ->{
		CarEnergyView carView = new CarEnergyView(stage);
		CarEnergyModel carModel = new CarEnergyModel();
		CarEnergyController carController = new CarEnergyController(carModel, carView);
			});
		
		carMenuItem.setOnAction(event ->{
		CarEnergyView carView = new CarEnergyView(stage);
		CarEnergyModel carModel = new CarEnergyModel();
		CarEnergyController carController = new CarEnergyController(carModel, carView);
			});
		
		houseBtn.setOnAction(event -> {
		EnergyView energyView = new EnergyView(stage);
		EnergyModel energyModel = new EnergyModel();
		EnergyController energyController = new EnergyController(energyModel, energyView);
		});
		
		applianceMenuItem.setOnAction(event -> {
			EnergyView energyView = new EnergyView(stage);
			EnergyModel energyModel = new EnergyModel();
			
			EnergyController energyController = new EnergyController(energyModel, energyView);
			});
		
		root.setTop(menuBar);
		menuBar.getMenus().addAll(fileMenu);
		buttons.getChildren().addAll(carBtn, houseBtn);
		text.getChildren().addAll(instructions);
		pane.getChildren().addAll(root, text,buttons);
		stage.setScene(new Scene(pane, 500, 500));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
