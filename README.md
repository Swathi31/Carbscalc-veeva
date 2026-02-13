# Carbscalc-veeva
CarbsCalc Automation Framework

This project contains automated end-to-end test scenarios for the Carbohydrate Calculator website using:

Java

Selenium WebDriver

Cucumber (BDD – Gherkin Feature Files)

Maven

JUnit/TestNG

Project Overview

This framework automates user scenarios for:

https://www.calculator.net/carbohydrate-calculator.html

It validates different carbohydrate calculation flows using Cucumber feature files and Selenium WebDriver.

Framework Structure
Carbscalc-veeva
│
├── src/test/java
│   ├── stepDefinitions
│   ├── runners
│   ├── pages
│
├── src/test/resources
│   ├── features
│
├── pom.xml
└── README.md

Prerequisites

Make sure the following are installed:

Java JDK 8 or higher

Maven

Git

Chrome Browser

ChromeDriver (compatible with your Chrome version)

Check versions using:

java -version
mvn -version

Clone the Repository

Open terminal or command prompt:

git clone https://github.com/Swathi31/Carbscalc-veeva.git
cd Carbscalc-veeva

Install Dependencies

Run the following command to download Maven dependencies:

mvn clean install

How to Run the Tests
Option 1: Run via Maven
mvn test

Option 2: Run Specific Cucumber Runner

If using JUnit runner:

mvn test -Dcucumber.options="src/test/resources/features"


Or run the runner class directly from IDE:

Right click → Run TestRunner

Reports

After execution, reports will be available in:

/target


If using Cucumber HTML reports:

target/cucumber-reports.html


Open it in a browser to view detailed test results.

Test Scenarios Covered

Calculate carbohydrates for male profile

Calculate carbohydrates for female profile

Validate input fields and calculation results

Technologies Used

Selenium WebDriver

Cucumber BDD

Maven

Java

Page Object Model (POM) Design Pattern
