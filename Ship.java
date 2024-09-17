package kerbal;

public class Ship {
	private String name;
	private Part[] parts;

	public Ship(String name, Part[] parts) {
		this.name = name;
		this.parts = parts;
	}
	
	//Methods
	public double getDeltaV(){
		double deltaV = 0;
		double totalThrust = getShipThrust();
		double totalWeight = getShipWeight(true);
		deltaV = totalThrust / totalWeight * Math.log(totalWeight / (getShipWeight(false)));
		return deltaV;
	}

	public String getShipGraphics() {
		String graphics = "";
		for(int i = 0; i < parts.length; i++) {
			graphics += parts[i].getGraphics();
		}
		return graphics;
	}
	
	public Part[] getParts() {
		return parts;
	}

	public void addPart(Part part) {
		Part[] temp = new Part[parts.length + 1];
		for(int i = 0; i < parts.length; i++) {
			temp[i] = parts[i];
		}
		temp[parts.length] = part;
		parts = temp;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public double getShipThrust(){
		double thrust = 0;
		for(int i = 0; i < parts.length; i++){
			if(parts[i] instanceof Engine){
				Engine engine = (Engine) parts[i];
				thrust += engine.getThrust();
			}
		}
		return thrust;
	}
	
	public double getShipWeight(boolean includeFuel) {
		double weight = 0;
		for(int i = 0; i < parts.length; i++) {
			weight += parts[i].getWeight();

			if(includeFuel && parts[i] instanceof FuelTank) {
				FuelTank fuelTank = (FuelTank) parts[i];
				weight += fuelTank.getCurrentFuel() * Physics.fuelWeight;
			}
		}
		
		return weight;
	}

	public void refuel () {
		for(int i = 0; i < parts.length; i++) {
			if(parts[i] instanceof FuelTank) {
				FuelTank fuelTank = (FuelTank) parts[i];
				fuelTank.setCurrentFuel(fuelTank.getFuelCapacity());
			}
		}
	}
}
