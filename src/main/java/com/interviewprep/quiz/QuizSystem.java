package com.interviewprep.quiz;

import java.util.*;

/**
 * Interactive quiz system to test Java and Maven knowledge
 */
public class QuizSystem {
    
    private final List<QuizQuestion> questions;
    private int score = 0;
    private int totalQuestions = 0;
    
    public QuizSystem() {
        this.questions = initializeQuestions();
    }
    
    /**
     * Starts the interactive quiz
     */
    public void startQuiz(Scanner scanner) {
        System.out.println("\n🧠 JAVA & MAVEN QUIZ");
        System.out.println("====================");
        System.out.println("Test your knowledge with these interview-style questions!");
        System.out.println("Each question has multiple choice answers. Choose the best option.");
        
        System.out.print("\nHow many questions would you like to answer? (1-" + questions.size() + "): ");
        int numQuestions = getValidNumber(scanner, 1, questions.size());
        
        // Randomly select questions
        List<QuizQuestion> selectedQuestions = getRandomQuestions(numQuestions);
        
        System.out.println("\n🎯 Starting Quiz with " + numQuestions + " questions...");
        System.out.println("=".repeat(50));
        
        for (int i = 0; i < selectedQuestions.size(); i++) {
            QuizQuestion question = selectedQuestions.get(i);
            totalQuestions++;
            
            System.out.println("\nQuestion " + (i + 1) + " of " + selectedQuestions.size());
            System.out.println("Category: " + question.getCategory());
            System.out.println("Difficulty: " + question.getDifficulty());
            System.out.println("-".repeat(40));
            System.out.println(question.getQuestion());
            
            // Display options
            for (int j = 0; j < question.getOptions().size(); j++) {
                System.out.println((j + 1) + ". " + question.getOptions().get(j));
            }
            
            // Get user answer
            System.out.print("\nYour answer (1-" + question.getOptions().size() + "): ");
            int userAnswer = getValidNumber(scanner, 1, question.getOptions().size());
            
            // Check answer
            if (userAnswer == question.getCorrectAnswer()) {
                System.out.println("✅ Correct! " + question.getExplanation());
                score++;
            } else {
                System.out.println("❌ Incorrect. The correct answer is: " + 
                    question.getOptions().get(question.getCorrectAnswer() - 1));
                System.out.println("💡 Explanation: " + question.getExplanation());
            }
            
            System.out.println("-".repeat(40));
        }
        
        // Show results
        showResults();
        
        // Ask if user wants to review
        System.out.print("\nWould you like to review all questions? (y/n): ");
        String review = scanner.nextLine().trim().toLowerCase();
        if (review.equals("y") || review.equals("yes")) {
            reviewAllQuestions();
        }
    }
    
    /**
     * Shows quiz results
     */
    private void showResults() {
        System.out.println("\n📊 QUIZ RESULTS");
        System.out.println("==============");
        System.out.println("Score: " + score + "/" + totalQuestions);
        
        double percentage = (double) score / totalQuestions * 100;
        System.out.printf("Percentage: %.1f%%\n", percentage);
        
        // Performance feedback
        if (percentage >= 90) {
            System.out.println("🏆 Excellent! You're well-prepared for Java interviews!");
        } else if (percentage >= 80) {
            System.out.println("🎯 Great job! You have solid Java knowledge.");
        } else if (percentage >= 70) {
            System.out.println("👍 Good work! Keep studying to improve further.");
        } else if (percentage >= 60) {
            System.out.println("📚 Not bad! Focus on the areas you missed.");
        } else {
            System.out.println("📖 Keep studying! Review the concepts you struggled with.");
        }
    }
    
    /**
     * Reviews all questions with correct answers
     */
    private void reviewAllQuestions() {
        System.out.println("\n📖 QUESTION REVIEW");
        System.out.println("=================");
        
        for (int i = 0; i < questions.size(); i++) {
            QuizQuestion question = questions.get(i);
            System.out.println("\n" + (i + 1) + ". " + question.getQuestion());
            System.out.println("Category: " + question.getCategory());
            System.out.println("Correct Answer: " + 
                question.getOptions().get(question.getCorrectAnswer() - 1));
            System.out.println("Explanation: " + question.getExplanation());
            System.out.println("-".repeat(50));
        }
    }
    
    /**
     * Gets a valid number from user input
     */
    private int getValidNumber(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int number = Integer.parseInt(scanner.nextLine().trim());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.printf("❌ Please enter a number between %d and %d: ", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.printf("❌ Please enter a valid number between %d and %d: ", min, max);
            }
        }
    }
    
    /**
     * Gets random questions for the quiz
     */
    private List<QuizQuestion> getRandomQuestions(int count) {
        List<QuizQuestion> shuffled = new ArrayList<>(questions);
        Collections.shuffle(shuffled);
        return shuffled.subList(0, Math.min(count, shuffled.size()));
    }
    
    /**
     * Initializes all quiz questions
     */
    private List<QuizQuestion> initializeQuestions() {
        List<QuizQuestion> questions = new ArrayList<>();
        
        // OOP Questions
        questions.add(new QuizQuestion(
            "OOP",
            "Easy",
            "Which of the following is NOT one of the four pillars of Object-Oriented Programming?",
            Arrays.asList("Encapsulation", "Inheritance", "Polymorphism", "Recursion"),
            4,
            "Recursion is a programming concept, not an OOP pillar. The four pillars are Encapsulation, Inheritance, Polymorphism, and Abstraction."
        ));
        
        questions.add(new QuizQuestion(
            "OOP",
            "Medium",
            "What is the difference between method overloading and method overriding?",
            Arrays.asList(
                "Overloading is compile-time polymorphism, overriding is runtime polymorphism",
                "Overriding is compile-time polymorphism, overloading is runtime polymorphism",
                "Both are compile-time polymorphism",
                "Both are runtime polymorphism"
            ),
            1,
            "Method overloading is resolved at compile time (static binding), while method overriding is resolved at runtime (dynamic binding)."
        ));
        
        questions.add(new QuizQuestion(
            "OOP",
            "Hard",
            "What is the output of the following code?\nString s1 = new String(\"Hello\");\nString s2 = new String(\"Hello\");\nSystem.out.println(s1 == s2);",
            Arrays.asList("true", "false", "Compilation error", "Runtime error"),
            2,
            "The == operator compares object references, not content. s1 and s2 are different objects in memory, so it returns false."
        ));
        
        // Collections Questions
        questions.add(new QuizQuestion(
            "Collections",
            "Easy",
            "Which collection maintains insertion order?",
            Arrays.asList("HashSet", "TreeSet", "ArrayList", "HashMap"),
            3,
            "ArrayList maintains insertion order, while HashSet and TreeSet do not. HashMap maintains insertion order only in recent Java versions."
        ));
        
        questions.add(new QuizQuestion(
            "Collections",
            "Medium",
            "What is the time complexity of adding an element to an ArrayList?",
            Arrays.asList("O(1)", "O(log n)", "O(n)", "Amortized O(1)"),
            4,
            "Adding to ArrayList is amortized O(1). While most operations are O(1), occasionally the array needs to be resized, which is O(n)."
        ));
        
        questions.add(new QuizQuestion(
            "Collections",
            "Hard",
            "Which of the following is thread-safe?",
            Arrays.asList("ArrayList", "HashMap", "Vector", "LinkedList"),
            3,
            "Vector is thread-safe (synchronized), while ArrayList, HashMap, and LinkedList are not thread-safe by default."
        ));
        
        // Exception Handling Questions
        questions.add(new QuizQuestion(
            "Exception Handling",
            "Easy",
            "What is the difference between checked and unchecked exceptions?",
            Arrays.asList(
                "Checked exceptions must be handled, unchecked exceptions are optional",
                "Unchecked exceptions must be handled, checked exceptions are optional",
                "Both must be handled",
                "Neither needs to be handled"
            ),
            1,
            "Checked exceptions (extending Exception) must be handled with try-catch or throws, while unchecked exceptions (extending RuntimeException) are optional."
        ));
        
        questions.add(new QuizQuestion(
            "Exception Handling",
            "Medium",
            "What happens if an exception is thrown in a finally block?",
            Arrays.asList(
                "The exception is ignored",
                "The exception is caught by the outer try-catch",
                "The program terminates",
                "The finally block is skipped"
            ),
            2,
            "If an exception is thrown in a finally block, it will be caught by the outer try-catch block or propagated up the call stack."
        ));
        
        // Multithreading Questions
        questions.add(new QuizQuestion(
            "Multithreading",
            "Easy",
            "What is the difference between Thread.start() and Thread.run()?",
            Arrays.asList(
                "start() creates a new thread, run() executes in the same thread",
                "run() creates a new thread, start() executes in the same thread",
                "Both create new threads",
                "Both execute in the same thread"
            ),
            1,
            "start() creates a new thread and calls run() in that thread, while run() executes the code in the current thread."
        ));
        
        questions.add(new QuizQuestion(
            "Multithreading",
            "Medium",
            "What is the purpose of the volatile keyword?",
            Arrays.asList(
                "Makes a variable thread-safe",
                "Ensures visibility of changes across threads",
                "Prevents deadlocks",
                "Improves performance"
            ),
            2,
            "volatile ensures that changes to the variable are immediately visible to all threads, but it doesn't make operations atomic."
        ));
        
        questions.add(new QuizQuestion(
            "Multithreading",
            "Hard",
            "What is a deadlock?",
            Arrays.asList(
                "When a thread is waiting for a resource that will never be available",
                "When two or more threads are waiting for each other to release resources",
                "When a thread consumes too much memory",
                "When a thread runs too long"
            ),
            2,
            "A deadlock occurs when two or more threads are waiting for each other to release resources, creating a circular dependency."
        ));
        
        // Maven Questions
        questions.add(new QuizQuestion(
            "Maven",
            "Easy",
            "What does POM stand for in Maven?",
            Arrays.asList(
                "Project Object Model",
                "Project Organization Method",
                "Package Object Model",
                "Process Object Model"
            ),
            1,
            "POM stands for Project Object Model, which is the fundamental unit of work in Maven."
        ));
        
        questions.add(new QuizQuestion(
            "Maven",
            "Medium",
            "What is the default scope for Maven dependencies?",
            Arrays.asList("test", "provided", "compile", "runtime"),
            3,
            "The default scope is 'compile', which means the dependency is available in all classpaths."
        ));
        
        questions.add(new QuizQuestion(
            "Maven",
            "Hard",
            "What is the difference between mvn clean install and mvn install?",
            Arrays.asList(
                "clean install is faster",
                "install is faster",
                "clean install removes target directory first",
                "There is no difference"
            ),
            3,
            "mvn clean install first removes the target directory (clean phase) before building and installing."
        ));
        
        questions.add(new QuizQuestion(
            "Maven",
            "Medium",
            "What is the purpose of dependencyManagement in Maven?",
            Arrays.asList(
                "To manage all dependencies automatically",
                "To centralize dependency version management",
                "To exclude unwanted dependencies",
                "To speed up dependency resolution"
            ),
            2,
            "dependencyManagement is used to centralize dependency version management, especially useful in multi-module projects."
        ));
        
        questions.add(new QuizQuestion(
            "Java Fundamentals",
            "Easy",
            "What is the difference between == and .equals() for String comparison?",
            Arrays.asList(
                "== compares content, .equals() compares references",
                "== compares references, .equals() compares content",
                "Both compare content",
                "Both compare references"
            ),
            2,
            "== compares object references (memory addresses), while .equals() compares the actual content of the strings."
        ));
        
        questions.add(new QuizQuestion(
            "Java Fundamentals",
            "Medium",
            "What is the difference between String, StringBuilder, and StringBuffer?",
            Arrays.asList(
                "String is mutable, StringBuilder and StringBuffer are immutable",
                "String is immutable, StringBuilder is mutable and thread-safe, StringBuffer is mutable and not thread-safe",
                "String is immutable, StringBuilder is mutable and not thread-safe, StringBuffer is mutable and thread-safe",
                "All three are immutable"
            ),
            3,
            "String is immutable, StringBuilder is mutable but not thread-safe, and StringBuffer is mutable and thread-safe."
        ));
        
        return questions;
    }
    
    /**
     * Inner class representing a quiz question
     */
    private static class QuizQuestion {
        private final String category;
        private final String difficulty;
        private final String question;
        private final List<String> options;
        private final int correctAnswer;
        private final String explanation;
        
        public QuizQuestion(String category, String difficulty, String question, 
                          List<String> options, int correctAnswer, String explanation) {
            this.category = category;
            this.difficulty = difficulty;
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
            this.explanation = explanation;
        }
        
        public String getCategory() { return category; }
        public String getDifficulty() { return difficulty; }
        public String getQuestion() { return question; }
        public List<String> getOptions() { return options; }
        public int getCorrectAnswer() { return correctAnswer; }
        public String getExplanation() { return explanation; }
    }
} 