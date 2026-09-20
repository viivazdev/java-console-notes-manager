# java-console-notes-manager

A simple **console-based Notes Manager built with Java** for practicing file handling, OOP, collections, and CRUD operations.

The application allows users to create, view, search, and delete notes. Notes are stored in a local **`notes.txt` file**, so the data remains available after the program is closed.

## Features

* Create note
* View all notes
* Search note by ID
* Delete note
* Clear screen
* Exit application
* Save notes to `notes.txt`
* Load notes from `notes.txt` when the application starts

## Concepts Practiced

* Classes and Objects
* Encapsulation
* Constructors
* Getters
* `ArrayList`
* File Handling
* `FileReader`
* `FileWriter`
* `BufferedReader`
* `BufferedWriter`
* `try-catch`
* `IOException`
* `NumberFormatException`
* CRUD operations
* String processing
* Command-line input

## Project Structure

```text
NotesManager/
│
├── Note.java
├── NotesManager.java
└── notes.txt
```

### `Note.java`

Contains the `Note` class and note-related data:

```text
ID
Title
Content
```

It also contains methods for accessing and displaying note information.

### `NotesManager.java`

Contains the main application logic, menu, user input, CRUD operations, and file handling.

### `notes.txt`

This file is used to permanently store the notes.

The file is created automatically when the first note is saved.

Example:

```text
101|Java Basics|Learn Java variables and data types.
102|OOP|Practice classes, objects and constructors.
103|Collections|Learn ArrayList and CRUD operations.
```

The format is:

```text
ID|Title|Content
```

The `|` character is used to separate the note fields.

## How File Storage Works

When creating a note:

```text
User
 ↓
Create Note
 ↓
ArrayList
 ↓
notes.txt
```

When the application starts:

```text
notes.txt
 ↓
BufferedReader
 ↓
Read note data
 ↓
Create Note objects
 ↓
ArrayList
```

This means notes are not lost when the application is closed.

## How to Run

Compile the project:

```bash
javac Note.java NotesManager.java
```

Run the application:

```bash
java NotesManager
```

The `notes.txt` file will be created automatically when a note is saved.

## Example Menu

```text
===== NOTES MANAGER =====

1. Create Note
2. View Notes
3. Search Note
4. Delete Note
5. Clear Screen
6. Exit

Enter your choice:
```

## Example Note

```text
-------------------------
ID      : 101
Title   : Java Basics
Content : Learn Java variables and data types.
-------------------------
```

## Important Note About `notes.txt`

`notes.txt` is part of the project because it acts as the application's simple data storage.

Unlike the previous projects, where data existed only while the program was running, this project writes the data to a file.

If `notes.txt` is deleted, the saved notes will also be unavailable when the application starts again.

## Limitations

* Uses a text file instead of a database.
* Basic input validation.
* Notes are stored in a simple text format.
* No user authentication.
* No advanced search functionality.

## Purpose

This project was created as a **Java practice project** to understand how file handling can be combined with OOP and collections to build a simple application with persistent data.

## Technologies

* Java
* `ArrayList`
* Java File I/O
* Command Line / Terminal
