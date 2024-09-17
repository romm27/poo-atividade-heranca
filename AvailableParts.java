package kerbal;

public abstract class AvailableParts {
	public static CommandModule[] commandModules = new CommandModule[] {
		new CommandModule("Mk1-3 Command Pod", 
		"\n" + " / \\" + "\n" +
		"\n" + "|   |" + "\n" +
		"\n" + "L___|" + "\n"
		, 6.0, 3),
		new CommandModule("Mk1 Command Pod", "mk1pod",
		"\n" + " ___ " + "\n" +
		"\n" + "/  \\" + "\n" +
		"\n" + "_____" + "\n"
		,2.0, 1)
	};
	public static FuelTank[] fuelTanks = new FuelTank[] {
		new fuelTank("FL-T400 Fuel Tank",
		"\n" + " ___" + "\n" +
		"\n" + "| F |" + "\n" +
		"\n" + "L_T_|" + "\n"
		, 0.5, 450),
		new fuelTank("Oscar-B Fuel Tank",
		"\n" + "  -  " + "\n" +
		"\n" + " ( ) " + "\n" +
		"\n" + " ( ) " + "\n" +
		"\n" + "  -  " + "\n"
		, 0.1, 100),
	};
	public static Engine[] engines = new Engine[] {
		new Engine("LV-T30 Liquid Fuel Engine", 
		"\n" + "  ^  " + "\n" +
		"\n" + "/  \\" + "\n",
		1.0, 215),
		new Engine("LV-909 Liquid Fuel Engine",
		"\n" + "|| ||" + "\n" +
		"\n" + "^^ ^^" + "\n" +
		0.5, 50)
	};
}
