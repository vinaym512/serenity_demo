# Serenity Maven Project README

## Project Overview
This project uses Serenity BDD, a powerful library for writing clean, maintainable automated acceptance tests in Java. It leverages Maven for build automation and dependency management.

## Prerequisites
Before setting up the project, ensure you have the following software installed:

1. **Java Development Kit (JDK)**
2. **Apache Maven**

## Installation Instructions

### Step 1: Install Java Development Kit (JDK)

1. Download the JDK from the [Oracle JDK download page](https://www.oracle.com/java/technologies/javase-downloads.html) or install OpenJDK from your package manager.

2. Follow the installation instructions for your operating system.

3. Verify the installation by running the following command in your terminal or command prompt:
    ```sh
    java -version
    ```
   You should see output indicating the installed version of Java.
   This test code is developed using - Java version: 21.0.3

### Step 2: Install Apache Maven

1. Download Maven from the [Maven download page](https://maven.apache.org/download.cgi).

2. Follow the installation instructions for your operating system.

3. Verify the installation by running the following command in your terminal or command prompt:
    ```sh
    mvn -version
    ```
   You should see output indicating the installed version of Maven.
   This test code is developed using - apache-maven-3.9.8

## Project Setup

### Step 1: Clone the Repository

Clone the project repository from your version control system. For example, using Git:
```sh
git clone https://github.com/your-repository-url.git
cd your-repository-directory
```

### Step 2: Install Maven Dependencies

After setting up your `pom.xml`, you need to download and install the dependencies specified in the file. Run the following command in your terminal:

```sh
mvn clean install
```

This command will:
- Clean any previously compiled files.
- Compile the project.
- Download and install all dependencies specified in the `pom.xml` file.

### Step 3: Run Tests

Execute the tests using Maven:

```sh
mvn clean verify
```

This command will compile the code, run the tests, and generate Serenity reports.

### Step 4: View Reports

After running the tests, you can view the Serenity reports by opening the following file in a web browser:

```sh
target/site/serenity/index.html
```

## Troubleshooting

- Ensure your `JAVA_HOME` environment variable is set correctly and points to your JDK installation.
- Ensure your `M2_HOME` environment variable is set correctly and points to your Maven installation.
- If tests are not running, check the configurations in `pom.xml` and ensure all dependencies are correctly specified.

## Note

1. I have used the provided feature file.
2. I have automated only first scenario with minor update to mentioned steps.
3. Currently it is set to run on Chrome only.
4. Currently it is set to run in parallel.
5. Currently it generate report irrespective of tests pass or fail.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

---

By following the steps outlined above, you should be able to set up and run a Serenity BDD project with Maven successfully. For more detailed information, refer to the [Serenity BDD documentation](http://serenity-bdd.info/docs/articles/intro.html).