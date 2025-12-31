
# Test Automation Framework - HMCTS Technical Challenge

## ✅ Features
- Java + Selenium + TestNG + Cucumber
- Page Object Model
- Data-driven tests using Scenario Outline
- WebDriverManager for browser setup
- Allure Reporting with screenshots on failure
- Supports Chrome & Firefox (headless ready)

## ✅ Setup Instructions
1. Install Java 11+ and Maven.
2. Clone the repository:
   ```bash
   git clone <repo-url>
3. Install dependencies:
   ```bash
   mvn clean install

## ✅ Run Tests
- Default (Chrome):
    ```bash
    mvn test
- Firefox:
    ```bash
    mvn test -Dbrowser=firefox

## ✅ How to Run in Headless Mode
- Chrome (headless):
     ```bash
    mvn test -Dbrowser=chrome -Dheadless=true
- Firefox (headless):
  ```bash
    mvn test -Dbrowser=firefox -Dheadless=true

## ✅ Generate Allure Report
- mvn allure:report
- mvn allure:serve

## ✅ Logging Details
- Logging Framework: Log4j2
- Log File Location: logs/test-execution.log
- Log Levels Used:
    - INFO → Test steps and flow
    - DEBUG → Detailed actions
    - ERROR → Failures and exceptions
- Configuration File: src/test/resources/log4j2.xml

##  ✅ Commands for Logs
- View logs:
  ```bash
    cat logs/test-execution.log
- Clear logs before new run:
  ```bash
    rm -rf logs/*
