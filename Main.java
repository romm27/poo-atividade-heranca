package kerbal;

import java.util.Scanner;

import kerbal.Simulation.GameState;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Universe universe = new Universe();
        universe.initialiseSystem();

        Ship ship = new Ship("Ship", new Part[0]);

        Simulation.currentCelestialBody = universe.getCelestialBody("Kerbin");

        System.out.println("Welcome to Java Space Program!");

        // Building Craft

        System.out.println("This project is a small slice from Kerbal Space Program represented inside Java.");
        System.out.println("To get started please build your rocket.");

        // Ship builder variables
        boolean building = true;
        boolean hasCommandModule = false;

        while (building) {
            System.out.println("Ship Builder:");

            if (!hasCommandModule) {
                for (int i = 0; i < AvailableParts.commandModules.length; i++) {
                    System.out.println(i + ". " + AvailableParts.commandModules[i].getName());
                }
                int commandModuleChoice = scanner.nextInt();
                ship.addPart(AvailableParts.commandModules[commandModuleChoice]);
                hasCommandModule = true;
                System.out.println(AvailableParts.commandModules[commandModuleChoice].getName() + " added.");
            }

            System.out.println(ship.getShipGraphics());
            building = printBuilderMenu(scanner, ship);
        }

        boolean running = true;
        while (running) {
            printShipStats(ship);
            printCurrentSimulationStatus(ship);
            // Local Variables
            int choice = 0;
            int localGravity = Simulation.currentCelestialBody.getSurfaceGravity();

            System.out.println("Actions:");

            switch (Simulation.gameState) {
                case Simulation.GameState.Landed:
                    System.out.println("1. Launch");
                    System.out.println("2. Plant Flag");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                        	if(Simulation.currentCelestialBody.getComposition() == CelestialBody.BodyComposition.Gaseous) {
                        		System.out.println("It is not possible to land on a gas giant.");
                        		break;
                        	}
                            if (localGravity <= ship.getDeltaV()) {
                                Simulation.gameState = GameState.Orbiting;
                                ship.modifyDeltaV(-localGravity);
                            } else {
                                printNoFuelWarning();
                            }
                        	break;
                        case 2:

                            break;
                        default:
                        	return;
                    }

                    break;
                case Simulation.GameState.Orbiting:
                    System.out.println("1. Land");
                    System.out.println("2. Local Transfer");
                    System.out.println("3. Interplanetary Transfer");

                    switch (choice) {
                        case 1:
                            if (localGravity <= ship.getDeltaV()) {
                                Simulation.gameState = GameState.Landed;
                                ship.modifyDeltaV(-localGravity);
                            } else {
                                printNoFuelWarning();
                            }
                            break;
                        case 2:

                            break;
                        case 3:

                            break;
                        default:
                        	return;
                    }
                    break;
            }

            scanner.close();
        }

    }

    // Ship builder methods
    private static boolean printBuilderMenu(Scanner scanner, Ship ship) {
        System.out.println("1. Add Fuel Tank");
        System.out.println("2. Add Engine(Launch)");
        System.out.println("3. Exit");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                for (int i = 0; i < AvailableParts.fuelTanks.length; i++) {
                    System.out.println(i + ". " + AvailableParts.fuelTanks[i].getName());
                }
                int fuelTankChoice = scanner.nextInt();
                ship.addPart(AvailableParts.fuelTanks[fuelTankChoice]);
                System.out.println(AvailableParts.fuelTanks[fuelTankChoice].getName() + " added.");
                return true;
            case 2:
                for (int i = 0; i < AvailableParts.engines.length; i++) {
                    System.out.println(i + ". " + AvailableParts.engines[i].getName());
                }
                int engineChoice = scanner.nextInt();
                ship.addPart(AvailableParts.engines[engineChoice]);
                System.out.println(AvailableParts.engines[engineChoice].getName() + " added.");
                return false;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");
                return true;
        }
        return false;
    }

    private static void printShipStats(Ship ship) {
        System.out.println("Ship Stats:");
        System.out.println("Delta V: " + ship.getDeltaV());
        System.out.printf("Thrust: %.0f \n", ship.getShipThrust());
    }

    private static void printCurrentSimulationStatus(Ship ship) {
        System.out.println(
                "Currently " + Simulation.gameState.toString() + " in " + Simulation.currentCelestialBody.getName());
    }

    private static void printNoFuelWarning() {
        System.out.println("Not enough Delta-V!");
        System.out.println("P.S: This basically means you don't have enough fuel for this action.");
    }
}
