package kerbal;

public class PlanetarySystem {
	private CelestialBody[] celestialBodies; //0 - is parent

	public PlanetarySystem(String name, double diameter, double surfaceGravity, CelestialBody.BodyComposition composition, double distanceFromParent) {
		celestialBodies = new CelestialBody[1];
		celestialBodies[0] = new CelestialBody(name, diameter, surfaceGravity, composition, distanceFromParent);
	}

	public void addCelestialBody(String name, double diameter, double surfaceGravity, CelestialBody.BodyComposition composition, double distanceFromParent) {
		CelestialBody[] temp = new CelestialBody[celestialBodies.length + 1];
		for (int i = 0; i < celestialBodies.length; i++) {
			temp[i] = celestialBodies[i];
		}
		temp[celestialBodies.length] = new CelestialBody(name, diameter, surfaceGravity, composition, distanceFromParent);
		celestialBodies = temp;
	}
	
	public CelestialBody[] getBodies() {
		return celestialBodies;
	}

	public CelestialBody getBody(String name) {
		for (int i = 0; i < celestialBodies.length; i++) {
			if (celestialBodies[i].getName().equals(name)) {
				return celestialBodies[i];
			}
		}
		return null;
	}
	
	public CelestialBody getBody(int index) {
		return celestialBodies[index];
	}
}

