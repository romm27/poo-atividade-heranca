package kerbal;

public abstract class Simulation {
	enum GameState{Building, InSpace}
	
	static public CelestialBody currentCelestialBody;
	static public GameState gameState = GameState.Building;
}
