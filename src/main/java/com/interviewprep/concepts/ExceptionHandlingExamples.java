package com.interviewprep.concepts;

import java.io.*;
import java.util.Scanner;

/**
 * Demonstrates various exception handling techniques in Java
 */
public class ExceptionHandlingExamples {
    
    // ==================== TRY-CATCH BLOCKS ====================
    
    /**
     * Demonstrates basic try-catch exception handling
     */
    public void demonstrateTryCatch() {
        System.out.println("\n🛡️  TRY-CATCH BLOCKS");
        System.out.println("====================");
        
        // Basic try-catch
        try {
            int result = divideNumbers(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("❌ ArithmeticException caught: " + e.getMessage());
        }
        
        // Try-catch with multiple operations
        try {
            int[] numbers = {1, 2, 3, 4, 5};
            System.out.println("Accessing element at index 10: " + numbers[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌ ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        }
        
        // Try-catch with different exception types
        try {
            String text = null;
            System.out.println("Length of text: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("❌ NullPointerException caught: " + e.getMessage());
        }
    }
    
    // ==================== MULTIPLE CATCH BLOCKS ====================
    
    /**
     * Demonstrates multiple catch blocks for different exception types
     */
    public void demonstrateMultipleCatch() {
        System.out.println("\n🎯 MULTIPLE CATCH BLOCKS");
        System.out.println("=========================");
        
        // Multiple catch blocks
        try {
            String input = "abc";
            int number = Integer.parseInt(input);
            int result = 100 / number;
            System.out.println("Result: " + result);
        } catch (NumberFormatException e) {
            System.out.println("❌ NumberFormatException: Cannot parse string to number");
        } catch (ArithmeticException e) {
            System.out.println("❌ ArithmeticException: Division by zero");
        } catch (Exception e) {
            System.out.println("❌ General Exception: " + e.getMessage());
        }
        
        // Multiple catch blocks with specific order (most specific first)
        try {
            String[] array = {"one", "two", "three"};
            String element = array[5]; // This will throw ArrayIndexOutOfBoundsException
            int length = element.length();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌ ArrayIndexOutOfBoundsException: Index out of bounds");
        } catch (NullPointerException e) {
            System.out.println("❌ NullPointerException: Null reference");
        } catch (Exception e) {
            System.out.println("❌ General Exception: " + e.getMessage());
        }
    }
    
    // ==================== FINALLY BLOCK ====================
    
    /**
     * Demonstrates the finally block and its usage
     */
    public void demonstrateFinally() {
        System.out.println("\n🔒 FINALLY BLOCK");
        System.out.println("================");
        
        // Finally block always executes
        try {
            System.out.println("🔵 Inside try block");
            int result = divideNumbers(10, 2);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("❌ ArithmeticException: " + e.getMessage());
        } finally {
            System.out.println("🟢 Finally block always executes");
        }
        
        System.out.println();
        
        // Finally block executes even when exception occurs
        try {
            System.out.println("🔵 Inside try block");
            int result = divideNumbers(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("❌ ArithmeticException: " + e.getMessage());
        } finally {
            System.out.println("🟢 Finally block executes even after exception");
        }
        
        System.out.println();
        
        // Finally block with return statement
        System.out.println("Method result: " + demonstrateFinallyWithReturn());
    }
    
    // ==================== CUSTOM EXCEPTIONS ====================
    
    /**
     * Demonstrates custom exception creation and usage
     */
    public void demonstrateCustomExceptions() {
        System.out.println("\n🎨 CUSTOM EXCEPTIONS");
        System.out.println("===================");
        
        // Using custom exception
        try {
            validateAge(15);
        } catch (InvalidAgeException e) {
            System.out.println("❌ Custom Exception: " + e.getMessage());
        }
        
        try {
            validateAge(25);
            System.out.println("✅ Age is valid");
        } catch (InvalidAgeException e) {
            System.out.println("❌ Custom Exception: " + e.getMessage());
        }
        
        // Using custom exception with additional information
        try {
            validateEmail("invalid-email");
        } catch (InvalidEmailException e) {
            System.out.println("❌ Email Exception: " + e.getMessage());
            System.out.println("Invalid email: " + e.getInvalidEmail());
        }
    }
    
    // ==================== TRY-WITH-RESOURCES ====================
    
    /**
     * Demonstrates try-with-resources for automatic resource management
     */
    public void demonstrateTryWithResources() {
        System.out.println("\n📁 TRY-WITH-RESOURCES");
        System.out.println("====================");
        
        // Try-with-resources with FileReader
        try (FileReader reader = new FileReader("nonexistent.txt")) {
            System.out.println("Reading file...");
        } catch (FileNotFoundException e) {
            System.out.println("❌ FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("❌ IOException: " + e.getMessage());
        }
        
        // Try-with-resources with multiple resources
        try (FileReader reader = new FileReader("nonexistent.txt");
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            System.out.println("Reading with buffered reader...");
        } catch (FileNotFoundException e) {
            System.out.println("❌ FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("❌ IOException: " + e.getMessage());
        }
        
        // Custom resource with AutoCloseable
        try (CustomResource resource = new CustomResource()) {
            resource.doSomething();
        } catch (Exception e) {
            System.out.println("❌ Exception: " + e.getMessage());
        }
    }
    
    // ==================== EXCEPTION PROPAGATION ====================
    
    /**
     * Demonstrates exception propagation through method calls
     */
    public void demonstrateExceptionPropagation() {
        System.out.println("\n📤 EXCEPTION PROPAGATION");
        System.out.println("=======================");
        
        try {
            methodA();
        } catch (Exception e) {
            System.out.println("❌ Exception caught in main: " + e.getMessage());
            System.out.println("Stack trace:");
            e.printStackTrace();
        }
    }
    
    // ==================== SUPPORTING METHODS ====================
    
    private int divideNumbers(int a, int b) {
        return a / b; // This can throw ArithmeticException
    }
    
    private int demonstrateFinallyWithReturn() {
        try {
            System.out.println("🔵 Inside try block");
            return 42;
        } finally {
            System.out.println("🟢 Finally block executes before return");
        }
    }
    
    private void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older. Provided age: " + age);
        }
    }
    
    private void validateEmail(String email) throws InvalidEmailException {
        if (!email.contains("@")) {
            throw new InvalidEmailException("Invalid email format", email);
        }
    }
    
    private void methodA() throws Exception {
        System.out.println("Method A called");
        methodB();
    }
    
    private void methodB() throws Exception {
        System.out.println("Method B called");
        methodC();
    }
    
    private void methodC() throws Exception {
        System.out.println("Method C called");
        throw new Exception("Exception thrown in method C");
    }
    
    public void runAllExamples() {
        demonstrateTryCatch();
        demonstrateMultipleCatch();
        demonstrateFinally();
        demonstrateCustomExceptions();
        demonstrateTryWithResources();
        demonstrateExceptionPropagation();
    }
    
    // ==================== SUPPORTING CLASSES ====================
    
    /**
     * Custom exception for invalid age
     */
    public static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }
    
    /**
     * Custom exception for invalid email with additional data
     */
    public static class InvalidEmailException extends Exception {
        private final String invalidEmail;
        
        public InvalidEmailException(String message, String invalidEmail) {
            super(message);
            this.invalidEmail = invalidEmail;
        }
        
        public String getInvalidEmail() {
            return invalidEmail;
        }
    }
    
    /**
     * Custom resource that implements AutoCloseable
     */
    public static class CustomResource implements AutoCloseable {
        public void doSomething() {
            System.out.println("🔧 Custom resource doing something...");
        }
        
        @Override
        public void close() {
            System.out.println("🧹 Custom resource closing...");
        }
    }
} 