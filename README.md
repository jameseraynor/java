# Java Interview Preparation App 🚀

A comprehensive Java interview preparation application that covers core Java concepts and Maven topics commonly asked in technical interviews.

## 📚 Features

### 🏗️ Object-Oriented Programming (OOP)
- **Encapsulation**: Data hiding and access control
- **Inheritance**: Class hierarchy and code reuse
- **Polymorphism**: Method overloading and overriding
- **Abstraction**: Abstract classes and interfaces

### 📦 Collections Framework
- **Lists**: ArrayList, LinkedList with performance comparisons
- **Sets**: HashSet, TreeSet with set operations
- **Maps**: HashMap, TreeMap with iteration examples
- **Queues**: PriorityQueue with custom comparators
- **Streams**: Java 8+ Stream API examples
- **Utility Methods**: Collections class methods

### ⚠️ Exception Handling
- **Try-Catch Blocks**: Basic exception handling
- **Multiple Catch Blocks**: Handling different exception types
- **Finally Block**: Resource cleanup
- **Custom Exceptions**: Creating and using custom exceptions
- **Try-with-Resources**: Automatic resource management
- **Exception Propagation**: How exceptions flow through methods

### 🔄 Multithreading & Concurrency
- **Thread Creation**: Extending Thread vs implementing Runnable
- **Synchronization**: synchronized keyword and ReentrantLock
- **Thread Communication**: wait/notify mechanism
- **ExecutorService**: Thread pool management
- **Atomic Operations**: Thread-safe counters

### 🛠️ Maven Concepts
- **POM Structure**: Project Object Model explanation
- **Maven Lifecycle**: Build, clean, and site lifecycles
- **Dependencies Management**: Scopes, transitive dependencies
- **Plugins**: Build and reporting plugins
- **Best Practices**: Maven development guidelines
- **Profiles**: Environment-specific configurations

### 🧠 Interactive Quiz System
- **Multiple Choice Questions**: Test your knowledge
- **Randomized Questions**: Different questions each time
- **Performance Tracking**: Score and percentage calculation
- **Detailed Explanations**: Learn from mistakes
- **Question Review**: Review all questions and answers

## 🚀 Getting Started

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher

### Installation

1. **Clone or download the project**
   ```bash
   git clone <repository-url>
   cd java-interview-prep
   ```

2. **Build the project**
   ```bash
   mvn clean compile
   ```

3. **Run the application**
   ```bash
   mvn exec:java -Dexec.mainClass="com.interviewprep.Main"
   ```

   Or create an executable JAR:
   ```bash
   mvn clean package
   java -jar target/java-interview-prep-1.0.0-jar-with-dependencies.jar
   ```

## 🎯 How to Use

### Main Menu
The application provides an interactive menu-driven interface:

```
🚀 Welcome to Java Interview Preparation App!
=============================================

📚 Choose a topic to explore:
1. 🏗️  Object-Oriented Programming (OOP)
2. 📦 Collections Framework
3. ⚠️  Exception Handling
4. 🔄 Multithreading & Concurrency
5. 🛠️  Maven Concepts
6. 🧠 Take a Quiz
0. 🚪 Exit
```

### Exploring Concepts
1. Choose a topic (1-5) to explore specific Java concepts
2. Each topic has sub-menus with detailed examples
3. Run individual examples or all examples at once
4. Study the code and output to understand the concepts

### Taking the Quiz
1. Choose option 6 to start the quiz
2. Select the number of questions you want to answer
3. Answer multiple-choice questions
4. Review your score and performance
5. Optionally review all questions with explanations

## 📁 Project Structure

```
java-interview-prep/
├── src/
│   ├── main/java/com/interviewprep/
│   │   ├── Main.java                    # Main application entry point
│   │   ├── concepts/
│   │   │   ├── OOPConcepts.java         # OOP examples
│   │   │   ├── CollectionsExamples.java # Collections examples
│   │   │   ├── ExceptionHandlingExamples.java # Exception handling
│   │   │   └── MultithreadingExamples.java # Multithreading
│   │   ├── maven/
│   │   │   └── MavenConcepts.java       # Maven concepts
│   │   └── quiz/
│   │       └── QuizSystem.java          # Interactive quiz
│   └── test/java/                       # Unit tests (to be added)
├── pom.xml                              # Maven configuration
└── README.md                            # This file
```

## 🧪 Running Tests

```bash
mvn test
```

## 📦 Maven Commands

### Build Commands
```bash
mvn clean                    # Clean previous build
mvn compile                  # Compile source code
mvn test                     # Run tests
mvn package                  # Create JAR file
mvn install                  # Install to local repository
mvn clean install           # Clean and install
```

### Utility Commands
```bash
mvn dependency:tree         # Show dependency tree
mvn help:effective-pom      # Show effective POM
mvn exec:java              # Run main class
```

## 🎓 Learning Path

### For Beginners
1. Start with **OOP Concepts** to understand fundamental principles
2. Explore **Collections Framework** for data structures
3. Learn **Exception Handling** for robust code
4. Take the **Quiz** to test your knowledge

### For Intermediate Developers
1. Deep dive into **Multithreading** concepts
2. Study **Maven** for build automation
3. Practice with **Collections** advanced features
4. Challenge yourself with harder quiz questions

### For Advanced Developers
1. Focus on **Multithreading** synchronization patterns
2. Master **Maven** profiles and plugins
3. Understand **Collections** performance characteristics
4. Review all concepts and take comprehensive quizzes

## 🔧 Customization

### Adding New Questions
Edit `QuizSystem.java` and add new `QuizQuestion` objects to the `initializeQuestions()` method.

### Adding New Examples
Create new classes in the appropriate package and add them to the main menu in `Main.java`.

### Modifying Maven Configuration
Edit `pom.xml` to add new dependencies, plugins, or build configurations.

## 📚 Additional Resources

### Java Documentation
- [Java SE Documentation](https://docs.oracle.com/en/java/)
- [Java Collections Framework](https://docs.oracle.com/javase/tutorial/collections/)
- [Java Concurrency](https://docs.oracle.com/javase/tutorial/essential/concurrency/)

### Maven Documentation
- [Maven Getting Started](https://maven.apache.org/guides/getting-started/)
- [Maven POM Reference](https://maven.apache.org/pom.html)
- [Maven Lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)

### Interview Preparation
- [Java Interview Questions](https://www.geeksforgeeks.org/java-interview-questions/)
- [Maven Interview Questions](https://www.javatpoint.com/maven-interview-questions)

## 🤝 Contributing

Feel free to contribute to this project by:
- Adding new examples
- Improving existing code
- Adding more quiz questions
- Enhancing documentation
- Reporting bugs or suggesting features

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 🙏 Acknowledgments

- Java community for excellent documentation
- Maven team for the powerful build tool
- All contributors who help improve this project

---

**Happy Learning! 🎉**

*This application is designed to help you prepare for Java technical interviews by providing hands-on examples and interactive learning experiences.* 