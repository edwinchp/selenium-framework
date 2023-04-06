# selenium-framework

Welcome to my awesome Selenium/Cucumber framework! This framework is designed to make it easy to create and execute automated tests using Selenium and Cucumber. 🤖

### 📜 Overview

The framework uses the Page Object Model design pattern to keep your tests organized and easy to maintain. It also includes some useful utilities, such as a custom WebDriver manager and an ExtentReport to help you generate detailed test reports. 📊

### 🧪 Prerequisites

Before you can start using the framework, make sure you have the following software installed:

    Java JDK 8 or higher
    Maven
    Git

### 💻 Getting Started

To use this framework, follow these steps

   - Clone this repository using ```git clone https://github.com/edwinchp/selenium-framework.git```
   - Open the project in your favorite IDE
   - Modify the resources/properties/global-data.properties file with your desired settings
   - Create your feature files in the src/test/resources/features directory
  -  Implement your step definitions in the src/test/java/stepDefinitions directory using the Page Object Model design pattern
  -  Run your tests using Maven command ```mvn clean test```
  -  Check your test report in the target/extent-report/ directory