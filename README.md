#Chatbot with NLP in Java
A simple chatbot that uses Natural Language Processing (NLP) to understand and respond to user queries.

##Features
Uses Stanford CoreNLP library for NLP tasks
Supports sentiment analysis and intent detection
Responds to user queries based on sentiment and intent
Handles greetings, thank you messages, and complaints
Getting Started
##Prerequisites
Java 8 or higher
Stanford CoreNLP library (version 4.2.2 or higher)
Apache Commons Lang library (version 3.12.0 or higher)
##Running the Chatbot
Clone the repository: git clone https://github.com/Shreyanshivns/chatbot.git
Compile the project: javac -cp ".;stanford-corenlp-4.2.2.jar;commons-lang3-3.12.0.jar" Chatbot.java Main.java
Run the chatbot: java -cp ".;stanford-corenlp-4.2.2.jar;commons-lang3-3.12.0.jar" Main
##Interacting with the Chatbot
Type a message to interact with the chatbot.
The chatbot will respond based on the sentiment and intent of your message.
Type "quit" to exit the chatbot.
##Code Structure
Chatbot.java: The main chatbot class that handles NLP tasks and responds to user queries.
Main.java: The main class that runs the chatbot and handles user input.
##Dependencies
Stanford CoreNLP library (version 4.2.2 or higher)
Apache Commons Lang library (version 3.12.0 or higher)
License
This project is licensed under the MIT License. See LICENSE for details.
