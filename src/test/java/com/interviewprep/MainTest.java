package com.interviewprep;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Simple test class to demonstrate unit testing
 */
public class MainTest {
    
    @Test
    public void testMainClassExists() {
        // This test ensures the Main class can be instantiated
        assertDoesNotThrow(() -> {
            // Main class should exist and be accessible
            Class<?> mainClass = Class.forName("com.interviewprep.Main");
            assertNotNull(mainClass);
        });
    }
    
    @Test
    public void testMainMethodExists() {
        // This test ensures the main method exists
        assertDoesNotThrow(() -> {
            Class<?> mainClass = Class.forName("com.interviewprep.Main");
            mainClass.getMethod("main", String[].class);
        });
    }
} 