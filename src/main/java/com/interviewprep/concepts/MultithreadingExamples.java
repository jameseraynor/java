package com.interviewprep.concepts;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Demonstrates multithreading and concurrency concepts in Java
 */
public class MultithreadingExamples {
    
    // ==================== THREAD CREATION (EXTENDS THREAD) ====================
    
    /**
     * Demonstrates thread creation by extending Thread class
     */
    public void demonstrateThreadExtends() {
        System.out.println("\n🧵 THREAD CREATION (EXTENDS THREAD)");
        System.out.println("==================================");
        
        // Creating threads by extending Thread
        MyThread thread1 = new MyThread("Thread-1", 5);
        MyThread thread2 = new MyThread("Thread-2", 3);
        
        System.out.println("Starting threads...");
        thread1.start();
        thread2.start();
        
        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("❌ Main thread interrupted: " + e.getMessage());
        }
        
        System.out.println("All threads completed!");
    }
    
    // ==================== THREAD CREATION (IMPLEMENTS RUNNABLE) ====================
    
    /**
     * Demonstrates thread creation by implementing Runnable interface
     */
    public void demonstrateThreadRunnable() {
        System.out.println("\n🏃 THREAD CREATION (IMPLEMENTS RUNNABLE)");
        System.out.println("=======================================");
        
        // Creating threads by implementing Runnable
        MyRunnable runnable1 = new MyRunnable("Runnable-1", 4);
        MyRunnable runnable2 = new MyRunnable("Runnable-2", 6);
        
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        
        System.out.println("Starting threads...");
        thread1.start();
        thread2.start();
        
        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("❌ Main thread interrupted: " + e.getMessage());
        }
        
        System.out.println("All threads completed!");
    }
    
    // ==================== THREAD SYNCHRONIZATION ====================
    
    /**
     * Demonstrates thread synchronization using synchronized keyword and locks
     */
    public void demonstrateSynchronization() {
        System.out.println("\n🔒 THREAD SYNCHRONIZATION");
        System.out.println("========================");
        
        // Shared counter without synchronization
        System.out.println("--- Without Synchronization ---");
        Counter counter = new Counter();
        
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("❌ Thread interrupted: " + e.getMessage());
        }
        
        System.out.println("Final count (without sync): " + counter.getCount());
        
        // Shared counter with synchronization
        System.out.println("\n--- With Synchronization ---");
        SynchronizedCounter syncCounter = new SynchronizedCounter();
        
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                syncCounter.increment();
            }
        });
        
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                syncCounter.increment();
            }
        });
        
        thread3.start();
        thread4.start();
        
        try {
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            System.out.println("❌ Thread interrupted: " + e.getMessage());
        }
        
        System.out.println("Final count (with sync): " + syncCounter.getCount());
        
        // Using ReentrantLock
        System.out.println("\n--- Using ReentrantLock ---");
        LockCounter lockCounter = new LockCounter();
        
        Thread thread5 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                lockCounter.increment();
            }
        });
        
        Thread thread6 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                lockCounter.increment();
            }
        });
        
        thread5.start();
        thread6.start();
        
        try {
            thread5.join();
            thread6.join();
        } catch (InterruptedException e) {
            System.out.println("❌ Thread interrupted: " + e.getMessage());
        }
        
        System.out.println("Final count (with lock): " + lockCounter.getCount());
    }
    
    // ==================== THREAD COMMUNICATION (WAIT/NOTIFY) ====================
    
    /**
     * Demonstrates thread communication using wait/notify mechanism
     */
    public void demonstrateThreadCommunication() {
        System.out.println("\n💬 THREAD COMMUNICATION (WAIT/NOTIFY)");
        System.out.println("=====================================");
        
        Message message = new Message();
        
        // Producer thread
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                message.send("Message " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("❌ Producer interrupted: " + e.getMessage());
                }
            }
        });
        
        // Consumer thread
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                message.receive();
            }
        });
        
        System.out.println("Starting producer and consumer...");
        producer.start();
        consumer.start();
        
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            System.out.println("❌ Main thread interrupted: " + e.getMessage());
        }
        
        System.out.println("Producer-Consumer completed!");
    }
    
    // ==================== EXECUTOR SERVICE ====================
    
    /**
     * Demonstrates ExecutorService for thread pool management
     */
    public void demonstrateExecutorService() {
        System.out.println("\n🏊 EXECUTOR SERVICE");
        System.out.println("==================");
        
        // Fixed thread pool
        System.out.println("--- Fixed Thread Pool ---");
        ExecutorService fixedPool = Executors.newFixedThreadPool(3);
        
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            fixedPool.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("❌ Task interrupted: " + e.getMessage());
                }
            });
        }
        
        fixedPool.shutdown();
        try {
            if (!fixedPool.awaitTermination(10, TimeUnit.SECONDS)) {
                fixedPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            fixedPool.shutdownNow();
        }
        
        // Cached thread pool
        System.out.println("\n--- Cached Thread Pool ---");
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        
        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            cachedPool.submit(() -> {
                System.out.println("Cached task " + taskId + " executed by " + Thread.currentThread().getName());
            });
        }
        
        cachedPool.shutdown();
        
        // Scheduled executor
        System.out.println("\n--- Scheduled Executor ---");
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(2);
        
        // Schedule a task to run after 2 seconds
        scheduledPool.schedule(() -> {
            System.out.println("Scheduled task executed after 2 seconds");
        }, 2, TimeUnit.SECONDS);
        
        // Schedule a task to run every 1 second
        ScheduledFuture<?> periodicTask = scheduledPool.scheduleAtFixedRate(() -> {
            System.out.println("Periodic task executed at: " + System.currentTimeMillis());
        }, 0, 1, TimeUnit.SECONDS);
        
        // Stop the periodic task after 5 seconds
        scheduledPool.schedule(() -> {
            periodicTask.cancel(false);
            scheduledPool.shutdown();
        }, 5, TimeUnit.SECONDS);
    }
    
    // ==================== ATOMIC OPERATIONS ====================
    
    /**
     * Demonstrates atomic operations for thread-safe counters
     */
    public void demonstrateAtomicOperations() {
        System.out.println("\n⚛️  ATOMIC OPERATIONS");
        System.out.println("=====================");
        
        AtomicInteger atomicCounter = new AtomicInteger(0);
        
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomicCounter.incrementAndGet();
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomicCounter.incrementAndGet();
            }
        });
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("❌ Thread interrupted: " + e.getMessage());
        }
        
        System.out.println("Final atomic count: " + atomicCounter.get());
    }
    
    public void runAllExamples() {
        demonstrateThreadExtends();
        demonstrateThreadRunnable();
        demonstrateSynchronization();
        demonstrateThreadCommunication();
        demonstrateExecutorService();
        demonstrateAtomicOperations();
    }
    
    // ==================== SUPPORTING CLASSES ====================
    
    /**
     * Thread class that extends Thread
     */
    private static class MyThread extends Thread {
        private final String name;
        private final int count;
        
        public MyThread(String name, int count) {
            this.name = name;
            this.count = count;
        }
        
        @Override
        public void run() {
            for (int i = 1; i <= count; i++) {
                System.out.println(name + " - Count: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("❌ " + name + " interrupted: " + e.getMessage());
                    return;
                }
            }
            System.out.println(name + " completed!");
        }
    }
    
    /**
     * Runnable implementation
     */
    private static class MyRunnable implements Runnable {
        private final String name;
        private final int count;
        
        public MyRunnable(String name, int count) {
            this.name = name;
            this.count = count;
        }
        
        @Override
        public void run() {
            for (int i = 1; i <= count; i++) {
                System.out.println(name + " - Count: " + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println("❌ " + name + " interrupted: " + e.getMessage());
                    return;
                }
            }
            System.out.println(name + " completed!");
        }
    }
    
    /**
     * Counter without synchronization
     */
    private static class Counter {
        private int count = 0;
        
        public void increment() {
            count++;
        }
        
        public int getCount() {
            return count;
        }
    }
    
    /**
     * Counter with synchronization
     */
    private static class SynchronizedCounter {
        private int count = 0;
        
        public synchronized void increment() {
            count++;
        }
        
        public synchronized int getCount() {
            return count;
        }
    }
    
    /**
     * Counter with ReentrantLock
     */
    private static class LockCounter {
        private int count = 0;
        private final ReentrantLock lock = new ReentrantLock();
        
        public void increment() {
            lock.lock();
            try {
                count++;
            } finally {
                lock.unlock();
            }
        }
        
        public int getCount() {
            lock.lock();
            try {
                return count;
            } finally {
                lock.unlock();
            }
        }
    }
    
    /**
     * Message class for producer-consumer example
     */
    private static class Message {
        private String message;
        private boolean empty = true;
        
        public synchronized void send(String message) {
            while (!empty) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("❌ Send interrupted: " + e.getMessage());
                }
            }
            this.message = message;
            empty = false;
            notify();
        }
        
        public synchronized String receive() {
            while (empty) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("❌ Receive interrupted: " + e.getMessage());
                }
            }
            empty = true;
            notify();
            System.out.println("Received: " + message);
            return message;
        }
    }
} 