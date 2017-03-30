package wholeProjectSecondVersion;

import java.io.FileNotFoundException;

public class CarEnergyController {
	
	//Constructors with CarEnergyModel object and CarEnergyView object as parameters
	public CarEnergyController(CarEnergyModel model, CarEnergyView window) {
		
		//Window listener when button is clicked
		window.setWindowListener(new CarWindowListener() {
			
			//When button is clicked, set methods are invoked to get 
			//variables from the window event
			public void buttonClicked(CarWindowEvent ev) {
				model.setCarName(ev.getCarName());
				model.setName(ev.getName());
				model.setYear(ev.getYear());
				model.setMonth(ev.getMonth());
				model.calculateDay(Double.parseDouble(ev.getGasCost()), Double.parseDouble(ev.getMpg()), 
													  Double.parseDouble(ev.getMiles()));
				model.calculateMonth(Double.parseDouble(ev.getGasCost()), Double.parseDouble(ev.getMpg()),
														Double.parseDouble(ev.getMiles()));
				model.calculateYear(Double.parseDouble(ev.getGasCost()), Double.parseDouble(ev.getMpg()),
													   Double.parseDouble(ev.getMiles()));
				
				window.displayDataDay(model.calculateDay(Double.parseDouble(ev.getGasCost()), 
														 Double.parseDouble(ev.getMpg()), 
														 Double.parseDouble(ev.getMiles())));
				
				window.displayDataMonth(model.calculateMonth(Double.parseDouble(ev.getGasCost()), 
														     Double.parseDouble(ev.getMpg()), 
														     Double.parseDouble(ev.getMiles())));

				window.displayDataYear(model.calculateYear(Double.parseDouble(ev.getGasCost()), 
														   Double.parseDouble(ev.getMpg()), 
														   Double.parseDouble(ev.getMiles())));

				//saves data by getting id number from one that is entered. 
				try {
					model.save(Integer.parseInt(ev.getId()));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

}

