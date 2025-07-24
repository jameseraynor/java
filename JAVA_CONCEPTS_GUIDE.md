# Java Interview Concepts Guide 📚

A comprehensive guide covering all Java and Maven concepts commonly asked in technical interviews.

## Table of Contents
- [Object-Oriented Programming (OOP)](#object-oriented-programming-oop)
- [Collections Framework](#collections-framework)
- [Exception Handling](#exception-handling)
- [Multithreading & Concurrency](#multithreading--concurrency)
- [Maven Concepts](#maven-concepts)
- [Java Fundamentals](#java-fundamentals)

---

## Object-Oriented Programming (OOP) 🏗️

### 1. Encapsulation 🔒

**Definition:** Bundling data and methods that operate on that data within a single unit (class) and hiding internal state.

**Key Concepts:**
- Data hiding through private fields
- Public methods for controlled access
- Validation and business logic in methods

**Example:**
```java
public class BankAccount {
    private String accountHolder;
    private double balance;
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}
```

**Interview Questions:**
- What is encapsulation and why is it important?
- How do you achieve encapsulation in Java?
- What are the benefits of encapsulation?

### 2. Inheritance 👨‍👩‍👧‍👦

**Definition:** Mechanism that allows a class to inherit properties and methods from another class.

**Key Concepts:**
- `extends` keyword for class inheritance
- `super()` to call parent constructor
- Method overriding with `@Override`
- Single inheritance (one parent class)

**Example:**
```java
public class Animal {
    protected String name;
    protected int age;
    
    public void makeSound() {
        System.out.println("Generic sound");
    }
}

public class Dog extends Animal {
    private String breed;
    
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}
```

**Interview Questions:**
- What is inheritance and how does it work in Java?
- What is the difference between inheritance and composition?
- Can you inherit from multiple classes in Java?
- What is method overriding vs method overloading?

### 3. Polymorphism 🔄

**Definition:** Ability to present the same interface for different underlying forms (data types or classes).

**Types:**
1. **Compile-time Polymorphism (Method Overloading)**
2. **Runtime Polymorphism (Method Overriding)**

**Example:**
```java
// Method Overloading
public class Calculator {
    public int add(int a, int b) { return a + b; }
    public double add(double a, double b) { return a + b; }
    public int add(int a, int b, int c) { return a + b + c; }
}

// Method Overriding
Animal[] animals = {new Dog(), new Cat(), new Bird()};
for (Animal animal : animals) {
    animal.makeSound(); // Each makes its own sound
}
```

**Interview Questions:**
- What is polymorphism and its types?
- What is the difference between overloading and overriding?
- How is polymorphism implemented in Java?

### 4. Abstraction 🎭

**Definition:** Hiding complex implementation details and showing only necessary features.

**Implementation:**
- Abstract classes
- Interfaces
- Abstract methods

**Example:**
```java
// Abstract Class
public abstract class Shape {
    protected String name;
    
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    
    public void displayInfo() {
        System.out.println("Shape: " + name);
    }
}

// Interface
public interface Vehicle {
    void start();
    void stop();
    void getInfo();
}
```

**Interview Questions:**
- What is abstraction and how is it different from encapsulation?
- When would you use an abstract class vs an interface?
- Can you have abstract methods in a non-abstract class?

---

## Collections Framework 📦

### 1. List Interface 📋

**Implementations:**
- **ArrayList**: Dynamic array, fast random access
- **LinkedList**: Doubly-linked list, fast insertions/deletions

**Key Differences:**
| Operation | ArrayList | LinkedList |
|-----------|-----------|------------|
| Get/Set | O(1) | O(n) |
| Add/Remove (end) | O(1) amortized | O(1) |
| Add/Remove (beginning) | O(n) | O(1) |

**Example:**
```java
List<String> arrayList = new ArrayList<>();
arrayList.add("Apple");
arrayList.add(1, "Banana");

List<Integer> linkedList = new LinkedList<>();
linkedList.addFirst(10);
linkedList.addLast(20);
```

### 2. Set Interface 🔍

**Implementations:**
- **HashSet**: Hash table, no order, O(1) operations
- **TreeSet**: Red-black tree, sorted order, O(log n) operations

**Example:**
```java
Set<String> hashSet = new HashSet<>();
hashSet.add("Red");
hashSet.add("Green");
hashSet.add("Red"); // Duplicate ignored

Set<Integer> treeSet = new TreeSet<>();
treeSet.add(30);
treeSet.add(10);
treeSet.add(50); // Automatically sorted
```

### 3. Map Interface 🗺️

**Implementations:**
- **HashMap**: Hash table, no order, O(1) operations
- **TreeMap**: Red-black tree, sorted by keys, O(log n) operations

**Example:**
```java
Map<String, Integer> hashMap = new HashMap<>();
hashMap.put("Apple", 5);
hashMap.put("Banana", 3);
hashMap.put("Apple", 6); // Overwrites previous value

Map<String, Integer> treeMap = new TreeMap<>();
treeMap.put("Zebra", 1);
treeMap.put("Ant", 5); // Automatically sorted by keys
```

### 4. Queue Interface 📊

**Implementations:**
- **PriorityQueue**: Priority heap, O(log n) operations
- **LinkedList**: Can be used as queue

**Example:**
```java
Queue<Integer> priorityQueue = new PriorityQueue<>();
priorityQueue.offer(30);
priorityQueue.offer(10);
priorityQueue.offer(50);
// Processes in order: 10, 30, 50

// Custom comparator
PriorityQueue<String> stringQueue = new PriorityQueue<>(
    (s1, s2) -> s2.length() - s1.length() // Longest first
);
```

### 5. Collections Utility Methods 🛠️

**Common Methods:**
```java
Collections.sort(list);
Collections.reverse(list);
Collections.shuffle(list);
Collections.binarySearch(list, key); // List must be sorted
Collections.frequency(list, element);
Collections.min(list);
Collections.max(list);
```

### 6. Streams API (Java 8+) 🌊

**Key Operations:**
```java
List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");

// Filter
List<String> longFruits = fruits.stream()
    .filter(fruit -> fruit.length() > 5)
    .collect(Collectors.toList());

// Map
List<Integer> lengths = fruits.stream()
    .map(String::length)
    .collect(Collectors.toList());

// Reduce
int totalLength = fruits.stream()
    .mapToInt(String::length)
    .sum();

// Group by
Map<Integer, List<String>> grouped = fruits.stream()
    .collect(Collectors.groupingBy(String::length));
```

---

## Exception Handling ⚠️

### 1. Exception Hierarchy

```
Throwable
├── Error (unchecked)
│   ├── OutOfMemoryError
│   ├── StackOverflowError
│   └── ...
└── Exception
    ├── RuntimeException (unchecked)
    │   ├── NullPointerException
    │   ├── ArrayIndexOutOfBoundsException
    │   ├── ClassCastException
    │   └── ...
    └── Checked Exceptions
        ├── IOException
        ├── SQLException
        └── ...
```

### 2. Try-Catch Blocks 🛡️

**Basic Structure:**
```java
try {
    // Code that might throw exception
    int result = 10 / 0;
} catch (ArithmeticException e) {
    // Handle specific exception
    System.out.println("Division by zero: " + e.getMessage());
} catch (Exception e) {
    // Handle any other exception
    System.out.println("General exception: " + e.getMessage());
}
```

### 3. Multiple Catch Blocks 🎯

**Order Matters:**
```java
try {
    // Code that might throw multiple exceptions
} catch (SpecificException e) {
    // Handle specific exception first
} catch (GeneralException e) {
    // Handle general exception last
}
```

### 4. Finally Block 🔒

**Always Executes:**
```java
try {
    // Code that might throw exception
    return 42;
} catch (Exception e) {
    // Handle exception
} finally {
    // Always executes, even after return
    System.out.println("Cleanup code");
}
```

### 5. Try-with-Resources 📁

**Automatic Resource Management:**
```java
try (FileReader reader = new FileReader("file.txt");
     BufferedReader bufferedReader = new BufferedReader(reader)) {
    // Use resources
    String line = bufferedReader.readLine();
} catch (IOException e) {
    // Handle exception
}
// Resources automatically closed
```

### 6. Custom Exceptions 🎨

**Creating Custom Exceptions:**
```java
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class InvalidEmailException extends Exception {
    private final String invalidEmail;
    
    public InvalidEmailException(String message, String invalidEmail) {
        super(message);
        this.invalidEmail = invalidEmail;
    }
    
    public String getInvalidEmail() {
        return invalidEmail;
    }
}
```

### 7. Exception Propagation 📤

**How Exceptions Flow:**
```java
public void methodA() throws Exception {
    methodB();
}

public void methodB() throws Exception {
    methodC();
}

public void methodC() throws Exception {
    throw new Exception("Exception thrown in method C");
}
```

---

## Multithreading & Concurrency 🔄

### 1. Thread Creation 🧵

**Method 1: Extending Thread**
```java
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread: " + i);
        }
    }
}

MyThread thread = new MyThread();
thread.start();
```

**Method 2: Implementing Runnable**
```java
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Runnable: " + i);
        }
    }
}

Thread thread = new Thread(new MyRunnable());
thread.start();
```

**Method 3: Lambda Expression (Java 8+)**
```java
Thread thread = new Thread(() -> {
    for (int i = 1; i <= 5; i++) {
        System.out.println("Lambda: " + i);
    }
});
thread.start();
```

### 2. Thread Lifecycle

```
New → Runnable → Running → Blocked/Waiting → Terminated
```

### 3. Thread Synchronization 🔒

**Synchronized Method:**
```java
public class Counter {
    private int count = 0;
    
    public synchronized void increment() {
        count++;
    }
    
    public synchronized int getCount() {
        return count;
    }
}
```

**Synchronized Block:**
```java
public void increment() {
    synchronized (this) {
        count++;
    }
}
```

**ReentrantLock:**
```java
public class LockCounter {
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
}
```

### 4. Thread Communication 💬

**Wait/Notify Mechanism:**
```java
public class Message {
    private String message;
    private boolean empty = true;
    
    public synchronized void send(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                // Handle interruption
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
                // Handle interruption
            }
        }
        empty = true;
        notify();
        return message;
    }
}
```

### 5. ExecutorService 🏊

**Thread Pool Management:**
```java
// Fixed thread pool
ExecutorService fixedPool = Executors.newFixedThreadPool(3);

// Cached thread pool
ExecutorService cachedPool = Executors.newCachedThreadPool();

// Scheduled executor
ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(2);

// Submit tasks
for (int i = 1; i <= 5; i++) {
    final int taskId = i;
    fixedPool.submit(() -> {
        System.out.println("Task " + taskId + " executed by " + 
                          Thread.currentThread().getName());
    });
}

// Shutdown
fixedPool.shutdown();
```

### 6. Atomic Operations ⚛️

**Thread-Safe Counters:**
```java
AtomicInteger atomicCounter = new AtomicInteger(0);
AtomicLong atomicLong = new AtomicLong(0);
AtomicReference<String> atomicString = new AtomicReference<>("");

// Atomic operations
atomicCounter.incrementAndGet();
atomicCounter.addAndGet(5);
atomicCounter.compareAndSet(5, 10);
```

### 7. Concurrent Collections

**Thread-Safe Collections:**
```java
// Thread-safe lists
List<String> copyOnWriteList = new CopyOnWriteArrayList<>();
List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());

// Thread-safe maps
Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
Map<String, Integer> synchronizedMap = Collections.synchronizedMap(new HashMap<>());

// Thread-safe queues
BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(100);
BlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();
```

---

## Maven Concepts 🛠️

### 1. POM (Project Object Model) 📋

**Basic Structure:**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
    <groupId>com.example</groupId>
    <artifactId>my-project</artifactId>
    <version>1.0.0</version>
    <packaging>jar</packaging>
    
    <name>My Project</name>
    <description>Project description</description>
    
    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    
    <dependencies>
        <!-- Dependencies here -->
    </dependencies>
    
    <build>
        <plugins>
            <!-- Plugins here -->
        </plugins>
    </build>
</project>
```

### 2. Maven Lifecycle 🔄

**Default Lifecycle:**
1. **validate** - Validate project is correct
2. **compile** - Compile source code
3. **test** - Run tests
4. **package** - Package compiled code
5. **verify** - Run integration tests
6. **install** - Install package to local repository
7. **deploy** - Deploy package to remote repository

**Clean Lifecycle:**
- **clean** - Remove target directory

**Site Lifecycle:**
- **site** - Generate project documentation
- **site-deploy** - Deploy site to server

### 3. Dependencies Management 📚

**Dependency Scopes:**
- **compile** (default) - Available in all classpaths
- **provided** - Provided by JDK or container
- **runtime** - Required at runtime, not compile time
- **test** - Only for testing
- **system** - Similar to provided, but specify JAR explicitly
- **import** - Only used in dependencyManagement

**Example:**
```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.8.2</version>
        <scope>test</scope>
    </dependency>
    
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.13.3</version>
    </dependency>
</dependencies>
```

**Dependency Management:**
```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>5.3.20</version>
        </dependency>
    </dependencies>
</dependencyManagement>
```

### 4. Maven Plugins 🔌

**Build Plugins:**
- **maven-compiler-plugin** - Compile Java source code
- **maven-surefire-plugin** - Run unit tests
- **maven-jar-plugin** - Create JAR files
- **maven-war-plugin** - Create WAR files
- **maven-assembly-plugin** - Create executable JARs
- **maven-shade-plugin** - Create uber JARs

**Reporting Plugins:**
- **maven-javadoc-plugin** - Generate JavaDoc
- **maven-site-plugin** - Generate project site
- **maven-surefire-report-plugin** - Generate test reports
- **maven-dependency-plugin** - Analyze dependencies

**Plugin Configuration:**
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.10.1</version>
    <configuration>
        <source>11</source>
        <target>11</target>
    </configuration>
</plugin>
```

### 5. Maven Profiles 🎭

**Profile Types:**
- **Per Project** - Defined in POM
- **Per User** - Defined in settings.xml
- **Global** - Defined in global settings.xml

**Profile Example:**
```xml
<profiles>
    <profile>
        <id>development</id>
        <properties>
            <db.url>jdbc:h2:mem:testdb</db.url>
        </properties>
    </profile>
    <profile>
        <id>production</id>
        <properties>
            <db.url>jdbc:mysql://prod-server:3306/mydb</db.url>
        </properties>
    </profile>
</profiles>
```

**Using Profiles:**
```bash
mvn clean install -P development
mvn clean install -P production
mvn clean install -P !production  # Exclude profile
```

### 6. Common Maven Commands ⚡

**Build Commands:**
```bash
mvn clean                    # Clean previous build
mvn compile                  # Compile source code
mvn test                     # Run tests
mvn package                  # Create JAR file
mvn install                  # Install to local repository
mvn clean install           # Clean and install
```

**Utility Commands:**
```bash
mvn dependency:tree         # Show dependency tree
mvn help:effective-pom      # Show effective POM
mvn exec:java              # Run main class
mvn dependency:resolve     # Resolve dependencies
mvn dependency:copy-dependencies # Copy dependencies
```

---

## Java Fundamentals 🎯

### 1. String Handling 📝

**String vs StringBuilder vs StringBuffer:**
```java
// String - Immutable
String str1 = "Hello";
String str2 = str1 + " World"; // Creates new object

// StringBuilder - Mutable, not thread-safe
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World"); // Modifies same object

// StringBuffer - Mutable, thread-safe
StringBuffer sbf = new StringBuffer("Hello");
sbf.append(" World"); // Modifies same object
```

**String Comparison:**
```java
String s1 = "Hello";
String s2 = new String("Hello");

// Reference comparison
s1 == s2; // false (different objects)

// Content comparison
s1.equals(s2); // true (same content)
```

### 2. Generics 🎲

**Generic Classes:**
```java
public class Box<T> {
    private T content;
    
    public void set(T content) {
        this.content = content;
    }
    
    public T get() {
        return content;
    }
}

Box<String> stringBox = new Box<>();
Box<Integer> intBox = new Box<>();
```

**Generic Methods:**
```java
public static <T> void printArray(T[] array) {
    for (T element : array) {
        System.out.println(element);
    }
}

public static <T extends Comparable<T>> T max(T a, T b) {
    return a.compareTo(b) > 0 ? a : b;
}
```

### 3. Annotations 🏷️

**Built-in Annotations:**
```java
@Override
public void method() {
    // Override parent method
}

@Deprecated
public void oldMethod() {
    // Method is deprecated
}

@SuppressWarnings("unchecked")
public void method() {
    // Suppress warnings
}

@FunctionalInterface
public interface MyInterface {
    void method();
}
```

### 4. Lambda Expressions (Java 8+) 🐑

**Basic Syntax:**
```java
// Single parameter
Consumer<String> printer = s -> System.out.println(s);

// Multiple parameters
BiFunction<Integer, Integer, Integer> adder = (a, b) -> a + b;

// No parameters
Supplier<String> supplier = () -> "Hello";

// Multiple statements
Consumer<String> processor = s -> {
    System.out.println("Processing: " + s);
    System.out.println("Length: " + s.length());
};
```

**Method References:**
```java
// Static method reference
Function<String, Integer> parser = Integer::parseInt;

// Instance method reference
Consumer<String> printer = System.out::println;

// Constructor reference
Supplier<ArrayList<String>> listSupplier = ArrayList::new;
```

### 5. Optional (Java 8+) 📦

**Handling Null Values:**
```java
Optional<String> optional = Optional.of("Hello");

// Safe operations
optional.ifPresent(System.out::println);
String result = optional.orElse("Default");
String result2 = optional.orElseGet(() -> "Generated");

// Chaining
Optional<String> result3 = optional
    .map(String::toUpperCase)
    .filter(s -> s.length() > 3);
```

### 6. Date/Time API (Java 8+) 📅

**LocalDate, LocalTime, LocalDateTime:**
```java
LocalDate date = LocalDate.now();
LocalTime time = LocalTime.now();
LocalDateTime dateTime = LocalDateTime.now();

// Creating specific dates
LocalDate specificDate = LocalDate.of(2023, 12, 25);
LocalTime specificTime = LocalTime.of(14, 30, 0);

// Manipulating dates
LocalDate tomorrow = date.plusDays(1);
LocalDate nextWeek = date.plusWeeks(1);
LocalDate nextMonth = date.plusMonths(1);
```

**Duration and Period:**
```java
Duration duration = Duration.between(startTime, endTime);
Period period = Period.between(startDate, endDate);

long hours = duration.toHours();
int days = period.getDays();
```

---

## Interview Tips 💡

### 1. Common Interview Questions

**OOP:**
- Explain the four pillars of OOP
- Difference between abstract class and interface
- What is polymorphism and its types?
- How does inheritance work in Java?

**Collections:**
- When to use ArrayList vs LinkedList?
- How does HashMap work internally?
- What is the difference between HashSet and TreeSet?
- Explain the Collections framework hierarchy

**Exception Handling:**
- Difference between checked and unchecked exceptions
- What happens if an exception is thrown in finally block?
- How to create custom exceptions?
- Explain exception propagation

**Multithreading:**
- Difference between Thread.start() and Thread.run()
- What is synchronization and why is it needed?
- Explain wait/notify mechanism
- What is a deadlock and how to prevent it?

**Maven:**
- What is POM and its structure?
- Explain Maven lifecycle
- What are dependency scopes?
- How to resolve dependency conflicts?

### 2. Coding Best Practices

**Code Organization:**
- Use meaningful variable and method names
- Follow Java naming conventions
- Write self-documenting code
- Use appropriate access modifiers

**Error Handling:**
- Always handle exceptions appropriately
- Use try-with-resources for resource management
- Don't ignore exceptions
- Provide meaningful error messages

**Performance:**
- Choose appropriate data structures
- Be aware of time complexity
- Use StringBuilder for string concatenation
- Avoid unnecessary object creation

**Thread Safety:**
- Use thread-safe collections when needed
- Understand synchronization costs
- Consider using atomic operations
- Be aware of race conditions

### 3. Problem-Solving Approach

1. **Understand the Problem** - Ask clarifying questions
2. **Plan the Solution** - Break down into smaller parts
3. **Choose Data Structures** - Consider time/space complexity
4. **Write Clean Code** - Follow best practices
5. **Test Your Solution** - Consider edge cases
6. **Optimize if Needed** - Look for improvements

---

## Resources 📚

### Official Documentation
- [Java SE Documentation](https://docs.oracle.com/en/java/)
- [Java Collections Framework](https://docs.oracle.com/javase/tutorial/collections/)
- [Java Concurrency](https://docs.oracle.com/javase/tutorial/essential/concurrency/)
- [Maven Documentation](https://maven.apache.org/guides/)

### Practice Platforms
- [LeetCode](https://leetcode.com/)
- [HackerRank](https://www.hackerrank.com/)
- [CodeSignal](https://codesignal.com/)
- [InterviewBit](https://www.interviewbit.com/)

### Books
- "Effective Java" by Joshua Bloch
- "Java Concurrency in Practice" by Brian Goetz
- "Clean Code" by Robert C. Martin
- "Head First Java" by Kathy Sierra

---

**Happy Learning! 🎉**

*This guide covers the essential Java and Maven concepts commonly asked in technical interviews. Practice implementing these concepts and solving problems to strengthen your understanding.* 