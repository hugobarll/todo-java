# To-Do List CLI

A simple command-line task manager built in Java to practice core language and OOP concepts: collections, custom exceptions, and file I/O for data persistence.

## Features

- Add a task
- List all tasks
- Mark a task as done
- Delete a task by ID
- Save progress to a local `.txt` file
- Load progress automatically on startup
- Input validation with custom exceptions (no crashes on invalid input or missing tasks)

## Technologies

- Java (no external dependencies)
- Core packages: `java.util`, `java.io`

## Project Structure

```
src/
├── app/
│   └── Main.java                    # Console menu and user interaction
├── entities/
│   └── Task.java                    # Task model (id, description, done)
├── services/
│   └── TaskManager.java             # Business logic (add, list, complete, delete, save, load)
└── exceptions/
    ├── TaskNotFoundException.java   # Thrown when a task ID doesn't exist
    └── TaskFileException.java       # Thrown when reading/writing the file fails
```

## How It Works

- Tasks are kept in memory in a `List<Task>` while the program runs.
- Each task gets a unique, ever-increasing ID (IDs are never reused, even after deletion).
- On exit (or manually, via the menu), the current task list is saved to a text file, one task per line (`id;description;done`).
- On startup, the program loads any existing tasks from that file back into memory.

## How to Run

1. Clone the repository:
   ```
   git clone https://github.com/hugobarll/<repo-name>.git
   ```
2. Compile and run `Main.java` from your IDE, or via terminal:
   ```
   javac -d out $(find src -name "*.java")
   java -cp out app.Main
   ```
3. When prompted, enter a file path (e.g. `data/tasks.txt`) to save/load your tasks.

## Example

```
1 - Add task
2 - List tasks
3 - Change status
4 - Delete task
5 - Save progress
6 - Exit
Enter an option: 1
Enter the task: Study Spring Boot

1 - Add task
2 - List tasks
3 - Change status
4 - Delete task
5 - Save progress
6 - Exit
Enter an option: 2
All tasks:
Task{id=1, description='Study Spring Boot', done=false}
```

## What I Practiced

- Object-oriented design (entities, services, exceptions as separate layers)
- Custom unchecked exceptions for cleaner error handling
- File persistence with `BufferedReader`/`BufferedWriter`
- Defensive input handling with `try/catch`

## Next Step

This project is being migrated to a REST API using Spring Boot and a relational database, replacing the console menu and file storage with proper endpoints and persistence.

## Author

**Victor Hugo dos Santos Barcellos**
[GitHub](https://github.com/hugobarll)
