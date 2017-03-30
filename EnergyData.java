package wholeProjectSecondVersion;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class EnergyData implements Serializable{
	
	// ArrayList
	private ArrayList<EnergyModel> eModel;
	private ArrayList<CarEnergyModel> cModel;
	
	public EnergyData() {
		
		this.eModel = new ArrayList<>();
		this.cModel = new ArrayList<>();	
		
	}
	
	@SuppressWarnings("Unchecked")
	public void loadArrays(EnergyData data) throws FileNotFoundException, ClassNotFoundException {
		
		FileInputStream fis = null;
		ObjectInputStream input = null;
		
		try
		{
			fis = new FileInputStream("EnergyData.dat");
			input = new ObjectInputStream(fis);
			
		}
		catch (IOException e) 
		{

		}
		
		try {
			EnergyData d = (EnergyData) input.readObject();
			data.seteModel(d.geteModel());
			data.setcModel(d.getcModel());
			
		} catch(Exception e) {
			System.out.println("");
		}
		try {
			input.close();
		} catch (IOException | NullPointerException e) {
				//e.printStackTrace();
			}

	}
	
		public void saveArrays(EnergyData data)
		{
			FileOutputStream fos = null;
			ObjectOutputStream output = null;
		
		
		try{
			fos = new FileOutputStream("EnergyData.dat");
			output = new ObjectOutputStream(fos);
			
		}
		catch(IOException e) {
			System.out.println("ERROR, TRY AGAIN!");
			
		}
		
		try 
		{
			output.writeObject(data.geteModel());
			output.writeObject(data.getcModel());
			output.close();
			
		} 
		catch(IOException e) {

		}
		
	}
		public static EnergyModel searchArrays(int idNo, EnergyData data) {
			for(EnergyModel energyModel : data.geteModel())
			{
				if(energyModel.getId() == idNo)
				{
					return energyModel;
				}
			}
			return null;
		}
			public static CarEnergyModel searchCarArrays(int idNo, EnergyData data) {

				for(CarEnergyModel carEnergyModel : data.getcModel())
				{
					if(carEnergyModel.getId() == idNo)
					{
						return carEnergyModel;
					}
				}
				return null;
		}

		
public ArrayList<EnergyModel> geteModel() {
	return eModel;
}

public void seteModel(ArrayList<EnergyModel> eModel) {
	this.eModel = eModel;
}

public ArrayList<CarEnergyModel> getcModel() {
	return cModel;
}

public void setcModel(ArrayList<CarEnergyModel> cModel) {
	this.cModel = cModel;
}

	
}
