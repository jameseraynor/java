package com.interviewprep.concepts;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Demonstrates the Java Collections Framework with practical examples
 * covering Lists, Sets, Maps, and Queues
 */
public class CollectionsExamples {
    
    // ==================== LISTS ====================
    
    /**
     * Demonstrates List interface implementations (ArrayList, LinkedList)
     */
    public void demonstrateLists() {
        System.out.println("\n📋 LIST INTERFACE EXAMPLES");
        System.out.println("=========================");
        
        // ArrayList - Dynamic array implementation
        System.out.println("\n--- ArrayList ---");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        arrayList.add(1, "Blueberry"); // Insert at specific index
        
        System.out.println("ArrayList: " + arrayList);
        System.out.println("Size: " + arrayList.size());
        System.out.println("Element at index 2: " + arrayList.get(2));
        System.out.println("Contains 'Banana': " + arrayList.contains("Banana"));
        
        // LinkedList - Doubly-linked list implementation
        System.out.println("\n--- LinkedList ---");
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.addFirst(5); // Add to beginning
        linkedList.addLast(15); // Add to end
        linkedList.add(20);
        
        System.out.println("LinkedList: " + linkedList);
        System.out.println("First element: " + linkedList.getFirst());
        System.out.println("Last element: " + linkedList.getLast());
        
        // Performance comparison
        System.out.println("\n--- Performance Comparison ---");
        long startTime = System.nanoTime();
        arrayList.add(0, "New Fruit"); // O(n) operation
        long arrayListTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        linkedList.addFirst(1); // O(1) operation
        long linkedListTime = System.nanoTime() - startTime;
        
        System.out.println("ArrayList add at beginning: " + arrayListTime + " ns");
        System.out.println("LinkedList add at beginning: " + linkedListTime + " ns");
    }
    
    // ==================== SETS ====================
    
    /**
     * Demonstrates Set interface implementations (HashSet, TreeSet)
     */
    public void demonstrateSets() {
        System.out.println("\n🔍 SET INTERFACE EXAMPLES");
        System.out.println("========================");
        
        // HashSet - Hash table implementation, no order guaranteed
        System.out.println("\n--- HashSet ---");
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Red");
        hashSet.add("Green");
        hashSet.add("Blue");
        hashSet.add("Red"); // Duplicate - will be ignored
        
        System.out.println("HashSet: " + hashSet);
        System.out.println("Size: " + hashSet.size());
        System.out.println("Contains 'Green': " + hashSet.contains("Green"));
        
        // TreeSet - Red-black tree implementation, sorted order
        System.out.println("\n--- TreeSet ---");
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(30);
        treeSet.add(10);
        treeSet.add(50);
        treeSet.add(20);
        
        System.out.println("TreeSet (sorted): " + treeSet);
        System.out.println("First element: " + treeSet.first());
        System.out.println("Last element: " + treeSet.last());
        System.out.println("Elements less than 25: " + treeSet.headSet(25));
        System.out.println("Elements greater than 15: " + treeSet.tailSet(15));
        
        // Set operations
        System.out.println("\n--- Set Operations ---");
        Set<String> set1 = new HashSet<>(Arrays.asList("A", "B", "C"));
        Set<String> set2 = new HashSet<>(Arrays.asList("B", "C", "D"));
        
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        
        // Union
        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union: " + union);
        
        // Intersection
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);
        
        // Difference
        Set<String> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Difference (set1 - set2): " + difference);
    }
    
    // ==================== MAPS ====================
    
    /**
     * Demonstrates Map interface implementations (HashMap, TreeMap)
     */
    public void demonstrateMaps() {
        System.out.println("\n🗺️  MAP INTERFACE EXAMPLES");
        System.out.println("=========================");
        
        // HashMap - Hash table implementation, no order guaranteed
        System.out.println("\n--- HashMap ---");
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Apple", 5);
        hashMap.put("Banana", 3);
        hashMap.put("Cherry", 8);
        hashMap.put("Apple", 6); // Overwrites previous value
        
        System.out.println("HashMap: " + hashMap);
        System.out.println("Apple count: " + hashMap.get("Apple"));
        System.out.println("Contains key 'Banana': " + hashMap.containsKey("Banana"));
        System.out.println("Contains value 8: " + hashMap.containsValue(8));
        
        // TreeMap - Red-black tree implementation, sorted by keys
        System.out.println("\n--- TreeMap ---");
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Zebra", 1);
        treeMap.put("Ant", 5);
        treeMap.put("Cat", 3);
        treeMap.put("Dog", 2);
        
        System.out.println("TreeMap (sorted by keys): " + treeMap);
        System.out.println("First key: " + treeMap.firstKey());
        System.out.println("Last key: " + treeMap.lastKey());
        System.out.println("Keys less than 'D': " + treeMap.headMap("D").keySet());
        
        // Map iteration
        System.out.println("\n--- Map Iteration ---");
        System.out.println("Iterating through HashMap:");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        // Using forEach (Java 8+)
        System.out.println("\nUsing forEach:");
        hashMap.forEach((key, value) -> 
            System.out.println(key + " -> " + value));
    }
    
    // ==================== QUEUES ====================
    
    /**
     * Demonstrates Queue interface implementations (PriorityQueue)
     */
    public void demonstrateQueues() {
        System.out.println("\n📊 QUEUE INTERFACE EXAMPLES");
        System.out.println("==========================");
        
        // PriorityQueue - Priority heap implementation
        System.out.println("\n--- PriorityQueue (Natural Order) ---");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(30);
        priorityQueue.offer(10);
        priorityQueue.offer(50);
        priorityQueue.offer(20);
        
        System.out.println("PriorityQueue: " + priorityQueue);
        System.out.println("Peek (highest priority): " + priorityQueue.peek());
        System.out.println("Poll (remove highest priority): " + priorityQueue.poll());
        System.out.println("After poll: " + priorityQueue);
        
        // PriorityQueue with custom comparator
        System.out.println("\n--- PriorityQueue (Custom Order) ---");
        PriorityQueue<String> stringQueue = new PriorityQueue<>(
            (s1, s2) -> s2.length() - s1.length() // Sort by length descending
        );
        stringQueue.offer("short");
        stringQueue.offer("very long string");
        stringQueue.offer("medium");
        stringQueue.offer("tiny");
        
        System.out.println("PriorityQueue (by length): " + stringQueue);
        while (!stringQueue.isEmpty()) {
            System.out.println("Processing: " + stringQueue.poll());
        }
        
        // LinkedList as Queue
        System.out.println("\n--- LinkedList as Queue ---");
        Queue<String> queue = new LinkedList<>();
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");
        
        System.out.println("Queue: " + queue);
        System.out.println("Peek: " + queue.peek());
        System.out.println("Poll: " + queue.poll());
        System.out.println("After poll: " + queue);
    }
    
    // ==================== COLLECTIONS UTILITY METHODS ====================
    
    /**
     * Demonstrates useful Collections utility methods
     */
    public void demonstrateCollectionsUtilities() {
        System.out.println("\n🛠️  COLLECTIONS UTILITY METHODS");
        System.out.println("=============================");
        
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6);
        System.out.println("Original list: " + numbers);
        
        // Sorting
        List<Integer> sortedList = new ArrayList<>(numbers);
        Collections.sort(sortedList);
        System.out.println("Sorted: " + sortedList);
        
        // Reverse sorting
        Collections.sort(sortedList, Collections.reverseOrder());
        System.out.println("Reverse sorted: " + sortedList);
        
        // Binary search (list must be sorted)
        Collections.sort(sortedList);
        int index = Collections.binarySearch(sortedList, 5);
        System.out.println("Index of 5: " + index);
        
        // Shuffle
        List<Integer> shuffledList = new ArrayList<>(numbers);
        Collections.shuffle(shuffledList);
        System.out.println("Shuffled: " + shuffledList);
        
        // Frequency
        int frequency = Collections.frequency(numbers, 1);
        System.out.println("Frequency of 1: " + frequency);
        
        // Min and Max
        System.out.println("Min: " + Collections.min(numbers));
        System.out.println("Max: " + Collections.max(numbers));
    }
    
    // ==================== STREAMS (JAVA 8+) ====================
    
    /**
     * Demonstrates Java 8+ Streams with Collections
     */
    public void demonstrateStreams() {
        System.out.println("\n🌊 STREAMS EXAMPLES");
        System.out.println("===================");
        
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry");
        
        // Filter
        List<String> longFruits = fruits.stream()
            .filter(fruit -> fruit.length() > 5)
            .collect(Collectors.toList());
        System.out.println("Fruits with length > 5: " + longFruits);
        
        // Map
        List<Integer> fruitLengths = fruits.stream()
            .map(String::length)
            .collect(Collectors.toList());
        System.out.println("Fruit lengths: " + fruitLengths);
        
        // Reduce
        int totalLength = fruits.stream()
            .mapToInt(String::length)
            .sum();
        System.out.println("Total length: " + totalLength);
        
        // Collect to different collection types
        Set<String> fruitSet = fruits.stream()
            .filter(fruit -> fruit.startsWith("A"))
            .collect(Collectors.toSet());
        System.out.println("Fruits starting with 'A': " + fruitSet);
        
        // Group by
        Map<Integer, List<String>> groupedByLength = fruits.stream()
            .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by length: " + groupedByLength);
    }
    
    public void runAllExamples() {
        demonstrateLists();
        demonstrateSets();
        demonstrateMaps();
        demonstrateQueues();
        demonstrateCollectionsUtilities();
        demonstrateStreams();
    }
} 