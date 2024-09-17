package kerbal;

public class Ship {
	private String name;
	private Part[] parts;

	//Methods
	public Ship(String name, Part[] parts) {
		this.name = name;
		this.parts = parts;
	}
	
	
	//Methods
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

	public String getName() {
		return name;
	}

	public void getThrust(){
		double thrust = 0;
		for(int i = 0; i < parts.length; i++){
			if(parts[i] instanceof Engine){
				Engine engine = (Engine) parts[i];
				thrust += engine.getThrust();
			}
		}
	}
	
	public double getShipWeight() {
		double weight = 0;
		for(int i = 0; i < parts.length; i++) {
			weight += parts[i].getWeight();
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
