package com.interviewprep.maven;

import java.util.Properties;

/**
 * Demonstrates Maven concepts and features commonly asked in interviews
 */
public class MavenConcepts {
    
    // ==================== POM STRUCTURE ====================
    
    /**
     * Explains the Project Object Model (POM) structure
     */
    public void explainPOMStructure() {
        System.out.println("\n📋 POM STRUCTURE EXPLANATION");
        System.out.println("============================");
        
        System.out.println("The POM (Project Object Model) is the fundamental unit of work in Maven.");
        System.out.println("It is an XML file that contains information about the project and");
        System.out.println("configuration details used by Maven to build the project.");
        
        System.out.println("\n📁 Key POM Elements:");
        System.out.println("├── project: Root element");
        System.out.println("├── modelVersion: POM version (4.0.0 for Maven 2 & 3)");
        System.out.println("├── groupId: Organization's unique identifier");
        System.out.println("├── artifactId: Project's unique name");
        System.out.println("├── version: Project version");
        System.out.println("├── packaging: Project type (jar, war, ear, pom)");
        System.out.println("├── name: Human-readable project name");
        System.out.println("├── description: Project description");
        System.out.println("├── properties: Build configuration properties");
        System.out.println("├── dependencies: Project dependencies");
        System.out.println("├── build: Build configuration");
        System.out.println("└── plugins: Maven plugins");
        
        System.out.println("\n🔧 Properties Section:");
        System.out.println("- maven.compiler.source: Java source version");
        System.out.println("- maven.compiler.target: Java target version");
        System.out.println("- project.build.sourceEncoding: Character encoding");
        System.out.println("- Custom properties for dependency versions");
        
        System.out.println("\n📦 Dependencies Section:");
        System.out.println("- groupId: Dependency organization");
        System.out.println("- artifactId: Dependency name");
        System.out.println("- version: Dependency version");
        System.out.println("- scope: When dependency is needed (compile, test, provided, runtime)");
        System.out.println("- optional: Whether dependency is optional");
        System.out.println("- exclusions: Dependencies to exclude");
    }
    
    // ==================== MAVEN LIFECYCLE ====================
    
    /**
     * Explains the Maven build lifecycle
     */
    public void explainMavenLifecycle() {
        System.out.println("\n🔄 MAVEN LIFECYCLE");
        System.out.println("==================");
        
        System.out.println("Maven has three standard lifecycles:");
        
        System.out.println("\n1️⃣  DEFAULT LIFECYCLE (Build):");
        System.out.println("├── validate: Validate project is correct");
        System.out.println("├── compile: Compile source code");
        System.out.println("├── test: Run tests");
        System.out.println("├── package: Package compiled code");
        System.out.println("├── verify: Run integration tests");
        System.out.println("├── install: Install package to local repository");
        System.out.println("└── deploy: Deploy package to remote repository");
        
        System.out.println("\n2️⃣  CLEAN LIFECYCLE:");
        System.out.println("└── clean: Remove target directory");
        
        System.out.println("\n3️⃣  SITE LIFECYCLE:");
        System.out.println("├── site: Generate project documentation");
        System.out.println("└── site-deploy: Deploy site to server");
        
        System.out.println("\n⚡ Common Maven Commands:");
        System.out.println("- mvn clean: Clean previous build");
        System.out.println("- mvn compile: Compile source code");
        System.out.println("- mvn test: Run tests");
        System.out.println("- mvn package: Create JAR/WAR file");
        System.out.println("- mvn install: Install to local repository");
        System.out.println("- mvn clean install: Clean and install");
        System.out.println("- mvn dependency:tree: Show dependency tree");
        System.out.println("- mvn help:effective-pom: Show effective POM");
        
        System.out.println("\n🎯 Lifecycle Execution:");
        System.out.println("When you run a phase, Maven executes all phases up to that point.");
        System.out.println("Example: 'mvn package' executes: validate → compile → test → package");
    }
    
    // ==================== DEPENDENCIES MANAGEMENT ====================
    
    /**
     * Explains Maven dependencies management
     */
    public void explainDependencies() {
        System.out.println("\n📚 DEPENDENCIES MANAGEMENT");
        System.out.println("=========================");
        
        System.out.println("Maven manages dependencies automatically by downloading them");
        System.out.println("from repositories and managing the classpath.");
        
        System.out.println("\n🏪 Repository Types:");
        System.out.println("├── Local Repository: ~/.m2/repository");
        System.out.println("├── Central Repository: Maven Central");
        System.out.println("└── Remote Repositories: Custom repositories");
        
        System.out.println("\n📦 Dependency Scopes:");
        System.out.println("├── compile (default): Available in all classpaths");
        System.out.println("├── provided: Provided by JDK or container");
        System.out.println("├── runtime: Required at runtime, not compile time");
        System.out.println("├── test: Only for testing");
        System.out.println("├── system: Similar to provided, but specify JAR explicitly");
        System.out.println("└── import: Only used in dependencyManagement");
        
        System.out.println("\n🔗 Dependency Management:");
        System.out.println("- Transitive Dependencies: Dependencies of dependencies");
        System.out.println("- Dependency Exclusion: Exclude unwanted transitive dependencies");
        System.out.println("- Optional Dependencies: Mark dependencies as optional");
        System.out.println("- Dependency Version Management: Centralize version management");
        
        System.out.println("\n📋 Dependency Resolution:");
        System.out.println("1. Maven reads POM dependencies");
        System.out.println("2. Downloads from repositories");
        System.out.println("3. Resolves transitive dependencies");
        System.out.println("4. Handles conflicts (nearest definition wins)");
        System.out.println("5. Builds classpath");
        
        System.out.println("\n🛠️  Dependency Management Example:");
        System.out.println("<dependencyManagement>");
        System.out.println("  <dependencies>");
        System.out.println("    <dependency>");
        System.out.println("      <groupId>org.springframework</groupId>");
        System.out.println("      <artifactId>spring-core</artifactId>");
        System.out.println("      <version>5.3.20</version>");
        System.out.println("    </dependency>");
        System.out.println("  </dependencies>");
        System.out.println("</dependencyManagement>");
    }
    
    // ==================== PLUGINS ====================
    
    /**
     * Explains Maven plugins
     */
    public void explainPlugins() {
        System.out.println("\n🔌 MAVEN PLUGINS");
        System.out.println("================");
        
        System.out.println("Plugins are the core of Maven functionality.");
        System.out.println("They are used to execute goals during the build lifecycle.");
        
        System.out.println("\n🏗️  Build Plugins:");
        System.out.println("├── maven-compiler-plugin: Compile Java source code");
        System.out.println("├── maven-surefire-plugin: Run unit tests");
        System.out.println("├── maven-jar-plugin: Create JAR files");
        System.out.println("├── maven-war-plugin: Create WAR files");
        System.out.println("├── maven-assembly-plugin: Create executable JARs");
        System.out.println("└── maven-shade-plugin: Create uber JARs");
        
        System.out.println("\n📊 Reporting Plugins:");
        System.out.println("├── maven-javadoc-plugin: Generate JavaDoc");
        System.out.println("├── maven-site-plugin: Generate project site");
        System.out.println("├── maven-surefire-report-plugin: Generate test reports");
        System.out.println("└── maven-dependency-plugin: Analyze dependencies");
        
        System.out.println("\n⚙️  Plugin Configuration:");
        System.out.println("<plugin>");
        System.out.println("  <groupId>org.apache.maven.plugins</groupId>");
        System.out.println("  <artifactId>maven-compiler-plugin</artifactId>");
        System.out.println("  <version>3.10.1</version>");
        System.out.println("  <configuration>");
        System.out.println("    <source>11</source>");
        System.out.println("    <target>11</target>");
        System.out.println("  </configuration>");
        System.out.println("</plugin>");
        
        System.out.println("\n🎯 Plugin Goals:");
        System.out.println("- Goals are the specific tasks a plugin performs");
        System.out.println("- Example: maven-compiler-plugin:compile");
        System.out.println("- Goals can be bound to lifecycle phases");
        System.out.println("- Goals can be executed independently");
        
        System.out.println("\n🔧 Common Plugin Goals:");
        System.out.println("- compiler:compile - Compile main source code");
        System.out.println("- compiler:testCompile - Compile test source code");
        System.out.println("- surefire:test - Run unit tests");
        System.out.println("- jar:jar - Create JAR file");
        System.out.println("- install:install - Install to local repository");
        System.out.println("- dependency:tree - Show dependency tree");
    }
    
    // ==================== MAVEN BEST PRACTICES ====================
    
    /**
     * Demonstrates Maven best practices
     */
    public void demonstrateBestPractices() {
        System.out.println("\n⭐ MAVEN BEST PRACTICES");
        System.out.println("=======================");
        
        System.out.println("1️⃣  Version Management:");
        System.out.println("- Use properties for dependency versions");
        System.out.println("- Use dependencyManagement for multi-module projects");
        System.out.println("- Keep versions in parent POM");
        
        System.out.println("\n2️⃣  Dependency Management:");
        System.out.println("- Exclude transitive dependencies when needed");
        System.out.println("- Use appropriate scopes");
        System.out.println("- Regularly update dependencies");
        
        System.out.println("\n3️⃣  Build Configuration:");
        System.out.println("- Use profiles for different environments");
        System.out.println("- Configure plugins properly");
        System.out.println("- Use assembly plugin for executable JARs");
        
        System.out.println("\n4️⃣  Project Structure:");
        System.out.println("- Follow Maven standard directory layout");
        System.out.println("- Use meaningful groupId and artifactId");
        System.out.println("- Keep POM files clean and organized");
        
        System.out.println("\n5️⃣  Testing:");
        System.out.println("- Write unit tests for all code");
        System.out.println("- Use integration tests for complex scenarios");
        System.out.println("- Configure test coverage reporting");
        
        System.out.println("\n6️⃣  Documentation:");
        System.out.println("- Add proper project description");
        System.out.println("- Document dependencies and their purposes");
        System.out.println("- Use README files for project setup");
    }
    
    // ==================== MAVEN PROFILES ====================
    
    /**
     * Explains Maven profiles
     */
    public void explainProfiles() {
        System.out.println("\n🎭 MAVEN PROFILES");
        System.out.println("=================");
        
        System.out.println("Profiles allow you to customize the build for different environments.");
        
        System.out.println("\n🏷️  Profile Types:");
        System.out.println("├── Per Project: Defined in POM");
        System.out.println("├── Per User: Defined in settings.xml");
        System.out.println("└── Global: Defined in global settings.xml");
        
        System.out.println("\n⚙️  Profile Activation:");
        System.out.println("- By default: -P profile-name");
        System.out.println("- By environment: Based on OS, JDK version, etc.");
        System.out.println("- By file: Presence/absence of files");
        System.out.println("- By property: System properties");
        
        System.out.println("\n📋 Profile Example:");
        System.out.println("<profiles>");
        System.out.println("  <profile>");
        System.out.println("    <id>development</id>");
        System.out.println("    <properties>");
        System.out.println("      <db.url>jdbc:h2:mem:testdb</db.url>");
        System.out.println("    </properties>");
        System.out.println("  </profile>");
        System.out.println("  <profile>");
        System.out.println("    <id>production</id>");
        System.out.println("    <properties>");
        System.out.println("      <db.url>jdbc:mysql://prod-server:3306/mydb</db.url>");
        System.out.println("    </properties>");
        System.out.println("  </profile>");
        System.out.println("</profiles>");
        
        System.out.println("\n🚀 Using Profiles:");
        System.out.println("- mvn clean install -P development");
        System.out.println("- mvn clean install -P production");
        System.out.println("- mvn clean install -P !production (exclude profile)");
    }
    
    public void runAllExamples() {
        explainPOMStructure();
        explainMavenLifecycle();
        explainDependencies();
        explainPlugins();
        demonstrateBestPractices();
        explainProfiles();
    }
} 