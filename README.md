AI Test Case Generator

An AI-powered test case generation tool built using Java, Maven, and Ollama (Local LLM).

This project reads software requirements from text files and automatically generates structured test cases using a locally running Large Language Model.

📌 Project Overview

Manual test case writing is time-consuming and repetitive.
This project automates that process using AI.

It:

📄 Reads requirement files

🤖 Sends them to Ollama (local LLM)

🧠 Generates intelligent test cases

📊 Exports results into structured format (Excel-ready)

Built for QA engineers who want to move from manual effort → AI-assisted productivity.

🛠 Tech Stack

Java 21

Maven

Ollama (Local LLM - llama3)

REST API Integration

Excel Output Handling

📂 Project Structure
ai-test-case-generator
│
├── src/main/java/tcGenerator
│   ├── ai
│   │   ├── OllamaClient.java
│   │   └── OllamaTest.java
│   ├── generator
│
├── src/main/resources
│   └── requirement
│       ├── login.txt
│       └── NewRequirement.txt
│
├── pom.xml
├── .gitignore
└── README.md

⚙️ Installation & Setup
1️⃣ Install Java

Check:

java -version


If not installed, download JDK 21.

2️⃣ Install Maven

Check:

mvn -version

3️⃣ Install Ollama

Download from:

https://ollama.com


After installation, run:

ollama run llama3


This downloads the model locally.

▶️ How to Run the Project
Step 1 — Start Ollama

Open a new terminal:

ollama run llama3


Keep it running.

Step 2 — Build the Project

Inside project folder:

mvn clean install


You should see:

BUILD SUCCESS

Step 3 — Run the Application
mvn exec:java -Dexec.mainClass="tcGenerator.ai.OllamaTest"


The application will:

Read requirement file

Send prompt to Ollama

Generate AI test cases

Output results

🧠 How It Works

Requirement file is loaded from resources

Prompt is structured for test case generation

Ollama API is called locally

AI response is parsed

Test cases are structured for output
💡 Why This Project Matters

This project demonstrates:

AI + QA integration

LLM API handling in Java

Real-world automation thinking

Transition from manual QA to AI-driven QA

👤 Author

NithaTP

GitHub: https://github.com/NithaTP

⭐ If You Like This Project

Star the repository and connect with me to collaborate on AI + Automation projects.
