Mini Task Scheduler (Console Version) – Organize Your Day with Java

📌 Project Overview

The Mini Task Scheduler is a Java console-based application designed to help users organize their daily activities.
It allows users to add, view, delete, and mark tasks as completed in a simple and interactive way.
This project is ideal for beginners learning Java basics, OOP, and console applications.

🎯 Features

✅ Add a new task with:

Title (required)

Description (optional)

Deadline/Time (optional)

✅ View all tasks in a numbered list.
✅ Delete tasks by entering their number (with confirmation).
✅ Mark tasks as completed (✔).
✅ Save tasks to a file (tasks.txt).
✅ Menu-driven interface with looping until exit.

🛠️ Tools & Technologies

Language: Java SE 8 or higher

IDE: IntelliJ IDEA / Eclipse / BlueJ / VS Code / Replit

Core Java Concepts Used:

Scanner (input handling)

ArrayList (dynamic task storage)

Loops & Conditionals

Methods (modular programming)

String formatting & console UI

File I/O (save tasks to file)

(Optional) LocalDate for deadlines

📂 Project Structure
MiniTaskScheduler/
│── MiniTaskScheduler.java   # Main application file
│── tasks.txt                # Saved tasks (created automatically)
│── README.md                # Documentation

🚀 How to Run

Clone or Download the project files.

Open the project in your Java IDE (IntelliJ, Eclipse, VS Code, etc.).

Compile and run the program:

javac MiniTaskScheduler.java
java MiniTaskScheduler


Follow the on-screen menu options to manage tasks.

📝 Sample Usage
=====================================
   Welcome to Mini Task Scheduler!
=====================================

========= MENU =========
1. Add a new task
2. View all tasks
3. Delete a task
4. Mark task as completed
5. Save tasks to file
6. Exit
========================
Enter your choice: 1
Enter task title: Complete Java Project
Enter task description (optional): Work on Mini Task Scheduler
Enter task deadline (yyyy-mm-dd) or leave blank: 2025-10-10
✅ Task added successfully!

🔮 Future Enhancements (Optional)

Load tasks back from file at startup.

Sort tasks by deadline/time.

Add color-coded output using ANSI codes.

Implement search/filter for tasks.

Add recurring task reminders.
