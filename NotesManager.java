import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class NotesManager {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Note> notes = new ArrayList<>();

    static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {

        loadNotes();

        boolean running = true;

        while (running) {

            System.out.println("\n===== NOTES MANAGER =====");
            System.out.println("1. Create Note");
            System.out.println("2. View Notes");
            System.out.println("3. Search Note");
            System.out.println("4. Delete Note");
            System.out.println("5. Clear Screen");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createNote();
                    break;

                case 2:
                    viewNotes();
                    break;

                case 3:
                    searchNote();
                    break;

                case 4:
                    deleteNote();
                    break;

                case 5:
                    clearScreen();
                    break;

                case 6:
                    running = false;
                    System.out.println("Notes Manager closed.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }

    static void createNote() {

        System.out.println("\n===== CREATE NOTE =====");

        System.out.print("Enter Note ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Content: ");
        String content = sc.nextLine();

        Note note = new Note(id, title, content);

        notes.add(note);

        saveNotes();

        System.out.println("Note created successfully.");
    }

    static void viewNotes() {

        System.out.println("\n===== ALL NOTES =====");

        if (notes.isEmpty()) {
            System.out.println("No notes found.");
            return;
        }

        for (Note note : notes) {
            note.displayNote();
        }
    }

    static void searchNote() {

        System.out.println("\n===== SEARCH NOTE =====");

        System.out.print("Enter Note ID: ");
        int id = sc.nextInt();

        for (Note note : notes) {

            if (note.getId() == id) {

                System.out.println("Note found.");
                note.displayNote();
                return;
            }
        }

        System.out.println("Note not found.");
    }

    static void deleteNote() {

        System.out.println("\n===== DELETE NOTE =====");

        System.out.print("Enter Note ID: ");
        int id = sc.nextInt();

        for (Note note : notes) {

            if (note.getId() == id) {

                notes.remove(note);

                saveNotes();

                System.out.println("Note deleted successfully.");
                return;
            }
        }

        System.out.println("Note not found.");
    }

    static void saveNotes() {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Note note : notes) {
                writer.write(note.toFileFormat());
                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println("Error saving notes.");
        }
    }

    static void loadNotes() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|", 3);

                int id = Integer.parseInt(data[0]);
                String title = data[1];
                String content = data[2];

                Note note = new Note(id, title, content);

                notes.add(note);
            }

        } catch (IOException e) {

            System.out.println("Error loading notes.");

        } catch (NumberFormatException e) {

            System.out.println("Invalid note data.");
        }
    }

    static void clearScreen() {

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
