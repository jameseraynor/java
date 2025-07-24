package com.interviewprep;

import com.interviewprep.concepts.*;
import com.interviewprep.maven.MavenConcepts;
import com.interviewprep.quiz.QuizSystem;

import java.util.Scanner;

/**
 * Main application for Java Interview Preparation
 * This app covers core Java concepts and Maven topics commonly asked in interviews
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("🚀 Welcome to Java Interview Preparation App!");
        System.out.println("=============================================");
        
        while (true) {
            displayMainMenu();
            int choice = getValidChoice(scanner, 1, 6);
            
            switch (choice) {
                case 1:
                    exploreOOPConcepts(scanner);
                    break;
                case 2:
                    exploreCollectionsFramework(scanner);
                    break;
                case 3:
                    exploreExceptionHandling(scanner);
                    break;
                case 4:
                    exploreMultithreading(scanner);
                    break;
                case 5:
                    exploreMavenConcepts(scanner);
                    break;
                case 6:
                    startQuiz(scanner);
                    break;
                case 0:
                    System.out.println("👋 Thank you for using Java Interview Prep! Good luck with your interview!");
                    scanner.close();
                    return;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
            
            System.out.println("\n" + "=".repeat(50) + "\n");
        }
    }
    
    private static void displayMainMenu() {
        System.out.println("\n📚 Choose a topic to explore:");
        System.out.println("1. 🏗️  Object-Oriented Programming (OOP)");
        System.out.println("2. 📦 Collections Framework");
        System.out.println("3. ⚠️  Exception Handling");
        System.out.println("4. 🔄 Multithreading & Concurrency");
        System.out.println("5. 🛠️  Maven Concepts");
        System.out.println("6. 🧠 Take a Quiz");
        System.out.println("0. 🚪 Exit");
        System.out.print("\nEnter your choice: ");
    }
    
    private static void exploreOOPConcepts(Scanner scanner) {
        OOPConcepts oop = new OOPConcepts();
        
        System.out.println("\n🏗️  Object-Oriented Programming Concepts");
        System.out.println("=====================================");
        System.out.println("1. Encapsulation");
        System.out.println("2. Inheritance");
        System.out.println("3. Polymorphism");
        System.out.println("4. Abstraction");
        System.out.println("5. Run all examples");
        System.out.print("Choose a concept: ");
        
        int choice = getValidChoice(scanner, 1, 5);
        
        switch (choice) {
            case 1:
                oop.demonstrateEncapsulation();
                break;
            case 2:
                oop.demonstrateInheritance();
                break;
            case 3:
                oop.demonstratePolymorphism();
                break;
            case 4:
                oop.demonstrateAbstraction();
                break;
            case 5:
                oop.runAllExamples();
                break;
        }
    }
    
    private static void exploreCollectionsFramework(Scanner scanner) {
        CollectionsExamples collections = new CollectionsExamples();
        
        System.out.println("\n📦 Collections Framework");
        System.out.println("=======================");
        System.out.println("1. List Interface (ArrayList, LinkedList)");
        System.out.println("2. Set Interface (HashSet, TreeSet)");
        System.out.println("3. Map Interface (HashMap, TreeMap)");
        System.out.println("4. Queue Interface (PriorityQueue)");
        System.out.println("5. Run all examples");
        System.out.print("Choose a collection type: ");
        
        int choice = getValidChoice(scanner, 1, 5);
        
        switch (choice) {
            case 1:
                collections.demonstrateLists();
                break;
            case 2:
                collections.demonstrateSets();
                break;
            case 3:
                collections.demonstrateMaps();
                break;
            case 4:
                collections.demonstrateQueues();
                break;
            case 5:
                collections.runAllExamples();
                break;
        }
    }
    
    private static void exploreExceptionHandling(Scanner scanner) {
        ExceptionHandlingExamples exceptions = new ExceptionHandlingExamples();
        
        System.out.println("\n⚠️  Exception Handling");
        System.out.println("====================");
        System.out.println("1. Try-Catch Blocks");
        System.out.println("2. Multiple Catch Blocks");
        System.out.println("3. Finally Block");
        System.out.println("4. Custom Exceptions");
        System.out.println("5. Try-with-Resources");
        System.out.println("6. Run all examples");
        System.out.print("Choose an example: ");
        
        int choice = getValidChoice(scanner, 1, 6);
        
        switch (choice) {
            case 1:
                exceptions.demonstrateTryCatch();
                break;
            case 2:
                exceptions.demonstrateMultipleCatch();
                break;
            case 3:
                exceptions.demonstrateFinally();
                break;
            case 4:
                exceptions.demonstrateCustomExceptions();
                break;
            case 5:
                exceptions.demonstrateTryWithResources();
                break;
            case 6:
                exceptions.runAllExamples();
                break;
        }
    }
    
    private static void exploreMultithreading(Scanner scanner) {
        MultithreadingExamples multithreading = new MultithreadingExamples();
        
        System.out.println("\n🔄 Multithreading & Concurrency");
        System.out.println("=============================");
        System.out.println("1. Thread Creation (extends Thread)");
        System.out.println("2. Thread Creation (implements Runnable)");
        System.out.println("3. Thread Synchronization");
        System.out.println("4. Thread Communication (wait/notify)");
        System.out.println("5. ExecutorService");
        System.out.println("6. Run all examples");
        System.out.print("Choose an example: ");
        
        int choice = getValidChoice(scanner, 1, 6);
        
        switch (choice) {
            case 1:
                multithreading.demonstrateThreadExtends();
                break;
            case 2:
                multithreading.demonstrateThreadRunnable();
                break;
            case 3:
                multithreading.demonstrateSynchronization();
                break;
            case 4:
                multithreading.demonstrateThreadCommunication();
                break;
            case 5:
                multithreading.demonstrateExecutorService();
                break;
            case 6:
                multithreading.runAllExamples();
                break;
        }
    }
    
    private static void exploreMavenConcepts(Scanner scanner) {
        MavenConcepts maven = new MavenConcepts();
        
        System.out.println("\n🛠️  Maven Concepts");
        System.out.println("=================");
        System.out.println("1. POM Structure");
        System.out.println("2. Maven Lifecycle");
        System.out.println("3. Dependencies Management");
        System.out.println("4. Plugins");
        System.out.println("5. Run all examples");
        System.out.print("Choose a topic: ");
        
        int choice = getValidChoice(scanner, 1, 5);
        
        switch (choice) {
            case 1:
                maven.explainPOMStructure();
                break;
            case 2:
                maven.explainMavenLifecycle();
                break;
            case 3:
                maven.explainDependencies();
                break;
            case 4:
                maven.explainPlugins();
                break;
            case 5:
                maven.runAllExamples();
                break;
        }
    }
    
    private static void startQuiz(Scanner scanner) {
        QuizSystem quiz = new QuizSystem();
        quiz.startQuiz(scanner);
    }
    
    private static int getValidChoice(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.printf("❌ Please enter a number between %d and %d: ", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.printf("❌ Please enter a valid number between %d and %d: ", min, max);
            }
        }
    }
} 