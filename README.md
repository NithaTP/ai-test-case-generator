<h1 align="center">🚀 AI Test Case Generator</h1>

<p align="center">
AI-powered test case generation using <b>Java + Maven + Ollama (Local LLM)</b>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Maven-Build-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Ollama-LLM-green?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Status-Active-success?style=for-the-badge" />
</p>

---

## ✨ About The Project

**AI Test Case Generator** is a Java-based automation tool that reads requirement files and generates structured test cases using a locally running Large Language Model via Ollama.

This project helps QA engineers move from **manual effort → AI-assisted productivity**.

---

## 🔥 What It Does

- 📄 Reads requirement input files  
- 🤖 Sends structured prompts to Ollama  
- 🧠 Generates intelligent test cases  
- ⚡ Automates repetitive QA documentation  
- 🔒 Runs fully locally (no cloud required)

---

## 🛠 Tech Stack

| Technology | Role |
|------------|------|
| **Java 21** | Core application logic |
| **Maven** | Build management |
| **Ollama (llama3)** | Local AI model |
| **REST API** | LLM communication |
| **Excel Processing** | Structured output |

---

## 📂 Project Structure

ai-test-case-generator
│
├── src/main/java/tcGenerator
│ ├── ai
│ │ ├── OllamaClient.java
│ │ └── OllamaTest.java
│ ├── generator
│
├── src/main/resources/requirement
│ ├── login.txt
│ └── NewRequirement.txt
│
├── pom.xml
└── README.md


---

## ⚙️ Installation Guide

### 1️⃣ Install Java

```bash
java -version
2️⃣ Install Maven
mvn -version
3️⃣ Install Ollama
Download from:

https://ollama.com

Run model:

ollama run llama3
▶️ How To Run
Start Ollama
ollama run llama3
Build Project
mvn clean install
Run Application
mvn exec:java -Dexec.mainClass="tcGenerator.ai.OllamaTest"
🧠 How It Works
Requirement File
⬇
Java Application
⬇
Ollama Local API
⬇
LLM Generates Test Cases
⬇
Structured Output

🎯 Key Features
✔ Fully local AI execution
✔ Clean modular Java structure
✔ Maven-based build system
✔ Easy to extend for UI or API integration

🚀 Future Enhancements
Web UI for requirement input

Direct Excel export module

REST API wrapper

CI/CD integration

Cloud deployment option

👩‍💻 Author
NithaTP
GitHub: https://github.com/NithaTP

<p align="center"> ⭐ If you like this project, consider giving it a star! </p> ```
