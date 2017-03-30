package wholeProjectSecondVersion;

import java.io.FileNotFoundException;

import javafx.stage.Stage;

public class EnergyController {
	

	public EnergyController(EnergyModel model, EnergyView window) {

		window.setWindowListener(new WindowListener() {
			
			public void buttonClicked(WindowEvent ev) {
				model.setAppliance(ev.getAppliance());
				model.setName(ev.getName());
				model.setYear(ev.getYear());
				model.setMonth(ev.getMonth());
				model.calculateDay(Double.parseDouble(ev.getPwrCon()), Double.parseDouble(ev.getHour()));
				model.calculateMonth(Double.parseDouble(ev.getPwrCon()), Double.parseDouble(ev.getHour()));
				model.calculateYear(Double.parseDouble(ev.getPwrCon()), Double.parseDouble(ev.getHour()));
				
				model.calculateDayCost(model.calculateDay(Double.parseDouble(ev.getPwrCon()), 
														  Double.parseDouble(ev.getHour())));
				model.calculateMonthCost(model.calculateMonth(Double.parseDouble(ev.getPwrCon()), 
															  Double.parseDouble(ev.getHour())));
				model.calculateYearCost(model.calculateYear(Double.parseDouble(ev.getPwrCon()), 
															Double.parseDouble(ev.getHour())));
				
				window.displayDataDay(model.calculateDay(Double.parseDouble(ev.getPwrCon()), 
														 Double.parseDouble(ev.getHour())));
				window.displayDataMonth(model.calculateMonth(Double.parseDouble(ev.getPwrCon()),
															Double.parseDouble(ev.getHour())));

				window.displayDataYear(model.calculateYear(Double.parseDouble(ev.getPwrCon()),
															Double.parseDouble(ev.getHour())));
				
				window.displayDataDayCost(model.calculateDayCost(model.calculateDay
																(Double.parseDouble(ev.getPwrCon()), 
																 Double.parseDouble(ev.getHour()))));
				
				window.displayDataMonthCost(model.calculateMonthCost(model.calculateMonth
																	(Double.parseDouble(ev.getPwrCon()), 
															         Double.parseDouble(ev.getHour()))));
				window.displayDataYearCost(model.calculateYearCost(model.calculateYear
																  (Double.parseDouble(ev.getPwrCon()), 
																   Double.parseDouble(ev.getHour()))));

				
				try {
					model.save(Integer.parseInt(ev.getId()));	
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}
	
//	 to do more students, we need a bag between controller and POJOs
}

	