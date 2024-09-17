package kerbal;

public class Universe {
	private PlanetarySystem[] system;

	public Universe() {
		initialiseSystem();
	}

	//Methods
	void initialiseSystem() {
		system = new PlanetarySystem[8];

		//Initialise the first system
		system[0] = new PlanetarySystem("Kerbol", 1392000, 17.1, CelestialBody.BodyComposition.Plasma, 0, false);
		system[1] = new PlanetarySystem("Moho", 250, 2.7, CelestialBody.BodyComposition.Rocky, 400, false);
		system[2] = new PlanetarySystem("Eve", 700, 16.7, CelestialBody.BodyComposition.Rocky, 983, false);
		system[2].addCelestialBody("Gilly", 13, 0.049, CelestialBody.BodyComposition.Rocky, 49, false);
		system[3] = new PlanetarySystem("Kerbin", 600, 9.81, CelestialBody.BodyComposition.Rocky, 1159, true);
		system[3].addCelestialBody("Mun", 200, 1.63, CelestialBody.BodyComposition.Rocky, 23, false);
		system[3].addCelestialBody("Minmus", 60, 0.491, CelestialBody.BodyComposition.Rocky, 39, false);
		system[4] = new PlanetarySystem("Duna", 320, 2.94, CelestialBody.BodyComposition.Rocky, 1469, false);
		system[4].addCelestialBody("Ike", 130, 1.1, CelestialBody.BodyComposition.Rocky, 13, false);
		system[5] = new PlanetarySystem("Dres", 138, 1.13, CelestialBody.BodyComposition.Rocky, 1792, false);
		system[6] = new PlanetarySystem("Jool", 699, 7.85, CelestialBody.BodyComposition.Gaseous, 2125, false);
		system[6].addCelestialBody("Laythe", 500, 7.85, CelestialBody.BodyComposition.Rocky, 150, false);
		system[6].addCelestialBody("Vall", 300, 2.31, CelestialBody.BodyComposition.Rocky, 190, false);
		system[6].addCelestialBody("Tylo", 600, 7.85, CelestialBody.BodyComposition.Rocky, 235, false);
		system[6].addCelestialBody("Bop", 65, 0.6, CelestialBody.BodyComposition.Rocky, 289, false);
		system[6].addCelestialBody("Pol", 44, 0.373, CelestialBody.BodyComposition.Rocky, 311, false);
		system[7] = new PlanetarySystem("Eeloo", 210, 1.69, CelestialBody.BodyComposition.Rocky, 2987, false);
	}

	public double getDistanceFrom(CelestialBody body1, CelestialBody body2) {
		return Math.abs(body1.getDistanceFromParent() - body2.getDistanceFromParent());
	}

	public CelestialBody getCelestialBody(String name) {
		for(int i = 0; i < system.length; i++) {
			for(int j = 0; j < system[i].getBodies().length; j++) {
				if(system[i].getBody(j).getName().equals(name)) {
					return system[i].getBody(j);
				}
			}
		}
		return null;
	}

	public CelestialBody getCelestialBody(int systemIndex, int bodyIndex) {
		return system[systemIndex].getBody(bodyIndex);
	}

	public PlanetarySystem getSystem(String name) {
		for(int i = 0; i < system.length; i++) {
			if(system[i].getBody(name) != null) {
				return system[i];
			}
		}
		return null;
	}

	public PlanetarySystem getSystem(int index) {
		return system[index];
	}
}
