package HashTable;
import java.util.HashMap;
import java.util.Scanner;

public class StudentDirectory {
	private HashMap<String, Student> students;
    private Scanner scanner;

    public StudentDirectory() {
        students = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    // Class to represent a student
    private static class Student {
        String name;
        String major;

        public Student(String name, String major) {
            this.name = name;
            this.major = major;
        }
    }

    public void addStudent() {
        System.out.print("\nEnter student name: ");
        String name = scanner.next();

        System.out.print("Enter student ID: ");
        String id = scanner.next();

        System.out.print("Enter student major: ");
        String major = scanner.next();

        // Create a new student record
        Student student = new Student(name, major);

        // Add the student record to the hash table with ID as the key
        students.put(id, student);

        System.out.println("Student record added successfully.\n");
    }

    public void searchStudent() {
        System.out.print("\nEnter student ID to search: ");
        String id = scanner.next();

        // Search for the student record in the hash table
        if (students.containsKey(id)) {
            Student student = students.get(id);
            System.out.println("Student found:");
            System.out.println("Name: " + student.name);
            System.out.println("Major: " + student.major + "\n");
        } else {
            System.out.println("Student not found.");
        }
    }

    
    public void deleteStudent() {
        System.out.print("\nEnter student ID to delete: ");
        String id = scanner.next();

        // Remove the student record from the hash table
        if (students.containsKey(id)) {
            students.remove(id);
            System.out.println("Student deleted successfully.\n");
        } else {
            System.out.println("Student not found.\n");
        }
    }

    public void displayStudents() {
        System.out.println("\nStudent Records:");
        for (String id : students.keySet()) {
            Student student = students.get(id);
            System.out.println("ID: " + id + " | Name: " + student.name + " | Major: " + student.major);
        }
    }

	public static void main(String[] args) {
		StudentDirectory directory = new StudentDirectory();
        int choice;
        do {
        	System.out.println("=================================");
            System.out.println("| Choose an Option:             |");
            System.out.println("| 1. Add Student                |");
            System.out.println("| 2. Search Student             |");
            System.out.println("| 3. Delete Student             |");
            System.out.println("| 4. Display Students           |");
            System.out.println("| 5. Exit                       |");
            System.out.println("=================================");
            System.out.print("Your choice: ");

            choice = directory.scanner.nextInt();

            switch (choice) {
                case 1:
                    directory.addStudent();
                    break;
                case 2:
                    directory.searchStudent();
                    break;
                case 3:
                    directory.deleteStudent();
                    break;
                case 4:
                    directory.displayStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 5);

	}
}
