package Object_Oriented_Programming.Inheritance;


// Main class
public class RestaurantTest {

    public static void main(String[] args) {

        Worker chef = new Chef("Rahul", 30, 101);
        Worker waiter = new Waiter("Amit", 25, 102);

        chef.performDuties();
        waiter.performDuties();
    }
}

// Superclass
class EmployeeBase {
    String name;
    int age;

    EmployeeBase(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Interface
interface Worker {
    void performDuties();
}

// Chef class
class Chef extends EmployeeBase implements Worker {
    int id;

    Chef(String name, int age, int id) {
        super(name, age);
        this.id = id;
    }

    public void performDuties() {
        System.out.println("Chef " + name + " is cooking food.");
    }
}

// Waiter class
class Waiter extends EmployeeBase implements Worker {
    int id;

    Waiter(String name, int age, int id) {
        super(name, age);
        this.id = id;
    }

    public void performDuties() {
        System.out.println("Waiter " + name + " is serving customers.");
    }
}
