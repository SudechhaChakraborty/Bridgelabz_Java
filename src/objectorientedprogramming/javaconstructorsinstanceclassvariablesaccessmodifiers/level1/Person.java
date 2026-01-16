package Object_Oriented_Programming.Java_Constructors_Instance_ClassVariables_AccessModifiers.Level1;
/*
Create a Person class with a copy constructor that clones another person's attributes.
 */

import java.util.Scanner;

class Person {

    String name;
    int age;

    Person(String n, int a) {
        name = n;
        age = a;
    }

    Person(Person p) {
        name = p.name;
        age = p.age;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age : " + age);
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        Person p1 = new Person(name, age);

        Person p2 = new Person(p1);

        System.out.println("\nOriginal Person:");
        p1.display();

        System.out.println("Copied Person:");
        p2.display();

        sc.close();
    }
}

