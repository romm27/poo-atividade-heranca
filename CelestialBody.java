package kerbal;

public class CelestialBody {
	private String name;
	private double diameter; //in km
	private double surfaceGravity;
	private BodyComposition composition;
	private double distanceFromParent; //in km
	private boolean hasFlag;
	
	
	enum BodyComposition{Rocky, Gaseous, Plasma};

	public CelestialBody(String name, double diameter, double surfaceGravity, BodyComposition composition, double distanceFromParent, boolean hasFlag) {
		this.name = name;
		this.diameter = diameter;
		this.surfaceGravity = surfaceGravity;
		this.composition = composition;
		this.distanceFromParent = distanceFromParent;
		this.hasFlag = hasFlag;
	}
	
	//Methods
	public String getName() {
		return name;
	}

	public double getDistanceFromParent() {
		return distanceFromParent;
	}
}
