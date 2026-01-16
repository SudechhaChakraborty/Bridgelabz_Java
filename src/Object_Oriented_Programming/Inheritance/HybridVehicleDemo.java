package Object_Oriented_Programming.Inheritance;

public class HybridVehicleDemo {

    public static void main(String[] args) {

        TransportUnit ev = new ElectricVehicle(150, "Tesla Model 3");
        TransportUnit pv = new PetrolVehicle(180, "Honda City");

        System.out.println("Electric Vehicle:");
        ev.displayInfo();
        ((ElectricVehicle) ev).charge();

        System.out.println();

        System.out.println("Petrol Vehicle:");
        pv.displayInfo();
        ((PetrolVehicle) pv).refuel();
    }
}

// Superclass
class TransportUnit {
    int maxSpeed;
    String model;

    TransportUnit(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface
interface Refuelable {
    void refuel();
}

// ElectricVehicle subclass
class ElectricVehicle extends TransportUnit {

    ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    void charge() {
        System.out.println("Electric vehicle is charging.");
    }
}

// PetrolVehicle subclass (Hybrid inheritance)
class PetrolVehicle extends TransportUnit implements Refuelable {

    PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void refuel() {
        System.out.println("Petrol vehicle is being refueled.");
    }
}
