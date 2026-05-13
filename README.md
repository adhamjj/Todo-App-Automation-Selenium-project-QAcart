#  Todo Application - Selenium Automation Framework

## 📌 Project Overview
This project is a professional **End-to-End (E2E) Automation Framework** designed to test the **QApart Todo Application**. The framework is built with a focus on **clean code**, **reusability**, and **scalability** using the **Page Object Model (POM)** design pattern.

---

##  Tech Stack & Tools
* **Language:** Java (JDK 11+)
* **Automation Engine:** Selenium WebDriver
* **Testing Framework:** TestNG (Data-driven testing, Assertions)
* **Design Pattern:** Page Object Model (POM)
* **Build Tool:** Maven
* **Reporting:** Allure Reports (Detailed visual execution logs)
* **Logging & Evidence:** Integrated Screenshots on failure.

---

##  Framework Architecture
The project is structured to separate concerns and make maintenance easy:
* **`src/main/java`**: Contains **Page Objects** and **Base Classes**. Each page in the app has a corresponding Java class to store its locators and actions.
* **`src/test/java`**: Contains the **Test Classes**. These classes only call methods from the Page Objects, keeping the tests readable and focused on logic.
* **`pom.xml`**: Manages all dependencies (Selenium, TestNG, Allure).

---

##  Scenarios Covered
1. **User Authentication:** Login and Signup flows.
2. **Task Management:**
    - Creating new Todo items.
    - Marking tasks as completed.
    - Deleting tasks.
3. **Validation:** Verifying that the UI reflects the correct state after each action.

---

##  Reporting (Allure)
The framework generates high-quality visual reports.
To see the results of the latest test run:
1. Ensure you have Allure installed.
2. Run the command:
   ```bash
   allure serve allure-results
