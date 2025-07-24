package com.interviewprep.concepts;

/**
 * Demonstrates the four pillars of Object-Oriented Programming:
 * 1. Encapsulation
 * 2. Inheritance
 * 3. Polymorphism
 * 4. Abstraction
 */
public class OOPConcepts {
    
    // ==================== ENCAPSULATION ====================
    
    /**
     * Encapsulation: Bundling data and methods that operate on that data within a single unit (class)
     * and hiding internal state and requiring all interaction to be performed through an object's methods.
     */
    public void demonstrateEncapsulation() {
        System.out.println("\n🔒 ENCAPSULATION EXAMPLE");
        System.out.println("=======================");
        System.out.println("Encapsulation bundles data and methods together and hides internal state.");
        
        BankAccount account = new BankAccount("John Doe", 1000.0);
        
        System.out.println("Account holder: " + account.getAccountHolder());
        System.out.println("Initial balance: $" + account.getBalance());
        
        // Trying to access private field directly would cause compilation error
        // account.balance = -5000; // This would not compile!
        
        account.deposit(500);
        System.out.println("After deposit: $" + account.getBalance());
        
        account.withdraw(200);
        System.out.println("After withdrawal: $" + account.getBalance());
        
        // Validation prevents invalid operations
        account.withdraw(2000); // This will be rejected
        System.out.println("After invalid withdrawal: $" + account.getBalance());
    }
    
    // ==================== INHERITANCE ====================
    
    /**
     * Inheritance: Mechanism that allows a class to inherit properties and methods from another class.
     */
    public void demonstrateInheritance() {
        System.out.println("\n👨‍👩‍👧‍👦 INHERITANCE EXAMPLE");
        System.out.println("=========================");
        System.out.println("Inheritance allows a class to inherit properties and methods from another class.");
        
        // Creating instances of different animal types
        Animal genericAnimal = new Animal("Generic Animal", 5);
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        Cat cat = new Cat("Whiskers", 2, "Persian");
        
        System.out.println("\n--- Generic Animal ---");
        genericAnimal.makeSound();
        genericAnimal.displayInfo();
        
        System.out.println("\n--- Dog (inherits from Animal) ---");
        dog.makeSound(); // Overridden method
        dog.displayInfo(); // Inherited method
        dog.fetch(); // Dog-specific method
        
        System.out.println("\n--- Cat (inherits from Animal) ---");
        cat.makeSound(); // Overridden method
        cat.displayInfo(); // Inherited method
        cat.purr(); // Cat-specific method
    }
    
    // ==================== POLYMORPHISM ====================
    
    /**
     * Polymorphism: Ability to present the same interface for different underlying forms (data types or classes).
     */
    public void demonstratePolymorphism() {
        System.out.println("\n🔄 POLYMORPHISM EXAMPLE");
        System.out.println("=======================");
        System.out.println("Polymorphism allows objects of different types to be treated as objects of a common super type.");
        
        // Polymorphic array - all elements are Animal type but can hold different subclasses
        Animal[] animals = {
            new Animal("Generic Animal", 1),
            new Dog("Rex", 4, "German Shepherd"),
            new Cat("Mittens", 3, "Siamese"),
            new Dog("Max", 2, "Labrador")
        };
        
        System.out.println("Processing animals polymorphically:");
        for (Animal animal : animals) {
            animal.makeSound(); // Each animal makes its own sound
        }
        
        // Method overloading example
        Calculator calculator = new Calculator();
        System.out.println("\n--- Method Overloading ---");
        System.out.println("add(5, 3) = " + calculator.add(5, 3));
        System.out.println("add(5.5, 3.2) = " + calculator.add(5.5, 3.2));
        System.out.println("add(5, 3, 2) = " + calculator.add(5, 3, 2));
    }
    
    // ==================== ABSTRACTION ====================
    
    /**
     * Abstraction: Hiding complex implementation details and showing only necessary features.
     */
    public void demonstrateAbstraction() {
        System.out.println("\n🎭 ABSTRACTION EXAMPLE");
        System.out.println("======================");
        System.out.println("Abstraction hides complex implementation details and shows only necessary features.");
        
        // Using abstract class
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        
        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("Circle perimeter: " + circle.calculatePerimeter());
        circle.displayInfo();
        
        System.out.println("\nRectangle area: " + rectangle.calculateArea());
        System.out.println("Rectangle perimeter: " + rectangle.calculatePerimeter());
        rectangle.displayInfo();
        
        // Using interface
        Vehicle car = new Car();
        Vehicle motorcycle = new Motorcycle();
        
        System.out.println("\n--- Vehicle Interface ---");
        car.start();
        car.stop();
        car.getInfo();
        
        System.out.println();
        motorcycle.start();
        motorcycle.stop();
        motorcycle.getInfo();
    }
    
    public void runAllExamples() {
        demonstrateEncapsulation();
        demonstrateInheritance();
        demonstratePolymorphism();
        demonstrateAbstraction();
    }
    
    // ==================== SUPPORTING CLASSES ====================
    
    // Encapsulation Example
    private static class BankAccount {
        private String accountHolder;
        private double balance;
        
        public BankAccount(String accountHolder, double initialBalance) {
            this.accountHolder = accountHolder;
            this.balance = initialBalance;
        }
        
        public String getAccountHolder() {
            return accountHolder;
        }
        
        public double getBalance() {
            return balance;
        }
        
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: $" + amount);
            } else {
                System.out.println("Invalid deposit amount");
            }
        }
        
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn: $" + amount);
            } else {
                System.out.println("Invalid withdrawal amount or insufficient funds");
            }
        }
    }
    
    // Inheritance Example
    private static class Animal {
        protected String name;
        protected int age;
        
        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        public void makeSound() {
            System.out.println(name + " makes a generic sound");
        }
        
        public void displayInfo() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }
    
    private static class Dog extends Animal {
        private String breed;
        
        public Dog(String name, int age, String breed) {
            super(name, age); // Call parent constructor
            this.breed = breed;
        }
        
        @Override
        public void makeSound() {
            System.out.println(name + " barks: Woof! Woof!");
        }
        
        public void fetch() {
            System.out.println(name + " fetches the ball");
        }
        
        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Breed: " + breed);
        }
    }
    
    private static class Cat extends Animal {
        private String breed;
        
        public Cat(String name, int age, String breed) {
            super(name, age);
            this.breed = breed;
        }
        
        @Override
        public void makeSound() {
            System.out.println(name + " meows: Meow!");
        }
        
        public void purr() {
            System.out.println(name + " purrs contentedly");
        }
        
        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Breed: " + breed);
        }
    }
    
    // Polymorphism Example - Method Overloading
    private static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }
        
        public double add(double a, double b) {
            return a + b;
        }
        
        public int add(int a, int b, int c) {
            return a + b + c;
        }
    }
    
    // Abstraction Example - Abstract Class
    private static abstract class Shape {
        protected String name;
        
        public Shape(String name) {
            this.name = name;
        }
        
        public abstract double calculateArea();
        public abstract double calculatePerimeter();
        
        public void displayInfo() {
            System.out.println("Shape: " + name);
            System.out.println("Area: " + calculateArea());
            System.out.println("Perimeter: " + calculatePerimeter());
        }
    }
    
    private static class Circle extends Shape {
        private double radius;
        
        public Circle(double radius) {
            super("Circle");
            this.radius = radius;
        }
        
        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }
        
        @Override
        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }
    }
    
    private static class Rectangle extends Shape {
        private double length;
        private double width;
        
        public Rectangle(double length, double width) {
            super("Rectangle");
            this.length = length;
            this.width = width;
        }
        
        @Override
        public double calculateArea() {
            return length * width;
        }
        
        @Override
        public double calculatePerimeter() {
            return 2 * (length + width);
        }
    }
    
    // Abstraction Example - Interface
    private static interface Vehicle {
        void start();
        void stop();
        void getInfo();
    }
    
    private static class Car implements Vehicle {
        @Override
        public void start() {
            System.out.println("Car engine starts with a roar");
        }
        
        @Override
        public void stop() {
            System.out.println("Car engine stops smoothly");
        }
        
        @Override
        public void getInfo() {
            System.out.println("This is a car - 4 wheels, enclosed cabin");
        }
    }
    
    private static class Motorcycle implements Vehicle {
        @Override
        public void start() {
            System.out.println("Motorcycle engine starts with a vroom");
        }
        
        @Override
        public void stop() {
            System.out.println("Motorcycle engine stops");
        }
        
        @Override
        public void getInfo() {
            System.out.println("This is a motorcycle - 2 wheels, open design");
        }
    }
} 