API Automation Framework (Java + TestNG + RestAssured + Allure)

A clean, modular, production-ready API Automation Framework built using:

Java 11

RestAssured 5.x

TestNG 7.9

Allure Reporting

YAML Configuration

Reusable API Client Layer

Schema Validation

Faker Data Generator

📁 Project Structure
```
api-automation-framework-java/
│
├── pom.xml
├── README.md
├── .gitignore
│
├── src
│   └── test
│       ├── java
│       │   ├── clients
│       │   │   └── UsersClient.java
│       │   ├── config
│       │   │   └── ConfigLoader.java
│       │   ├── core
│       │   │   └── HttpClient.java
│       │   ├── models
│       │   │   ├── CreateUserPayload.java
│       │   │   ├── UpdateUserPayload.java
│       │   │   └── StatusUpdatePayload.java
│       │   ├── tests
│       │   │   ├── UsersGetTests.java
│       │   │   ├── UsersPostTests.java
│       │   │   ├── UsersPutTests.java
│       │   │   ├── UsersPatchTests.java
│       │   │   └── UsersDeleteTests.java
│       │   └── utils
│       │       └── DataGenerator.java
│       │
│       └── resources
│           ├── config.yaml
│           ├── testng.xml
│           └── schemas
│               └── user_schema.json
│
└── target/
    ├── test-classes
    ├── surefire-reports
    └── allure-results (created automatically after test run)
```
🔧 Features
✔ Modular & Reusable HTTP Client

A wrapper around RestAssured that:

Handles GET, POST, PUT, PATCH, DELETE

Injects base URL + token

Attaches logs and Allure filters automatically

✔ TestNG + Allure Reporting

Automatically generates report in target/allure-results/

Run mvn allure:serve to view report

✔ YAML-Based Config

The config.yaml file contains:

baseUrl: "https://gorest.co.in/public/v2"
token: "your_api_token_here"

✔ JSON Schema Validation

Useful for response structure verification.

✔ Faker Data Generator

Random email/name generator avoids conflicts.

✔ Full CRUD Test Suite

All APIs covered:

GET users

POST create user

PUT update user

PATCH partial update

DELETE remove user

🛠 Setup & Installation
1️⃣ Clone repo
git clone <your-repo-url>
cd api-automation-framework-java

2️⃣ Install dependencies (Maven will auto-download)
mvn clean test

3️⃣ Update config.yaml

Put your real GoREST API token:

src/test/resources/config.yaml

🧪 Running Tests

Run the complete suite:

mvn clean test


Run a single test class:

mvn -Dtest=UsersGetTests test

📊 Generating Allure Report

After running tests:

1️⃣ View report:
mvn allure:serve


This opens the HTML dashboard automatically.

2️⃣ If using Allure CLI:
allure serve target/allure-results

📦 Maven Dependencies Used

Key libraries:

TestNG

RestAssured

Allure TestNG

Allure RestAssured

Jackson Databind / YAML

Java Faker

dotenv (optional)

And Maven Surefire plugin for running TestNG.


Below is a screenshot of the project structure/test report:

![Project Screenshot](assets/Screenshot%202025-12-08%20at%209.48.15%E2%80%AFPM.png)


