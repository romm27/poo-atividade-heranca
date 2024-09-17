package kerbal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        Universe universe = new Universe();

        Ship ship = new Ship("Ship", new Part[0]);
        
        Simulation.currentCelestialBody = universe.getCelestialBody("Kerbin");
        
        System.out.println("Welcome to Java Space Program!");
        
        //Building Craft
        
        System.out.println("This project is a small slice from Kerbal Space Program represented inside Java.");
        System.out.println("To get started please build your rocket.");
        
        //Ship builder variables
        boolean building = true;
        boolean hasCommandModule = false;

        //Ship builder methods
        private void BuilderMenu(){
            
        }

        while(building) {
        	System.out.println("Ship Builder:");
            System.out.println(ship.getShipGraphics());
        }
        
        
        boolean running = true;
        while(running) {
        	
        }
        
        scanner.close();
    }
    
    //Methods
    private void PrintActionMenu(Scanner scanner) {
    	
    }
}
