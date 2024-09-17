package kerbal;

public class CelestialBody {
	private String name;
	private double diameter; //in km
	private double surfaceGravity;
	private BodyComposition composition;
	private double distanceFromParent; //in km
	
	
	enum BodyComposition{Rocky, Gaseous, Plasma};

	public CelestialBody(String name, double diameter, double surfaceGravity, BodyComposition composition, double distanceFromParent) {
		this.name = name;
		this.diameter = diameter;
		this.surfaceGravity = surfaceGravity;
		this.composition = composition;
		this.distanceFromParent = distanceFromParent;
	}
	
	//Methods
	public String getName() {
		return name;
	}
}
